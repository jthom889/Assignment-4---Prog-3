package model;
import java.io.FileNotFoundException;


public class MorseMessageDecoder{
	
	public MorseMessageDecoder(String fileName) throws FileNotFoundException {
		
		MorseDecoder mc = new MorseDecoder(fileName);
	}
    
}