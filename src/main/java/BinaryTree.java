import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.abs;

/**
 * Created by srawa5 on 4/25/2017.
 */
public class BinaryTree {

    static BinaryTreeNode root;
    private static int level;

    public static BinaryTreeNode createNewNode(int n) {
        BinaryTreeNode node = new BinaryTreeNode();
        node.num = n;
        node.right = null;
        node.left = null;
        return node;
    }

    public static BinaryTreeNode createRoot(int n) {
        BinaryTreeNode node = new BinaryTreeNode();
        node.num = n;
        node.right = null;
        node.left = null;
        root = node;
        return node;
    }

    public static BinaryTreeNode getRoot() {
        return root;
    }

    public static void setRoot(BinaryTreeNode root) {
        root = root;
    }

    public static void inOrderTraversal(BinaryTreeNode node) {

        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.num);
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(BinaryTreeNode node) {

        if (node != null) {
            System.out.println(node.num);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(BinaryTreeNode node) {

        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.println(node.num);
        }
    }

    public static int size(BinaryTreeNode node) {

        if (node != null) {

            if (isLeafNode(node))
                return 1;

            return size(node.left) + size(node.right) + 1;
        }
        return 0;
    }

    private static boolean isLeafNode(BinaryTreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public static void levelOrderTraversal(BinaryTreeNode node) {
        for (int i = 0; i < height(node); i++) {
            levelOrderTraversalOfGivenLevel(node, i);
            System.out.println();
        }
    }

    public static void levelOrderTraversalOfGivenLevel(BinaryTreeNode node, int i) {

        if (node != null) {

            if (i == 0) {
                System.out.print(node.num + " ");
            } else {
                levelOrderTraversalOfGivenLevel(node.left, i - 1);
                levelOrderTraversalOfGivenLevel(node.right, i - 1);
            }
        }
    }

    public static int height(BinaryTreeNode node) {
        if (node != null) {
            if (isLeafNode(node)) {
                return 1;
            }
            return 1 + max(height(node.left), height(node.right));
        }
        return 0;

    }

    private static int max(int num1, int num2) {
        return num1 >= num2 ? num1 : num2;
    }


    public static void levelOrderTraversalIterative(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(node);

        BinaryTreeNode currrentNode = queue.poll();
        while (currrentNode != null) {

            System.out.println(currrentNode.num);

            BinaryTreeNode leftNode = currrentNode.left;
            if (leftNode != null) {
                queue.add(leftNode);
            }
            BinaryTreeNode rightNode = currrentNode.right;
            if (rightNode != null) {
                queue.add(rightNode);
            }

            currrentNode = queue.poll();
        }
    }

    public static void inOrderTraversalIterative(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        BinaryTreeNode currentNode = node;
        while (true) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            BinaryTreeNode poppedElement = stack.pop();
            currentNode = poppedElement.right;

            System.out.println(poppedElement.num);
            if (stack.isEmpty() && currentNode == null) {
                break;
            }

        }

    }

    public static boolean ifBinaryTreeIdentical(BinaryTreeNode node1, BinaryTreeNode node2) {
        if ((node1 == null && node2 != null) && (node1 != null && node2 == null)) {
            return false;
        } else if (node1 == null && node2 == null) {
            return true;
        }
        return (node1.num == node2.num) && ifBinaryTreeIdentical(node1.left, node2.left) && ifBinaryTreeIdentical(node1.right, node2.right);
    }

    public static void mirrorBinaryTree(BinaryTreeNode node) {
        if (node != null) {
            if (node.right != null && node.left != null) {
                BinaryTreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
                mirrorBinaryTree(node.left);
                mirrorBinaryTree(node.right);
            }
        }
    }

    public static void printRootToLeafPath(BinaryTreeNode node, int[] binaryTreeNodes, int i) {

        if (node != null) {
            binaryTreeNodes[i] = node.num;
            if (node.left != null) {
                printRootToLeafPath(node.left, binaryTreeNodes, i + 1);
            }
            if (node.right != null) {
                printRootToLeafPath(node.right, binaryTreeNodes, i + 1);
            }

            if (isLeafNode(node)) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(binaryTreeNodes[j] + " ");
                }
                System.out.println();
            }
        }

    }

    public static int leafNodeCount(BinaryTreeNode node) {
        if (node != null) {
            if (isLeafNode(node)) {
                return 1;
            }
            return leafNodeCount(node.left) + leafNodeCount(node.right);
        }
        return 0;
    }

    public static void spiralLevelOrderTraversal(BinaryTreeNode node) {
        for (int i = 0; i < height(node); i++) {
            spiralLevelOrderTraversalOfGivenLevel(node, i);
            System.out.println();
        }
    }

    public static void spiralLevelOrderTraversalOfGivenLevel(BinaryTreeNode node, int i) {

        if (node != null) {

            if (i == 0) {
                System.out.print(node.num + " ");
            } else if (i % 2 == 0) {
                levelOrderTraversalOfGivenLevel(node.left, i - 1);
                levelOrderTraversalOfGivenLevel(node.right, i - 1);
            } else {
                levelOrderTraversalOfGivenLevel(node.right, i - 1);
                levelOrderTraversalOfGivenLevel(node.left, i - 1);
            }
        }
    }

    public static void spiralLevelOrderTraversalIterative(BinaryTreeNode node) {

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(node);
        int i = 0;
        BinaryTreeNode currrentNode = queue.poll();

        while (currrentNode != null) {

            System.out.println(currrentNode.num);

            if (i % 2 == 0) {

                BinaryTreeNode leftNode = currrentNode.left;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                BinaryTreeNode rightNode = currrentNode.right;
                if (rightNode != null) {
                    queue.add(rightNode);
                }
            } else {

                BinaryTreeNode rightNode = currrentNode.right;
                if (rightNode != null) {
                    queue.add(rightNode);
                }

                BinaryTreeNode leftNode = currrentNode.left;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
            }
            currrentNode = queue.poll();
            i++;
        }


    }

    public static boolean checkChildSumProperty(BinaryTreeNode node) {

        if (node != null) {
            int leftNodeVal = 0;
            int rightNodeVal = 0;

            if (isLeafNode(node)) {

                return true;
            }


            BinaryTreeNode left = node.left;
            if (left != null)
                leftNodeVal = left.num;

            BinaryTreeNode right = node.right;
            if (right != null)
                rightNodeVal = right.num;

            boolean leftTreeCheck = checkChildSumProperty(left);
            boolean rightTreeCheck = checkChildSumProperty(node.right);
            return (node.num == (leftNodeVal + rightNodeVal)) && leftTreeCheck && rightTreeCheck;

        }
        return true;
    }

    public static int convertChildSumProperty(BinaryTreeNode node) {
        if (node != null) {
            if (isLeafNode(node)) {
                return node.num;
            }

            int left = convertChildSumProperty(node.left);
            int right = convertChildSumProperty(node.right);
            node.num = left + right;
            return node.num;

        }
        return 0;
    }

    public static int maxDiameterOfBinaryTree(BinaryTreeNode node) {

        if (node != null) {
            if (isLeafNode(node)) {
                return 1;
            }
            int leftMax = maxDiameterOfBinaryTree(node.left);
            int rightMax = maxDiameterOfBinaryTree(node.right);
            return max(max(leftMax, rightMax), 1 + height(node.left) + height(node.right));
        }
        return 0;
    }

    public static boolean checkHeightBalancedTree(BinaryTreeNode node) {

        if (node != null) {
            if (isLeafNode(node)) {
                return true;
            }

            int leftHeight = height(node.left);
            int rightHeight = height(node.right);


            return abs(leftHeight - rightHeight) < 2 && checkChildSumProperty(node.left) && checkChildSumProperty(node.right);
        }
        return true;
    }

    public static void printRootToLeafPathWithGivenSum(BinaryTreeNode node, int[] arr, int index, int sum) {
        if (node != null) {
            if (isLeafNode(node)) {
                if (sum == node.num) {
                    arr[index] = sum;
                    printArray(arr);
                }
                return;
            }

            arr[index] = node.num;
            printRootToLeafPathWithGivenSum(node.left, arr, index + 1, sum - node.num);
            printRootToLeafPathWithGivenSum(node.right, arr, index + 1, sum - node.num);

        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0)
            System.out.println(arr[i] + " ");
        }
    }

    public static void widthOfBinaryTree(BinaryTreeNode node, int[] arr, int index) {
        if (node != null) {

            arr[index]++;
            widthOfBinaryTree(node.left, arr, index + 1);
            widthOfBinaryTree(node.right, arr, index + 1);
        }
    }

    public static void printArray(int[] arr, String template, boolean indexPrint) {
        for (int i = 0; i < arr.length; i++) {
            if (indexPrint) {
                System.out.println(template + " : " + arr[i]);
            } else {
                System.out.println(template + i + " : " + arr[i]);
            }
        }
    }

    public static void printNodesAtDistanceK(BinaryTreeNode node, int k) {
        if(node!=null){
            if(k==0)
            System.out.println(node.num);

            printNodesAtDistanceK(node.left,k-1);
            printNodesAtDistanceK(node.right,k-1);

        }
    }

    public static int getLevel() {
        return level;
    }

    public static void getLevelOfKey(BinaryTreeNode node, int key, int tempLevel) {
        if(node!=null)
        {
            if(node.num==key){
                level = tempLevel;
            }

            getLevelOfKey(node.left,key,tempLevel+1);
            getLevelOfKey(node.right,key, tempLevel+1);
        }

    }

    public static void printAllAncestors(BinaryTreeNode node, int[] arr, int key, int index) {
        if(node!=null){
            if(node.num ==key){
                arr[index] = node.num;
                printArray(arr);
                return;
            }

            arr[index]=node.num;
            printAllAncestors(node.left,arr,key,index+1);
            printAllAncestors(node.right,arr,key,index+1);

        }
        return;
    }

    public static boolean checkSumTreeProperty(BinaryTreeNode node, int[] arr) {
        if(node!=null){
            if(checkSumTreeProperty(node.left,arr) && checkSumTreeProperty(node.right,arr)){
                if(node.left !=null){
                    arr[0] += node.left.num;
                }

                if(node.right !=null){
                    arr[0] += node.right.num;
                }

                return (2*arr[0]==node.num);

            }
            return false;


        }
        return true;
    }
}
