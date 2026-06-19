class Solution {
    public int romanToInt(String s) {
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prevValue = 0;

        for(int i=s.length()-1; i>=0; i--){
            int curValue = map.get(s.charAt(i));
            if(curValue < prevValue){
                res-=curValue; // Subtract if smaller (e.g., IV = 5 - 1 = 4)
            }else{
                res+=curValue; // Add if greater (e.g., VI = 5 + 1 = 6)
            }
            prevValue = curValue;
        }
        return res;
    }
}