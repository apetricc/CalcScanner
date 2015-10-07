/**
 * Created by petriccione on 10/7/15.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
public class runner implements Tokens{


public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcParser myParser = new CalcParser(args[0]);
        myParser.parse();
        }

}
