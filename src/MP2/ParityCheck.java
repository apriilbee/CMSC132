/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP2;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ParityCheck {
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter data bits:");
        input = scan.nextLine();
        
        System.out.print("\nMenu \n1.Odd Parity \n2.Even Parity \n\nChoice: ");
        choice = scan.nextInt();
        
        System.out.println(checkCodeword(input,choice));
            
    }
    
     public static boolean checkCodeword(String input, int parity) throws FileNotFoundException{
        StringBuilder build = new StringBuilder();
        String databits = getDataBits(input);
        String checkbits = getCheckBits(input);
        build.append(input);
        
        int two = 1;
        int error = 0;
        
        boolean hasError = false;
        for(int i=0; i<build.length(); i++){
            char cb;
            if(i==(two-1)){
                int ctr=0;
                int pos = i+1;
                int tmp=pos;
                
                for(int j=pos-1; j<databits.length();){
                    if(tmp!=0){
                        if(databits.charAt(j)=='1')
                            ctr++;
                        tmp--;
                        j++;
                    }
                    else{
                        tmp+=pos;
                        j+=pos;
                    }
                }
                if(parity == 1){ cb = ctr%2==0 ? '1' : '0'; }
                else { cb = ctr%2==0 ? '0' : '1';  }
                
                if(cb != checkbits.charAt(i)){
                    error += pos;
                    hasError = true;
                }
                two*=2;
              
            }
        }
        if(!hasError){
            System.out.println("Data correct");
            return true;
        }
        else {
            System.out.println("\nError at: " + error);
            return false;
        }
    }

    private static String getDataBits(String input) {
        StringBuilder tmp = new StringBuilder();
        String databits = input;
        tmp.append(databits);
        int two = 1;
        
        for(int i=0; i<input.length();i++){
            if(i==(two-1)){
                tmp.replace(i, i+1, "?");
                two*=2;
            }
        }
        return tmp.toString();
    }
    
    private static String getCheckBits(String input) {
        StringBuilder tmp = new StringBuilder();
        String databits = input;
        tmp.append(databits);
        int two = 1;
        
        for(int i=0; i<input.length();i++){
            if(i==(two-1)){
                two*=2;
            }
            else{
                tmp.replace(i, i+1, "?");
            }
        }
        return tmp.toString();
    }
}
