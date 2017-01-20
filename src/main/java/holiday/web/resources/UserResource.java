package holiday.web.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.lang3.StringUtils;

import holiday.web.entities.RelType;
import holiday.web.entities.User;
import holiday.web.services.UserService;


@Path("/users")
public class UserResource
{
	@Inject
	UserService userService;
	
	public UserResource()
	{
		//userService = new UserService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<User> getUsers(@Context UriInfo uriInfo)
	{
		List<User> users = userService.getAllUsers();
		for(User user : users)
		{
			getUriForSelf(uriInfo, user);
			getUriForCheckouts(uriInfo, user);
		}
		return users;
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{type}")
	public User getUser(@PathParam("type") String FieldType , @Context UriInfo uriInfo)
	{
		User user = null;
		
		if(StringUtils.isNumeric(FieldType))
			user =  userService.getUser(Integer.parseInt(FieldType));
		else 
			user =  userService.getUserByEmail(FieldType);
		
			
		getUriForSelf(uriInfo, user);
		getUriForCheckouts(uriInfo, user);
		return user;
	}

	private void getUriForCheckouts(UriInfo uriInfo, User user)
	{
		if(user == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(UserResource.class,"getCheckoutResource")
				.path(CheckoutResource.class)	
				.resolveTemplate("userId", user.getUserId()) // {userId}
				.build()
				.toString();
		user.addLinks(Uri, RelType.checkouts);
	
	}
	
	private void getUriForSelf(UriInfo uriInfo, User user)
	{
		if(user == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(Long.toString(user.getUserId()))
				.build()
				.toString();
		user.addLinks(Uri, RelType.self);
	
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user, @Context UriInfo uriInfo)
	{
		User addedUser =  userService.addUser(user);
		getUriForSelf(uriInfo, addedUser);
	    getUriForCheckouts(uriInfo, addedUser);
	    return addedUser;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User UpdateUser(User user, @Context UriInfo uriInfo)
	{
		User updatedUser =  userService.UpdateUser(user);
		getUriForSelf(uriInfo, updatedUser);
	    getUriForCheckouts(uriInfo, updatedUser);
	    return updatedUser;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{userId}")
	public User RemoveUser(@PathParam("userId") int Id, @Context UriInfo uriInfo)
	{
		
		User user =  userService.RemoveUser(Id);
		getUriForSelf(uriInfo, user);
	    getUriForCheckouts(uriInfo, user);
	    return user;
	}
	
	@Path("/{userId}/checkouts")
	public CheckoutResource getCheckoutResource()
	{
		return new CheckoutResource();				
	}
}
