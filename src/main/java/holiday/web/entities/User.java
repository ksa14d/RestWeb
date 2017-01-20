package holiday.web.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import holiday.web.utilities.Link;

@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	public User(){}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	  
    private String userName;
 
    private String email;
    
    private String contactNo;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();

    @XmlTransient
    @OneToMany(mappedBy="user")
    private List<Checkout> checkout = new ArrayList<Checkout>();
    
	
    @Transient
	public List<Link> getLinks()
	{
		return links;
	}

	public void setLinks(List<Link> links)
	{
		this.links = links;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}	
	
	@XmlTransient
	public List<Checkout> getCheckout() {
		return checkout;
	}

	public void setCheckout(List<Checkout> checkout) {
		this.checkout = checkout;
	}
	
	public void addLinks(String url , String rel)
	{
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
