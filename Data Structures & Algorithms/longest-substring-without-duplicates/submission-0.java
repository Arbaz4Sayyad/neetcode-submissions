class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch, right); // char -> index
            }else{
                left = Math.max(left, map.get(ch)+1);
                map.put(ch, right); // char -> index
            }
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
}