package binaryTree;

public class App {

    public static void main(String[] args) {
        binaryTreeQuestions();
    }

    private static void binaryTreeQuestions() {
        BinaryTreeNode root = BinaryTree.createRoot(12);
        root.left = BinaryTree.createNewNode(4);
        root.right = BinaryTree.createNewNode(8);
        root.left.left = BinaryTree.createNewNode(3);
        root.left.right = BinaryTree.createNewNode(1);
        root.right.left = BinaryTree.createNewNode(5);
        root.right.right = BinaryTree.createNewNode(3);

/*
        root.left.left.left = BinaryTree.createNewNode(8);
        root.left.left.right = BinaryTree.createNewNode(9);
        root.left.right.left = BinaryTree.createNewNode(10);
        root.left.right.right = BinaryTree.createNewNode(11);
        root.right.left.left = BinaryTree.createNewNode(12);
        root.right.left.right = BinaryTree.createNewNode(13);
        root.right.right.left = BinaryTree.createNewNode(14);
        root.right.right.right = BinaryTree.createNewNode(15);*/


        BinaryTreeNode root1 = BinaryTree.createNewNode(26);
        root1.left = BinaryTree.createNewNode(10);
        root1.right = BinaryTree.createNewNode(3);
        root1.left.left = BinaryTree.createNewNode(4);
        root1.left.right = BinaryTree.createNewNode(6);
        root1.right.left = BinaryTree.createNewNode(4);

        System.out.println("******* InOrder Traversal **********");
        BinaryTree.inOrderTraversal(root1);

        System.out.println("******* PreOrder Traversal **********");
        BinaryTree.preOrderTraversal(root1);

        System.out.println("******* PostOrder Traversal **********");
        BinaryTree.postOrderTraversal(root1);

        System.out.println("******* Level Order Traversal **********");
        BinaryTree.levelOrderTraversal(root1);

        System.out.println("******* Level Order Traversal Iterative **********");
        BinaryTree.levelOrderTraversalIterative(root1);

        System.out.println("******* InOrder Traversal w/o recursion **********");
        BinaryTree.inOrderTraversalIterative(root1);

        System.out.println("******* size Of Tree **********");
        System.out.println("Size of tree : " + BinaryTree.size(root1));

        System.out.println("******* height Of Tree **********");
        System.out.println("Size of tree : " + BinaryTree.height(root1));

        System.out.println("******* comparison of binary Tree ****************");
        System.out.println(BinaryTree.ifBinaryTreeIdentical(root1, root));

        System.out.println("******* Mirroring of binary Tree ****************");
        BinaryTree.mirrorBinaryTree(root);

        System.out.println("******* Level Order Traversal Iterative **********");
        BinaryTree.levelOrderTraversalIterative(root);

        System.out.println("************ Root To leaf Path ***************");
        BinaryTree.printRootToLeafPath(root, new int[10], 0);

        System.out.println("************ leaf Nodes Count ***************");
        System.out.println(BinaryTree.leafNodeCount(root));

        System.out.println("************ spiral Level Order Traversal ***************");
        BinaryTree.spiralLevelOrderTraversal(root);

        System.out.println("************ spiral Level Order Traversal Iterative ***************");
        BinaryTree.spiralLevelOrderTraversalIterative(root);

        System.out.println("************ child Sum Property check ***************");
        System.out.println("Have Child sum Property : " + (BinaryTree.checkChildSumProperty(root) ? "True" : "false"));

        System.out.println("************ child Sum Property conversion ***************");
        System.out.println("Have Child sum Property : " + (BinaryTree.checkChildSumProperty(root1) ? "True" : "false"));
        BinaryTree.convertChildSumProperty(root1);
        System.out.println("Have Child sum Property : " + (BinaryTree.checkChildSumProperty(root1) ? "True" : "false"));
        BinaryTree.levelOrderTraversal(root1);

        System.out.println("************ Diameter Of Binary Tree ***************");
        System.out.println("Diameter of tree : " + BinaryTree.maxDiameterOfBinaryTree(root));

        System.out.println("***********  check Whether Tree is height Balanced ****************");
        //optimise solution to O(n)
        System.out.println("Binary Tree is height Balanced : " + (BinaryTree.checkHeightBalancedTree(root1) ? "True" : "false"));

        System.out.println("*********  Root to Leaf Path equal to Given Sum **********");
        int heightOfRoot = BinaryTree.height(root);
        BinaryTree.printRootToLeafPathWithGivenSum(root, new int[heightOfRoot], 0, 23);

        System.out.println("************** Width Of Binay Tree *****************");
        // ToDo (Using Level Order Traversal with Queue)
        int[] arr = new int[BinaryTree.height(root1)];
        BinaryTree.widthOfBinaryTree(root1, arr, 0);
        BinaryTree.printArray(arr, "Width of Binary Tree of Level ", true);

        System.out.println("***********  Print Node at k distance from root ***********");
        BinaryTree.printNodesAtDistanceK(root1, 3);

        System.out.println("**********  Print Level of Node **************");
        int key = 8;
        BinaryTree.getLevelOfKey(root1, key, 1);
        System.out.println("Level Of Node " + key + " is : " + BinaryTree.getLevel());

        System.out.println("**********  Print Ancestors of a given Node **************");
        BinaryTree.printAllAncestors(root, new int[heightOfRoot], 8, 0);

        System.out.println("**********  check Sum Tree Property **************");
        System.out.println("Have Child sum Property : " + (BinaryTree.checkSumTreeProperty(root1, new int[1]) ? "True" : "false"));
    }


}
