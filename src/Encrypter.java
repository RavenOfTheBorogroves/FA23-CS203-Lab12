import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	
    	File ImDecrypting = new File(decryptedFilePath);
    	String read =readFile(messageFilePath);
    	int s = this.shift;
    	
    	
    	read.replaceAll("\n","@" ); //i did this so that i can keep the enter spaces and still be able to use to character array
    	StringBuilder attempt = new StringBuilder();
    	for(char character:read.toCharArray()) {
    		int value = (int)character;
    		if (value <= 64 || value >= 123) {
    			attempt.append(character);
    		} else if (value>=65&&value <=90){
    			int newValue = value - s ;
    			if (newValue < 65) {
    				int newShift = 65 - newValue;
    				newValue = 90 - newShift + 1;
    			}
    			char newCharacter = (char) newValue;
				attempt.append(newCharacter);
    		} else if (value>=97&&value<=122) {
    			int newValue = value - s ;
    			if (newValue < 97) {
    				int newShift = 97 - newValue;
    				newValue = 122 - newShift + 1;
    				
    			}
    			char newCharacter = (char) newValue;
				attempt.append(newCharacter);
    		} else {
    			attempt.append(character);
    		}
    		//i am really proud of myself
    	}
    	String decoded = attempt.toString();
    	decoded.replaceAll("@", "\n");
    	System.out.println(decoded);
    	
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        //TODO: Read file from filePath
        Scanner Imdying = new Scanner(new File(filePath));
        
        //Imdying.(System.getProperty("line.separator")); 
        //i tried a delimiter and im leaving my rant in bc i want to //so this took me way to long to figure out and half of that was figuring out what dilimit means bc i have never heard that before AND I DIDNT NEED IT BC I WANNA READ IT AS ONE AND NOT LOTS OF DIFFERENT LINES 
        while (Imdying.hasNextLine()) {
        message = message + "\n" +Imdying.nextLine();
        }
        Imdying.close();
        return message;
        
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        //TODO: Write to filePath
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
