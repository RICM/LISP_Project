package main;

import reader.*;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				GrammaireLISP.main(args);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		
		
	}

}
