package com.zyu.ds.tree;

public class AVLTree {

    AVLNode root;

    int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }


    class AVLNode {
        int key, height;

        AVLNode leftNode;
        AVLNode rightNode;

        public AVLNode(int key, int height) {
            this.key = key;
            this.height = height;
        }
    }
}