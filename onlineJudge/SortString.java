/**
 * 题目描述
 * 
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则1：英文字母从A到Z排列，不区分大小写。
 *     如，输入：Type 输出：epTy
 * 规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *     如，输入：BabA 输出：aABb
 * 规则3：非英文字母的其它字符保持原来的位置。
 *     如，输入：By?e 输出：Be?y
 * 样例：
 *    输入：
 *    A Famous Saying: Much Ado About Nothing(2012/8).
 *    输出：
 *    A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			char[] c = str.toCharArray();
			function(c);
			System.out.println(String.valueOf(c));
		}
	}

	public static void function(char[] c) {

		char[] temp = new char[c.length]; // temp用来存储有顺序的字母
		int k = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[j] - 'a' == i || c[j] - 'A' == i) {  //按照字母表的顺序排列
					temp[k] = c[j];
					k++;
				}
			}
		}

		k = 0;
		for (int i = 0; i < c.length; i++) {
			if ((c[i] >= 65 && c[i] <= 90) || (c[i] >= 97 && c[i] <= 122)) {
				c[i] = temp[k];
				k++;
			}
		}
	}
}
