package assignment_02.task_2;

import assignment_02.task_2.model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree root = new Tree(5);
        Tree left_child = new Tree(2);
        Tree right_child = new Tree(7);

        root.SetLeft(left_child);
        root.SetRight(right_child);
        root.insertValue(5);

        System.out.println(root.str(root));
        System.out.println(root.contains(5));
    }
}
