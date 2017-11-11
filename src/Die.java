public class Die {

    private static final int MAX = 6;   //dice has 6 faces
    private int faceValue;

    public Die() {

        roll();
    }

    public void roll() {
        faceValue=(int) ( (Math.random()*MAX) +1 ); //calculate face value randomly
    }

    public int getFaceValue() {

        return faceValue;
    }
}
