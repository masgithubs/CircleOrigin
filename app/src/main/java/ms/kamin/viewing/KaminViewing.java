package ms.kamin.viewing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class KaminViewing extends SurfaceView implements SurfaceHolder.Callback, GestureDetector.OnGestureListener {
	KaminThread mainThread;
	KaminViewingDrawLevel kaminBaseViewingLevel;
	MainTask mainTask;
	Canvas canvas;
	SurfaceHolder holder;
	GestureDetector gestureDetector;



	public KaminViewing(Context context) {
		super(context);
		kaminBaseViewingLevel = new KaminViewingDrawLevel();
		holder = getHolder();
		holder.addCallback(this);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setKeepScreenOn(true);
		gestureDetector = new GestureDetector(context,this);
		mainTask = new MainTask();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

	public KaminSettings getKaminSettings() {
		return kaminBaseViewingLevel.settings;
	}

	public void setKaminBaseViewingLevel(KaminViewingDrawLevel kaminBaseViewingLevel) {
		this.kaminBaseViewingLevel = kaminBaseViewingLevel;
	}

	public MainTask getMainTask() {
		return mainTask;
	}

	@Override
	public void surfaceCreated(@NonNull SurfaceHolder holder) {
		if (mainThread == null){
			mainThread = new KaminThread();
		}
		if (mainThread.getKaminTasks() == null){
			mainThread.addTask(mainTask);
		}
		if (mainThread.getKaminTasks().size() == 0){
			mainThread.addTask(mainTask);
		}
		if (!mainThread.isRuning){
			mainThread.start();
			mainThread.isRuning = true;
		}
		mainTask.isRun = true;
	}

	@Override
	public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

	}

	@Override
	public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
		mainTask.isRun = false;
	}
	public void setRun(boolean isRun){
		mainTask.isRun = isRun;
	}


	class MainTask implements KaminTask{
		public boolean isRun;
		Paint paint;
		@RequiresApi(api = Build.VERSION_CODES.N)
		@Override
		public void exec() {
			while (isRun){
				canvas = holder.lockCanvas();
				//绘制基础视图
				if (kaminBaseViewingLevel != null && canvas != null) {
					kaminBaseViewingLevel.baseLevel(canvas);
					kaminBaseViewingLevel.backgroundLevel(canvas);
					kaminBaseViewingLevel.overlayLevel(canvas);
					kaminBaseViewingLevel.uiLevel(canvas);
					kaminBaseViewingLevel.foregroundLevel(canvas);
				}
				if (paint == null){
					paint = new Paint();
					paint.setColor(Color.RED);
					paint.setStyle(Paint.Style.FILL_AND_STROKE);
					paint.setTextSize(20);
				}
				if (canvas!=null)
					holder.unlockCanvasAndPost(canvas);
			}
		}
		public void setRun(boolean run) {
			isRun = run;
		}
	}


	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {

		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		return false;
	}
}
