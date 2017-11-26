
public class Die {

    private static final int MAX = 6; // dice facevalue number
    private int faceValue;

    public Die() {

        roll();
    }

    public void roll() {

        faceValue=(int) ( (Math.random()*MAX) +1 );
    }

    public int getFaceValue() { // get facevalue of dice object

        return faceValue;
    }
}