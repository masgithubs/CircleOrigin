package ms.kamin.viewing;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Cao Shixu
 * created time: $(DATE}
 * usage:
 */
public class KaminThread extends Thread{
	private List<KaminTask> kaminTasks;
	public boolean isRuning;

	@Override
	public void run() {
		if (kaminTasks != null){
			for (KaminTask kaminTask : kaminTasks){
				kaminTask.exec();
			}
		}
	}

	public void setRuning(boolean runing) {
		isRuning = runing;
	}

	public void addTask(KaminTask kaminTask){
		if (kaminTasks == null){
			kaminTasks = new ArrayList<>();
		}
		kaminTasks.add(kaminTask);
	}

	public void setKaminTasks(List<KaminTask> kaminTasks) {
		this.kaminTasks = kaminTasks;
	}

	public List<KaminTask> getKaminTasks() {
		return kaminTasks;
	}
}
