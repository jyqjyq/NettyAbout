package com.jyq.test;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

public class TreeTest {
    static class TreeNode{
        private Integer val;
        private Integer hight;
        private TreeNode leftNode;
        private TreeNode rightNode;

        TreeNode(Integer val ,TreeNode leftNode,TreeNode rightNode){
            this.val = val;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

    }

    public static void main(String[] args) {
        TreeTest.TreeNode t7 = new TreeNode(7,null,null);
        TreeTest.TreeNode t6 = new TreeNode(6,null,null);
        TreeTest.TreeNode t5 = new TreeNode(5,t6,t7);
        TreeTest.TreeNode t4 = new TreeNode(4,null,null);
        TreeTest.TreeNode t3 = new TreeNode(3,null,null);
        TreeTest.TreeNode t2 = new TreeNode(2,t4,t5);
        TreeTest.TreeNode t1 = new TreeNode(1,t2,t3);
        //前序
        print(t1);
    }

    private static void print(TreeNode t1) {
        if(t1 == null){
            return ;
        }
        System.out.println(t1.val);
        print(t1.leftNode);
        print(t1.rightNode);
    }

}
