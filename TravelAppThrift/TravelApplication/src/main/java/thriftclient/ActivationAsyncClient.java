package thriftclient;

import main.AcidothLogger;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import thriftgen.activation.ActivationService;
import thriftgen.activation.CoordinationContext;

import java.io.IOException;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/6/13
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivationAsyncClient {

    private String serverUrl;
    private int port;
    private CoordinationContext  coordinationContext;
    private String wait = new String();
    TAsyncClientManager asyncClientManager = null;



    public ActivationAsyncClient(String serverUrl, int port){
        this.serverUrl = serverUrl;
        this.port = port;

        try {
            asyncClientManager = new TAsyncClientManager();
        } catch (IOException e) {
            AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

     public CoordinationContext createCoordinationContext(String coordinationType, CoordinationContext existingCoordinationContext, int expires){

         TNonblockingTransport tNonblockingTransport = null;
         TProtocolFactory tProtocolFactory = null;

         try {
             tNonblockingTransport = new TNonblockingSocket(serverUrl, port);
             tProtocolFactory = new TBinaryProtocol.Factory();

             ActivationService.AsyncClient client = new ActivationService.AsyncClient(tProtocolFactory, asyncClientManager, tNonblockingTransport);
             client.createCoordinationContext(coordinationType, existingCoordinationContext, expires, new CreateCoordinationContextCallback());

         } catch (IOException e) {
             AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);
             e.printStackTrace();

         } catch (TException e) {
             AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);
             e.printStackTrace();

         }

        synchronized (wait){
             try {
                 wait.wait();
             } catch (InterruptedException e) {
                 AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);

                 e.printStackTrace();
             }
         }

         tNonblockingTransport.close();
//         asyncClientManager.stop();

         return coordinationContext;
     }


    class CreateCoordinationContextCallback implements AsyncMethodCallback<ActivationService.AsyncClient.createCoordinationContext_call>{

        @Override
        public void onComplete(final ActivationService.AsyncClient.createCoordinationContext_call createCoordinationContext_call) {

                        try {
                            System.out.println("Gng to create coordinationcontext ....................");
                            coordinationContext = createCoordinationContext_call.getResult();
                            System.out.println("Coordination context is"+coordinationContext);

                            synchronized (wait){
                                wait.notifyAll();
                            }
                        } catch (TException e) {
                            AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);
                            e.printStackTrace();
                        }
        }

        @Override
        public void onError(Exception e) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
