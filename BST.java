package dummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BST {

	public BST() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		BSTNode root=null;
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			root= insertBSTNode(root, sc.nextInt());
		}
		
		
		root= deleteBSTNode(root, sc.nextInt());
		printBST(root);
		
		}
	public static void printBST(BSTNode root) {
		if(root==null) return;
		System.out.println(root.key);
		printBST(root.left);
		printBST(root.right);
	}
	static BSTNode insertBSTNode(BSTNode root, int key) {
		//System.out.println("hello ");
		if(root==null) {
			return new BSTNode(key);
		}
		
		else if(key<root.key) {
			root.left= insertBSTNode(root.left, key);	
		}
		else {
			root.right= insertBSTNode(root.right, key);
		}
			return root;
	}
	static BSTNode deleteBSTNode(BSTNode root, int key) 
    {
        if(root==null) return null;
        
        if(root.key==key) {
            if(root.left==null && root.right==null) {
                return null;
            }
            else if(root.left==null) {
                return root.right;
            }
            else if(root.right==null) {
                 return root.left;
            }
            else {
                BSTNode newBSTNode=root;
                BSTNode prev=root;
                root=root.right;
                if(root.left==null) {
                    prev.right=root.right;
                } else {
                    while(root.left!=null) {
                        prev=root;
                        root=root.left;
                    }
                    prev.left=root.right;
                }
                newBSTNode.key=root.key;
                return newBSTNode;
            }
        }
        else if(root.key>key) {
            root.left= deleteBSTNode(root.left, key);
        } else {
            root.right= deleteBSTNode(root.right, key);
        }
        return root;
    }
	
}
class BSTNode
{
    int key;
    BSTNode left, right;

    BSTNode(int item)
    {
        key = item;
        left = right = null;
    }
}
