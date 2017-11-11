@SuppressWarnings("WeakerAccess")
public class Square {   //square object

    private String name;
    private int index;

    public Square(String name, int index) { //square constructor

        this.name=name;
        this.index=index;
    }

    public String getName() {

        return name;
    }

    public int getIndex() {

        return index;
    }
}
