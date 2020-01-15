package mini1;
import java.util.Arrays;
public class LoopsAndArraysTest {
	public static void main(String[] args) {
		//LoopsAndArrays idk = new LoopsAndArrays();
		int[] a = {0, 1, 2, 3, 4, 5};
		int[] b = {50, 40, 30, 20, 10, 0, -10, -20};
		int[] c = {0, 53, 15, 2};
		int[] d = {1, 2, 3, 5, 10, 120};
		int[] e = {0, 1};
		
		System.out.println("---arrayToString---");
		System.out.println("543210 | " + LoopsAndArrays.arrayToString(a));
		System.out.println("215530 | " + LoopsAndArrays.arrayToString(c));
		
		
		System.out.println("--numFirstChar---");
		System.out.println("2 | " + LoopsAndArrays.numFirstChar("i I i I"));
		System.out.println("3 | " + LoopsAndArrays.numFirstChar("pepperoni"));
		
		
		System.out.println("---countMatches---");
		System.out.println("5 | " + LoopsAndArrays.countMatches("abcdef", "Abcdef"));
		System.out.println("3 | " + LoopsAndArrays.countMatches("aaccee", "abcdef"));
		
		
		System.out.println("---Arithmetic---");
		System.out.println("true  | " + LoopsAndArrays.isArithmetic(a));
		System.out.println("true  | " + LoopsAndArrays.isArithmetic(b));
		System.out.println("false | " + LoopsAndArrays.isArithmetic(c));
		System.out.println("false | " + LoopsAndArrays.isArithmetic(d));
		System.out.println("true | " + LoopsAndArrays.isArithmetic(e));
		
		
		System.out.println("---Ascending---");
		System.out.println("true  | " + LoopsAndArrays.isAscending(a));
		System.out.println("false | " + LoopsAndArrays.isAscending(b));
		System.out.println("false | " + LoopsAndArrays.isAscending(c));
		System.out.println("true  | " + LoopsAndArrays.isAscending(d));
		
		System.out.println("---CountSubStrings---");
		System.out.println("1 | " + LoopsAndArrays.countSubstringsWithOverlap("ian", "Christian"));
		System.out.println("2 | " + LoopsAndArrays.countSubstringsWithOverlap("ian", "Christian ianson"));
		System.out.println("4 | " + LoopsAndArrays.countSubstringsWithOverlap("aa", "aaaaa"));
		System.out.println("0 | " + LoopsAndArrays.countSubstringsWithOverlap("ab", "aaaaa"));
		
		
		//{0, 1, 2, 3, 4, 5} with {0, 53, 15, 2}
		//0 0 1 53 2 15 3 2 4 5
		System.out.println("---interLeaveArray---");//look at arrays above and the method is called there. Array ab
		System.out.println("0 0 1 53 2 15 3 2 4 5 ");
		int[] ac = LoopsAndArrays.interleaveArray(a, c);
		for (int i = 0; i < ac.length; i++)	{
			System.out.print(ac[i] + " ");
		}
		//{0, 1, 2, 3, 4, 5} with {0, 1}
		System.out.println("\n0 0 1 1 2 3 4 5");
		int[] ae = LoopsAndArrays.interleaveArray(a, e);
		for (int i = 0; i < ae.length; i++)	{
			System.out.print(ae[i] + " ");
		}
		
		
		
		System.out.println("\n---Collatz---");
		System.out.println("[1, 4, 2, 1] | " + Arrays.toString(LoopsAndArrays.collatz(1, 3)));
		System.out.println("[25, 76, 38, 19, 58, 29] | " + Arrays.toString(LoopsAndArrays.collatz(25, 5)));
		
	}
}
