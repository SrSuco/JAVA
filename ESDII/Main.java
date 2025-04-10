import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class No {
    String key;
    No left, right;

    No(String key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BinarySearchTree {
    private No root;
    
    public void insert(String key) {
        root = insertRec(root, key);
    }

    private No insertRec(No no, String key) {
        if (no == null) {
            return new No(key);
        }
        if (key.compareTo(no.key) < 0) {
            no.left = insertRec(no.left, key);
        } else if (key.compareTo(no.key) > 0) {
            no.right = insertRec(no.right, key);
        }
        return no;
    }


    public boolean search(String key) {
        return searchRec(root, key);
    }

    private boolean searchRec(No no, String key) {
        if (no == null) {
            return false;
        }
        if (key.equals(no.key)) {
            return true;
        }
        return key.compareTo(no.key) < 0 ? searchRec(no.left, key) : searchRec(no.right, key);
    }

    public void printInOrder() {
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(No no) {
        if (no != null) {
            printInOrderRec(no.left);
            System.out.print(no.key + " ");
            printInOrderRec(no.right);
        }
    }

    public void printPreOrder() {
        printPreOrderRec(root);
        System.out.println();
    }

    private void printPreOrderRec(No no) {
        if (no != null) {
            System.out.print(no.key + " ");
            printPreOrderRec(no.left);
            printPreOrderRec(no.right);
        }
    }

    public void printPostOrder() {
        printPostOrderRec(root);
        System.out.println();
    }

    private void printPostOrderRec(No no) {
        if (no != null) {
            printPostOrderRec(no.left);
            printPostOrderRec(no.right);
            System.out.print(no.key + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bst = new BinarySearchTree();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "I":
                    String insertKey = parts[1];
                    bst.insert(insertKey);
                    break;

                case "INFIXA":
                    bst.printInOrder();
                    break;

                case "PREFIXA":
                    bst.printPreOrder();
                    break;

                case "POSFIXA":
                    bst.printPostOrder();
                    break;

                case "P":
                    String searchKey = parts[1];
                    if (bst.search(searchKey)) {
                        System.out.println(searchKey + " existe");
                    } else {
                        System.out.println(searchKey + " nao existe");
                    }
                    break;
            }
        }
    }
}