class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                char top = stack.peek();
                if(!stack.isEmpty() && (
                        (ch == ']' && top == '[') || 
                        (ch == '}' && top == '{') ||
                        (ch == ')' && top == '('))){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}