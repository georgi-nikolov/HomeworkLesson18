

public class Employee {

	private String name;
	private Task currentTask;
	private int hoursLeft;
	private static AllWork AllWork;
	private static int day = 0;
	
	Employee(String name){
		this.setName(name);
	}

	void setName(String name) {
		String regex = "^[\\p{L} .'-]+$";
		if(name == null || name.isEmpty() || (!(name.matches(regex))))
			throw new IllegalArgumentException("Invalid input for name field");
		else
			this.name = name;
	}
	
	String getName(){
		return this.name;
	}

	void setCurrentTask(Task currentTask) {
		if(currentTask == null)
			throw new IllegalArgumentException("Invalid input for currentTaks field");
		else
			this.currentTask = currentTask;
	}
	
	Task getCurrentTask(){
		return this.currentTask;
	}

	void setHoursLeft(int hoursLeft) {
		if(this.hoursLeft>=0)
		this.hoursLeft = hoursLeft;
	}
	
	int getHoursLeft(){
		return this.hoursLeft;
	}
	
	void work() {
		if (this.getCurrentTask() == null) {
			this.setCurrentTask(AllWork.getNextTask());
			AllWork.setCurrentUnassignedTask();
			System.out.println(this.getName() + " starts working on " + this.getCurrentTask().getName());
		}
		while (this.getHoursLeft() > 0) {

			if (this.getCurrentTask().getWorkingHours() == 0) {
				if (AllWork.getCurrentUnassignedTask() != -1) {
					this.setCurrentTask(AllWork.getNextTask());
					AllWork.setCurrentUnassignedTask();
					System.out.println(this.getName() + " starts working on " + this.getCurrentTask().getName());
				} else {
					System.out.println("No free tasks left, waiting...");
					break;
				}
			}
			if (this.hoursLeft > this.currentTask.getWorkingHours()) {
				this.hoursLeft = this.hoursLeft - this.currentTask.getWorkingHours();
				this.currentTask.setWorkingHours(0);
				System.out.println(this.getName() + " has finished working on " + this.getCurrentTask().getName());

			} else {
				this.getCurrentTask().setWorkingHours(this.currentTask.getWorkingHours() - this.hoursLeft);
				this.hoursLeft = 0;
				System.out.println(this.getName() + " has finished his shift today but has to work on "
						+ this.getCurrentTask().getName() + " for another " + this.getCurrentTask().getWorkingHours()
						+ " hours");
			}
		}
	}
	
	
	void showReport(){
		System.out.println("This is a report for " + this.name);
		
		if(this.currentTask != null){
			System.out.println("The employee is working  on " + this.currentTask.getName());
			
			if(this.currentTask.getWorkingHours()>0)
				System.out.println("The current task needs to be worked on for another " + this.currentTask.getWorkingHours() + " hours");
			else
				System.out.println("The employee has finished working on his/her task");
		}
		else
			System.out.println("This employee has no task currently set");
		
		System.out.println("The employee has " + this.hoursLeft + " hours left to work today\n");
	}
	
	void startWorkingDay(){
		this.setHoursLeft(8);
	}
	
	static int getDay(){
		return Employee.day;
	}
	
	static void setDay(){
		Employee.day++;
		System.out.println("Start of day " + day);
	}
	
	AllWork getAllWork(){
		return this.AllWork;
	}
	
	void setAllWork(AllWork AllWork){
		if(AllWork != null)
		this.AllWork = AllWork;
	}
}
