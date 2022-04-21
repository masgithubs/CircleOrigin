package ms.kamin.viewing.common;

import java.util.Vector;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class Vector2 {
	private float vecx,vecy;
	public Vector2(int vecx,int vecy){
		this.vecx = vecx;
		this.vecy = vecy;
	}
	public Vector2(float vecx,float vecy){
		this.vecx = vecx;
		this.vecy = vecy;
	}

	public float getVecx() {
		return vecx;
	}

	public float getVecy() {
		return vecy;
	}

	public void setVecx(float vecx) {
		this.vecx = vecx;
	}

	public void setVecy(float vecy) {
		this.vecy = vecy;
	}
	public Vector2 calculateVectorValue(Vector2 vector2){
		float tempVecx = vector2.getVecx();
		float tempVecy = vector2.getVecy();
		float targetX = vecx + tempVecx;
		float targetY = vecy + tempVecy;
		return new Vector2(targetX,targetY);
	}

	public static float getDistance(Vector2 vector1,Vector2 vector2){
		float tempVecx1 = vector1.getVecx();
		float tempVecx2 = vector2.getVecx();
		float tempVecy1 = vector1.getVecy();
		float tempVecy2 = vector2.getVecy();
		float x = tempVecx1 = tempVecx2;
		float y = tempVecy1 = tempVecy2;
		float distance = (float) (Math.pow(x,2) + Math.pow(y,2));
		return distance;
	}
}
