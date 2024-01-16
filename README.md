# hackerrank solutions
From time to time I try to solve some basic rackerrank exercises.
I began from rank of 269710 ... at least in my "record" :-)

My goal is to get rank of 1000.
In addition, here I was putting another exercises, which are asked on interviews. 


#### Techniques

* Sliding window

#### isSymmetric a binary tree
The idea is to use queue, push a root node twice.
```
Queue<TreeNode> q = new LinkedList<>();
q.add(root);
q.add(root);

while(!q.isEmpty()) {
    TreeNode left = q.poll();
    TreeNode right = q.poll();
    
    // the same for traversal, add twice
    /*
     1
   /   \
  2     2
 / \   / \
3   4 4   3
    
    */ 
    q.add(left.left);
    q.add(right.right);
    q.add(left.right);
    q.add(right.left);
}

```

#### Sorted Array to BST
Idea to use middle of the array
```
https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
```







Videos:

[Data Structures](https://www.youtube.com/watch?v=RBSGKlAvoiM)

[Algorithms by Prf. Skiena, 2021](https://www.youtube.com/watch?v=I6yuK4WpLxM&t=2248s)

[Binary Trees](https://www.youtube.com/watch?v=fAAZixBzIAI)


#### mvn show latest versions of the dependencies

```
 mvn versions:display-dependency-updates
```
