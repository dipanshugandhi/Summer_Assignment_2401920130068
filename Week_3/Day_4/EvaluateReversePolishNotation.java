class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int d2 = stack.pop();
                int d1 = stack.pop();
                int ans = 0;

                if(tokens[i].equals("+")) {
                    ans = d1 + d2;
                }

                if(tokens[i].equals("-")) {
                    ans = d1 - d2;
                }

                if(tokens[i].equals("*")) {
                    ans = d1 * d2;
                }

                if(tokens[i].equals("/")) {
                    ans = d1 / d2;
                }
                stack.push(ans);
            }

            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
