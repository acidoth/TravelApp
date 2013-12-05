package util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pirinthapan
 * Date: 11/27/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class XmlLoader {

    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser;

    public XmlLoader() {

        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        DefaultHandler handler = new DefaultHandler(){

            boolean isCoordinatorAddress = false;
            boolean isActivationport = false;
            boolean isCompletionport = false;
            boolean isputAddress1 = false;
            boolean isputAddress2 = false;

            public void startElement(String uri, String localName,String qName,
                                     Attributes attributes){

                if(qName.equalsIgnoreCase("address"))
                    isCoordinatorAddress = true;

                if (qName.equalsIgnoreCase("activationport"))
                    isActivationport = true;

                if (qName.equalsIgnoreCase("completionport"))
                    isCompletionport = true;

                if (qName.equalsIgnoreCase("putaddress1"))
                    isputAddress1 = true;

                if (qName.equalsIgnoreCase("putaddress2"))
                    isputAddress2 = true;

            }


            public void endElement(String uri, String localName,
                                   String qName){

            }


            public void characters(char ch[], int start, int length){

                if(isCoordinatorAddress){
                    Constants.coordinatorServerAddress = new String(ch, start, length);
                    System.out.println("Coordinator server address : " + Constants.coordinatorServerAddress);
                    isCoordinatorAddress = false;
                }

                if(isActivationport) {
                    Constants.activationPort = Integer.parseInt(new String(ch, start, length));
                    System.out.println("Activation port : " + Constants.activationPort);
                    isActivationport = false;
                }

                if(isCompletionport) {
                    Constants.completionPort = Integer.parseInt(new String(ch, start, length));
                    System.out.println("Completion port : " + Constants.completionPort);
                    isCompletionport = false;
                }

                if (isputAddress1){
                    Constants.putAddress1 = new String(ch, start, length);
                    System.out.println("Put address of participant 1 : " + Constants.putAddress1);
                    isputAddress1 = false;
                }

                if(isputAddress2){
                    Constants.putAddress2 = new String(ch, start, length);
                    System.out.println("Put address of participant 2 : " + Constants.putAddress2);
                    isputAddress2 = false;
                }

            }

        };

        try {

            saxParser.parse(System.getProperty("user.dir") + "/Constants", handler);

        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
