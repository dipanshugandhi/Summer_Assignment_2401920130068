class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                if(!reverse) {
                    TreeNode currentNode = queue.removeLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }
                    if(currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                }
                else {
                            TreeNode currentNode = queue.removeFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right != null) {
                        queue.addLast(currentNode.right);
                }
                    if(currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
            }
        }
        reverse = !reverse;
        result.add(currentLevel);
        
    }
    return result;
    }
}
