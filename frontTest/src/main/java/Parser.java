import java.util.Arrays;
import java.util.List;

public class Parser {
    public static String[] parseRGBAStringToInt(String str)
    {


        str=str.substring(5);
        String[]rgbaS=str.split(", ");

        return rgbaS;
    }

}
