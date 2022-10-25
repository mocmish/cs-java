package salarycalc;

public class Employee {
	public String empName;
	public int fixedScore;
	public int daysWorked;
	
	public Employee(String empName, double fixedScore, int daysWorked) {
		
	}
	
	//loads employee stats from stat database, searches with name
		public void loadfromDB(String name, Database db) {
			
		}
		
		public void updateIntoDB(Database db) {
			
		}
	
		//setter methods
		public void setScore(int newScore) {
			this.fixedScore = newScore;
		}
		
		public void setDays(int newDays) {
			this.daysWorked = newDays;
		}
}
