import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC = 0; TC < tc; TC++) {
			// 1. 입력받기
			String a = sc.next();
			int sum = 0;
			Stack<Character> stack = new Stack<>();

			// 2. stack을 이용한 검사
			for (int i = 0; i < a.length(); i++) {
				// 레이저를 만나면?
				if (a.charAt(i) == '(' && a.charAt(i + 1) == ')') {
					sum += stack.size();
					i++;
				}
				// 왼쪽 괄호를 만나면?
				else if (a.charAt(i) == '(') {
					stack.push(a.charAt(i));
				}
				// 오른쪽 괄호를 만나면?
				else if (a.charAt(i) == ')'){
					stack.pop();
					sum += 1;
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", TC+1, sum);
		}
	}
}