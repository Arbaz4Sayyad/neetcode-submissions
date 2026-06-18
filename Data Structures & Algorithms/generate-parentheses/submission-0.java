class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        backtrack(new StringBuilder(""), 0, 0, n, output);

        return output;
    }

    public void backtrack(StringBuilder current, int open, int close, int n, List<String> output){
        // base case
        if(open == n && close == n){
            output.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');
            backtrack(current, open + 1, close, n, output);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < n && close < open){
            current.append(')');
            backtrack(current, open, close + 1, n, output);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
