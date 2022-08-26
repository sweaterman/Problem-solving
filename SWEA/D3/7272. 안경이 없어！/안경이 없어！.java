import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static String hole = "ADOPQR";
	static String holex = "CEFGHIJKLMNSTUVWXYZ";
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			String a = sc.next();
			String b = sc.next();
			boolean check = true;

			// 1. 사이즈가 다르면 다름.
			if (a.length() != b.length()) {
				check = false;
			}
			// 2. 각 문자에 구멍의 유무 체크
			else {
				for (int i = 0; i < a.length(); i++) {
					//B일 때
					if(a.charAt(i)=='B') {
						if(b.charAt(i)!='B') {
							check = false;
							break;
						}
					}
					//구멍이 있는 문자일 때
					else if(hole.contains(Character.toString(a.charAt(i)))) {
						if(!hole.contains(Character.toString(b.charAt(i)))) {
							check = false;
							break;
						}
					}
					//없는 문자 일 때
					else if(!holex.contains(Character.toString(b.charAt(i)))){
						check = false;
						break;
					}
				}
			}
			
			System.out.printf("#%d ", tc+1);
			if(check) {
				System.out.println("SAME");
			}
			else {
				System.out.println("DIFF");
			}
		} // 테스트케이스 끝
	}
}