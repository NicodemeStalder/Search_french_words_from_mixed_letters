package scr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Scr {


	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		
		HashMot[] m = new HashMot[4];
		m[0] = new HashMot("d.txt",7);
		m[1] = new HashMot("d.txt",6);
		m[2] = new HashMot("d.txt",5);
		m[3] = new HashMot("d.txt",4);
		Scanner s = new Scanner(System.in);
		String mot = "";
		do{
			System.out.println("Entrez les 7 lettres :");
			mot = s.nextLine();

		}while(mot.length()!=7);
		s.close();
		printListOfMixedLetters(listOfWords(m,mot, 7));
		printListOfMixedLetters(listOfWords(m,mot, 6));
		printListOfMixedLetters(listOfWords(m,mot, 5));
		printListOfMixedLetters(listOfWords(m,mot, 4));




	}

	private static List<MixedLetters> listOfWords(HashMot [] m,String mot, int longueurDesMots) throws Exception{

		if (longueurDesMots<4 || longueurDesMots>7||mot.length()<4||mot.length()>7)
		{
			throw new Exception("word length only 4 or 5 or 6 or 7");
		}

		if(mot.length()<longueurDesMots)
		{
			throw new Exception("word length is smaller than requested word length");
		}

		if (mot.length()==longueurDesMots)
		{
			return m[7-longueurDesMots].wordsOfSameLetters(new MixedLetters(mot));
		}
		else
		{
			String[] s = subMot(mot);
			List<MixedLetters> l = listOfWords(m,s[0],longueurDesMots);
			for(int i=1; i<s.length;++i)
			{
				l.addAll(listOfWords(m,s[i],longueurDesMots));
			}
			return l;
		}




	}



	private static String[] subMot(String mot)
	{
		String[] mots = new String[mot.length()];

		for(int i=0; i<mot.length();++i)
		{
			mots[i] = "";
		}

		for(int i=0; i<mot.length(); ++i)
		{
			for(int j=0; j<mot.length(); ++j)
			{
				if(j!=i)
				{
					mots[i] += mot.charAt(j);
				}
			}

		}
		return mots;
	}


	private static void printListOfMixedLetters(List<MixedLetters> l)
	{
		System.out.println();
		HashSet<String> hs = new HashSet<>();
		for(MixedLetters m:l)
		{
			hs.add(m.getWord());
		}
		int u=0;
		for(String s:hs)
		{
			if(u>50)
			{
				System.out.println();
				u=0;
			}
			u+=2+s.length();
			System.out.print(s + "  ");
		}

	}



}
