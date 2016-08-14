/**
 * 题目描述
 * 
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * 
 * 
 * 输入描述:
 * 输入一个字符串
 * 
 * 
 * 输出描述:
 * 返回有效密码串的最大长度
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			System.out.println(getPalindrome(str).length());
		}
	}

	public static String getPalindrome(String s) {
		char[] ch = s.toCharArray();
		String str = ""; // 存储最长的回文子串
		String temp = "";
		for (int i = 0; i < ch.length; i++) {
			temp = getLongestPlalindrome(ch, i, i + 1);  // 偶数回文
			if (temp.length() > str.length()) {
				str = temp;
			}
			temp = getLongestPlalindrome(ch, i, i);  // 奇数回文
			if (temp.length() > str.length()) {
				str = temp;
			}
		}
		return str;
	}

	/**
	 * 求以i和j为中心的字符数组的最长回文
	 * @param ch
	 * @param i
	 * @return
	 */
	public static String getLongestPlalindrome(char[] ch, int i, int j) {
		int len = ch.length;
		while (i >= 0 && j <= len - 1 && ch[i] == ch[j]) {
			i--;
			j++;
		}
		return String.valueOf(ch).substring(i + 1, j);
	}
}
