package main;





import org.wso2.carbon.registry.acidothinterface.putserver.PutResponse;
import soapgen.java.host.PutService;
import soapgen.java.host.PutServiceImplService;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/10/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PutAsyncClient {

    PutService putService;

    public PutAsyncClient(URL wsdlLocation, QName serviceName){
        PutServiceImplService putServiceImplService = new PutServiceImplService(wsdlLocation, serviceName);
        putService = putServiceImplService.getPutServiceImplPort();
    }

    class PutCallback implements AsyncHandler<PutResponse> {

        private PutResponse output;
        public void handleResponse(Response<PutResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        PutResponse getResponse() {
            return output;
        }
    }


    public boolean put(String str1, String str2, String str3, String identifier, String coordinationType, String registrationAddress, int registrationPort, int expires) throws Exception {

//        PutCallback callbackHandler =
//                new PutCallback();
//        Future<?> resp = putService.putAsync(str1, str2, str3, identifier,coordinationType, registrationAddress, registrationPort, expires, callbackHandler );
//        // For the purposes of a test, block until the async call completes
////        resp.get(5L, TimeUnit.MINUTES);
//
//        while (!resp.isDone()){}
//
//        return callbackHandler.getResponse().isReturn();

        return putService.put(str1, str2, str3, identifier,coordinationType, registrationAddress, registrationPort, expires);
    }
}
