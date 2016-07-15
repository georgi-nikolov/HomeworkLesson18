

public class Office {

	public static void main(String[] args) {
		
		
		AllWork AllWork = new AllWork();
		
		Task one = new Task("Coding", 8);
		Task two = new Task("Graphical Design", 4);
		Task three = new Task("Making coffe for everyone", 2);
		Task four = new Task("Copying documents", 6);
		Task five = new Task("Fixing bugs", 15);
		Task six = new Task("Learning a new programming language", 20);
		Task seven = new Task("Negotiating with clients", 7);
		Task eight = new Task("Cleaning the office", 3);
		Task nine = new Task("Fixing hardware", 5);
		Task ten = new Task("Upgrading the hardware", 6);
		
		AllWork.addTask(one);
		AllWork.addTask(two);
		AllWork.addTask(three);
		AllWork.addTask(four);
		AllWork.addTask(five);
		AllWork.addTask(six);
		AllWork.addTask(seven);
		AllWork.addTask(eight);
		AllWork.addTask(nine);
		AllWork.addTask(ten);
		
		
		Employee ivan = new Employee("Ivan");
		Employee pesho = new Employee("Petyr");
		Employee gosho = new Employee("Gosho");
		Employee maria = new Employee("Maria");
		ivan.setAllWork(AllWork);
		
		
		
		
	
		while(true){
			if(AllWork.isAllWorkDone()){
				System.out.println("The employees have completed all tasks");
				break;
			}
			Employee.setDay();
			ivan.startWorkingDay();
			pesho.startWorkingDay();
			gosho.startWorkingDay();
			maria.startWorkingDay();
			ivan.work();
			pesho.work();
			gosho.work();
			maria.work();
			
		}
			
		
	}
}
