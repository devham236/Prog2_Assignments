package assignment_03.jumpNrun;

public class NPC {
    private int xCoordinate;
    boolean isCrouching;

    public NPC(int x, boolean c){
        this.xCoordinate = x;
        this.isCrouching = c;
    }

    public void StandUp(){
        this.isCrouching = false;
    }

    public void crouch(){
        this.isCrouching = true;
    }

    public void walkRight(){
        this.xCoordinate += 1;
    }

    public void dashRight(){
        if(!isCrouching){
            this.xCoordinate += 2;
        }
    }

    public int getxCoordinate(){
        return this.xCoordinate;
    }

}
