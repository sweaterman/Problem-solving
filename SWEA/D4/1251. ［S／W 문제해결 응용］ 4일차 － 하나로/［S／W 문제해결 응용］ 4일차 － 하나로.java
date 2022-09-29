import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Node implements Comparable<Node> {
		double w;
		int idx;
		Node(double w, int idx){
			this.w = w;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Node o) {
			return (int) (this.w-o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			int[][] island = new int[N][2];
			for (int i=0; i<N; i++) {
				island[i][0] = sc.nextInt();
			}
			for (int i=0; i<N; i++) {
				island[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			
			//2. 계산
			boolean[] visit = new boolean[N];
			double result = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			while (!pq.isEmpty()) {
				Node a = pq.poll();
				if (visit[a.idx]) continue;
				visit[a.idx] = true;
				result += a.w;
				for (int i=0; i<N; i++) {
					pq.add(new Node(getW(island[a.idx][0], island[a.idx][1], island[i][0], island[i][1]), i));
				}
			}
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, Math.round(E*result));
			
		}//테케 끝
	}
	
	static double getW(int x1, int y1, int x2, int y2) {
		return (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}	
}