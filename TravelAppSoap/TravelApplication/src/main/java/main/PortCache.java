package main;

import server.activation.ActivationService;
import server.activation.ActivationServiceImplService;
import server.completion.CompletionService;
import server.completion.CompletionServiceImplService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 12/2/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PortCache {

    private static final int CACHE_MAX_SIZE = 100;
    private static LinkedHashMap<String, ActivationService> activationPortCache;
    private static LinkedHashMap<String, CompletionService> completionPortCache;

    public PortCache(){

        activationPortCache = new LinkedHashMap<String, ActivationService>(CACHE_MAX_SIZE, 0.75f, true){
            protected boolean removeEldestEntry(
                    Map.Entry<String, ActivationService> eldest) {
                // Remove the eldest entry if the size of the cache exceeds the
                // maximum size
                return size() > CACHE_MAX_SIZE;
            }
        };

        completionPortCache = new LinkedHashMap<String, CompletionService>(CACHE_MAX_SIZE, 0.75f, true){
            protected boolean removeEldestEntry(
                    Map.Entry<String, CompletionService> eldest) {
                // Remove the eldest entry if the size of the cache exceeds the
                // maximum size
                return size() > CACHE_MAX_SIZE;
            }
        };

    }

    public ActivationService getActivationServicePort(String address){

        ActivationService activationService = activationPortCache.get(address);

        if(activationService != null){
            return activationService;
        }
        else {
            activationService = createActivationServicePort(address);
            activationPortCache.put(address, activationService);
            return activationService;
        }
    }

    private ActivationService createActivationServicePort(String address){

        ActivationServiceImplService service = null;
        try {
            service = new ActivationServiceImplService(new URL(address));
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ActivationService activationService = service.getActivationServiceImplPort();

        return activationService;
    }

    public CompletionService getCompletionServicePort(String address){
        CompletionService completionService = completionPortCache.get(address);

        if(completionService != null){
            return completionService;
        }
        else {
            completionService = createCompletionServicePort(address);
            completionPortCache.put(address, completionService);
            return completionService;
        }
    }

    private CompletionService createCompletionServicePort(String address){
        CompletionServiceImplService service = null;
        try {
            service = new CompletionServiceImplService(new URL(address));
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        CompletionService completionService = service.getCompletionServiceImplPort();

        return completionService;
    }
}
