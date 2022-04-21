package ms.kamin.viewing.widget.actor;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class TextOverlay extends Overlay{
	Paint paint;
	@Override
	public void draw(Canvas canvas) {
		if (paint == null){
			paint = new Paint();
			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.FILL_AND_STROKE);
			paint.setTextSize(20);
		}
		canvas.drawText("haahhaha",190,200,paint);
	}
}
