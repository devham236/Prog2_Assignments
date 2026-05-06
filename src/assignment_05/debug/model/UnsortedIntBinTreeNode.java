package assignment_05.debug.model;

import java.util.Random;

//Inserts randomly left or right. Needs to search through both subtrees, as
//there is no way of knowing where the node containing i might be.
public class UnsortedIntBinTreeNode extends IntBinTreeNode {
  private static Random rand = new Random();

  public UnsortedIntBinTreeNode(int content, SortedIntBinTreeNode left, SortedIntBinTreeNode right){
    super(content, left, right);
  }

  /**
   * Randomly inserts to left or right.
   * If left/right is not null, call insert on that child node.
   * 
   * @param i Integer to insert.
   */
  @Override
  public void insert(int i) {
    if (UnsortedIntBinTreeNode.rand.nextBoolean()) {
      if (left_ == null) 
        left_ = new UnsortedIntBinTreeNode(i, null, null);
      else
        left_.insert(i);
    } else {
      if (right_ == null) 
        right_ = new UnsortedIntBinTreeNode(i, null, null);
      else
        right_.insert(i);
    }
  }

  /**
   * Looks if integer is in tree.
   * Looks through both subtrees, as they are not sorted.
   * 
   * @param i Integer to search for.
   * @return  True if integer is in tree.
   */
  @Override
  public boolean contains(int i) {
    return content_ == i || (left_ != null && left_.contains(i)) || (right_ != null && right_.contains(i));
  }
}

/*
Zeile 8: Random Objekt wird nicht mit new Random() initialisiert

Zeile 10-12: Konstruktor mit super() Aufruf fehlt, weil Basisklasse keinen Standardkonstruktor ohne Parameter hat.

Zeile 23-31 und Zeile 44: Aufruf von den Feldern left, right mit super ist unnötig.
 */