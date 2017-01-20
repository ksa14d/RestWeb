package holiday.web.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Startup
@Singleton
public class HolidaySessionFactory
{
	private  SessionFactory sessionFactory = null;

	@PostConstruct
	void init()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Produces @DBSession public Session getHolidayDBSession() // static so that i can access it by class name
	{
		return sessionFactory.openSession();
	}
}
//public class HolidaySessionFactory
//{
//	private static  HolidaySessionFactory holidaySessionFactory = new HolidaySessionFactory();
//
//	private  SessionFactory sessionFactory = null;
//
//	private HolidaySessionFactory() // private so that only this class has the right to create a instance
//	{
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
//
//	public static Session getHolidayDBSession() // static so that i can access it by class name
//	{
//		return holidaySessionFactory.sessionFactory.openSession();
//	}
//}
