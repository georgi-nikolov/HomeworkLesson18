
public class AllWork {

	private Task[] allTasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask; 
	
	AllWork(){
		this.allTasks = new Task[10];
		this.freePlacesForTasks = 10;
		this.currentUnassignedTask = 0;
	}
	
	void addTask(Task task){
		if(task != null && this.freePlacesForTasks > 0){
			this.freePlacesForTasks--;
			for (int i = 0; i < allTasks.length; i++) {
				if(allTasks[i] == null){
					allTasks[i] = task;
					break;
				}
			}
		}
		else
			System.err.println("Invalid input for task field or no room for this task");
	}
	
	Task getNextTask(){
		return allTasks[currentUnassignedTask];
	}
	
	boolean isAllWorkDone(){
		boolean isDone = true;
		for (int i = 0; i < allTasks.length; i++) {
			if(allTasks[i].getWorkingHours() > 0)
				isDone = false;
		}
		return isDone;
	}
	
	void setCurrentUnassignedTask(){
		if(this.currentUnassignedTask == allTasks.length-1)
			this.currentUnassignedTask = -1;
		else
			this.currentUnassignedTask++;
	}
	
	int getCurrentUnassignedTask(){
		return this.currentUnassignedTask;
	}
}
