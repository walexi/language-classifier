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
public class CounterArray {
    
    private char letter;
    private int count;
    private double freq;

    public CounterArray(char letter, int count, double freq) {
        this.letter = letter;
        this.count = count;
        this.freq = freq;
    }

    
    public void setFreq(double freq) {
        this.freq = freq;
    }

    public double getFreq() {
        return freq;
    }

    
    public char getLetter() {
        return letter;
    }

    public int getCount() {
        return count;
    }

    
    public void countIncrease(){
        count++;
    }

    
}
