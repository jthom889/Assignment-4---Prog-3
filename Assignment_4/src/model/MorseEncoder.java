package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseEncoder{
	
	private HashMap<Character, String> letterCodes;
	
	public MorseEncoder(String fileName) throws FileNotFoundException {
        letterCodes = new HashMap<Character, String>();
        readCodes(fileName);
    }
	
	private void readCodes(String fileName) throws FileNotFoundException {
        
    	Scanner in = new Scanner(new File(fileName));
        Character letter;
        String code;
        

        while (in.hasNextLine()){
        
            letter = in.next().charAt(0);
            code = in.next();
            letterCodes.put(letter, code);
        }
        in.close();	
    }

    public void print() 
    {   
        System.out.println(letterCodes.toString());
    }
   
    public String encode(char letter) {
    		
    	return letterCodes.get(letter);
       
    }

	public HashMap<Character, String> getLetterCodes() {
		return letterCodes;
	}
    
}
