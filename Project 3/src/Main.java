/**
 * Created by HiThereAndy on 5/22/2017.
 */
import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{

        URL oracle = new URL(" https://www.cpp.edu/~ftang/courses/CS241/hw/city.dat");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream())
        );
        String inputLine;
        while((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
