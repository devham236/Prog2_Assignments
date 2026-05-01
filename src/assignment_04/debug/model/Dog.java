package assignment_04.debug.model;

import assignment_04.debug.Animal;

public class Dog extends Animal {
    
  public Dog(String name) {
    super(name);
  }


  @Override
  public String getName() {
    return super.name_;
  }

  @Override
  public int getArms() {
    return 2;
  }

  @Override
  public int getLegs() {
    return 2;
  }

  @Override
  public String toString() {
    return String.format("%s is a dog with %d legs and %d arms.", this.getName(), this.getArms(), this.getLegs());
  }
}

/*
Zeile 3: Animal Klasse importiert, damit Dog Klasse Konstruktor verwenden kann

Zeile 18 und 23: Funktionen geben 4 wieder, ein Hund hat aber nicht 4 Beine und 4 Arme.
 */