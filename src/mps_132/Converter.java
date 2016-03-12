/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mps_132;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Converter {
    private static Scanner read;
    
    public static void toBigEndian(String input) throws FileNotFoundException {
        read = new Scanner(new File(input));
        ArrayList<Object> big_endian;
        big_endian = new ArrayList<>();
        System.out.println("\nBig Endian:\n");
        while(read.hasNext()){
            String tmp = read.nextLine();
            if (tmp.matches("[0-9]+")){
                processInteger(big_endian,Integer.parseInt(tmp));
            }
            else{
                processString(big_endian,tmp.toCharArray());
                addZeros(big_endian);
            }       
         
            addZeros(big_endian);
        }
        print(big_endian);
    }
    
    public static void toSmallEndian(String input) throws FileNotFoundException {
        read = new Scanner(new File(input));
        ArrayList<Object> small_endian;
        small_endian = new ArrayList<>();
        System.out.println("\nSmall Endian:\n");
        while(read.hasNext()){
            String tmp = read.nextLine();
            if (tmp.matches("[0-9]+")){
                processInteger(small_endian,Integer.parseInt(tmp));
            }
            else{
                processStringSmallEndian(small_endian,tmp);
                addZeros(small_endian);
            }       

            addZeros(small_endian);
        }
        print(small_endian);
    }

    //32 bit representation of integer
    private static void processInteger(ArrayList<Object> endian, int input) {
        ArrayList x = new ArrayList();
        String bin = toBinary(input);
        ArrayList<Integer> BitRep = to32bitRep(bin);
        for(int i=0; i<BitRep.size(); i++){
            endian.add(BitRep.get(i));
        }
    }
    
    private static String toBinary(int input){
        String bin = "";
        String zeros = "";
        StringBuilder binary = new StringBuilder();
        int tmp = input;
        while(tmp > 0){
            bin += String.valueOf(tmp%2);
            tmp = tmp/2;
        }
        binary.append(bin);
        binary = binary.reverse();
        for(int i = 32 - binary.length(); i>0; i--){
            zeros += "0";
        }
        return zeros+binary;
    }
    
    //converts binary to 32 bit representation of array
    private static ArrayList<Integer> to32bitRep(String output){
        ArrayList<Integer> arr = new ArrayList<>();
        int start = 0;
        int end = 8;
        while(end <= 32){
            arr.add(toInt(output.substring(start, end)));
            start += 8;
            end += 8;
        }
        return arr;
    }
    
    private static Integer toInt(String binary) {
        int ans = 0;
        int two = 1;
        StringBuilder tmp = new StringBuilder();
        tmp.append(binary);
        tmp = tmp.reverse();

        for(int i=0; i<tmp.length(); i++){
            ans += Character.getNumericValue(tmp.charAt(i))*two;
            two *= 2;
        }
        return ans;
    }
    
    private static void processString(ArrayList<Object> endian,char[] array) {
        for(int j=0; j<array.length; j++){
            endian.add(array[j]);
        }
        addZeros(endian);
    }
    
    private static void processStringSmallEndian(ArrayList<Object> endian,String tmp) {
        //insert sht here
        String reversed = "";
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end = 4;
        for(int i = 0; i < tmp.length()/4; i++){
            builder.append(tmp.substring(start, end));
            builder = builder.reverse();
            reversed += builder;
            start += 4;
            end += 4;
            builder.delete(0, builder.length());
        }
        String last = tmp.substring(4*(tmp.length()/4),tmp.length());
        while(last.length()<4){
            last += "0";
        }
        builder.append(last);
        builder = builder.reverse();
        reversed += builder;
        processString(endian,reversed.toCharArray());
    }
    
    private static void print(ArrayList<Object> endian) {
       
        for(int i = 0; i < endian.size(); i++){
            System.out.print(endian.get(i) + "\t");
            if((i+1)%4==0){
                System.out.println("");
            }
        }
    }

    private static void addZeros(ArrayList<Object> endian) {
        while(endian.size()%4!=0)
            endian.add("0");
    }
}