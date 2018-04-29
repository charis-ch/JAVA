import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Resources {

	public static void main(String[] args) throws JSONException {
		// get the 87 characters and 61 planets
		URL url;
		String uri=//"http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";//
		"https://swapi.co/api/people/?format=json";//"https://www.google.com";
	String string,str;str="";	StringBuilder strbuf=new StringBuilder();
		try {
			url = new URL(uri);
			HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0"); 
			connection.setRequestProperty("Content-Type", "application/xml");

			int code;

	{
		BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		
		while((string=br.readLine()) != null){
			System.out.println(string);
		str+=string;
		strbuf.append(string);
		}
		System.out.println("==============================================================================================================");
	//	String[] names=str.split("name");
		
		System.out.println(str);
			System.out.println("==============================================================================================================");
			JSONObject obj=new JSONObject(str);
			
			JSONArray actors=(JSONArray) obj.get("results");
		//	System.out.println((str=(String)obj.get("results")));
			System.out.println(actors);

			//	System.out.println(actors.get("name"));
		}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
