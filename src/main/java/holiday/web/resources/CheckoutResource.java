package holiday.web.resources;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


import holiday.web.entities.Checkout;
import holiday.web.entities.CheckoutCart;
import holiday.web.entities.RelType;
import holiday.web.services.CheckoutService;

@Path("/")
@RequestScoped
@ManagedBean
public class CheckoutResource
{
	@Inject
	CheckoutService checkoutService ;
	
	
	public CheckoutResource()
	{
		//checkoutService = new CheckoutService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Checkout> getCheckouts(@PathParam("userId") int userId  , @Context UriInfo uriInfo)
	{
		List<Checkout> checkouts =  checkoutService.getCheckoutsByUserId(userId);   
		for(Checkout checkout : checkouts)
		{
			getUriForCheckouts(uriInfo,checkout,userId);
			getUriForCheckoutCarts(uriInfo,checkout,userId);
		}
		return checkouts;
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)		
	public Checkout addCheckout(@PathParam("userId") int userId  , List<CheckoutCart> ItemsToAdd ,@Context UriInfo uriInfo) 
	{
		Checkout checkout =  checkoutService.addCheckout(userId, ItemsToAdd);
		getUriForCheckouts(uriInfo,checkout,userId);
		getUriForCheckoutCarts(uriInfo,checkout,userId);
		return checkout;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{checkoutId}")
	public Checkout removeCheckout(@PathParam("userId") int userId  , @PathParam("checkoutId") int checkoutId , @Context UriInfo uriInfo)
	{
		Checkout checkout =  checkoutService.removeCheckout(checkoutId); // have to also remove the cart items first
		getUriForCheckouts(uriInfo,checkout,userId);
		//getUriForCheckoutCarts(uriInfo,checkout,userId); carts info have been deleted
		return checkout;
	}
	
	private void getUriForCheckoutCarts(UriInfo uriInfo, Checkout checkout, int userId) // Checkout checkout
	{
		if(checkout == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(UserResource.class,"getCheckoutResource")
				.path(CheckoutResource.class,"getCheckoutCartResource")	
				.resolveTemplate("checkoutId", checkout.getCheckoutId())				
				.resolveTemplate("userId", userId) 
				.build()
				.toString();
				
		checkout.addLinks(Uri, RelType.checkoutcarts);
	
	}
	
	private void getUriForCheckouts(UriInfo uriInfo, Checkout checkout, int userId) 
	{
		if(checkout == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(UserResource.class)
				.path(UserResource.class,"getCheckoutResource")
				.path(CheckoutResource.class)	
				.resolveTemplate("userId", userId) 
				.build()
				.toString();
		checkout.addLinks(Uri, RelType.checkouts);
	
	}
	
//	private void getUriForSelf(UriInfo uriInfo, User user)
//	{
//		if(user == null)return;
//		String Uri = uriInfo.getBaseUriBuilder()
//				.path(UserResource.class)
//				.path(UserResource.class,"getCheckoutResource")
//				.path(CheckoutResource.class)	
//				.resolveTemplate("userId", user.getUserId()) // {userId}
//				.build()
//				.toString();
//		user.addLinks(Uri, RelType.checkouts);
//	
//	}
	
	@Path("/{checkoutId}/checkoutcarts")
	public CheckoutCartResource getCheckoutCartResource()
	{
		return new CheckoutCartResource();				
	}
}
