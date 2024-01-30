import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int x=0; x<commands.length; x++) {
            int i = commands[x][0], j = commands[x][1], k = commands[x][2];
            int[] tmp = new int[j-i+1];
            
            int index = 0;
            for (int z=i-1; z<j; z++) {
                tmp[index] = array[z];
                index++;
            }
            Arrays.sort(tmp);
            answer[x] = tmp[k-1];
        }
        return answer;
    }
}