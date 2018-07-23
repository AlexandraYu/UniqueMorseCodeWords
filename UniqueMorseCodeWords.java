import java.util.HashMap;
import java.util.HashMap;
public class UniqueMorseCodeWords{
    public int uniqueMorseRepresentations(String[] words) { 
	    //given Morse code for each small letter a-z
        String[]  morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //create this string for easier storage later on
		String letters="abcdefghijklmnopqrstuvwxyz";
		//concactnation of several letters' Morse translation for a word
		String morseTranslate =""; 
        int count=0; 
        HashMap<Character, Integer> letterMap = new HashMap<Character, Integer>(); //for storing each letter a-z as a key in the map 
        HashMap<String, Integer> morseMap = new HashMap<String, Integer>(); //storing each word's Mores representation
        for (int i=0; i<letters.length(); i++) { //put all these 26 letters into map as the 26 keys
            letterMap.put(letters.charAt(i), i); 
        }
        
        for(String word : words) { //for each word in the input String array
            System.out.print("word is: "+word+"\n");
            for (int i=0; i<word.length(); i++)  { //for here we're trying to see what each character in the word is represented by the Morse code 
                char key=word.charAt(i); //now we use this character as the key for the letterMap to find its value, and use this value as the index for morseCode String array
                System.out.print("key is: "+key+"\n");
                System.out.print("on the map is: "+letterMap.get(key)+"\n"); 
                morseTranslate=morseTranslate+morseCode[letterMap.get(key)]; //then we concactnate the each Morse code for the character for the whole word
                System.out.print("morseTranslate is: "+morseTranslate+"\n");
            }
            if(!morseMap.containsKey(morseTranslate)){ //now we put the Morse code of the "whole word" into the morseMap as the key, if it's not yet there
                morseMap.put(morseTranslate, count); //"count" is actually useless here, value isn't important in this case
                count++; 
            }
            morseTranslate=""; //after a word, we're going through another word so need to set the current morseTranslate into null for a fresh start again. 
        }
        return morseMap.size(); //this can tell you how many entries in a hash map, which in this case tells you how many unique Morse codes there are given the words String array. 
    }
     public static void main(String []args){
        String[] words = {"gin", "zen", "gig", "msg"};
        int uniqueCount=0; 
        UniqueMorseCodeWords umcw = new UniqueMorseCodeWords(); 
        uniqueCount=umcw.uniqueMorseRepresentations(words); 
        System.out.println("There are "+uniqueCount+" unique Morse codes\n");
     }
}