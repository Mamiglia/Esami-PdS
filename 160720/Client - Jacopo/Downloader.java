
import java.util.logging.*;
import java.util.Scanner;
import java.util.logging.Level;
import javax.swing.JTextArea;


public class Downloader implements Runnable{

    
    private Scanner scan;
    private JTextArea text;
    private boolean run;
    private String string;
    
    private Logger logger = java.util.logging.Logger.getLogger("DOWNLOADER");

    public Downloader(Scanner scan, JTextArea t){
        this.scan = scan;
        text = t;
    }
    
    public void run() {
        
        
        logger.log(Level.INFO,"downloading...");
        run = true;
        while(scan.hasNext() && run){
            string = scan.nextLine();
            if(string.equals("END") || string.equals("file not found")){
                System.out.println("string recived: "+ string);
                run = false;
                break;
            }
            System.out.println(string);
            text.append(string);
            
        }

        
        logger.log(Level.INFO, "dowload is finish");
    }
    
    public void stop() {
        run = false;
    }
}

//while(scan.hasNext() && run ){
//            string = scan.nextLine();
//            if(string == "END") break;
//            System.out.println(string);
//            text.append(string);
//            
//        }


 
//        string = scan.nextLine();
//        while(string != "END"){
//            System.out.println(string);
//            text.append(string);
//        }