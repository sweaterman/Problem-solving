import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			//1. 입력받기
			int T = sc.nextInt();
			int[] nums = new int[8];
			for(int i=0; i<8; i++) {
				nums[i] = sc.nextInt();
			}
			
			//2. 계산
			end : while(true) {
				for(int i=0; i<5; i++) {
					int tmp = nums[0];
					//땡기기
					for(int j=1; j<8; j++) {
						nums[j-1] = nums[j];
					}
					nums[7] = tmp-(i+1);
					if(nums[7] <= 0) {
						nums[7] = 0;
						break end;
					}
				}
			}
			
			//3. 출력
			System.out.printf("#%d ", T);
			for(int i=0; i<8; i++) {
				System.out.printf("%d ", nums[i]);
			}
			System.out.println();
			
		}//테스트 케이스 끝
	}
}