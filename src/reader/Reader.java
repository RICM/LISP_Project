/* Generated By:JavaCC: Do not edit this line. Reader.java */
package reader;
import java.io.*;
//import java.util.*;
//import java.lang.*;
import lisp.*;
import exception.*;

public class Reader implements ReaderConstants {


        /** le support de lecture */
        protected static java.io.Reader in = new BufferedReader(new InputStreamReader(System.in));
        /** lecture d'une S-EXPR au terminal
	* @return Sexpr : la Sexpr construite.
	* @throws LispException une erreur de syntaxe
	*/
        public static _Sexpr read() throws LispException, ParseException{
                Reader parser = new Reader(in);
                return parser.SEXPR();

        }

        /** lecture d'une S-EXPR à partir de la chaîne
	* @param s : la chaîne
	* @return Sexpr : la Sexpr construite.
	* @throws LispException une erreur de syntaxe
	*/
        public static _Sexpr read(String s) throws LispException, ParseException{
                java.io.Reader stream = new  BufferedReader( new StringReader(s));
                Reader parser = new Reader(stream);
                return parser.SEXPR();
        }

        /** evaluation de la séquence S-EXPRs à partir du fichier s
	* @param s : le nom du fichier
	* @return Sexpr : symbole du nom du fichier.
	* @throws LispException une erreur de lecture
	*/
        public static _Sexpr importe(String s) throws LispException, ParseException, FileNotFoundException{
                java.io.Reader streamFile = new  BufferedReader(new FileReader (s));
                Reader parser = new Reader(streamFile);
                return parser.SEXPR();
        }

//les regles de grammaires de ce langage
  final public _Sexpr SEXPR() throws ParseException, LispException {
        _Sexpr se;
        _Slist l; //What the otarie??? avant : Liste l;
        Symbol s;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case QUOTE:
      jj_consume_token(QUOTE);
      se = SEXPR();
                 {if (true) return new Scons(new Symbol("quote"), se /*new Scons(se, Nil.nilissime)*/ );} // to adapt
      //break;
    case POUVERTE:
      jj_consume_token(POUVERTE);
      l = LISTE(); //what the otarie???
      jj_consume_token(PFERMEE);
                 {if (true) return l;}
      //break;
    case MOT:
      s = ATOME();
                 {if (true) return s;}
      //break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    //throw new Error("Missing return statement in function");
  }

  final public Symbol ATOME() throws ParseException, LispException {
        Symbol s1;
    s1 = SYMBOLE();
                 {return s1;} // Avant : if (true) return s1;
    //throw new Error("Missing return statement in function"); DEAD CODE
  }

  final public Symbol SYMBOLE() throws ParseException, LispException {
        Token t;
    t = jj_consume_token(MOT);
                 {return new Symbol(t.image);} //avant : if (true) return Symbol.creationSymbol(t.image);
    //throw new Error("Missing return statement in function");
  }

  final public _Slist LISTE() throws ParseException, LispException {
        //Symbol s;
        _Sexpr se, se2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case POUVERTE:
    case QUOTE:
    case MOT:
      se = SEXPR();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POINT:
        jj_consume_token(POINT);
        se2 = SEXPR();
        break;
      default:
        jj_la1[1] = jj_gen;
        se2 = LISTE(); //What the otarie?
      }
                 {return (_Slist) new Scons(se,se2 /*new Scons(se2, Nil.nilissime)*/);}//Avant : if (true) return (_Slist) new Scons(se,se2 /*new Scons(se2, Nil.nilissime)*/);
      //break;
    default:
      jj_la1[2] = jj_gen;
          {return (_Slist) Nil.nil;} // Avant : if (true) return (_Slist) Nil.nil;
    }
    //throw new Error("Missing return statement in function");
  }

  final public Nil NIL() throws ParseException {
    jj_consume_token(POUVERTE);
    jj_consume_token(PFERMEE);
                 {return Nil.nil;}// Avant : if (true) return Nil.nil;
    //throw new Error("Missing return statement in function"); Inutile pusique dans tous les cas on renvoie nil
  }

  /** Generated Token Manager. */
  public ReaderTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
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
      jj_la1_1 = new int[] {0x1a00,0x100,0x1a00,};
   }

  /** Constructor with InputStream. */
  public Reader(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Reader(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Reader(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ReaderTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Reader(ReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ReaderTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
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
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[45];
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
    for (int i = 0; i < 45; i++) {
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
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
