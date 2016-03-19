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
public class HammingDistance {
    public static void main(String[] args) throws FileNotFoundException {
        String input;
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter data bits:");
        input = scan.nextLine();
        
        System.out.print("\nMenu \n1.Odd Parity \n2.Even Parity \n\nChoice: ");
        choice = scan.nextInt();
        
        boolean hasNoError = checkCodeword(input,1);
        if(hasNoError)
            System.out.println("\nCodeword has no error.");
        else
            System.out.println("\nCodeword has error.");
    }
    
     public static boolean checkCodeword(String input, int parity) throws FileNotFoundException{
        ArrayList<String> binary = toBinary(input);
        int two = 1;
        int index = binary.get(0).length(); //index sa binary strings
        
        for(int i=0; i<input.length(); i++){
            if(i==(two-1)){
                int ctr=0;
                char cb;
                
                for(int j=0; j<binary.size(); j++){
                    String tmp = binary.get(j);
                    if(tmp.charAt(index-1) == '1')
                        ctr++;
                }
                
                if(parity == 1){
                    cb = ctr%2==0 ? '1' : '0';
                }
                else {
                    cb = ctr%2==0 ? '0' : '1';
                }
                
                if(cb!=input.charAt(i)){
                    return false; //pwede ra pd iprint tanan naay errors here
                }
                
                two*=2;
                index--;
            }
        }
        return true;
    }
    
    private static ArrayList<String> toBinary(String codeword) {
        ArrayList<String> binary = new ArrayList<>();
        int two = 1;
        int count = 0;
        
        for(int i=0; i<codeword.length();i++){
            if(i!=(two-1)){
                binary.add(Integer.toBinaryString(i+1));
            }
            else{
                count++;
                two*=2;
            }
        }
        
        for(int i=0; i<binary.size();i++){
            String tmp = binary.get(i);
            String zero = "";
            while (zero.length() != (count-tmp.length())){
                zero += "0";
            }
            tmp = zero+tmp;
            binary.set(i, tmp);
        }
        return binary;
    }
    
}
