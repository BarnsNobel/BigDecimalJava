package utilities;


import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Formally known as the Color Code Barns Nobel, The Barns Wallow Collective
 * @author Barns Noble, marked as Public Domain
 */
//work method slow and methodical
//hate rush jobs as they lead to sloppy code
//BARNS E NOBEL (nom de plume)
//Legal Name: Stephen A. Wilson, formerly of 27 Eastbrook Way Brooks Ab T1R 0H7
//for you consideration and use
//I own this code.
//I want to work at google in order to write amazing code with an amazing team
//with people who are in the same league as i am in order that I might operate
//at my fullest potential and find my place in the universe.
//Stephen A. Wilson - Barns Nobel(will now use this name as a marker on my code)
//decrypt to be seperate class
//six month project 
public class TheColorZip {
    int colorCode = 0;
    long red = 0;
    long green = 0;
    long blue = 0;
    long alpha = 0;
    
    int x = 0;
    int y = 0;
    BufferedImage output = null;
    int compressedData = 0;
    //do not change this
    int compressionFactor = 3;
    int compressionCount = 0;
    File toEncode = null;
    int buffersize = 1000;
    long[] compressionBuffer = new long[buffersize];
    
    //
    /**
     * An obvious form of stenography using png format (trying to output to jpg will fail)
     * Instanciate class and call getEncodedImage();
     * @param tobeEncodedInImage input file
     * @throws IOException if there is a problem (ie not a data file or cant be read)
     */
    public TheColorZip(File fileTobeEncoded) throws IOException {
        toEncode = fileTobeEncoded;
        colorCodeCompression(toEncode);
        
    }
    
    /**
     * 
     * @param tobeEncodedInImage
     * @throws IOException 
     */
    public void colorCodeCompression(File tobeEncodedInImage) throws IOException {
        toEncode = tobeEncodedInImage;
        
        //test and fail improper input(file and outDir;
        int byteCount = 0;
        int testByte = 0;
        FileReader reader = new FileReader(toEncode);
        while (testByte != -1) {
            testByte = reader.read();
            byteCount++;
        }
        reader.close();
        reader = new FileReader(toEncode);
        byteCount = byteCount/buffersize;
        int size = byteCount;
        
        int square = (int) Math.sqrt((double)size);
        square = square+square/10;
        if (square == 0) {
            square = 32+8;
        }
        System.out.println(square);
        output = 
                new BufferedImage(square,square,BufferedImage.TYPE_4BYTE_ABGR);
        int input = reader.read();
        
        while (input != -1) {
            
                
                encodeCompression(input);
                input = reader.read();
            
            
        }
        
        reader.close();
        
        //constructor(tobeEncodedInImage);
    }
    
    public BufferedImage getEncodedImage() {
        return output;
    }    
    
    //important bit <------>
    
    public void writePixel() throws IOException {
        //writes a pixel to stored image
        WritableRaster raster = output.getRaster();
        int[] pix = new int[]{(int)red,(int)green,(int)blue,(int)alpha};
        raster.setPixel(x, y, pix);
        red = 0;
        green = 0;
        blue = 0;
        alpha = 0;
        
        //System.out.println("x = "+x+ "y = "+y);
        x++;
        if (x == output.getWidth()) {
            x = 0;
            y++;
            if (y == output.getHeight()) {
                throw new IOException("Data is Corrupted, or Out of Range.");
            }
        }
    }
    
    
    
    public int countCompress  = 0;
    int countTest = 0;
    public void encodeCompression(int dataPoint) throws IOException {
        
        if (countTest < 2) {
            if (countCompress >= buffersize) {
                compressIntegerData();
                countCompress = 0;
                countTest++;
                //System.exit(0);
            } else {
                compressionBuffer[countCompress] = (long) dataPoint;
            }
            countCompress++;
        } else {
            System.exit(0);
        }
         
    }
    //Cutting Edge copyrights reserved Barns Nobel 2023
    //public long data = 0;
    long scale = 255*255;
    public void compressIntegerData() throws IOException {
        //int lifted = dataPoint+3;
        //Long.parseLong(""+factor+""+(testArray[i]));
        long[] outArrayBuffer = new long[10];
        //Random rand = new Random(dataPoint);
        BigDecimal data = new BigDecimal(1.0);
        int factor = 100001;
        for (int i = 0;i < compressionBuffer.length-50;i++) {
            //System.out.println("IN: "+ compressionBuffer[i]);
            long in = compressionBuffer[i]+3;
            long num = 0;
            ///take care of pesky nums
            if (in < 0) {
                in = in*-1;
            }
            num = Long.parseLong(""+factor+""+(in));
            //System.out.println(num);
            
            data = data.multiply(data);
            System.out.println("Num IN: "+ num);
            
            factor++;
            factor++;
            
        }
        
    
        //System.out.println();
        //System.out.println(data);
        
        if ((int) red != red) {
            throw new IOException("red outPut value out of range: "+red);
        }
        if ((int) green != green) {
            throw new IOException("green outPut value out of range: "+green);
        }
        if ((int) blue != blue) {
            throw new IOException("blue outPut value out of range: "+blue);
        }
        if ((int) alpha != alpha) {
            throw new IOException("alpha outPut value out of range: "+alpha);
        }
        
        /*red = data/(scale*scale*scale);
        data = data - red*scale*scale*scale;
        green = data/(scale*scale);
        data = data-green*scale*scale;
        blue = data/(scale);
        data = data-blue*scale;
        alpha = data;
        if ((int) red != red) {
            throw new IOException("red outPut value out of range: "+red);
        }
        if ((int) green != green) {
            throw new IOException("green outPut value out of range: "+green);
        }
        if ((int) blue != blue) {
            throw new IOException("blue outPut value out of range: "+blue);
        }
        if ((int) alpha != alpha) {
            throw new IOException("alpha outPut value out of range: "+alpha);
        }*/
        /*alpha = 255;
        red = 255;
        green = 255;
        blue = 255;*/
        //red = r;
        //green = (int) g;
        //blue = (int) b;
        //alpha = (int) a;
        long data2 = red*scale*scale*scale+green*scale*scale+blue*scale+alpha;
        System.out.println(data2);
        
        
        
        System.out.println("r:"+red+" g:"+green+" b:"+blue+" a:"+alpha);
        //writePixel();
        //System.out.println();
        //combonation number needed;
        
        int[] pix = new int[]{(int)red,(int)green,(int)blue,(int)alpha};
        //decrypt
        factor = 10001;
        
        for (int i = compressionBuffer.length-1;i >= 0 ;i--) {
            boolean found = false;
            for (int n = 3;n < 512;n++) {
               
               if (!(found)) {
                   long num = Long.parseLong(""+(factor+i)+""+(n));
                   if (data2%num == 0) {
                       found = true;
                       System.out.println("found: "+num);
                       data2 = data2/num;
                       compressionBuffer[i] = n;
                   }
               }
                       
               
            }
        }
        
        //decompressDataPacket(pix);
        
    }
    public int[] numberCompression(long uncomp ) {
        long data = uncomp;
        long r = data/(scale*scale*scale);
        data = data - r*scale*scale*scale;
        long g = data/(scale*scale);
        data = data-g*scale*scale;
        long b = data/(scale);
        data = data-b*scale;
        long a = data;
        return new int[]{(int) r, (int) g, (int) b, (int) a};
    }
    
    
    public void readImage(File imagefile, File output) {
        
    }
    int[] workingArray = new int[buffersize];
    public void decodeData() {
    
}       
        
            
    

    
    

}
