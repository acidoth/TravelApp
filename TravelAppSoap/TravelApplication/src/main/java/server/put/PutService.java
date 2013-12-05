
package server.put;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import java.util.concurrent.Future;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PutService", targetNamespace = "http://put.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PutService {


    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @param arg6
     * @param arg7
     * @return
     *     returns javax.xml.ws.Response<server.put.PutResponse>
     */
    @WebMethod(operationName = "put")
    @RequestWrapper(localName = "put", targetNamespace = "http://put.server/", className = "server.put.Put")
    @ResponseWrapper(localName = "putResponse", targetNamespace = "http://put.server/", className = "server.put.PutResponse")
    public Response<PutResponse> putAsync(
            @WebParam(name = "arg0", targetNamespace = "")
            String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            String arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            String arg3,
            @WebParam(name = "arg4", targetNamespace = "")
            String arg4,
            @WebParam(name = "arg5", targetNamespace = "")
            String arg5,
            @WebParam(name = "arg6", targetNamespace = "")
            int arg6,
            @WebParam(name = "arg7", targetNamespace = "")
            int arg7);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @param asyncHandler
     * @param arg6
     * @param arg7
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "put")
    @RequestWrapper(localName = "put", targetNamespace = "http://put.server/", className = "server.put.Put")
    @ResponseWrapper(localName = "putResponse", targetNamespace = "http://put.server/", className = "server.put.PutResponse")
    public Future<?> putAsync(
            @WebParam(name = "arg0", targetNamespace = "")
            String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            String arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            String arg3,
            @WebParam(name = "arg4", targetNamespace = "")
            String arg4,
            @WebParam(name = "arg5", targetNamespace = "")
            String arg5,
            @WebParam(name = "arg6", targetNamespace = "")
            int arg6,
            @WebParam(name = "arg7", targetNamespace = "")
            int arg7,
            @WebParam(name = "asyncHandler", targetNamespace = "")
            AsyncHandler<PutResponse> asyncHandler);

    /**
     * 
     * @param arg5
     * @param arg4
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @param arg6
     * @param arg7
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "put", targetNamespace = "http://put.server/", className = "server.put.Put")
    @ResponseWrapper(localName = "putResponse", targetNamespace = "http://put.server/", className = "server.put.PutResponse")
    public boolean put(
            @WebParam(name = "arg0", targetNamespace = "")
            String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            String arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            String arg3,
            @WebParam(name = "arg4", targetNamespace = "")
            String arg4,
            @WebParam(name = "arg5", targetNamespace = "")
            String arg5,
            @WebParam(name = "arg6", targetNamespace = "")
            int arg6,
            @WebParam(name = "arg7", targetNamespace = "")
            int arg7);

}