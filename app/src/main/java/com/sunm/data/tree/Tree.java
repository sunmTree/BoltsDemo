package com.sunm.data.tree;

import android.support.annotation.Nullable;
import android.util.Log;

import com.sunm.AppConfig;

import java.util.Stack;

/**
 * Created by Administrator on 2017/10/8.
 */

public class Tree {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "Tree";
    private Node root;

    public static final int TREE_PRE_ORDER = 1;
    public static final int TREE_IN_ORDER = 2;
    public static final int TREE_POST_ORDER = 3;

    public Tree() {
        root = null;
    }

    /**
     * 查找
     *
     * @param key
     * @return nullable
     */
    @Nullable
    public Node find(int key) {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /***
     * 插入
     * @param id
     * @param dd
     */
    public void insert(int id, double dd) {
        Node node = new Node();
        node.iData = id;
        node.dData = dd;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftNode;
                    if (current == null) {
                        parent.leftNode = node;
                        return;
                    }
                } else {
                    current = current.rightNode;
                    if (current == null) {
                        parent.rightNode = node;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除操纵
     *
     * @param key
     * @return
     */
    public boolean delete(int key) {
        if (root == null) {
            return false;
        }
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftNode;
            } else {
                isLeftChild = false;
                current = current.rightNode;
            }
            if (current == null) {
                return false;
            }
        }

        // if no children, simple delete it
        if (current.leftNode == null && current.rightNode == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
        } else if (current.rightNode == null) { // if no right child, replace with left subtree
            if (current == root) {
                root = current.leftNode;
            } else if (isLeftChild) {
                parent.leftNode = current.leftNode;
            } else {
                parent.rightNode = current.leftNode;
            }
        } else if (current.leftNode == null) { // if no left child, replace with right subtree
            if (current == root) {
                root = current.rightNode;
            } else if (isLeftChild) {
                parent.leftNode = current.rightNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftNode = successor;
            } else {
                parent.rightNode = successor;
            }

            // connect successor to current's left child
            successor.leftNode = current.leftNode;
        }

        return true;
    }

    /**
     * goes to right child, then right child's left descendents
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rightNode;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }

        // 要删除的节点的右子节点有它自己的左子节点
        if (successor != delNode.rightNode) {
            successorParent.leftNode = successor.rightNode;
            // successor 替换被删除的 delNode
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }

    /**
     * @param traverseType
     */
    public void traverse(int traverseType) {
        switch (traverseType) {
            case TREE_PRE_ORDER:
                if (DEBUG) {
                    Log.d(TAG, "start preOrder this tree");
                }
                preOrder(root);
                break;
            case TREE_IN_ORDER:
                if (DEBUG) {
                    Log.d(TAG, "start inOrder this tree");
                }
                inOrder(root);
                break;
            case TREE_POST_ORDER:
                if (DEBUG) {
                    Log.d(TAG, "start postOrder this tree");
                }
                postOrder(root);
                break;
        }
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            if (DEBUG) {
                Log.i(TAG, "preOrder localRoot data [ "
                        + localRoot.iData + " , " + localRoot.dData + " ]");
            }
            preOrder(localRoot.leftNode);
            preOrder(localRoot.rightNode);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftNode);
            if (DEBUG) {
                Log.i(TAG, "inOrder localRoot data [ "
                        + localRoot.iData + " , " + localRoot.dData + " ]");
            }
            inOrder(localRoot.rightNode);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftNode);
            postOrder(localRoot.rightNode);
            if (DEBUG) {
                Log.i(TAG, "postOrder localRoot data [ "
                        + localRoot.iData + " , " + localRoot.dData + " ]");
            }
        }
    }

    public void displayTree() {
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (!nodes.isEmpty()) {
                Node temp = nodes.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftNode);
                    localStack.push(temp.rightNode);

                    if (temp.leftNode != null || temp.rightNode != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.print(" ");
                }
                nBlanks /= 2;
                while (!localStack.isEmpty()) {
                    nodes.push(localStack.pop());
                }
            }
        }
    }
}
