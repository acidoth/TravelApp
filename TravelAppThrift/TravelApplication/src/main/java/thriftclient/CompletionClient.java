package thriftclient;

import main.TravelApp;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thriftgen.completion.CompletionService;
import thriftgen.completion.ServiceResponse;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionClient {
    private String serverUrl;
    private int port;

    public CompletionClient(String serverUrl, int port ){
        this.serverUrl = serverUrl;
        this.port = port;
    }

    public ServiceResponse commit(String identifier){

        TTransport transport;
        CompletionService.Client commitClient;
        ServiceResponse serviceResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            commitClient = new CompletionService.Client(protocol);

            serviceResponse = commitClient.commit(identifier);

            transport.close();

        }catch (TException e) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(TravelApp.file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            e.printStackTrace(ps);
            ps.close();
            e.printStackTrace();
        }
        return serviceResponse;
    }


    public ServiceResponse rollback(String identifier){
        TTransport transport;

        CompletionService.Client rollbackClient;
        ServiceResponse serviceResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            rollbackClient = new CompletionService.Client(protocol);

            serviceResponse = rollbackClient.commit(identifier);

            transport.close();

        }catch (TException e) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(TravelApp.file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            e.printStackTrace(ps);
            ps.close();
            e.printStackTrace();
        }
        return serviceResponse;
    }
}
