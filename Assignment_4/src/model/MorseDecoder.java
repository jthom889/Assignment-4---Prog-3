package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class MorseDecoder{
	BinaryTree<Character> intCode;
	
	public MorseDecoder(String fileName) throws FileNotFoundException
    {
        intCode = new  BinaryTree<Character>(null);
        createTree(fileName);
    }
	
	 private void createTree(String fileName) throws FileNotFoundException {
	        Scanner in = new Scanner(new File(fileName));
	        String letter;
	        String code;

	        while (in.hasNextLine()){
	            letter = in.next();
	            code = in.next();
	            placeCode (intCode, letter.charAt(0), code);
	        }
	        in.close();
	    }
	 
	 public void placeCode(BinaryTree<Character> m, char charToPlace, String code) {
		 
		 if(code.equals(".")) {
	    		BinaryTree<Character> toAdd = new BinaryTree<Character>(charToPlace);
	    		m.setLeft(toAdd);
	    	}
	    	
	    	else if(code.equals("-")) {
	    		BinaryTree<Character> toAdd = new BinaryTree<Character>(charToPlace);
	    		m.setRight(toAdd);
	    	}
	    	
	    	else if(code.length() > 1 && code.charAt(0) == '.')
	    		placeCode(m.getLeft(), charToPlace, code.substring(1));
	    	
	    	else if(code.length() > 1 && code.charAt(0) == '-')
	    		placeCode(m.getRight(), charToPlace, code.substring(1));
	 }
	 
	 public char decode(String code) {
		 
	        return decoder(intCode, code);
	    }
	    
	    private char decoder( BinaryTree<Character> m, String code) {
			
	    	for(int i = 0; i < code.length(); i++) {
	    		
	    		if(code.charAt(i) == '.')
	    			m = m.getLeft();
	    		
	    		else if(code.charAt(i) == '-')
	    			m = m.getRight();	
	    	}
	    	return m.getRootElement();
	        
	    }
	    
	    public void print() {   
	        Iterator<Character> it = intCode.iterator();
	        
	        while (it.hasNext())
	            System.out.print (it.next()+" ");
	    }
   
}