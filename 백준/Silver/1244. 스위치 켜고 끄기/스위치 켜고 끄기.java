import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt(); //스위치 개수 (100이하 양의 정수)
	    int[] sw = new int[N+1]; //스위치 상태
	    for (int i=1; i<N+1; i++) {
	    	sw[i] = sc.nextInt();
	    }
	    int M = sc.nextInt(); //학생 수 (100이하 양의 정수)
	    
	    for(int i=0; i<M; i++) { //입력 및 바로 계산
	    	int gender = sc.nextInt(); //성별
	    	int x = sc.nextInt(); //받은 수
	    	
	    	if(gender == 1) { //남
	    		for(int j=x; j<N+1; j+=x) {
	    			if(sw[j] == 1) { sw[j] = 0; }
	    			else { sw[j] = 1; }
	    		}
	    	}
	    	
	    	else { //여
	    		int j = 0;
	    		if(sw[x] == 1) { sw[x] = 0; }
    			else { sw[x] = 1; }
	    		while(x-j>=1 && x+j<N+1 && sw[x+j]==sw[x-j]) {
	    			if(sw[x+j] == 1) { sw[x+j] = 0; }
	    			else { sw[x+j] = 1; }
	    			if(sw[x-j] == 1) { sw[x-j] = 0; }
	    			else { sw[x-j] = 1; }
	    			j++;
	    		}
	    	}
	    }
	    
	    //출력
	    for(int k=1; k<N+1; k++) {
	    	System.out.printf("%d ", sw[k]);
	    	if(k%20 == 0) {
	    		System.out.println();
	    	}
	    }   
	}

}