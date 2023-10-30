package com.zyu.algo;


import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        root.left = new TreeNode('B');
        root.right = new TreeNode('C');
        root.left.left = new TreeNode('D');
        root.left.right = new TreeNode('E');

        preOrderTraversal(root);

        System.out.println("############");
        inOrderTraversal(root);

        System.out.println("##############");
        postOrderTraversal(root);

        System.out.println("$$$$$$$$$$$$$$$$$");
        levelOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + "->");

        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val + "->");
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.val + "->");
    }

    public static void levelOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.val + "->");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            val = x;
        }
    }

}