package partB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringTokenizer;


public class TestBet {
	
	/**
	 * creating static parameters for the functions
	 */
	static HashMap<String, Integer> map = new HashMap<>();
	static int counter=0;
	static String longest ="";
	static int max = 0;
	static int maxT = 1;
	
	/**
	 * main function for read file
	 * @param args
	 */
	public static void main(String[] args) {
		readFile("C:\\Users\\user\\workspace\\OOP\\src\\partB\\text1.txt");
	}

	/**
	 * read file using buffer 
	 * search key by value using StackOverflow code using Object
	 * @param fileName
	 * sending every line from text to function mapWords
	 * prints The Number of Different Words, The Number of Words, The Most Frequent Word and frequenncy, and The Longest Word    
	 */
	public static void readFile (String fileName){ 

		try { // try read from the file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			//System.out.println(0+") "+str);
			for(int i=1; str!=null; i=i+1) {
				mapWords(str);
				str = br.readLine();
				/*	if (str != null){
					System.out.println(i+") "+str);
				}*/
			}
			br.close();
			String ans = "";

			//this code is taken from StackOverflow
			for (Entry<String, Integer> entry : map.entrySet()) {
				if (Objects.equals(maxT, entry.getValue())) {
					ans = entry.getKey().toString();
				}
			}
			
			System.out.println("The Number of Different Words: " +map.size() );
			System.out.println("The Number of Words: " +counter );
			System.out.println("The Most Frequent Word: ("+ans+ "), frequency: " +maxT);
			System.out.println("The Longest Word: ("+longest+")");
			
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	
	/**
	 * creating map of key as String which is the words in the text
	 * and value as the number of appearances of every word in the text  
	 * @param str
	 */
	public static void mapWords(String str) {
		String delim =  " ,:;.()-/"; //the delimiters are: ( ,:;.()-/)
		StringTokenizer tok = new StringTokenizer(str,delim);//constructor
		String temp = null;
		while (tok.hasMoreTokens()){
			temp = tok.nextToken();//get the next token
			if(map.containsKey(temp)) { //if the word is already in the map, we update its value
				map.put(temp, map.get(temp)+1);
				if(map.get(temp)> maxT) {//we save the frequency of the Most Frequent Word 
					maxT= map.get(temp);
				}
				counter++;
			}
			else {
				map.put(temp, 1);
				counter++;
				if(temp.length()>max) {//we save The Longest Word
					max=temp.length();
					longest = temp;
				}
			}
		}
	}
}
