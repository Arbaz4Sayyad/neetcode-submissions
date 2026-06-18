class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> output = new ArrayList<>();

        // handle empty input
        if(digits.length() == 0){
            return output;
        }

        backtrack(0, digits, new StringBuilder(""), map,  output);

        return output;
    }

    public void backtrack(int index, String digits, StringBuilder current, Map<Character, String> map, List<String> output){
        // base case
        if(index == digits.length()){
            output.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        
        for(int i = 0; i < letters.length(); i++){
            // include 
            current.append(letters.charAt(i));
            backtrack(index + 1, digits, current, map,  output);
            current.deleteCharAt(current.length() - 1);

            // backtrack(index + 1, digits, current + letters.charAt(i), map,  output);
        }
    }

}
