class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);
        int maxLen = 0;

        for(int i = 0; i < heights.length; i++) {
            int ans = (next[i] - prev[i] - 1) * heights[i]; 
            maxLen = Math.max(ans, maxLen);      
        }
        return maxLen; 
    }

    public int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] prev = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                prev[i] = -1;
            }
            else {
                prev[i] = stack.peek();
            }
            stack.push(i);
        }
        return prev;
    }

    public int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack();
        int[] next = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                next[i] = arr.length;
            }
            else {
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        return next;
    }
}
