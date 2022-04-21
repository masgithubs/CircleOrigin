package ms.kamin.viewing.widget.actor;

import android.graphics.Canvas;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public interface KaminGroundDrawLevel {
	void groundBackgroundLevel(Canvas canvass);
	void mapLevel(Canvas canvas);
	void playerLevel(Canvas canvas);
	void groundForegroundLevel(Canvas canvas);
}
