package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * this class will will convert a single morse
 * code character back into english
 * @author Jonah Thompson
 *
 */
public class MorseDecoder{
	BinaryTree<Character> intCode;
	
	/**
	 * constructor for MorseDecoder
	 * @param fileName is the file where data comes from
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public MorseDecoder(String fileName) throws FileNotFoundException
    {
        intCode = new  BinaryTree<Character>(null);
        createTree(fileName);
    }
	
	/**
	 * this method will initialize a binary 
	 * tree based on morse code characters
	 * @param fileName is the name of the file where data comes from
	 * @throws FileNotFoundException if the file cannot be found
	 */
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
	 
	 /**
	  * this method will place the letter 
	  * values into the binary tree
	  * @param m is the binary tree to add data to
	  * @param charToPlace is the value going into the tree
	  * @param code is the morse code condition to add the value to the tree
	  */
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
	 
	 /**
	  * this method will get a decoded
	  * letter from the binary tree
	  * @param code is the morse code character to decode
	  * @return the decoded character
	  */
	 public char decode(String code) {
		 
	        return decoder(intCode, code);
	    }
	    
	 /**
	  * this method will get the letter value
	  * from the tree based on the mosre code
	  * @param m is the binary tree to get data from
	  * @param code is the morse code character to decode
	  * @return the decoded letter
	  */
	    private char decoder( BinaryTree<Character> m, String code) {
			
	    	for(int i = 0; i < code.length(); i++) {
	    		
	    		if(code.charAt(i) == '.')
	    			m = m.getLeft();
	    		
	    		else if(code.charAt(i) == '-')
	    			m = m.getRight();	
	    	}
	    	return m.getRootElement();
	        
	    }
	    
	    /**
	     * this method will print the contents 
	     * of the binary tree in order 
	     */
	    public void print() {   
	        Iterator<Character> it = intCode.iterator();
	        
	        while (it.hasNext())
	            System.out.print (it.next()+" ");
	    }
   
}