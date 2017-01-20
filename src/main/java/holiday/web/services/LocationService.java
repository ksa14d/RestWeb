package holiday.web.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import holiday.web.entities.City;
import holiday.web.entities.Country;
import holiday.web.entities.HolidayBean;
import holiday.web.entities.State;

import javax.annotation.ManagedBean;
import javax.ejb.Local;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@ManagedBean
@RequestScoped
public class LocationService
{
    @DBSession
	@Inject
	Session session;
	
	public LocationService()
	{
		//session = HolidaySessionFactory.getHolidayDBSession();
	}
	
	
	
	public List<Country> getAllCountries()
	{
		List<Country> countries = null;
		try
		{
			
			session.beginTransaction();
			Query query = session.createQuery("from Country");			
			countries = (List<Country>)  query.list();			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return countries;
	}
	
	
	
	public List<State> getAllStates(int countryId)
	{
		List<State> states = null;
		try
		{
			
			session.beginTransaction();
			Query query = session.createQuery("from State where country_id = :id");
			query.setParameter("id", countryId);
			states = (List<State>) query.list();
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return states;
	}
	
	public List<City> getAllCities(int stateId)
	{
		List<City> cities = null;
		try
		{
			
			session.beginTransaction();
			
			Query query = session.createQuery("from City where state_id = :id");
			query.setParameter("id", stateId);
			cities = (List<City>) query.list();
			
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return cities;
	}



	public List<HolidayBean> getHolidayByCountry(int id)
	{
		// TODO Auto-generated method stub
	/*	String countries;
			 HolidaysSOAPProxy proxy = new HolidaysSOAPProxy();
			 try
			{
				countries = proxy.getCountryListWrapper();
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			 
		
		return null;
	}



	public List<HolidayBean> getHolidayByState(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}



	public List<HolidayBean> getHolidayByCity(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
