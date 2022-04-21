package ms.kamin.viewing;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import ms.kamin.viewing.widget.actor.Overlay;
import ms.kamin.viewing.widget.debug.KaminBugger;

/**
 * author: Cao Shixu
 * created time: $(DATE}
		* usage:
		*/
public class KaminSettings{
	public KaminBugger kaminBugger;
	private List<Overlay> overlays;

	public void debug(boolean isDebug){
		if (kaminBugger == null){
			kaminBugger = new KaminBugger();
		}
		kaminBugger.isDebug = isDebug;
	}
	public void addOverlay(Overlay overlay){
		if (overlays == null){
			overlays = new ArrayList<>();
		}
		overlays.add(overlay);
	}

	public KaminBugger getKaminBugger() {
		return kaminBugger;
	}

	public List<Overlay> getOverlays() {
		return overlays;
	}

}
