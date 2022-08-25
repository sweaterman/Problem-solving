import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class Solution
{
    static int count = 0;
	static void countSub(int[] tree, int p) {
		count++;
		for(int i=0; i<tree.length; i++) {
			if(tree[i] == p) {
				countSub(tree, i);
			}
		}
	}
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++) {
			// 1. 변수 입력 받기
			int V = sc.nextInt();
			int E = sc.nextInt();
			int V1 = sc.nextInt();
			int V2 = sc.nextInt();
			
			//2. 노드 정보 1차원 배열에 저장
			int[] tree = new int[V+1]; //0번은 비우기. 인덱스는 노드 번호, 값은 부모를 의미

			for (int i=0; i<E; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				tree[c] = p;
			}
			
			//3. 각 정점의 부모들을 저장할 배열을 생성하고 부모들 넣기
			List<Integer> p1 = new ArrayList<>();
			List<Integer> p2 = new ArrayList<>();
			p1.add(V1); p2.add(V2);
			int a = tree[V1];
			int b = tree[V2];
			
			while(a!=0) {
				p1.add(a);
				a = tree[a];
			}
			while(b!=0) {
				p2.add(b);
				b = tree[b];
			}
			
			//4. 가까운 공통 조상 찾기
			int answer = 0;
			end: for(int i=0; i<p1.size(); i++) {
				for(int j=0; j<p2.size(); j++) {
					if(p1.get(i).equals(p2.get(j))) {
						answer = p1.get(i);
						break end;
					}
				}
			}
			
			//5. 서브트리 개수 찾기
			countSub(tree, answer);
			System.out.printf("#%d %d %d\n", tc+1, answer, count);
			count = 0;
		}
	}
}