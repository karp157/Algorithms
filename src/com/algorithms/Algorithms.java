package com.algorithms;

import sun.tools.jar.resources.jar;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Michal on 05.02.14.
 */
public class Algorithms
{

	public static int fibonacci(int n)
	{
		if (n < 0)
		{
			return 0;
		}
		else if (n < 2)
		{
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public static Set<String> anagrams(String word)
	{
		Set<String> results = new HashSet<String>();
		anagramsAggregate("", word, results);
		return results;
	}

	private static void anagramsAggregate(String currWord, String restLetters, Set<String> results)
	{
		if (restLetters.isEmpty())
		{
			results.add(currWord);
		}
		else
		{
			for (int i = 0; i < restLetters.length(); i++)
			{
				String restString = restLetters.substring(0, i) + restLetters.substring(i + 1, restLetters.length());
				anagramsAggregate(currWord + restLetters.charAt(i), restString, results);
			}
		}
	}

	public static Set<String> anagramsIterative(String line)
	{
		Map<Integer, Set<String>> permMap = new HashMap<Integer, Set<String>>();
		for (int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			permMap.put(i + 1, new HashSet<String>());
			if (i == 0)
			{
				permMap.get(i + 1).add(c + "");
			}
			else
			{
				Set<String> newPerms = permMap.get(i + 1);
				for (String perm : permMap.get(i))
				{
					for (int p = 0; p < perm.length(); p++)
					{
						newPerms.add(perm.substring(0, p) + c + perm.substring(p, perm.length()));
					}
					newPerms.add(perm + c);
				}
			}
		}

		return permMap.get(line.length());
	}


	public static String reverseString(String line)
	{
		StringBuilder builder = new StringBuilder();
		for (int i = line.length() - 1; i >= 0; i--)
		{
			builder.append(line.charAt(i));
		}
		return builder.toString();
	}

	public static boolean palindrome(String string)
	{
		return isPalindrome(string, 0, string.length() - 1);
	}

	public static boolean isPalindrome(String string, int begin, int end)
	{
		int i = begin, j = end;
		while (i < j)
		{
			if (string.charAt(i) != string.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static int[] maxCountersSimple(int N, int[] A)
	{
		int actMax = 0;
		int results[] = new int[N];
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != N + 1)
			{
				int resIndex = A[i] - 1;

				results[resIndex]++;

				if (results[resIndex] > actMax)
				{
					actMax = results[resIndex];
				}
			}
			else
			{
				for (int j = 0; j < results.length; j++)
				{
					results[j] = actMax;
				}
			}
		}

		return results;
	}

	public static int[] maxCounters(int N, int[] A)
	{
		int results[] = new int[N];
		int actMax = 0, minAll = 0;
		for (int i = 0; i < A.length; i++)
		{
			int resIndex = A[i] - 1;
			if (A[i] != N + 1)
			{
				if (results[resIndex] < minAll)
				{
					results[resIndex] = minAll;
				}
				results[resIndex]++;
				if (results[resIndex] > actMax)
				{
					actMax = results[resIndex];
				}
			}
			else
			{
				minAll = actMax;
			}
		}
		for (int j = 0; j < results.length; j++)
		{
			if (results[j] < minAll)
			{
				results[j] = minAll;
			}
		}
		return results;
	}

	public static int sumOfDigits(int number)
	{
		int sum = 0;
		while (number > 0)
		{
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}

		return sum;
	}

	public static int reverseNumber(int number)
	{
		int sum = 0;
		while (number > 0)
		{
			int digit = number % 10;
			sum *= 10;
			sum += digit;
			number /= 10;
		}
		return sum;
	}

	public static int[] quickSort(int[] tab, int left, int right)
	{
		int i = left, j = right;
		int pivot = tab[(left + right) / 2];
		do
		{
			while (tab[i] > pivot)
			{
				i++;
			}
			while (tab[j] < pivot)
			{
				j--;
			}

			if (i <= j)
			{
				int tmp = tab[i];
				tab[i] = tab[j];
				tab[j] = tmp;
				i++;
				j--;
			}
		}
		while (i < j);

		if (left < j)
		{
			quickSort(tab, left, j);
		}

		if (right > i)
		{
			quickSort(tab, i, right);
		}
		return tab;
	}


	/*
	62/100
	expected time N + M
	expected space N
	time: N*M
	 */
	public static int[] geonomicRangeQuery(String S, int[] P, int[] Q)
	{
		int[] results = new int[P.length];
		Map<Character, Integer> nucleotydes = new HashMap<Character, Integer>();
		nucleotydes.put('A', 1);
		nucleotydes.put('C', 2);
		nucleotydes.put('G', 3);
		nucleotydes.put('T', 4);

        int[] sumA = new int[S.length()];
        int[] sumC = new int[S.length()];
        int[] sumG = new int[S.length()];
        int sumAval=0, sumCval=0,sumGval=0;

		//maximal length to A element
		for (int i = 0; i < S.length(); i++)
		{
			char c = S.charAt(i);
			if (c == 'A') {
                sumA[i] = ++sumAval;
                sumG[i] = sumGval;
                sumC[i] = sumCval;
            } else if(c == 'C')
			{
                sumA[i] = sumAval;
                sumC[i] = ++sumCval;
                sumG[i] = sumGval;
			}else if (c == 'G') {
                sumA[i] = sumAval;
                sumC[i] = sumCval;
                sumG[i] = ++sumGval;
            }
            else{
                sumA[i] = sumAval;
                sumC[i] = sumCval;
                sumG[i] = sumGval;
            }
		}

		for (int i = 0; i < P.length; i++) {
            int amountBefore = P[i] > 0 ? sumA[P[i] - 1]: 0;
            if (sumA[Q[i]] > amountBefore) {
                results[i] = 1;
                continue;
            }
            amountBefore = P[i] > 0 ? sumC[P[i] - 1]: 0;
            if (sumC[Q[i]] > amountBefore) {
                results[i] = 2;
                continue;
            }
            amountBefore = P[i] > 0 ? sumG[P[i] - 1]: 0;
            if (sumG[Q[i]] > amountBefore) {
                results[i] = 3;
                continue;
            }
            results[i] = 4;
        }
        return results;
	}

	public static int minAvgTwoSlice(int[] A)
	{
		int minAvgIdx=0;
		double minAvgVal=(A[0]+A[1])/2; //At least two elements in A.
		double currAvg;
		for(int i=0; i<A.length-2; i++){
			/**
			 * We check first the two-element slice
			 */
			currAvg = ((double)(A[i] + A[i+1]))/2;
			if(currAvg < minAvgVal){
				minAvgVal = currAvg;
				minAvgIdx = i;
			}
			/**
			 * We check the three-element slice
			 */
			currAvg = ((double)(A[i] + A[i+1] + A[i+2]))/3;
			if(currAvg < minAvgVal){
				minAvgVal = currAvg;
				minAvgIdx = i;
			}
		}
		/**
		 * Now we have to check the remaining two elements of the array
		 * Inside the for we checked ALL the three-element slices (the last one
		 * began at A.length-3) and all but one two-element slice (the missing
		 * one begins at A.length-2).
		 */
		currAvg = ((double)(A[A.length-2] + A[A.length-1]))/2;
		if(currAvg < minAvgVal){
			minAvgVal = currAvg;
			minAvgIdx = A.length-2;
		}
		return minAvgIdx;
	}

	public static int triangle(int[] A)
	{
		Arrays.sort(A);
		for (int i = 2; i < A.length; i++)
		{
			if (isTriangle(A[i - 2], A[i - 1], A[i]))
			{
				return 1;
			}
		}
		return 0;
	}

	private static boolean isTriangle(int a, int b, int c)
	{
		long ab, ac, bc;
		ab = a + b;
		ac = a + c;
		bc = b + c;
		if (ab > c && ac > b && bc > a)
		{
			return true;
		}
		return false;
	}

	public static int dominator(int[] A)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++)
		{
			Integer count = map.get(A[i]);
			count = (count == null) ? 1 : (count + 1);
			map.put(A[i], count);
		}
		int dominator = -1;
		boolean found = false;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			int value = entry.getValue();
			if (value > A.length / 2)
			{
				found = true;
				dominator = entry.getKey();
				break;
			}
		}
		if (!found)
		{
			return -1;
		}

		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == dominator)
			{
				return i;
			}
		}
		return -1;
	}

	public int permCheck(int[] A)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		long sum = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (!set.add(A[i]))
			{
				return 0;
			}
			sum += A[i];
		}
		long shouldBe = 0;
		for (int i = 1; i <= A.length; i++)
		{
			shouldBe += i;
		}

		if (sum != shouldBe)
		{
			return 0;
		}
		return 1;
	}

	//return number of palindroms in S (if over 100million -> return -1)
	public int countPalindromicSlices(String S)
	{
		int count = 0;
		for (int i = 1; i < S.length(); i++)
		{
			for (int j = i - 1; j >= 0; j -= 2)
			{
				if (isPalindrome(S, j, i))
				{
					count++;
				}
			}
			for (int left = i - 1, right = i + 1; left >= 0 && right < S.length(); left--, right++)
			{
				if (isPalindrome(S, left, right))
				{
					count++;
				}
				else
				{
					break;
				}
			}
			if (count > 100000000)
			{
				break;
			}
		}
		return count;
	}

	public static int brackets(String S)
	{
		Stack<Character> stack = new Stack<Character>();
		try
		{
			for (int i = 0; i < S.length(); i++)
			{
				char c = S.charAt(i);
				if (c == '{' || c == '[' || c == '(')
				{
					stack.push(c);
				}
				else
				{
					boolean fail = false;
					char last = stack.pop();
					if (c == '}')
					{
						fail = (last != '{');
					}
					else if (c == ']')
					{
						fail = (last != '[');
					}
					else if (c == ')')
					{
						fail = (last != '(');
					}
					if (fail)
					{
						return 0;
					}
				}
			}
		}
		catch (EmptyStackException e)
		{
			return 0;
		}
		if (stack.size() == 0)
		{
			return 1;
		}
		return 0;
	}

	public static int maxProfit(int[] A)
	{
		if (A.length < 2)
		{
			return 0;
		}

		int maxDiff = 0;
		int minUpToNow = A[0];
		for (int i = 1; i < A.length; i++)
		{
			if (A[i] - minUpToNow > maxDiff)
			{
				maxDiff = A[i] - minUpToNow;
			}

			if (A[i] < minUpToNow)
			{
				minUpToNow = A[i];
			}
		}
		return maxDiff;
	}

	public static int simpleMaxProfit(int[] A)
	{
		if (A.length < 2)
		{
			return 0;
		}

		int max = 0;
		for (int i = 1; i < A.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				int diff = A[i] - A[j];
				if (diff > max)
				{
					max = diff;
				}
			}
		}
		return max;
	}

	public static int nesting(String S)
	{
		Stack<Character> stack = new Stack<Character>();
		try
		{
			for (char c : S.toCharArray())
			{
				if (c == '(')
				{
					stack.push(c);
				}
				else if (c == ')')
				{
					char last = stack.pop();
					if (last != '(')
					{
						return 0;
					}
				}
			}
		}
		catch (EmptyStackException e)
		{
			return 0;
		}
		return (stack.isEmpty()) ? 1 : 0;
	}

	public static int sigma2012(int[] H)
	{
		int heightBuilt = 0;
		int blocks = 0;
		while (heightBuilt < H.length)
		{
			int currentMinHeight = Integer.MAX_VALUE;
			boolean newBlock = false;
			for (int i = 0; i < H.length; i++)
			{
				int h = H[i];
				if (h <= heightBuilt)
				{//TODO dodać blok
					if (newBlock)
					{
						blocks++;
						newBlock = false;
						currentMinHeight = Integer.MAX_VALUE;
					}
					continue;
				}
				newBlock = true;
				if (currentMinHeight > h)
				{
					currentMinHeight = h;
				}
			}
			heightBuilt = currentMinHeight;
		}

		return blocks;
	}

	public static int minBlocksWall(int[] H)
	{
		long sum = 0;
		for (int i = 0; i < H.length; i++)
		{
			sum += H[i];
		}

		long buildSum = 0;
		int blocks = 0;
		while (buildSum < sum)
		{
			int currentMin = Integer.MAX_VALUE;
			boolean newBlock = false;
			for (int i = 0; i < H.length; i++)
			{
				int h = H[i];
				if (h == 0)
				{
					if (newBlock)
					{
						blocks++;
						newBlock = false;
						for (int j = i - 1; j >= 0 && H[j] > 0; j--)
						{
							buildSum += currentMin;
							H[j] -= currentMin;
						}
						break;
					}
					continue;
				}
				if (h < currentMin)
				{
					currentMin = h;
				}
				newBlock = true;
			}

			if (newBlock)
			{
				blocks++;
				for (int j = H.length - 1; j >= 0 && H[j] > 0; j--)
				{
					buildSum += currentMin;
					H[j] -= currentMin;
				}
			}
		}
		return blocks;
	}

	public static int fish(int[] A, int[] B)
	{
		int eaten = 0;
		Stack<Integer> downStack = new Stack<Integer>();

		for (int i = 0; i < A.length; i++)
		{
			if (B[i] == 1)
			{
				downStack.push(A[i]);
				continue;
			}

			// płynie w górę
			if (downStack.isEmpty()) // nie ma żadnej u góry płynącej w dół
			{
				continue;
			}
			else //konfrontacja
			{
				while (!downStack.isEmpty())
				{
					eaten++;
					int collFish = downStack.pop();
					if (collFish > A[i])
					{
						downStack.push(collFish);
						break;
					}
				}
			}
		}
		return A.length - eaten;
	}

	public static int equiLeader(int [] A)
	{
		int candidate = 0, size = 0;
		for (int i = 0; i < A.length; i++) {
			if (size == 0) {
				candidate = A[i];
				size++;
			} else if (candidate == A[i]) {
				size++;
			} else {
				size--;
			}
		}
		size = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) size++;
		}
		if (size <= A.length / 2) return 0;
		int count = 0, ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				count++;
			}
			if (count * 2 > i + 1 && (size - count) * 2 > A.length - i - 1) {
				ans++;
			}
		}
		return ans;
	}

	//100%
	public static int maxDoubleSliceSum(int[] A)
	{
		int[] leftMaxEndings = new int[A.length];
		int[] rightMaxEndings = new int[A.length];

		int actEnding = 0;
		for (int i = 1; i < A.length - 1; i++)
		{
			leftMaxEndings[i] = actEnding;
			actEnding = (A[i] + actEnding > 0) ? A[i] + actEnding : 0;
		}
		actEnding = 0;
		for (int i = A.length - 2; i > 0; i--)
		{
			rightMaxEndings[i] = actEnding;
			actEnding = (A[i] + actEnding > 0) ? A[i] + actEnding : 0;
		}

		int maxDoubleSlice = Integer.MIN_VALUE;
		for (int i = 1; i < A.length - 1; i++)
		{
			int doubleSlice = leftMaxEndings[i] + rightMaxEndings[i];
			maxDoubleSlice = (doubleSlice > maxDoubleSlice) ? doubleSlice : maxDoubleSlice;
		}
		return maxDoubleSlice;
	}

	//100%
	public static int maxSliceSum(int[] A)
	{
		int maxAct = A[0], maxSlice = A[0];
		for (int i = 1; i < A.length; i++)
		{
			maxAct = (maxAct + A[i] > A[i]) ? maxAct + A[i] : A[i];
			maxSlice = (maxAct > maxSlice) ? maxAct : maxSlice;
		}
		return  maxSlice;
	}

	//100%
	public static int maxSliceSum2(int[] A)
	{
		long[] sums = new long[A.length];
		long sum = 0;
		for (int i = 0; i < A.length; i++)
		{
			sum += A[i];
			sums[i] = sum;
		}

		long maxDiff = sums[0];
		long minUpToNow = sums[0];
		for (int i = 1; i < sums.length; i++)
		{
			if (sums[i] > maxDiff)
			{
				maxDiff = sums[i];
			}
			if (sums[i] - minUpToNow > maxDiff)
			{
				maxDiff = sums[i] - minUpToNow;
			}

			if (sums[i] < minUpToNow)
			{
				minUpToNow = sums[i];
			}
		}
		return (int)maxDiff;
	}

	public static int minPermimeterRectange(int N)
	{
		int minPer = Integer.MAX_VALUE;
		for(int i = 1; i*i <= N; i++ ){
			if(N%i == 0){
				int b = N/i;
				minPer = (2*b + 2*i < minPer)? 2*(i+b) : minPer;
			}
		}
		return minPer;
	}

	public static int peaks(int[] A)
	{
		int peaks = 0;
		int[] peaksSum = new int[A.length];

		for (int i = 1; i < A.length - 1; i++)
		{
			if (A[i - 1] < A[i] && A[i] > A[i + 1])
			{
				peaks++;
			}
			peaksSum[i] = peaks;
		}
		peaksSum[0] = 0;
		peaksSum[A.length - 1] = peaks;

		for (int i = 2; i <= A.length; i++)
		{
			if (A.length % i == 0)
			{
				boolean correct = true;
				int peaksPrev = 0;
				for (int k = i - 1, actPeaks = 1; k < A.length; k += i, actPeaks++)
				{
					if (peaksSum[k] < actPeaks || peaksSum[k] == peaksPrev)
					{
						correct = false;
						break;
					}
					peaksPrev = peaksSum[k];
				}
				if (correct)
				{
					return A.length / i;
				}
			}
		}
		return 0;
	}

	public static int boron2013(int[] A)
	{

		ArrayList<Integer> peaksPositions = new ArrayList<Integer>();
		int[] leftDistances = new int[A.length];
		int[] rigthDistances = new int[A.length];

		int dist = Integer.MAX_VALUE/2;
		for (int i = 1; i < A.length - 1; i++)
		{
			if (A[i - 1] < A[i] && A[i] > A[i + 1])
			{
				peaksPositions.add(i);
				leftDistances[i] = dist;
				dist = 0;
			}
			dist++;
		}

		rigthDistances[A.length - 1] = Integer.MAX_VALUE;
		if (peaksPositions.size()>1)
		{
			for (int i = peaksPositions.size() - 2; i >= 0; i++)
			{
				int peakThis = peaksPositions.get(i);
				int peakPrev = peaksPositions.get(i+1);
				rigthDistances[peakThis] = peakPrev - peakThis;
			}
		}

		for (int i = 0; i < A.length; i++)
		{
//			leftDistances[i] = (leftDistances)
		}
		int maxResult = peaksPositions.size();
		for (int i = maxResult; i > 0; i--)
		{
			int minDist = Integer.MAX_VALUE, actDist;
			for (int j = 1; j < peaksPositions.size(); j++)
			{
			}
		}
		return 0;
	}

	public static int boron2013_2(int[] A)
	{
		ArrayList<Integer> peaksPositions = new ArrayList<Integer>();
		for (int i = 1; i < A.length - 1; i++)
		{
			if (A[i - 1] < A[i] && A[i] > A[i + 1])
			{
				peaksPositions.add(i);
			}
		}

		double delta = Math.sqrt(4 * A.length + 5);
		int pMax = (int)((1+delta)/2);
		pMax = (peaksPositions.size() < pMax) ? peaksPositions.size() : pMax;

		for (int i = pMax; i > 0; i--)
		{
			int flagged = 0;
			int lastPosition = - Integer.MIN_VALUE/2;

			for (int peak : peaksPositions)
			{
				if (peak - lastPosition >= i)
				{
					flagged++;
					lastPosition = peak;
				}
			}
			if (flagged >= i)
			{
				return i;
			}
		}
		return 0;
	}

	public static int [] countNonDivisibleSimple(int[] A)
	{
		int results[] = new int[A.length];

		for (int i = 0; i < A.length; i++)
		{
			int divisors = 0;
			for (int j = 0; j < A.length; j++)
			{
				if (A[i] % A[j] != 0)
				{
					divisors++;
				}
			}
			results[i] = divisors;
		}
		return results;
	}

	public static int [] countNonDivisible(int[] A)
	{
		int results[] = new int[A.length];
		int counts[] = new int[2 * A.length + 1];

		for (int i = 0; i < A.length; i++)
		{
			counts[A[i]]++;

		}

		for (int i = 0; i < A.length; i++)
		{
			int divisors = 0;
			for (int j = 1; j * j <= A[i]; j++)
			{
				if (A[i] % j == 0)
				{
					divisors += counts[j];
					int b = A[i]/j;
					if (b != j)
					{
						divisors += counts[A[i] / j];
					}
				}
			}
			results[i] = A.length - divisors;
		}
		return results;
	}

	public static int greatestCommonDivisor(int a, int b)
	{
		if (a % b == 0)
		{
			return b;
		}
		return greatestCommonDivisor(b, a % b);
	}

	public static int leastCommonMultiple(int a, int b)
	{
		long mul = a * b;
		return (int)(mul / greatestCommonDivisor(a, b));
	}

	public static int chocolatesByNumbers(int N, int M)
	{
		int lcm = leastCommonMultiple(N, M);
		return lcm / M;
	}

	public static int[] countSemiprimes(int N, int[] P, int[] Q)
	{
		int[] results = new int[P.length];
		int[] FactorizationTable = new int[N+1];
		int[] semiProductsCount = new int[N + 1];

		// for every number find the smallest prime divisor
		for (int i = 2; i * i <= N; i++)
		{
			if (FactorizationTable[i] == 0)
			{
				for (int k = i * i; k <= N; k++)
				{
					if (FactorizationTable[k] == 0)
					{
						FactorizationTable[k] = i;
					}
					k += i;
				}
			}
		}

		for (int i = 0; i < P.length; i++)
		{

		}

		return results;
	}

	public static int commonPrimeDivisors(int[] A, int[] B)
	{

		return 0;
	}

	public static int binaryGap(int N)
	{
		int maxGap = 0, actGap = 0;
		boolean counting = false;
		while (N > 0)
		{
			if (N % 2 == 1)
			{
				if (counting)
				{
					maxGap = actGap > maxGap ? actGap : maxGap;
				}
				counting = true;
				actGap = 0;
			}else if (counting)
			{
				actGap++;
			}
			N /= 2;
		}

		return maxGap;
	}

    public static int breakChain(int A[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] < min) {
                min = A[i];
                minIndex = i;
            }
        }

        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] < min && Math.abs(i-minIndex)>1) {
                min2 = A[i];
            }
        }

        return (min+min2);
    }

    public static int pairsInArray(int[] A) {

        Arrays.sort(A);

        long pairs = 0;
        int sameValues = 0;
        int curValue=0;
        for (int i = 0; i<A.length; i++) {
            if (i == 0) {
                curValue = A[i];
            }
            if ((curValue != A[i] || i == A.length - 1) && sameValues > 1) {
                pairs += (sameValues*(sameValues-1))/2;
                sameValues = 0;
            }
            curValue = A[i];
            sameValues++;
            if (pairs > 1000000000) {
                return 1000000000;
            }
        }
        return (int)pairs;
    }

    public static int[] negativeRepresentation(int M) {

        ArrayList<Integer> binRep = new ArrayList<Integer>();

        while (M != 0) {
            int rest = (M % -2);
            M /= -2;
            if (rest < 0)
            {
                rest += 2;
                M += 1;
            }
            binRep.add(rest);
        }
        int [] res = new int[binRep.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = binRep.get(i);
        }
        return res;
    }

    public static int magnitudePole(int[] A) {

        int maxLeftNumbers[] = new int[A.length];
        int minRightNumbers[] = new int[A.length];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
            min = (A[j] < min) ? A[j] : min;
            max = (A[i] > max) ? A[i] : max;

            maxLeftNumbers[i] = max;
            minRightNumbers[j] = min;
        }

        for (int i = 0; i < A.length; i++) {
            if (maxLeftNumbers[i] <= A[i] && minRightNumbers[i] >= A[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int searchKMP(char[] w, char[] s, int[] t)
    {
        int m=0;
        int i=0;
        while( ((m + i) < s.length) && (i<w.length) )
        {
            if(s[m+i] == w[i]) i++;
            else
            {
                m += i - t[i];
                if (i > 0) i = t[i];
                i++;
            }
        }
        if(i == w.length) return m;
        else return -1;
    }

	public static int permMissingElement(int[] A)
	{
		if(A==null || A.length <1){
			return 1;
		}
		long sum = (A.length+1)*(1+A.length+1)/2;

		for(int i = 0; i<A.length; i++){
			sum -= A[i];
		}
		return (int)sum;
	}


}
















