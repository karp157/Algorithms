import com.algorithms.Algorithms;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Michal on 08.02.14.
 */
public class AlgorithmsTest
{
	@Test
	public void testAnagrams() throws Exception
	{
		Set<String> res1 = Algorithms.anagrams("abc");
		Set<String> res2 = Algorithms.anagrams("aba");
		//		assertThat(res1, hasItems("abc", "acb", "bac", "bca", "cba", "cab"));
		assertEquals(6, res1.size());
		//		assertThat(res2, hasItems("aba", "aab", "baa"));
		assertEquals(3, res2.size());
	}

	@Test
	public void testAnagramsIterative() throws Exception
	{
		Set<String> res1 = Algorithms.anagramsIterative("abc");
		Set<String> res2 = Algorithms.anagramsIterative("aba");
		//		assertThat(res1, hasItems("abc", "acb", "bac", "bca", "cba", "cab"));
		assertEquals(6, res1.size());
		//		assertThat(res2, hasItems("aba", "aab", "baa"));
		assertEquals(3, res2.size());
	}

	@Test
	public void testReverseString() throws Exception
	{
		String res = Algorithms.reverseString("Reverse Me");
		String expected = new String("eM esreveR");
		assertEquals((Object) expected, (Object) res);
	}

	@Test
	public void testPalindrome() throws Exception
	{

	}

	@Test
	public void testMaxCounters() throws Exception
	{
		int[] array = { 3, 4, 4, 6, 1, 4, 4 };
		int[] expected = { 3, 2, 2, 4, 2 };
		int[] result = Algorithms.maxCounters(5, array);
		assertArrayEquals(expected, result);
	}

	@Test
	public void testSumOfDigits() throws Exception
	{
		assertEquals(6, Algorithms.sumOfDigits(123));
	}

	@Test
	public void testFibonacci()
	{
		assertEquals(5, Algorithms.fibonacci(4));
	}

	@Test
	public void testReverseNumber() throws Exception
	{

	}

	@Test
	public void testQuickSort() throws Exception
	{
		Random random = new Random();
		int n = 500000;
		int[] tab = new int[n];
		for (int i = 0; i < tab.length; i++)
		{
			tab[i] = random.nextInt(n / 3);
		}
		long t1 = System.currentTimeMillis();
		Algorithms.quickSort(tab.clone(), 0, tab.length - 1);
		long t2 = System.currentTimeMillis();
		Arrays.sort(tab.clone());
		long t3 = System.currentTimeMillis();

		System.out.println("My algorithm:" + (t2 - t1) + ", standard sort:" + (t3 - t2));
	}

	@Test
	public void testGeonomicRangeQuery() throws Exception
	{
		String query = "GACACCATA";
		StringBuilder builder = new StringBuilder();
		int n = 100000;

		int[] P = { 0, 0, 4, 7 };
		int[] Q = { 8, 2, 5, 7 };
		int[] results = Algorithms.geonomicRangeQuery(query, P, Q);
		int[] expected = { 1, 1, 2, 4 };
		assertArrayEquals(expected, results);

	}

	@Test
	public void testMinAvgTwoSlice() throws Exception
	{

	}

	@Test
	public void testBrackets()
	{
		String proper = "{[()()]}";
		String wrong = "([)()]";
		int res1 = Algorithms.brackets(proper);
		int res2 = Algorithms.brackets(wrong);
		assertEquals(1, res1);
		assertEquals(0, res2);
	}

	@Test
	public void testMaxProfit()
	{
		int[] tab1 = { 1, 2, 3, 4, 5 };
		int[] tab2 = { 10, 7, 7, 6, 6, 5 };
		int[] tab3 = { 23171, 21011, 21123, 21366, 21013, 21367 };
		int res1 = Algorithms.maxProfit(tab1);
		int res2 = Algorithms.maxProfit(tab2);
		int res3 = Algorithms.maxProfit(tab3);
		assertEquals(4, res1);
		assertEquals(0, res2);
		assertEquals(356, res3);
	}

	@Test
	public void testBuildWallBlocks()
	{
		int[] tab1 = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
		int res1 = Algorithms.minBlocksWall(tab1);
		assertEquals(7, res1);
	}

	@Test
	public void testFish()
	{
		int[] A1 = { 4, 3, 2, 1, 5 };
		int[] B1 = { 0, 1, 0, 0, 0 };
		int res1 = Algorithms.fish(A1, B1);
		assertEquals(2, res1);
	}

	@Test
	public void testEquiLeader()
	{
		int[] A = { 4, 3, 4, 4, 4, 2 };
		int res = Algorithms.equiLeader(A);
		assertEquals(2, res);
	}

