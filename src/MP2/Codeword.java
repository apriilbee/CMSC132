/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Codeword {
    //input: databits
    //output: databits + check bits
    
    
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        int choice;
        boolean success;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter data bits:");
        input = scan.nextLine();
        
        System.out.print("\n\nMenu \n1.Odd Parity \n2.Even Parity \n\nChoice: ");
        choice = scan.nextInt();
        
        success = choice==1 ? execute(input,1): execute(input,2);
        //work on execute
        
    }
    public static boolean execute(String input, int parity) throws FileNotFoundException{
        String codeword = initializeCheckbits(input);
        codeword = addCheckBits(input,codeword, parity);
        //work on addcheckbits
        return true;
    }

    private static String initializeCheckbits(String input) {
        int two = 1;
        StringBuilder build = new StringBuilder();
        int length = input.length();
        
        build.append(input);
        
        while(two<=length){
            build.insert(two-1, " ");
            two*=2;
        }
        
        String codeword = build.toString();
        return codeword; 
    }

    private static String addCheckBits(String input, String codeword, int parity) {
        //convert index to very binary
        for(int i=0; i<codeword.length();i++){
            if(codeword.charAt(i)==' '){
                //check all very binary. if 1, change checkbit to 0 or 1
            }
                
        }
        return codeword;
    }

   
    
    
    

    
    
}
