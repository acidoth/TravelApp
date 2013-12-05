package main;

import server.activation.ActivationService;
import server.activation.CoordinationContext;
import server.completion.CompletionService;
import server.completion.ServiceResponse;
import util.Constants;
import util.Customer;
import util.XmlLoader;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created with IntelliJ IDEA.
 * User: chaamini
 * Date: 8/15/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class TravelApp {

    private static int totalTransactions = 0;
    public static String fileName;
    public static File file;
    CompletionAsyncClient completionAsyncClient = null;
    ActivationAsyncClient activationAsyncClient = null;

    public TravelApp(){
        PortCache portCache = new PortCache();
        CompletionService completionService = portCache.getCompletionServicePort(Constants.completionServiceAddress);
        ActivationService activationService = portCache.getActivationServicePort(Constants.activationServiceAddress);

        completionAsyncClient = new CompletionAsyncClient(completionService);
        activationAsyncClient = new ActivationAsyncClient(activationService);

    }

    SampleWSRegistryClient sampleWSRegistryClient=new SampleWSRegistryClient(Constants.putServiceAddress);
    SampleWSRegistryClient sampleWSRegistryClient2=new SampleWSRegistryClient(Constants.putServiceAddress2);

    public static void main(String[] args){
        new XmlLoader();
        //Scanner scanner=new Scanner(System.in);
        //System.out.println("enter it haha : ");

        System.out.println("Test l....."+ args[0]);
        TravelApp travelApp = new TravelApp();

        long timeInMinute = Long.parseLong(args[0]);
        //timeInMinute=scanner.nextLong();
        long timeInMs = timeInMinute * 60 * 1000;
        long startTime = System.currentTimeMillis();
        long timePeriod = System.currentTimeMillis() - startTime;

        int dataNum = Integer.parseInt(args[1])*100000;

        fileName = Integer.toString(dataNum);

        file = new File(fileName + ".log");

        do
        {
            travelApp.doTransaction(Integer.toString(dataNum));
            timePeriod = System.currentTimeMillis() - startTime;
            dataNum++;

        }while (timePeriod < timeInMs);
    }


    private void doTransaction(String data){

        String isPutSuccess1 = "-1", isPutSuccess2 = "-1";
        ServiceResponse serviceResponse = null;
        CoordinationContext coordinationContext = createCoordinationContext();

        if(coordinationContext != null){

            System.out.println("Coordination context created " + coordinationContext);

            //isPutSuccess1 = putJavaParticipant(Constants.putServiceAddress, coordinationContext, data);
            //isPutSuccess2 = putJavaParticipant(Constants.putServiceAddress2, coordinationContext, data);
            try {
                isPutSuccess1=sampleWSRegistryClient.Put(coordinationContext,data,data,data);
                isPutSuccess2=sampleWSRegistryClient2.Put(coordinationContext,data,data,data);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            if(!isPutSuccess1.equals("-1"))
                System.out.println("Successfull registered for participant " + Constants.putServiceAddress + " for " + coordinationContext.getIdentifier());
            if(!isPutSuccess2.equals("-1"))
                System.out.println("Successfull registered for participant " + Constants.putServiceAddress2 + " for " + coordinationContext.getIdentifier());

            if((!isPutSuccess1.equals("-1")) && (!isPutSuccess2.equals("-1")))   {
                serviceResponse = completeTransaction(coordinationContext);

                if(serviceResponse == ServiceResponse.COMMITTED)
                    System.out.println("Transaction finished " + coordinationContext.getIdentifier());
            }
            else {
                 rollbackTransaction(coordinationContext.getIdentifier());
            }
        }
    }

    private CoordinationContext createCoordinationContext(){

        CoordinationContext coordinationContext = null;
        try {
            coordinationContext = activationAsyncClient.CreateCoordinationContext();
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return coordinationContext;
    }


    private String putJavaParticipant(String putAddress, CoordinationContext coordinationContext, String data){

        String result = null;

        try {

            SampleWSRegistryClient sampleWSRegistryClient = new SampleWSRegistryClient(putAddress);
            result = sampleWSRegistryClient.Put(coordinationContext, data, data, data);

        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return result;
    }


    private ServiceResponse completeTransaction(CoordinationContext coordinationContext){


        ServiceResponse serviceResponse = null;

        try {
            serviceResponse = completionAsyncClient.Commit(coordinationContext.getIdentifier());
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return serviceResponse;
    }

    private ServiceResponse rollbackTransaction(String identifier){
        ServiceResponse serviceResponse=null;
        try {
            serviceResponse=completionAsyncClient.Rollback(identifier);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return serviceResponse;
    }





    public void initialize (final Customer customer){

       /* ActivationServiceImplService activationServiceImplService = null;
        try {
            activationServiceImplService = new ActivationServiceImplService(new URL(Constants.activationServiceAddress), new QName(Constants.activationServiceAddress, "ActivationServiceImplService"));
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        ActivationService activationService = activationServiceImplService.getActivationServiceImplPort();
        CoordinationContext coordinationContext = activationService.createCoordinationContext("AT", null, 0);

        if(coordinationContext != null){

            System.out.println(coordinationContext);


           *//* soapgen.put.host._9084.PutServiceImplService putServiceImplService1 = new soapgen.put.host._9084.PutServiceImplService();
            soapgen.put.host._9086.PutServiceImplService putServiceImplService2 = new soapgen.put.host._9086.PutServiceImplService();

            soapgen.put.host._9084.PutService putService1 = putServiceImplService1.getPutServiceImplPort();
            soapgen.put.host._9086.PutService putService2 = putServiceImplService2.getPutServiceImplPort();*//*

            PutServiceImplService putServiceImplService1 = null;
            PutServiceImplService putServiceImplService2 = null;
            try {
                putServiceImplService1 = new PutServiceImplService(new URL(Constants.putServiceAddress), new QName(Constants.putServiceAddress, "PutServiceImplService"));
                putServiceImplService2 = new PutServiceImplService(new URL(Constants.putServiceAddress2), new QName(Constants.putServiceAddress2, "PutServiceImplService"));
            } catch (MalformedURLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


            PutService putService1 = putServiceImplService1.getPutServiceImplPort();
            PutService putService2 = putServiceImplService2.getPutServiceImplPort();

            boolean putRespose1 = putService1.put(customer.getName(), "2", "3", coordinationContext.getIdentifier(), coordinationContext.getCoordinationType(), coordinationContext.getEndPointReference().getAddress(), coordinationContext.getEndPointReference().getPrivateInstance(), coordinationContext.getExpires());
            boolean putRespose2 = putService2.put(customer.getName(), "2", "3", coordinationContext.getIdentifier(), coordinationContext.getCoordinationType(), coordinationContext.getEndPointReference().getAddress(), coordinationContext.getEndPointReference().getPrivateInstance(), coordinationContext.getExpires());

            System.out.println(putRespose1 + " " + putRespose2);

            ServiceResponse commitResponse = null;
            CompletionServiceImplService completionServiceImplService = null;
            try {
                completionServiceImplService = new CompletionServiceImplService(new URL(Constants.completionServiceAddress), new QName(Constants.completionServiceAddress, "CompletionServiceImplService"));
            } catch (MalformedURLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            CompletionService completionService = completionServiceImplService.getCompletionServiceImplPort();
//            ((BindingProvider)completionService).getRequestContext().put("javax.xml.ws.client.connectionTimeout", "3000");
//            ((BindingProvider)completionService).getResponseContext().put("javax.xml.ws.client.receiveTimeout", "3000");

            if(putRespose1 && putRespose2){
                System.out.println("registration successfull " + coordinationContext.getIdentifier());
                commitResponse = completionService.commit(coordinationContext.getIdentifier());
            }
            else{
                System.out.println("transaction aborted");
                completionService.rollBack(coordinationContext.getIdentifier());
            }

            if(commitResponse == ServiceResponse.COMMITTED)
                System.out.println("Successfully commited");
        }

        System.out.println(coordinationContext);*/



//                   PutDispatcherService putDispatcherService1 = null;
//                   try {
//                       putDispatcherService1 = new PutDispatcherService(new URL("http://localhost:8009/"));
//                   } catch (MalformedURLException e) {
//                       e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                   }
//                   PutDispatcherPortType putDispatcherPortType1 = putDispatcherService1.getPutDispatcher();
//
//                   Put put1 = new Put();
//                   put1.setCoordinationType("AtomicTransaction");
//                   put1.setCoordinatorPort(coordinationContext.getEndPointReference().getPrivateInstance());
//                   put1.setCoordinatorUrl(coordinationContext.getEndPointReference().getAddress());
//                   put1.setDate(customer.getDate());
//                   put1.setDestinationFrom(customer.getDestinationFrom());
//                   put1.setDestinationTo(customer.getDestinationTo());
//                   put1.setExpires(coordinationContext.getExpires());
//                   put1.setHotelName(customer.getHotelName());
//                   put1.setIdentifier(coordinationContext.getIdentifier());
//                   put1.setStayHotel(Integer.parseInt(customer.getStayInHotel()));
//                   put1.setName(customer.getName());
//
//                   PutResponse putResponse1 = putDispatcherPortType1.put(put1);
    }
}
