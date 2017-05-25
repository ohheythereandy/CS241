/**
 * Created by Andy on 5/24/17.
 */
public class CityNode {

    public int label;
    public int elevation;
    public long population;
    public String cityCode, cityName;

    public CityNode(){
        label = 0;
        population = 0;
        elevation = 0;
        cityCode = null;
        cityName = null;
    }

    public CityNode(int number, String cityCode, String cityName, long population, int elevation){
        label = number;
        population = this.population;
        elevation = this.elevation;
        cityCode = this.cityCode;
        cityName = this.cityName;
    }

}
