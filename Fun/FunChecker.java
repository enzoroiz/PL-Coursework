// $ANTLR 3.5.2 Fun/FunChecker.g 2014-11-25 11:24:32

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FunChecker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSN", "BOOL", "COLON", "COMMENT", 
		"DIGIT", "DIV", "DOT", "ELSE", "EOL", "EQ", "FALSE", "FOR", "FORMAL", 
		"FORVAR", "FUNC", "FUNCCALL", "GT", "ID", "IF", "IFELSE", "INT", "LETTER", 
		"LPAR", "LT", "MINUS", "NOACTUAL", "NOFORMAL", "NOT", "NUM", "PLUS", "PROC", 
		"PROCCALL", "PROG", "REPEAT", "RETURN", "RPAR", "SEQ", "SPACE", "TIMES", 
		"TO", "TRUE", "UNTIL", "VAR", "WHILE"
	};
	public static final int EOF=-1;
	public static final int ASSN=4;
	public static final int BOOL=5;
	public static final int COLON=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DOT=10;
	public static final int ELSE=11;
	public static final int EOL=12;
	public static final int EQ=13;
	public static final int FALSE=14;
	public static final int FOR=15;
	public static final int FORMAL=16;
	public static final int FORVAR=17;
	public static final int FUNC=18;
	public static final int FUNCCALL=19;
	public static final int GT=20;
	public static final int ID=21;
	public static final int IF=22;
	public static final int IFELSE=23;
	public static final int INT=24;
	public static final int LETTER=25;
	public static final int LPAR=26;
	public static final int LT=27;
	public static final int MINUS=28;
	public static final int NOACTUAL=29;
	public static final int NOFORMAL=30;
	public static final int NOT=31;
	public static final int NUM=32;
	public static final int PLUS=33;
	public static final int PROC=34;
	public static final int PROCCALL=35;
	public static final int PROG=36;
	public static final int REPEAT=37;
	public static final int RETURN=38;
	public static final int RPAR=39;
	public static final int SEQ=40;
	public static final int SPACE=41;
	public static final int TIMES=42;
	public static final int TO=43;
	public static final int TRUE=44;
	public static final int UNTIL=45;
	public static final int VAR=46;
	public static final int WHILE=47;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public FunChecker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public FunChecker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FunChecker.tokenNames; }
	@Override public String getGrammarFileName() { return "Fun/FunChecker.g"; }



		// Contextual errors

		private int errorCount = 0;

		private void reportError (String message,
		                          CommonTree ast) {
		// Print an error message relating to the given 
		// (sub)AST.
			int line = ast.getLine(),
			    column = ast.getCharPositionInLine() ;
			System.err.println("line " + line + ":" + column
			   + " " + message);
			errorCount++;
		}

		public int getNumberOfContextualErrors () {
		// Return the total number of errors so far detected.
			return errorCount;
		}


		// Scope checking

		private SymbolTable<Type> typeTable =
		   new SymbolTable<Type>();

		private void predefine () {
		// Add predefined procedures to the type table.
			typeTable.put("read",
			   new Type.Mapping(Type.VOID, Type.INT));
			typeTable.put("write",
			   new Type.Mapping(Type.INT, Type.VOID));
		}

		private void define (String id, Type type,
		                     CommonTree decl) {
		// Add id with its type to the type table, checking 
		// that id is not already declared in the same scope.
			boolean ok = typeTable.put(id, type);
			if (!ok)
				reportError(id + " is redeclared", decl);
		}

		private Type retrieve (String id, CommonTree occ) {
		// Retrieve id's type from the type table.
			Type type = typeTable.get(id);
			if (type == null) {
				reportError(id + " is undeclared", occ);
				return Type.ERROR;
			} else
				return type;
		}


		// Type checking

		private static final Type.Mapping
		   NOTTYPE = new Type.Mapping(Type.BOOL, Type.BOOL),
		   COMPTYPE = new Type.Mapping(
		      new Type.Pair(Type.INT, Type.INT), Type.BOOL),
		   ARITHTYPE = new Type.Mapping(
		      new Type.Pair(Type.INT, Type.INT), Type.INT),
		   MAINTYPE = new Type.Mapping(Type.VOID, Type.VOID);

		private void checkType (Type typeExpected,
		                        Type typeActual,
		                        CommonTree construct) {
		// Check that a construct's actual type matches 
		// the expected type.
			if (! typeActual.equiv(typeExpected))
				reportError("type is " + typeActual
				   + ", should be " + typeExpected,
				   construct);
		}

		private Type checkCall (String id, Type typeArg,
		                        CommonTree call) {
		// Check that a procedure call identifies a procedure 
		// and that its argument type matches the proecure's 
		// type. Return the type of the procedure call.
			Type typeProc = retrieve(id, call);
			if (! (typeProc instanceof Type.Mapping)) {
				reportError(id + " is not a procedure", call);
				return Type.ERROR;
			} else {
				Type.Mapping mapping = (Type.Mapping)typeProc;
				checkType(mapping.domain, typeArg, call);
				return mapping.range;
			}
		}

		private Type checkUnary (Type.Mapping typeOp,
		                         Type typeArg,
		                         CommonTree op) {
		// Check that a unary operator's operand type matches 
		// the operator's type. Return the type of the operator 
		// application.
			if (! (typeOp.domain instanceof Type.Primitive))
				reportError(
				   "unary operator should have 1 operand",
				   op);
			else
				checkType(typeOp.domain, typeArg, op);
			return typeOp.range;
		}

		private Type checkBinary (Type.Mapping typeOp,
		                          Type typeArg1, Type typeArg2,
		                          CommonTree op) {
		// Check that a binary operator's operand types match 
		// the operator's type. Return the type of the operator 
		// application.
			if (! (typeOp.domain instanceof Type.Pair))
				reportError(
				   "binary operator should have 2 operands",
				   op);
			else {
				Type.Pair pair =
				   (Type.Pair)typeOp.domain;
				checkType(pair.first, typeArg1, op);
				checkType(pair.second, typeArg2, op);
			}
			return typeOp.range;
		}




	// $ANTLR start "program"
	// Fun/FunChecker.g:157:1: program : ^( PROG ( var_decl )* ( proc_decl )+ ) ;
	public final void program() throws RecognitionException {
		CommonTree PROG1=null;

		try {
			// Fun/FunChecker.g:158:2: ( ^( PROG ( var_decl )* ( proc_decl )+ ) )
			// Fun/FunChecker.g:158:4: ^( PROG ( var_decl )* ( proc_decl )+ )
			{
			PROG1=(CommonTree)match(input,PROG,FOLLOW_PROG_in_program61); 
			 predefine(); 
			match(input, Token.DOWN, null); 
			// Fun/FunChecker.g:160:5: ( var_decl )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Fun/FunChecker.g:160:5: var_decl
					{
					pushFollow(FOLLOW_var_decl_in_program73);
					var_decl();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			// Fun/FunChecker.g:161:5: ( proc_decl )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==FUNC||LA2_0==PROC) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Fun/FunChecker.g:161:5: proc_decl
					{
					pushFollow(FOLLOW_proc_decl_in_program80);
					proc_decl();
					state._fsp--;

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input, Token.UP, null); 

			 Type tmain = retrieve("main", PROG1);
							  checkType(tmain, MAINTYPE, PROG1);
							
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "proc_decl"
	// Fun/FunChecker.g:171:1: proc_decl : ( ^( PROC ID t= formal ( var_decl )* com ) | ^( FUNC t1= type ID t2= formal ( var_decl )* com t3= expr ) );
	public final void proc_decl() throws RecognitionException {
		CommonTree ID2=null;
		CommonTree PROC3=null;
		CommonTree ID4=null;
		CommonTree FUNC5=null;
		Type t =null;
		Type t1 =null;
		Type t2 =null;
		Type t3 =null;

		try {
			// Fun/FunChecker.g:172:2: ( ^( PROC ID t= formal ( var_decl )* com ) | ^( FUNC t1= type ID t2= formal ( var_decl )* com t3= expr ) )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PROC) ) {
				alt5=1;
			}
			else if ( (LA5_0==FUNC) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// Fun/FunChecker.g:172:4: ^( PROC ID t= formal ( var_decl )* com )
					{
					PROC3=(CommonTree)match(input,PROC,FOLLOW_PROC_in_proc_decl107); 
					match(input, Token.DOWN, null); 
					ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_proc_decl113); 
					 typeTable.enterLocalScope();
									
					pushFollow(FOLLOW_formal_in_proc_decl127);
					t=formal();
					state._fsp--;

					 Type proctype =
									    new Type.Mapping(t, Type.VOID);
									  define((ID2!=null?ID2.getText():null), proctype, PROC3);
									  // ... to enable recursion
									
					// Fun/FunChecker.g:182:5: ( var_decl )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==VAR) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Fun/FunChecker.g:182:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl139);
							var_decl();
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					pushFollow(FOLLOW_com_in_proc_decl146);
					com();
					state._fsp--;

					 typeTable.exitLocalScope();
									  define((ID2!=null?ID2.getText():null), proctype, PROC3);
									
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// Fun/FunChecker.g:188:4: ^( FUNC t1= type ID t2= formal ( var_decl )* com t3= expr )
					{
					FUNC5=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_proc_decl163); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_type_in_proc_decl171);
					t1=type();
					state._fsp--;

					ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_proc_decl177); 
					 typeTable.enterLocalScope();
									
					pushFollow(FOLLOW_formal_in_proc_decl191);
					t2=formal();
					state._fsp--;

					 Type functype =
									    new Type.Mapping(t2, t1);
									  define((ID4!=null?ID4.getText():null), functype, FUNC5);
									  // ... to enable recursion
									
					// Fun/FunChecker.g:199:5: ( var_decl )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Fun/FunChecker.g:199:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl203);
							var_decl();
							state._fsp--;

							}
							break;

						default :
							break loop4;
						}
					}

					pushFollow(FOLLOW_com_in_proc_decl210);
					com();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_proc_decl218);
					t3=expr();
					state._fsp--;

					 typeTable.exitLocalScope();
									  define((ID4!=null?ID4.getText():null), functype, FUNC5);
									  checkType(t1, t3, FUNC5);
									
					match(input, Token.UP, null); 

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "proc_decl"



	// $ANTLR start "formal"
	// Fun/FunChecker.g:209:1: formal returns [Type type] : ( ^( FORMAL t= type ID ) | NOFORMAL );
	public final Type formal() throws RecognitionException {
		Type type = null;


		CommonTree ID6=null;
		CommonTree FORMAL7=null;
		Type t =null;

		try {
			// Fun/FunChecker.g:210:2: ( ^( FORMAL t= type ID ) | NOFORMAL )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FORMAL) ) {
				alt6=1;
			}
			else if ( (LA6_0==NOFORMAL) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Fun/FunChecker.g:210:4: ^( FORMAL t= type ID )
					{
					FORMAL7=(CommonTree)match(input,FORMAL,FOLLOW_FORMAL_in_formal247); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_type_in_formal251);
					t=type();
					state._fsp--;

					ID6=(CommonTree)match(input,ID,FOLLOW_ID_in_formal253); 
					match(input, Token.UP, null); 

					 define((ID6!=null?ID6.getText():null), t, FORMAL7);
									  type = t;
									
					}
					break;
				case 2 :
					// Fun/FunChecker.g:214:4: NOFORMAL
					{
					match(input,NOFORMAL,FOLLOW_NOFORMAL_in_formal265); 
					 type = Type.VOID; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "formal"



	// $ANTLR start "var_decl"
	// Fun/FunChecker.g:218:1: var_decl : ^( VAR t1= type ID t2= expr ) ;
	public final void var_decl() throws RecognitionException {
		CommonTree ID8=null;
		CommonTree VAR9=null;
		Type t1 =null;
		Type t2 =null;

		try {
			// Fun/FunChecker.g:219:2: ( ^( VAR t1= type ID t2= expr ) )
			// Fun/FunChecker.g:219:4: ^( VAR t1= type ID t2= expr )
			{
			VAR9=(CommonTree)match(input,VAR,FOLLOW_VAR_in_var_decl283); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_var_decl287);
			t1=type();
			state._fsp--;

			ID8=(CommonTree)match(input,ID,FOLLOW_ID_in_var_decl289); 
			pushFollow(FOLLOW_expr_in_var_decl293);
			t2=expr();
			state._fsp--;

			match(input, Token.UP, null); 

			 define((ID8!=null?ID8.getText():null), t1, VAR9);
							  checkType(t1, t2, VAR9);
							
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "var_decl"



	// $ANTLR start "for_var_decl"
	// Fun/FunChecker.g:225:1: for_var_decl returns [Type type] : ^( FORVAR INT ID t= expr ) ;
	public final Type for_var_decl() throws RecognitionException {
		Type type = null;


		CommonTree ID10=null;
		CommonTree FORVAR11=null;
		Type t =null;

		try {
			// Fun/FunChecker.g:226:2: ( ^( FORVAR INT ID t= expr ) )
			// Fun/FunChecker.g:226:4: ^( FORVAR INT ID t= expr )
			{
			FORVAR11=(CommonTree)match(input,FORVAR,FOLLOW_FORVAR_in_for_var_decl324); 
			match(input, Token.DOWN, null); 
			match(input,INT,FOLLOW_INT_in_for_var_decl326); 
			ID10=(CommonTree)match(input,ID,FOLLOW_ID_in_for_var_decl328); 
			pushFollow(FOLLOW_expr_in_for_var_decl332);
			t=expr();
			state._fsp--;

			match(input, Token.UP, null); 

			 define((ID10!=null?ID10.getText():null), Type.INT, FORVAR11);				// EXTENSION FOR
							  type = t;							// EXTENSION FOR
							
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "for_var_decl"



	// $ANTLR start "type"
	// Fun/FunChecker.g:232:1: type returns [Type type] : ( BOOL | INT );
	public final Type type() throws RecognitionException {
		Type type = null;


		try {
			// Fun/FunChecker.g:233:2: ( BOOL | INT )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BOOL) ) {
				alt7=1;
			}
			else if ( (LA7_0==INT) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// Fun/FunChecker.g:233:4: BOOL
					{
					match(input,BOOL,FOLLOW_BOOL_in_type373); 
					 type = Type.BOOL; 
					}
					break;
				case 2 :
					// Fun/FunChecker.g:234:4: INT
					{
					match(input,INT,FOLLOW_INT_in_type381); 
					 type = Type.INT; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "type"



	// $ANTLR start "com"
	// Fun/FunChecker.g:240:1: com : ( ^( ASSN ID t= expr ) | ^( PROCCALL ID t= expr ) | ^( IF t= expr com ) | ^( IFELSE t= expr com com ) | ^( WHILE t= expr com ) | ^( FOR t1= for_var_decl t2= expr com ) | ^( REPEAT com t= expr ) | ^( SEQ ( com )* ) );
	public final void com() throws RecognitionException {
		CommonTree ID12=null;
		CommonTree ASSN13=null;
		CommonTree ID14=null;
		CommonTree PROCCALL15=null;
		CommonTree IF16=null;
		CommonTree IFELSE17=null;
		CommonTree WHILE18=null;
		CommonTree FOR19=null;
		CommonTree REPEAT20=null;
		Type t =null;
		Type t1 =null;
		Type t2 =null;

		try {
			// Fun/FunChecker.g:241:2: ( ^( ASSN ID t= expr ) | ^( PROCCALL ID t= expr ) | ^( IF t= expr com ) | ^( IFELSE t= expr com com ) | ^( WHILE t= expr com ) | ^( FOR t1= for_var_decl t2= expr com ) | ^( REPEAT com t= expr ) | ^( SEQ ( com )* ) )
			int alt9=8;
			switch ( input.LA(1) ) {
			case ASSN:
				{
				alt9=1;
				}
				break;
			case PROCCALL:
				{
				alt9=2;
				}
				break;
			case IF:
				{
				alt9=3;
				}
				break;
			case IFELSE:
				{
				alt9=4;
				}
				break;
			case WHILE:
				{
				alt9=5;
				}
				break;
			case FOR:
				{
				alt9=6;
				}
				break;
			case REPEAT:
				{
				alt9=7;
				}
				break;
			case SEQ:
				{
				alt9=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Fun/FunChecker.g:241:4: ^( ASSN ID t= expr )
					{
					ASSN13=(CommonTree)match(input,ASSN,FOLLOW_ASSN_in_com399); 
					match(input, Token.DOWN, null); 
					ID12=(CommonTree)match(input,ID,FOLLOW_ID_in_com401); 
					pushFollow(FOLLOW_expr_in_com405);
					t=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 Type tvar =
									    retrieve((ID12!=null?ID12.getText():null), ASSN13);
									  checkType(tvar, t, ASSN13);
									
					}
					break;
				case 2 :
					// Fun/FunChecker.g:246:4: ^( PROCCALL ID t= expr )
					{
					PROCCALL15=(CommonTree)match(input,PROCCALL,FOLLOW_PROCCALL_in_com418); 
					match(input, Token.DOWN, null); 
					ID14=(CommonTree)match(input,ID,FOLLOW_ID_in_com420); 
					pushFollow(FOLLOW_expr_in_com424);
					t=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 Type tres = checkCall(
									    (ID14!=null?ID14.getText():null), t, PROCCALL15);
									  if (! tres.equiv(Type.VOID))
									    reportError(
									      "procedure should be void",
									      PROCCALL15);
									
					}
					break;
				case 3 :
					// Fun/FunChecker.g:254:4: ^( IF t= expr com )
					{
					IF16=(CommonTree)match(input,IF,FOLLOW_IF_in_com437); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com441);
					t=expr();
					state._fsp--;

					pushFollow(FOLLOW_com_in_com443);
					com();
					state._fsp--;

					match(input, Token.UP, null); 

					 checkType(Type.BOOL, t, IF16);
									
					}
					break;
				case 4 :
					// Fun/FunChecker.g:257:4: ^( IFELSE t= expr com com )
					{
					IFELSE17=(CommonTree)match(input,IFELSE,FOLLOW_IFELSE_in_com456); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com460);
					t=expr();
					state._fsp--;

					pushFollow(FOLLOW_com_in_com462);
					com();
					state._fsp--;

					pushFollow(FOLLOW_com_in_com464);
					com();
					state._fsp--;

					match(input, Token.UP, null); 

					 checkType(Type.BOOL, t, IFELSE17);
									
					}
					break;
				case 5 :
					// Fun/FunChecker.g:260:4: ^( WHILE t= expr com )
					{
					WHILE18=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_com477); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com481);
					t=expr();
					state._fsp--;

					pushFollow(FOLLOW_com_in_com483);
					com();
					state._fsp--;

					match(input, Token.UP, null); 

					 checkType(Type.BOOL, t, WHILE18);
									
					}
					break;
				case 6 :
					// Fun/FunChecker.g:263:4: ^( FOR t1= for_var_decl t2= expr com )
					{
					FOR19=(CommonTree)match(input,FOR,FOLLOW_FOR_in_com496); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_for_var_decl_in_com500);
					t1=for_var_decl();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_com504);
					t2=expr();
					state._fsp--;

					pushFollow(FOLLOW_com_in_com506);
					com();
					state._fsp--;

					match(input, Token.UP, null); 

					 checkType(Type.INT, t1, FOR19);				// EXTENSION FOR
									  checkType(Type.INT, t2, FOR19); 				// EXTENSION FOR
									
					}
					break;
				case 7 :
					// Fun/FunChecker.g:267:4: ^( REPEAT com t= expr )
					{
					REPEAT20=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_com533); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_com_in_com535);
					com();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_com539);
					t=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 checkType(Type.BOOL, t, REPEAT20);				// EXTENSION REPEAT UNTIL
									
					}
					break;
				case 8 :
					// Fun/FunChecker.g:270:4: ^( SEQ ( com )* )
					{
					match(input,SEQ,FOLLOW_SEQ_in_com568); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// Fun/FunChecker.g:270:10: ( com )*
						loop8:
						while (true) {
							int alt8=2;
							int LA8_0 = input.LA(1);
							if ( (LA8_0==ASSN||LA8_0==FOR||(LA8_0 >= IF && LA8_0 <= IFELSE)||LA8_0==PROCCALL||LA8_0==REPEAT||LA8_0==SEQ||LA8_0==WHILE) ) {
								alt8=1;
							}

							switch (alt8) {
							case 1 :
								// Fun/FunChecker.g:270:10: com
								{
								pushFollow(FOLLOW_com_in_com570);
								com();
								state._fsp--;

								}
								break;

							default :
								break loop8;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "com"



	// $ANTLR start "expr"
	// Fun/FunChecker.g:276:1: expr returns [Type type] : ( FALSE | TRUE | NUM | ID | ^( FUNCCALL ID t= expr ) | ^( EQ t1= expr t2= expr ) | ^( LT t1= expr t2= expr ) | ^( GT t1= expr t2= expr ) | ^( PLUS t1= expr t2= expr ) | ^( MINUS t1= expr t2= expr ) | ^( TIMES t1= expr t2= expr ) | ^( DIV t1= expr t2= expr ) | ^( NOT t= expr ) | NOACTUAL );
	public final Type expr() throws RecognitionException {
		Type type = null;


		CommonTree ID21=null;
		CommonTree ID22=null;
		CommonTree FUNCCALL23=null;
		CommonTree EQ24=null;
		CommonTree LT25=null;
		CommonTree GT26=null;
		CommonTree PLUS27=null;
		CommonTree MINUS28=null;
		CommonTree TIMES29=null;
		CommonTree DIV30=null;
		CommonTree NOT31=null;
		Type t =null;
		Type t1 =null;
		Type t2 =null;

		try {
			// Fun/FunChecker.g:277:2: ( FALSE | TRUE | NUM | ID | ^( FUNCCALL ID t= expr ) | ^( EQ t1= expr t2= expr ) | ^( LT t1= expr t2= expr ) | ^( GT t1= expr t2= expr ) | ^( PLUS t1= expr t2= expr ) | ^( MINUS t1= expr t2= expr ) | ^( TIMES t1= expr t2= expr ) | ^( DIV t1= expr t2= expr ) | ^( NOT t= expr ) | NOACTUAL )
			int alt10=14;
			switch ( input.LA(1) ) {
			case FALSE:
				{
				alt10=1;
				}
				break;
			case TRUE:
				{
				alt10=2;
				}
				break;
			case NUM:
				{
				alt10=3;
				}
				break;
			case ID:
				{
				alt10=4;
				}
				break;
			case FUNCCALL:
				{
				alt10=5;
				}
				break;
			case EQ:
				{
				alt10=6;
				}
				break;
			case LT:
				{
				alt10=7;
				}
				break;
			case GT:
				{
				alt10=8;
				}
				break;
			case PLUS:
				{
				alt10=9;
				}
				break;
			case MINUS:
				{
				alt10=10;
				}
				break;
			case TIMES:
				{
				alt10=11;
				}
				break;
			case DIV:
				{
				alt10=12;
				}
				break;
			case NOT:
				{
				alt10=13;
				}
				break;
			case NOACTUAL:
				{
				alt10=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// Fun/FunChecker.g:277:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_expr593); 
					 type = Type.BOOL; 
					}
					break;
				case 2 :
					// Fun/FunChecker.g:279:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_expr604); 
					 type = Type.BOOL; 
					}
					break;
				case 3 :
					// Fun/FunChecker.g:281:4: NUM
					{
					match(input,NUM,FOLLOW_NUM_in_expr615); 
					 type = Type.INT; 
					}
					break;
				case 4 :
					// Fun/FunChecker.g:283:4: ID
					{
					ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_expr626); 
					 type = retrieve((ID21!=null?ID21.getText():null), ID21);
									
					}
					break;
				case 5 :
					// Fun/FunChecker.g:287:4: ^( FUNCCALL ID t= expr )
					{
					FUNCCALL23=(CommonTree)match(input,FUNCCALL,FOLLOW_FUNCCALL_in_expr639); 
					match(input, Token.DOWN, null); 
					ID22=(CommonTree)match(input,ID,FOLLOW_ID_in_expr641); 
					pushFollow(FOLLOW_expr_in_expr645);
					t=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 Type result = checkCall(
									    (ID22!=null?ID22.getText():null), t, FUNCCALL23);
									  if (result.equiv(Type.VOID))
									    reportError(
										 "procedure should be non-void",
									      FUNCCALL23);
									  type = result;
									
					}
					break;
				case 6 :
					// Fun/FunChecker.g:296:4: ^( EQ t1= expr t2= expr )
					{
					EQ24=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expr658); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr662);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr666);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    COMPTYPE, t1, t2, EQ24); 
					}
					break;
				case 7 :
					// Fun/FunChecker.g:299:4: ^( LT t1= expr t2= expr )
					{
					LT25=(CommonTree)match(input,LT,FOLLOW_LT_in_expr679); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr683);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr687);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    COMPTYPE, t1, t2, LT25); 
					}
					break;
				case 8 :
					// Fun/FunChecker.g:302:4: ^( GT t1= expr t2= expr )
					{
					GT26=(CommonTree)match(input,GT,FOLLOW_GT_in_expr700); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr704);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr708);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    COMPTYPE, t1, t2, GT26); 
					}
					break;
				case 9 :
					// Fun/FunChecker.g:305:4: ^( PLUS t1= expr t2= expr )
					{
					PLUS27=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr721); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr725);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr729);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    ARITHTYPE, t1, t2, PLUS27); 
					}
					break;
				case 10 :
					// Fun/FunChecker.g:308:4: ^( MINUS t1= expr t2= expr )
					{
					MINUS28=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr742); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr746);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr750);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    ARITHTYPE, t1, t2, MINUS28); 
					}
					break;
				case 11 :
					// Fun/FunChecker.g:311:4: ^( TIMES t1= expr t2= expr )
					{
					TIMES29=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expr763); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr767);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr771);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									    ARITHTYPE, t1, t2, TIMES29); 
					}
					break;
				case 12 :
					// Fun/FunChecker.g:314:4: ^( DIV t1= expr t2= expr )
					{
					DIV30=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr784); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr788);
					t1=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr792);
					t2=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkBinary(
									     ARITHTYPE, t1, t2, DIV30); 
					}
					break;
				case 13 :
					// Fun/FunChecker.g:317:4: ^( NOT t= expr )
					{
					NOT31=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expr805); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr809);
					t=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 type = checkUnary(NOTTYPE, t, NOT31); 
					}
					break;
				case 14 :
					// Fun/FunChecker.g:319:4: NOACTUAL
					{
					match(input,NOACTUAL,FOLLOW_NOACTUAL_in_expr821); 
					 type = Type.VOID; 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_PROG_in_program61 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_var_decl_in_program73 = new BitSet(new long[]{0x0000400400040000L});
	public static final BitSet FOLLOW_proc_decl_in_program80 = new BitSet(new long[]{0x0000000400040008L});
	public static final BitSet FOLLOW_PROC_in_proc_decl107 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_proc_decl113 = new BitSet(new long[]{0x0000000040010000L});
	public static final BitSet FOLLOW_formal_in_proc_decl127 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl139 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_com_in_proc_decl146 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_in_proc_decl163 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proc_decl171 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_proc_decl177 = new BitSet(new long[]{0x0000000040010000L});
	public static final BitSet FOLLOW_formal_in_proc_decl191 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl203 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_com_in_proc_decl210 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_proc_decl218 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FORMAL_in_formal247 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_formal251 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_formal253 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOFORMAL_in_formal265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_decl283 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_var_decl287 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_var_decl289 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_var_decl293 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FORVAR_in_for_var_decl324 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_INT_in_for_var_decl326 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_for_var_decl328 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_for_var_decl332 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BOOL_in_type373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSN_in_com399 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_com401 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com405 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROCCALL_in_com418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_com420 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com424 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_in_com437 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com441 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com443 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IFELSE_in_com456 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com460 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com462 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com464 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_com477 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com481 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com483 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOR_in_com496 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_for_var_decl_in_com500 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com504 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com506 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REPEAT_in_com533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_com_in_com535 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com539 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_com568 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_com_in_com570 = new BitSet(new long[]{0x0000812800C08018L});
	public static final BitSet FOLLOW_FALSE_in_expr593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expr604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_expr615 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCCALL_in_expr639 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expr641 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr645 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expr658 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr662 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr666 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expr679 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr683 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr687 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expr700 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr704 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr708 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expr721 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr725 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr729 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr742 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr746 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr750 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TIMES_in_expr763 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr767 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr771 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr784 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr788 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr792 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expr805 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr809 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOACTUAL_in_expr821 = new BitSet(new long[]{0x0000000000000002L});
}
