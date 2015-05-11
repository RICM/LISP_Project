package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import lisp.function.fsubr.Scope;
import reader.GrammaireLISP;
import reader.ParseException;
import exception.LispException;

public class Toplevel extends AbstrSubr {

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 0;
	
	private int lvmNumb = 0;

	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Car function
	 */
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	
	/**
	 * Function used to evaluate a Car
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("TOPLEVEL");
	}
	
	/**
	 * Function used to apply an _Sexpr to the Toplevel function
	 * @return _Sexpr The _Sexpr resulting from application
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		
		lvmNumb++;
		try {
			GrammaireLISP parser = new GrammaireLISP(System.in);
			
			_Sexpr s;
			int i=0;
			do{
				System.out.print("LVM"+lvmNumb+" : ["+i+"]\t");
				s = parser.read();
				
				//System.out.println(s);
				try{
					if (s instanceof Scons && ((Scons)s).getCar() instanceof Symbol 
							&& ((Symbol)((Scons)s).getCar()).name.equals("SCOPE")){
						((Scope)((Symbol)((Scons)s).getCar()).eval()).print();
					}else{
						System.out.println(s.eval());
					}
				}catch (LispException e){
					System.out.println("--> "+e.getMessage());
				}
				
				i++;
			}while(!(s instanceof Scons 
					&& ((Scons)s).getCar() instanceof Symbol 
					&& ((Symbol)((Scons)s).getCar()).name.equals("QUIT")));
			lvmNumb--;
			
		} catch (LispException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e){
			System.out.println("Error when parsed file : ");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Unknow Error Occured");
			System.out.println(e.getMessage());
		}
		return new Symbol("T");
	}

	/**
	 * @return String The function name
	 */
	public String toString(){
		return "TOPLEVEL";
	}
}
