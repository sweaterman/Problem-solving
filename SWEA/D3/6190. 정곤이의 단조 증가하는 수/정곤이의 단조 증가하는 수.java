import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static boolean check(int num) {
		String check = Integer.toString(num);
		for(int k=1; k<check.length(); k++) {
			if(check.charAt(k-1)> check.charAt(k)) {
				return false;
			}
		}
		return true;
	}
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for(int i=0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			
			int max = nums[0];
			if(!check(max)) {
				max = -1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if (check(nums[i]*nums[j]) && max < nums[i]*nums[j]) {
						max = nums[i]*nums[j];
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}