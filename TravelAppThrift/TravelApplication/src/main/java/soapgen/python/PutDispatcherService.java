
package soapgen.python;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "PutDispatcherService", targetNamespace = "http://localhost:8008/put.wsdl", wsdlLocation = "http://localhost:8008/")
public class PutDispatcherService
    extends Service
{

    private final static URL PUTDISPATCHERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(PutDispatcherService.class.getName());
    private URL wsdlLocation;
    private QName serviceName;

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = PutDispatcherService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8008/");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8008/', retrying as a local file");
            logger.warning(e.getMessage());
        }
        PUTDISPATCHERSERVICE_WSDL_LOCATION = url;
    }

    public PutDispatcherService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
        this.wsdlLocation = wsdlLocation;
        this.serviceName = serviceName;
    }

    public PutDispatcherService() {
        super(PUTDISPATCHERSERVICE_WSDL_LOCATION, new QName("http://localhost:8008/put.wsdl", "PutDispatcherService"));
    }

    /**
     * 
     * @return
     *     returns PutDispatcherPortType
     */
    @WebEndpoint(name = "PutDispatcher")
    public PutDispatcherPortType getPutDispatcher() {
        return super.getPort(new QName(serviceName.getNamespaceURI(), "PutDispatcher"), PutDispatcherPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PutDispatcherPortType
     */
    @WebEndpoint(name = "PutDispatcher")
    public PutDispatcherPortType getPutDispatcher(WebServiceFeature... features) {
        return super.getPort(new QName(serviceName.getNamespaceURI(), "PutDispatcher"), PutDispatcherPortType.class, features);
    }

}