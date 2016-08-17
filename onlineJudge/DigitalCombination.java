
/**
 * 题目：
 * 
 * 任意1-121之间的数都可以通过{1,3,9,27,81}这5个数字通过加减的方式组合而来（每个数字只出现一次）
 * 给定一个数字（1-121）
 * 输出这样的加减组合（大数在前，小数在后）
 * 
 * 
 * 解决方法：
 * 
 * 使用平衡三进制的方式计算
 * 
 * 平衡三进制：一般三进制是有0，1，2组成，平衡三进制有-1，0，1组成
 * 在计算的过程中，如果余数是2，那么将该余数变为-1，同时 商+1 即可计算出 平衡三进制
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(function(72));
	}

	public static String function(int n) {
		String res = "";
		int[] array = { 1, 3, 9, 27, 81 };

		String balancedTernary = getBalancedTernary(n);
		char[] ch = balancedTernary.toCharArray();
		int len = ch.length;

		for (int i = 0; i < len; i++) {
			if (ch[i] == 'T') {
				res = res + "-" + array[len - 1 - i];
			} else if (ch[i] == '1') {
				res = res + "+" + array[len - 1 - i];
			}
		}
		return res.substring(1);
	}

	public static String getBalancedTernary(int n) {
		String res = "";  
		int remainder = 0; // 余数
		while (n > 0) {
			remainder = n % 3;
			n = n / 3;
			if (remainder == 2) {
				n += 1;
				remainder = -1;
			}
			if (remainder == -1) {  // 用T表示-1
				res = "T" + res;
			} else {
				res = remainder + res;
			}
		}
		return res;
	}
}
