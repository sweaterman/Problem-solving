import java.util.Scanner;

public class Solution {
    static int D;
    static int W;
    static int K;
    static int[][] fig;
    static int[][] tmp;
    static int bit;
    static int R;
    static int[] changeArr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();        
        //테스트케이스
        for (int tc=1; tc<=TC; tc++) {
            //1. 입력받기
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            fig = new int[D][W];
            for (int i=0; i<D; i++) {
                for (int j=0; j<W; j++) {
                    fig[i][j] = sc.nextInt();
                }
            }
            
            //2. 계산
            int cnt = 0;
            tmp = new int[D][W];
            copy(fig, tmp); 
            while (cnt < D) {
                if (checkIdx() == true) break;
                cnt++;
                perm(cnt);
                
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }//테케 끝
    }//메인 끝
    
    //배열 복사 함수 추가
    static void copy(int[][] a, int[][] b) {
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++) {
                b[i][j] = a[i][j];  
            }
        }
    }//복사함수 끝
        
    //성능 통과 확인
    static boolean checkIdx() {
        for (int i=0; i<W; i++) {
            boolean flag = false;
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j=0; j<D; j++) {
                if (tmp[j][i] == 0) {
                    cnt0++;
                    if (cnt0 == K) {
                        flag = true;
                        break;
                    }
                    cnt1 = 0;
                }
                else {
                    cnt1++;
                    if (cnt1 == K) {
                        flag = true;
                        break;
                    }
                    cnt0 = 0;
                }
            }
            if (flag == false) return false;
        }
        return true;
    }//성능 체크함수 끝
    
    //cnt개 바꾸는 가지수 ex) AAB, BBA 등
    static void perm(int cnt) {
        for(int i=0; i<(2<<(cnt-1)); i++) {
            R = cnt;
            bit = i;
            changeArr = new int[R];
            perm2(0, 0);
            if (checkIdx()) return;
        }
    }
    
    //a의 경우(AAB, BBA 등), b개를 바꾼다.
    static void perm2(int idx, int sidx) {
        if(checkIdx()) return;
        
        if (sidx == R) { //다 골랐다.
            copy(fig, tmp);
            changeBit();
            return;
        }
        
        else if (idx == D) {
            return;
        }
        changeArr[sidx] = idx;
        perm2(idx+1, sidx+1);
        perm2(idx+1, sidx);
    }
    
    static void changeBit() {
        for (int i=0; i<R; i++) {
            if (((bit >> i) & 1) == 0) {
                for (int j=0; j<W; j++) {
                    tmp[changeArr[i]][j] = 0;
                }
            }
            else {
                for (int j=0; j<W; j++) {
                    tmp[changeArr[i]][j] = 1;
                }
            }
        }
        return;
    }
}