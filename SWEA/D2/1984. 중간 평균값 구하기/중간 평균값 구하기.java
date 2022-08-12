import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int tc=0; tc<n; tc++) {
			//입력받기
			int[] nums = new int[10];
			for (int i=0; i<nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			
			//선택 정렬
			int min = nums[0]; 
			int idx = 0;
			int tmp;
			for (int i=0; i<nums.length-1; i++) {
				for (int j=i; j<nums.length; j++) {
					if (min > nums[j]) {
						min = nums[j];
						idx = j;
					}
				}
				tmp = nums[idx];
				nums[idx] = nums[i];
				nums[i] = tmp;
				min = nums[i+1];
				idx = i+1;
			}
			
			//계산
			double sum = 0;
			for (int i=1; i<nums.length-1; i++) {
				sum += nums[i];
			}
			long result = Math.round(sum/8);
			
			System.out.printf("#%d %d\n", tc+1, result);
		}
	}
}