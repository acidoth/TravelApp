package main;

import server.put.PutResponse;
import server.put.PutService;
import server.put.PutServiceImplService;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/9/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class PutAsyncClient {

    PutService putService;
    URL ws;

    public PutAsyncClient(URL wsdlLocation, QName serviceName){
        PutServiceImplService service = new PutServiceImplService(wsdlLocation, serviceName);
        putService = service.getPutServiceImplPort();
        ws = wsdlLocation;
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


    public boolean Put(String str1, String str2, String str3, String str4, String str5, String str6, int in1, int in2) throws Exception {

        System.out.println("put called for " + ws);
        ManagementFactory.getRuntimeMXBean().getName();
//        PutCallback callbackHandler =
//                new PutCallback();
//        Future<?> resp = putService.putAsync(str1, str2, str3, str4, str5, str6, in1, in2, callbackHandler);
//        // For the purposes of a test, block until the async call completes
////        resp.get(5L, TimeUnit.MINUTES);
//
//        while (!resp.isDone()){}
//
//        return callbackHandler.getResponse().isReturn();
        return putService.put(str1, str2, str3, str4, str5, str6, in1, in2);
    }
}
