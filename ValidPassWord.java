/**
题目描述

密码要求:
 
  
1.长度超过8位
 
2.包括大小写字母.数字.其它符号,以上四种至少三种
  
3.不能有相同长度超2的子串重复
  
 
说明:长度超过2的子串


输入描述:
一组或多组长度超过2的子符串。每组占一行


输出描述:
如果符合要求输出：OK，否则输出NG
**/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str= scanner.next();
			function(str);
		}
	}
	
	public static void function(String str) {
		if (str.length() > 8 && !sameSubString(str) && Symbol(str)) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}
	}
	
	/**
	 * 是否包含相同子字符串，
	 * 		基本思想：先取长度为3的子字符串sub1，查看剩下的长度的子字符串sub2中是否包含了sub1
	 * @param str
	 * @return 包含返回true，不包含返回false
	 */
	public static boolean sameSubString(String str) {
		for (int i = 0; i < str.length() - 3; i++) {
			String sub1 = str.substring(i, i + 3);
			String sub2 = str.substring(i + 3, str.length());
			if (sub2.contains(sub1)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否有三种以上符号类型
	 * @param str
	 * @return
	 */
	public static boolean Symbol(String str) {
		int upper = 0;
		int lower = 0;
		int digit = 0;
		int other = 0;

		for (char ch : str.toCharArray()) {
			if (ch >= 48 && ch <= 57) {
				digit = 1;
				continue;
			}
			if (ch >= 65 && ch <= 90) {
				upper = 1;
				continue;
			}
			if (ch >= 97 && ch <= 122) {
				lower = 1;
				continue;
			}
			other = 1;
		}
		return (upper + lower + digit + other) >= 3;
	}
	
}
