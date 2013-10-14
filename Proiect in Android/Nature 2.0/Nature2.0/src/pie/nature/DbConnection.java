package pie.nature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;

// TODO: folosita doar pentru testarea layoutului,
// a se implementa baza de date actuala
public class DbConnection {

	public static List<Item> getItems() {
		List<Item> items = new ArrayList<Item>(5);

		for (int i = 0; i < 500; i++) {
			Bitmap bmp = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
			Canvas c = new Canvas(bmp);
			c.drawARGB(255, new Random().nextInt(256),
					new Random().nextInt(256), new Random().nextInt(256));
			Item item = new Item(bmp, i + "");
			items.add(item);
		}

		return items;
	}

}
