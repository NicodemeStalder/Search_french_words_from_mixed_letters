package scr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Nico
 *
 *class that represent a word of type String (it stores the string in the attribute word)
 *the class is designed so that two different words with the same letters respond to these two rules:
 * they are considered equal by the redefined equals method
 * they have the same hashcode (redefined hashcode method)
 * 
 */
public class MixedLetters {
	
	private String word;
	private String letters; // useful for equals and hashcode methods
	
	public MixedLetters(String word)
	{
		this.word = word;
		List<Character> lettersL = new ArrayList<>();
		for(int i=0; i<word.length(); ++i)
		{
			lettersL.add(word.charAt(i));
		}
		Collections.sort(lettersL);
		String letters="";
		for(char c:lettersL)
		{
			letters+=c;
		}
		this.letters=letters;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public String getLetters()
	{
		return letters;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof MixedLetters)
		{
			if (this.getLetters().equals(((MixedLetters)o).getLetters()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(letters);
	}
	
}
