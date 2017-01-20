package holiday.web.resources;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import holiday.web.entities.Holiday;
import holiday.web.entities.HolidayBean;

import holiday.web.entities.RelType;
import holiday.web.services.HolidayService;


@Path("/holidays")
@RequestScoped
@ManagedBean
public class HolidayResource
{
	@Inject
	HolidayService holidayService;
	
	public HolidayResource()
	{
		holidayService = new HolidayService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{locationId}")
	public List<HolidayBean> getHolidayByCountry(@PathParam("locationId") int Id, @QueryParam("year") String year, @QueryParam("type") String locationType, @Context UriInfo uriInfo)
	{
		List<HolidayBean> holidays = null;
		
		if(locationType.equalsIgnoreCase("country"))
		{
			holidays = holidayService.getHolidayByCountry(Id, year);
		}
		else if(locationType.equalsIgnoreCase("state"))
		{
			holidays = holidayService.getHolidayByState(Id, year);
		}
		else if(locationType.equalsIgnoreCase("city"))
		{
			holidays = holidayService.getHolidayByCity(Id, year);
		}		 
		
		return holidays;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Holiday> getHolidays(@Context final UriInfo uriInfo)
	{
		List<Holiday> holidays = null;
        holidays = holidayService.getAllHolidays();
		holidays.stream().forEach(h -> getUriForImage(uriInfo,h));
		return holidays;
	}


	@GET
	@Produces("image/jpe")
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{holidayId}.jpe")
	public Response getImage(@PathParam("holidayId") int holidayId)
	{
		final byte[] imageData = holidayService.getDestinationImage(holidayId);

		return Response.ok().entity(new StreamingOutput(){

			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException
			{
				output.write(imageData);
				output.flush();
			}
		}).build();
	}

	private void getUriForImage(UriInfo uriInfo,Holiday holiday)
	{
		if(holiday == null)return;
		String Uri = uriInfo.getBaseUriBuilder()
				.path(HolidayResource.class)
				.path(HolidayResource.class,"getImage")
				.resolveTemplate("holidayId", holiday.getHolidayId())
				.build()
				.toString();
		holiday.addLinks(Uri, RelType.holidayImage);

	}


}
