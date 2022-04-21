package ms.kamin.viewing;

import android.graphics.Canvas;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:基础的绘制图层 实现：class : KaminViewingDrawLevel
 */
public interface KaminBaseViewingLevel {
	void baseLevel(Canvas canvas);
	void backgroundLevel(Canvas canvas);
	void groundLevel(Canvas canvas);
	void overlayLevel(Canvas canvas);
	void uiLevel(Canvas canvas);
	void foregroundLevel(Canvas canvas);
}
