import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: pirinthapan
 * Date: 11/17/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static ArrayList<Process> processesList = new ArrayList<Process>();

    public static void main(String[] args){

        File jarFile = new File("target/travel-jar-with-dependencies.jar");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the time duration of a single Application : ");
        int time = scanner.nextInt();

        System.out.println("Enter the number of applications : ");
        int numberOfApps = scanner.nextInt();

        Process process;

        try {
            for(int i = 0; i< numberOfApps; i++) {
                process = Runtime.getRuntime().exec("java -jar "+ jarFile.getAbsolutePath() + " " + time + " " + i);
                processesList.add(process);
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        Main main = new Main();
        main.exit();
    }


    private void exit(){

        int input = 1;

        while (input != 0) {
        System.out.println("Enter 0 to exit : ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        }

        if(input == 0)
            for(Process process : processesList)
                process.destroy();
    }
}
