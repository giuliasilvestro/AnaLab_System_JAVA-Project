/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaccia;
import java.io.*;
/**
 *
 * @author giuliasilvestro
 */

class Input {
    public static String leggiStringa() {
        String s =new String();
        try{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(r);
        s =in.readLine();
        }
        catch (IOException e){
            System.out.println("hai letto una stringa vuota");
        }
        return s;
    }
    public static int leggiIntero() {
        String s = leggiStringa();
        return Integer.parseInt(s);
    }
    public static float leggiFloat() {
        String s = leggiStringa();
        return Float.parseFloat(s);
    }
      public static double leggiDouble() {
        String s = leggiStringa();
        return Double.parseDouble(s);
    }
 } 