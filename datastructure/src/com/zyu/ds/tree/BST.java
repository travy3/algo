package com.zyu.ds.tree;

public class BST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(searchBST(root,6));
    }


    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 查找
     * <p>
     * 删除
     * 1，无子节点
     * 2，有一个子节点
     * 2，有两个子节点
     *
     * @param node
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else if (key == node.val) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            //有两个子节点，找到右节点下的最左节点
            node.val = getMin(node.right);
            node.right = deleteNode(node.right, node.val);
        }
        return node;
    }

    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}