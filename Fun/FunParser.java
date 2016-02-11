// $ANTLR 3.5.2 Fun/Fun.g 2014-11-25 11:24:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class FunParser extends Parser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public FunParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public FunParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return FunParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Fun/Fun.g"; }


	public static class program_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// Fun/Fun.g:39:1: program : ( var_decl )* ( proc_decl )+ EOF -> ^( PROG ( var_decl )* ( proc_decl )+ ) ;
	public final FunParser.program_return program() throws RecognitionException {
		FunParser.program_return retval = new FunParser.program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope var_decl1 =null;
		ParserRuleReturnScope proc_decl2 =null;

		CommonTree EOF3_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_proc_decl=new RewriteRuleSubtreeStream(adaptor,"rule proc_decl");
		RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");

		try {
			// Fun/Fun.g:40:2: ( ( var_decl )* ( proc_decl )+ EOF -> ^( PROG ( var_decl )* ( proc_decl )+ ) )
			// Fun/Fun.g:40:4: ( var_decl )* ( proc_decl )+ EOF
			{
			// Fun/Fun.g:40:4: ( var_decl )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==BOOL||LA1_0==INT) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Fun/Fun.g:40:4: var_decl
					{
					pushFollow(FOLLOW_var_decl_in_program104);
					var_decl1=var_decl();
					state._fsp--;

					stream_var_decl.add(var_decl1.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// Fun/Fun.g:40:14: ( proc_decl )+
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
					// Fun/Fun.g:40:14: proc_decl
					{
					pushFollow(FOLLOW_proc_decl_in_program107);
					proc_decl2=proc_decl();
					state._fsp--;

					stream_proc_decl.add(proc_decl2.getTree());
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_program110);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: proc_decl, var_decl
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 40:31: -> ^( PROG ( var_decl )* ( proc_decl )+ )
			{
				// Fun/Fun.g:40:34: ^( PROG ( var_decl )* ( proc_decl )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROG, "PROG"), root_1);
				// Fun/Fun.g:41:35: ( var_decl )*
				while ( stream_var_decl.hasNext() ) {
					adaptor.addChild(root_1, stream_var_decl.nextTree());
				}
				stream_var_decl.reset();

				if ( !(stream_proc_decl.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_proc_decl.hasNext() ) {
					adaptor.addChild(root_1, stream_proc_decl.nextTree());
				}
				stream_proc_decl.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class proc_decl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "proc_decl"
	// Fun/Fun.g:48:1: proc_decl : ( PROC ID LPAR formal RPAR COLON ( var_decl )* seq_com DOT -> ^( PROC ID formal ( var_decl )* seq_com ) | FUNC type ID LPAR formal RPAR COLON ( var_decl )* seq_com RETURN expr DOT -> ^( FUNC type ID formal ( var_decl )* seq_com expr ) );
	public final FunParser.proc_decl_return proc_decl() throws RecognitionException {
		FunParser.proc_decl_return retval = new FunParser.proc_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PROC4=null;
		Token ID5=null;
		Token LPAR6=null;
		Token RPAR8=null;
		Token COLON9=null;
		Token DOT12=null;
		Token FUNC13=null;
		Token ID15=null;
		Token LPAR16=null;
		Token RPAR18=null;
		Token COLON19=null;
		Token RETURN22=null;
		Token DOT24=null;
		ParserRuleReturnScope formal7 =null;
		ParserRuleReturnScope var_decl10 =null;
		ParserRuleReturnScope seq_com11 =null;
		ParserRuleReturnScope type14 =null;
		ParserRuleReturnScope formal17 =null;
		ParserRuleReturnScope var_decl20 =null;
		ParserRuleReturnScope seq_com21 =null;
		ParserRuleReturnScope expr23 =null;

		CommonTree PROC4_tree=null;
		CommonTree ID5_tree=null;
		CommonTree LPAR6_tree=null;
		CommonTree RPAR8_tree=null;
		CommonTree COLON9_tree=null;
		CommonTree DOT12_tree=null;
		CommonTree FUNC13_tree=null;
		CommonTree ID15_tree=null;
		CommonTree LPAR16_tree=null;
		CommonTree RPAR18_tree=null;
		CommonTree COLON19_tree=null;
		CommonTree RETURN22_tree=null;
		CommonTree DOT24_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
		RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_FUNC=new RewriteRuleTokenStream(adaptor,"token FUNC");
		RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
		RewriteRuleTokenStream stream_PROC=new RewriteRuleTokenStream(adaptor,"token PROC");
		RewriteRuleSubtreeStream stream_formal=new RewriteRuleSubtreeStream(adaptor,"rule formal");
		RewriteRuleSubtreeStream stream_seq_com=new RewriteRuleSubtreeStream(adaptor,"rule seq_com");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
		RewriteRuleSubtreeStream stream_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule var_decl");

		try {
			// Fun/Fun.g:49:2: ( PROC ID LPAR formal RPAR COLON ( var_decl )* seq_com DOT -> ^( PROC ID formal ( var_decl )* seq_com ) | FUNC type ID LPAR formal RPAR COLON ( var_decl )* seq_com RETURN expr DOT -> ^( FUNC type ID formal ( var_decl )* seq_com expr ) )
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
					// Fun/Fun.g:49:4: PROC ID LPAR formal RPAR COLON ( var_decl )* seq_com DOT
					{
					PROC4=(Token)match(input,PROC,FOLLOW_PROC_in_proc_decl207);  
					stream_PROC.add(PROC4);

					ID5=(Token)match(input,ID,FOLLOW_ID_in_proc_decl209);  
					stream_ID.add(ID5);

					LPAR6=(Token)match(input,LPAR,FOLLOW_LPAR_in_proc_decl215);  
					stream_LPAR.add(LPAR6);

					pushFollow(FOLLOW_formal_in_proc_decl217);
					formal7=formal();
					state._fsp--;

					stream_formal.add(formal7.getTree());
					RPAR8=(Token)match(input,RPAR,FOLLOW_RPAR_in_proc_decl219);  
					stream_RPAR.add(RPAR8);

					COLON9=(Token)match(input,COLON,FOLLOW_COLON_in_proc_decl221);  
					stream_COLON.add(COLON9);

					// Fun/Fun.g:51:5: ( var_decl )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==BOOL||LA3_0==INT) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Fun/Fun.g:51:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl227);
							var_decl10=var_decl();
							state._fsp--;

							stream_var_decl.add(var_decl10.getTree());
							}
							break;

						default :
							break loop3;
						}
					}

					pushFollow(FOLLOW_seq_com_in_proc_decl230);
					seq_com11=seq_com();
					state._fsp--;

					stream_seq_com.add(seq_com11.getTree());
					DOT12=(Token)match(input,DOT,FOLLOW_DOT_in_proc_decl232);  
					stream_DOT.add(DOT12);

					// AST REWRITE
					// elements: seq_com, formal, var_decl, ID, PROC
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 51:30: -> ^( PROC ID formal ( var_decl )* seq_com )
					{
						// Fun/Fun.g:51:33: ^( PROC ID formal ( var_decl )* seq_com )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_PROC.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_formal.nextTree());
						// Fun/Fun.g:53:35: ( var_decl )*
						while ( stream_var_decl.hasNext() ) {
							adaptor.addChild(root_1, stream_var_decl.nextTree());
						}
						stream_var_decl.reset();

						adaptor.addChild(root_1, stream_seq_com.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:54:4: FUNC type ID LPAR formal RPAR COLON ( var_decl )* seq_com RETURN expr DOT
					{
					FUNC13=(Token)match(input,FUNC,FOLLOW_FUNC_in_proc_decl324);  
					stream_FUNC.add(FUNC13);

					pushFollow(FOLLOW_type_in_proc_decl326);
					type14=type();
					state._fsp--;

					stream_type.add(type14.getTree());
					ID15=(Token)match(input,ID,FOLLOW_ID_in_proc_decl328);  
					stream_ID.add(ID15);

					LPAR16=(Token)match(input,LPAR,FOLLOW_LPAR_in_proc_decl334);  
					stream_LPAR.add(LPAR16);

					pushFollow(FOLLOW_formal_in_proc_decl336);
					formal17=formal();
					state._fsp--;

					stream_formal.add(formal17.getTree());
					RPAR18=(Token)match(input,RPAR,FOLLOW_RPAR_in_proc_decl338);  
					stream_RPAR.add(RPAR18);

					COLON19=(Token)match(input,COLON,FOLLOW_COLON_in_proc_decl340);  
					stream_COLON.add(COLON19);

					// Fun/Fun.g:56:5: ( var_decl )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==BOOL||LA4_0==INT) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// Fun/Fun.g:56:5: var_decl
							{
							pushFollow(FOLLOW_var_decl_in_proc_decl346);
							var_decl20=var_decl();
							state._fsp--;

							stream_var_decl.add(var_decl20.getTree());
							}
							break;

						default :
							break loop4;
						}
					}

					pushFollow(FOLLOW_seq_com_in_proc_decl349);
					seq_com21=seq_com();
					state._fsp--;

					stream_seq_com.add(seq_com21.getTree());
					RETURN22=(Token)match(input,RETURN,FOLLOW_RETURN_in_proc_decl355);  
					stream_RETURN.add(RETURN22);

					pushFollow(FOLLOW_expr_in_proc_decl357);
					expr23=expr();
					state._fsp--;

					stream_expr.add(expr23.getTree());
					DOT24=(Token)match(input,DOT,FOLLOW_DOT_in_proc_decl359);  
					stream_DOT.add(DOT24);

					// AST REWRITE
					// elements: ID, FUNC, type, expr, var_decl, formal, seq_com
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 57:30: -> ^( FUNC type ID formal ( var_decl )* seq_com expr )
					{
						// Fun/Fun.g:57:33: ^( FUNC type ID formal ( var_decl )* seq_com expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_FUNC.nextNode(), root_1);
						adaptor.addChild(root_1, stream_type.nextTree());
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_formal.nextTree());
						// Fun/Fun.g:59:35: ( var_decl )*
						while ( stream_var_decl.hasNext() ) {
							adaptor.addChild(root_1, stream_var_decl.nextTree());
						}
						stream_var_decl.reset();

						adaptor.addChild(root_1, stream_seq_com.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "proc_decl"


	public static class formal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "formal"
	// Fun/Fun.g:63:1: formal : ( type ID -> ^( FORMAL type ID ) | -> NOFORMAL );
	public final FunParser.formal_return formal() throws RecognitionException {
		FunParser.formal_return retval = new FunParser.formal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID26=null;
		ParserRuleReturnScope type25 =null;

		CommonTree ID26_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Fun/Fun.g:64:2: ( type ID -> ^( FORMAL type ID ) | -> NOFORMAL )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==BOOL||LA6_0==INT) ) {
				alt6=1;
			}
			else if ( (LA6_0==RPAR) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// Fun/Fun.g:64:4: type ID
					{
					pushFollow(FOLLOW_type_in_formal501);
					type25=type();
					state._fsp--;

					stream_type.add(type25.getTree());
					ID26=(Token)match(input,ID,FOLLOW_ID_in_formal503);  
					stream_ID.add(ID26);

					// AST REWRITE
					// elements: type, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 64:31: -> ^( FORMAL type ID )
					{
						// Fun/Fun.g:64:34: ^( FORMAL type ID )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL, "FORMAL"), root_1);
						adaptor.addChild(root_1, stream_type.nextTree());
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:65:31: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 65:31: -> NOFORMAL
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NOFORMAL, "NOFORMAL"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formal"


	public static class var_decl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_decl"
	// Fun/Fun.g:68:1: var_decl : type ID ASSN expr -> ^( VAR type ID expr ) ;
	public final FunParser.var_decl_return var_decl() throws RecognitionException {
		FunParser.var_decl_return retval = new FunParser.var_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID28=null;
		Token ASSN29=null;
		ParserRuleReturnScope type27 =null;
		ParserRuleReturnScope expr30 =null;

		CommonTree ID28_tree=null;
		CommonTree ASSN29_tree=null;
		RewriteRuleTokenStream stream_ASSN=new RewriteRuleTokenStream(adaptor,"token ASSN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// Fun/Fun.g:69:2: ( type ID ASSN expr -> ^( VAR type ID expr ) )
			// Fun/Fun.g:69:4: type ID ASSN expr
			{
			pushFollow(FOLLOW_type_in_var_decl577);
			type27=type();
			state._fsp--;

			stream_type.add(type27.getTree());
			ID28=(Token)match(input,ID,FOLLOW_ID_in_var_decl579);  
			stream_ID.add(ID28);

			ASSN29=(Token)match(input,ASSN,FOLLOW_ASSN_in_var_decl581);  
			stream_ASSN.add(ASSN29);

			pushFollow(FOLLOW_expr_in_var_decl583);
			expr30=expr();
			state._fsp--;

			stream_expr.add(expr30.getTree());
			// AST REWRITE
			// elements: expr, ID, type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 69:31: -> ^( VAR type ID expr )
			{
				// Fun/Fun.g:69:34: ^( VAR type ID expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR, "VAR"), root_1);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "var_decl"


	public static class for_var_decl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "for_var_decl"
	// Fun/Fun.g:72:1: for_var_decl : ID ASSN expr -> ^( FORVAR INT ID expr ) ;
	public final FunParser.for_var_decl_return for_var_decl() throws RecognitionException {
		FunParser.for_var_decl_return retval = new FunParser.for_var_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID31=null;
		Token ASSN32=null;
		ParserRuleReturnScope expr33 =null;

		CommonTree ID31_tree=null;
		CommonTree ASSN32_tree=null;
		RewriteRuleTokenStream stream_ASSN=new RewriteRuleTokenStream(adaptor,"token ASSN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Fun/Fun.g:73:2: ( ID ASSN expr -> ^( FORVAR INT ID expr ) )
			// Fun/Fun.g:73:4: ID ASSN expr
			{
			ID31=(Token)match(input,ID,FOLLOW_ID_in_for_var_decl625);  
			stream_ID.add(ID31);

			ASSN32=(Token)match(input,ASSN,FOLLOW_ASSN_in_for_var_decl627);  
			stream_ASSN.add(ASSN32);

			pushFollow(FOLLOW_expr_in_for_var_decl629);
			expr33=expr();
			state._fsp--;

			stream_expr.add(expr33.getTree());
			// AST REWRITE
			// elements: expr, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 73:26: -> ^( FORVAR INT ID expr )
			{
				// Fun/Fun.g:73:29: ^( FORVAR INT ID expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORVAR, "FORVAR"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(INT, "INT"));
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_expr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_var_decl"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// Fun/Fun.g:76:1: type : ( BOOL -> BOOL | INT -> INT );
	public final FunParser.type_return type() throws RecognitionException {
		FunParser.type_return retval = new FunParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BOOL34=null;
		Token INT35=null;

		CommonTree BOOL34_tree=null;
		CommonTree INT35_tree=null;
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
		RewriteRuleTokenStream stream_BOOL=new RewriteRuleTokenStream(adaptor,"token BOOL");

		try {
			// Fun/Fun.g:77:2: ( BOOL -> BOOL | INT -> INT )
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
					// Fun/Fun.g:77:4: BOOL
					{
					BOOL34=(Token)match(input,BOOL,FOLLOW_BOOL_in_type675);  
					stream_BOOL.add(BOOL34);

					// AST REWRITE
					// elements: BOOL
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 77:31: -> BOOL
					{
						adaptor.addChild(root_0, stream_BOOL.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:78:4: INT
					{
					INT35=(Token)match(input,INT,FOLLOW_INT_in_type706);  
					stream_INT.add(INT35);

					// AST REWRITE
					// elements: INT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 78:31: -> INT
					{
						adaptor.addChild(root_0, stream_INT.nextNode());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class com_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "com"
	// Fun/Fun.g:84:1: com : ( ID ASSN expr -> ^( ASSN ID expr ) | ID LPAR actual RPAR -> ^( PROCCALL ID actual ) | IF expr COLON c1= seq_com ( DOT -> ^( IF expr $c1) | ELSE COLON c2= seq_com DOT -> ^( IFELSE expr $c1 $c2) ) | WHILE expr COLON seq_com DOT -> ^( WHILE expr seq_com ) | FOR for_var_decl TO expr COLON seq_com DOT -> ^( FOR for_var_decl expr seq_com ) | REPEAT COLON seq_com UNTIL expr DOT -> ^( REPEAT seq_com expr ) );
	public final FunParser.com_return com() throws RecognitionException {
		FunParser.com_return retval = new FunParser.com_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID36=null;
		Token ASSN37=null;
		Token ID39=null;
		Token LPAR40=null;
		Token RPAR42=null;
		Token IF43=null;
		Token COLON45=null;
		Token DOT46=null;
		Token ELSE47=null;
		Token COLON48=null;
		Token DOT49=null;
		Token WHILE50=null;
		Token COLON52=null;
		Token DOT54=null;
		Token FOR55=null;
		Token TO57=null;
		Token COLON59=null;
		Token DOT61=null;
		Token REPEAT62=null;
		Token COLON63=null;
		Token UNTIL65=null;
		Token DOT67=null;
		ParserRuleReturnScope c1 =null;
		ParserRuleReturnScope c2 =null;
		ParserRuleReturnScope expr38 =null;
		ParserRuleReturnScope actual41 =null;
		ParserRuleReturnScope expr44 =null;
		ParserRuleReturnScope expr51 =null;
		ParserRuleReturnScope seq_com53 =null;
		ParserRuleReturnScope for_var_decl56 =null;
		ParserRuleReturnScope expr58 =null;
		ParserRuleReturnScope seq_com60 =null;
		ParserRuleReturnScope seq_com64 =null;
		ParserRuleReturnScope expr66 =null;

		CommonTree ID36_tree=null;
		CommonTree ASSN37_tree=null;
		CommonTree ID39_tree=null;
		CommonTree LPAR40_tree=null;
		CommonTree RPAR42_tree=null;
		CommonTree IF43_tree=null;
		CommonTree COLON45_tree=null;
		CommonTree DOT46_tree=null;
		CommonTree ELSE47_tree=null;
		CommonTree COLON48_tree=null;
		CommonTree DOT49_tree=null;
		CommonTree WHILE50_tree=null;
		CommonTree COLON52_tree=null;
		CommonTree DOT54_tree=null;
		CommonTree FOR55_tree=null;
		CommonTree TO57_tree=null;
		CommonTree COLON59_tree=null;
		CommonTree DOT61_tree=null;
		CommonTree REPEAT62_tree=null;
		CommonTree COLON63_tree=null;
		CommonTree UNTIL65_tree=null;
		CommonTree DOT67_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_ASSN=new RewriteRuleTokenStream(adaptor,"token ASSN");
		RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
		RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
		RewriteRuleTokenStream stream_REPEAT=new RewriteRuleTokenStream(adaptor,"token REPEAT");
		RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
		RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
		RewriteRuleTokenStream stream_TO=new RewriteRuleTokenStream(adaptor,"token TO");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_UNTIL=new RewriteRuleTokenStream(adaptor,"token UNTIL");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
		RewriteRuleSubtreeStream stream_for_var_decl=new RewriteRuleSubtreeStream(adaptor,"rule for_var_decl");
		RewriteRuleSubtreeStream stream_seq_com=new RewriteRuleSubtreeStream(adaptor,"rule seq_com");
		RewriteRuleSubtreeStream stream_actual=new RewriteRuleSubtreeStream(adaptor,"rule actual");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Fun/Fun.g:85:2: ( ID ASSN expr -> ^( ASSN ID expr ) | ID LPAR actual RPAR -> ^( PROCCALL ID actual ) | IF expr COLON c1= seq_com ( DOT -> ^( IF expr $c1) | ELSE COLON c2= seq_com DOT -> ^( IFELSE expr $c1 $c2) ) | WHILE expr COLON seq_com DOT -> ^( WHILE expr seq_com ) | FOR for_var_decl TO expr COLON seq_com DOT -> ^( FOR for_var_decl expr seq_com ) | REPEAT COLON seq_com UNTIL expr DOT -> ^( REPEAT seq_com expr ) )
			int alt9=6;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA9_1 = input.LA(2);
				if ( (LA9_1==ASSN) ) {
					alt9=1;
				}
				else if ( (LA9_1==LPAR) ) {
					alt9=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IF:
				{
				alt9=3;
				}
				break;
			case WHILE:
				{
				alt9=4;
				}
				break;
			case FOR:
				{
				alt9=5;
				}
				break;
			case REPEAT:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Fun/Fun.g:85:4: ID ASSN expr
					{
					ID36=(Token)match(input,ID,FOLLOW_ID_in_com747);  
					stream_ID.add(ID36);

					ASSN37=(Token)match(input,ASSN,FOLLOW_ASSN_in_com749);  
					stream_ASSN.add(ASSN37);

					pushFollow(FOLLOW_expr_in_com751);
					expr38=expr();
					state._fsp--;

					stream_expr.add(expr38.getTree());
					// AST REWRITE
					// elements: ID, ASSN, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 85:31: -> ^( ASSN ID expr )
					{
						// Fun/Fun.g:85:34: ^( ASSN ID expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:86:4: ID LPAR actual RPAR
					{
					ID39=(Token)match(input,ID,FOLLOW_ID_in_com780);  
					stream_ID.add(ID39);

					LPAR40=(Token)match(input,LPAR,FOLLOW_LPAR_in_com782);  
					stream_LPAR.add(LPAR40);

					pushFollow(FOLLOW_actual_in_com784);
					actual41=actual();
					state._fsp--;

					stream_actual.add(actual41.getTree());
					RPAR42=(Token)match(input,RPAR,FOLLOW_RPAR_in_com786);  
					stream_RPAR.add(RPAR42);

					// AST REWRITE
					// elements: ID, actual
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 86:31: -> ^( PROCCALL ID actual )
					{
						// Fun/Fun.g:86:34: ^( PROCCALL ID actual )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROCCALL, "PROCCALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actual.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// Fun/Fun.g:88:4: IF expr COLON c1= seq_com ( DOT -> ^( IF expr $c1) | ELSE COLON c2= seq_com DOT -> ^( IFELSE expr $c1 $c2) )
					{
					IF43=(Token)match(input,IF,FOLLOW_IF_in_com820);  
					stream_IF.add(IF43);

					pushFollow(FOLLOW_expr_in_com822);
					expr44=expr();
					state._fsp--;

					stream_expr.add(expr44.getTree());
					COLON45=(Token)match(input,COLON,FOLLOW_COLON_in_com824);  
					stream_COLON.add(COLON45);

					pushFollow(FOLLOW_seq_com_in_com828);
					c1=seq_com();
					state._fsp--;

					stream_seq_com.add(c1.getTree());
					// Fun/Fun.g:89:5: ( DOT -> ^( IF expr $c1) | ELSE COLON c2= seq_com DOT -> ^( IFELSE expr $c1 $c2) )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==DOT) ) {
						alt8=1;
					}
					else if ( (LA8_0==ELSE) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// Fun/Fun.g:89:7: DOT
							{
							DOT46=(Token)match(input,DOT,FOLLOW_DOT_in_com836);  
							stream_DOT.add(DOT46);

							// AST REWRITE
							// elements: IF, c1, expr
							// token labels: 
							// rule labels: retval, c1
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_c1=new RewriteRuleSubtreeStream(adaptor,"rule c1",c1!=null?c1.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 89:30: -> ^( IF expr $c1)
							{
								// Fun/Fun.g:89:33: ^( IF expr $c1)
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								adaptor.addChild(root_1, stream_c1.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// Fun/Fun.g:90:7: ELSE COLON c2= seq_com DOT
							{
							ELSE47=(Token)match(input,ELSE,FOLLOW_ELSE_in_com874);  
							stream_ELSE.add(ELSE47);

							COLON48=(Token)match(input,COLON,FOLLOW_COLON_in_com876);  
							stream_COLON.add(COLON48);

							pushFollow(FOLLOW_seq_com_in_com886);
							c2=seq_com();
							state._fsp--;

							stream_seq_com.add(c2.getTree());
							DOT49=(Token)match(input,DOT,FOLLOW_DOT_in_com888);  
							stream_DOT.add(DOT49);

							// AST REWRITE
							// elements: expr, c1, c2
							// token labels: 
							// rule labels: retval, c1, c2
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
							RewriteRuleSubtreeStream stream_c1=new RewriteRuleSubtreeStream(adaptor,"rule c1",c1!=null?c1.getTree():null);
							RewriteRuleSubtreeStream stream_c2=new RewriteRuleSubtreeStream(adaptor,"rule c2",c2!=null?c2.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 91:30: -> ^( IFELSE expr $c1 $c2)
							{
								// Fun/Fun.g:91:33: ^( IFELSE expr $c1 $c2)
								{
								CommonTree root_1 = (CommonTree)adaptor.nil();
								root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IFELSE, "IFELSE"), root_1);
								adaptor.addChild(root_1, stream_expr.nextTree());
								adaptor.addChild(root_1, stream_c1.nextTree());
								adaptor.addChild(root_1, stream_c2.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 4 :
					// Fun/Fun.g:94:4: WHILE expr COLON seq_com DOT
					{
					WHILE50=(Token)match(input,WHILE,FOLLOW_WHILE_in_com955);  
					stream_WHILE.add(WHILE50);

					pushFollow(FOLLOW_expr_in_com957);
					expr51=expr();
					state._fsp--;

					stream_expr.add(expr51.getTree());
					COLON52=(Token)match(input,COLON,FOLLOW_COLON_in_com959);  
					stream_COLON.add(COLON52);

					pushFollow(FOLLOW_seq_com_in_com965);
					seq_com53=seq_com();
					state._fsp--;

					stream_seq_com.add(seq_com53.getTree());
					DOT54=(Token)match(input,DOT,FOLLOW_DOT_in_com967);  
					stream_DOT.add(DOT54);

					// AST REWRITE
					// elements: seq_com, WHILE, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 95:30: -> ^( WHILE expr seq_com )
					{
						// Fun/Fun.g:95:33: ^( WHILE expr seq_com )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_seq_com.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// Fun/Fun.g:96:4: FOR for_var_decl TO expr COLON seq_com DOT
					{
					FOR55=(Token)match(input,FOR,FOLLOW_FOR_in_com995);  
					stream_FOR.add(FOR55);

					pushFollow(FOLLOW_for_var_decl_in_com997);
					for_var_decl56=for_var_decl();
					state._fsp--;

					stream_for_var_decl.add(for_var_decl56.getTree());
					TO57=(Token)match(input,TO,FOLLOW_TO_in_com999);  
					stream_TO.add(TO57);

					pushFollow(FOLLOW_expr_in_com1001);
					expr58=expr();
					state._fsp--;

					stream_expr.add(expr58.getTree());
					COLON59=(Token)match(input,COLON,FOLLOW_COLON_in_com1003);  
					stream_COLON.add(COLON59);

					pushFollow(FOLLOW_seq_com_in_com1015);
					seq_com60=seq_com();
					state._fsp--;

					stream_seq_com.add(seq_com60.getTree());
					DOT61=(Token)match(input,DOT,FOLLOW_DOT_in_com1017);  
					stream_DOT.add(DOT61);

					// AST REWRITE
					// elements: expr, seq_com, FOR, for_var_decl
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 97:30: -> ^( FOR for_var_decl expr seq_com )
					{
						// Fun/Fun.g:97:33: ^( FOR for_var_decl expr seq_com )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);
						adaptor.addChild(root_1, stream_for_var_decl.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_seq_com.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// Fun/Fun.g:98:4: REPEAT COLON seq_com UNTIL expr DOT
					{
					REPEAT62=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_com1049);  
					stream_REPEAT.add(REPEAT62);

					COLON63=(Token)match(input,COLON,FOLLOW_COLON_in_com1051);  
					stream_COLON.add(COLON63);

					pushFollow(FOLLOW_seq_com_in_com1053);
					seq_com64=seq_com();
					state._fsp--;

					stream_seq_com.add(seq_com64.getTree());
					UNTIL65=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_com1055);  
					stream_UNTIL.add(UNTIL65);

					pushFollow(FOLLOW_expr_in_com1057);
					expr66=expr();
					state._fsp--;

					stream_expr.add(expr66.getTree());
					DOT67=(Token)match(input,DOT,FOLLOW_DOT_in_com1059);  
					stream_DOT.add(DOT67);

					// AST REWRITE
					// elements: seq_com, expr, REPEAT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 99:9: -> ^( REPEAT seq_com expr )
					{
						// Fun/Fun.g:99:12: ^( REPEAT seq_com expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_REPEAT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_seq_com.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "com"


	public static class seq_com_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "seq_com"
	// Fun/Fun.g:102:1: seq_com : ( com )* -> ^( SEQ ( com )* ) ;
	public final FunParser.seq_com_return seq_com() throws RecognitionException {
		FunParser.seq_com_return retval = new FunParser.seq_com_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope com68 =null;

		RewriteRuleSubtreeStream stream_com=new RewriteRuleSubtreeStream(adaptor,"rule com");

		try {
			// Fun/Fun.g:103:2: ( ( com )* -> ^( SEQ ( com )* ) )
			// Fun/Fun.g:103:4: ( com )*
			{
			// Fun/Fun.g:103:4: ( com )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==FOR||(LA10_0 >= ID && LA10_0 <= IF)||LA10_0==REPEAT||LA10_0==WHILE) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// Fun/Fun.g:103:4: com
					{
					pushFollow(FOLLOW_com_in_seq_com1096);
					com68=com();
					state._fsp--;

					stream_com.add(com68.getTree());
					}
					break;

				default :
					break loop10;
				}
			}

			// AST REWRITE
			// elements: com
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 103:31: -> ^( SEQ ( com )* )
			{
				// Fun/Fun.g:103:34: ^( SEQ ( com )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SEQ, "SEQ"), root_1);
				// Fun/Fun.g:103:40: ( com )*
				while ( stream_com.hasNext() ) {
					adaptor.addChild(root_1, stream_com.nextTree());
				}
				stream_com.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "seq_com"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Fun/Fun.g:109:1: expr : sec_expr ( ( EQ ^| LT ^| GT ^) sec_expr )? ;
	public final FunParser.expr_return expr() throws RecognitionException {
		FunParser.expr_return retval = new FunParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ70=null;
		Token LT71=null;
		Token GT72=null;
		ParserRuleReturnScope sec_expr69 =null;
		ParserRuleReturnScope sec_expr73 =null;

		CommonTree EQ70_tree=null;
		CommonTree LT71_tree=null;
		CommonTree GT72_tree=null;

		try {
			// Fun/Fun.g:110:2: ( sec_expr ( ( EQ ^| LT ^| GT ^) sec_expr )? )
			// Fun/Fun.g:110:4: sec_expr ( ( EQ ^| LT ^| GT ^) sec_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_sec_expr_in_expr1142);
			sec_expr69=sec_expr();
			state._fsp--;

			adaptor.addChild(root_0, sec_expr69.getTree());

			// Fun/Fun.g:111:5: ( ( EQ ^| LT ^| GT ^) sec_expr )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==EQ||LA12_0==GT||LA12_0==LT) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// Fun/Fun.g:111:7: ( EQ ^| LT ^| GT ^) sec_expr
					{
					// Fun/Fun.g:111:7: ( EQ ^| LT ^| GT ^)
					int alt11=3;
					switch ( input.LA(1) ) {
					case EQ:
						{
						alt11=1;
						}
						break;
					case LT:
						{
						alt11=2;
						}
						break;
					case GT:
						{
						alt11=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}
					switch (alt11) {
						case 1 :
							// Fun/Fun.g:111:8: EQ ^
							{
							EQ70=(Token)match(input,EQ,FOLLOW_EQ_in_expr1151); 
							EQ70_tree = (CommonTree)adaptor.create(EQ70);
							root_0 = (CommonTree)adaptor.becomeRoot(EQ70_tree, root_0);

							}
							break;
						case 2 :
							// Fun/Fun.g:111:14: LT ^
							{
							LT71=(Token)match(input,LT,FOLLOW_LT_in_expr1156); 
							LT71_tree = (CommonTree)adaptor.create(LT71);
							root_0 = (CommonTree)adaptor.becomeRoot(LT71_tree, root_0);

							}
							break;
						case 3 :
							// Fun/Fun.g:111:20: GT ^
							{
							GT72=(Token)match(input,GT,FOLLOW_GT_in_expr1161); 
							GT72_tree = (CommonTree)adaptor.create(GT72);
							root_0 = (CommonTree)adaptor.becomeRoot(GT72_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_sec_expr_in_expr1165);
					sec_expr73=sec_expr();
					state._fsp--;

					adaptor.addChild(root_0, sec_expr73.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class sec_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sec_expr"
	// Fun/Fun.g:114:1: sec_expr : prim_expr ( ( PLUS ^| MINUS ^| TIMES ^| DIV ^) prim_expr )* ;
	public final FunParser.sec_expr_return sec_expr() throws RecognitionException {
		FunParser.sec_expr_return retval = new FunParser.sec_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PLUS75=null;
		Token MINUS76=null;
		Token TIMES77=null;
		Token DIV78=null;
		ParserRuleReturnScope prim_expr74 =null;
		ParserRuleReturnScope prim_expr79 =null;

		CommonTree PLUS75_tree=null;
		CommonTree MINUS76_tree=null;
		CommonTree TIMES77_tree=null;
		CommonTree DIV78_tree=null;

		try {
			// Fun/Fun.g:115:2: ( prim_expr ( ( PLUS ^| MINUS ^| TIMES ^| DIV ^) prim_expr )* )
			// Fun/Fun.g:115:4: prim_expr ( ( PLUS ^| MINUS ^| TIMES ^| DIV ^) prim_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_prim_expr_in_sec_expr1179);
			prim_expr74=prim_expr();
			state._fsp--;

			adaptor.addChild(root_0, prim_expr74.getTree());

			// Fun/Fun.g:116:5: ( ( PLUS ^| MINUS ^| TIMES ^| DIV ^) prim_expr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==DIV||LA14_0==MINUS||LA14_0==PLUS||LA14_0==TIMES) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// Fun/Fun.g:116:7: ( PLUS ^| MINUS ^| TIMES ^| DIV ^) prim_expr
					{
					// Fun/Fun.g:116:7: ( PLUS ^| MINUS ^| TIMES ^| DIV ^)
					int alt13=4;
					switch ( input.LA(1) ) {
					case PLUS:
						{
						alt13=1;
						}
						break;
					case MINUS:
						{
						alt13=2;
						}
						break;
					case TIMES:
						{
						alt13=3;
						}
						break;
					case DIV:
						{
						alt13=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						throw nvae;
					}
					switch (alt13) {
						case 1 :
							// Fun/Fun.g:116:8: PLUS ^
							{
							PLUS75=(Token)match(input,PLUS,FOLLOW_PLUS_in_sec_expr1188); 
							PLUS75_tree = (CommonTree)adaptor.create(PLUS75);
							root_0 = (CommonTree)adaptor.becomeRoot(PLUS75_tree, root_0);

							}
							break;
						case 2 :
							// Fun/Fun.g:116:16: MINUS ^
							{
							MINUS76=(Token)match(input,MINUS,FOLLOW_MINUS_in_sec_expr1193); 
							MINUS76_tree = (CommonTree)adaptor.create(MINUS76);
							root_0 = (CommonTree)adaptor.becomeRoot(MINUS76_tree, root_0);

							}
							break;
						case 3 :
							// Fun/Fun.g:116:25: TIMES ^
							{
							TIMES77=(Token)match(input,TIMES,FOLLOW_TIMES_in_sec_expr1198); 
							TIMES77_tree = (CommonTree)adaptor.create(TIMES77);
							root_0 = (CommonTree)adaptor.becomeRoot(TIMES77_tree, root_0);

							}
							break;
						case 4 :
							// Fun/Fun.g:116:34: DIV ^
							{
							DIV78=(Token)match(input,DIV,FOLLOW_DIV_in_sec_expr1203); 
							DIV78_tree = (CommonTree)adaptor.create(DIV78);
							root_0 = (CommonTree)adaptor.becomeRoot(DIV78_tree, root_0);

							}
							break;

					}

					pushFollow(FOLLOW_prim_expr_in_sec_expr1207);
					prim_expr79=prim_expr();
					state._fsp--;

					adaptor.addChild(root_0, prim_expr79.getTree());

					}
					break;

				default :
					break loop14;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sec_expr"


	public static class prim_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prim_expr"
	// Fun/Fun.g:119:1: prim_expr : ( FALSE -> FALSE | TRUE -> TRUE | NUM -> NUM | ID -> ID | ID LPAR actual RPAR -> ^( FUNCCALL ID actual ) | NOT prim_expr -> ^( NOT prim_expr ) | LPAR expr RPAR -> expr );
	public final FunParser.prim_expr_return prim_expr() throws RecognitionException {
		FunParser.prim_expr_return retval = new FunParser.prim_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FALSE80=null;
		Token TRUE81=null;
		Token NUM82=null;
		Token ID83=null;
		Token ID84=null;
		Token LPAR85=null;
		Token RPAR87=null;
		Token NOT88=null;
		Token LPAR90=null;
		Token RPAR92=null;
		ParserRuleReturnScope actual86 =null;
		ParserRuleReturnScope prim_expr89 =null;
		ParserRuleReturnScope expr91 =null;

		CommonTree FALSE80_tree=null;
		CommonTree TRUE81_tree=null;
		CommonTree NUM82_tree=null;
		CommonTree ID83_tree=null;
		CommonTree ID84_tree=null;
		CommonTree LPAR85_tree=null;
		CommonTree RPAR87_tree=null;
		CommonTree NOT88_tree=null;
		CommonTree LPAR90_tree=null;
		CommonTree RPAR92_tree=null;
		RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
		RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");
		RewriteRuleTokenStream stream_NUM=new RewriteRuleTokenStream(adaptor,"token NUM");
		RewriteRuleSubtreeStream stream_prim_expr=new RewriteRuleSubtreeStream(adaptor,"rule prim_expr");
		RewriteRuleSubtreeStream stream_actual=new RewriteRuleSubtreeStream(adaptor,"rule actual");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Fun/Fun.g:120:2: ( FALSE -> FALSE | TRUE -> TRUE | NUM -> NUM | ID -> ID | ID LPAR actual RPAR -> ^( FUNCCALL ID actual ) | NOT prim_expr -> ^( NOT prim_expr ) | LPAR expr RPAR -> expr )
			int alt15=7;
			switch ( input.LA(1) ) {
			case FALSE:
				{
				alt15=1;
				}
				break;
			case TRUE:
				{
				alt15=2;
				}
				break;
			case NUM:
				{
				alt15=3;
				}
				break;
			case ID:
				{
				int LA15_4 = input.LA(2);
				if ( (LA15_4==LPAR) ) {
					alt15=5;
				}
				else if ( ((LA15_4 >= BOOL && LA15_4 <= COLON)||(LA15_4 >= DIV && LA15_4 <= ELSE)||LA15_4==EQ||LA15_4==FOR||LA15_4==FUNC||(LA15_4 >= GT && LA15_4 <= IF)||LA15_4==INT||(LA15_4 >= LT && LA15_4 <= MINUS)||(LA15_4 >= PLUS && LA15_4 <= PROC)||(LA15_4 >= REPEAT && LA15_4 <= RPAR)||(LA15_4 >= TIMES && LA15_4 <= TO)||LA15_4==UNTIL||LA15_4==WHILE) ) {
					alt15=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NOT:
				{
				alt15=6;
				}
				break;
			case LPAR:
				{
				alt15=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// Fun/Fun.g:120:4: FALSE
					{
					FALSE80=(Token)match(input,FALSE,FOLLOW_FALSE_in_prim_expr1221);  
					stream_FALSE.add(FALSE80);

					// AST REWRITE
					// elements: FALSE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 120:31: -> FALSE
					{
						adaptor.addChild(root_0, stream_FALSE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:121:4: TRUE
					{
					TRUE81=(Token)match(input,TRUE,FOLLOW_TRUE_in_prim_expr1251);  
					stream_TRUE.add(TRUE81);

					// AST REWRITE
					// elements: TRUE
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 121:31: -> TRUE
					{
						adaptor.addChild(root_0, stream_TRUE.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// Fun/Fun.g:122:4: NUM
					{
					NUM82=(Token)match(input,NUM,FOLLOW_NUM_in_prim_expr1282);  
					stream_NUM.add(NUM82);

					// AST REWRITE
					// elements: NUM
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 122:31: -> NUM
					{
						adaptor.addChild(root_0, stream_NUM.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// Fun/Fun.g:123:4: ID
					{
					ID83=(Token)match(input,ID,FOLLOW_ID_in_prim_expr1314);  
					stream_ID.add(ID83);

					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 123:31: -> ID
					{
						adaptor.addChild(root_0, stream_ID.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// Fun/Fun.g:124:4: ID LPAR actual RPAR
					{
					ID84=(Token)match(input,ID,FOLLOW_ID_in_prim_expr1347);  
					stream_ID.add(ID84);

					LPAR85=(Token)match(input,LPAR,FOLLOW_LPAR_in_prim_expr1349);  
					stream_LPAR.add(LPAR85);

					pushFollow(FOLLOW_actual_in_prim_expr1351);
					actual86=actual();
					state._fsp--;

					stream_actual.add(actual86.getTree());
					RPAR87=(Token)match(input,RPAR,FOLLOW_RPAR_in_prim_expr1353);  
					stream_RPAR.add(RPAR87);

					// AST REWRITE
					// elements: actual, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 124:31: -> ^( FUNCCALL ID actual )
					{
						// Fun/Fun.g:124:34: ^( FUNCCALL ID actual )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCCALL, "FUNCCALL"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_actual.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// Fun/Fun.g:126:4: NOT prim_expr
					{
					NOT88=(Token)match(input,NOT,FOLLOW_NOT_in_prim_expr1409);  
					stream_NOT.add(NOT88);

					pushFollow(FOLLOW_prim_expr_in_prim_expr1411);
					prim_expr89=prim_expr();
					state._fsp--;

					stream_prim_expr.add(prim_expr89.getTree());
					// AST REWRITE
					// elements: NOT, prim_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 126:31: -> ^( NOT prim_expr )
					{
						// Fun/Fun.g:126:34: ^( NOT prim_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_prim_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// Fun/Fun.g:127:4: LPAR expr RPAR
					{
					LPAR90=(Token)match(input,LPAR,FOLLOW_LPAR_in_prim_expr1437);  
					stream_LPAR.add(LPAR90);

					pushFollow(FOLLOW_expr_in_prim_expr1439);
					expr91=expr();
					state._fsp--;

					stream_expr.add(expr91.getTree());
					RPAR92=(Token)match(input,RPAR,FOLLOW_RPAR_in_prim_expr1441);  
					stream_RPAR.add(RPAR92);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 127:31: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prim_expr"


	public static class actual_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "actual"
	// Fun/Fun.g:130:1: actual : ( expr -> expr | -> NOACTUAL );
	public final FunParser.actual_return actual() throws RecognitionException {
		FunParser.actual_return retval = new FunParser.actual_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr93 =null;

		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// Fun/Fun.g:131:2: ( expr -> expr | -> NOACTUAL )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==FALSE||LA16_0==ID||LA16_0==LPAR||(LA16_0 >= NOT && LA16_0 <= NUM)||LA16_0==TRUE) ) {
				alt16=1;
			}
			else if ( (LA16_0==RPAR) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// Fun/Fun.g:131:4: expr
					{
					pushFollow(FOLLOW_expr_in_actual1468);
					expr93=expr();
					state._fsp--;

					stream_expr.add(expr93.getTree());
					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 131:31: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// Fun/Fun.g:132:31: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 132:31: -> NOACTUAL
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(NOACTUAL, "NOACTUAL"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "actual"

	// Delegated rules



	public static final BitSet FOLLOW_var_decl_in_program104 = new BitSet(new long[]{0x0000000401040020L});
	public static final BitSet FOLLOW_proc_decl_in_program107 = new BitSet(new long[]{0x0000000400040000L});
	public static final BitSet FOLLOW_EOF_in_program110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROC_in_proc_decl207 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_proc_decl209 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_proc_decl215 = new BitSet(new long[]{0x0000008001000020L});
	public static final BitSet FOLLOW_formal_in_proc_decl217 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_proc_decl219 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_proc_decl221 = new BitSet(new long[]{0x0000802001608420L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl227 = new BitSet(new long[]{0x0000802001608420L});
	public static final BitSet FOLLOW_seq_com_in_proc_decl230 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_proc_decl232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_in_proc_decl324 = new BitSet(new long[]{0x0000000001000020L});
	public static final BitSet FOLLOW_type_in_proc_decl326 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_proc_decl328 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_proc_decl334 = new BitSet(new long[]{0x0000008001000020L});
	public static final BitSet FOLLOW_formal_in_proc_decl336 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_proc_decl338 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_proc_decl340 = new BitSet(new long[]{0x0000806001608020L});
	public static final BitSet FOLLOW_var_decl_in_proc_decl346 = new BitSet(new long[]{0x0000806001608020L});
	public static final BitSet FOLLOW_seq_com_in_proc_decl349 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RETURN_in_proc_decl355 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_proc_decl357 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_proc_decl359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_formal501 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_formal503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_var_decl577 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ID_in_var_decl579 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSN_in_var_decl581 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_var_decl583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_for_var_decl625 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSN_in_for_var_decl627 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_for_var_decl629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_com747 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ASSN_in_com749 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_com751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_com780 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_com782 = new BitSet(new long[]{0x0000108184204000L});
	public static final BitSet FOLLOW_actual_in_com784 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_com786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_com820 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_com822 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_com824 = new BitSet(new long[]{0x0000802000608C00L});
	public static final BitSet FOLLOW_seq_com_in_com828 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_DOT_in_com836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_com874 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_com876 = new BitSet(new long[]{0x0000802000608400L});
	public static final BitSet FOLLOW_seq_com_in_com886 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_com888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_com955 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_com957 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_com959 = new BitSet(new long[]{0x0000802000608400L});
	public static final BitSet FOLLOW_seq_com_in_com965 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_com967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_com995 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_for_var_decl_in_com997 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_TO_in_com999 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_com1001 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_com1003 = new BitSet(new long[]{0x0000802000608400L});
	public static final BitSet FOLLOW_seq_com_in_com1015 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_com1017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REPEAT_in_com1049 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_COLON_in_com1051 = new BitSet(new long[]{0x0000A02000608000L});
	public static final BitSet FOLLOW_seq_com_in_com1053 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_UNTIL_in_com1055 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_com1057 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_com1059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_com_in_seq_com1096 = new BitSet(new long[]{0x0000802000608002L});
	public static final BitSet FOLLOW_sec_expr_in_expr1142 = new BitSet(new long[]{0x0000000008102002L});
	public static final BitSet FOLLOW_EQ_in_expr1151 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_LT_in_expr1156 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_GT_in_expr1161 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_sec_expr_in_expr1165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prim_expr_in_sec_expr1179 = new BitSet(new long[]{0x0000040210000202L});
	public static final BitSet FOLLOW_PLUS_in_sec_expr1188 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_MINUS_in_sec_expr1193 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_TIMES_in_sec_expr1198 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_DIV_in_sec_expr1203 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_prim_expr_in_sec_expr1207 = new BitSet(new long[]{0x0000040210000202L});
	public static final BitSet FOLLOW_FALSE_in_prim_expr1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_prim_expr1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_prim_expr1282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_prim_expr1314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_prim_expr1347 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAR_in_prim_expr1349 = new BitSet(new long[]{0x0000108184204000L});
	public static final BitSet FOLLOW_actual_in_prim_expr1351 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_prim_expr1353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_prim_expr1409 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_prim_expr_in_prim_expr1411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_prim_expr1437 = new BitSet(new long[]{0x0000100184204000L});
	public static final BitSet FOLLOW_expr_in_prim_expr1439 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RPAR_in_prim_expr1441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_actual1468 = new BitSet(new long[]{0x0000000000000002L});
}
