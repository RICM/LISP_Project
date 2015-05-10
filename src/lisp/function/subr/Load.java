package lisp.function.subr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import reader.GrammaireLISP;
import reader.ParseException;
import exception.LispException;
import lisp.AbstrSubr;
import lisp.Nil;
import lisp.Symbol;
import lisp._Sexpr;

public class Load extends AbstrSubr {

	private int numberOfParam = 1;
	
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		if (param instanceof Symbol){
			try {
				GrammaireLISP parser = new GrammaireLISP(System.in);
				
				
				Scanner scanner=new Scanner(new File(param.toString()));
				while (scanner.hasNextLine()) {
					_Sexpr s = parser.read(scanner.nextLine());
					System.out.println(s.eval());
				}
				scanner.close();
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				System.out.println("Failed to open file : ");
				System.out.println(e.getMessage());
			}
			System.out.println("End of file reading");
			return null;
		}
		else{
			throw new LispException ("Error : trying to apply LOAD to something which is not a Symbol");
		}
		
	}

	@Override
	public _Sexpr eval() throws LispException {
		
		// TODO Auto-generated method stub
		return null;
	}

}
