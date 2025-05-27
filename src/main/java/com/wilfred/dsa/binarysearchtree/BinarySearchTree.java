package com.wilfred.dsa.binarysearchtree;

import java.util.*;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }


    public boolean contains(int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean contains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.value == value) {
            return true;
        }
        if (value < currentNode.value) {
            return contains(currentNode.left, value);
        } else {
            return contains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return contains(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;

    }

    private Node rInsert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node currentNode = new Node(mid);
        currentNode.left = rInsert(nums, left, mid - 1);
        currentNode.right = rInsert(nums, mid + 1, right);
        return currentNode;
    }

    private Node invertTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }


    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);

    }

    public void deleteNode(int value) {
        deleteNode(root, value);

    }


    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minimumValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }


    private int minimumValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


    public ArrayList<Integer> BFS() {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(current);
        while (queue.size() > 0) {
            current = queue.remove();
            results.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return results;
    }


    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        //another way of writing this code
        /*class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }

        }
        new Traverse(root);*/
        //using  recursion
        preOrder(root, results);
        return results;

    }

    private void preOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        results.add(currentNode.value);
        if (currentNode.left != null) {
            preOrder(currentNode.left, results);
        }
        if (currentNode.right != null) {
            preOrder(currentNode.right, results);
        }

    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        //another way of writing this code
        /*class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);

            }

        }
        new Traverse(root);*/
        //using  recursion
        postOrder(root, results);
        return results;

    }

    private void postOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.left != null) {
            postOrder(currentNode.left, results);
        }
        if (currentNode.right != null) {
            postOrder(currentNode.right, results);
        }
        results.add(currentNode.value);

    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();
        //another way of writing this code
        /*class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                     results.add(currentNode.value);

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }

            }

        }
        new Traverse(root);*/
        //using  recursion
        inOrder(root, results);
        return results;

    }

    private void inOrder(Node currentNode, ArrayList<Integer> results) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.left != null) {
            inOrder(currentNode.left, results);
        }
        results.add(currentNode.value);
        if (currentNode.right != null) {
            inOrder(currentNode.right, results);
        }

    }

    public boolean isValidBST() {
        ArrayList<Integer> results = new ArrayList<>();
        inOrder(root, results);
        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i + 1) < results.get(i)) {
                return false;
            }
        }
        return true;

    }

    public Integer kthSmallest(int k) {
        ArrayList<Integer> results = new ArrayList<>();
        inOrder(root, results);
        if (k > results.size())
            return null;
        return results.get(k - 1);

    }

    public Integer kthSmallest2(int k) {
        // Create an empty stack to keep track of nodes
        Stack<Node> stack = new Stack<>();

        // Start from the root of the BST
        Node node = this.root;

        // Continue as long as there are unprocessed nodes
        while (!stack.isEmpty() || node != null) {

            // Traverse to the leftmost node of the current subtree,
            // pushing all the nodes onto the stack
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Process nodes from the stack when no left children
            node = stack.pop();

            // Decrement k after each processed node
            k -= 1;

            // If k reaches 0, return the current node value
            if (k == 0) {
                return node.value;
            }

            // Move to the right child after a node has been processed
            node = node.right;
        }

        // Return null if fewer than k nodes in the tree
        return null;
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.value != q.value) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public List<List<Integer>> levelOrderBottom() {
        LinkedList<List<Integer>> results = new LinkedList<>();
        if (root == null) return results;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.value);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add at the beginning to build bottom-up order
            results.addFirst(level);
        }

        return results;
    }

    public int maxDepth(TreeNode root) {
        return maxCount(root, 0);
    }

    private int maxCount(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count++;
        return Math.max(maxCount(root.left, count), maxCount(root.right, count));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(current);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int count = 0;
            List<Integer> levels = new ArrayList<>();
            while (count < len) {
                current = queue.remove();
                levels.add(current.val);
                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
                count++;
            }
            results.add(levels);

        }
        return results;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.offer(current);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int count = 1;
            while (count <= len) {
                current = queue.remove();
                if (count == len) {
                    results.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                count++;
            }
        }
        return results;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null)
            return results;
        results.add(root.val);
        dfsRightSide(root.right, results);
        return  results;
    }

    void dfsRightSide(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        results.add(root.val);
        if(root.right!=null){
            dfsRightSide(root.right, results);
        }

    }

}
