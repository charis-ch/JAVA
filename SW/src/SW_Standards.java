import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/***
 * 
 * The following class has been declared abstract since there is no need for
 * creating any objects. It contains the basic common method for accessing the
 * Swapi webpage (either with json , either with )
 * 
 * 
 * 
 * 
 * 
 * 
 */
public abstract class SW_Standards {

	public static final String BASE = "https://swapi.co/api/";
	public static final String JSON = "?format=json";
	public static final String API = "?format=api";
	public static final String WOOKIE = "?format=wookiee";

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
	public static String accessURL(String uri) {
		URL url;
		String string, str;
		str = "";

		try {
			url = new URL(uri);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0");
	

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while ((string = br.readLine()) != null) {

				str += string;

			}
			

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
	 * The unit test for the abstract class SW_Standards
	 * 
	 */
	public static void main(String args[]) {

		String uri = "https://www.google.com.cy";
		System.out.println(accessURL(uri));

	}

}
