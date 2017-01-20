package holiday.web.resources;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import holiday.web.entities.City;
import holiday.web.entities.Country;
import holiday.web.entities.Navigable;
import holiday.web.entities.RelType;
import holiday.web.entities.State;
import holiday.web.services.LocationService;



@Path("/countries")
@RequestScoped
@ManagedBean
public class LocationResource
{
	@Inject
	LocationService locationService;
	
	public LocationResource()
	{
		//locationService = new LocationService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)	
	public List<Country> getCountries(@Context UriInfo uriInfo)
	{
		List<Country> countries = locationService.getAllCountries();
		for(Country c : countries)
		{
			getUriForStates(uriInfo , c);	
			getUriForHolidays(uriInfo , c);
			
		}
		return countries;		
	}
	
	@GET  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{countryId}/states")
	public List<State> getStates(@PathParam("countryId") int Id, @Context UriInfo uriInfo)
	{
		List<State> states = locationService.getAllStates(Id);
		for(State s : states)
		{
			getUriForCities(uriInfo  , Id , s);	
			getUriForHolidays(uriInfo, s);
		}
		return states;		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{countryId}/states/{stateId}/cities")
	public List<City> getCities(@PathParam("countryId") int countryId ,@PathParam("stateId") int Id, @Context UriInfo uriInfo)
	{
		List<City> cities = locationService.getAllCities(Id);
		for(City c : cities)
		{
			getUriForHolidays(uriInfo , c);			
		}
		return cities;		
	}
	
	/*
	private void getUriForCountries(UriInfo uriInfo, User u)
	{
		if(u == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(LocationResource.class)
				.build()
				.toString();
		u.addLinks(Uri, RelType.countries);
	
	}
	*/
	private void getUriForStates(UriInfo uriInfo, Country country)
	{
		if(country == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(LocationResource.class)				
				.path(LocationResource.class,"getStates")				
				.resolveTemplate("countryId", country.getId())
				.build()
				.toString();
		country.addLinks(Uri, RelType.states);
	
	}
	
	private void getUriForCities(UriInfo uriInfo, int countryId , State state)
	{
		if(state == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(LocationResource.class)				
				.path(LocationResource.class,"getCities")				
				.resolveTemplate("countryId", countryId)
				.resolveTemplate("stateId", state.getId())
				.build()
				.toString();
		state.addLinks(Uri, RelType.cities);
	
	}
	
	/*private void getUriForHolidaysByCities(UriInfo uriInfo, int countryId ,int stateId , City c)
	{
		if(c == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(LocationResource.class)
				.path(LocationResource.class,"getHolidayByCities") 	
				.resolveTemplate("stateId", stateId)	
				.resolveTemplate("countryId", countryId)
				.resolveTemplate("cityId", c.getId())
				.build()
				.toString();
		c.addLinks(Uri, RelType.holidays);
	
	}*/
	
	/*private void getUriForHolidaysByState(UriInfo uriInfo, int countryId ,State s)
	{
		if(s == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(LocationResource.class)
				.path(LocationResource.class,"getHolidayByState") 	
				.resolveTemplate("stateId", s.getId())	
				.resolveTemplate("countryId", countryId)			
				.build()
				.toString();
		s.addLinks(Uri, RelType.holidays);
	
	}*/
	
	private void getUriForHolidays(UriInfo uriInfo ,Navigable location)
	{		
		if(location == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(HolidayResource.class)
				.build()
				.toString();
		location.addLinks(Uri, RelType.holidays);
	
	}
}
