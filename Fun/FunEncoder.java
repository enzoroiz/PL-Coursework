// $ANTLR 3.5.2 Fun/FunEncoder.g 2014-11-25 11:24:33

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FunEncoder extends TreeParser {
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


	public FunEncoder(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public FunEncoder(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FunEncoder.tokenNames; }
	@Override public String getGrammarFileName() { return "Fun/FunEncoder.g"; }



		private SVM obj = new SVM();

		private int globalvaraddr = 0;
		private int localvaraddr = 0;
		private int currentLocale = Address.GLOBAL;

		private SymbolTable<Address> addrTable =
		   new SymbolTable<Address>();

		private void predefine () {
		// Add predefined procedures to the address table.
			addrTable.put("read",
			   new Address(SVM.READOFFSET, Address.CODE));
			addrTable.put("write",
			   new Address(SVM.WRITEOFFSET, Address.CODE));
		}




	// $ANTLR start "program"
	// Fun/FunEncoder.g:99:1: program returns [SVM objectprogram] : ^( PROG ( var_decl )* ( proc_decl )+ ) ;
	public final SVM program() throws RecognitionException {
		SVM objectprogram = null;


		try {
			// Fun/FunEncoder.g:100:2: ( ^( PROG ( var_decl )* ( proc_decl )+ ) )
			// Fun/FunEncoder.g:100:4: ^( PROG ( var_decl )* ( proc_decl )+ )
			{
			match(input,PROG,FOLLOW_PROG_in_program117); 
			 predefine();
							
			match(input, Token.DOWN, null); 
			// Fun/FunEncoder.g:103:5: ( var_decl )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==VAR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Fun/FunEncoder.g:103:5: var_decl
					{
					pushFollow(FOLLOW_var_decl_in_program129);
					var_decl();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			 int calladdr =
							    obj.currentOffset();
							  obj.emit12(SVM.CALL, 0);
							  obj.emit1(SVM.HALT);
							
			// Fun/FunEncoder.g:109:5: ( proc_decl )+
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
					// Fun/FunEncoder.g:109:5: proc_decl
					{
					pushFollow(FOLLOW_proc_decl_in_program142);
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

			 int mainaddr =
							    addrTable.get("main").offset;
							  obj.patch12(calladdr, mainaddr);
							  objectprogram = obj;
							
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return objectprogram;
	}
	// $ANTLR end "program"



	// $ANTLR start "proc_decl"
	// Fun/FunEncoder.g:121:1: proc_decl : ( ^( PROC ID formal ( var_decl )* com ) | ^( FUNC type ID formal ( var_decl )* com expr ) );
	public final void proc_decl() throws RecognitionException {
		CommonTree ID1=null;
		CommonTree ID2=null;

		try {
			// Fun/FunEncoder.g:122:2: ( ^( PROC ID formal ( var_decl )* com ) | ^( FUNC type ID formal ( var_decl )* com expr ) )
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
					// Fun/FunEncoder.g:122:4: ^( PROC ID formal ( var_decl )* com )
					{
					match(input,PROC,FOLLOW_PROC_in_proc_decl169); 
					match(input, Token.DOWN, null); 
					ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_proc_decl175); 
					 String id = (ID1!=null?ID1.getText():null);
									  Address procaddr = new Address(
									    obj.currentOffset(), Address.CODE);
									  addrTable.put(id, procaddr);
									  addrTable.enterLocalScope();
									  currentLocale = Address.LOCAL;
									  localvaraddr = 2;
									  // ... allows 2 words for link data
									
					pushFollow(FOLLOW_formal_in_proc_decl187);
					formal();
					state._fsp--;

					// Fun/FunEncoder.g:134:5: ( var_decl )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==VAR) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Fun/FunEncoder.g:134:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl193);
							var_decl();
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					pushFollow(FOLLOW_com_in_proc_decl200);
					com();
					state._fsp--;

					 obj.emit11(SVM.RETURN, 0);
									  addrTable.exitLocalScope();
									  currentLocale = Address.GLOBAL;
									
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// Fun/FunEncoder.g:141:4: ^( FUNC type ID formal ( var_decl )* com expr )
					{
					match(input,FUNC,FOLLOW_FUNC_in_proc_decl217); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_type_in_proc_decl223);
					type();
					state._fsp--;

					ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_proc_decl229); 
					 String id = (ID2!=null?ID2.getText():null);
									  Address procaddr = new Address(
									    obj.currentOffset(), Address.CODE);
									  addrTable.put(id, procaddr);
									  addrTable.enterLocalScope();
									  currentLocale = Address.LOCAL;
									  localvaraddr = 2;
									  // ... allows 2 words for link data
									
					pushFollow(FOLLOW_formal_in_proc_decl241);
					formal();
					state._fsp--;

					// Fun/FunEncoder.g:154:5: ( var_decl )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==VAR) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Fun/FunEncoder.g:154:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl247);
							var_decl();
							state._fsp--;

							}
							break;

						default :
							break loop4;
						}
					}

					pushFollow(FOLLOW_com_in_proc_decl254);
					com();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_proc_decl260);
					expr();
					state._fsp--;

					 obj.emit11(SVM.RETURN, 1);
									  addrTable.exitLocalScope();
									  currentLocale = Address.GLOBAL;
									
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
	// Fun/FunEncoder.g:164:1: formal : ( ^( FORMAL type ID ) | NOFORMAL );
	public final void formal() throws RecognitionException {
		CommonTree ID3=null;

		try {
			// Fun/FunEncoder.g:165:2: ( ^( FORMAL type ID ) | NOFORMAL )
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
					// Fun/FunEncoder.g:165:4: ^( FORMAL type ID )
					{
					match(input,FORMAL,FOLLOW_FORMAL_in_formal283); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_type_in_formal289);
					type();
					state._fsp--;

					ID3=(CommonTree)match(input,ID,FOLLOW_ID_in_formal295); 
					 String id = (ID3!=null?ID3.getText():null);
									  addrTable.put(id, new Address(
									    localvaraddr++, Address.LOCAL));
									  obj.emit11(SVM.COPYARG, 1); 
									
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// Fun/FunEncoder.g:174:4: NOFORMAL
					{
					match(input,NOFORMAL,FOLLOW_NOFORMAL_in_formal311); 
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
	// $ANTLR end "formal"



	// $ANTLR start "var_decl"
	// Fun/FunEncoder.g:177:1: var_decl : ^( VAR type ID expr ) ;
	public final void var_decl() throws RecognitionException {
		CommonTree ID4=null;

		try {
			// Fun/FunEncoder.g:178:2: ( ^( VAR type ID expr ) )
			// Fun/FunEncoder.g:178:4: ^( VAR type ID expr )
			{
			match(input,VAR,FOLLOW_VAR_in_var_decl323); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_var_decl329);
			type();
			state._fsp--;

			ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_var_decl335); 
			pushFollow(FOLLOW_expr_in_var_decl341);
			expr();
			state._fsp--;

			 String id = (ID4!=null?ID4.getText():null);
							  switch (currentLocale) {
							    case Address.LOCAL:
							      addrTable.put(id, new Address(
							        localvaraddr++, Address.LOCAL));
							      break;
							    case Address.GLOBAL:
							      addrTable.put(id, new Address(
							        globalvaraddr++, Address.GLOBAL));
							  }
							
			match(input, Token.UP, null); 

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
	// Fun/FunEncoder.g:196:1: for_var_decl returns [int addr] : ^( FORVAR INT ID expr ) ;
	public final int for_var_decl() throws RecognitionException {
		int addr = 0;


		CommonTree ID5=null;

		try {
			// Fun/FunEncoder.g:197:2: ( ^( FORVAR INT ID expr ) )
			// Fun/FunEncoder.g:197:4: ^( FORVAR INT ID expr )
			{
			match(input,FORVAR,FOLLOW_FORVAR_in_for_var_decl375); 
			match(input, Token.DOWN, null); 
			match(input,INT,FOLLOW_INT_in_for_var_decl389); 
			ID5=(CommonTree)match(input,ID,FOLLOW_ID_in_for_var_decl404); 
			pushFollow(FOLLOW_expr_in_for_var_decl419);
			expr();
			state._fsp--;

			 String id = (ID5!=null?ID5.getText():null);					// EXTENSION FOR
							      addrTable.put(id, new Address(			// EXTENSION FOR
							        localvaraddr++, Address.LOCAL));		// EXTENSION FOR
							  addr = addrTable.get(id).offset;			// EXTENSION FOR
							
			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return addr;
	}
	// $ANTLR end "for_var_decl"



	// $ANTLR start "type"
	// Fun/FunEncoder.g:209:1: type : ( BOOL | INT );
	public final void type() throws RecognitionException {
		try {
			// Fun/FunEncoder.g:210:2: ( BOOL | INT )
			// Fun/FunEncoder.g:
			{
			if ( input.LA(1)==BOOL||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
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
	// $ANTLR end "type"



	// $ANTLR start "com"
	// Fun/FunEncoder.g:217:1: com : ( ^( ASSN ID expr ) | ^( PROCCALL ID expr ) | ^( IF expr com ) | ^( IFELSE expr com com ) | ^( WHILE expr com ) | ^( REPEAT com expr ) | ^( FOR identaddr= for_var_decl expr com ) | ^( SEQ ( com )* ) );
	public final void com() throws RecognitionException {
		CommonTree ID6=null;
		CommonTree ID7=null;
		int identaddr =0;

		try {
			// Fun/FunEncoder.g:218:2: ( ^( ASSN ID expr ) | ^( PROCCALL ID expr ) | ^( IF expr com ) | ^( IFELSE expr com com ) | ^( WHILE expr com ) | ^( REPEAT com expr ) | ^( FOR identaddr= for_var_decl expr com ) | ^( SEQ ( com )* ) )
			int alt8=8;
			switch ( input.LA(1) ) {
			case ASSN:
				{
				alt8=1;
				}
				break;
			case PROCCALL:
				{
				alt8=2;
				}
				break;
			case IF:
				{
				alt8=3;
				}
				break;
			case IFELSE:
				{
				alt8=4;
				}
				break;
			case WHILE:
				{
				alt8=5;
				}
				break;
			case REPEAT:
				{
				alt8=6;
				}
				break;
			case FOR:
				{
				alt8=7;
				}
				break;
			case SEQ:
				{
				alt8=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// Fun/FunEncoder.g:218:4: ^( ASSN ID expr )
					{
					match(input,ASSN,FOLLOW_ASSN_in_com496); 
					match(input, Token.DOWN, null); 
					ID6=(CommonTree)match(input,ID,FOLLOW_ID_in_com502); 
					pushFollow(FOLLOW_expr_in_com508);
					expr();
					state._fsp--;

					 String id = (ID6!=null?ID6.getText():null);
									  Address varaddr = addrTable.get(id);
									  switch (varaddr.locale) {
									    case Address.GLOBAL:
									      obj.emit12(SVM.STOREG,
									        varaddr.offset);
									      break;
									    case Address.LOCAL:
									      obj.emit12(SVM.STOREL,
									        varaddr.offset);
									  }
									
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// Fun/FunEncoder.g:234:4: ^( PROCCALL ID expr )
					{
					match(input,PROCCALL,FOLLOW_PROCCALL_in_com525); 
					match(input, Token.DOWN, null); 
					ID7=(CommonTree)match(input,ID,FOLLOW_ID_in_com531); 
					pushFollow(FOLLOW_expr_in_com537);
					expr();
					state._fsp--;

					 String id = (ID7!=null?ID7.getText():null);
									  Address procaddr = addrTable.get(id);
									  // Assume procaddr.locale == CODE.
									  obj.emit12(SVM.CALL,
									    procaddr.offset);
									
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// Fun/FunEncoder.g:244:4: ^( IF expr com )
					{
					match(input,IF,FOLLOW_IF_in_com554); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com560);
					expr();
					state._fsp--;

					 int condaddr = obj.currentOffset();
									  obj.emit12(SVM.JUMPF, 0);
									
					pushFollow(FOLLOW_com_in_com572);
					com();
					state._fsp--;

					 int exitaddr = obj.currentOffset();
									  obj.patch12(condaddr, exitaddr);
									
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// Fun/FunEncoder.g:254:4: ^( IFELSE expr com com )
					{
					match(input,IFELSE,FOLLOW_IFELSE_in_com589); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com595);
					expr();
					state._fsp--;

					 int condaddr = obj.currentOffset();
									  obj.emit12(SVM.JUMPF, 0);
									
					pushFollow(FOLLOW_com_in_com607);
					com();
					state._fsp--;

					 int jumpaddr = obj.currentOffset();
									  obj.emit12(SVM.JUMP, 0);
									  int elseaddr = obj.currentOffset();
									  obj.patch12(condaddr, elseaddr);
									
					pushFollow(FOLLOW_com_in_com619);
					com();
					state._fsp--;

					 int exitaddr = obj.currentOffset();
									  obj.patch12(jumpaddr, exitaddr);
									
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// Fun/FunEncoder.g:270:4: ^( WHILE expr com )
					{
					match(input,WHILE,FOLLOW_WHILE_in_com636); 
					 int startaddr = obj.currentOffset();
									
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_com649);
					expr();
					state._fsp--;

					 int condaddr = obj.currentOffset();
									  obj.emit12(SVM.JUMPF, 0);
									
					pushFollow(FOLLOW_com_in_com662);
					com();
					state._fsp--;

					 obj.emit12(SVM.JUMP, startaddr);
									  int exitaddr = obj.currentOffset();
									  obj.patch12(condaddr, exitaddr);
									
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// Fun/FunEncoder.g:283:4: ^( REPEAT com expr )
					{
					match(input,REPEAT,FOLLOW_REPEAT_in_com679); 
					 int startaddr = obj.currentOffset();			// EXTENSION REPEAT UNTIL
									
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_com_in_com707);
					com();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_com735);
					expr();
					state._fsp--;

					 int condaddr = obj.currentOffset();			// EXTENSION REPEAT UNTIL
									  obj.emit12(SVM.JUMPF, 0);				// EXTENSION REPEAT UNTIL
									  obj.emit12(SVM.JUMP, startaddr);			// EXTENSION REPEAT UNTIL
									  int exitaddr = obj.currentOffset();			// EXTENSION REPEAT UNTIL
									  obj.patch12(condaddr, exitaddr);			// EXTENSION REPEAT UNTIL
									
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// Fun/FunEncoder.g:296:4: ^( FOR identaddr= for_var_decl expr com )
					{
					match(input,FOR,FOLLOW_FOR_in_com777); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_for_var_decl_in_com797);
					identaddr=for_var_decl();
					state._fsp--;

					 int jumpaddr = obj.currentOffset();			// EXTENSION FOR
									
					pushFollow(FOLLOW_expr_in_com835);
					expr();
					state._fsp--;

					 							// EXTENSION FOR
									  obj.emit12(SVM.LOADL, identaddr);			// EXTENSION FOR
									  obj.emit1(SVM.CMPLT);					// EXTENSION FOR
									  int condaddr = obj.currentOffset();			// EXTENSION FOR
								  	  obj.emit12(SVM.JUMPT, 0);				// EXTENSION FOR
									
					pushFollow(FOLLOW_com_in_com864);
					com();
					state._fsp--;

					 obj.emit12(SVM.LOADL, identaddr);			// EXTENSION FOR
									  obj.emit1(SVM.INC);					// EXTENSION FOR
									  obj.emit12(SVM.STOREL, identaddr);			// EXTENSION FOR
									  obj.emit12(SVM.JUMP, jumpaddr);			// EXTENSION FOR
								  	  int exitaddr = obj.currentOffset();			// EXTENSION FOR
								  	  obj.patch12(condaddr, exitaddr);			// EXTENSION FOR
									
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// Fun/FunEncoder.g:316:4: ^( SEQ ( com )* )
					{
					match(input,SEQ,FOLLOW_SEQ_in_com895); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// Fun/FunEncoder.g:317:5: ( com )*
						loop7:
						while (true) {
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( (LA7_0==ASSN||LA7_0==FOR||(LA7_0 >= IF && LA7_0 <= IFELSE)||LA7_0==PROCCALL||LA7_0==REPEAT||LA7_0==SEQ||LA7_0==WHILE) ) {
								alt7=1;
							}

							switch (alt7) {
							case 1 :
								// Fun/FunEncoder.g:317:5: com
								{
								pushFollow(FOLLOW_com_in_com901);
								com();
								state._fsp--;

								}
								break;

							default :
								break loop7;
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
	// Fun/FunEncoder.g:324:1: expr : ( FALSE | TRUE | NUM | ID | ^( FUNCCALL ID expr ) | ^( EQ expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( TIMES expr expr ) | ^( DIV expr expr ) | ^( NOT expr ) | NOACTUAL );
	public final void expr() throws RecognitionException {
		CommonTree NUM8=null;
		CommonTree ID9=null;
		CommonTree ID10=null;

		try {
			// Fun/FunEncoder.g:325:2: ( FALSE | TRUE | NUM | ID | ^( FUNCCALL ID expr ) | ^( EQ expr expr ) | ^( LT expr expr ) | ^( GT expr expr ) | ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( TIMES expr expr ) | ^( DIV expr expr ) | ^( NOT expr ) | NOACTUAL )
			int alt9=14;
			switch ( input.LA(1) ) {
			case FALSE:
				{
				alt9=1;
				}
				break;
			case TRUE:
				{
				alt9=2;
				}
				break;
			case NUM:
				{
				alt9=3;
				}
				break;
			case ID:
				{
				alt9=4;
				}
				break;
			case FUNCCALL:
				{
				alt9=5;
				}
				break;
			case EQ:
				{
				alt9=6;
				}
				break;
			case LT:
				{
				alt9=7;
				}
				break;
			case GT:
				{
				alt9=8;
				}
				break;
			case PLUS:
				{
				alt9=9;
				}
				break;
			case MINUS:
				{
				alt9=10;
				}
				break;
			case TIMES:
				{
				alt9=11;
				}
				break;
			case DIV:
				{
				alt9=12;
				}
				break;
			case NOT:
				{
				alt9=13;
				}
				break;
			case NOACTUAL:
				{
				alt9=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Fun/FunEncoder.g:325:4: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_expr921); 
					 obj.emit12(SVM.LOADC, 0); 
					}
					break;
				case 2 :
					// Fun/FunEncoder.g:327:4: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_expr932); 
					 obj.emit12(SVM.LOADC, 1); 
					}
					break;
				case 3 :
					// Fun/FunEncoder.g:329:4: NUM
					{
					NUM8=(CommonTree)match(input,NUM,FOLLOW_NUM_in_expr943); 
					 int value =
									    Integer.parseInt((NUM8!=null?NUM8.getText():null));
									  obj.emit12(SVM.LOADC, value);
									
					}
					break;
				case 4 :
					// Fun/FunEncoder.g:334:4: ID
					{
					ID9=(CommonTree)match(input,ID,FOLLOW_ID_in_expr954); 
					 String id = (ID9!=null?ID9.getText():null);
									  Address varaddr = addrTable.get(id);
									  switch (varaddr.locale) {
									    case Address.GLOBAL:
									      obj.emit12(SVM.LOADG,
									        varaddr.offset);
									      break;
									    case Address.LOCAL:
									      obj.emit12(SVM.LOADL,
									        varaddr.offset);
									  }
									
					}
					break;
				case 5 :
					// Fun/FunEncoder.g:347:4: ^( FUNCCALL ID expr )
					{
					match(input,FUNCCALL,FOLLOW_FUNCCALL_in_expr966); 
					match(input, Token.DOWN, null); 
					ID10=(CommonTree)match(input,ID,FOLLOW_ID_in_expr972); 
					pushFollow(FOLLOW_expr_in_expr978);
					expr();
					state._fsp--;

					 String id = (ID10!=null?ID10.getText():null);
									  Address funcaddr = addrTable.get(id);
									  // Assume that funcaddr.locale == CODE.
									  obj.emit12(SVM.CALL,
									    funcaddr.offset);
									
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// Fun/FunEncoder.g:357:4: ^( EQ expr expr )
					{
					match(input,EQ,FOLLOW_EQ_in_expr995); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1001);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1007);
					expr();
					state._fsp--;

					 obj.emit1(SVM.CMPEQ); 
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// Fun/FunEncoder.g:362:4: ^( LT expr expr )
					{
					match(input,LT,FOLLOW_LT_in_expr1024); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1030);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1036);
					expr();
					state._fsp--;

					 obj.emit1(SVM.CMPLT); 
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// Fun/FunEncoder.g:367:4: ^( GT expr expr )
					{
					match(input,GT,FOLLOW_GT_in_expr1053); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1059);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1065);
					expr();
					state._fsp--;

					 obj.emit1(SVM.CMPGT); 
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// Fun/FunEncoder.g:372:4: ^( PLUS expr expr )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expr1082); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1088);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1094);
					expr();
					state._fsp--;

					 obj.emit1(SVM.ADD); 
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// Fun/FunEncoder.g:377:4: ^( MINUS expr expr )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expr1111); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1117);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1123);
					expr();
					state._fsp--;

					 obj.emit1(SVM.SUB); 
					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// Fun/FunEncoder.g:382:4: ^( TIMES expr expr )
					{
					match(input,TIMES,FOLLOW_TIMES_in_expr1140); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1146);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1152);
					expr();
					state._fsp--;

					 obj.emit1(SVM.MUL); 
					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// Fun/FunEncoder.g:387:4: ^( DIV expr expr )
					{
					match(input,DIV,FOLLOW_DIV_in_expr1169); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1175);
					expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr1181);
					expr();
					state._fsp--;

					 obj.emit1(SVM.DIV); 
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// Fun/FunEncoder.g:392:4: ^( NOT expr )
					{
					match(input,NOT,FOLLOW_NOT_in_expr1198); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr1204);
					expr();
					state._fsp--;

					 obj.emit1(SVM.INV); 
					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// Fun/FunEncoder.g:396:4: NOACTUAL
					{
					match(input,NOACTUAL,FOLLOW_NOACTUAL_in_expr1220); 
					 
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
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_PROG_in_program117 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_var_decl_in_program129 = new BitSet(new long[]{0x0000400400040000L});
	public static final BitSet FOLLOW_proc_decl_in_program142 = new BitSet(new long[]{0x0000000400040008L});
	public static final BitSet FOLLOW_PROC_in_proc_decl169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_proc_decl175 = new BitSet(new long[]{0x0000000040010000L});
	public static final BitSet FOLLOW_formal_in_proc_decl187 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl193 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_com_in_proc_decl200 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNC_in_proc_decl217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proc_decl223 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_proc_decl229 = new BitSet(new long[]{0x0000000040010000L});
	public static final BitSet FOLLOW_formal_in_proc_decl241 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl247 = new BitSet(new long[]{0x0000C12800C08010L});
	public static final BitSet FOLLOW_com_in_proc_decl254 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_proc_decl260 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FORMAL_in_formal283 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_formal289 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_formal295 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOFORMAL_in_formal311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_var_decl323 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_var_decl329 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_var_decl335 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_var_decl341 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FORVAR_in_for_var_decl375 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_INT_in_for_var_decl389 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_for_var_decl404 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_for_var_decl419 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSN_in_com496 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_com502 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com508 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROCCALL_in_com525 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_com531 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com537 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_in_com554 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com560 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com572 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IFELSE_in_com589 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com595 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com607 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com619 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_com636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_com649 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com662 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REPEAT_in_com679 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_com_in_com707 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com735 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FOR_in_com777 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_for_var_decl_in_com797 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_com835 = new BitSet(new long[]{0x0000812800C08010L});
	public static final BitSet FOLLOW_com_in_com864 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SEQ_in_com895 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_com_in_com901 = new BitSet(new long[]{0x0000812800C08018L});
	public static final BitSet FOLLOW_FALSE_in_expr921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expr932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_expr943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_expr954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCCALL_in_expr966 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expr972 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr978 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expr995 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1001 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1007 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expr1024 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1030 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1036 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expr1053 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1059 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1065 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expr1082 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1088 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1094 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expr1111 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1117 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1123 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TIMES_in_expr1140 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1146 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1152 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expr1169 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1175 = new BitSet(new long[]{0x00001403B8386200L});
	public static final BitSet FOLLOW_expr_in_expr1181 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expr1198 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr1204 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOACTUAL_in_expr1220 = new BitSet(new long[]{0x0000000000000002L});
}
