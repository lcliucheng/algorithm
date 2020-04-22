package com.lc.algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liu cheng
 * @since 2020-04-22 13:56
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTree {
    /**
     * 199. 二叉树的右视图
     * <p>
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     * <p>
     * 1            <---
     * /   \
     * 2     3         <---
     * \     \
     * 5     4       <---
     *  \
     * 6             <---
     */

    /**
     * BFS
     */
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        ArrayList<TreeNode> os = new ArrayList<TreeNode> ();
        os.add (root);
        while (!os.isEmpty ()) {
            Integer i = null;
            ArrayList<TreeNode> newOs = new ArrayList<> ();
            for (TreeNode treeNode : os) {
                i = treeNode.val;
                TreeNode left = treeNode.left;
                if (left != null) {
                    newOs.add (left);
                }
                TreeNode right = treeNode.right;
                if (right != null) {
                    newOs.add (right);
                }
            }
            list.add (i);
            os = newOs;
        }
        return list;
    }

    /**
     * DFS
     */
    static List<Integer> op = new ArrayList<> ();

    public static List<Integer> rightSideView2(TreeNode root) {

        if (root == null) {
            return op;
        }
        op.add (root.val);
        findRightNode (root, 1);
        return op;
    }

    public static void findRightNode(TreeNode root, int level) {

        TreeNode right = root.right;
        if (right != null) {
            if (op.size () == level) {
                op.add (right.val);
            }
            findRightNode (right, level + 1);

        }
        TreeNode left = root.left;
        if (left != null) {
            if (op.size () == level) {
                op.add (left.val);
            }
            findRightNode (left, level + 1);
        }
    }

    /**
     * 简化后的DFS
     */
    public static List<Integer> rightSideView3(TreeNode root) {

        if (root == null) {
            return op;
        }
        findRightNode2 (root, 0);
        return op;
    }

    public static void findRightNode2(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (op.size () == level) {
            op.add (root.val);
        }

        findRightNode2 (root.right, level + 1);
        findRightNode2 (root.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode (1);

        TreeNode left2 = new TreeNode (2);
        root.left = left2;
        TreeNode left5 = new TreeNode (5);
        left2.left = left5;
        TreeNode left6 = new TreeNode (6);
        left5.right = left6;


        TreeNode right3 = new TreeNode (3);
        root.right = right3;
      /*  TreeNode right4 = new TreeNode (4);
        right3.left = right4;*/
        List<Integer> integers = rightSideView2 (root);
        System.out.println (integers);
    }


}
