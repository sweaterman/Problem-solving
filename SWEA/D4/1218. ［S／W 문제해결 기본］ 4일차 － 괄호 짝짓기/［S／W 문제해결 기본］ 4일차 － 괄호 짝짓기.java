import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	for (int tc=0; tc<10; tc++) {
		int n = sc.nextInt();
		String t = sc.next();
		System.out.printf("#%d %d\n", tc+1, check(t)?1:0);
		}
	}
	
	static boolean check(String t) {
		Stack<Character> stack = new Stack<>();
		int idx = 0;
		while (idx < t.length()) {
			//왼쪽괄호를 만날 때
			if (t.charAt(idx) == '(' || t.charAt(idx) == '{' || t.charAt(idx) == '[' || t.charAt(idx) == '<') {
				stack.push(t.charAt(idx++));
			}
			
			//오른쪽 괄호를 만날 때
			else if (t.charAt(idx) == ')' || t.charAt(idx) == '}' || t.charAt(idx) == ']' || t.charAt(idx) == '>') {
				if (stack.isEmpty()) {
					return false;
				}
				char c = stack.pop();
				
				//stack에서 꺼낸 왼쪽 괄호와 오른쪽 괄호가 매치되는지 확인
				switch(c) {
				case '(':
					if (t.charAt(idx)!=')') return false;
					break;
				case '{':
					if (t.charAt(idx)!='}') return false;
					break;
				case '[':
					if (t.charAt(idx)!=']')	return false;
					break;
				case '<':
					if (t.charAt(idx)!='>') return false;
					break;
				}
				idx++;
			}
		}
		//괄호가 남아있다면?
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}