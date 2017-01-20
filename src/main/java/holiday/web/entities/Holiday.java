package holiday.web.entities;


import java.util.ArrayList;
import java.util.List;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Holiday.findAll", query = "SELECT h FROM Holiday h"),
    @NamedQuery(name = "Holiday.findByHolidayId", query = "SELECT h FROM Holiday h WHERE h.holidayId = :holidayId"),
    @NamedQuery(name = "Holiday.findByDestinationName", query = "SELECT h FROM Holiday h WHERE h.destinationName = :destinationName")})
public class Holiday {

    
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer holidayId;
   
    private String destinationName;
    
    
    @XmlTransient
    @Lob    
    private byte[] destinationImage;
    
    @JoinColumn(name = "city_id", referencedColumnName = "Id")
    @ManyToOne
    @XmlTransient
    private City city;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();

    public Holiday() {
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


    public Holiday(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    
    @XmlTransient
    public byte[] getDestinationImage() {
        return destinationImage;
    }

    public void setDestinationImage(byte[] destinationImage) {
        this.destinationImage = destinationImage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        hash += (holidayId != null ? holidayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holiday)) {
            return false;
        }
        Holiday other = (Holiday) object;
        if ((this.holidayId == null && other.holidayId != null) || (this.holidayId != null && !this.holidayId.equals(other.holidayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Holiday.Entity.Holiday[ holidayId=" + holidayId + " ]";
    }
    
}
