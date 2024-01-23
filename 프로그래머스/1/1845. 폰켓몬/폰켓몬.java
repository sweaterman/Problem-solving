import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;        
        int size = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if(size <= set.size()) {
            answer = size;
        } else {
            answer = set.size();
        }

        return answer;
    }
}