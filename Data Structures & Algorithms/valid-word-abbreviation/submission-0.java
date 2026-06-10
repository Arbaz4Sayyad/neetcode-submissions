class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbr.length()){
            char w_c = word.charAt(i);
            char a_c = abbr.charAt(j);
            
            if(Character.isDigit(a_c)){
                if(a_c == '0'){
                    return false;
                }
                
                int curr = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                    curr = curr * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i = i + curr;
            }else{
                if(w_c != a_c){
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}