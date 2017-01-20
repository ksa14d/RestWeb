package holiday.web.entities;


import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "holidaybeanlistwrapper")
public final class HolidayBeanListWrapper {

    private ArrayList<HolidayBean> holidayBeanList;

    public HolidayBeanListWrapper() {
        this(null);
    }

    public HolidayBeanListWrapper(ArrayList<HolidayBean> holidayBeanList) {
        this.holidayBeanList = holidayBeanList;
    }

    /**
     * @return the holidayBeanList
     */
    public ArrayList<HolidayBean> getHolidayBeanList() {
        return holidayBeanList;
    }

    /**
     * @param holidayBeanList the holidayBeanList to set
     */
    public void setHolidayBeanList(ArrayList<HolidayBean> holidayBeanList) {
        this.holidayBeanList = holidayBeanList;
    }
}
