package assignment_02.task_2.model;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int val){
        this.value = val;
    }

    public int GetValue(){
        return this.value;
    }

    public Tree GetRight() {
        return this.right;
    }

    public Tree GetLeft() {
        return this.left;
    }

    public void SetLeft(Tree t){
        this.left = t;
    }

    public void SetRight(Tree t){
        this.right = t;
    }

    public static String str(Tree t){
        if (t == null){
            return "";
        }

        return str(t.left) + " " + t.value + " " + str(t.right);
    }

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        }

        if (this.left != null && this.left.contains(value)) {
            return true;
        }

        if (this.right != null && this.right.contains(value)) {
            return true;
        }

        return false;
    }

    public void insertValue(int value) {
        if (contains(value)){
            return;
        }

        // check ob wert nach links muss
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Tree(value);
            } else {
                this.left.insertValue(value);
            }
        }

        // check ob wert nach rechts muss
        else if (value > this.value) {
            if (this.right == null) {
                this.right = new Tree(value);
            } else {
                this.right.insertValue(value);
            }
        }
    }
}
