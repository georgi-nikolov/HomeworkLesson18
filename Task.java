

public class Task {

		private String name;
		private int workingHours;
		
		Task(String name, int workingHours){
				this.name = name;
				this.workingHours = workingHours;
		}

		String getName() {
			return name;
		}

		void setName(String name) {
			if(name == null || name.isEmpty())
				throw new IllegalArgumentException("Invalid input for name field");
			else
				this.name = name;
		}

		int getWorkingHours() {
			return workingHours;
		}

		void setWorkingHours(int workingHours) {
			if(workingHours>=0)
			this.workingHours = workingHours;
		}
		
}
