/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageclassifier;

import com.googlecode.fannj.Fann;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author olawale
 */
public class LangClassifierEngine {
    
    public static void main(String[] args){
            System.out.println("Pls enter name of file");
            Scanner sc = new Scanner(System.in);
            String filename = sc.next();
            System.out.println("Pls enter number of outputs");
            int outputNum = sc.nextInt();
            System.out.println("pls enter expected output i.e languages for this engine");
            ArrayList<String> langs = new ArrayList<>(outputNum);
            
            for(int i=0;i<outputNum;i++){
                langs.add(sc.next().toLowerCase());
            }
            
            System.out.println("pls enter expected result for this training file");
            String expectedResult = sc.next().toLowerCase();
            int j = langs.indexOf(expectedResult);
            int expectedLangCode;
            while(j==-1){
                System.out.println("pls enter correct answer");
                expectedResult = sc.next().toLowerCase();
                j = langs.indexOf(expectedResult);
            }
             expectedLangCode = j;   
            
            FrequencyGenerator fg = new FrequencyGenerator(filename,expectedLangCode,outputNum,1);
            fg.generateFile();
            
            Fann fn;
    }
    
}
