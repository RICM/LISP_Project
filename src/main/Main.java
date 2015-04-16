package main;

import exception.LispException;
import reader.*;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				GrammaireLISP.read();
			} catch (LispException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		
	}

}
