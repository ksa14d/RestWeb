package holiday.web.resources;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


import holiday.web.entities.CheckoutCart;
import holiday.web.entities.RelType;

import holiday.web.services.CheckoutCartService;


@Path("/")
@RequestScoped
@ManagedBean
public class CheckoutCartResource
{
	@Inject
    CheckoutCartService checkoutCartService ;
    
	
	public CheckoutCartResource()
	{
		//checkoutCartService = new CheckoutCartService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)	
	public List<CheckoutCart> getCheckoutCart(@PathParam("userId") int userId ,@PathParam("checkoutId") int checkoutId ,@Context UriInfo uriInfo)
	{
		List<CheckoutCart> checkoutcart =  checkoutCartService.getCheckoutCart(checkoutId);
		for(CheckoutCart item : checkoutcart)
		{			
			getUriForSelf(uriInfo,userId,checkoutId,item);
			getUriForCheckoutCart(uriInfo,userId,checkoutId,item);
		}
		return checkoutcart;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{checkoutcartId}")
	public CheckoutCart removeCheckoutCart(@PathParam("userId") int userId ,@PathParam("checkoutId") int checkoutId ,@PathParam("checkoutcartId") int checkoutCartId  , @Context UriInfo uriInfo)
	{
		CheckoutCart checkoutcart =  checkoutCartService.removeCheckoutCart(checkoutCartId); // have to also remove the cart items first
		getUriForSelf(uriInfo,userId,checkoutId,checkoutcart);
		getUriForCheckoutCart(uriInfo,userId,checkoutId,checkoutcart);		
		return checkoutcart;
	}
	
	private void getUriForCheckoutCart(UriInfo uriInfo, int userId , int checkoutId ,CheckoutCart item) 
	{
		if(item == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(UserResource.class,"getCheckoutResource")
				.path(CheckoutResource.class)	
				.resolveTemplate("userId", userId) 
				.build()
				.toString();
		item.addLinks(Uri, RelType.self);
	
	}
	
	private void getUriForSelf(UriInfo uriInfo, int userId, int checkoutId , CheckoutCart item)
	{
		if(item == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(UserResource.class,"getCheckoutResource")
				.path(CheckoutResource.class,"getCheckoutCartResource")	
				.path(Long.toString(item.getItemID()))
				.resolveTemplate("checkoutId", checkoutId)				
				.resolveTemplate("userId", userId) 
				.build()
				.toString();
				
		item.addLinks(Uri, RelType.checkoutcarts);
	
	}
}
