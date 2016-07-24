/**
题目描述

请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 
所有的IP地址划分为 A,B,C,D,E五类
 
A类地址1.0.0.0~126.255.255.255; 
 
B类地址128.0.0.0~191.255.255.255; 
 
C类地址192.0.0.0~223.255.255.255;
 
D类地址224.0.0.0~239.255.255.255；
 
E类地址240.0.0.0~255.255.255.255
  
 
私网IP范围是：
 
10.0.0.0～10.255.255.255
 
172.16.0.0～172.31.255.255
 
192.168.0.0～192.168.255.255
 
 
 
子网掩码为前面是连续的1，然后全是0


输入描述:
多行字符串。每行一个IP地址和掩码，用~隔开。


输出描述:
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。

**/


import java.util.Scanner;

public class IP {
	static int A = 0;
	static int B = 0;
	static int C = 0;
	static int D = 0;
	static int E = 0;
	static int InValid = 0;
	static int P = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			function(str);
		}
		System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + InValid + " " + P);
	}

	public static void function(String str) {
		String ip = str.split("~")[0];
		String mask = str.split("~")[1];
		countIP(ip, mask);
	}

	/**
	 * 分类IP： A, B, C, D, E, 错误IP或错误掩码, 私有IP
	 * 
	 * @param strIP
	 * @return
	 */
	public static void countIP(String strIP, String strMask) {
		String[] ipStrArray = strIP.split("\\.");
		String[] maskStrArray = strMask.split("\\.");
		if (ipStrArray.length != 4||maskStrArray.length!=4) {
			InValid++;
			return;
		}

		int[] ip = new int[4];
		int[] mask = new int[4];
		try {
			for (int i = 0; i < 4; i++) {
				ip[i] = Integer.parseInt(ipStrArray[i]);
				mask[i]= Integer.parseInt(maskStrArray[i]);
			}
		} catch (Exception e) {
			InValid++;
			return;
		}

		if (!isValidMask(mask)) {
			InValid++;
			return;
		}

		if (isPrivate(ip)) {
			P++;
		}

		if (ip[0] >= 1 && ip[0] <= 126) {
			A++;
		}

		if (ip[0] >= 128 && ip[0] <= 191) {
			B++;
		}
		
		if (ip[0] >= 192 && ip[0] <= 223) {
			C++;
		}

		if (ip[0] >= 224 && ip[0] <= 239) {
			D++;
		}

		if (ip[0] >= 240 && ip[0] <= 255) {
			E++;
		}
	}

	/**
	 * 判断是否是私网ip
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isPrivate(int[] ip) {
		if (ip[0] == 10) {
			return true;
		}
		if (ip[0] == 172 && (ip[1] >= 16 && ip[1] <= 31)) {
			return true;
		}
		if (ip[0] == 192 && ip[1] == 168) {
			return true;
		}
		return false;
	}

	/**
	 * 是否是合法的子网掩码
	 * 
	 * @param mask
	 * @return
	 */
	public static boolean isValidMask(int[] mask) {
		
		for (int i = 0; i < 4; i++) {
			if (mask[i] < 0 || mask[i] > 255) {
				return false;
			}
		}

		String maskBinary = "";
		for (int i = 0; i < 4; i++) {
			maskBinary += Integer.toBinaryString(mask[i]);
		}

		int index = maskBinary.indexOf("0");
		maskBinary = maskBinary.substring(index + 1);	//index+1 --> 防止出现IndexOutOfBoundsException：在mask全都是1的情况下，index是-1，
		if (maskBinary.contains("1")) {
			return false;
		}
		return true;
	}
}
