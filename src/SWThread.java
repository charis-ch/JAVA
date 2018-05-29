import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class SWThread extends SW_Standards implements Runnable {
	private static String elements[] = new String[90];
	private int thread;
	private Data data;
	private int limit;
	private final AtomicBoolean running = new AtomicBoolean(true);
	private Thread task;
	static int counter = 1;

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
		/// thread2=this
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

			System.out.println("i= " + i);
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
			// System.out.println("Thread = " + thread);
			// System.out.println("limit=" + limit);
			// System.out.println(counter++ +
			// "=================================");
			for (int x = y; x <= limit; x++) {
				System.out.println(x + "  " + elements[x]);
			}

			running.set(false);
		}

	}
}
