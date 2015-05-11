package lisp.function.subr;

import java.io.FileNotFoundException;

import lisp.AbstrSubr;
import lisp.Symbol;
import lisp._Sexpr;
import reader.GrammaireLISP;
import reader.ParseException;
import exception.LispException;

public class Load extends AbstrSubr {

	private int numberOfParam = 1;
	
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		if (param instanceof Symbol){
			GrammaireLISP parser = new GrammaireLISP(System.in);
			_Sexpr s = null;
			
			try {
				s = parser.importe(param.toString().toLowerCase(), false);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				System.out.println("Failed to open file : ");
				System.out.println(e.getMessage());
			}
			System.out.println("End of file reading");
			return s;
		}
		else{
			throw new LispException ("Error : trying to apply LOAD to something which is not a Symbol");
		}
		
	}

	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("LOAD");
	}
	
	/**
	 * @return String The function name
	 */
	public String toString(){
		return "LOAD";
	}
}
