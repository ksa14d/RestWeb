package holiday.web.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import holiday.web.utilities.Link;


@XmlRootElement
@Entity
public class Checkout {
	
	

	    public Checkout()
	    {
	     	super();
	        setDateTime(LocalDateTime.now().toString());
     	}

		@Id @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer checkoutId;
	  
	    private Integer total;
	    
	    private String DateTime;
	    
	    @XmlTransient
	    @ManyToOne
	    @JoinColumn(name="user_id",foreignKey = @ForeignKey(name = "user_id"))	    
	    private User user;
	    
	    @Transient
	    private int userId ;
	    
	    @XmlTransient
	    @OneToMany(mappedBy="checkout", cascade=CascadeType.ALL)
	    private List<CheckoutCart> checkoutCart = new ArrayList<CheckoutCart>();
	    
	    @Transient
	    private List<Link> links = new ArrayList<Link>();

	    @Transient
		public List<Link> getLinks()
		{
			return links;
		}

		public void setLinks(List<Link> links)
		{
			this.links = links;
		}
	 
	    public String getDateTime()
		{
			return DateTime;
		}

		public void setDateTime(String dateTime)
		{
			DateTime = dateTime;
		}

		public int getUserId()
		{
	    	userId =  user.getUserId();
	    	return userId;
		}

		
		public Integer getCheckoutId() {
			return checkoutId;
		}

		public void setCheckoutId(Integer checkoutId) {
			this.checkoutId = checkoutId;
		}

		public Integer getTotal() {
			return total;
		}

		public void setTotal(Integer total) {
			this.total = total;
		}

		 @XmlTransient
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@XmlTransient
		public List<CheckoutCart> getCheckoutCart() {
			return checkoutCart;
		}

		public void setCheckoutCart(List<CheckoutCart> checkoutCart) {
			this.checkoutCart = checkoutCart;
		}

		public void addLinks(String url , String rel)
		{
			Link link = new Link();
			link.setLink(url);
			link.setRel(rel);
			links.add(link);
		}
	   
	
}
