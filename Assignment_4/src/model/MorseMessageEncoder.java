package model;
import java.io.FileNotFoundException;


public class MorseMessageEncoder{
	
	public MorseMessageEncoder(String fileName) throws FileNotFoundException {
		
		MorseEncoder me = new MorseEncoder(fileName);
		
	}
	
	public void encode() {
		
	}
    
}