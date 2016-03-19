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
public class Codeword {
    //input: databits
    //output: databits + check bits
    
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter data bits:");
        input = scan.nextLine();
        
        System.out.print("\nMenu \n1.Odd Parity \n2.Even Parity \n\nChoice: ");
        choice = scan.nextInt();
        
        if (choice == 1)
            execute(input,1);
        else
            execute(input,2);
    }
    
    public static String execute(String input, int parity) throws FileNotFoundException{
        String codeword = initializeCheckbits(input);
        codeword = addCheckBits(input,codeword, parity);
        System.out.println("\nCodeword:" + codeword);
        return codeword;
    }
    
    /*
        adds space for check bits to powers of two that can fit in string
    */
    private static String initializeCheckbits(String input) {
        int m = input.length();
        int r = 0;
        
        // m + r + 1 <= 2^r
        while((m+r)>Math.pow(2, r)){
            r++;
            System.out.println("m+r:" + (m+r) + "\tmathpow:" + Math.pow(2, r));
        }
        
        int length = m+r;
        StringBuilder build = new StringBuilder();
        while(build.length()<length){
            build.append(" ");
        }
        
        int two = 1;
        for(int i=0,j=0; i<build.length();i++){
            if((two-1)==i){
                two*=2;
            }
            else{
                build.replace(i, i+1, String.valueOf(input.charAt(j)));
                j++;
                if(j>=input.length())
                    break;
            }    
        }
        
        return build.toString(); 
    }

    /*
        adds check bits according to parity
    */
    private static String addCheckBits(String input, String codeword, int parity) {
        StringBuilder build = new StringBuilder();
        ArrayList<String> binary = toBinary(codeword);
        
        int index = countCheckbits(codeword);
        build.append(codeword);
        
        for(int i=0; i<codeword.length(); i++){
            if(codeword.charAt(i) == ' '){
                int ctr=0;
                String cb;
                
                for(int j=0; j<binary.size(); j++){
                    String tmp = binary.get(j);
                    if(tmp.charAt(index-1) == '1')
                        ctr++;
                }
                
                if(parity == 1){cb = ctr%2==0 ? "1" : "0";}
                else{cb = ctr%2==0 ? "0" : "1";}
                
                build.replace(i, i+1, cb);
                index--;
            }
        }
        return build.toString();
    }

    private static ArrayList<String> toBinary(String codeword) {
        ArrayList<String> binary = new ArrayList<>();
        int checkbits = countCheckbits(codeword);
        
        for(int i=0; i<codeword.length();i++){
            if(codeword.charAt(i)!=' ')
                binary.add(Integer.toBinaryString(i+1));
        }
        
        for(int i=0; i<binary.size();i++){
            String tmp = binary.get(i);
            String zero = "";
            while (zero.length() != (checkbits-tmp.length())){
                zero += "0";
            }
            tmp = zero+tmp;
            binary.set(i, tmp);
        }
        return binary;
    }
    
    private static int countCheckbits(String codeword){
        int cb = 0;
        for(int i=0; i<codeword.length();i++){
            if(codeword.charAt(i)==' ')
                cb++;
        }
        return cb;
    }
}