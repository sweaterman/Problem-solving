import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {	
	static int N;
	static int[][] map;
	static int result;
	static int[][] gate; //입구 좌표
	static int cnt; //사람 수 
	static int minute;
	static int[][] people; //사람 
	static int stair1;
	static int stair2;
	static boolean[] visit;
	static List<Integer> stairCheck1;
	static List<Integer> stairCheck2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			//1. 입력 받기
			N = sc.nextInt();
			map = new int[N][N];
			cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						cnt++;
					}
				}
			}
			
			//2. 입구 찾기
			gate = new int[2][2]; //계단의 입구는 2개 (i, j 좌표)
			int gate_cnt = 0;
			out : for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] != 0 && map[i][j] != 1) {
						gate[gate_cnt][0] = i;
						gate[gate_cnt][1] = j;
						gate_cnt++;
						if (gate_cnt == 2) { break out; }
					}
				}
			}
			
			//3. 사람 찾기
			people = new int[cnt][5]; // 각 x, y 좌표와 거리 표시 배열 (1번입구, 2번 입구), 임시 공간
			int idx = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == 1) {
						people[idx][0] = i;
						people[idx][1] = j;
						people[idx][2] = Math.abs(i-gate[0][0]) + Math.abs(j-gate[0][1]);
						people[idx][3] = Math.abs(i-gate[1][0]) + Math.abs(j-gate[1][1]);
						idx++;
					}
				}
			}
			
			//4. 각 사람이 어떤 입구를 선택하는지? 모든 경우의 반복문
			result = Integer.MAX_VALUE;
			for (int i=0; i<(1<<cnt); i++) {
				minute = 0; // 시간의 흐름
				stair1 = 0; //계단에 있는 사람 수
				stair2 = 0;
				visit = new boolean[cnt];
				stairCheck1 = new ArrayList<>();
				stairCheck2 = new ArrayList<>();
				for (int j=0; j<cnt; j++) {
					//j번째 사람이
					if ((i & (1<<j)) > 0) { //1번 계단 선택
						people[j][4] = 1;
					}
					else {
						people[j][4] = 0;
					}
				}
				cal();
				if (minute < result) {
					result = minute;
				}
//				System.out.printf("현재 케이스 시간: %d\n", minute);
			}
			
			//5. 출력
			System.out.printf("#%d %d\n", tc, result);
			
		}//테케 끝
	}	
	static void cal() {
		minute++;
		
		boolean flag = true;
		for (int i=0; i<cnt; i++) {
			if (!visit[i]) {
				flag = false;
				break;
			}
		}
		
		if (flag && stairCheck1.size() == 0 && stairCheck2.size() == 0) return; //종료 조건

		int x = stairCheck1.size();
		int y = stairCheck2.size();
		
		for (int i=0; i<x; i++) {
			stairCheck1.set(i, stairCheck1.get(i)-1);
			if (stairCheck1.get(i).equals(0)) {
				stair1--;
				stairCheck1.remove(i);
				i--;
				x--;
//				System.out.println("1번계단 1명 나갑니다");
			}
		}
		
		for (int i=0; i<y; i++) {
			stairCheck2.set(i, stairCheck2.get(i)-1);
			if (stairCheck2.get(i).equals(0)) {
				stair2--;
				stairCheck2.remove(i);
				i--;
				y--;
//				System.out.println("2번계단 1명 나갑니다");
			}
		}
		
		for (int i=0; i<cnt; i++) {
			if (!visit[i]) {
				if (people[i][4] == 1) { //첫번째 계단 선택
					// minute과 같으면 계단으로 이동
					if (people[i][2] <= minute && stair1<3) {
						visit[i] = true;
						stair1++;
//						System.out.printf("%d분에 %d번째 사람 계단 들어가기\n", minute, i);
						stairCheck1.add(map[gate[0][0]][gate[0][1]]);
					}
				}
				else { // 두번째 계단 선택
					if (people[i][3] <= minute && stair2<3) {
						visit[i] = true;
						stair2++;
//						System.out.printf("%d분에 %d번째 사람 계단 들어가기\n", minute, i);
						stairCheck2.add(map[gate[1][0]][gate[1][1]]);
					}
				}
			}
		}
		cal();
	}
}