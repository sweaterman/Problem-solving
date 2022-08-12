import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int tc=0; tc<n; tc++) {
			//10개 정수 입력받기
			int[] nums = new int[10];
			for (int i=0; i<10; i++) {
				nums[i] = sc.nextInt();
			}
			int max = nums[0];
			for (int i=1; i<10; i++) {
				if (max < nums[i]) {
					max = nums[i];
				}
			}
			System.out.printf("#%d %d\n", tc+1, max);
		}
	}
}