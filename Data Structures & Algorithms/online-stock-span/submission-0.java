class StockSpanner {

    // Stack stores:
    // [price, span]
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        // Current day's span is at least 1
        // because today itself is included.
        int span = 1;

        // Remove all previous prices that are
        // less than or equal to today's price.
        //
        // Their spans can be combined with today's span.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            // Add the span of the removed price
            span += stack.pop()[1];
        }

        // Store today's price and its calculated span
        stack.push(new int[]{price, span});

        // Return the span for today's price
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */