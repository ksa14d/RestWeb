package holiday.web.services;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import holiday.web.entities.Checkout;
import holiday.web.entities.CheckoutCart;
import holiday.web.entities.User;
import holiday.web.utilities.*;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class CheckoutService
{
	@DBSession
	@Inject
	Session session;
	MappingUtility mapper ;
	public CheckoutService()
	{
		
		//session = HolidaySessionFactory.getHolidayDBSession();
		mapper = new MappingUtility();
	}
	
	public List<Checkout> getCheckoutsByUserId(int userId)
	{
		List<Checkout> checkouts = null;
		try
		{
			
			session.beginTransaction();
			User user  =  session.get(User.class, userId);
			System.out.println("id "+ user.getUserName());
			checkouts = user.getCheckout();
			checkouts.size();
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return checkouts;
	}
	

	
	public Checkout addCheckout(int userId , List<CheckoutCart> ItemsToAdd)
	{
		Checkout checkout = null;
		try
		{
			session.beginTransaction();
			User user = session.get(User.class, userId);
			checkout = new Checkout();
			checkout.setTotal(0);
			mapper.User_Join_Checkout(user,checkout);
			session.update(user);
			int  total = 0;
			for(CheckoutCart c : ItemsToAdd)
			{
		        total += c.getPrice();
			}
			checkout.setTotal(total);
			session.save(checkout);
			for(CheckoutCart c : ItemsToAdd)
			{
				mapper.Checkout_Join_Checkoutcart(checkout, c);
			}
			
			for(CheckoutCart c : ItemsToAdd)
			{
				session.save(c);
			}
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return checkout;
	}
	
	public Checkout removeCheckout(int checkoutId)
	{
		Checkout checkoutToDelete  = null;
		
		try
		{			
			session.beginTransaction();
			checkoutToDelete = session.get(Checkout.class, checkoutId);
			session.delete(checkoutToDelete);			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return checkoutToDelete;
	}	
}
