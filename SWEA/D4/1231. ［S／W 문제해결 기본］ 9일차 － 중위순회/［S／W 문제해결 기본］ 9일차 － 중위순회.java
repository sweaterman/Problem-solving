import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution
{
    static void inorder(Map<Integer, Character> tree, int num) {
		if (tree.containsKey(num*2)) { //왼쪽 자식이 있다면?
			inorder(tree, num*2);
		}
		System.out.printf("%c", tree.get(num));
		if (tree.containsKey(num*2+1)) { //오른쪽 자식이 있다면?
			inorder(tree, num*2+1);
		}
	}
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		//테스트 케이스
		for(int tc=0; tc<10; tc++) {
			//1. 입력받기
			Map<Integer, Character> tree = new HashMap<>();
			int size = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<size; i++) {
				st = new StringTokenizer(sc.nextLine());
				tree.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
			}
			
			//2. 중위 순회
			System.out.printf("#%d ", tc+1);
			inorder(tree, 1);
			System.out.println();
        }
	}
}