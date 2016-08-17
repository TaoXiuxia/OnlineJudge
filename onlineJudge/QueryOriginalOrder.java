/**
 * 小明同学把1到n这n个数字按照一定的顺序放入个一个队列Q中，现在他对这个队列Q执行：
 * while(!Q.empty()){
 *     int x = Q.front();
 *     Q.pop();
 *     Q.push(x);
 *     x = Q.front();
 *     printf("%d\n", x);
 *     Q.pop();
 * }
 * 其中 做取出队头的值操作时，并不弹出当期队头
 * 假设输出的是1,2,3,4,5,6
 * 求输入的数组是什么？
 * 
 * 
 * 解题过程：
 * 题目中输出的过程即：
 *    取队头，放至队尾；
 *    取队头，输出；
 *    取队头，放至队尾；
 *    取队头，输出；
 *    ...
 * 即 每隔一个数字输出一个数字
 * 其逆过程就是每隔一个数字放回一个数字
 */
public class QueryOriginalOrder {

	public static void main(String[] args) {
		int[]array = {1,2,3,4,5,6};
		int[] res = function(array);
		for(int i:res){
			System.out.print(i);
		}
	}

	public static int[] function(int []array){
		int len = array.length;
		int[] res = new int[len];
		for(int i=0;i<len;i++){
			res[i] = -1;
		}
		
		int no=1; //标记位，每跳过一个数写入一个数
		int k=0;  // 数组array的计数器
		int i=0;  // 数组res的计数器
		while(contains(res,-1)){
			if(i>=len){
				i=0;
			}
			if(res[i]==-1){
				if(no==1){
					no=2;
				}else{
					res[i]=array[k];
					no=1;
					k++;
				}
			}
			i++;
		}
		
		return res;
		
	}
	
	/**
	 * 判断一个数组array中是否包含了数字n
	 * 
	 * @param array
	 * @param n
	 * @return
	 */
	public static boolean contains(int[]array,int n){
		for(int i:array){
			if(i==n)
				return true;
		}
		return false;
	}
	
}
