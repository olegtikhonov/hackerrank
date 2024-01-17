## Trees
I think it is more natural to have different section of documentation related to leetcode data structures
I will describe the basic idea or algorithms, probably with code snippets. 

#### Path sum
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding 
up all the values along the path equals targetSum.  A leaf is a node with no children.

![img.png](images/path_sum_of_bt.png)

```code
boolean dfs(int currentSum, TreeNode node, int targetSum) {
    if(node == null) {
        return true;
    }
    currentSum += node.val;
    
    if(node.left == null && node.right == null) {
        return currentSum == targetSum;
    }
    
    return ( dfs(currentSum, node.left, targetSum) || dfs(currentSum, node.right, targetSum));
} 
```
