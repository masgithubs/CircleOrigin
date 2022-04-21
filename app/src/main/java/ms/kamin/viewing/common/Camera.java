package ms.kamin.viewing.common;

import android.graphics.Canvas;

import ms.kamin.viewing.widget.actor.Actor;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class Camera extends Actor {

	private float distance;
	private float xDistance;
	private float yDistance;
	private float zDistance;

	public void setzDistance(float zDistance) {
		this.zDistance = zDistance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public void setxDistance(float xDistance) {
		this.xDistance = xDistance;
	}

	public void setyDistance(float yDistance) {
		this.yDistance = yDistance;
	}

	@Override
	public void draw(Canvas canvas) {

	}
}
