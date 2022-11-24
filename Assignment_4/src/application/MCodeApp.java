package application;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.MorseMessageDecoder;
import model.MorseMessageEncoder;


public class MCodeApp 
{
    /**
     *  Give a brief description of what main does
     * @throws FileNotFoundException 
     */
    public static void main(String args[]) throws FileNotFoundException
    {
    	
    	final String file = "res/codes.txt";
        Scanner in = new Scanner(System.in);
        MorseMessageDecoder decoder = new  MorseMessageDecoder(file);
        MorseMessageEncoder encoder = new  MorseMessageEncoder(file);
        String message;
        char choice = ' ';

        do
        {
            System.out.print ("Enter E (encode), D (decode) or Q(quit): ");
            try { 
                choice = in.nextLine().toUpperCase().charAt(0);
                switch (choice)
                {
                    case 'D':
                            System.out.println ("Enter the message you'd like to decode from Morse Code");
                            message = in.nextLine();
                            //System.out.println (decoder.decodeMessage(message)); 
                            break;
                    case 'E':
                            System.out.println ("Enter the message you'd like to encode into Morse Code");
                            message = in.nextLine();
                            System.out.println (encoder.encodeMessage(message));
                    default:   
                }
            }
            catch (StringIndexOutOfBoundsException e )
            {   System.out.println ("Invalid entry - try again");
            }
        } while (choice != 'Q');
    }
}
