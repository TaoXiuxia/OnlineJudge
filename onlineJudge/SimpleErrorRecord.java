/**
 * 题目描述
 * 
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *  
 * 处理： 
 *  
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 *  
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 *  
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * 
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * 
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * 
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class SimpleErrorRecord {

	static Map<String, Integer> map = new TreeMap<String, Integer>();
	static Queue<String> queue = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if (str != null) {
				function(str);
			}
		}

		Iterator<String> qIterator = queue.iterator();
		while (qIterator.hasNext()) {
			String str = qIterator.next();
			String fileName = str.split(" ")[0];
			String line = str.split(" ")[1];

			if (fileName.length() > 16) {
				fileName = fileName.substring(fileName.length() - 16);
			}
			System.out.println(fileName + " " + line + " " + map.get(str));
		}
	}

	public static void function(String str) {
		String[] tempFileName = str.split("\\\\");

		String netFileName = tempFileName[tempFileName.length - 1];
		if (map.containsKey(netFileName)) {
			map.put(netFileName, map.get(netFileName) + 1);
			return;
		} else {
			map.put(netFileName, 1);
		}

		if (queue.size() < 8) {
			queue.offer(netFileName);
		} else {
			queue.poll();
			queue.offer(netFileName);
		}
	}
}
