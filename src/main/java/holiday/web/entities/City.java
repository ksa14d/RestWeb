package holiday.web.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name")})
public class City implements Navigable{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    
    @XmlTransient
    @JoinColumn(name = "country_id", referencedColumnName = "Id")
    @ManyToOne
    private Country country;
    
    @XmlTransient
    @JoinColumn(name = "state_id", referencedColumnName = "Id")
    @ManyToOne
    private State state;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();

    public City() {
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


    public City(Integer id) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Holiday.Entity.City[ id=" + id + " ]";
    }
    
}
