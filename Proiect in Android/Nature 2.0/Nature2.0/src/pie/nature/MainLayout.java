package pie.nature;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainLayout extends ScrollView {

	private Activity activity;
	private TileImage[][] tiles;
	private RelativeLayout layout;

	private int numberRows;
	private int numberColumns;
	private int numberAll;
	private float valueWidth;
	private float valueHeight;
	private float valueMargin;

	private List<Item> items;

	private static int colorBase = TileImage.COLOR_BORDER1;

	public MainLayout(Activity activity) {
		super(activity);
		this.activity = activity;
	}

	public void create(List<Item> items) {
		this.items = items;
		numberAll = items.size();
		initVars();
		initLayouts();
		initViews();
	}

	private void initVars() {
		numberColumns = 9;
		numberRows = numberAll / numberColumns;
		if (numberAll % numberColumns != 0)
			numberRows++;

		WindowManager wm = (WindowManager) activity
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		valueWidth = display.getWidth() / numberColumns;
		valueHeight = valueWidth;
		valueMargin = valueWidth / 100 * 5; // 5% of the width

		TileImage.setupTile(valueMargin, valueWidth, valueHeight, valueMargin);
	}

	private void initLayouts() {

		layout = new RelativeLayout(activity);
		layout.setBackgroundColor(colorBase);
		layout.setGravity(Gravity.CENTER_HORIZONTAL);
		RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);

		this.setLayoutParams(new ScrollView.LayoutParams(
				ScrollView.LayoutParams.MATCH_PARENT,
				ScrollView.LayoutParams.MATCH_PARENT));
		this.addView(layout, rllp);
		this.setBackgroundColor(colorBase);

	}

	private void initViews() {

		tiles = new TileImage[numberRows][numberColumns];

		for (int i = 0; i < numberRows; i++)
			for (int j = 0; j < numberColumns; j++) {
				if (i * numberColumns + j >= numberAll)
					break;

				tiles[i][j] = new TileImage(activity);
				tiles[i][j].setId(i * numberColumns + j);
				RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(
						(int) valueWidth, (int) valueHeight);
				rllp.setMargins((int) (j * valueWidth),
						(int) (i * valueHeight), 0, 0);
				layout.addView(tiles[i][j], rllp);

				tiles[i][j].setItemToDisplay(items.get(i * numberColumns + j));
			}
	}

}
