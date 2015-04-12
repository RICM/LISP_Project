package main;

import reader.*;
import exception.ParseException;;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				Reader.main(args);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		
		
	}

}
