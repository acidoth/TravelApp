
package server.activation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server.activation package. 
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

    private final static QName _CreateCoordinationContext_QNAME = new QName("http://activation.server/", "createCoordinationContext");
    private final static QName _CreateCoordinationContextResponse_QNAME = new QName("http://activation.server/", "createCoordinationContextResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server.activation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link server.activation.CoordinationContext }
     * 
     */
    public CoordinationContext createCoordinationContext() {
        return new CoordinationContext();
    }

    /**
     * Create an instance of {@link server.activation.CreateCoordinationContextResponse }
     * 
     */
    public CreateCoordinationContextResponse createCreateCoordinationContextResponse() {
        return new CreateCoordinationContextResponse();
    }

    /**
     * Create an instance of {@link server.activation.EndPointReference }
     * 
     */
    public EndPointReference createEndPointReference() {
        return new EndPointReference();
    }

    /**
     * Create an instance of {@link server.activation.CreateCoordinationContext }
     * 
     */
    public CreateCoordinationContext createCreateCoordinationContext() {
        return new CreateCoordinationContext();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link server.activation.CreateCoordinationContext }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://activation.server/", name = "createCoordinationContext")
    public JAXBElement<CreateCoordinationContext> createCreateCoordinationContext(CreateCoordinationContext value) {
        return new JAXBElement<CreateCoordinationContext>(_CreateCoordinationContext_QNAME, CreateCoordinationContext.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link server.activation.CreateCoordinationContextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://activation.server/", name = "createCoordinationContextResponse")
    public JAXBElement<CreateCoordinationContextResponse> createCreateCoordinationContextResponse(CreateCoordinationContextResponse value) {
        return new JAXBElement<CreateCoordinationContextResponse>(_CreateCoordinationContextResponse_QNAME, CreateCoordinationContextResponse.class, null, value);
    }

}
