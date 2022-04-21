package ms.kamin.viewing.widget.common;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Comparator;
import java.util.List;

import ms.kamin.viewing.widget.actor.Actor;
import ms.kamin.viewing.widget.actor.Overlay;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class LevelSorter {
	@RequiresApi(api = Build.VERSION_CODES.N)
	public static List<Actor> sort(List<Actor> actors){
		actors.sort(new Comparator<Actor>() {
			@Override
			public int compare(Actor o1, Actor o2) {
				return o1.getId() - o2.getId();
			}
		});
		return actors;
	}
}
