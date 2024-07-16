//Leetcode Problem 515: Find Largest Value in Each Tree Row

// Time Complexity : O(n) => As we are iterating over each and every node
// Space Complexity : O(n) => Due to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to check if queue was not empty, add the max value in result

/*
Approach : Using BFS(Level Order Traversal). Take queue and add the root value. Maintain a list and start by adding the root in the result. Run a while loop to check if queue is not empty and use size variable to hold size of the queue. If both left & right child are null continue, otherwise check the maximum value for each row. And add in the result set
 */

class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i =0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left == null && curr.right == null){
                    continue;
                }

                if(curr.left != null){
                    q.add(curr.left);
                    max = Math.max(max, curr.left.val);
                }

                if(curr.right != null){
                    q.add(curr.right);
                    max = Math.max(max, curr.right.val);
                }

            }

            if(!q.isEmpty()){
                result.add(max);
            }

        }

        return result;
    }
}