package ms.kamin.viewing.widget.actor;

import android.graphics.Canvas;

import ms.kamin.viewing.common.Position;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public abstract class Actor {
	public Position position;
	public int id;
	public String name;

	public abstract void draw(Canvas canvas);

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}
}
