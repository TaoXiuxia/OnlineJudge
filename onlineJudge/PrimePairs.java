/**
 * 题目描述
 * 
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
 * 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 * 
 * 输入:
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 * 输出:
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *  
 * 
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 
 * 
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 * 
 * 输入例子:
 * 4
 * 2 5 6 13
 * 
 * 输出例子:
 * 2
 */

/**
 *   动态规划
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] v = new int[n];
			for (int i = 0; i < n; i++) {
				v[i] = scanner.nextInt();
			}
			System.out.println(countPrimePairs(v));
		}
	}

	private static int countPrimePairs(int[] v) {
		int[] dp = new int[v.length + 1];
		for (int i = v.length - 2; i > -1; i--) {
			for (int j = v.length - 1; j > i; j--) {
				int cnt = isPrime(v[i] + v[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1) : dp[i + 1];
				dp[i] = (cnt > dp[i]) ? cnt : dp[i];
			}
		}
		return dp[0];
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int s = (int) Math.sqrt(n);
		for (int i = 2; i <= s; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
