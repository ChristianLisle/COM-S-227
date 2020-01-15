package mini1;
import java.util.Arrays;

public class LoopsAndArraysTest2 {
	public static void main(String args[]){
		  System.out.println("arrayToString: " + LoopsAndArrays.arrayToString(new int[]{1, 2, 3, 4}) + "(should be 4321)");
		  System.out.println("collatz: " + Arrays.toString(LoopsAndArrays.collatz(7,3)) + "(should be [7, 22, 11, 34])");
		  System.out.println("countMatches: " + LoopsAndArrays.countMatches("abcde", "xbydcazzz") + "(should be 2)");
		  System.out.println("countSubstringsWithOverlap: " + LoopsAndArrays.countSubstringsWithOverlap("aa", "aaaaa") + "(should be 4)");
		  System.out.println("interleaveArray: " + Arrays.toString(LoopsAndArrays.interleaveArray(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7, 8})) + "(should be [1, 4, 2, 5, 3, 6, 7, 8])");
		  System.out.println("isArithmic: " + LoopsAndArrays.isArithmetic(new int[]{2, 4, 7}) + "(should be false)");
		  System.out.println("isArithmic2: " + LoopsAndArrays.isArithmetic(new int[]{2, 4, 6, 8}) + "(should be true)");
		  System.out.println("isAscending: " + LoopsAndArrays.isAscending(new int[]{1, 2, 3}) + "(should be true)");
		  System.out.println("isAscending: " + LoopsAndArrays.isAscending(new int[]{1, 3, 3}) + "(should be flase)");
		  System.out.println("numFirstChar: " + LoopsAndArrays.numFirstChar("computer science") + "(should be 3)");
		}
}
