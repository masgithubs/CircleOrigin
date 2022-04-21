package ms.kamin.viewing.widget.ui;

import android.graphics.Canvas;

import ms.kamin.viewing.widget.ui.event.ClickEvent;

/**
 * author: Cao Shixu
 * created time: $(DATE}
		 * usage:
		 */
public class Lable extends UIComponent implements ClickEvent {
	Canvas canvas;
	ClickEvent clickEvent;
	@Override
	public void draw(Canvas canvas) {
		if (canvas == null){
			this.canvas = canvas;
		}

	}

	@Override
	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void onClick(UIComponent component) {
		if (clickEvent != null)
			clickEvent.onClick(component);
	}
}
