package test.twest;


/**
 * Represents a binary tree node.
 *
 */
public class BTreeNode {
    public int data;
    public BTreeNode left;
    public BTreeNode right;


    public BTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName());
        sb.append('{');
        sb.append(data);
        if(left != null) {
            sb.append(", left=").append(left);
        }
        if(right != null) {
            sb.append(", right=").append(right);
        }
        sb.append('}');
        return sb.toString();
    }
}
