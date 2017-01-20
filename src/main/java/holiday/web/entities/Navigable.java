package holiday.web.entities;

import java.util.List;

import holiday.web.utilities.Link;

public interface Navigable
{
	
	public List<Link> getLinks();
	
	public void setLinks(List<Link> links);
	
	public void addLinks(String url, String rel);
	
}
