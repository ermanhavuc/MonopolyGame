import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Print {

    public static void out(String message, boolean line) throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);
        if (line){
            System.out.println(message);
            out.println(message);
        }else {
            System.out.print(message);
            out.print(message);
        }

    }
}
