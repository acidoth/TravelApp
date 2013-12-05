package main;

import soapgen.python.Put;
import soapgen.python.PutDispatcherPortType;
import soapgen.python.PutDispatcherService;
import soapgen.python.PutResponse;
import thriftclient.ActivationAsyncClient;
import thriftclient.CompletionAsyncClient;
import thriftgen.activation.CoordinationContext;
import thriftgen.completion.ServiceResponse;
import util.Constants;
import util.XmlLoader;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: chaamini
 * Date: 8/15/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

public class TravelApp{// extends HttpServlet {

    private int resulst;
    public static String fileName;
    public static File file;


    SampleWSRegistryClient sampleWSRegistryClient=new SampleWSRegistryClient(Constants.putAddress1);
    SampleWSRegistryClient sampleWSRegistryClient2=new SampleWSRegistryClient(Constants.putAddress2);
    ActivationAsyncClient activationClient = new ActivationAsyncClient(Constants.coordinatorServerAddress, Constants.activationPort);
    CompletionAsyncClient completionClient = new CompletionAsyncClient(Constants.coordinatorServerAddress, Constants.completionPort);


    public static void main(String[] args){
        //System.out.println("tttttttttt " + );
        new XmlLoader();
        System.out.println("time duration of a single Transaction : " + args[0]);
        TravelApp travelApp = new TravelApp();

        long timeInMinute = Long.parseLong(args[0]);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Time Bass: ");
        timeInMinute=scanner.nextLong();
        long timeInMs = timeInMinute * 60 * 1000;
        long startTime = System.currentTimeMillis();
        long timePeriod = System.currentTimeMillis() - startTime;

        int dataNum = Integer.parseInt(args[1])*100000;

        fileName = Integer.toString(dataNum);

        file = new File(fileName + ".log");

        do
        {
            travelApp.doTransaction(new Customer("ac", "cd", "ef", "gh", "hi", "2"), Integer.toString(dataNum));
            timePeriod = System.currentTimeMillis() - startTime;
            dataNum++;
        }while (timePeriod < timeInMs);


    }


    private void doTransaction(Customer customer, String data){

        String  isPutSuccess1 = "-1", isPutSuccess2 = "-1";
        CoordinationContext coordinationContext = createCoordinationContext();

        if (coordinationContext != null){
            System.out.println("Coordination Context created " + coordinationContext);

//        boolean isPutSuccess1 = putPythonParticipant(Constants.putAddress3, coordinationContext, customer);
      //   isPutSuccess1 = putJavaParticipant(Constants.putAddress1, coordinationContext, data);
           // System.out.println("peeeeeeeeeeeeeeeeeepppppppppppp...............");
       //  isPutSuccess2 = putJavaParticipant(Constants.putAddress2, coordinationContext, data);


            try {
                isPutSuccess1=sampleWSRegistryClient.Put(coordinationContext,data,data,data);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            try {
                isPutSuccess2=sampleWSRegistryClient2.Put(coordinationContext,data,data,data);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            System.out.println("First put ================ "+isPutSuccess1+" SecondPUT================== "+isPutSuccess2 +"  ========================");

            if(!isPutSuccess1.equals("-1"))
                System.out.println("Participant with put Address " + Constants.putAddress1 + "Successfully registered");
            if(!isPutSuccess2.equals("-1"))
                System.out.println("Participant with put Address " + Constants.putAddress2 + "Successfully registered");
        }

        if((!isPutSuccess1.equals("-1")) && (!isPutSuccess2.equals("-1"))) {
            ServiceResponse commitResponse = commitTransaction(coordinationContext);

            if(commitResponse == ServiceResponse.commited)
                System.out.println("Transaction " + coordinationContext.getIdentifier() + "Successfully Completed");
       }
        else{
            completionClient.rollback(coordinationContext.getIdentifier());
        }
    }


    private CoordinationContext createCoordinationContext(){
        return  activationClient.createCoordinationContext("AtomicTransaction", null, 0);
    }


    private String putJavaParticipant(String putAddress, CoordinationContext coordinationContext, String data){

        String result = null;

        try {

            SampleWSRegistryClient sampleWSRegistryClient = new SampleWSRegistryClient(putAddress);
            result = sampleWSRegistryClient.Put(coordinationContext, data, data, data);

        } catch (MalformedURLException e) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(TravelApp.file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            e.printStackTrace(ps);
            ps.close();
            e.printStackTrace();
        } catch (Exception e) {
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
        return result;
    }


    private boolean putPythonParticipant(String putAddress, CoordinationContext coordinationContext, Customer customer){

        boolean isTravelSuccess;
        PutDispatcherService putDispatcherService = null;
        try {
            putDispatcherService = new PutDispatcherService(new URL(putAddress), new QName(putAddress + "/put.wsdl", "PutDispatcherService"));
        } catch (MalformedURLException e) {
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
        System.out.println("hi");


        PutDispatcherPortType putDispatcherPortType = putDispatcherService.getPutDispatcher();

        Put put = new Put();
        put.setCoordinationType("AtomicTransaction");
        put.setCoordinatorPort(coordinationContext.getRegistrationEPR().getPrivateInstance());
        put.setCoordinatorUrl(coordinationContext.getRegistrationEPR().getAddress());
        put.setDate(customer.getDate());
        put.setDestinationFrom(customer.getDestinationFrom());
        put.setDestinationTo(customer.getDestinationTo());
        put.setExpires(coordinationContext.getExpires());
        put.setHotelName(customer.getHotelName());
        put.setIdentifier(coordinationContext.getIdentifier());
        put.setStayHotel(Integer.parseInt(customer.getStayInHotel()));
        put.setName(customer.getName());


        PutResponse putResponse = putDispatcherPortType.put(put);
        isTravelSuccess = putResponse.isPutResult();

        return isTravelSuccess;
    }


    private ServiceResponse commitTransaction(CoordinationContext coordinationContext){
        return completionClient.commit(coordinationContext.getIdentifier());
    }


    /*//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        final Customer customer = new Customer(request.getParameter("name"), request.getParameter("destinationFrom"), request.getParameter("destinationTo"), request.getParameter("Date"), request.getParameter("Hotels"), request.getParameter("stayInHotel"));

        for(int i = 0; i<1; i++){
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    doTransaction(customer, "");
                }
            }).start();
        }


        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
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


        String successString = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"  \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html> \n" +
                "<head> \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
                "<title> My first jsp  </title> \n" +
                "</head> \n" +
                "<body> \n" +
                "<center> \n" +
                "<font size=\"10px\" color=\"#00DD00\">" +
                "Transaction Successfully Completed" +
                "</font> \n" +
                "</center> \n" +
                "</body> \n" +
                "</html>";

        String failedString =  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"  \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html> \n" +
                "<head> \n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
                "<title> My first jsp  </title> \n" +
                "</head> \n" +
                "<body> \n" +
                "<center> \n" +
                "<font size=\"10px\" color=\"#DD0000\">" +
                "Transaction Failed" +
                "</font> \n" +
                "</center> \n" +
                "</body> \n" +
                "</html>";

        if(resulst == 1)
            out.println(successString);
        else out.println(failedString);


    }*/

}
