/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utilities;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * A Barns Swallow Club project....
 * Credit to Bethany Harmon and Taylor Swift for there inspiration and help.
 * @author Barns Nobel, Marked as public Domain, 2022,2023.....Medicine Hat, AB. 2023.
 */
public class BigDec extends BigDecimal {
    /*public static bigDec pi = new bigDec(Math.PI);
    public static bigDec one = new bigDec(1.0);
    public static bigDec ten = new bigDec(10.0);
    public static bigDec oneEighty = new bigDec(Math.PI/2.0);*/
    
    
    public BigDec(long val){
       super(""+val+"000000000000000000000000000000000000000000000000000"
               + "00000000000000000000000000000001"); 
    }
    public BigDec(double val){
       super(""+val+"000000000000000000000000000000000000000000000000000"
               + "00000000000000000000000000000001");  
       
    }
    public BigDec(float val){
       super(""+val+"000000000000000000000000000000000000000000000000000"
               + "00000000000000000000000000000001"); 
    }
    public BigDec(int val){
       super(""+val+"000000000000000000000000000000000000000000000000000"
               + "00000000000000000000000000000001"); 
    }
    
    public BigDec(String val) {
        super(val);
    }
    
    public String toString() {
        return super.toString();
    }
    
    /**
     * 
     * @param val
     * @return 
     */
    public BigDec times(BigDec bd) {
        return new BigDec((new BigDecimal(bd.toString())
                .multiply(new BigDecimal(bd.toString()))).toString().
                substring(0,167)+"1");
    }
    
    public BigDecimal times(int val) {
        return new BigDecimal(val).multiply(this);
    }
    
    public BigDecimal times(double val) {
        return new BigDecimal(val).multiply(this);
    }
    
    public BigDecimal times(long val) {
        return new BigDecimal(val).multiply(this);
    }
    
    public BigDecimal times(float val) {
        return new BigDecimal(val).multiply(this);
    }
    public BigDecimal times(BigDecimal val) {
        return this.multiply(val);
    }
    public BigDecimal div(int val) {
        return this.divide(new BigDecimal(val));
    }
    
    public BigDecimal div(double val) {
        return this.divide(new BigDecimal(val));
    }
    
    public BigDecimal div(long val) {
        return this.divide(new BigDecimal(val));
    }
    
    public BigDecimal div(float val) {
        return this.divide(new BigDecimal(val));
    }
    public BigDecimal div(BigDec val) {
        return this.divide(val);
    }
    
    public BigDecimal plus(BigDecimal val) {
        return this.add(val);
    }
    
    public BigDecimal plus(int val) {
        return this.add(new BigDecimal(val));
    }
    
    public BigDecimal plus(double val) {
        return this.add(new BigDecimal(val));
    }
    
    public BigDecimal plus(long val) {
        return this.add(new BigDecimal(val));
    }
    
    public BigDecimal plus(float val) {
        return this.add(new BigDecimal(val));
    }
    public BigDecimal minus(BigDecimal val) {
        return this.subtract(val);
    }
    public BigDecimal minus(int val) {
        return this.subtract(new BigDecimal(val));
    }
    
    public BigDecimal minus(double val) {
        return this.subtract(new BigDecimal(val));
    }
    
    public BigDecimal minus(long val) {
        return this.subtract(new BigDecimal(val));
    }
    
    public BigDecimal minus(float val) {
        return this.subtract(new BigDecimal(val));
    }
    public void setPrecison(int scale) {
        
    }
    
}
