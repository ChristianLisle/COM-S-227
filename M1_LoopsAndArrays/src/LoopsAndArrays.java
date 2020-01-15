package mini1;
/**
 * This class contains methods that are related to Loops and Arrays.
 * @author Christian Lisle
 *
 */
public class LoopsAndArrays {
	/**
	 * Returns a string which contains the elements in an array in reverse order
	 * @param array
	 * @return
	 */
	public static String arrayToString(int[] array)	{
		String output = "";
		for (int i = array.length - 1; i >= 0; i--) {
			output += array[i]; 
		}
		return output;
	}
	
	/**
	 * Given integer start and integer numIterations, return an array containing the Collatz sequence beginning with start up to numIterations
	 * @param start
	 * @param numIterations
	 * @return
	 */
	public static int[] collatz(int start, int numIterations)	{
		int[] output = new int[numIterations + 1];
		output[0] = start;
		for (int i = 1; i < output.length; i++)	{
			if (start % 2 != 0) {
				start = 3*start + 1;
			}
			else	{
				start /= 2;
			}
			output[i] = start;
			numIterations++;
		}
		return output;
	}
	
	/**
	 * Counts the number of positions in a pair of strings that have matching characters.
	 * @param s given string
	 * @param t given string
	 * @return number of matches
	 */
	public static int countMatches(String s, String t)	{
		int counter = 0;
		for (int i = 0; i < s.length() && i < t.length(); i++) {
			if (s.charAt(i) == t.charAt(i))	{
				counter ++;
			}
		}
		return counter;
	}
	
	/**
	 * Counts the number of times that one string occurs as a substring in another
	 * @param t target string
	 * @param s string in which we are looking
	 * @return number of times that one string occurs as a substring in another
	 */
	public static int countSubstringsWithOverlap(String t, String s) {
		int count = 0, index = 0;
		while (index != -1)	{
			index = s.indexOf(t, index);
			if (index != -1) {
				count ++;
				index ++;
			}
		}
		return count;
	}
	
	/**
	 * Given two arrays, return the array which interleaves the elements of the two arrays
	 * @param a The first array
	 * @param b The second array
	 * @return The result of the interleaved array
	 */
	public static int[] interleaveArray(int[] a, int[] b)	{
		int[] output = new int[(a.length + b.length)];
		int x = 0;
		for (int i = 0; i < output.length; i++)	{
			if (i < a.length) {
				output[x] = a[i];
				x++;
			}
			if (i < b.length)	{
				output[x] = b[i];
				x++;
			}
		}
		return output;
	}
	
	/**
	 * Given an array of integers, returns true if the numbers form an arithmetic sequence
	 * (a sequence in which each value differs from the previous one by a fixed amount)
	 * @param array
	 * @return Whether or not the numbers in the array form an arithmetic sequence
	 */
	public static boolean isArithmetic(int[] array)	{
		boolean result = array.length == 1 ? true : false;
		int sumDifference;
		if (array.length >= 2)	{
			sumDifference = array[1] - array[0]; //Difference between a[0] and a[1]
			if (array.length == 2 && sumDifference > 0)	{
				return true;
			}
			for (int i = 1; i < array.length - 1; i++)	{
				if (array[i + 1] - array[i] == sumDifference)	{
					result = true;
				}
				else	{
					return false;
				}
			}
		}
		return result;
	}
	
	/**
	 * Given an array of integers, return whether the array is in ascending order
	 * (duplicates are not allowed)
	 * @param a
	 * @return
	 */
	public static boolean isAscending(int[] a)	{
		boolean output = a.length == 1 ? true : false;
		for (int i = 0; i < a.length - 1; i++)	{
			if (a[i + 1] > a[i])	{
				output = true;
			}
			else	{
				return false;
			}
		}
		return output;
	}
	
	/**
	 * Counts the number of times the first character of a string appears
	 * @param s 
	 * @return
	 */
	public static int numFirstChar(String s) {
		if (s.length() == 0)	{
			return 0;	
		}
		char first = s.charAt(0);
		int counter = 0;
		for (int i = 0; i < s.length(); i++)	{
			if ((s.charAt(i)) == first)	{
				counter ++;
			}
		}
		return counter;
	}
}
