import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++) {
			//1. 입력받기
			int H = sc.nextInt();
			int W = sc.nextInt();
			int h = 0; int w = 0; //전차의 처음 위치
			char[][] MAP = new char[H][W];
			for(int i=0; i<H; i++) {
				String a = sc.next();
				for(int j=0; j<W; j++) {
					MAP[i][j] = a.charAt(j);
					if(a.charAt(j) == '<' || a.charAt(j) == '>' || a.charAt(j) == '^' || a.charAt(j) == 'v') {
						h = i;
						w = j;
					}
				}
			}
			int N = sc.nextInt();
			String command = sc.next();
			int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			char[] car = {'^', 'v', '<', '>'};
			for(int i=0; i<N; i++) {
				char check = command.charAt(i);
				//방향 및 이동
				if (check == 'U' || check == 'D' || check == 'L' || check =='R') {
					//delta와 car의 모양을 인덱스 m을 통해 접근
					int m;
					if(check == 'U') { m = 0; }
					else if(check == 'D') { m = 1; }
					else if(check == 'L') { m = 2; }
					else { m = 3; }
					
					if (h+delta[m][0] >= 0 && h+delta[m][0] < H && w+delta[m][1] >= 0 && w+delta[m][1] < W) {
						if (MAP[h+delta[m][0]][w+delta[m][1]] == '.') {
							MAP[h][w] = '.';
							h += delta[m][0];
							w += delta[m][1];
						}
					}
					MAP[h][w] = car[m];
				}
				
				//발사
				else if(check == 'S') {
					//어느 방향을 보고 있는지 찾기
					int m = -1;
					for(int j=0; j<4; j++) {
						if (MAP[h][w] == car[j]) {
							m = j;
						}
					}
					
					//포탄 행 이동
					int bullet;
					if (m == 0 || m == 1) {
						bullet = h;
						while(true) {
							bullet += delta[m][0];
							//인덱스 범위 내라면?
							if (bullet >= 0 && bullet < H) {
								if(MAP[bullet][w] == '#') { break; }
								else if(MAP[bullet][w] == '*') { MAP[bullet][w] = '.'; break; }
							}
							//인덱스 밖이라면 stop
							else { break; }
						}
					}
					//포탄 열 이동
					else {
						bullet = w;
						while(true) {
							bullet += delta[m][1];
							//인덱스 범위 내라면?
							if (bullet >= 0 && bullet < W) {
								if(MAP[h][bullet] == '#') { break; }
								else if(MAP[h][bullet] == '*') { MAP[h][bullet] = '.'; break; }
							}
							//인덱스 밖이라면 stop
							else { break; }
						}
					}
				}
			}//명령어 끝
			System.out.printf("#%d ", tc+1);
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.printf("%c", MAP[i][j]);
				}
				System.out.println();
			}
		}//테스트 케이스 끝
	}
}