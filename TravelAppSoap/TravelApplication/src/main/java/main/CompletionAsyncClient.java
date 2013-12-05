package main;

import server.completion.CommitResponse;
import server.completion.CompletionService;
import server.completion.RollBackResponse;
import server.completion.ServiceResponse;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/9/13
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionAsyncClient {

    CompletionService completionService;

    public CompletionAsyncClient(CompletionService completionService){
        this.completionService = completionService;
    }

    class CommitCallback implements AsyncHandler<CommitResponse> {
        private CommitResponse output;

        public void handleResponse(Response<CommitResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        CommitResponse getResponse() {
            return output;
        }
    }


    public ServiceResponse Commit(String identifier) throws Exception {

        CommitCallback callbackHandler =
                new CommitCallback();
        Future<?> resp = completionService.commitAsync(identifier, callbackHandler);
        // For the purposes of a test, block until the async call completes
//        resp.get(5L, TimeUnit.MINUTES);

        while (!resp.isDone()){}

        return callbackHandler.getResponse().getReturn();
    }

    class RollbackCallback implements AsyncHandler<RollBackResponse> {
        private RollBackResponse output;

        public void handleResponse(Response<RollBackResponse> response) {
            try {
                output = response.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RollBackResponse getResponse() {
            return output;
        }
    }


    public ServiceResponse Rollback(String identifier) throws Exception {

        RollbackCallback callbackHandler =
                new RollbackCallback();
        Future<?> resp = completionService.rollBackAsync(identifier, callbackHandler);
        // For the purposes of a test, block until the async call completes
//        resp.get(5L, TimeUnit.MINUTES);

        while (!resp.isDone()){}

        return callbackHandler.getResponse().getReturn();
    }
}
