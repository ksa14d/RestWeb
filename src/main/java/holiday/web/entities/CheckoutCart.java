package holiday.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import holiday.web.utilities.Link;

@XmlRootElement
@Entity
public class CheckoutCart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)        
    private Integer itemID;
    	
    private Integer optionValue;
       
    private String state;
    
    private String city;
    
      
    private String year;

	private String country;
  
    private Double price;
  
    @Transient
    private int checkoutId ;
    
    @Transient
    private List<Link> links = new ArrayList<Link>();
    
    @XmlTransient
    @ManyToOne
    @JoinColumn(name="checkout_id",foreignKey = @ForeignKey(name = "checkout_id"))	    
    private Checkout checkout;
    
    @Transient
   	public List<Link> getLinks()
   	{
   		return links;
   	}

   	public void setLinks(List<Link> links)
   	{
   		this.links = links;
   	}

	public int getCheckoutId()
	{
		checkoutId = checkout.getCheckoutId();
		return checkoutId;
	}


	public Integer getItemID() {
		return itemID;
	}


	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}


	public Integer getOptionValue() {
		return optionValue;
	}


	public void setOptionValue(Integer option) {
		this.optionValue = option;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
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



	@XmlTransient
	public Checkout getCheckout() {
		return checkout;
	}


	public void setCheckout(Checkout checkout) {
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
