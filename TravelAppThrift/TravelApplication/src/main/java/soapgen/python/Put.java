
package soapgen.python;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="coordinatorUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coordinationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expires" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stayHotel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destinationFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hotelName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coordinatorPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="destinationTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Put")
public class Put {

    @XmlElement(required = true)
    protected String coordinatorUrl;
    @XmlElement(required = true)
    protected String coordinationType;
    protected int expires;
    protected int stayHotel;
    @XmlElement(required = true)
    protected String date;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String destinationFrom;
    @XmlElement(required = true)
    protected String hotelName;
    @XmlElement(required = true)
    protected String identifier;
    protected int coordinatorPort;
    @XmlElement(required = true)
    protected String destinationTo;

    /**
     * Gets the value of the coordinatorUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinatorUrl() {
        return coordinatorUrl;
    }

    /**
     * Sets the value of the coordinatorUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinatorUrl(String value) {
        this.coordinatorUrl = value;
    }

    /**
     * Gets the value of the coordinationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinationType() {
        return coordinationType;
    }

    /**
     * Sets the value of the coordinationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinationType(String value) {
        this.coordinationType = value;
    }

    /**
     * Gets the value of the expires property.
     * 
     */
    public int getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     */
    public void setExpires(int value) {
        this.expires = value;
    }

    /**
     * Gets the value of the stayHotel property.
     * 
     */
    public int getStayHotel() {
        return stayHotel;
    }

    /**
     * Sets the value of the stayHotel property.
     * 
     */
    public void setStayHotel(int value) {
        this.stayHotel = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the destinationFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationFrom() {
        return destinationFrom;
    }

    /**
     * Sets the value of the destinationFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationFrom(String value) {
        this.destinationFrom = value;
    }

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the coordinatorPort property.
     * 
     */
    public int getCoordinatorPort() {
        return coordinatorPort;
    }

    /**
     * Sets the value of the coordinatorPort property.
     * 
     */
    public void setCoordinatorPort(int value) {
        this.coordinatorPort = value;
    }

    /**
     * Gets the value of the destinationTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationTo() {
        return destinationTo;
    }

    /**
     * Sets the value of the destinationTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationTo(String value) {
        this.destinationTo = value;
    }

}
