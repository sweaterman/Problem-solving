import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc<10; tc++) {
			int n = sc.nextInt();
			String tokens = sc.next();
			String postfix = change(tokens);
			System.out.printf("#%d %d\n", tc+1, cal(postfix));
		}
	}
	
	//후위 표기식으로 변경하여 저장
	static String change(String t) {
		Stack<Character> stack = new Stack<>();
		String postfix = null;
		//연산자 우선순위 저장
		Map<Character, Integer> icp = new HashMap<>();
		Map<Character, Integer> isp = new HashMap<>(); 
		icp.put('+', 1); icp.put('*', 2); icp.put('(', 3);
		isp.put('(', 0); isp.put('+', 1); isp.put('*', 2);   
		Set<Character> oper = icp.keySet();
		
		for (int i=0; i<t.length(); i++) {
			//닫힌 괄호라면?
			if (t.charAt(i) == ')') {
				char tmp = ' ';
				while(tmp!='(') {
					tmp = stack.pop();
					if (tmp!='('){
						postfix += tmp;
					}
				}
			}
			
			//연산자라면?
			else if (oper.contains(t.charAt(i))) {
				// 우선순위가 낮을 때 그만큼 꺼내고 push
				if (stack.size() == 0) {
					stack.push(t.charAt(i));
					continue;
				}
				while(icp.get(t.charAt(i))<=isp.get(stack.get(stack.size()-1))) {
					postfix += stack.pop();
				}
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
			if(postfix.charAt(i)=='+' || postfix.charAt(i)=='*') {
				int a = stack.pop();
				int b = stack.pop();
				
				switch (postfix.charAt(i)) {
				case '+':
					stack.push(b+a); break;
				case '*':
					stack.push(b*a); break;
				}
			}
			//피연산자라면?
			else {
				stack.push(Character.getNumericValue(postfix.charAt(i)));
			}
		}
		return stack.pop();
	}
}