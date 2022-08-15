import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        for (int tc=0; tc<10; tc++) {
            //1. 입력받기
            int TC = sc.nextInt();
            char[][] words = new char[100][100];
            for(int i=0; i<100; i++) {
                String temp = sc.next();
                words[i] = temp.toCharArray();
            }
            
            //2. 회문 계산
            int max = 0;
            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    //회문의 길이를 최대 100부터 거꾸로 검사
                	
                	//가로 검사
                    for(int len=100-j; len>max; len--) {
                        boolean check = true;
                        for(int k=0; k<len/2; k++) {
                            if(words[i][j+k]!=words[i][j+len-1-k]) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            max = len;
                            break;
                        }
                    }
                    
                    //세로 검사
                    for(int len=100-i; len>max; len--) {
                    	boolean check = true;
                    	for(int k=0; k<len/2; k++) {
                            if(words[i+k][j]!=words[i+len-1-k][j]) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            max = len;
                            break;
                        }
                    }
                }
            }
            //3. 출력
            System.out.printf("#%d %d\n", TC, max);
        }// tc 끝
        sc.close();
	}
}