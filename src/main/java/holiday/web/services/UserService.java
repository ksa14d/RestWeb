package holiday.web.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import holiday.web.entities.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class UserService
{
	@DBSession
	@Inject
	Session session;
	
	public UserService()
	{
		//session = HolidaySessionFactory.getHolidayDBSession();
	}
	
	public List<User> getAllUsers()
	{
		List<User> users = null;
		try
		{
			
			session.beginTransaction();
			
			users = (List<User>) session.createQuery("from User").list();
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return users;
	}
	
	public User getUser(int userId)
	{
		User users = null;
		try
		{
			
			session.beginTransaction();
			
			users = session.get(User.class, userId);
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return users;
	}
	
	public  User getUserByEmail(String emailID)
	{
		List<User> users = null;
		User user = null;;
		try
		{
			session.beginTransaction();
			Query query = session.createQuery("from User where email = :eid");
			query.setParameter("eid", emailID);
			users = (List<User>) query.list();
			if(users.size() > 0)
				user = users.get(0);
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return user;
	}
	
	public  User addUser(User user)
	{
	
		try
		{
			
			session.beginTransaction();				
			Query query = session.createQuery("from User where email = :eid");
			query.setParameter("eid", user.getEmail());
			List<User> users = (List<User>) query.list();
			if(users.size() > 0)
				user = users.get(0);
			else
			    session.save(user);			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		
		return user;
	}
	
	public  User UpdateUser(User user)
	{		
		
		User userToUpdate  = null;
		try
		{
			
			session.beginTransaction();
			
			userToUpdate = session.get(User.class,user.getUserId());
			userToUpdate.setContactNo(user.getContactNo());
			userToUpdate.setEmail(user.getEmail());	
			
			session.update(userToUpdate);
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return userToUpdate;
	}
	
	public  User RemoveUser(int id)
	{
		User userToDelete  = null;
		
		try
		{
			
			session.beginTransaction();
			userToDelete = session.get(User.class, id);
			session.delete(userToDelete);
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return userToDelete;
	}
}
