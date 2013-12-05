package thriftclient;

import main.AcidothLogger;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import thriftgen.completion.CompletionService;
import thriftgen.completion.ServiceResponse;

import java.io.IOException;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/6/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionAsyncClient {

    private String serverUrl;
    private int port;
    private ServiceResponse commitResponse, rollbackResponse;
    private String wait = new String();
    TAsyncClientManager asyncClientManager = null;


    public CompletionAsyncClient(String serverUrl, int port){
        this.serverUrl = serverUrl;
        this.port = port;

        try {
            asyncClientManager = new TAsyncClientManager();
        } catch (IOException e) {
            AcidothLogger.getLogger().log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public ServiceResponse commit(String identifier){

        TNonblockingTransport tNonblockingTransport = null;
        TProtocolFactory tProtocolFactory = null;

        try {
            tNonblockingTransport = new TNonblockingSocket(serverUrl, port);
            tProtocolFactory = new TBinaryProtocol.Factory();

            CompletionService.AsyncClient client = new CompletionService.AsyncClient(tProtocolFactory, asyncClientManager, tNonblockingTransport);
            client.commit(identifier, new CommitCallback());

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
//        asyncClientManager.stop();

        return commitResponse;
    }

    class CommitCallback implements AsyncMethodCallback<CompletionService.AsyncClient.commit_call>{

        @Override
        public void onComplete(CompletionService.AsyncClient.commit_call commit_call) {
            //To change body of implemented methods use File | Settings | File Templates.
            try {
                commitResponse = commit_call.getResult();
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

    public ServiceResponse rollback(String identifier){

        TNonblockingTransport tNonblockingTransport = null;
        TProtocolFactory tProtocolFactory = null;

        try {
            tNonblockingTransport = new TNonblockingSocket(serverUrl, port);
            tProtocolFactory = new TBinaryProtocol.Factory();

            CompletionService.AsyncClient client = new CompletionService.AsyncClient(tProtocolFactory, asyncClientManager, tNonblockingTransport);
            client.rollBack(identifier, new rollbackCallback());
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
//        asyncClientManager.stop();

        return rollbackResponse;
    }

    class rollbackCallback implements AsyncMethodCallback<CompletionService.AsyncClient.rollBack_call>{

        @Override
        public void onComplete(CompletionService.AsyncClient.rollBack_call rollBack_call) {
            //To change body of implemented methods use File | Settings | File Templates.
            try {
                rollbackResponse = rollBack_call.getResult();
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
