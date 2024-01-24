import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i=1; i<phone_book.length; i++) {
            if ((phone_book[i].length() >= phone_book[i-1].length()) &&
                (phone_book[i-1].equals(phone_book[i].substring(0, phone_book[i-1].length()))))
                return false;
        }
        
        return answer;
    }
}