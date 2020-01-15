package mini2;

/**
 * This class contains seven methods that all do something using recursion
 * @author Christian Lisle
 *
 */
public class Mini2 {

	/**
	 * Returns a string containing only the characters of s whose position in s,
	 * counting from 1, is zero mod n. No credit if your solution uses a loop. For
	 * instance, given the parameters s = "abcabcabcabca" and n = 3, the output
	 * should be "cccc".
	 * 
	 * @param s
	 *            The input string
	 * @param n
	 *            The position modulus
	 * @return The new string
	 */
	public static String everyNth(String s, int n) {
		if (n > s.length()) {
			return "";
		}
		return s.charAt(n - 1) + everyNth(s.substring(n), n);
	}

	/**
	 * Returns a string containing only the characters of s whose position in s,
	 * counting from 1, is non-zero mod n. No credit if your solution uses a loop.
	 * For instance, given the parameters s = "abcabcabcabca" and n = 3, the output
	 * should be "ababababa".
	 * 
	 * @param s
	 *            The input string
	 * @param n
	 *            The position modulus
	 * @return The new string
	 */
	public static String noNth(String s, int n) {
		if (n > s.length()) {
			return s.substring(0);
		}
		return s.substring(0, n - 1) + noNth(s.substring(n), n);
	}

	/**
	 * Returns a copy of the input in which all contiguous sequences of identical
	 * characters are reduced to a single instance of that character. No credit if
	 * your solution uses a loop. For instance, on input "Foo bar bazzzzz !!", the
	 * output should be "Fo bar baz !"
	 * 
	 * @param s
	 *            The input string
	 * @return The new string
	 */
	public static String unique(String s) {
		if (s.length() <= 1) {
			return s;
		}
		if (s.charAt(1) == s.charAt(0)) {
			return unique(s.substring(1));
		}
		return s.charAt(0) + unique(s.substring(1));
	}

	/**
	 * Returns the value of the numeric String number when converted to an integer.
	 * Use Character.getNumericValue() to get the numeric value of individual
	 * characters in number. No credit if your solution uses a loop or calls
	 * Integer.parseInt(). For instance, on input "12345" returns 12345.
	 * 
	 * @param number
	 *            A String consisting only of digit characters
	 * @return The String converted to an int
	 */
	public static int toInt(String number) {
		if (number.length() == 1) {
			return Character.getNumericValue(number.charAt(0));
		}
		if (number.charAt(0) == '-')	{
			return 0 - toInt(number.substring(1));
		}
		// change the actual value of current number. Example: the 2 in "12345" is has a value of 2,000, not just 2
		return (int) (Character.getNumericValue(number.charAt(0)) * (pow(10, number.length() - 1))) + toInt(number.substring(1));
	}

	/**
	 * Returns true if and only if the String s contains only matched brackets.
	 * There are four bracket types: '(' matches ')', '<' matches '>', '[' matches
	 * ']', and '{' matches '}' The opening bracket must always precede the matching
	 * closing bracket. A sequence of brackets is matching if it is empty, if it is
	 * an opening bracket immediately followed by its corresponding closing bracket,
	 * or if it is an opening bracket followed by a matched sequence of brackets and
	 * ends with a closing bracket. For instance, the following sequences are
	 * matched: "", "()", "<((({[]})))>()()[{}]<>" and these are unmatched: "{",
	 * "(])", ")(", "<((({[]}))>()()[{}]<>" HINT: This solution will need a loop to
	 * search for a pair of neighboring, matched braces. No credit if your solution
	 * uses more than one loop.
	 * 
	 * @param s
	 *            A String containing only characters in the set of 8 brackets.
	 * @return true if the input sequence is matched, else false
	 */
	public static boolean isMatched(String s) {
		boolean isMatched = true;
		char searchFor = '.';
		if (s.length() <= 1) {
			return (s.length() == 0) ? isMatched : false;
		}
		
		for (int i = 0; i < s.length() - 1; i++) {
			switch(s.charAt(i))	{
			case '(':
				searchFor =  ')';
				break;
			case '[':
				searchFor = ']';
				break;
			case '{':
				searchFor = '}';
				break;
			case '<':
				searchFor = '>';
				break;
			default:
				return false;
			}
			if (s.charAt(i+1) == searchFor) {
				s = s.substring(0, i) + s.substring(i+2);
				break;
			}
		}
		return isMatched(s);
	}

	/**
	 * Efficiently computes b^exponent (where ^ is the exponentiation operator; that
	 * is 2^2 is 2 squared). No credit if your solution uses a loop. b=base b^0 = 1,
	 * b^exponent = b * b^(exponent-1), and b^exponent = (b^(exponent/2))^2 =
	 * b^(exponent/2) * b^(exponent/2).
	 * 
	 * @param base
	 *            The base
	 * @param exponent
	 *            The exponent
	 * @return Base raised to the power exponent
	 */
	public static double pow(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		return base * pow(base, exponent - 1);
	}
}
