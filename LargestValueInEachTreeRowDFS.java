//Leetcode Problem 515: Find Largest Value in Each Tree Row

// Time Complexity : O(n) => As we are iterating over each and every node
// Space Complexity : O(n) => Due to queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot the syntax to update the value in the list. Use set by passing level & new root value

/*
Approach : Using DFS(Depth First Search). Start the dfs call by passing the root node and level 0. And if level is equal to the resultant list's size then add the root and chek if next root's value is greater than the already set value replace. Do left recursive call by passing root.left & level +1. Do right recursive call by passing root.right & level +1
 */

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level){

        if(root == null){
            return;
        }

        if(level == result.size()){
            result.add(root.val);
        }
        else{
            if(root.val > result.get(level)){
                result.set(level, root.val);
            }

        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }
}