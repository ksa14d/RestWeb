package holiday.web.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author karthik
 */


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HolidayBean {

    
	 private String startDate = null;
	    private int startYear = 0;
	    private int startMonth = 0;
	    private int startDay = 0;
	    private String endDate = null;
	    private String name = null;
	    private String region = null;
	    private String country = null;
	    private String state = null;
	    private String city = null;
	    private String holidayNote = null;
	    private String businessesClosed = null;
	    private String banksClosed = null;
	    private String religiousHoliday = null;
	    private String religion = null;
	    @XmlTransient
	    private String dis = null;

	    public HolidayBean() {
	        this(null, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null);
	    }

	    public HolidayBean(String startDate, int startYear, int startMonth, int startDay,
	            String endDate, String name, String country, String state, String city,
	            String holidayNote, String businessesClosed, String banksClosed,
	            String religiousHoliday, String religion, String dis) {
	        this.startDate = startDate;
	        this.startYear = startYear;
	        this.startMonth = startMonth;
	        this.startDay = startDay;
	        this.endDate = endDate;
	        this.name = name;
	        this.country = country;
	        this.state = state;
	        this.city = city;
	        this.holidayNote = holidayNote;
	        this.businessesClosed = businessesClosed;
	        this.banksClosed = banksClosed;
	        this.religiousHoliday = religiousHoliday;
	        this.religion = religion;
	        this.dis = dis;
	    }

	    /**
	     * @return the startDate
	     */
	    public String getStartDate() {
	        return startDate;
	    }

	    /**
	     * @param startDate the startDate to set
	     */
	    public void setStartDate(String startDate) {
	        this.startDate = startDate;
	    }

	    /**
	     * @return the endDate
	     */
	    public String getEndDate() {
	        return endDate;
	    }

	    /**
	     * @param endDate the endDate to set
	     */
	    public void setEndDate(String endDate) {
	        this.endDate = endDate;
	    }

	    /**
	     * @return the name
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * @param name the name to set
	     */
	    public void setName(String name) {
	        this.name = name;
	    }

	    /**
	     * @return the region
	     */
	    public String getRegion() {
	        return region;
	    }

	    /**
	     * @param region the region to set
	     */
	    public void setRegion(String region) {
	        this.region = region;
	    }

	    /**
	     * @return the country
	     */
	    public String getCountry() {
	        return country;
	    }

	    /**
	     * @param country the country to set
	     */
	    public void setCountry(String country) {
	        this.country = country;
	    }

	    /**
	     * @return the city
	     */
	    public String getCity() {
	        return city;
	    }

	    /**
	     * @param city the city to set
	     */
	    public void setCity(String city) {
	        this.city = city;
	    }

	    /**
	     * @return the holidayNote
	     */
	    public String getHolidayNote() {
	        return holidayNote;
	    }

	    /**
	     * @param holidayNote the holidayNote to set
	     */
	    public void setHolidayNote(String holidayNote) {
	        this.holidayNote = holidayNote;
	    }

	    /**
	     * @return the state
	     */
	    public String getState() {
	        return state;
	    }

	    /**
	     * @param state the state to set
	     */
	    public void setState(String state) {
	        this.state = state;
	    }

	    /**
	     * @return the startYear
	     */
	    public int getStartYear() {
	        return startYear;
	    }

	    /**
	     * @param startYear the startYear to set
	     */
	    public void setStartYear(int startYear) {
	        this.startYear = startYear;
	    }

	    /**
	     * @return the startMonth
	     */
	    public int getStartMonth() {
	        return startMonth;
	    }

	    /**
	     * @param startMonth the startMonth to set
	     */
	    public void setStartMonth(int startMonth) {
	        this.startMonth = startMonth;
	    }

	    /**
	     * @return the startDay
	     */
	    public int getStartDay() {
	        return startDay;
	    }

	    /**
	     * @param startDay the startDay to set
	     */
	    public void setStartDay(int startDay) {
	        this.startDay = startDay;
	    }

	    /**
	     * @return the businessesClosed
	     */
	    public String getBusinessesClosed() {
	        return businessesClosed;
	    }

	    /**
	     * @param businessesClosed the businessesClosed to set
	     */
	    public void setBusinessesClosed(String businessesClosed) {
	        this.businessesClosed = businessesClosed;
	    }

	    /**
	     * @return the banksClosed
	     */
	    public String getBanksClosed() {
	        return banksClosed;
	    }

	    /**
	     * @param banksClosed the banksClosed to set
	     */
	    public void setBanksClosed(String banksClosed) {
	        this.banksClosed = banksClosed;
	    }

	    /**
	     * @return the religiousHoliday
	     */
	    public String getReligiousHoliday() {
	        return religiousHoliday;
	    }

	    /**
	     * @param religiousHoliday the religiousHoliday to set
	     */
	    public void setReligiousHoliday(String religiousHoliday) {
	        this.religiousHoliday = religiousHoliday;
	    }

	    /**
	     * @return the religion
	     */
	    public String getReligion() {
	        return religion;
	    }

	    /**
	     * @param religion the religion to set
	     */
	    public void setReligion(String religion) {
	        this.religion = religion;
	    }

	    /**
	     * @return the dis
	     */
	    public String getDis() {
	        return dis;
	    }

	    /**
	     * @param dis the dis to set
	     */
	    public void setDis(String dis) {
	        this.dis = dis;
	    }

}
