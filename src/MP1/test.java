/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        int input = 1000000;
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
        String output = zeros+binary;
        ArrayList<Integer> arr = new ArrayList<>();
        
        
        int start = 0;
        int end = 8;
        
        while(end <= 32){
            System.out.println(output.substring(start,end));
            arr.add(toInt(output.substring(start, end)));
            start += 8;
            end += 8;
        }
        System.out.println(arr.toString());
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
}
