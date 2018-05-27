import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONException;
import org.json.JSONObject;

public class SWThread extends SW_Standards implements Runnable {
	static String f[] = new String[90];
	int thread;
	Data data;

	private final AtomicBoolean running = new AtomicBoolean(true);

	public SWThread(int i, Data people) {

		thread = i;
		data = people;
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
		Thread a = new Thread(new SWThread(0, Data.PEOPLE));
		a.start();
		Thread b = new Thread(new SWThread(1, Data.PEOPLE));
		b.start();
		Thread c = new Thread(new SWThread(2, Data.PEOPLE));
		c.start();
		Thread d = new Thread(new SWThread(3, Data.PEOPLE));
		d.start();
		Thread e = new Thread(new SWThread(4, Data.PEOPLE));
		e.start();

	}

	@Override
	public void run() {// (int thread, Data data) {
		
			while (running.get()) {
				int i = 20 * thread;
				String uri;
				JSONObject obj = null;
				int y = i + 1;
				int limit = 20 * i + 21;
				if (limit > 80)
					limit = 87;
				// TODO Auto-generated method stub
				for (i = i + 1; i < limit; i++) {

					uri = data.name().toLowerCase() + "/" + String.valueOf(i) + "/";

					uri = BASE + uri + JSON;

					String str;
					str = "";

					try {
						str = accessURL(uri);
						obj = new JSONObject(str);
						f[i] = obj.get("name").toString();
					}
					// System.out.println(obj.get("name"));

					catch (JSONException e) {

						e.printStackTrace();
					} catch (NullPointerException nullPointer) {
						/// return null;
					}

				}
				for (int x = y; x < limit; x++) {
					System.out.println(x + "  " + f[x]);
				}

				running.set(false);
			}

	}
}
