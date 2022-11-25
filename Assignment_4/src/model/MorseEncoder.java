package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * this class converts a letter into morse code
 * @author Opemipo Lano
 *
 */
public class MorseEncoder{
	
	private HashMap<Character, String> letterCodes;
	
	/**
	 * constructor for the MorseEncoder
	 * @param fileName is where the data comes from
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public MorseEncoder(String fileName) throws FileNotFoundException {
        letterCodes = new HashMap<Character, String>();
        readCodes(fileName);
    }
	
	/**
	 * this method will read the codes from
	 *the file and store them in a hashmap
	 * @param fileName is the file the data comes from
	 * @throws FileNotFoundException if the file cannot be located
	 */
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

	/**
	 * this method will print the entire hashMap
	 */
    public void print() 
    {   
        System.out.println(letterCodes.toString());
    }
   
    /**
     * this method will take a letter
     * and convert it to morse code
     * @param letter is the letter to be put into morse code
     * @return the encoded message
     */
    public String encode(char letter) {
    		
    	return letterCodes.get(letter);
       
    }

    /**
     * this is a getter for the hashmap
     * @return
     */
	public HashMap<Character, String> getLetterCodes() {
		return letterCodes;
	}
    
}
