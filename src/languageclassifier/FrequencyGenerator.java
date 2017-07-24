/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageclassifier;

/**
 *
 * @author olawale
 */
public class FrequencyGenerator {
    
    private static CounterArray[] ca;
    private static String filename;
    private static int numberofLang;
    private static int numOfTrainingPatterns;
    private static int expectedResult;
    public FrequencyGenerator(String filename,int result, int numberOfLang, int numOfTrainingFiles) {
        this.filename = filename;
        this.numberofLang = numberOfLang;
        this.numOfTrainingPatterns = numOfTrainingFiles;
        this.expectedResult = result;
        ca = new CounterArray[26];
        for(int row=0;row<26;row++){
            ca[row] = new CounterArray((char)('A'+row), 0,0);
        }
        
    }
    
    public void generateFile(){
        countLetters(FileTools.readFile(filename));
        generateFreq();
        FileTools.writeOutFile("output.txt");
        System.out.println(numOfTrainingPatterns + " " + 26 +" "+numberofLang);
        for(int k=0;k<26;k++){
            System.out.print(ca[k].getFreq() + " ");
        }
        System.out.printf("/n" + expectedResult);

    }
    
    public static void countLetters(StringBuilder sb){
            String str  = sb.toString().toUpperCase();
        int length = str.length();
    
       for(int k=0;k<length;k++){
           int check = str.charAt(k);
           if(check>='A'&& check<='Z'){
               ca[check - 'A'].countIncrease();
           }
       }
    }
    
    public static void generateFreq(){
           int charTotalCount = 0;
        for(int k=0;k<26;k++){
                charTotalCount = charTotalCount+ca[k].getCount();
            }
        System.out.println(charTotalCount);
         for(int k=0;k<26;k++){
             ca[k].setFreq((double)ca[k].getCount()/charTotalCount); 
         }
    }
       
    
    
}


