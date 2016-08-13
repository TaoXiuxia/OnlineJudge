/**
 * 题目描述
 * 
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 * 
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			System.out.println(function(str));
		}

	}

	public static String function(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (char c : str.toCharArray()) {
			String s = c + "";
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		int min = getMin(map);

		Iterator<String> i = map.keySet().iterator();
		while (i.hasNext()) {
			String temp = i.next();
			if (map.get(temp) == min) {
				str = str.replaceAll(temp, "");	// replaceAll是生成一个新的字符串，而不是在原有基础上修改。
			}
		}
		return str;
	}

	public static int getMin(Map<String, Integer> map) {
		int min = 20;
		Iterator<String> i = map.keySet().iterator();
		while (i.hasNext()) {
			if (min > map.get(i.next())) {
				min = map.get(i.next());
			}
		}
		return min;
	}
}
