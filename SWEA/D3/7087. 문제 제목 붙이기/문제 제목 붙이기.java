import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
        	//1. 입력 받기  (제목의 첫글자만 저장)
            List<Character> title = new ArrayList<>();
            int N = sc.nextInt();
            for(int i=0; i<N; i++) {
                String a = sc.next();
                title.add(a.charAt(0));
            }
            
            //2. 아스키 코드를 통해 계산
            title.sort(null); //알파벳 순서대로 저장
            int count = 0;
            if(title.get(0) != 'A') {
            	System.out.printf("#%d %d\n", tc, count);
            	continue;
            }
            count = 1;
            for (int i=1; i<title.size(); i++) {
            	if (title.get(i-1)==title.get(i)) {
            		continue;
            	}
            	else if (title.get(i-1)+1==title.get(i)) {
            		count++;
            	}
            	else {
            		break;
            	}
            }
            System.out.printf("#%d %d\n", tc, count);
        }
	}

}