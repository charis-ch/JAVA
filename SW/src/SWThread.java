import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class SWThread extends Resources  implements Runnable {
	private static String elements[];// = new String[90];
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
		// TODO Auto-generated constructor stub
	}

	public SWThread(int i2, int range2, Data data) {

		thread = i2;
		this.data = data;
		range = range2;
		limit = range * thread + range;
		i = range * thread;

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// SWThread a = new SWThread(0, Data.PEOPLE);
		// SWThread b = new SWThread(1, Data.PEOPLE);
		// SWThread c = new SWThread(2, Data.PEOPLE);
		// SWThread d = new SWThread(3, Data.PEOPLE);
		// SWThread e = new SWThread(4, Data.PEOPLE);
		/**
		 * a.run(0, Data.PEOPLE);System.out.println("Next!"); b.run(1,
		 * Data.PEOPLE);System.out.println("Next!"); c.run(2,
		 * Data.PEOPLE);System.out.println("Next!"); d.run(3,
		 * Data.PEOPLE);System.out.println("Next!"); e.run(4, Data.PEOPLE);
		 **/
		// new Thread(new SWThread(0, Data.PEOPLE)).start();//).start();
		ExecutorService exec = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++)
			exec.execute(new SWThread(i, Data.PEOPLE));
		exec.shutdown();

	}

	@Override
	public void run() {// (int thread, Data data) {

		while (running.get()) {
			int i = range * thread;
			String uri;
			JSONObject obj = null;

			if (thread == 4)
				limit = finalData;
			// TODO Auto-generated method stub
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
				// System.out.println(obj.get("name"));

				catch (JSONException e) {

					e.printStackTrace();
				} catch (NullPointerException nullPointer) {
					/// return null;
				}

			}

			running.set(false);
		}

	}
}