package pie.nature;

import android.graphics.Bitmap;

public class Item {

	private Bitmap bmp;
	private String name;

	public Item(Bitmap bmp, String name) {
		this.bmp = bmp;
		this.name = name;
	}

	public Bitmap getBmp() {
		return bmp;
	}

	public String getName() {
		return name;
	}

}
