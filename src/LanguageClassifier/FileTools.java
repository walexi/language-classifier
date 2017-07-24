/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageclassifier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olawale
 */
public class FileTools {
    
    
    public static StringBuilder readFile(String file){
        StringBuilder sb = new StringBuilder();
        List<Integer> chars = new ArrayList<>();
          FileReader fr = null;
        try {
            String str;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while((str=br.readLine())!=null){
                sb.append(str);
            }
        } catch (FileNotFoundException ex) {
                System.out.println("File not found");
        } catch (IOException ex) {
                System.out.println("Empty File");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Empty file");
            }
        }
    
        return sb;
    }
    
    public static void writeOutFile(String outputfile){
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(outputfile));
        } catch (FileNotFoundException ex) {
               System.out.println("Unable to create a new file, pls check if a file with same name exist as a direcotry, or you do not have write permission in the directory");
        }
        
        System.setOut(ps);
        
    
    }
    
}
