import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			int start = sc.nextInt();
			int[][] graph = new int[101][101];
			for(int i=0; i<N/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a][b] = 1;
			}
			boolean[] visit = new boolean[101];
			
			//2. 계산
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			visit[start] = true;
			List<Integer> result = new ArrayList<>();
			
			while (!q.isEmpty()) {
				int check = q.size();
				result = new ArrayList<>();
				for (int i=0; i<check; i++) {
					int a = q.poll();
					result.add(a);
					for (int j=1; j<101; j++) {
						if (!visit[j] && graph[a][j] == 1) {
							q.add(j);
							visit[j] = true;
						}
					}
				}
			}
			//3. 출력
			Collections.sort(result);
			System.out.printf("#%d %d\n", tc, result.get(result.size()-1));
		}//테케 끝
	}	
}