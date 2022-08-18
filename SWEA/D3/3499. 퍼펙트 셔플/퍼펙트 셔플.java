import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int TC=0; TC<tc; TC++) {
			Queue<String> a = new LinkedList<>();
			Queue<String> b = new LinkedList<>();
			
			//1. 입력받기
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				if (i<(n+1)/2) {
					a.offer(sc.next());
				}
				else {
					b.offer(sc.next());
				}
			}
			
			// 2. 츨력하기
			System.out.printf("#%d ", TC+1);
			for(int i=0; i<n/2; i++) {
				System.out.printf("%s ", a.poll());
				System.out.printf("%s ", b.poll());
			}
			if (a.size()>0) {
				System.out.printf("%s ", a.poll());
			}
			System.out.println();
		}
	}
}