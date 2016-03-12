/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mps_132;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        Converter converter = new Converter();
        converter.toBigEndian(input);
        converter.toSmallEndian(input);
    }
    
}