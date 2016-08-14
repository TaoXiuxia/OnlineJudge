/**
 * 题目描述
 * 
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字                                           相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *  
 *  
 * 输入描述:
 * 输入 
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 
 * 输 出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * 
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String string = cin.nextLine();
			if (string.contains(".")) {
				String[] strings = string.split("\\.");
				long Total = 0;
				for (int i = 0; i < strings.length; i++) {
					if (i == 0) {
						Total += Long.parseLong(strings[i]) * 256 * 256 * 256;
					} else if (i == 1) {
						Total += Long.parseLong(strings[i]) * 256 * 256;
					} else if (i == 2) {
						Total += Long.parseLong(strings[i]) * 256;
					} else {
						Total += Long.parseLong(strings[i]);
					}
				}
				System.out.println(Total);
			} else {
				long IP = Long.parseLong(string);
				System.out.print(IP / 256 / 256 / 256);
				System.out.print(".");
				System.out.print((IP / (256 * 256)) % 256);
				System.out.print(".");
				System.out.print((IP / 256) % 256);
				System.out.print(".");
				System.out.println(IP % 256);
			}
		}
	}
}