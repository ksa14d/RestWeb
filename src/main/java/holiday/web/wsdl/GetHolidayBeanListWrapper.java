
package holiday.web.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHolidayBeanListWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHolidayBeanListWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="throughMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="throughday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="throughYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHolidayBeanListWrapper", propOrder = {
    "country",
    "state",
    "city",
    "year",
    "fromMonth",
    "fromDay",
    "fromYear",
    "throughMonth",
    "throughday",
    "throughYear"
})
public class GetHolidayBeanListWrapper {

    protected String country;
    protected String state;
    protected String city;
    protected String year;
    protected String fromMonth;
    protected String fromDay;
    protected String fromYear;
    protected String throughMonth;
    protected String throughday;
    protected String throughYear;

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYear(String value) {
        this.year = value;
    }

    /**
     * Gets the value of the fromMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
     * Sets the value of the fromMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromMonth(String value) {
        this.fromMonth = value;
    }

    /**
     * Gets the value of the fromDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromDay() {
        return fromDay;
    }

    /**
     * Sets the value of the fromDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDay(String value) {
        this.fromDay = value;
    }

    /**
     * Gets the value of the fromYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromYear() {
        return fromYear;
    }

    /**
     * Sets the value of the fromYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromYear(String value) {
        this.fromYear = value;
    }

    /**
     * Gets the value of the throughMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThroughMonth() {
        return throughMonth;
    }

    /**
     * Sets the value of the throughMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThroughMonth(String value) {
        this.throughMonth = value;
    }

    /**
     * Gets the value of the throughday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThroughday() {
        return throughday;
    }

    /**
     * Sets the value of the throughday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThroughday(String value) {
        this.throughday = value;
    }

    /**
     * Gets the value of the throughYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThroughYear() {
        return throughYear;
    }

    /**
     * Sets the value of the throughYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThroughYear(String value) {
        this.throughYear = value;
    }

}
