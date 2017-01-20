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
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findById", query = "SELECT s FROM State s WHERE s.id = :id"),
    @NamedQuery(name = "State.findByName", query = "SELECT s FROM State s WHERE s.name = :name")})
public class State implements Navigable {

   
   @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
     
    private String name;
    
    @XmlTransient
    @OneToMany(mappedBy = "state")
    private List<City> cities;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();
    
    @XmlTransient
    @JoinColumn(name = "country_id", referencedColumnName = "Id")    
    @ManyToOne
    private Country country;

    public State() {
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

    public State(Integer id) {
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
    public List<City> getCityCollection() {
        return cities;
    }

    public void setCityCollection(List<City> cities) {
        this.cities = cities;
    }

    public Country getCountryId() {
        return country;
    }

    public void setCountryId(Country country) {
        this.country = country;
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
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Holiday.Entity.State[ id=" + id + " ]";
    }
    
}
