class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {
            if(op.equals("C")){
                stack.pop();
            } else if(op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if(op.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();

                int score = first + second;

                stack.push(first); // restore
                stack.push(score);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}