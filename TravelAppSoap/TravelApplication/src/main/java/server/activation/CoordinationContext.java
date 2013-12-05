
package server.activation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoordinationContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoordinationContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coordinationType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndPointReference" type="{http://activation.server/}EndPointReference"/>
 *         &lt;element name="expires" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "CoordinationContext", propOrder = {
    "identifier",
    "coordinationType",
    "endPointReference",
    "expires"
})
public class CoordinationContext {

    @XmlElement(required = true)
    protected String identifier;
    @XmlElement(required = true)
    protected String coordinationType;
    @XmlElement(name = "EndPointReference", required = true)
    protected EndPointReference endPointReference;
    protected int expires;

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
     * Gets the value of the endPointReference property.
     * 
     * @return
     *     possible object is
     *     {@link EndPointReference }
     *     
     */
    public EndPointReference getEndPointReference() {
        return endPointReference;
    }

    /**
     * Sets the value of the endPointReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndPointReference }
     *     
     */
    public void setEndPointReference(EndPointReference value) {
        this.endPointReference = value;
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

}
