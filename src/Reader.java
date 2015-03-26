import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader {
	

	/** le support de lecture */
	protected static java.io.Reader in = new BufferedReader(new InputStreamReader (System.in));
	
	/** lecture d'une S-EXPR au terminal
	 *  @return Sexpr : la Sexpr construite.
	 *  @throws LispException une erreur de syntaxe
	 */
	public static Sexpr read() throws LispException{
	
	}
	
	/** lecture d'une S-EXPRs à partir de la chaine
	 * @param s : le nom du fichier
	 * @return Sexpr : la Sexpr construite
	 * @throws LispException une erreur de syntaxe
	 */
	public static Sexpr read(String s) throws LispException{
		
	}
	
	/** évaluation de la séquence S-EXPRs à partir du fichier s
	 *  @param s : le nom du fichier
	 *  @return Sexpr : synbole du nom du fichier
	 *  @throws LispException une erreur de lecture
	 */
	public static Sexpr importe(String s) throws LispException{
		
	}
	

}
