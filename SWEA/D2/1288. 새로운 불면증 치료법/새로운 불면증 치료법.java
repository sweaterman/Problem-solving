import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashSet;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++) {
			HashSet<Integer> nums = new HashSet<>();
			for(int i=0; i<10; i++) {
				nums.add(i);
			}
			int n = sc.nextInt();
			for(int i=1; ; i++) {
				int NN = i*n;
				String a = Integer.toString(NN);
				for(int j=0; j<a.length(); j++) {
					int check = a.charAt(j)-'0';
					if (nums.contains(check)) {
						nums.remove(check);
					}
				}
				if (nums.isEmpty()) {
					System.out.printf("#%d %d\n", tc+1, NN);
					break;
				}
			}
		}
	}
}