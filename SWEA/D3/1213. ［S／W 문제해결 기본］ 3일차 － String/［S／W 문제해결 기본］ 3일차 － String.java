import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			//1. 입력받기
			sc.next();
			String f = sc.next();
			String words = sc.next();
			
			//2. 보이어 무어
			int M = f.length();
			int N = words.length();
			Map <Character, Integer> skip = makeSkip(f);
			
			int idx = M-1;
			int sum = 0;
			while(idx<N) {
				boolean check = true;
				for(int i=0; i<M; i++) {
					if(words.charAt(idx-i)!=f.charAt(M-i-1)) {//달랐어
						check = false;
						if(!skip.containsKey(words.charAt(idx-i))) {
							idx += M-i;
						}
						else {
							if(skip.get(words.charAt(idx-i)) - i > 0) {
								idx += skip.get(words.charAt(idx-i)) - i;
							} else idx ++;
						}
						break;
					}
				}
				if(check) {
					sum ++;
					idx ++;
				}
			}
			System.out.printf("#%d %d\n", tc+1, sum);
			
		}
	}
	public static Map<Character, Integer> makeSkip(String f) {
		int M = f.length()-1;
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<f.length(); i++) {
			result.put(f.charAt(i), M--);
		}
		return result;
	}
}
