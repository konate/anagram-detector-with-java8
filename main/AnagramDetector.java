package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AnagramDetector utilizes Java SE 8 Streams
 * 
 * @author Bakary Konate
 *
 */
public class AnagramDetector {

	/**
	 * Check weather two non-empty an non-null strings are anagram of each other 
	 * It returns true if they are, else returns false
	 * @param string1
	 * @param string2
	 * @return result
	 */
	public static boolean isAnagramOf_v1(String string1, String string2) {
		if(string1.isEmpty() || string1 == null)
			throw new IllegalArgumentException("Argument 1 cannot be empty or null.");
		
		if(string2.isEmpty() || string1 == null)
			throw new IllegalArgumentException("Argument 2 cannot be empty or null.");
		
		String str1 = string1.trim().toLowerCase(); 
		String str2 = string2.trim().toLowerCase();
		
		if(str1.length() != str2.length()){
			return false;
		}
		
		if(str1.equalsIgnoreCase(str2)){
			return true;
		}
		
		//Anagram comparison is done character by character
		boolean result = str1.chars() // Parallel InStream of Characters values
		    		.allMatch( c1 -> str2.chars() // Parallel InStream of Characters values
		    				         .anyMatch(c2 -> c1 == c2) ); 
		    		
	    return result;
	}
	
	/**
	 * Check weather two non-empty an non-null strings are anagram of each other 
	 * It returns true if they are, else returns false
	 * @param string1
	 * @param string2
	 * @return result
	 */
	public static boolean isAnagramOf_v2(String string1, String string2) {
		if(string1.isEmpty() || string1 == null)
			throw new IllegalArgumentException("Argument 1 cannot be empty or null.");
		
		if(string2.isEmpty() || string1 == null)
			throw new IllegalArgumentException("Argument 2 cannot be empty or null.");
		
		int codeBase_1 = string1.chars() //InStream character codes
				.filter(c -> c != 32) //remove any whitespace
				.map(Character::toLowerCase)
				.sum();
		
		int codeBase_2 = string2.chars() // InStream character codes
				.filter(c -> c != 32) //remove any whitespace
				.map(Character::toLowerCase)
				.sum();
		// Two strings are anagram of each other if their 
		//sum of their code values are equals.
	    return codeBase_1 == codeBase_2;
	}
	/**
	 * Find all the anagram of searchString in targetString
	 * @param searchString 
	 * @param targetString
	 * @return list
	 */
	public static List<String> findAnagram(String searchString, String targetString){
		 
		List<String> list = Stream.of(targetString.split(" ")) //creates a Stream of strings
		.filter(s -> isAnagramOf_v1(s , searchString)) //remove any string not anagram of searchString
		.collect(Collectors.toList()); //creates a list of strings
       
		return list;	
	}
	
	/**
	 * Find all the anagram of searchString in targetString
	 * @param searchString 
	 * @param targetString
	 * @return list
	 */
	public static List<String> findAnagram_v2(String searchString, String targetString){
		 
		List<String> list = Stream.of(targetString.split(" ")) //creates a Stream of strings
		.filter(s -> isAnagramOf_v2(s , searchString)) //remove any string not anagram of searchString
		.collect(Collectors.toList()); //creates a list of strings
       
		return list;	
	}
	
}
