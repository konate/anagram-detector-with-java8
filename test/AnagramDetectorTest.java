package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.AnagramDetector;

public class AnagramDetectorTest {
	 @Rule
     public ExpectedException thrown= ExpectedException.none();

	@Test
	public void testIsAnagramOf_v1() {
		
	//string1 and string2 are anagram of each other
	   String string1 = "actmoM";
       String string2 = "tamcom ";
   
	   boolean condition = AnagramDetector.isAnagramOf_v1(string1, string2);  
	   assertTrue(condition);
	   
	 //string1 and string2 are NOT anagram of each other
	   string1 = "dog";
       string2 = "cat";
   
	   condition = AnagramDetector.isAnagramOf_v1(string1, string2);  
	   assertFalse(condition);
	   
	}
	
	@Test
	public void testIsAnagramOf_v2() {
		
	//string1 and string2 are anagram of each other
	   String string1 = "actmoM";
       String string2 = "tamcom ";
   
	   boolean condition = AnagramDetector.isAnagramOf_v2(string1, string2);  
	   assertTrue(condition);
	   
	 //string1 and string2 are NOT anagram of each other
	   string1 = "dog";
       string2 = "cat";
   
	   condition = AnagramDetector.isAnagramOf_v2(string1, string2);  
	   assertFalse(condition);
	   
	}
	 @Test
     public void testIllegalArgumentException() {
		 		
         thrown.expect(IllegalArgumentException.class);
         AnagramDetector.isAnagramOf_v1("", ""); 
         AnagramDetector.isAnagramOf_v1("dog", ""); 
         AnagramDetector.isAnagramOf_v1(null, "cat"); 
         AnagramDetector.isAnagramOf_v1("cat", null); 
         
         AnagramDetector.isAnagramOf_v2("", ""); 
         AnagramDetector.isAnagramOf_v2("dog", ""); 
         AnagramDetector.isAnagramOf_v2(null, "cat"); 
         AnagramDetector.isAnagramOf_v2("cat", null); 
    
     }

	@Test
	public void testFindAnagrams() {
		
	//find anagram of a string1 string in string2 are anagram of each other
	   String string1 = "actmoM"; // string to find all anagrams
	   String string2 = "ctmoMa ta mcom atmoMc"; // target test
	   
	   String[] expectedOutput = {"ctmoMa", "atmoMc"}; // 2 anagrams of actmoM
    
	   List<String> actual = AnagramDetector.findAnagram(string1, string2);  
	   assertArrayEquals((expectedOutput), actual.toArray());	   
	}
	
	@Test
	public void testFindAnagrams_v2() {
		
	//find anagram of a string1 string in string2 are anagram of each other
	   String string1 = "actmoM"; // string to find all anagrams
	   String string2 = "ctmoMa ta mcom atmoMc"; // target test
	   
	   String[] expectedOutput = {"ctmoMa", "atmoMc"}; // 2 anagrams of actmoM
    
	   List<String> actual = AnagramDetector.findAnagram(string1, string2);  
	   assertArrayEquals((expectedOutput), actual.toArray());	   
	}

}
