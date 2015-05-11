package main;

import java.io.FileNotFoundException;

import reader.GrammaireLISP;
import reader.ParseException;
import context.Contexts;
import exception.LispException;

public class Main {

	public static void main(String[] args) {
		
		Contexts.setMinimalContexts();
		GrammaireLISP parser = new GrammaireLISP(System.in);

		try {
			parser.importe("boot", false);
			parser.read("(TOPLEVEL)").eval();
		} catch (ParseException e){
			System.out.println("Error when parsed file : ");
			System.out.println(e.getMessage());
		} catch (LispException e) {
			System.out.println(e.getMessage());
		}catch (FileNotFoundException e){
			System.out.println("Failed to open file : ");
			System.out.println(e.getMessage());
		}
	}
}