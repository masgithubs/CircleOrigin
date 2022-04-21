package ms.kamin.viewing;

import android.graphics.Canvas;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ms.kamin.viewing.widget.actor.Actor;
import ms.kamin.viewing.widget.actor.Ground;
import ms.kamin.viewing.widget.actor.Overlay;
import ms.kamin.viewing.widget.common.LevelSorter;
import ms.kamin.viewing.widget.ui.UIComponent;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class KaminViewingDrawLevel implements KaminBaseViewingLevel {
	List<Overlay> overlays;
	List<UIComponent> uiComponents;

	KaminSettings settings;
	//基础内容视图
	private List<Ground> grounds;

	public KaminViewingDrawLevel(){
		grounds = new ArrayList<>();
		settings = new KaminSettings();
	}

	public void addGround(Ground ground){
		grounds.add(ground);
	}

	@Override
	public void baseLevel(Canvas canvas) {

	}

	@Override
	public void backgroundLevel(Canvas canvas) {

	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void groundLevel(Canvas canvas) {
		canvas.save();
		for (Ground ground : grounds){
			ground.groundBackgroundLevel(canvas);
			ground.mapLevel(canvas);
			ground.playerLevel(canvas);
			ground.groundForegroundLevel(canvas);
		}
		canvas.restore();
	}


	/**
	 * 绘制overlay
	 * @param canvas
	 */
	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void overlayLevel(Canvas canvas) {
		canvas.save();
		List<Overlay> overlays = settings.getOverlays();
		List<Actor> actor = new ArrayList<>();
		for (Overlay overlay : overlays){
			actor.add(overlay);
		}
		overlays = null;
		LevelSorter.sort(actor);
		for (Actor actor1 : actor){
			actor1.draw(canvas);
		}
		canvas.restore();
	}

	@Override
	public void uiLevel(Canvas canvas) {

	}

	@Override
	public void foregroundLevel(Canvas canvas) {

	}
}
