/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class check {
    public static void main(String[] args) {
        StringBuilder build = new StringBuilder();
        build.append("??1?101?1010");
        
        
        for(int i=0; i<build.length(); i++){
            if(build.charAt(i)=='?'){
                int ctr=0;
                int pos = i+1;
                System.out.println(pos);
                int tmp=pos;
                for(int j=pos-1; j<build.length();){
                    if(tmp!=0){
                        System.out.print(build.charAt(j));
                        if(build.charAt(j)=='1')
                            ctr++;
                        tmp--;
                        j++;
                    }
                    else{
                        tmp+=pos;
                        j+=pos;
                    }
                }
                System.out.println(ctr);
                System.out.println("");
            }
        }
    }
}
