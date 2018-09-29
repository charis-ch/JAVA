import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class SWThread extends Resources  implements Runnable {
	private static String elements[];
	static int range = 20;
	int thread;
	static Data data;
	int limit;
	int i;
	private static int finalData;
	private final AtomicBoolean running = new AtomicBoolean(true);

	public static String[] downloadCharacters(int start, int end) {
		elements = new String[end + 1];

		ExecutorService exec = Executors.newFixedThreadPool(5);
		int range = (end - start) / 5;
		finalData = end;
		for (int i = 0; i < 5; i++)
			exec.execute(new SWThread(i, range, Data.PEOPLE));
		exec.shutdown();

		return elements;

	}

	public static String[] downloadFeatureNames(int total) {
	
		
		finalData = total;
		elements = new String[total];
		range = total / 5;
		System.out.println("Range= " + range);
		ExecutorService exec = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++)
			exec.execute(new SWThread(i, data));
		exec.shutdown();

		return elements;

	}
public SWThread(Data feature) {
	
	data=feature;
	
}
	public SWThread(int x, Data people) {

		thread = x;
		data = people;
		limit = range * thread + range;
		i = range * thread;
		
	}

	public SWThread(int i2, int range2, Data feature) {

		thread = i2;
		data = feature;
		range = range2;
		limit = range * thread + range;
		i = range * thread;

		
	}

	public static void main(String[] args) {

	
		data=Data.PEOPLE;
		String characters[]=downloadFeatureNames(81);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}for(String str:characters)
			System.out.println(str);
//		ExecutorService exec = Executors.newFixedThreadPool(5);
//
//		for (int i = 0; i < 5; i++)
//			exec.execute(new SWThread(i, Data.PEOPLE));
//		exec.shutdown();

	}

	@Override
	public void run() {

		while (running.get()) {
			int i = range * thread;
			String uri;
			JSONObject obj = null;

			if (thread == 4)
				limit = finalData;
			
			for (i = i + 1; i <= limit; i++) {

				uri = data.name().toLowerCase() + "/" + String.valueOf(i) + "/";

				uri = BASE + uri + JSON;

				String str;
				str = "";

				try {
					str = accessURL(uri);
					obj = new JSONObject(str);
					elements[i] = obj.get("name").toString();
				}
				

				catch (JSONException e) {

					e.printStackTrace();
				} catch (NullPointerException nullPointer) {
					/// return null;
				
				}catch (ArrayIndexOutOfBoundsException bound) {
					
					bound.printStackTrace();
					
					System.out.println(elements.length+"=="+i+"   ???");
				}

			}

			running.set(false);
		}

	}
}