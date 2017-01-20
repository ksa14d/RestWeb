package holiday.web.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import holiday.web.entities.Checkout;
import holiday.web.entities.CheckoutCart;

import holiday.web.utilities.MappingUtility;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class CheckoutCartService
{

	@DBSession
	@Inject
	Session session;

	MappingUtility mapper ;
	
	public CheckoutCartService()
	{

		//session = sessionFactory.openSession();
		mapper = new MappingUtility();
		
	}
	
	
	public  List<CheckoutCart> getCheckoutCart(int checkoutId)
	{
		List<CheckoutCart> checkoutCart = null;
		try
		{
			session.beginTransaction();
			Checkout checkout = session.get(Checkout.class, checkoutId);
			checkoutCart = checkout.getCheckoutCart();
			checkoutCart.size();
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return checkoutCart;
	}
	
	// get a specific cart item is not required
	
	//creating a group of it
	
	public  CheckoutCart addItemToExistingCart(int checkoutId , CheckoutCart cartItem)
	{		
		Checkout checkout = null;
		try
		{
			session.beginTransaction();
		
			checkout = session.get(Checkout.class, checkoutId);
			mapper.Checkout_Join_Checkoutcart(checkout, cartItem);
			session.update(checkout);
			session.save(cartItem);			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return cartItem;
	}
	
	public  CheckoutCart removeCheckoutCart(int checkoutCartId)
	{
		CheckoutCart checkoutCartToDelete = null;
		try
		{
			session.beginTransaction();
			checkoutCartToDelete = session.get(CheckoutCart.class, checkoutCartId);
			session.delete(checkoutCartToDelete);
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return checkoutCartToDelete;
	}
}
