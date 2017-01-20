package holiday.web.utilities;

import holiday.web.entities.Checkout;
import holiday.web.entities.CheckoutCart;
import holiday.web.entities.User;

public class MappingUtility {

	public MappingUtility(){}
	
	public void User_Join_Checkout(User user , Checkout checkout)
	{
		user.getCheckout().add(checkout);
		checkout.setUser(user);
	}
	
	public void Checkout_Join_Checkoutcart(Checkout checkout , CheckoutCart checkoutcart)
	{
		checkout.getCheckoutCart().add(checkoutcart);
		checkoutcart.setCheckout(checkout);
	}
	
	
	
}
