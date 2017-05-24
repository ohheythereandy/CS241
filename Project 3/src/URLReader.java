/**
 * Created by Andy on 5/23/17.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class URLReader {

    String cityURL;
    String roadURL;
    Scanner scan;

    public URLReader(GraphInterface<CityNode> graph) throws Exception{
        cityURL = "https://www.cpp.edu/~ftang/courses/CS241/hw/city.dat";
        roadURL = "https://www.cpp.edu/~ftang/courses/CS241/hw/road.dat";
        fileReader(cityURL, graph);
    }

    public void fileReader(String url, GraphInterface<CityNode> graph ) throws Exception {

        URL city = new URL(url);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(city.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            scan = new Scanner(inputLine);

            graph.addVertex(vertex);
        }
        //close stream
        in.close();

    }

}