	@Test
	public void testMaxDoubleSliceSum()
	{
		int[] A = { 3, 2, 6, -1, 4, 5, -1, 2 };
		int res = Algorithms.maxDoubleSliceSum(A);
		assertEquals(17, res);
	}

	@Test
	public void testMaxSliceSum()
	{
		int A[] = { 3, 2, -6, 4, 0 };
		int res = Algorithms.maxSliceSum(A);
		assertEquals(5, res);
	}

	@Test
	public void testMaxSliceSum2()
	{
		int A[] = { 3, 2, -6, 4, 0 };
		int res = Algorithms.maxSliceSum2(A);
		assertEquals(5, res);
	}

	@Test
	public void testMinPerimeterRectangle()
	{
		int res = Algorithms.minPermimeterRectange(30);
		assertEquals(22, res);
	}

	@Test
	public void testPeaks()
	{
		int A[] = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
		int res = Algorithms.peaks(A);
		assertEquals(3, res);
	}

	@Test
	public void testBoron2013()
	{
		int A[] = { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 };
		int res = Algorithms.boron2013_2(A);
		assertEquals(3, res);
	}

	@Test
	public void testCountNonDivisible()
	{
		int A[] = { 3, 1, 2, 3, 6 };
		int expected[] = { 2, 4, 3, 2, 0 };
		int res[] = Algorithms.countNonDivisible(A);
		assertArrayEquals(expected, res);
	}

	@Test
	public void testGCD()
	{
		int res1 = Algorithms.greatestCommonDivisor(9, 6);
		assertEquals(3, res1);
	}

	@Test
	public void testChocolatesByNumber()
	{
		int res = Algorithms.chocolatesByNumbers(10, 4);
		assertEquals(5, res);
	}

	@Test
	public void testCountSemiprimes()
	{
		int[] P = { 1, 4, 16 };
		int[] Q = { 26, 10, 20 };
		int[] result = Algorithms.countSemiprimes(26, P, Q);
		int[] expected = { 10, 4, 0 };
		//		assertArrayEquals(expected, result);
	}


	@Test
	public void testRep()
	{
		int[] res = Algorithms.negativeRepresentation(42);
	}

	@Test
	public void testSearchKMP()
	{
		String S = "abdabcacf";
		String W = "abc";
		int[] T = new int[S.length()];
		int res = Algorithms.searchKMP(W.toCharArray(), S.toCharArray(), T);
	}

	@Test
	public void testFindMissingElement()
	{
		int A[] = { 2, 3, 1, 5 };
		int res = Algorithms.permMissingElement(A);
		assertEquals(4, res);
	}


	@Test
	public void testTriangle() throws Exception
	{

	}

	@Test
	public void testDominator() throws Exception
	{

	}

	@Test
	public void testPermCheck() throws Exception
	{

	}

	@Test
	public void testCountPalindromicSlices() throws Exception
	{

	}

	@Test
	public void testSimpleMaxProfit() throws Exception
	{

	}

	@Test
	public void testNesting() throws Exception
	{

	}

	@Test
	public void testSigma2012() throws Exception
	{

	}

	@Test
	public void testMinBlocksWall() throws Exception
	{

	}

	@Test
	public void testMinPermimeterRectange() throws Exception
	{

	}

	@Test
	public void testPeak() throws Exception
	{

	}

	@Test
	public void testBoron2013_2() throws Exception
	{

	}

	@Test
	public void testCountNonDivisibleSimple() throws Exception
	{

	}

	@Test
	public void testBinaryGap() throws Exception
	{
		int res1 = Algorithms.binaryGap(9);
		assertEquals(2, res1);
		int res2 = Algorithms.binaryGap(529);
		assertEquals(4, res2);
		int res3 = Algorithms.binaryGap(20);
		assertEquals(1, res3);
		int res4 = Algorithms.binaryGap(15);
		assertEquals(0, res4);

	}

	@Test
	public void testIsPalindrome() throws Exception
	{

	}

	@Test
	public void testMaxCountersSimple() throws Exception
	{

	}

	@Test
	public void testGreatestCommonDivisor() throws Exception
	{

	}

	@Test
	public void testLeastCommonMultiple() throws Exception
	{

	}

	@Test
	public void testChocolatesByNumbers() throws Exception
	{

	}

	@Test
	public void testCommonPrimeDivisors() throws Exception
	{

	}

	@Test
	public void testBreakChain() throws Exception
	{

	}

	@Test
	public void testPairsInArray() throws Exception
	{

	}

	@Test
	public void testNegativeRepresentation() throws Exception
	{

	}

	@Test
	public void testMagnitudePole() throws Exception
	{

	}

	@Test
	public void testPermMissingElement() throws Exception
	{

	}
}
