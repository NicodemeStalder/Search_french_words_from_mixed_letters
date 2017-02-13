package scr;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * 
 * @author Nico
 *
 *class that take the filename of a file that contains words
 *it will put all the words of the length specified by the attribute longueur of the constructor in a HashMap like this:
 *all words with the same letters are put in a same list. This list is put in a HashMap associated with a key that is any word of the previous list
 *
 *the method wordsOfSameLetters return the list of words of the same letters than the word you ask.
 *
 *
 */
public class HashMot {

	private HashMap<MixedLetters,List<MixedLetters>> h;

	public HashMot(String fileName, int longueur) throws FileNotFoundException, IOException, Exception
	{
		InputStream i = new BufferedInputStream(new FileInputStream(fileName));
		List<Integer> l = new ArrayList<Integer>();
		List<String> s2 = new ArrayList<>();
		String s1="";
		int a;
		do
		{
			a=i.read();
			while(a!=-1 && a!=13 && a!=10){
				l.add(a);
				a=i.read();

			}

			if (l.size()==longueur)
			{
				for(int in: l)
				{
					s1+=(char)in;
				}
				s2.add(s1);
			}

			l=new ArrayList<Integer>();
			s1="";
		}while(a!=-1);
		i.close();




		HashMap<MixedLetters,List<MixedLetters>> h = new HashMap<>();

		MixedLetters mot;
		for(String m : s2)
		{
			mot = new MixedLetters(m);

			if(h.containsKey(mot))
			{
				h.get(mot).add(mot);
			}
			else
			{
				ArrayList<MixedLetters> tmp = new ArrayList<>();
				tmp.add(mot);
				h.put(mot,tmp);
			}
		}
		this.h=h;
	}

	public List<MixedLetters> wordsOfSameLetters(MixedLetters m)
	{
		if (h.containsKey(m))
		{
		return h.get(m);
		}
		else
		{
			return new ArrayList<MixedLetters>();
		}
	}

}
