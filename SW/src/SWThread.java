import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class SWThread extends SW_Standards implements Runnable {
	private static String elements[] ;//= new String[90];
	private static Thread mainThread;
	private int thread;
	private Data data;
	private int limit;
	private final AtomicBoolean running = new AtomicBoolean(true);

	static int counter = 1;

	
	public static void setThread(Thread main) {
		
		
		mainThread=main;
	}
	public static String[] downloadCharacters(int total) {
		elements=new String[total];
		

		ExecutorService exec = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++)
			exec.execute(new SWThread(i, Data.PEOPLE));
		exec.shutdown();

		return elements;

	}

	public SWThread(int i, Data feature) {

		thread = i;
		data = feature;
		limit = 20 * i + 20;

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService exec = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++)
			exec.execute(new SWThread(i, Data.PEOPLE));
		exec.shutdown();

	}

	@Override
	public void run() {

		while (running.get()) {
			int i = 20 * thread;
			String uri;
			JSONObject obj = null;
			int y = i + 1;

			 if (thread == 4)
			limit = 87;

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
				} 

			}


			running.set(false);
		}

	}
}
