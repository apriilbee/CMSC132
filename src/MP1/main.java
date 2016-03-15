/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author April Dae Bation
 */

public class main {
    private static String input;
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name:");
        input = scan.nextLine();
        
        execute();
    }
    
    public static void execute() throws FileNotFoundException{
        Converter.toBigEndian(input);
        Converter.toSmallEndian(input);
    }
    
}