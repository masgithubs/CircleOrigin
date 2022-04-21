package ms.kamin.becircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ms.kamin.viewing.KaminSettings;
import ms.kamin.viewing.KaminViewing;
import ms.kamin.viewing.widget.actor.AnActor;
import ms.kamin.viewing.widget.actor.TextOverlay;

public class MainActivity extends AppCompatActivity {
	KaminViewing kaminViewing;
	KaminSettings settings;
	AnActor player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		kaminViewing = new KaminViewing(this);
		settings = kaminViewing.getKaminSettings();
		setContentView(kaminViewing);
		settings.addOverlay(new TextOverlay());
	}

	@Override
	protected void onStop() {
		super.onStop();
		kaminViewing.setRun(false);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		kaminViewing.setRun(false);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		kaminViewing.setRun(true);
	}

	@Override
	protected void onResume() {
		super.onResume();
		kaminViewing.setRun(true);
	}
}