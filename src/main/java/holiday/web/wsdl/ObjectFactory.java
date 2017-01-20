
package holiday.web.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the holiday.web.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStateCityListWrapperResponse_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getStateCityListWrapperResponse");
    private final static QName _GetCountryCityListWrapperResponse_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getCountryCityListWrapperResponse");
    private final static QName _GetStateListWrapperResponse_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getStateListWrapperResponse");
    private final static QName _GetStateListWrapper_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getStateListWrapper");
    private final static QName _GetCountryListWrapperResponse_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getCountryListWrapperResponse");
    private final static QName _GetCountryListWrapper_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getCountryListWrapper");
    private final static QName _GetStateCityListWrapper_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getStateCityListWrapper");
    private final static QName _GetCountryCityListWrapper_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getCountryCityListWrapper");
    private final static QName _GetHolidayBeanListWrapper_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getHolidayBeanListWrapper");
    private final static QName _GetHolidayBeanListWrapperResponse_QNAME = new QName("http://soapwebservice.worldholidaysandevents.com/", "getHolidayBeanListWrapperResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: holiday.web.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHolidayBeanListWrapperResponse }
     * 
     */
    public GetHolidayBeanListWrapperResponse createGetHolidayBeanListWrapperResponse() {
        return new GetHolidayBeanListWrapperResponse();
    }

    /**
     * Create an instance of {@link GetHolidayBeanListWrapper }
     * 
     */
    public GetHolidayBeanListWrapper createGetHolidayBeanListWrapper() {
        return new GetHolidayBeanListWrapper();
    }

    /**
     * Create an instance of {@link GetCountryCityListWrapper }
     * 
     */
    public GetCountryCityListWrapper createGetCountryCityListWrapper() {
        return new GetCountryCityListWrapper();
    }

    /**
     * Create an instance of {@link GetCountryListWrapper }
     * 
     */
    public GetCountryListWrapper createGetCountryListWrapper() {
        return new GetCountryListWrapper();
    }

    /**
     * Create an instance of {@link GetStateCityListWrapper }
     * 
     */
    public GetStateCityListWrapper createGetStateCityListWrapper() {
        return new GetStateCityListWrapper();
    }

    /**
     * Create an instance of {@link GetCountryListWrapperResponse }
     * 
     */
    public GetCountryListWrapperResponse createGetCountryListWrapperResponse() {
        return new GetCountryListWrapperResponse();
    }

    /**
     * Create an instance of {@link GetStateListWrapper }
     * 
     */
    public GetStateListWrapper createGetStateListWrapper() {
        return new GetStateListWrapper();
    }

    /**
     * Create an instance of {@link GetCountryCityListWrapperResponse }
     * 
     */
    public GetCountryCityListWrapperResponse createGetCountryCityListWrapperResponse() {
        return new GetCountryCityListWrapperResponse();
    }

    /**
     * Create an instance of {@link GetStateListWrapperResponse }
     * 
     */
    public GetStateListWrapperResponse createGetStateListWrapperResponse() {
        return new GetStateListWrapperResponse();
    }

    /**
     * Create an instance of {@link GetStateCityListWrapperResponse }
     * 
     */
    public GetStateCityListWrapperResponse createGetStateCityListWrapperResponse() {
        return new GetStateCityListWrapperResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateCityListWrapperResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getStateCityListWrapperResponse")
    public JAXBElement<GetStateCityListWrapperResponse> createGetStateCityListWrapperResponse(GetStateCityListWrapperResponse value) {
        return new JAXBElement<GetStateCityListWrapperResponse>(_GetStateCityListWrapperResponse_QNAME, GetStateCityListWrapperResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryCityListWrapperResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getCountryCityListWrapperResponse")
    public JAXBElement<GetCountryCityListWrapperResponse> createGetCountryCityListWrapperResponse(GetCountryCityListWrapperResponse value) {
        return new JAXBElement<GetCountryCityListWrapperResponse>(_GetCountryCityListWrapperResponse_QNAME, GetCountryCityListWrapperResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateListWrapperResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getStateListWrapperResponse")
    public JAXBElement<GetStateListWrapperResponse> createGetStateListWrapperResponse(GetStateListWrapperResponse value) {
        return new JAXBElement<GetStateListWrapperResponse>(_GetStateListWrapperResponse_QNAME, GetStateListWrapperResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateListWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getStateListWrapper")
    public JAXBElement<GetStateListWrapper> createGetStateListWrapper(GetStateListWrapper value) {
        return new JAXBElement<GetStateListWrapper>(_GetStateListWrapper_QNAME, GetStateListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryListWrapperResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getCountryListWrapperResponse")
    public JAXBElement<GetCountryListWrapperResponse> createGetCountryListWrapperResponse(GetCountryListWrapperResponse value) {
        return new JAXBElement<GetCountryListWrapperResponse>(_GetCountryListWrapperResponse_QNAME, GetCountryListWrapperResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryListWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getCountryListWrapper")
    public JAXBElement<GetCountryListWrapper> createGetCountryListWrapper(GetCountryListWrapper value) {
        return new JAXBElement<GetCountryListWrapper>(_GetCountryListWrapper_QNAME, GetCountryListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStateCityListWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getStateCityListWrapper")
    public JAXBElement<GetStateCityListWrapper> createGetStateCityListWrapper(GetStateCityListWrapper value) {
        return new JAXBElement<GetStateCityListWrapper>(_GetStateCityListWrapper_QNAME, GetStateCityListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryCityListWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getCountryCityListWrapper")
    public JAXBElement<GetCountryCityListWrapper> createGetCountryCityListWrapper(GetCountryCityListWrapper value) {
        return new JAXBElement<GetCountryCityListWrapper>(_GetCountryCityListWrapper_QNAME, GetCountryCityListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHolidayBeanListWrapper }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getHolidayBeanListWrapper")
    public JAXBElement<GetHolidayBeanListWrapper> createGetHolidayBeanListWrapper(GetHolidayBeanListWrapper value) {
        return new JAXBElement<GetHolidayBeanListWrapper>(_GetHolidayBeanListWrapper_QNAME, GetHolidayBeanListWrapper.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHolidayBeanListWrapperResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservice.worldholidaysandevents.com/", name = "getHolidayBeanListWrapperResponse")
    public JAXBElement<GetHolidayBeanListWrapperResponse> createGetHolidayBeanListWrapperResponse(GetHolidayBeanListWrapperResponse value) {
        return new JAXBElement<GetHolidayBeanListWrapperResponse>(_GetHolidayBeanListWrapperResponse_QNAME, GetHolidayBeanListWrapperResponse.class, null, value);
    }

}
