package thriftclient;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thriftgen.activation.ActivationService;
import thriftgen.activation.CoordinationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivationClient {

    private String serverUrl;
    private int port;

    public ActivationClient(String serverUrl, int port){
        this.serverUrl = serverUrl;
        this.port = port;
    }

    public CoordinationContext createCoordinationContext(String coordinationType, CoordinationContext existingContext, int expires ){
        TTransport transport;
        TFramedTransport tFramedTransport;
        ActivationService.Client createClient;
        CoordinationContext coordinationContext = new CoordinationContext();

        transport = new TSocket(serverUrl, port);
        tFramedTransport = new TFramedTransport(transport);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            createClient = new ActivationService.Client(protocol);

            coordinationContext = createClient.createCoordinationContext(coordinationType, existingContext, expires);
            transport.close();

            System.out.println("client context " + coordinationContext);

        }catch (TException e) {
            e.printStackTrace();
        }
        return coordinationContext;
    }
}
