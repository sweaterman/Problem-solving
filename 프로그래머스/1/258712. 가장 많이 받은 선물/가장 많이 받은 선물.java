import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i=0; i<friends.length; i++) {
            result.put(friends[i], i);
        }
        
        int[][] arr = new int[friends.length][friends.length];
        for (int i=0; i<gifts.length; i++) {
            String[] tmp = gifts[i].split(" ");
            arr[result.get(tmp[0])][result.get(tmp[1])] += 1;
        }
        
        for (int i=0; i<friends.length; i++) {
            for (int j=i+1; j<friends.length; j++) {
                if (arr[i][j] > arr[j][i]) {
                    arr[i][i] += 1;
                }
                else if (arr[i][j] < arr[j][i]) {
                    arr[j][j] += 1;
                }
                else {
                    int g1 = 0;
                    for (int k=0; k<friends.length; k++) {
                        g1 += arr[i][k];
                        g1 -= arr[k][i];
                    }
                    int g2 = 0;
                    for (int k=0; k<friends.length; k++) {
                        g2 += arr[j][k];
                        g2 -= arr[k][j];
                    }
                    
                    if (g1 > g2) {
                        arr[i][i] += 1;
                    }
                    else if (g1 < g2) {
                        arr[j][j] += 1;
                    }
                }
            }
        }
        
        int answer = arr[0][0];
        for (int x=0; x<friends.length; x++) {
            if (arr[x][x] > answer) {
                answer = arr[x][x];
            }
        }
        
        
        return answer;
    }
}