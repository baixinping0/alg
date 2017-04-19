package alg.bxp.qunar.tree;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int count = 0;
		int[] preOrder = null;
		int[] inOrder = null;
		String[] preOrderS = null;
		String[] inOrderS = null;
		Scanner s = new Scanner(System.in);
		int i = 0;
		while (s.hasNext()){
			if(i == 0){
				count = Integer.parseInt(s.nextLine());
				preOrder = new int[count];
				inOrder = new int[count];
			}else if(i == 1){
				preOrderS = s.nextLine().split(" ");
			}else{
				inOrderS = s.nextLine().split(" ");
			}
			if(i == 2)
				break;
			i++;
		}
		for(int j = 0; j < count; j++){
			 preOrder[j] = Integer.parseInt(preOrderS[j].trim());
			 inOrder[j] = Integer.parseInt(inOrderS[j].trim());
		}
		Main build = new Main();
		TreeNode root = build.reConstructBinaryTree(preOrder, inOrder);
		build.levelOrder(root);
	}
	
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode head = buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return head;
	}
	public TreeNode buildTree(int[] preOrder, int begin1, int end1, int[] inOrder, int begin2, int end2) {
		if (begin1 > end1 || begin2 > end2) {
			return null;
		}
		int rootData = preOrder[begin1];
		TreeNode head = new TreeNode(rootData);
		int divider = findIndexInArray(inOrder, rootData, begin2, end2);
		int offSet = divider - begin2 - 1;
		TreeNode left = buildTree(preOrder, begin1 + 1, begin1 + 1 + offSet, inOrder, begin2, begin2 + offSet);
		TreeNode right = buildTree(preOrder, begin1 + offSet + 2, end1, inOrder, divider + 1, end2);
		head.left = left;
		head.right = right;
		return head;
	}
	public int findIndexInArray(int[] a, int x, int begin, int end)
	{
		for (int i = begin; i <= end; i++)
		{
			if (a[i] == x)
				return i;
		}
		return -1;
	}
	//中序遍历
	public void inOrder(TreeNode n)
	{
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.val + " ");
			inOrder(n.right);
		}
	}
	//前序遍历
	public void preOrder(TreeNode n)
	{
		if (n != null)
		{
			System.out.print(n.val + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	//层序遍历
	public void levelOrder(TreeNode n) {
        if (n == null) {
            return;
        }
        int depth = depth(n);

        for (int i = 1; i <= depth; i++) {
            levelOrder(n, i);
        }
    }

	
    private void levelOrder(TreeNode n, int level) {
        if (n == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(n.val + " ");
            return;
        }
        // 左子树
        levelOrder(n.left, level - 1);
        // 右子树
        levelOrder(n.right, level - 1);
    }

    public int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }

        int l = depth(n.left);
        int r = depth(n.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
	
	
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

