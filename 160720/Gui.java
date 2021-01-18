import java.awt.*;
import static java.lang.String.valueOf;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Gui extends JFrame{
    private JFrame mainFrame;

    private JPanel menu;
    
    private JButton startServer;
    private JButton closeServer;
    
    private Listener listener = new Listener(this);
    private Logger logger = Logger.getLogger("Gui");
    
    public Gui(){
        //inizializzi Frame e metto listener
         createObject();
         
         menu.add(startServer); 
         menu.add(closeServer); 

         mainFrame.add(menu,BorderLayout.NORTH);
         
        
     //faccio listener
        startServer.setActionCommand("START");  startServer.addActionListener(listener);
        closeServer.setActionCommand("CLOSE");  closeServer.addActionListener(listener);

        startServer.setEnabled(true);
        closeServer.setEnabled(false);
        
        functionPack();
        
    }
    
    public void buttons(boolean run){
        if(run == true){
            startServer.setEnabled(false);
            closeServer.setEnabled(true);
        }
        else if(run == false){
            startServer.setEnabled(true);
            closeServer.setEnabled(false);
        }
        
    }
    
    //inizializzo oggetti
    private void createObject(){
        mainFrame = new JFrame("tris");
        menu = new JPanel();
        closeServer = new JButton("close server");
        startServer = new JButton("start server");
        
        
    }
    
    //funzioni per visualizzazione grafica
    private void functionPack(){
        mainFrame.setTitle("SERVER");
        mainFrame.pack();
        mainFrame.setLocation(1430,550);
        mainFrame.setSize(300,100);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
