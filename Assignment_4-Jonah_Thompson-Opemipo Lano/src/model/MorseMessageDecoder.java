package model;
import java.io.FileNotFoundException;

/**
 * This class uses the morse decoder to decode 
 * full words and sentences of morse code
 * @author Jonah Thompson
 *
 */
public class MorseMessageDecoder{
	
	MorseDecoder mc;
	
	/**
	 * constructor for MorseMessageDecoder
	 * @param fileName is the file to take the data from
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public MorseMessageDecoder(String fileName) throws FileNotFoundException {
		
		mc = new MorseDecoder(fileName);
	}
	
	/**
	 * this method will take a word or phrase in morse
	 *  code and convert it to a regular word or phrase
	 * @param message is the message to decode
	 * @return the decoded message
	 */
	public String decodeMessage(String message) {
		
		String morseLetter = "";
		int count = 0;
		String decoded = "";
		
		String morseWord[] = message.split("       ");
		
		for(int i = 0; i < morseWord.length; i++) {
			
			String word = morseWord[i];
			
			String[] letter = word.split("   ");
			
			for(String l: letter) 
				decoded = decoded + mc.decode(l);
			
			decoded = decoded + " ";
		}
		
		return decoded.toLowerCase();	
	}
    
}