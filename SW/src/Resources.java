import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class Resources implements SW_Standards {

	/**
	 * 
	 * The following method takes as argument one uri and returns a string or
	 * null according the url content.
	 * 
	 * @param uri
	 *            the specified string which represents a url
	 * 
	 * @return a string with content or null
	 * 
	 * 
	 */
	public String accessURL(String uri) {
		URL url;
		String string, str;
		str = "";

		try {
			url = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setRequestProperty("Content-Type", "application/xml");

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((string = br.readLine()) != null) {

				str += string;

			}
			System.out.println(
					"==============================================================================================================");
			// String[] names=str.split("name");

			System.out.println(str);
			System.out.println(
					"==============================================================================================================");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (FileNotFoundException notFound) {

			return null;
		}

		catch (IOException e) {

			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 * The method below initialize a string in order to get the uri of a
	 * specific resource on the swapi. It can only get info in JSON format
	 * 
	 * 
	 * 
	 * 
	 */
	public JSONObject requestResources(Data category, int number) {
		String uri;
		JSONObject obj = null;
		if (number != 0)
			uri = category.name().toLowerCase() + "/" + String.valueOf(number) + "/";
		else
			uri = category.name().toLowerCase() + "/";

		uri = BASE + uri + JSON;

		String str;
		str = "";

		try {
			str = accessURL(uri);
			obj = new JSONObject(str);
		}
		// System.out.println(obj.get("name"));

		catch (JSONException e) {

			e.printStackTrace();
		} catch (NullPointerException nullPointer) {
			return null;
		}
		return obj;

	}

	/**
	 * The Swapi includes francais
	 * 
	 **/

	public String[] get(Data data) {

		String[] elements = null;

		JSONObject resource = requestResources(data, 0);
		try {
			int total_elements = resource.getInt("count") + 1;
			elements = new String[total_elements + 1];
			System.out.println("Total elements=" + total_elements);
			int i;
			for (i = 1; i <= total_elements; i++) {
				System.out.println(i);

				resource = requestResources(data, i);
				try {

					elements[i] = resource.get("name").toString();
				} catch (NullPointerException null_pointer) {
				}

			}
			for (String str : elements)
				System.out.println(str);
		} catch (JSONException e) {
			return null;
		}
		return elements;
		// return null;
	}

	public static void main(String[] args) {
		// get the 87 characters and 61 planets

		Resources resource = new Resources();
	
			resource.get(Data.PEOPLE);
		SW_Standards a=new Resources();
		
		//
		// Resources resource = new Resources();
		// JSONObject actors = resource.requestResources(Data.PEOPLE, 0);
		// int total_characters =
		// Integer.parseInt(actors.get("count").toString()) + 1;
		// System.out.println("Total actors on 7 films:" + total_characters);
		// Random generator = new Random();
		// int random_number = generator.nextInt(87) + 1;
		// JSONObject actor = resource.requestResources(Data.PEOPLE,
		// random_number);
		// System.out.println("The character with number " + random_number + "
		// of the swapi is " + actor.get("name"));

	}

}
