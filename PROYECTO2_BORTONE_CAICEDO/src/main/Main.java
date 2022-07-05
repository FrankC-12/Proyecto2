/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import Controller.Controller;
import Controller.ReadFile;
/**
 *
 * @author giubo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadFile reader = new ReadFile();
        Summary resumen= reader.readFile();
        HashTable nuevo = new HashTable();
        System.out.println(resumen.getTittle().getClass());
        System.out.println(nuevo.hashCode(resumen.getTittle()));
       
        
    }
    
}
