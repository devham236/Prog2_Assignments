package assignment_05.debug.model;

//Inserts integers in a sorted way. Only needs to search in one subtree as a
//result.
public class SortedIntBinTreeNode extends IntBinTreeNode {
  
  public SortedIntBinTreeNode(int content, SortedIntBinTreeNode left, SortedIntBinTreeNode right) {
    super(content, left, right);
    if ((left != null && left.content_ >= content) || (right != null && right.content_ <= content)) {
      System.err.println("Trying to create invalid sorted tree.");
      System.exit(2);
    }
  }

  @Override
  public boolean contains(int i) {
    if (i == this.content_) {
      return true;
    }

    if (i < this.content_) {
      return this.left_ != null && this.left_.contains(i);
    }

    else {
      return this.right_ != null && this.right_.contains(i);
    }
  }

  /**
   * Inserts integer into the sorted tree.
   * Smaller Integers will be placed into the left subtree, larger ones into
   * the right subtree. Equal ones will be ignored
   * 
   * @param i Integer to insert.
   */
  @Override
  public void insert(int i) {
    if (i < super.content_) {
      if (super.left_ == null) 
        super.left_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.left_.insert(i);
    } else if (i > super.content_) {
      if (super.right_ == null) 
        super.right_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.right_.insert(i);
    }
  }
}

/*
Zeile 24 und 29: Größere Werte müssen nach rechts und kleinere Werte nach links, hier ist es umgekehrt

Zeile 15-28: Methode contains von IntBinTreeNode fehlt
 */