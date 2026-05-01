package assignment_04.debug;

public class Animal {
  protected String name_;
  protected int legs_;
  protected int arms_;


  public Animal(String name, int legs, int arms) {
    this.name_ = name;
    this.legs_ = legs;
    this.arms_ = arms;
  }

  public Animal(String name) {
    this(name, 0, 0);
  }


  public String getName() {
    return this.name_;
  }

  public int getArms() {
    return this.arms_;
  }

  public int getLegs() {
    return this.legs_;
  }

  @Override
  public String toString() {
    return String.format("%s is an animal with %d legs and %d arms.", this.getName(), this.getLegs(), this.getArms());
  }
}

/*
Zeile 4-6: Variablen auf protected gestellt anstatt private, damit andere Klassen Zugriff haben

Zeile 9 und 15: Konstruktoren auf public gestellt damit Subklassen Zugriff haben.
 */