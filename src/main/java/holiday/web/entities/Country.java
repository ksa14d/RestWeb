package holiday.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import holiday.web.utilities.Link;

/**
 *
 * @author karthik
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id"),
    @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name")})
public class Country implements Navigable {

   @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
   
    private String name;
    
    @XmlTransient
    @OneToMany(mappedBy = "country")
    private List<City> cities;
    
    @XmlTransient
    @OneToMany(mappedBy = "country")
    private List<State> states;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();

    public Country() {
    }
    
    @Transient
	public List<Link> getLinks()
	{
		return links;
	}

	public void setLinks(List<Link> links)
	{
		this.links = links;
	}


    public Country(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @XmlTransient
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
    
    public void addLinks(String url , String rel)
   	{
   		Link link = new Link();
   		link.setLink(url);
   		link.setRel(rel);
   		links.add(link);
   	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Holiday.Entity.Country[ id=" + id + " ]";
    }
    
}
