package model;
import java.io.FileNotFoundException;
import java.util.HashMap;


public class MorseMessageEncoder{
	
	HashMap<Character, String> list;
	
	public MorseMessageEncoder(String fileName) throws FileNotFoundException {
		
		MorseEncoder me = new MorseEncoder(fileName);
		list = me.getLetterCodes();
	
	}
	
	public String encodeMessage(String message) {
	
		String morseMsg = "";
		
		message = message.toUpperCase();
		
		for(int i = 0; i < message.length(); i++) {
			
			if(message.charAt(i) == ' ' && morseMsg != "")
				morseMsg = morseMsg + "    ";
			
			else if(list.containsKey(message.charAt(i))) 
				morseMsg = morseMsg + list.get(message.charAt(i)) + "   ";
		}
		
		return morseMsg;
		
	}
    
}