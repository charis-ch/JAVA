import org.json.JSONObject;

public interface SW_Standards {

String BASE="https://swapi.co/api/";
String JSON="?format=json";

public  JSONObject requestResources(Data category,int number );

}
