package ms.kamin.viewing.widget.actor;

import android.graphics.Canvas;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ms.kamin.viewing.widget.common.LevelSorter;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class Ground implements KaminGroundDrawLevel{
	public List<Actor> actorBackgroundLev;
	public List<Actor> actorMapLev;
	public List<Actor> actorPlayerLev;
	public List<Actor> actorForegroundLev;

	/**
	 * 添加背景层
	 * @param actorBackgroundLev
	 */
	public void addActorBackgroundLev(List<Actor> actorBackgroundLev) {
		if (actorBackgroundLev == null){
			actorBackgroundLev = new ArrayList<>();
		}
		this.actorBackgroundLev = actorBackgroundLev;
	}


	/**
	 * 添加前景层
	 * @param actorForegroundLev
	 */
	public void addActorForegroundLev(List<Actor> actorForegroundLev) {
		if (actorForegroundLev == null){
			actorForegroundLev = new ArrayList<>();
		}
		this.actorForegroundLev = actorForegroundLev;
	}

	/**
	 * 添加map层
	 * @param actorMapLev
	 */
	public void addActorMapLev(List<Actor> actorMapLev) {
		if (actorMapLev == null){
			actorMapLev = new ArrayList<>();
		}
		this.actorMapLev = actorMapLev;
	}

	/**
	 * 添加玩家层
	 * @param actorPlayerLev
	 */
	public void addActorPlayerLev(List<Actor> actorPlayerLev) {
		if (actorPlayerLev == null){
			actorPlayerLev = new ArrayList<>();
		}
		this.actorPlayerLev = actorPlayerLev;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void groundBackgroundLevel(Canvas canvas) {
		canvas.save();
		if (actorBackgroundLev != null) {
			List<Actor> sort = LevelSorter.sort(actorBackgroundLev);
			for (Actor actor : sort){
				actor.draw(canvas);
			}
		}
		canvas.restore();
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void mapLevel(Canvas canvas) {
		canvas.save();
		if (actorMapLev != null) {
			List<Actor> sort = LevelSorter.sort(actorMapLev);
			for (Actor actor : sort){
				actor.draw(canvas);
			}
		}
		canvas.restore();
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void playerLevel(Canvas canvas) {
		canvas.save();
		if (actorMapLev != null) {
			List<Actor> sort = LevelSorter.sort(actorMapLev);
			for (Actor actor : sort){
				actor.draw(canvas);
			}
		}
		canvas.restore();
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	@Override
	public void groundForegroundLevel(Canvas canvas) {
		canvas.save();
		if (actorForegroundLev != null) {
			List<Actor> sort = LevelSorter.sort(actorForegroundLev);
			for (Actor actor : sort){
				actor.draw(canvas);
			}
		}
		canvas.restore();
	}
}
