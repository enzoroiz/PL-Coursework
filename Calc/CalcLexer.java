// $ANTLR 3.5.2 Calc/Calc.g 2014-11-03 19:03:55

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ASSN=4;
	public static final int DIVIDED=5;
	public static final int EOL=6;
	public static final int ID=7;
	public static final int LPAR=8;
	public static final int MINUS=9;
	public static final int NUM=10;
	public static final int PLUS=11;
	public static final int PUT=12;
	public static final int RPAR=13;
	public static final int SET=14;
	public static final int SPACE=15;
	public static final int TIMES=16;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public CalcLexer() {} 
	public CalcLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Calc/Calc.g"; }

	// $ANTLR start "PUT"
	public final void mPUT() throws RecognitionException {
		try {
			int _type = PUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:46:5: ( 'put' )
			// Calc/Calc.g:46:7: 'put'
			{
			match("put"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUT"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:47:5: ( 'set' )
			// Calc/Calc.g:47:7: 'set'
			{
			match("set"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "ASSN"
	public final void mASSN() throws RecognitionException {
		try {
			int _type = ASSN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:49:6: ( '=' )
			// Calc/Calc.g:49:8: '='
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

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:50:6: ( '+' )
			// Calc/Calc.g:50:8: '+'
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
			// Calc/Calc.g:51:7: ( '-' )
			// Calc/Calc.g:51:9: '-'
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
			// Calc/Calc.g:52:7: ( '*' )
			// Calc/Calc.g:52:9: '*'
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

	// $ANTLR start "DIVIDED"
	public final void mDIVIDED() throws RecognitionException {
		try {
			int _type = DIVIDED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:53:9: ( '/' )
			// Calc/Calc.g:53:11: '/'
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
	// $ANTLR end "DIVIDED"

	// $ANTLR start "LPAR"
	public final void mLPAR() throws RecognitionException {
		try {
			int _type = LPAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:54:6: ( '(' )
			// Calc/Calc.g:54:8: '('
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
			// Calc/Calc.g:55:6: ( ')' )
			// Calc/Calc.g:55:8: ')'
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

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:57:4: ( 'a' .. 'z' )
			// Calc/Calc.g:
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
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

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:58:5: ( ( '0' .. '9' )+ )
			// Calc/Calc.g:58:7: ( '0' .. '9' )+
			{
			// Calc/Calc.g:58:7: ( '0' .. '9' )+
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
					// Calc/Calc.g:
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

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:60:5: ( ( '\\r' )? '\\n' )
			// Calc/Calc.g:60:7: ( '\\r' )? '\\n'
			{
			// Calc/Calc.g:60:7: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// Calc/Calc.g:60:7: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "SPACE"
	public final void mSPACE() throws RecognitionException {
		try {
			int _type = SPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Calc/Calc.g:62:7: ( ( ' ' | '\\t' )+ )
			// Calc/Calc.g:62:9: ( ' ' | '\\t' )+
			{
			// Calc/Calc.g:62:9: ( ' ' | '\\t' )+
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
					// Calc/Calc.g:
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

	@Override
	public void mTokens() throws RecognitionException {
		// Calc/Calc.g:1:8: ( PUT | SET | ASSN | PLUS | MINUS | TIMES | DIVIDED | LPAR | RPAR | ID | NUM | EOL | SPACE )
		int alt4=13;
		switch ( input.LA(1) ) {
		case 'p':
			{
			int LA4_1 = input.LA(2);
			if ( (LA4_1=='u') ) {
				alt4=1;
			}

			else {
				alt4=10;
			}

			}
			break;
		case 's':
			{
			int LA4_2 = input.LA(2);
			if ( (LA4_2=='e') ) {
				alt4=2;
			}

			else {
				alt4=10;
			}

			}
			break;
		case '=':
			{
			alt4=3;
			}
			break;
		case '+':
			{
			alt4=4;
			}
			break;
		case '-':
			{
			alt4=5;
			}
			break;
		case '*':
			{
			alt4=6;
			}
			break;
		case '/':
			{
			alt4=7;
			}
			break;
		case '(':
			{
			alt4=8;
			}
			break;
		case ')':
			{
			alt4=9;
			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'q':
		case 'r':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt4=10;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt4=11;
			}
			break;
		case '\n':
		case '\r':
			{
			alt4=12;
			}
			break;
		case '\t':
		case ' ':
			{
			alt4=13;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// Calc/Calc.g:1:10: PUT
				{
				mPUT(); 

				}
				break;
			case 2 :
				// Calc/Calc.g:1:14: SET
				{
				mSET(); 

				}
				break;
			case 3 :
				// Calc/Calc.g:1:18: ASSN
				{
				mASSN(); 

				}
				break;
			case 4 :
				// Calc/Calc.g:1:23: PLUS
				{
				mPLUS(); 

				}
				break;
			case 5 :
				// Calc/Calc.g:1:28: MINUS
				{
				mMINUS(); 

				}
				break;
			case 6 :
				// Calc/Calc.g:1:34: TIMES
				{
				mTIMES(); 

				}
				break;
			case 7 :
				// Calc/Calc.g:1:40: DIVIDED
				{
				mDIVIDED(); 

				}
				break;
			case 8 :
				// Calc/Calc.g:1:48: LPAR
				{
				mLPAR(); 

				}
				break;
			case 9 :
				// Calc/Calc.g:1:53: RPAR
				{
				mRPAR(); 

				}
				break;
			case 10 :
				// Calc/Calc.g:1:58: ID
				{
				mID(); 

				}
				break;
			case 11 :
				// Calc/Calc.g:1:61: NUM
				{
				mNUM(); 

				}
				break;
			case 12 :
				// Calc/Calc.g:1:65: EOL
				{
				mEOL(); 

				}
				break;
			case 13 :
				// Calc/Calc.g:1:69: SPACE
				{
				mSPACE(); 

				}
				break;

		}
	}



}
