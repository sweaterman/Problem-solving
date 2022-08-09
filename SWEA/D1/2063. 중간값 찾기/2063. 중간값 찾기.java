import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		//입력
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		//버블 정렬
		int tmp;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n-1-i; j++) {
				if (nums[j] < nums[j+1]) {
					tmp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		System.out.printf("%d\n", nums[Math.round(n/2)]);
		sc.close();
	}
}
