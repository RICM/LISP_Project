/* Generated By:JavaCC: Do not edit this line. GrammaireLISP.java */
package reader;

import lisp.*;
import exception.*;
import java.io.*;
import java.util.*;

public class GrammaireLISP implements GrammaireLISPConstants {

        /** le support de lecture */
        protected static java.io.Reader in = new BufferedReader(new InputStreamReader (System.in));

        /** lecture d'une S-EXPR au terminal
	 *  @return Sexpr : la Sexpr construite.
	 *  @throws LispException une erreur de syntaxe
	 */

        public static _Sexpr read() throws LispException, ParseException{
                return SEXPR();
        }


        /** lecture d'une S-EXPRs à partir de la chaine
	 * @param s : la chaine a lire
	 * @return Sexpr : la Sexpr construite
	 * @throws LispException une erreur de syntaxe
	 */
        public static _Sexpr read(String s) throws LispException, ParseException{
                ReInit(new ByteArrayInputStream(s.getBytes()));
                return SEXPR();
        }


        /** évaluation de la séquence S-EXPRs à partir du fichier s
	 *  @param s : le nom du fichier
	 *  @return Sexpr : synbole du nom du fichier
	 *  @throws LispException une erreur de lecture
	 */
        public static _Sexpr importe(String s) throws LispException, ParseException, FileNotFoundException{
                ReInit(new BufferedReader(new FileReader (s)));
        return SEXPR();
        }

  static final public _Sexpr SEXPR() throws ParseException {
 _Sexpr se ;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOT:
      jj_consume_token(QUOT);
      se = SEXPR();
                {if (true) return new Scons(new Symbol("QUOTE"), se);}
      break;
    case IDENT:
      se = SYMBOLE();
                {if (true) return se;}
      break;
    case PO:
      jj_consume_token(PO);
      se = DEB_LISTE();
                {if (true) return se;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public _Sexpr SYMBOLE() throws ParseException {
 Token car;
    car = jj_consume_token(IDENT);
                {if (true) return new Symbol(car.toString());}
    throw new Error("Missing return statement in function");
  }

  static final public _Sexpr DEB_LISTE() throws ParseException {
 _Sexpr f,l;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PO:
    case QUOT:
    case PT:
    case IDENT:
      l = LIST();
                {if (true) return l;}
      break;
    case PF:
      f = END_LIST();
                {if (true) return f;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public _Sexpr LIST() throws ParseException {
  _Sexpr car,cdr,pairePointee;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PT:
      jj_consume_token(PT);
      pairePointee = SEXPR();
      cdr = DEB_LISTE();
                        {if (true) return new Scons(pairePointee, cdr);}
      break;
    case PO:
    case QUOT:
    case IDENT:
      car = SEXPR();
      cdr = DEB_LISTE();
                /*if(car.getClass().isInstance(Scons.class) && cdr.equals(Nil.nil))
  	  		return car;
  	  	else*/
                        //System.out.println("Car : "+car.toString());
                        //System.out.println("Cdr : "+cdr.toString()+"\n");
                        {if (true) return new Scons(car, cdr);}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public _Sexpr END_LIST() throws ParseException {
  _Sexpr car, cdr;
    jj_consume_token(PF);
          {if (true) return Nil.nil;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public GrammaireLISPTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1500,0x1f00,0x1d00,};
   }

  /** Constructor with InputStream. */
  public GrammaireLISP(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public GrammaireLISP(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new GrammaireLISPTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public GrammaireLISP(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GrammaireLISPTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public GrammaireLISP(GrammaireLISPTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(GrammaireLISPTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[46];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 46; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
