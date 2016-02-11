// $ANTLR 3.5.2 Fun/Fun.g 2014-11-25 11:24:32

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FunLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FunLexer() {} 
	public FunLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FunLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Fun/Fun.g"; }

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:138:6: ( 'bool' )
			// Fun/Fun.g:138:8: 'bool'
			{
			match("bool"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:139:6: ( 'else' )
			// Fun/Fun.g:139:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:140:7: ( 'false' )
			// Fun/Fun.g:140:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "FUNC"
	public final void mFUNC() throws RecognitionException {
		try {
			int _type = FUNC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:141:6: ( 'func' )
			// Fun/Fun.g:141:8: 'func'
			{
			match("func"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNC"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:142:4: ( 'if' )
			// Fun/Fun.g:142:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:143:5: ( 'int' )
			// Fun/Fun.g:143:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "PROC"
	public final void mPROC() throws RecognitionException {
		try {
			int _type = PROC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:144:6: ( 'proc' )
			// Fun/Fun.g:144:8: 'proc'
			{
			match("proc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROC"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:145:8: ( 'return' )
			// Fun/Fun.g:145:10: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:146:6: ( 'true' )
			// Fun/Fun.g:146:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:147:7: ( 'while' )
			// Fun/Fun.g:147:9: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:148:5: ( 'for' )
			// Fun/Fun.g:148:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "TO"
	public final void mTO() throws RecognitionException {
		try {
			int _type = TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:149:4: ( 'to' )
			// Fun/Fun.g:149:6: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TO"

	// $ANTLR start "REPEAT"
	public final void mREPEAT() throws RecognitionException {
		try {
			int _type = REPEAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:150:9: ( 'repeat' )
			// Fun/Fun.g:150:11: 'repeat'
			{
			match("repeat"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REPEAT"

	// $ANTLR start "UNTIL"
	public final void mUNTIL() throws RecognitionException {
		try {
			int _type = UNTIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:151:9: ( 'until' )
			// Fun/Fun.g:151:11: 'until'
			{
			match("until"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNTIL"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:153:4: ( '==' )
			// Fun/Fun.g:153:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:154:4: ( '<' )
			// Fun/Fun.g:154:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:155:4: ( '>' )
			// Fun/Fun.g:155:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:156:6: ( '+' )
			// Fun/Fun.g:156:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:157:7: ( '-' )
			// Fun/Fun.g:157:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "TIMES"
	public final void mTIMES() throws RecognitionException {
		try {
			int _type = TIMES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:158:7: ( '*' )
			// Fun/Fun.g:158:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMES"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:159:5: ( '/' )
			// Fun/Fun.g:159:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:160:5: ( 'not' )
			// Fun/Fun.g:160:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "ASSN"
	public final void mASSN() throws RecognitionException {
		try {
			int _type = ASSN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:162:6: ( '=' )
			// Fun/Fun.g:162:8: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSN"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:164:6: ( '(' )
			// Fun/Fun.g:164:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAR"

	// $ANTLR start "RPAR"
	public final void mRPAR() throws RecognitionException {
		try {
			int _type = RPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:165:6: ( ')' )
			// Fun/Fun.g:165:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAR"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:166:7: ( ':' )
			// Fun/Fun.g:166:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:167:5: ( '.' )
			// Fun/Fun.g:167:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:169:5: ( ( DIGIT )+ )
			// Fun/Fun.g:169:7: ( DIGIT )+
			{
			// Fun/Fun.g:169:7: ( DIGIT )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Fun/Fun.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:171:4: ( LETTER ( LETTER | DIGIT )* )
			// Fun/Fun.g:171:6: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// Fun/Fun.g:171:13: ( LETTER | DIGIT )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Fun/Fun.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "SPACE"
	public final void mSPACE() throws RecognitionException {
		try {
			int _type = SPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:173:7: ( ( ' ' | '\\t' )+ )
			// Fun/Fun.g:173:9: ( ' ' | '\\t' )+
			{
			// Fun/Fun.g:173:9: ( ' ' | '\\t' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\t'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Fun/Fun.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPACE"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:174:5: ( ( '\\r' )? '\\n' )
			// Fun/Fun.g:174:7: ( '\\r' )? '\\n'
			{
			// Fun/Fun.g:174:7: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// Fun/Fun.g:174:7: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Fun/Fun.g:175:9: ( '#' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n' )
			// Fun/Fun.g:175:11: '#' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n'
			{
			match('#'); 
			// Fun/Fun.g:175:15: (~ ( '\\r' | '\\n' ) )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Fun/Fun.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			// Fun/Fun.g:176:5: ( '\\r' )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='\r') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// Fun/Fun.g:176:5: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// Fun/Fun.g:178:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// Fun/Fun.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// Fun/Fun.g:179:17: ( '0' .. '9' )
			// Fun/Fun.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	@Override
	public void mTokens() throws RecognitionException {
		// Fun/Fun.g:1:8: ( BOOL | ELSE | FALSE | FUNC | IF | INT | PROC | RETURN | TRUE | WHILE | FOR | TO | REPEAT | UNTIL | EQ | LT | GT | PLUS | MINUS | TIMES | DIV | NOT | ASSN | LPAR | RPAR | COLON | DOT | NUM | ID | SPACE | EOL | COMMENT )
		int alt7=32;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// Fun/Fun.g:1:10: BOOL
				{
				mBOOL(); 

				}
				break;
			case 2 :
				// Fun/Fun.g:1:15: ELSE
				{
				mELSE(); 

				}
				break;
			case 3 :
				// Fun/Fun.g:1:20: FALSE
				{
				mFALSE(); 

				}
				break;
			case 4 :
				// Fun/Fun.g:1:26: FUNC
				{
				mFUNC(); 

				}
				break;
			case 5 :
				// Fun/Fun.g:1:31: IF
				{
				mIF(); 

				}
				break;
			case 6 :
				// Fun/Fun.g:1:34: INT
				{
				mINT(); 

				}
				break;
			case 7 :
				// Fun/Fun.g:1:38: PROC
				{
				mPROC(); 

				}
				break;
			case 8 :
				// Fun/Fun.g:1:43: RETURN
				{
				mRETURN(); 

				}
				break;
			case 9 :
				// Fun/Fun.g:1:50: TRUE
				{
				mTRUE(); 

				}
				break;
			case 10 :
				// Fun/Fun.g:1:55: WHILE
				{
				mWHILE(); 

				}
				break;
			case 11 :
				// Fun/Fun.g:1:61: FOR
				{
				mFOR(); 

				}
				break;
			case 12 :
				// Fun/Fun.g:1:65: TO
				{
				mTO(); 

				}
				break;
			case 13 :
				// Fun/Fun.g:1:68: REPEAT
				{
				mREPEAT(); 

				}
				break;
			case 14 :
				// Fun/Fun.g:1:75: UNTIL
				{
				mUNTIL(); 

				}
				break;
			case 15 :
				// Fun/Fun.g:1:81: EQ
				{
				mEQ(); 

				}
				break;
			case 16 :
				// Fun/Fun.g:1:84: LT
				{
				mLT(); 

				}
				break;
			case 17 :
				// Fun/Fun.g:1:87: GT
				{
				mGT(); 

				}
				break;
			case 18 :
				// Fun/Fun.g:1:90: PLUS
				{
				mPLUS(); 

				}
				break;
			case 19 :
				// Fun/Fun.g:1:95: MINUS
				{
				mMINUS(); 

				}
				break;
			case 20 :
				// Fun/Fun.g:1:101: TIMES
				{
				mTIMES(); 

				}
				break;
			case 21 :
				// Fun/Fun.g:1:107: DIV
				{
				mDIV(); 

				}
				break;
			case 22 :
				// Fun/Fun.g:1:111: NOT
				{
				mNOT(); 

				}
				break;
			case 23 :
				// Fun/Fun.g:1:115: ASSN
				{
				mASSN(); 

				}
				break;
			case 24 :
				// Fun/Fun.g:1:120: LPAR
				{
				mLPAR(); 

				}
				break;
			case 25 :
				// Fun/Fun.g:1:125: RPAR
				{
				mRPAR(); 

				}
				break;
			case 26 :
				// Fun/Fun.g:1:130: COLON
				{
				mCOLON(); 

				}
				break;
			case 27 :
				// Fun/Fun.g:1:136: DOT
				{
				mDOT(); 

				}
				break;
			case 28 :
				// Fun/Fun.g:1:140: NUM
				{
				mNUM(); 

				}
				break;
			case 29 :
				// Fun/Fun.g:1:144: ID
				{
				mID(); 

				}
				break;
			case 30 :
				// Fun/Fun.g:1:147: SPACE
				{
				mSPACE(); 

				}
				break;
			case 31 :
				// Fun/Fun.g:1:153: EOL
				{
				mEOL(); 

				}
				break;
			case 32 :
				// Fun/Fun.g:1:157: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\11\27\1\51\6\uffff\1\27\11\uffff\5\27\1\60\4\27\1\66\2\27\2\uffff"+
		"\5\27\1\76\1\uffff\1\77\4\27\1\uffff\2\27\1\106\1\107\1\110\1\27\1\112"+
		"\2\uffff\1\113\2\27\1\116\2\27\3\uffff\1\121\2\uffff\2\27\1\uffff\1\124"+
		"\1\125\1\uffff\1\126\1\127\4\uffff";
	static final String DFA7_eofS =
		"\130\uffff";
	static final String DFA7_minS =
		"\1\11\1\157\1\154\1\141\1\146\1\162\1\145\1\157\1\150\1\156\1\75\6\uffff"+
		"\1\157\11\uffff\1\157\1\163\1\154\1\156\1\162\1\60\1\164\1\157\1\160\1"+
		"\165\1\60\1\151\1\164\2\uffff\1\164\1\154\1\145\1\163\1\143\1\60\1\uffff"+
		"\1\60\1\143\1\165\2\145\1\uffff\1\154\1\151\3\60\1\145\1\60\2\uffff\1"+
		"\60\1\162\1\141\1\60\1\145\1\154\3\uffff\1\60\2\uffff\1\156\1\164\1\uffff"+
		"\2\60\1\uffff\2\60\4\uffff";
	static final String DFA7_maxS =
		"\1\172\1\157\1\154\1\165\1\156\1\162\1\145\1\162\1\150\1\156\1\75\6\uffff"+
		"\1\157\11\uffff\1\157\1\163\1\154\1\156\1\162\1\172\1\164\1\157\1\164"+
		"\1\165\1\172\1\151\1\164\2\uffff\1\164\1\154\1\145\1\163\1\143\1\172\1"+
		"\uffff\1\172\1\143\1\165\2\145\1\uffff\1\154\1\151\3\172\1\145\1\172\2"+
		"\uffff\1\172\1\162\1\141\1\172\1\145\1\154\3\uffff\1\172\2\uffff\1\156"+
		"\1\164\1\uffff\2\172\1\uffff\2\172\4\uffff";
	static final String DFA7_acceptS =
		"\13\uffff\1\20\1\21\1\22\1\23\1\24\1\25\1\uffff\1\30\1\31\1\32\1\33\1"+
		"\34\1\35\1\36\1\37\1\40\15\uffff\1\17\1\27\6\uffff\1\5\5\uffff\1\14\7"+
		"\uffff\1\13\1\6\6\uffff\1\26\1\1\1\2\1\uffff\1\4\1\7\2\uffff\1\11\2\uffff"+
		"\1\3\2\uffff\1\12\1\16\1\10\1\15";
	static final String DFA7_specialS =
		"\130\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\30\1\31\2\uffff\1\31\22\uffff\1\30\2\uffff\1\32\4\uffff\1\22\1\23"+
			"\1\17\1\15\1\uffff\1\16\1\25\1\20\12\26\1\24\1\uffff\1\13\1\12\1\14\2"+
			"\uffff\32\27\6\uffff\1\27\1\1\2\27\1\2\1\3\2\27\1\4\4\27\1\21\1\27\1"+
			"\5\1\27\1\6\1\27\1\7\1\11\1\27\1\10\3\27",
			"\1\33",
			"\1\34",
			"\1\35\15\uffff\1\37\5\uffff\1\36",
			"\1\40\7\uffff\1\41",
			"\1\42",
			"\1\43",
			"\1\45\2\uffff\1\44",
			"\1\46",
			"\1\47",
			"\1\50",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\52",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\61",
			"\1\62",
			"\1\64\3\uffff\1\63",
			"\1\65",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\67",
			"\1\70",
			"",
			"",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"",
			"\1\104",
			"\1\105",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\111",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\114",
			"\1\115",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\1\117",
			"\1\120",
			"",
			"",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"\1\122",
			"\1\123",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"\12\27\7\uffff\32\27\6\uffff\32\27",
			"",
			"",
			"",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( BOOL | ELSE | FALSE | FUNC | IF | INT | PROC | RETURN | TRUE | WHILE | FOR | TO | REPEAT | UNTIL | EQ | LT | GT | PLUS | MINUS | TIMES | DIV | NOT | ASSN | LPAR | RPAR | COLON | DOT | NUM | ID | SPACE | EOL | COMMENT );";
		}
	}

}
