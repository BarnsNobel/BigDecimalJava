/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utilities;

import java.io.File;

/**
 *
 * @author steph
 */
public class Utilities {
    public Utilities() {
        //test bed
        /*BigDec test = new BigDec(Math.PI);
        System.out.println(test.toString().length());
        BigDec test2 = test.times(test);
        System.out.println(test2);*/
        
        ColorCodeWrapper wrapper = new ColorCodeWrapper();
        wrapper.run();
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilities ut = new Utilities();
    }
    
}
