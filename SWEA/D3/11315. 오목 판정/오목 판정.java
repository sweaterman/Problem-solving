import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int TC = 1; TC <= tc; TC++) {
			//1. 입력받기
			int N = sc.nextInt();
			char[][] omok = new char[N][N];
			for (int i=0; i<N; i++) {
				String a = sc.next();
				for (int j=0; j<N; j++) {
					omok[i][j] = a.charAt(j);
				}
			}
			
			//2. 돌 체크
			boolean check = false;
			end : for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (omok[i][j] == 'o') {
						//가로확인
						for(int k=j; k<5+j; k++) {
							if(k>=N || (k<N && omok[i][k] != 'o')){
								break;
							}
							if (k==j+4) {
								check = true;
								break end;
							}
						}
						
						//세로확인
						for(int k=i; k<5+i; k++) {
							if(k>=N || (k<N && omok[k][j]!='o')) {
								break;
							}
							if(k==i+4) {
								check = true;
								break end;
							}
						}
						
						//좌하단 대각선 확인
						for(int k=0; k<5; k++) {
							if(k+i>=N || j-k<0 || (k+i<N && j-k>=0 && omok[i+k][j-k]!='o' )) {
								break;
							}
							if(k==4) {
								check = true;
								break end;
							}
						}
						
						//우하단 대각선 확인
						for(int k=0; k<5; k++) {
							if(k+i>=N || j+k>=N || (k+i<N && j+k<N && omok[i+k][j+k]!='o' )) {
								break;
							}
							if(k==4) {
								check = true;
								break end;
							}
						}
					}
				}
				
			} //돌 체크 끝
			
			//3. 출력하기
			if(check) {
				System.out.printf("#%d YES\n", TC);
			}
			else {
				System.out.printf("#%d NO\n", TC);
			}
		}
	}
}