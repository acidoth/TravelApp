
package server.activation;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ActivationServiceImplService", targetNamespace = "http://activation.server/")
public class ActivationServiceImplService
    extends Service
{

    private final static URL ACTIVATIONSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException ACTIVATIONSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName ACTIVATIONSERVICEIMPLSERVICE_QNAME = new QName("http://activation.server/", "ActivationServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/ActivationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACTIVATIONSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        ACTIVATIONSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public ActivationServiceImplService() {
        super(__getWsdlLocation(), ACTIVATIONSERVICEIMPLSERVICE_QNAME);
    }

    public ActivationServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACTIVATIONSERVICEIMPLSERVICE_QNAME, features);
    }

    public ActivationServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, ACTIVATIONSERVICEIMPLSERVICE_QNAME);
    }

    public ActivationServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACTIVATIONSERVICEIMPLSERVICE_QNAME, features);
    }

    public ActivationServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ActivationServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ActivationService
     */
    @WebEndpoint(name = "ActivationServiceImplPort")
    public ActivationService getActivationServiceImplPort() {
        return super.getPort(new QName("http://activation.server/", "ActivationServiceImplPort"), ActivationService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ActivationService
     */
    @WebEndpoint(name = "ActivationServiceImplPort")
    public ActivationService getActivationServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://activation.server/", "ActivationServiceImplPort"), ActivationService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACTIVATIONSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw ACTIVATIONSERVICEIMPLSERVICE_EXCEPTION;
        }
        return ACTIVATIONSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
