/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utilities;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * A Barns Swallow Club project....
 * Credit to Bethany Harmon and Taylor Swift for there inspiration and help.
 * @author Barns Nobel, Marked as public Domain, 2022,2023.....Medicine Hat, AB. 2023.
 */
public class ColorCodeWrapper extends SwingWorker {
    public static JProgressBar progressBar = new JProgressBar();
    //progress mesured in one hundred millionths
    public static long nEnd = Long.MAX_VALUE-1;
    public static long presentValue = 0L;
    private static JLabel label = null;
    private static JFrame frame = null;
    private static boolean stop = false;
    
    
    private void bigCalculations() {
        System.out.println("Caluculations Started.");
        //Enter end value here system will do that many calculations
        //control c to cancel or close the progress window to cancel
        long someEndValue = 1000000000L;
        nEnd = someEndValue;
        
        //cancel();
        //One Hundred MillionCalulations
        for (long i = 0;i < nEnd;i++) {
            presentValue = i;
            percentDone();
            label.setText(""+presentValue+"/"+nEnd);
            //If need output to system tray using println
            //uncomment next line
            //System.out.println(i);
            //Big Calcs Here define start at 0 and end at some end value
            /**
             * documentation here explain what you are doing or attempting to do
             */
            //color code to be processed here
            //could also be use to do multiple files
            //and put them in a zip file;
            
            
            
            
            
            
            
            
            
            if (i == someEndValue) {
                cancel();
                break;
            }
            if (stop) {
                break;
            }
        }
           
           
       
       if (!(stop)) {
            System.out.println("Caluculations Completed.");
       
       } else {
            System.out.println("Caluculations Stopped(cancelled)."); 
       }
    }
    
    
    
    
    
    
    public String doInBackground() {
       
       int min = 0;
       int max = 100;
       
       progressBar.getModel().setMaximum(max);
       progressBar.getModel().setValue(0);
       
       frame = new JFrame();
       frame.setTitle("Progress");
       //frame.setUndecorated(true);
       JPanel panel = new JPanel();
       panel.add(progressBar);
       label = new JLabel(""+presentValue+"/"+nEnd);
       panel.add(label);
       frame.setContentPane(panel);
       frame.setSize(new Dimension(400,80));
       GraphicsConfiguration gc = frame.getGraphicsConfiguration();
       Rectangle rect = gc.getBounds();
       frame.setLocation(rect.width/2-frame.getWidth()/2,rect.height/2-frame.getHeight()/2);
       frame.setVisible(true);
       
       WindowAdapter winList = new WindowAdapter(){
           public void windowClosing(WindowEvent we) {
               cancel();
               
           }
           public void windowClosed(WindowEvent we) {
               cancel();
               
           }
       }; 
       frame.addWindowListener(winList);
       KeyAdapter keyList = new KeyAdapter(){
           public void keyPressed(KeyEvent ke) {
               if ((ke.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) && ((ke.getKeyCode() == KeyEvent.VK_C))) {
                  cancel();
                  stop = true;
                  
               }
           }
       };
       frame.addKeyListener(keyList);
        bigCalculations();
        return "done";
    }
    public void start() {
        doInBackground();
    }
    
    
    private static void percentDone() {
        double max  = (double) nEnd;
        double min  = (double) 0;
        double present = (double) presentValue;
        
         progressBar.getModel().setValue((int) ((present)/(max-min)*100.0));
        //progressBar.getModel().setValue(50);
        //progressBar.validate();
    }
    
    private static void cancel() {
        stop = true;
        presentValue = nEnd;
    }
    
    public void done() {
        System.out.println("Process Completed.");
        System.exit(0);
    }
}
