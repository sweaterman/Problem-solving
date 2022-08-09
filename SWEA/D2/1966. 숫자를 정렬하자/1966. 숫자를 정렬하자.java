import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp = 0;
		
		for (int tc=0; tc<n; tc++) {
			int num = sc.nextInt();
			int[] nums = new int[num];
			for (int i=0; i<num; i++) {
				nums[i] = sc.nextInt();
			}
			
			//버블 정렬
			for (int i=0; i<num; i++) {
				for (int j=0; j<num-1-i; j++) {
					if (nums[j]>nums[j+1]) {
						tmp = nums[j+1];
						nums[j+1] = nums[j];
						nums[j] = tmp;
					}
				}
			}
			
			//출력
			System.out.printf("#%d ", tc+1);
			for (int i=0; i<num; i++) {
				System.out.printf("%d ", nums[i]);
			}
			System.out.println();
		}
	}
}
