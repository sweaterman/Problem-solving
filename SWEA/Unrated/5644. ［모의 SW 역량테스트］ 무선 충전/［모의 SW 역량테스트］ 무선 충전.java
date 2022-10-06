import java.util.Scanner;

public class Solution {
	static int time; //총 이동 시간
	static int t; //진행 시간
	static int N; //BC의 개수
	static int[] moveA; //A의 이동방향
	static int[] moveB; //B의 이동방향
	static int[][] BC; //BC 정보 [x, y, 충전범위, 처리량]
	static int[][] delta = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result; // 결과

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			time = sc.nextInt(); 
			N = sc.nextInt();
			moveA = new int[time+1];
			moveB = new int[time+1];
			for(int i=1; i<=time; i++) {
				moveA[i] = sc.nextInt();
			}
			for(int i=1; i<=time; i++) {
				moveB[i] = sc.nextInt();
			}
			BC = new int[N][4];
			for(int i=0; i<N; i++) {
				BC[i][1] = sc.nextInt() - 1;
				BC[i][0] = sc.nextInt() - 1;
				BC[i][2] = sc.nextInt();
				BC[i][3] = sc.nextInt();
			}
			
			//2. 계산
			t = 0;
			result = 0;
			sol(0, 0, 9, 9);
			
			//3. 출력
			System.out.printf("#%d %d\n", tc, result);
		}//테케 끝
	}//메인 끝
	
	static void sol(int ax, int ay, int bx, int by) {
		boolean[][] count = new boolean[N][2]; //몇번째? 0-> A, 1-> B
		for(int i=0; i<N; i++) {
			//A와 겹치면?
			if (cal(BC[i][0], BC[i][1], ax, ay) <= BC[i][2]) {
				count[i][0] = true;
			}
			//B와 겹치면?
			if (cal(BC[i][0], BC[i][1], bx, by) <= BC[i][2]) {
				count[i][1] = true;
			}
		}
		
		int tmp = 0;
		int tmpr = 0;
		for(int i=0; i<N; i++) { //A
			for(int j=0; j<N; j++) { //B
				tmpr = 0;
				//나눠가지는 경우
				if (i==j && count[i][0] && count[j][1]) {
					tmpr = BC[i][3];
					if(tmpr > tmp) {
						tmp = tmpr;
					}
					continue;
				}
				
				//각각 가지기
				if (count[i][0]) {
					tmpr += BC[i][3];
				}
				if (count[j][1]) {
					tmpr += BC[j][3];
				}
				
				if (tmpr > tmp) {
					tmp = tmpr;
				}
			}
		}
		
		result += tmp;
		t++;
		if (t == time+1) { //종료조건
			return;
		}
		sol(ax+delta[moveA[t]][0], ay+delta[moveA[t]][1], bx+delta[moveB[t]][0], by+delta[moveB[t]][1]);
	}
	
	//거리 확인하는 함수
	static int cal(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1-x2) + Math.abs(y1-y2));
	}
	
}