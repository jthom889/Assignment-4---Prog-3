package model;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseEncoder{
	
	String[] letterCodes;
	
	public MorseEncoder(String fileName) throws FileNotFoundException {
        letterCodes = new String[26];
        readCodes(fileName);
    }
	
	private void readCodes(String fileName) throws FileNotFoundException {
        
    	Scanner in = new Scanner(new File(fileName));
        String letter;
        String code;
        

        while (in.hasNextLine()){
        
            letter = in.next();
            code = in.next();
            letterCodes[Integer.parseInt(letter) - 1] = code;
        }
        in.close();
    	
    }

    public void print() 
    {   
        for (int i = 0; i < 26; i++)
        System.out.println(letterCodes[i]);
    }
   
    public String encode(char letter) {
		
    	String code = "";
    	int num = letter - '0';
    	
    	ArrayList<String> encode = new ArrayList<String>();
    	encode.add(".-");
    	encode.add("-...");
    	encode.add("-.-.");
    	encode.add("-..");
    	encode.add(".");
    	encode.add("..-.");
    	encode.add("--.");
    	encode.add("....");
    	encode.add("..");
    	encode.add(".---");
    	encode.add("-.-");
    	encode.add(".-..");
    	encode.add("--");
    	encode.add("-.");
    	encode.add("---");
    	encode.add(".--.");
    	encode.add("--.-");
    	encode.add(".-.");
    	encode.add("...");
    	encode.add("-");
    	encode.add("..-");
    	encode.add("...-");
    	encode.add(".--");
    	encode.add("-..-");
    	encode.add("-.--");
    	encode.add("--..");
    
    	
    	for(int i = 1; i <= 26; i++) {
    		
    		if(i == num) {
    			code = encode.get(i - 1);
    			break;
    		}
    		
    	}
    	return code;
       
    } 
     
}
