import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<10; tc++) {
			int n = sc.nextInt();
			String tokens = sc.next();
			String post = change(tokens); //후위 표기식으로 변경
			System.out.printf("#%d %d\n", tc+1, cal(post));
		}
	}
	
	//후위 표기식으로 변경하여 저장
	static String change(String t) {
		Stack<Character> stack = new Stack<>();
		String postfix = null;
		for (int i=0; i<t.length(); i++) {
			//연산자라면?
			if (t.charAt(i) == '+') {
				stack.push(t.charAt(i));
			}
			
			//피연산자라면?
			else {
				if (postfix==null) {
					postfix = Character.toString(t.charAt(i));
					continue;
				}
				postfix += t.charAt(i);
			}
		}
		while (stack.size()!=0) {
			postfix += stack.pop();
		}
		return postfix;
	}
	
	static int cal(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<postfix.length(); i++) {
			//연산자라면?
			if(postfix.charAt(i)=='+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b+a);
			}
			//피연산자라면?
			else {
				stack.push(Character.getNumericValue(postfix.charAt(i)));
			}
		}
		return stack.pop();
	}
}