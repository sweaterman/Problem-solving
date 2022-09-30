import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int W;
	static int H;
	static int[][] map;
	static int result;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			// 1. 입력 받기
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			for(int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 2. 계산
			result = Integer.MAX_VALUE;
			brick(N, map);
			
			// 3. 출력
			System.out.printf("#%d %d\n", tc, result);
			
		}//테스트케이스 끝
	}
	
	// 벽돌 깨기 관리 함수
	static void brick(int cnt, int arr[][]) {
		int[][] arr2 = new int[H][W];
		copy(arr, arr2);
		if (cnt == 0) {
			int r = cal(arr);
			if (r < result) {
				result = r;
			}
			return;
		}
		
		for (int k=0; k<W; k++) { //몇번째  열을 선택하는지?
			//깨기
			int[][] tmp = new int[H][W];
			copy(arr2, tmp);
			for (int i=0; i<H; i++) {
				if (tmp[i][k] != 0) {		
					crack(tmp, i, k); //벽돌 깨기
					copy(down(tmp), tmp); //중력
					break;
				}
			}
			brick(cnt-1, tmp);
		}
	}
	
	// 계속 깬다.
	static void crack(int arr[][], int x, int y) {
		if (arr[x][y] == 0) {
			return;
		}
		int c = arr[x][y];
		arr[x][y] = 0;
		for (int m=1; m<c; m++) {
			for (int k=0; k<4; k++) { //4방향 탐색
				if (x+m*delta[k][0] < H && y+m*delta[k][1] < W && x+m*delta[k][0] >= 0 && y+m*delta[k][1] >= 0
							&& arr[x+m*delta[k][0]][y+m*delta[k][1]] != 0) {
					crack(arr, x+m*delta[k][0], y+m*delta[k][1]);
				}
			}
		}				
	}
	
	//아래에 빈칸이 있을 때 떨어트리는 함수
	static int[][] down(int[][] arr) {
        int[][] tmpArr = new int[H][W];
        copy(arr, tmpArr);
        for(int i=0; i<W; i++) {
            while(true) {
                boolean flag = true;
                for(int j=H-1; j>0; j--) {
                    if(tmpArr[j][i] == 0 && tmpArr[j-1][i] > 0) {
                        flag = false;
                        tmpArr[j][i] = tmpArr[j-1][i];
                        tmpArr[j-1][i] = 0;
                    }
                }
                if(flag)
                    break;
            }
        }
        return tmpArr;
	}
	
	//남은 벽돌의 개수
	static int cal(int[][] arr) {
		int cnt = 0;
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (arr[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	//2차원 배열 복사 함수. 1을 2로 복사
	static void copy(int[][] arr1, int[][] arr2) {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}
}