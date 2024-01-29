import java.util.*;
    
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> tmp = new HashMap<>();
        for (String[] a: clothes) {
            if (tmp.get(a[1]) == null)
                tmp.put(a[1], 1);
            else
                tmp.put(a[1], tmp.get(a[1])+1);
        }
        
        Iterator ks = tmp.keySet().iterator();

        while (ks.hasNext()) {
            String key = ks.next().toString();
            answer *= tmp.get(key) + 1;
        }
        
        return answer-1;
    }
}