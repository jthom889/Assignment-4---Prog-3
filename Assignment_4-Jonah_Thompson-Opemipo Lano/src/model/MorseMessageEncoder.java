package model;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * this class will encode a message 
 * from English into morse code
 * @author Opemipo Lano
 *
 */
public class MorseMessageEncoder{
	
	HashMap<Character, String> list;
	MorseEncoder me;
	
	/**
	 * constructor for the MorseMessangerEncoder
	 * @param fileName is the file to take data from
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public MorseMessageEncoder(String fileName) throws FileNotFoundException {
		
		me = new MorseEncoder(fileName);
		list = me.getLetterCodes();
	
	}
	
	/**
	 * this method will encode a word or phrase 
	 * one letter at a time by calling the morseEncoder
	 * @param message is the message to be encoded
	 * @return the encoded message as morse code
	 */
	public String encodeMessage(String message) {
	
		String morseMsg = "";
		
		message = message.toUpperCase();
		
		for(int i = 0; i < message.length(); i++) {
			
			if(message.charAt(i) == ' ' && morseMsg != "")
				morseMsg = morseMsg + "    ";
			
			else if(list.containsKey(message.charAt(i))) 
				morseMsg = morseMsg + me.encode(message.charAt(i)) + "   ";
		}
		
		return morseMsg;
		
	}
    
}