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

public class MP1 {
    private static Scanner read;
    private static String input;
    private static ArrayList<Object> inputs;
    private static ArrayList<Object> big_endian;
    private static ArrayList<Object> small_endian;
    
    public static void main(String[] args) throws FileNotFoundException {
        inputs = new ArrayList<>();
        big_endian = new ArrayList<>();
        small_endian = new ArrayList<>();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name:");
        input = scan.nextLine();
        read = new Scanner(new File(input));
        
        toBigEndian();
        toSmallEndian();
        printBigEndian();
        printSmallEndian();
    }

    private static void toBigEndian() {
        while(read.hasNext()){
            String tmp = read.nextLine();
            inputs.add(tmp);
            if (tmp.matches("[0-9]+")){
                processInteger(Integer.parseInt(tmp));
            }
            else{
                processString(tmp.toCharArray());
                addZeros();
            }       
         
            addZeros();
        }
    }
    
     private static void processInteger(int input) {
        ArrayList x = new ArrayList();
        if (input>=100){
            while(input > 0){
                x.add(input%100);
                input/=100;
            }
        }
        else
            x.add(input);
        
        Collections.reverse(x);

        for(int j=0; j<(4-x.size()); j++){
            big_endian.add("0");
        }

        for(int k=0; k<x.size(); k++){
            big_endian.add(x.get(k));
        }
    }

    private static void processString(char[] array) {
        for(int j=0; j<array.length; j++){
            big_endian.add(array[j]);
        }
        addZeros();
    }
    
    private static void toSmallEndian() {
        ArrayList cloned = (ArrayList) big_endian.clone();
        int start = 0;
        int end = 4;
        for(int i=0; i<inputs.size();i++)
            System.out.println(inputs.get(i));
        System.out.println("\n");
        
        while(end <= big_endian.size()){
            boolean flag = false;
            List<Object> tmp = cloned.subList(start, end);

            for(int i=0; i<tmp.size(); i++){
                String tmp2 = String.valueOf(tmp.get(i));
                if (tmp2.matches("[a-zA-Z]+")){
                   flag = true;
                }
            }
            if (flag == true)
                Collections.reverse(tmp);
            else{
                //copy contents of tmp to tmp2 for checking purposes
                List tmp2 = new ArrayList();
                for(int i=0; i<tmp.size();i++)
                    tmp2.add(tmp.get(i));
                
                tmp2.removeAll(Arrays.asList("0"));
                String a = "";
                for(int i=0; i<tmp2.size();i++){
                    a +=  tmp2.get(i);
                }
                
                if(!inputs.contains(a))
                    Collections.reverse(tmp);
                
            }
            small_endian.addAll(Arrays.asList(tmp));
            
            start+=4;
            end+=4;
       }
    }
    
    private static void printBigEndian() {
        System.out.println("\nBig Endian:\n");
        for(int i = 0; i < big_endian.size(); i++){
            System.out.print(big_endian.get(i) + "    ");
            if((i+1)%4==0){
                System.out.println("");
            }
        }
    }

    private static void addZeros() {
        while(big_endian.size()%4!=0)
            big_endian.add("0");
    }

    private static void printSmallEndian() {
        System.out.println("\nSmall Endian:\n");
        for(int i = 0; i < small_endian.size(); i++){
            List tmp = (List) small_endian.get(i);
            for(int j = 0; j < tmp.size(); j++)
                System.out.print(tmp.get(j) + "    ");
            System.out.println("");
        }
    }
}