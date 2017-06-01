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

    public URLReader(GraphInterface graph) throws Exception{
        cityURL = "https://www.cpp.edu/~ftang/courses/CS241/hw/city.dat";
        roadURL = "https://www.cpp.edu/~ftang/courses/CS241/hw/road.dat";
        fileCityReader(cityURL, graph);
        fileRoadReader(roadURL, graph);
    }

    public void fileCityReader(String url, GraphInterface graph ) throws Exception {

        URL city = new URL(url);


        BufferedReader in = new BufferedReader(
                new InputStreamReader(city.openStream()));


        String inputLine;
        Scanner scan ;

        for(int i = 0; i < 20 ; i++){

            inputLine = in.readLine();
            scan = new Scanner(inputLine);
            int cityNumber = scan.nextInt();
            String cityCode = scan.next();
            String cityName = scan.next();
            long population;
            if(scan.hasNextInt()){
                population = scan.nextInt();
            }
            else{
                cityName = cityName.concat(" " + scan.next());
                population = scan.nextInt();
            }
            int elevation = scan.nextInt();
            //check to see if reads correctly
//              System.out.println(cityNumber +
//                    " "+ cityCode + " " + cityName + " " + population + " " + elevation );
            CityNode node = new CityNode(cityNumber, cityCode, cityName, population, elevation);
            graph.addVertex(node);

        }


        //close stream
        in.close();

    }

    public void fileRoadReader(String url, GraphInterface graph) throws Exception{
        URL road = new URL(url);
        BufferedReader in = new BufferedReader( new InputStreamReader(road.openStream()));

        String inputLine;
        Scanner scan;
        int fromCity = 0;
        int toCity = 0;
        int distance = 0;


        while((inputLine = in.readLine()) != null){
            scan = new Scanner(inputLine);
            fromCity = scan.nextInt();
            toCity = scan.nextInt();
            distance = scan.nextInt();
            //check to see if returns correct
            // System.out.println(fromCity + " " + toCity + " " + distance);
            graph.addEdge(fromCity, toCity, distance);
        }
    }

}