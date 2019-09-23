package ConnectToDB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Horoscope {
	
	private ConnectionToSQL conn= new ConnectionToSQL();
    	int dateFlag = 0;
    
	public  void firstPrediction() {
	conn.getDataFromDB();
	System.out.println();
	
	for(int i = 0; i < conn.getNames().size(); i++) {
		dateFlag = 1;
		int n = ((conn.getNames().get(i).length())-1) + ((conn.getNrID().get(i).length()));
		if (n%2 == 1) System.out.println("Student: " + conn.getNames().get(i) + " with nrID: " + conn.getNrID().get(i) + " will have the grade +1");
				else System.out.println("Student: " + conn.getNames().get(i) + " with nrID: " + conn.getNrID().get(i) + " will have the grade -1");
		}
	}
	
	public int firstPrediction(int index) {
		int n = ((conn.getNames().get(index).length())-1) + ((conn.getNrID().get(index).length()));
		if (n%2 == 0) return 1;
			else return 0;
		}
	
	public void secondPrediction() {
		int nr = 0;
		for(int i = 0; i <conn.getGrades().size(); i++) {
			if (conn.getGrades().get(i) > 8) {
				if(firstPrediction(i) == 1)
					nr++;
				}
			}
		if(conn.getNames().size() != 0)
			System.out.print("No. students with grade bigger than 8 that will have the grade decreased : " + nr);
		}
	
	public void thirdPrediction() {
		System.out.println();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		if(dateFlag != 0)
			System.out.println("Current date : " + dtf.format(localDate));
		
		for(int i = 0; i < conn.getNames().size(); i++) {
			char c = conn.getNames().get(i).charAt(0);  // c='a'
			int ascii = (int)c;
			int n = localDate.getDayOfMonth() + ascii;
			if(n%2 == 1) System.out.println("Student : " + conn.getNames().get(i) + " will have a good day");
				else System.out.println("Student : " + conn.getNames().get(i) + " will not have a good day");
			}
		}
	
}
