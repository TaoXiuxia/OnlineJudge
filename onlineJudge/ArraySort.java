/**
 * 题目描述
 * 
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙。
 * 
 * 输入描述:
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * 
 * 输出描述:
 * Lily的所有图片按照从小到大的顺序输出
 * 
 * 输入例子:
 * Ihave1nose2hands10fingers
 * 
 * 输出例子:
 * 0112Iaadeeefghhinnnorsssv
 */

/**
 * 就是数组按照顺序排序
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			char[] ch = input.toCharArray();
			char[] sorted = new char[ch.length];
			int k = 0;

			/**
			 * 先排列数字
			 */
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < ch.length; j++) {
					if ((ch[j] - '0') == i) {
						sorted[k] = ch[j];
						k++;
					}
				}
			}

			/**
			 * 排列大写字母
			 */
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < ch.length; j++) {
					if ((ch[j] - 'A') == i) {
						sorted[k] = ch[j];
						k++;
					}
				}
			}

			/**
			 * 摆列小写字母
			 */
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < ch.length; j++) {
					if ((ch[j] - 'a') == i) {
						sorted[k] = ch[j];
						k++;
					}
				}
			}
			System.out.println(String.valueOf(sorted));
		}
	}
}