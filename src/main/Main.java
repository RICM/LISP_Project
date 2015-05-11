package main;

import java.io.FileNotFoundException;

import reader.GrammaireLISP;
import reader.ParseException;
import context.Contexts;
import exception.LispException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\n"+
		 "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
		+"\t~	 __    ____  ___  ____    __  __    __    ___  _   _  ____  _  _  ____		~"+"\n"
		+"\t~	(  )  (_  _)/ __)(  _ \\  (  \\/  )  /__\\  / __)( )_( )(_  _)( \\( )( ___)		~"+"\n"
		+"\t~	 )(__  _)(_ \\__ \\ )___/   )    (  /(__)\\( (__  ) _ (  _)(_  )  (  )__) 		~"+"\n"
		+"\t~	(____)(____)(___/(__)    (_/\\/\\_)(__)(__)\\___)(_) (_)(____)(_)\\_)(____)		~\n"
		+"\t~											~\n"
		+"\t~	BRANGER Mathias - NOGUERON Matthieu - TITH Reatha - VIAL-GRELIER Aymeric	~\n"
		+"\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
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