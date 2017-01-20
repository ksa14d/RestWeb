package holiday.web.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import holiday.web.entities.*;
import holiday.web.wsdl.HolidaysSOAP;
import holiday.web.wsdl.HolidaysSOAPService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

@ManagedBean
@RequestScoped
public class HolidayService
{
	@DBSession
	@Inject
	Session session;
	 
	private String country = null;
	private String state = null;
	private String city = null;
	private String year = null;
	private String fromDay = null;
	private String fromMonth = null;
	private String fromYear = null;
	private String throughDay = null;
	private String throughMonth = null;
	private String throughYear = null;
	private HolidaysSOAP holidaysSOAPServiceProxy;
	private ArrayList<HolidayBean> holidayBeanList = null;
	
	public HolidayService()
	{
		try
		{
			setFromMonth("0");
			setThroughMonth("0");
			//session = HolidaySessionFactory.getHolidayDBSession();
			HolidaysSOAPService holidaysService = new HolidaysSOAPService();
			holidaysSOAPServiceProxy = holidaysService.getHolidaysSOAPPort();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			String x =  e.getMessage();
			x=x;
		}
	}
	
	  public String getCountry()
		{
			return country;
		}

		public void setCountry(String country)
		{
			this.country = country;
		}

		public String getState()
		{
			return state;
		}

		public void setState(String state)
		{
			this.state = state;
		}

		public String getCity()
		{
			return city;
		}

		public void setCity(String city)
		{
			this.city = city;
		}

		public String getYear()
		{
			return year;
		}

		public void setYear(String year)
		{
			this.year = year;
		}




	public String getFromDay()
		{
			return fromDay;
		}

		public void setFromDay(String fromDay)
		{
			this.fromDay = fromDay;
		}

		public String getFromMonth()
		{
			return fromMonth;
		}

		public void setFromMonth(String fromMonth)
		{
			this.fromMonth = fromMonth;
		}

		public String getFromYear()
		{
			return fromYear;
		}

		public void setFromYear(String fromYear)
		{
			this.fromYear = fromYear;
		}

		public String getThroughDay()
		{
			return throughDay;
		}

		public void setThroughDay(String throughDay)
		{
			this.throughDay = throughDay;
		}

		public String getThroughMonth()
		{
			return throughMonth;
		}

		public void setThroughMonth(String throughMonth)
		{
			this.throughMonth = throughMonth;
		}

		public String getThroughYear()
		{
			return throughYear;
		}

		public void setThroughYear(String throughYear)
		{
			this.throughYear = throughYear;
		}

	public List<HolidayBean> getHolidayByCountry(int countryId , String par_year)
	{
		setYear(par_year);
		Country obj_country = null;
		try
		{

			session.beginTransaction();

			obj_country = session.get(Country.class, countryId);

			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		this.country = obj_country.getName();
		getHolidays();

		return holidayBeanList;
	}



	public List<HolidayBean> getHolidayByState(int stateId , String par_year )
	{
		setYear(par_year);
		State obj_state = null;
		try
		{

			session.beginTransaction();

			obj_state = session.get(State.class, stateId);

			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		this.state = obj_state.getName();
		this.country = obj_state.getCountryId().getName();
		getHolidays();
		return holidayBeanList;
	}



	public List<HolidayBean> getHolidayByCity(int cityId , String par_year)
	{
		setYear(par_year);
		City obj_city = null;
		try
		{

			session.beginTransaction();

			obj_city = session.get(City.class, cityId);

			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		this.city = obj_city.getName();
		State obj_state = obj_city.getState();
		if(obj_state != null)
		      this.state = obj_state.getName();
		this.country = obj_city.getCountry().getName();

		getHolidays();
		return holidayBeanList;
	}

	public List<Holiday> getAllHolidays()
	{
		List<Holiday> holidays = null;
		try
		{
			session.beginTransaction();
			holidays = (List<Holiday>) session.getNamedQuery("Holiday.findAll").list();
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return holidays;
	}

	private List<HolidayBean> getHolidays()
	{
		//bug fix
		 holidaysSOAPServiceProxy.getCountryListWrapper();
		 if (holidayBeanList == null) {
	            if (year == null)
	            {
	                setYear("");
	            }
	            if (state == null )
	            {
	                state = "*";
	            }
	            // city == /cr/lf (ascii [13, 10]) if a state is clicked and it has no cities
	            String tempCity = new String();
	            if (city != null) {
	                try {
	                    tempCity = Arrays.toString(city.getBytes("US-ASCII"));
	                } catch (Exception e) {
	                    System.out.println(e);
	                }
	            }
	            // city == /cr/lf (ascii [13, 10]) if a state is clicked and it has no cities
	            if ((city == null ) || tempCity.equals("[13, 10]")) {
	                city = "*";
	            }

	            String sr = "HolidaysSOAPClientBean country = " + country +"\n"+
	                       "HolidaysSOAPClientBean state = " + state +"\n"+
	                       "HolidaysSOAPClientBean city = " + city +"\n"+
	                       "HolidaysSOAPClientBean getYear() = " + getYear() +"\n"+
	            "HolidaysSOAPClientBean getFromMonth() = " + getFromMonth()+"\n"+
	            "HolidaysSOAPClientBean getFromDay() = " + getFromDay()+"\n"+
	            "HolidaysSOAPClientBean getFromYear() = " + getFromYear()+"\n"+
	            "HolidaysSOAPClientBean getThroughMonth() = " + getThroughMonth()+"\n"+
	            "HolidaysSOAPClientBean getThroughDay() = " + getThroughDay()+"\n"+
	            "HolidaysSOAPClientBean getThroughYear() = " + getThroughYear()+"\n" ;

	            String xmlResult = holidaysSOAPServiceProxy.getHolidayBeanListWrapper(country, state, city, getYear(),
	            		getFromMonth(), getFromDay(), getFromYear(),
	            		getThroughMonth(), getThroughDay(), getThroughYear());
	            HolidayBeanListWrapper holidayBeanListWrapper = new HolidayBeanListWrapper();
	            holidayBeanList = new ArrayList<HolidayBean>();
	            try {
	                JAXBContext jc = JAXBContext.newInstance(HolidayBeanListWrapper.class, HolidayBean.class);
	                Unmarshaller u = jc.createUnmarshaller();
	                holidayBeanListWrapper = (HolidayBeanListWrapper) u.unmarshal(new StringReader(xmlResult));
	            } catch (Exception e) {
	                System.out.println(e);
	            }
	            holidayBeanList = holidayBeanListWrapper.getHolidayBeanList();
	        }
	        return holidayBeanList;
	}

	public byte[] getDestinationImage(int HolidayId) {
		byte [] destinationImage = null ;
		try
		{

			session.beginTransaction();
			Holiday holiday = session.get(Holiday.class, HolidayId);

			destinationImage = (byte[]) holiday.getDestinationImage();

			session.getTransaction().commit();
		} catch (HibernateException e)
		{

			session.getTransaction().rollback();
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return destinationImage;
	}


}
