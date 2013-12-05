package main;

import server.activation.ActivationService;
import server.activation.CoordinationContext;
import server.activation.CreateCoordinationContextResponse;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/9/13
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivationAsyncClient {

    ActivationService activationService;

    public ActivationAsyncClient(ActivationService activationService){
        this.activationService = activationService;
    }

    class ActivationServiceCallback implements AsyncHandler<CreateCoordinationContextResponse> {
        private CreateCoordinationContextResponse output;
        public void handleResponse(Response<CreateCoordinationContextResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CreateCoordinationContextResponse getResponse() {
            return output;
        }
    }


    public CoordinationContext CreateCoordinationContext() throws Exception {

        ActivationServiceCallback callbackHandler =
                new ActivationServiceCallback();
        Future<?> resp = activationService.createCoordinationContextAsync("AT", null, 10, callbackHandler);
        // For the purposes of a test, block until the async call completes
//        resp.get(5L, TimeUnit.MINUTES);

        while (!resp.isDone()){}

        return callbackHandler.getResponse().getReturn();
    }

}
