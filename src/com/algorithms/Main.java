package com.algorithms;

import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Michal on 05.02.14.
 */
public class Main
{
	public static int total = 10;

	public static void main(String[] args)
	{
		int array[] = { 3, 4, 3, 2, 3, -1, 3, 3 };
		System.out.println(array.toString() + "");
	}

	public void dirt()
	{
		Set<String> results = Algorithms.anagrams("aabbb");
		Set<String> resultsIter = Algorithms.anagramsIterative("abc");
		System.out.println("anagrams size:" + results.size() + ", anagrams:" + results);
		System.out.println("anagramsIter size:" + resultsIter.size() + ", anagrams:" + resultsIter);
		System.out.println("reverse string:" + Algorithms.reverseString("abc"));
		System.out.println("palindrome:" + Algorithms.palindrome("aba"));
		int array[] = { 3, 4, 4, 6, 1, 4, 4 };
		//		System.out.println("max counters:" + Algorithms.maxCountersSimple(5, array));
		System.out.println("sum of digits:" + Algorithms.sumOfDigits(1234));
		System.out.println("reverse number:" + Algorithms.reverseNumber(1230));
		System.out.println("quicksort:" +
				Arrays.toString(Algorithms.quickSort(array, 0, array.length - 1)));

		int array1[] = { 3, 4, 3, 2, 3, -1, 3, 3 };
		System.out.println("dominator:" + Algorithms.dominator(array1));

		int a = -5;
		int r = a >>> 1;
		int l = a << 1;
		System.out.println("right:" + r + ",left:" + l);

		boolean b1 = "a" == "a";
		boolean b2 = new String("a").equals("a");
		String s1 = new String("a");
		String s2 = new String("a");
		boolean b3 = s1.equals(s2);
		boolean b4 = s1 == s2;
		boolean b5 = "a".equals("a");
		Boolean flag = false;
		System.out.println(b1 + "," + b2 + "," + b3 + "," + b4 + "," + b5);

		new Main();

		a = 5;
		loop:
		for (int i = 1; i < 3; i++)
		{
			for (int j = 1; j < 3; j++)
			{
				if (a == 5)
				{
					break loop;
				}
				System.out.println(i * j);
			}
		}
		int[][] tab = null;
		if (tab != null)
		{

			for (int i = 0; i < tab.length; i++)
			{
				for (int j = 0; j < tab[0].length; j++)
				{

				}
			}
		}

		long l1 = System.currentTimeMillis();
		for (int i = 0; i < 30; i++)
		{
			double ab1 = 1;
			for (int j = 0; j < 1000; j++)
			{
				ab1 += 123.4 * Math.pow(2.3, 3.4) * Math.random() / Math.asin(ab1 % 1);
				ab1 %= 123446;
			}
		}
		long l2 = System.currentTimeMillis();
		System.out.println("Time of loops:" + (l2 - l1));

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);

		System.out.println("Working Directory = " + System.getProperty("user.dir"));

		String [] parts = "abc".split("");
		for (String part : parts)
		{
			System.out.println("->"+part+"<-");
		}

		List<String> testList = new ArrayList<String>();

		System.out.println("-----------------------------------------");
		int A [] = {1,5,2,6,3};
		int res = Algorithms.permMissingElement(A);
		System.out.println("missing:" + res);
		long sum = (A.length+1)*(1+A.length+1)/2;
		System.out.println();
	}

	public Main()
	{
		System.out.println("In test");
//		System.out.println(this);
		int temp = this.total;
		if (temp > 5)
		{
			System.out.println(temp);
		}
	}

}
