package com.intuit.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.intuit.dsl.services.ExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'||'", "'&&'", "'and'", "'or'", "'<'", "'>'", "'<='", "'>='", "'in'", "'not_in'", "'['", "','", "']'", "'=='", "'!='", "'=~'", "'!~'", "'is'", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'null'", "'true'", "'false'", "'if'", "'then'", "'else'", "'('", "')'", "'.'", "'parent('", "'last('", "'delete('", "'split('", "'contains('", "'extract('", "'dateFormat'", "'\"MM/dd/yyyy\"'", "'\"yyyyMMdd\"'", "'\"yyyy-MM-dd\"'", "'\"ms\"'", "'addToDate'", "'Days'", "'filter('", "'findFirst'", "'remove'", "'sort('", "'dedup('", "'ascending'", "'descending'", "'map('", "'{'", "'}'", "'as'", "'->'", "'..'", "'='", "'concat('", "'length('", "'lowerCase('", "'upperCase('", "'uuid()'", "'json('", "'join('", "'dayDifference('", "'translateUnicode('", "'currentDate('", "'pickFirst('", "'::'", "'@Config('", "'length'", "'filter'", "'delete'", "'path'", "'it'", "'field'", "'default'", "'template'", "'uuid'", "'parent'", "'json'", "'join'", "'translateUnicode'", "'upperCase'", "'lowerCase'", "'concat'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExpression.g"; }



     	private ExpressionGrammarAccess grammarAccess;

        public InternalExpressionParser(TokenStream input, ExpressionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Expression";
       	}

       	@Override
       	protected ExpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExpression"
    // InternalExpression.g:64:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExpression.g:64:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalExpression.g:65:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalExpression.g:71:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:77:2: (this_BooleanExpression_0= ruleBooleanExpression )
            // InternalExpression.g:78:2: this_BooleanExpression_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_BooleanExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalExpression.g:89:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalExpression.g:89:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalExpression.g:90:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalExpression.g:96:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:102:2: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalExpression.g:103:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalExpression.g:103:2: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalExpression.g:104:3: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_3);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:112:3: ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=11 && LA2_0<=14)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpression.g:113:4: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalExpression.g:113:4: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) ) )
            	    // InternalExpression.g:114:5: () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) )
            	    {
            	    // InternalExpression.g:114:5: ()
            	    // InternalExpression.g:115:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getBooleanExpressionAccess().getBooleanExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:121:5: ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) ) )
            	    // InternalExpression.g:122:6: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) )
            	    {
            	    // InternalExpression.g:122:6: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' ) )
            	    // InternalExpression.g:123:7: (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' )
            	    {
            	    // InternalExpression.g:123:7: (lv_op_2_1= '||' | lv_op_2_2= '&&' | lv_op_2_3= 'and' | lv_op_2_4= 'or' )
            	    int alt1=4;
            	    switch ( input.LA(1) ) {
            	    case 11:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case 12:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case 13:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    case 14:
            	        {
            	        alt1=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // InternalExpression.g:124:8: lv_op_2_1= '||'
            	            {
            	            lv_op_2_1=(Token)match(input,11,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:135:8: lv_op_2_2= '&&'
            	            {
            	            lv_op_2_2=(Token)match(input,12,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalExpression.g:146:8: lv_op_2_3= 'and'
            	            {
            	            lv_op_2_3=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_3, grammarAccess.getBooleanExpressionAccess().getOpAndKeyword_1_0_1_0_2());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalExpression.g:157:8: lv_op_2_4= 'or'
            	            {
            	            lv_op_2_4=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_4, grammarAccess.getBooleanExpressionAccess().getOpOrKeyword_1_0_1_0_3());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalExpression.g:171:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalExpression.g:172:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalExpression.g:172:5: (lv_right_3_0= ruleComparison )
            	    // InternalExpression.g:173:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.intuit.dsl.Expression.Comparison");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleComparison"
    // InternalExpression.g:195:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalExpression.g:195:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalExpression.g:196:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalExpression.g:202:1: ruleComparison returns [EObject current=null] : (this_Membership_0= ruleMembership ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Membership_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:208:2: ( (this_Membership_0= ruleMembership ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )* ) )
            // InternalExpression.g:209:2: (this_Membership_0= ruleMembership ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )* )
            {
            // InternalExpression.g:209:2: (this_Membership_0= ruleMembership ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )* )
            // InternalExpression.g:210:3: this_Membership_0= ruleMembership ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getMembershipParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_5);
            this_Membership_0=ruleMembership();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Membership_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:218:3: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=15 && LA4_0<=18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExpression.g:219:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) ) ( (lv_right_3_0= ruleMembership ) )
            	    {
            	    // InternalExpression.g:219:4: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) ) )
            	    // InternalExpression.g:220:5: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    {
            	    // InternalExpression.g:220:5: ()
            	    // InternalExpression.g:221:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:227:5: ( ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) ) )
            	    // InternalExpression.g:228:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalExpression.g:228:6: ( (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' ) )
            	    // InternalExpression.g:229:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    {
            	    // InternalExpression.g:229:7: (lv_op_2_1= '<' | lv_op_2_2= '>' | lv_op_2_3= '<=' | lv_op_2_4= '>=' )
            	    int alt3=4;
            	    switch ( input.LA(1) ) {
            	    case 15:
            	        {
            	        alt3=1;
            	        }
            	        break;
            	    case 16:
            	        {
            	        alt3=2;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt3=3;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt3=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // InternalExpression.g:230:8: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:241:8: lv_op_2_2= '>'
            	            {
            	            lv_op_2_2=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalExpression.g:252:8: lv_op_2_3= '<='
            	            {
            	            lv_op_2_3=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_0_1_0_2());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalExpression.g:263:8: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1_0_3());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getComparisonRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalExpression.g:277:4: ( (lv_right_3_0= ruleMembership ) )
            	    // InternalExpression.g:278:5: (lv_right_3_0= ruleMembership )
            	    {
            	    // InternalExpression.g:278:5: (lv_right_3_0= ruleMembership )
            	    // InternalExpression.g:279:6: lv_right_3_0= ruleMembership
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightMembershipParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_right_3_0=ruleMembership();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.intuit.dsl.Expression.Membership");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleMembership"
    // InternalExpression.g:301:1: entryRuleMembership returns [EObject current=null] : iv_ruleMembership= ruleMembership EOF ;
    public final EObject entryRuleMembership() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMembership = null;


        try {
            // InternalExpression.g:301:51: (iv_ruleMembership= ruleMembership EOF )
            // InternalExpression.g:302:2: iv_ruleMembership= ruleMembership EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMembershipRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMembership=ruleMembership();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMembership; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMembership"


    // $ANTLR start "ruleMembership"
    // InternalExpression.g:308:1: ruleMembership returns [EObject current=null] : (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )* ) ;
    public final EObject ruleMembership() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject this_Equals_0 = null;

        EObject lv_right_4_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:314:2: ( (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )* ) )
            // InternalExpression.g:315:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )* )
            {
            // InternalExpression.g:315:2: (this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )* )
            // InternalExpression.g:316:3: this_Equals_0= ruleEquals ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMembershipAccess().getEqualsParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_6);
            this_Equals_0=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Equals_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:324:3: ( ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalExpression.g:325:4: ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) ) otherlv_3= '[' ( (lv_right_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )* otherlv_7= ']'
            	    {
            	    // InternalExpression.g:325:4: ( () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) ) )
            	    // InternalExpression.g:326:5: () ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) )
            	    {
            	    // InternalExpression.g:326:5: ()
            	    // InternalExpression.g:327:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMembershipAccess().getMembershipLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:333:5: ( ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) ) )
            	    // InternalExpression.g:334:6: ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) )
            	    {
            	    // InternalExpression.g:334:6: ( (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' ) )
            	    // InternalExpression.g:335:7: (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' )
            	    {
            	    // InternalExpression.g:335:7: (lv_op_2_1= 'in' | lv_op_2_2= 'not_in' )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==19) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==20) ) {
            	        alt5=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalExpression.g:336:8: lv_op_2_1= 'in'
            	            {
            	            lv_op_2_1=(Token)match(input,19,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMembershipAccess().getOpInKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMembershipRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:347:8: lv_op_2_2= 'not_in'
            	            {
            	            lv_op_2_2=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMembershipAccess().getOpNot_inKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMembershipRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    otherlv_3=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getMembershipAccess().getLeftSquareBracketKeyword_1_1());
            	      			
            	    }
            	    // InternalExpression.g:365:4: ( (lv_right_4_0= ruleExpression ) )
            	    // InternalExpression.g:366:5: (lv_right_4_0= ruleExpression )
            	    {
            	    // InternalExpression.g:366:5: (lv_right_4_0= ruleExpression )
            	    // InternalExpression.g:367:6: lv_right_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMembershipAccess().getRightExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_right_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMembershipRule());
            	      						}
            	      						add(
            	      							current,
            	      							"right",
            	      							lv_right_4_0,
            	      							"com.intuit.dsl.Expression.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalExpression.g:384:4: (otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==22) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalExpression.g:385:5: otherlv_5= ',' ( (lv_right_6_0= ruleExpression ) )
            	    	    {
            	    	    otherlv_5=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(otherlv_5, grammarAccess.getMembershipAccess().getCommaKeyword_1_3_0());
            	    	      				
            	    	    }
            	    	    // InternalExpression.g:389:5: ( (lv_right_6_0= ruleExpression ) )
            	    	    // InternalExpression.g:390:6: (lv_right_6_0= ruleExpression )
            	    	    {
            	    	    // InternalExpression.g:390:6: (lv_right_6_0= ruleExpression )
            	    	    // InternalExpression.g:391:7: lv_right_6_0= ruleExpression
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getMembershipAccess().getRightExpressionParserRuleCall_1_3_1_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_right_6_0=ruleExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getMembershipRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"right",
            	    	      								lv_right_6_0,
            	    	      								"com.intuit.dsl.Expression.Expression");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    otherlv_7=(Token)match(input,23,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_7, grammarAccess.getMembershipAccess().getRightSquareBracketKeyword_1_4());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMembership"


    // $ANTLR start "entryRuleEquals"
    // InternalExpression.g:418:1: entryRuleEquals returns [EObject current=null] : iv_ruleEquals= ruleEquals EOF ;
    public final EObject entryRuleEquals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquals = null;


        try {
            // InternalExpression.g:418:47: (iv_ruleEquals= ruleEquals EOF )
            // InternalExpression.g:419:2: iv_ruleEquals= ruleEquals EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquals=ruleEquals();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquals; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquals"


    // $ANTLR start "ruleEquals"
    // InternalExpression.g:425:1: ruleEquals returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleEquals() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        Token lv_op_2_5=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:431:2: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalExpression.g:432:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalExpression.g:432:2: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalExpression.g:433:3: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualsAccess().getAdditionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_9);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Addition_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:441:3: ( ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=24 && LA9_0<=28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalExpression.g:442:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalExpression.g:442:4: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) ) )
            	    // InternalExpression.g:443:5: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) )
            	    {
            	    // InternalExpression.g:443:5: ()
            	    // InternalExpression.g:444:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getEqualsAccess().getEqualsLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:450:5: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) ) )
            	    // InternalExpression.g:451:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) )
            	    {
            	    // InternalExpression.g:451:6: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' ) )
            	    // InternalExpression.g:452:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' )
            	    {
            	    // InternalExpression.g:452:7: (lv_op_2_1= '==' | lv_op_2_2= '!=' | lv_op_2_3= '=~' | lv_op_2_4= '!~' | lv_op_2_5= 'is' )
            	    int alt8=5;
            	    switch ( input.LA(1) ) {
            	    case 24:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    case 27:
            	        {
            	        alt8=4;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt8=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // InternalExpression.g:453:8: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getEqualsAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:464:8: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getEqualsAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalExpression.g:475:8: lv_op_2_3= '=~'
            	            {
            	            lv_op_2_3=(Token)match(input,26,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_3, grammarAccess.getEqualsAccess().getOpEqualsSignTildeKeyword_1_0_1_0_2());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalExpression.g:486:8: lv_op_2_4= '!~'
            	            {
            	            lv_op_2_4=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_4, grammarAccess.getEqualsAccess().getOpExclamationMarkTildeKeyword_1_0_1_0_3());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // InternalExpression.g:497:8: lv_op_2_5= 'is'
            	            {
            	            lv_op_2_5=(Token)match(input,28,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_5, grammarAccess.getEqualsAccess().getOpIsKeyword_1_0_1_0_4());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getEqualsRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_5, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalExpression.g:511:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalExpression.g:512:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalExpression.g:512:5: (lv_right_3_0= ruleAddition )
            	    // InternalExpression.g:513:6: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualsAccess().getRightAdditionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualsRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.intuit.dsl.Expression.Addition");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquals"


    // $ANTLR start "entryRuleAddition"
    // InternalExpression.g:535:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalExpression.g:535:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalExpression.g:536:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalExpression.g:542:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:548:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalExpression.g:549:2: (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalExpression.g:549:2: (this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalExpression.g:550:3: this_Multiplication_0= ruleMultiplication ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_10);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Multiplication_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:558:3: ( ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) && (synpred1_InternalExpression())) {
                    alt11=1;
                }
                else if ( (LA11_0==30) && (synpred1_InternalExpression())) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalExpression.g:559:4: ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalExpression.g:559:4: ( ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) )
            	    // InternalExpression.g:560:5: ( ( ( () '+' ) | ( () '-' ) ) )=> ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    {
            	    // InternalExpression.g:574:5: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==29) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==30) ) {
            	        alt10=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalExpression.g:575:6: ( () otherlv_2= '+' )
            	            {
            	            // InternalExpression.g:575:6: ( () otherlv_2= '+' )
            	            // InternalExpression.g:576:7: () otherlv_2= '+'
            	            {
            	            // InternalExpression.g:576:7: ()
            	            // InternalExpression.g:577:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_2=(Token)match(input,29,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_0_1());
            	              						
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:589:6: ( () otherlv_4= '-' )
            	            {
            	            // InternalExpression.g:589:6: ( () otherlv_4= '-' )
            	            // InternalExpression.g:590:7: () otherlv_4= '-'
            	            {
            	            // InternalExpression.g:590:7: ()
            	            // InternalExpression.g:591:8: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              								current = forceCreateModelElementAndSet(
            	              									grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_0_1_0(),
            	              									current);
            	              							
            	            }

            	            }

            	            otherlv_4=(Token)match(input,30,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_0_1_1());
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }

            	    // InternalExpression.g:604:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalExpression.g:605:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalExpression.g:605:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalExpression.g:606:6: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_10);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"com.intuit.dsl.Expression.Multiplication");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalExpression.g:628:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalExpression.g:628:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalExpression.g:629:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalExpression.g:635:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:641:2: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // InternalExpression.g:642:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // InternalExpression.g:642:2: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // InternalExpression.g:643:3: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_11);
            this_Prefixed_0=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Prefixed_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:651:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=31 && LA13_0<=33)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalExpression.g:652:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // InternalExpression.g:652:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) ) )
            	    // InternalExpression.g:653:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
            	    {
            	    // InternalExpression.g:653:5: ()
            	    // InternalExpression.g:654:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMultiplicationAccess().getMultiOrDivOrModLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:660:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) ) )
            	    // InternalExpression.g:661:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
            	    {
            	    // InternalExpression.g:661:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' ) )
            	    // InternalExpression.g:662:7: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
            	    {
            	    // InternalExpression.g:662:7: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= '%' )
            	    int alt12=3;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt12=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt12=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt12=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt12) {
            	        case 1 :
            	            // InternalExpression.g:663:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:674:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,32,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalExpression.g:685:8: lv_op_2_3= '%'
            	            {
            	            lv_op_2_3=(Token)match(input,33,FOLLOW_4); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_3, grammarAccess.getMultiplicationAccess().getOpPercentSignKeyword_1_0_1_0_2());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMultiplicationRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalExpression.g:699:4: ( (lv_right_3_0= rulePrefixed ) )
            	    // InternalExpression.g:700:5: (lv_right_3_0= rulePrefixed )
            	    {
            	    // InternalExpression.g:700:5: (lv_right_3_0= rulePrefixed )
            	    // InternalExpression.g:701:6: lv_right_3_0= rulePrefixed
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_right_3_0=rulePrefixed();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.intuit.dsl.Expression.Prefixed");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrefixed"
    // InternalExpression.g:723:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // InternalExpression.g:723:49: (iv_rulePrefixed= rulePrefixed EOF )
            // InternalExpression.g:724:2: iv_rulePrefixed= rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefixed=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixed; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // InternalExpression.g:730:1: rulePrefixed returns [EObject current=null] : ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;



        	enterRule();

        try {
            // InternalExpression.g:736:2: ( ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // InternalExpression.g:737:2: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // InternalExpression.g:737:2: ( ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt14=1;
                }
                break;
            case 30:
                {
                alt14=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 21:
            case 35:
            case 36:
            case 37:
            case 38:
            case 41:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 55:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 64:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalExpression.g:738:3: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // InternalExpression.g:738:3: ( () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) ) )
                    // InternalExpression.g:739:4: () otherlv_1= '!' ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // InternalExpression.g:739:4: ()
                    // InternalExpression.g:740:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                      			
                    }
                    // InternalExpression.g:750:4: ( (lv_expression_2_0= ruleAtomic ) )
                    // InternalExpression.g:751:5: (lv_expression_2_0= ruleAtomic )
                    {
                    // InternalExpression.g:751:5: (lv_expression_2_0= ruleAtomic )
                    // InternalExpression.g:752:6: lv_expression_2_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"com.intuit.dsl.Expression.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:771:3: ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // InternalExpression.g:771:3: ( () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) ) )
                    // InternalExpression.g:772:4: () otherlv_4= '-' ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // InternalExpression.g:772:4: ()
                    // InternalExpression.g:773:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,30,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                      			
                    }
                    // InternalExpression.g:783:4: ( (lv_expression_5_0= ruleAtomic ) )
                    // InternalExpression.g:784:5: (lv_expression_5_0= ruleAtomic )
                    {
                    // InternalExpression.g:784:5: (lv_expression_5_0= ruleAtomic )
                    // InternalExpression.g:785:6: lv_expression_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_5_0,
                      							"com.intuit.dsl.Expression.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalExpression.g:804:3: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Atomic_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // InternalExpression.g:816:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalExpression.g:816:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalExpression.g:817:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalExpression.g:823:1: ruleAtomic returns [EObject current=null] : (this_LiteralExpression_0= ruleLiteralExpression | this_TernaryExpression_1= ruleTernaryExpression | this_ArrayExpression_2= ruleArrayExpression | this_ParenthesizedExpression_3= ruleParenthesizedExpression | ( () ( (lv_ref_5_0= ruleFunction ) ) ) | ( () ( (lv_ref_7_0= ruleVariable ) ) ) | ( () ( (lv_ref_9_0= ruleProperty ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralExpression_0 = null;

        EObject this_TernaryExpression_1 = null;

        EObject this_ArrayExpression_2 = null;

        EObject this_ParenthesizedExpression_3 = null;

        EObject lv_ref_5_0 = null;

        EObject lv_ref_7_0 = null;

        EObject lv_ref_9_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:829:2: ( (this_LiteralExpression_0= ruleLiteralExpression | this_TernaryExpression_1= ruleTernaryExpression | this_ArrayExpression_2= ruleArrayExpression | this_ParenthesizedExpression_3= ruleParenthesizedExpression | ( () ( (lv_ref_5_0= ruleFunction ) ) ) | ( () ( (lv_ref_7_0= ruleVariable ) ) ) | ( () ( (lv_ref_9_0= ruleProperty ) ) ) ) )
            // InternalExpression.g:830:2: (this_LiteralExpression_0= ruleLiteralExpression | this_TernaryExpression_1= ruleTernaryExpression | this_ArrayExpression_2= ruleArrayExpression | this_ParenthesizedExpression_3= ruleParenthesizedExpression | ( () ( (lv_ref_5_0= ruleFunction ) ) ) | ( () ( (lv_ref_7_0= ruleVariable ) ) ) | ( () ( (lv_ref_9_0= ruleProperty ) ) ) )
            {
            // InternalExpression.g:830:2: (this_LiteralExpression_0= ruleLiteralExpression | this_TernaryExpression_1= ruleTernaryExpression | this_ArrayExpression_2= ruleArrayExpression | this_ParenthesizedExpression_3= ruleParenthesizedExpression | ( () ( (lv_ref_5_0= ruleFunction ) ) ) | ( () ( (lv_ref_7_0= ruleVariable ) ) ) | ( () ( (lv_ref_9_0= ruleProperty ) ) ) )
            int alt15=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case 35:
            case 36:
            case 37:
                {
                alt15=1;
                }
                break;
            case 38:
                {
                alt15=2;
                }
                break;
            case 21:
                {
                alt15=3;
                }
                break;
            case 41:
                {
                alt15=4;
                }
                break;
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 55:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 64:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                {
                alt15=5;
                }
                break;
            case RULE_ID:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt15=6;
                }
                break;
            case 83:
                {
                alt15=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalExpression.g:831:3: this_LiteralExpression_0= ruleLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getLiteralExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralExpression_0=ruleLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:840:3: this_TernaryExpression_1= ruleTernaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getTernaryExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TernaryExpression_1=ruleTernaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TernaryExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:849:3: this_ArrayExpression_2= ruleArrayExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getArrayExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayExpression_2=ruleArrayExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:858:3: this_ParenthesizedExpression_3= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getParenthesizedExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_3=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParenthesizedExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:867:3: ( () ( (lv_ref_5_0= ruleFunction ) ) )
                    {
                    // InternalExpression.g:867:3: ( () ( (lv_ref_5_0= ruleFunction ) ) )
                    // InternalExpression.g:868:4: () ( (lv_ref_5_0= ruleFunction ) )
                    {
                    // InternalExpression.g:868:4: ()
                    // InternalExpression.g:869:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getFunctionReferenceAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:875:4: ( (lv_ref_5_0= ruleFunction ) )
                    // InternalExpression.g:876:5: (lv_ref_5_0= ruleFunction )
                    {
                    // InternalExpression.g:876:5: (lv_ref_5_0= ruleFunction )
                    // InternalExpression.g:877:6: lv_ref_5_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getRefFunctionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_ref_5_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"ref",
                      							lv_ref_5_0,
                      							"com.intuit.dsl.Expression.Function");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalExpression.g:896:3: ( () ( (lv_ref_7_0= ruleVariable ) ) )
                    {
                    // InternalExpression.g:896:3: ( () ( (lv_ref_7_0= ruleVariable ) ) )
                    // InternalExpression.g:897:4: () ( (lv_ref_7_0= ruleVariable ) )
                    {
                    // InternalExpression.g:897:4: ()
                    // InternalExpression.g:898:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getVariableReferenceAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:904:4: ( (lv_ref_7_0= ruleVariable ) )
                    // InternalExpression.g:905:5: (lv_ref_7_0= ruleVariable )
                    {
                    // InternalExpression.g:905:5: (lv_ref_7_0= ruleVariable )
                    // InternalExpression.g:906:6: lv_ref_7_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getRefVariableParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_ref_7_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"ref",
                      							lv_ref_7_0,
                      							"com.intuit.dsl.Expression.Variable");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalExpression.g:925:3: ( () ( (lv_ref_9_0= ruleProperty ) ) )
                    {
                    // InternalExpression.g:925:3: ( () ( (lv_ref_9_0= ruleProperty ) ) )
                    // InternalExpression.g:926:4: () ( (lv_ref_9_0= ruleProperty ) )
                    {
                    // InternalExpression.g:926:4: ()
                    // InternalExpression.g:927:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getPropertyExpresssionAction_6_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:933:4: ( (lv_ref_9_0= ruleProperty ) )
                    // InternalExpression.g:934:5: (lv_ref_9_0= ruleProperty )
                    {
                    // InternalExpression.g:934:5: (lv_ref_9_0= ruleProperty )
                    // InternalExpression.g:935:6: lv_ref_9_0= ruleProperty
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicAccess().getRefPropertyParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_ref_9_0=ruleProperty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicRule());
                      						}
                      						set(
                      							current,
                      							"ref",
                      							lv_ref_9_0,
                      							"com.intuit.dsl.Expression.Property");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalExpression.g:957:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalExpression.g:957:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalExpression.g:958:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalExpression.g:964:1: ruleLiteralExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= 'null' ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_3_0=null;
        Token lv_value_5_0=null;
        Token lv_value_7_1=null;
        Token lv_value_7_2=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:970:2: ( ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= 'null' ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) ) )
            // InternalExpression.g:971:2: ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= 'null' ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) )
            {
            // InternalExpression.g:971:2: ( ( () ( (lv_value_1_0= ruleNUMBER ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= 'null' ) ) ) | ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt17=1;
                }
                break;
            case RULE_STRING:
                {
                alt17=2;
                }
                break;
            case 35:
                {
                alt17=3;
                }
                break;
            case 36:
            case 37:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalExpression.g:972:3: ( () ( (lv_value_1_0= ruleNUMBER ) ) )
                    {
                    // InternalExpression.g:972:3: ( () ( (lv_value_1_0= ruleNUMBER ) ) )
                    // InternalExpression.g:973:4: () ( (lv_value_1_0= ruleNUMBER ) )
                    {
                    // InternalExpression.g:973:4: ()
                    // InternalExpression.g:974:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralExpressionAccess().getNumberLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:980:4: ( (lv_value_1_0= ruleNUMBER ) )
                    // InternalExpression.g:981:5: (lv_value_1_0= ruleNUMBER )
                    {
                    // InternalExpression.g:981:5: (lv_value_1_0= ruleNUMBER )
                    // InternalExpression.g:982:6: lv_value_1_0= ruleNUMBER
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLiteralExpressionAccess().getValueNUMBERParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_1_0=ruleNUMBER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLiteralExpressionRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"com.intuit.dsl.Expression.NUMBER");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:1001:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalExpression.g:1001:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalExpression.g:1002:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalExpression.g:1002:4: ()
                    // InternalExpression.g:1003:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralExpressionAccess().getStringLiteralAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:1009:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalExpression.g:1010:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalExpression.g:1010:5: (lv_value_3_0= RULE_STRING )
                    // InternalExpression.g:1011:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalExpression.g:1029:3: ( () ( (lv_value_5_0= 'null' ) ) )
                    {
                    // InternalExpression.g:1029:3: ( () ( (lv_value_5_0= 'null' ) ) )
                    // InternalExpression.g:1030:4: () ( (lv_value_5_0= 'null' ) )
                    {
                    // InternalExpression.g:1030:4: ()
                    // InternalExpression.g:1031:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralExpressionAccess().getNullLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:1037:4: ( (lv_value_5_0= 'null' ) )
                    // InternalExpression.g:1038:5: (lv_value_5_0= 'null' )
                    {
                    // InternalExpression.g:1038:5: (lv_value_5_0= 'null' )
                    // InternalExpression.g:1039:6: lv_value_5_0= 'null'
                    {
                    lv_value_5_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_5_0, grammarAccess.getLiteralExpressionAccess().getValueNullKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getLiteralExpressionRule());
                      						}
                      						setWithLastConsumed(current, "value", lv_value_5_0, "null");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalExpression.g:1053:3: ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) )
                    {
                    // InternalExpression.g:1053:3: ( () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) ) )
                    // InternalExpression.g:1054:4: () ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) )
                    {
                    // InternalExpression.g:1054:4: ()
                    // InternalExpression.g:1055:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLiteralExpressionAccess().getBooleanLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:1061:4: ( ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) ) )
                    // InternalExpression.g:1062:5: ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) )
                    {
                    // InternalExpression.g:1062:5: ( (lv_value_7_1= 'true' | lv_value_7_2= 'false' ) )
                    // InternalExpression.g:1063:6: (lv_value_7_1= 'true' | lv_value_7_2= 'false' )
                    {
                    // InternalExpression.g:1063:6: (lv_value_7_1= 'true' | lv_value_7_2= 'false' )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==36) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==37) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalExpression.g:1064:7: lv_value_7_1= 'true'
                            {
                            lv_value_7_1=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_7_1, grammarAccess.getLiteralExpressionAccess().getValueTrueKeyword_3_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLiteralExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_7_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalExpression.g:1075:7: lv_value_7_2= 'false'
                            {
                            lv_value_7_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_7_2, grammarAccess.getLiteralExpressionAccess().getValueFalseKeyword_3_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getLiteralExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_7_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleTernaryExpression"
    // InternalExpression.g:1093:1: entryRuleTernaryExpression returns [EObject current=null] : iv_ruleTernaryExpression= ruleTernaryExpression EOF ;
    public final EObject entryRuleTernaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTernaryExpression = null;


        try {
            // InternalExpression.g:1093:58: (iv_ruleTernaryExpression= ruleTernaryExpression EOF )
            // InternalExpression.g:1094:2: iv_ruleTernaryExpression= ruleTernaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTernaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTernaryExpression=ruleTernaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTernaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTernaryExpression"


    // $ANTLR start "ruleTernaryExpression"
    // InternalExpression.g:1100:1: ruleTernaryExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_expression_1_0= ruleBooleanExpression ) ) otherlv_2= 'then' ( (lv_truevalue_3_0= ruleAtomic ) ) ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )? ) ;
    public final EObject ruleTernaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_1_0 = null;

        EObject lv_truevalue_3_0 = null;

        EObject lv_falsevalue_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1106:2: ( (otherlv_0= 'if' ( (lv_expression_1_0= ruleBooleanExpression ) ) otherlv_2= 'then' ( (lv_truevalue_3_0= ruleAtomic ) ) ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )? ) )
            // InternalExpression.g:1107:2: (otherlv_0= 'if' ( (lv_expression_1_0= ruleBooleanExpression ) ) otherlv_2= 'then' ( (lv_truevalue_3_0= ruleAtomic ) ) ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )? )
            {
            // InternalExpression.g:1107:2: (otherlv_0= 'if' ( (lv_expression_1_0= ruleBooleanExpression ) ) otherlv_2= 'then' ( (lv_truevalue_3_0= ruleAtomic ) ) ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )? )
            // InternalExpression.g:1108:3: otherlv_0= 'if' ( (lv_expression_1_0= ruleBooleanExpression ) ) otherlv_2= 'then' ( (lv_truevalue_3_0= ruleAtomic ) ) ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTernaryExpressionAccess().getIfKeyword_0());
              		
            }
            // InternalExpression.g:1112:3: ( (lv_expression_1_0= ruleBooleanExpression ) )
            // InternalExpression.g:1113:4: (lv_expression_1_0= ruleBooleanExpression )
            {
            // InternalExpression.g:1113:4: (lv_expression_1_0= ruleBooleanExpression )
            // InternalExpression.g:1114:5: lv_expression_1_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTernaryExpressionAccess().getExpressionBooleanExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_expression_1_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTernaryExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"com.intuit.dsl.Expression.BooleanExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTernaryExpressionAccess().getThenKeyword_2());
              		
            }
            // InternalExpression.g:1135:3: ( (lv_truevalue_3_0= ruleAtomic ) )
            // InternalExpression.g:1136:4: (lv_truevalue_3_0= ruleAtomic )
            {
            // InternalExpression.g:1136:4: (lv_truevalue_3_0= ruleAtomic )
            // InternalExpression.g:1137:5: lv_truevalue_3_0= ruleAtomic
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTernaryExpressionAccess().getTruevalueAtomicParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_truevalue_3_0=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTernaryExpressionRule());
              					}
              					set(
              						current,
              						"truevalue",
              						lv_truevalue_3_0,
              						"com.intuit.dsl.Expression.Atomic");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:1154:3: ( ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred2_InternalExpression()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // InternalExpression.g:1155:4: ( ( 'else' )=>otherlv_4= 'else' ) ( (lv_falsevalue_5_0= ruleAtomic ) )
                    {
                    // InternalExpression.g:1155:4: ( ( 'else' )=>otherlv_4= 'else' )
                    // InternalExpression.g:1156:5: ( 'else' )=>otherlv_4= 'else'
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getTernaryExpressionAccess().getElseKeyword_4_0());
                      				
                    }

                    }

                    // InternalExpression.g:1162:4: ( (lv_falsevalue_5_0= ruleAtomic ) )
                    // InternalExpression.g:1163:5: (lv_falsevalue_5_0= ruleAtomic )
                    {
                    // InternalExpression.g:1163:5: (lv_falsevalue_5_0= ruleAtomic )
                    // InternalExpression.g:1164:6: lv_falsevalue_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTernaryExpressionAccess().getFalsevalueAtomicParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_falsevalue_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTernaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"falsevalue",
                      							lv_falsevalue_5_0,
                      							"com.intuit.dsl.Expression.Atomic");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTernaryExpression"


    // $ANTLR start "entryRuleArrayExpression"
    // InternalExpression.g:1186:1: entryRuleArrayExpression returns [EObject current=null] : iv_ruleArrayExpression= ruleArrayExpression EOF ;
    public final EObject entryRuleArrayExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayExpression = null;


        try {
            // InternalExpression.g:1186:56: (iv_ruleArrayExpression= ruleArrayExpression EOF )
            // InternalExpression.g:1187:2: iv_ruleArrayExpression= ruleArrayExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayExpression=ruleArrayExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayExpression"


    // $ANTLR start "ruleArrayExpression"
    // InternalExpression.g:1193:1: ruleArrayExpression returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_expression_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleArrayExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1199:2: ( ( () otherlv_1= '[' ( (lv_expression_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )* otherlv_5= ']' ) )
            // InternalExpression.g:1200:2: ( () otherlv_1= '[' ( (lv_expression_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )* otherlv_5= ']' )
            {
            // InternalExpression.g:1200:2: ( () otherlv_1= '[' ( (lv_expression_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )* otherlv_5= ']' )
            // InternalExpression.g:1201:3: () otherlv_1= '[' ( (lv_expression_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )* otherlv_5= ']'
            {
            // InternalExpression.g:1201:3: ()
            // InternalExpression.g:1202:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayExpressionAccess().getArrayExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayExpressionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalExpression.g:1212:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalExpression.g:1213:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalExpression.g:1213:4: (lv_expression_2_0= ruleExpression )
            // InternalExpression.g:1214:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArrayExpressionAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArrayExpressionRule());
              					}
              					add(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:1231:3: (otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==22) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalExpression.g:1232:4: otherlv_3= ',' ( (lv_expression_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getArrayExpressionAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalExpression.g:1236:4: ( (lv_expression_4_0= ruleExpression ) )
            	    // InternalExpression.g:1237:5: (lv_expression_4_0= ruleExpression )
            	    {
            	    // InternalExpression.g:1237:5: (lv_expression_4_0= ruleExpression )
            	    // InternalExpression.g:1238:6: lv_expression_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getArrayExpressionAccess().getExpressionExpressionParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_expression_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getArrayExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expression",
            	      							lv_expression_4_0,
            	      							"com.intuit.dsl.Expression.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getArrayExpressionAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalExpression.g:1264:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalExpression.g:1264:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalExpression.g:1265:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalExpression.g:1271:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;



        	enterRule();

        try {
            // InternalExpression.g:1277:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // InternalExpression.g:1278:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // InternalExpression.g:1278:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // InternalExpression.g:1279:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_14);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleFunction"
    // InternalExpression.g:1299:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalExpression.g:1299:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalExpression.g:1300:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalExpression.g:1306:1: ruleFunction returns [EObject current=null] : (this_CollectionFunction_0= ruleCollectionFunction | this_Join_1= ruleJoin | this_Length_2= ruleLength | this_DateFormat_3= ruleDateFormat | this_Delete_4= ruleDelete | this_Contains_5= ruleContains | this_DayDifference_6= ruleDayDifference | this_CurrentDate_7= ruleCurrentDate | this_PickFirst_8= rulePickFirst | this_Extract_9= ruleExtract | this_TranslateUnicode_10= ruleTranslateUnicode | this_AddToDate_11= ruleAddToDate | this_UUIDFunc_12= ruleUUIDFunc | this_LowerFunc_13= ruleLowerFunc | this_UpperFunc_14= ruleUpperFunc ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_CollectionFunction_0 = null;

        EObject this_Join_1 = null;

        EObject this_Length_2 = null;

        EObject this_DateFormat_3 = null;

        EObject this_Delete_4 = null;

        EObject this_Contains_5 = null;

        EObject this_DayDifference_6 = null;

        EObject this_CurrentDate_7 = null;

        EObject this_PickFirst_8 = null;

        EObject this_Extract_9 = null;

        EObject this_TranslateUnicode_10 = null;

        EObject this_AddToDate_11 = null;

        EObject this_UUIDFunc_12 = null;

        EObject this_LowerFunc_13 = null;

        EObject this_UpperFunc_14 = null;



        	enterRule();

        try {
            // InternalExpression.g:1312:2: ( (this_CollectionFunction_0= ruleCollectionFunction | this_Join_1= ruleJoin | this_Length_2= ruleLength | this_DateFormat_3= ruleDateFormat | this_Delete_4= ruleDelete | this_Contains_5= ruleContains | this_DayDifference_6= ruleDayDifference | this_CurrentDate_7= ruleCurrentDate | this_PickFirst_8= rulePickFirst | this_Extract_9= ruleExtract | this_TranslateUnicode_10= ruleTranslateUnicode | this_AddToDate_11= ruleAddToDate | this_UUIDFunc_12= ruleUUIDFunc | this_LowerFunc_13= ruleLowerFunc | this_UpperFunc_14= ruleUpperFunc ) )
            // InternalExpression.g:1313:2: (this_CollectionFunction_0= ruleCollectionFunction | this_Join_1= ruleJoin | this_Length_2= ruleLength | this_DateFormat_3= ruleDateFormat | this_Delete_4= ruleDelete | this_Contains_5= ruleContains | this_DayDifference_6= ruleDayDifference | this_CurrentDate_7= ruleCurrentDate | this_PickFirst_8= rulePickFirst | this_Extract_9= ruleExtract | this_TranslateUnicode_10= ruleTranslateUnicode | this_AddToDate_11= ruleAddToDate | this_UUIDFunc_12= ruleUUIDFunc | this_LowerFunc_13= ruleLowerFunc | this_UpperFunc_14= ruleUpperFunc )
            {
            // InternalExpression.g:1313:2: (this_CollectionFunction_0= ruleCollectionFunction | this_Join_1= ruleJoin | this_Length_2= ruleLength | this_DateFormat_3= ruleDateFormat | this_Delete_4= ruleDelete | this_Contains_5= ruleContains | this_DayDifference_6= ruleDayDifference | this_CurrentDate_7= ruleCurrentDate | this_PickFirst_8= rulePickFirst | this_Extract_9= ruleExtract | this_TranslateUnicode_10= ruleTranslateUnicode | this_AddToDate_11= ruleAddToDate | this_UUIDFunc_12= ruleUUIDFunc | this_LowerFunc_13= ruleLowerFunc | this_UpperFunc_14= ruleUpperFunc )
            int alt20=15;
            switch ( input.LA(1) ) {
            case 44:
            case 45:
            case 47:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 64:
            case 71:
            case 76:
                {
                alt20=1;
                }
                break;
            case 77:
                {
                alt20=2;
                }
                break;
            case 72:
                {
                alt20=3;
                }
                break;
            case 50:
                {
                alt20=4;
                }
                break;
            case 46:
                {
                alt20=5;
                }
                break;
            case 48:
                {
                alt20=6;
                }
                break;
            case 78:
                {
                alt20=7;
                }
                break;
            case 80:
                {
                alt20=8;
                }
                break;
            case 81:
                {
                alt20=9;
                }
                break;
            case 49:
                {
                alt20=10;
                }
                break;
            case 79:
                {
                alt20=11;
                }
                break;
            case 55:
                {
                alt20=12;
                }
                break;
            case 75:
                {
                alt20=13;
                }
                break;
            case 73:
                {
                alt20=14;
                }
                break;
            case 74:
                {
                alt20=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalExpression.g:1314:3: this_CollectionFunction_0= ruleCollectionFunction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getCollectionFunctionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CollectionFunction_0=ruleCollectionFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CollectionFunction_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1323:3: this_Join_1= ruleJoin
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getJoinParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Join_1=ruleJoin();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Join_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:1332:3: this_Length_2= ruleLength
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getLengthParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Length_2=ruleLength();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Length_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:1341:3: this_DateFormat_3= ruleDateFormat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getDateFormatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DateFormat_3=ruleDateFormat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DateFormat_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:1350:3: this_Delete_4= ruleDelete
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getDeleteParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Delete_4=ruleDelete();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Delete_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpression.g:1359:3: this_Contains_5= ruleContains
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getContainsParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Contains_5=ruleContains();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Contains_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExpression.g:1368:3: this_DayDifference_6= ruleDayDifference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getDayDifferenceParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DayDifference_6=ruleDayDifference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DayDifference_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExpression.g:1377:3: this_CurrentDate_7= ruleCurrentDate
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getCurrentDateParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CurrentDate_7=ruleCurrentDate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CurrentDate_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExpression.g:1386:3: this_PickFirst_8= rulePickFirst
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getPickFirstParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PickFirst_8=rulePickFirst();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PickFirst_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalExpression.g:1395:3: this_Extract_9= ruleExtract
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getExtractParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Extract_9=ruleExtract();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Extract_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalExpression.g:1404:3: this_TranslateUnicode_10= ruleTranslateUnicode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getTranslateUnicodeParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TranslateUnicode_10=ruleTranslateUnicode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TranslateUnicode_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalExpression.g:1413:3: this_AddToDate_11= ruleAddToDate
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getAddToDateParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AddToDate_11=ruleAddToDate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AddToDate_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalExpression.g:1422:3: this_UUIDFunc_12= ruleUUIDFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getUUIDFuncParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UUIDFunc_12=ruleUUIDFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UUIDFunc_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalExpression.g:1431:3: this_LowerFunc_13= ruleLowerFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getLowerFuncParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LowerFunc_13=ruleLowerFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LowerFunc_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalExpression.g:1440:3: this_UpperFunc_14= ruleUpperFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFunctionAccess().getUpperFuncParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UpperFunc_14=ruleUpperFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UpperFunc_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleCollectionFunction"
    // InternalExpression.g:1452:1: entryRuleCollectionFunction returns [EObject current=null] : iv_ruleCollectionFunction= ruleCollectionFunction EOF ;
    public final EObject entryRuleCollectionFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunction = null;


        try {
            // InternalExpression.g:1452:59: (iv_ruleCollectionFunction= ruleCollectionFunction EOF )
            // InternalExpression.g:1453:2: iv_ruleCollectionFunction= ruleCollectionFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectionFunction=ruleCollectionFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionFunction"


    // $ANTLR start "ruleCollectionFunction"
    // InternalExpression.g:1459:1: ruleCollectionFunction returns [EObject current=null] : ( ( (lv_function_0_0= ruleCollectionFunctionCall ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )? (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )* ) ;
    public final EObject ruleCollectionFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_function_0_0 = null;

        EObject lv_refexp_2_0 = null;

        EObject lv_resultKey_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1465:2: ( ( ( (lv_function_0_0= ruleCollectionFunctionCall ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )? (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )* ) )
            // InternalExpression.g:1466:2: ( ( (lv_function_0_0= ruleCollectionFunctionCall ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )? (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )* )
            {
            // InternalExpression.g:1466:2: ( ( (lv_function_0_0= ruleCollectionFunctionCall ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )? (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )* )
            // InternalExpression.g:1467:3: ( (lv_function_0_0= ruleCollectionFunctionCall ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )? (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )*
            {
            // InternalExpression.g:1467:3: ( (lv_function_0_0= ruleCollectionFunctionCall ) )
            // InternalExpression.g:1468:4: (lv_function_0_0= ruleCollectionFunctionCall )
            {
            // InternalExpression.g:1468:4: (lv_function_0_0= ruleCollectionFunctionCall )
            // InternalExpression.g:1469:5: lv_function_0_0= ruleCollectionFunctionCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCollectionFunctionAccess().getFunctionCollectionFunctionCallParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_function_0_0=ruleCollectionFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
              					}
              					set(
              						current,
              						"function",
              						lv_function_0_0,
              						"com.intuit.dsl.Expression.CollectionFunctionCall");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:1486:3: ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) && (synpred3_InternalExpression())) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalExpression.g:1487:4: ( ( '[' )=>otherlv_1= '[' ) ( (lv_refexp_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    // InternalExpression.g:1487:4: ( ( '[' )=>otherlv_1= '[' )
                    // InternalExpression.g:1488:5: ( '[' )=>otherlv_1= '['
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getCollectionFunctionAccess().getLeftSquareBracketKeyword_1_0());
                      				
                    }

                    }

                    // InternalExpression.g:1494:4: ( (lv_refexp_2_0= ruleExpression ) )
                    // InternalExpression.g:1495:5: (lv_refexp_2_0= ruleExpression )
                    {
                    // InternalExpression.g:1495:5: (lv_refexp_2_0= ruleExpression )
                    // InternalExpression.g:1496:6: lv_refexp_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCollectionFunctionAccess().getRefexpExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_refexp_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                      						}
                      						set(
                      							current,
                      							"refexp",
                      							lv_refexp_2_0,
                      							"com.intuit.dsl.Expression.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCollectionFunctionAccess().getRightSquareBracketKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalExpression.g:1518:3: (otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==43) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalExpression.g:1519:4: otherlv_4= '.' ( (lv_resultKey_5_0= ruleKey ) )
            	    {
            	    otherlv_4=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getCollectionFunctionAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    // InternalExpression.g:1523:4: ( (lv_resultKey_5_0= ruleKey ) )
            	    // InternalExpression.g:1524:5: (lv_resultKey_5_0= ruleKey )
            	    {
            	    // InternalExpression.g:1524:5: (lv_resultKey_5_0= ruleKey )
            	    // InternalExpression.g:1525:6: lv_resultKey_5_0= ruleKey
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCollectionFunctionAccess().getResultKeyKeyParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_resultKey_5_0=ruleKey();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"resultKey",
            	      							lv_resultKey_5_0,
            	      							"com.intuit.dsl.Expression.Key");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionFunction"


    // $ANTLR start "entryRuleCollectionFunctionCall"
    // InternalExpression.g:1547:1: entryRuleCollectionFunctionCall returns [EObject current=null] : iv_ruleCollectionFunctionCall= ruleCollectionFunctionCall EOF ;
    public final EObject entryRuleCollectionFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunctionCall = null;


        try {
            // InternalExpression.g:1547:63: (iv_ruleCollectionFunctionCall= ruleCollectionFunctionCall EOF )
            // InternalExpression.g:1548:2: iv_ruleCollectionFunctionCall= ruleCollectionFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCollectionFunctionCall=ruleCollectionFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionFunctionCall"


    // $ANTLR start "ruleCollectionFunctionCall"
    // InternalExpression.g:1554:1: ruleCollectionFunctionCall returns [EObject current=null] : (this_RemoveFunc_0= ruleRemoveFunc | this_FindFirstFunc_1= ruleFindFirstFunc | this_FilterFunc_2= ruleFilterFunc | this_MapFunc_3= ruleMapFunc | this_Split_4= ruleSplit | this_Json_5= ruleJson | this_ConcatFunc_6= ruleConcatFunc | this_SortFunc_7= ruleSortFunc | this_DedupFunc_8= ruleDedupFunc | this_LastFunc_9= ruleLastFunc | this_ParentFunc_10= ruleParentFunc ) ;
    public final EObject ruleCollectionFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveFunc_0 = null;

        EObject this_FindFirstFunc_1 = null;

        EObject this_FilterFunc_2 = null;

        EObject this_MapFunc_3 = null;

        EObject this_Split_4 = null;

        EObject this_Json_5 = null;

        EObject this_ConcatFunc_6 = null;

        EObject this_SortFunc_7 = null;

        EObject this_DedupFunc_8 = null;

        EObject this_LastFunc_9 = null;

        EObject this_ParentFunc_10 = null;



        	enterRule();

        try {
            // InternalExpression.g:1560:2: ( (this_RemoveFunc_0= ruleRemoveFunc | this_FindFirstFunc_1= ruleFindFirstFunc | this_FilterFunc_2= ruleFilterFunc | this_MapFunc_3= ruleMapFunc | this_Split_4= ruleSplit | this_Json_5= ruleJson | this_ConcatFunc_6= ruleConcatFunc | this_SortFunc_7= ruleSortFunc | this_DedupFunc_8= ruleDedupFunc | this_LastFunc_9= ruleLastFunc | this_ParentFunc_10= ruleParentFunc ) )
            // InternalExpression.g:1561:2: (this_RemoveFunc_0= ruleRemoveFunc | this_FindFirstFunc_1= ruleFindFirstFunc | this_FilterFunc_2= ruleFilterFunc | this_MapFunc_3= ruleMapFunc | this_Split_4= ruleSplit | this_Json_5= ruleJson | this_ConcatFunc_6= ruleConcatFunc | this_SortFunc_7= ruleSortFunc | this_DedupFunc_8= ruleDedupFunc | this_LastFunc_9= ruleLastFunc | this_ParentFunc_10= ruleParentFunc )
            {
            // InternalExpression.g:1561:2: (this_RemoveFunc_0= ruleRemoveFunc | this_FindFirstFunc_1= ruleFindFirstFunc | this_FilterFunc_2= ruleFilterFunc | this_MapFunc_3= ruleMapFunc | this_Split_4= ruleSplit | this_Json_5= ruleJson | this_ConcatFunc_6= ruleConcatFunc | this_SortFunc_7= ruleSortFunc | this_DedupFunc_8= ruleDedupFunc | this_LastFunc_9= ruleLastFunc | this_ParentFunc_10= ruleParentFunc )
            int alt23=11;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt23=1;
                }
                break;
            case 58:
                {
                alt23=2;
                }
                break;
            case 57:
                {
                alt23=3;
                }
                break;
            case 64:
                {
                alt23=4;
                }
                break;
            case 47:
                {
                alt23=5;
                }
                break;
            case 76:
                {
                alt23=6;
                }
                break;
            case 71:
                {
                alt23=7;
                }
                break;
            case 60:
                {
                alt23=8;
                }
                break;
            case 61:
                {
                alt23=9;
                }
                break;
            case 45:
                {
                alt23=10;
                }
                break;
            case 44:
                {
                alt23=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalExpression.g:1562:3: this_RemoveFunc_0= ruleRemoveFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getRemoveFuncParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RemoveFunc_0=ruleRemoveFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RemoveFunc_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1571:3: this_FindFirstFunc_1= ruleFindFirstFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getFindFirstFuncParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FindFirstFunc_1=ruleFindFirstFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FindFirstFunc_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:1580:3: this_FilterFunc_2= ruleFilterFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getFilterFuncParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FilterFunc_2=ruleFilterFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FilterFunc_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:1589:3: this_MapFunc_3= ruleMapFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getMapFuncParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MapFunc_3=ruleMapFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MapFunc_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:1598:3: this_Split_4= ruleSplit
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getSplitParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Split_4=ruleSplit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Split_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpression.g:1607:3: this_Json_5= ruleJson
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getJsonParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Json_5=ruleJson();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Json_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExpression.g:1616:3: this_ConcatFunc_6= ruleConcatFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getConcatFuncParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConcatFunc_6=ruleConcatFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConcatFunc_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExpression.g:1625:3: this_SortFunc_7= ruleSortFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getSortFuncParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SortFunc_7=ruleSortFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SortFunc_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExpression.g:1634:3: this_DedupFunc_8= ruleDedupFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getDedupFuncParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DedupFunc_8=ruleDedupFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DedupFunc_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalExpression.g:1643:3: this_LastFunc_9= ruleLastFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getLastFuncParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LastFunc_9=ruleLastFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LastFunc_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalExpression.g:1652:3: this_ParentFunc_10= ruleParentFunc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCollectionFunctionCallAccess().getParentFuncParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParentFunc_10=ruleParentFunc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParentFunc_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionFunctionCall"


    // $ANTLR start "entryRuleParentFunc"
    // InternalExpression.g:1664:1: entryRuleParentFunc returns [EObject current=null] : iv_ruleParentFunc= ruleParentFunc EOF ;
    public final EObject entryRuleParentFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParentFunc = null;


        try {
            // InternalExpression.g:1664:51: (iv_ruleParentFunc= ruleParentFunc EOF )
            // InternalExpression.g:1665:2: iv_ruleParentFunc= ruleParentFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParentFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParentFunc=ruleParentFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParentFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParentFunc"


    // $ANTLR start "ruleParentFunc"
    // InternalExpression.g:1671:1: ruleParentFunc returns [EObject current=null] : (otherlv_0= 'parent(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleParentFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1677:2: ( (otherlv_0= 'parent(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:1678:2: (otherlv_0= 'parent(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:1678:2: (otherlv_0= 'parent(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:1679:3: otherlv_0= 'parent(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParentFuncAccess().getParentKeyword_0());
              		
            }
            // InternalExpression.g:1683:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:1684:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:1684:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:1685:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParentFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParentFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParentFuncAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParentFunc"


    // $ANTLR start "entryRuleLastFunc"
    // InternalExpression.g:1710:1: entryRuleLastFunc returns [EObject current=null] : iv_ruleLastFunc= ruleLastFunc EOF ;
    public final EObject entryRuleLastFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLastFunc = null;


        try {
            // InternalExpression.g:1710:49: (iv_ruleLastFunc= ruleLastFunc EOF )
            // InternalExpression.g:1711:2: iv_ruleLastFunc= ruleLastFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLastFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLastFunc=ruleLastFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLastFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLastFunc"


    // $ANTLR start "ruleLastFunc"
    // InternalExpression.g:1717:1: ruleLastFunc returns [EObject current=null] : (otherlv_0= 'last(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleLastFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1723:2: ( (otherlv_0= 'last(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:1724:2: (otherlv_0= 'last(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:1724:2: (otherlv_0= 'last(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:1725:3: otherlv_0= 'last(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLastFuncAccess().getLastKeyword_0());
              		
            }
            // InternalExpression.g:1729:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:1730:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:1730:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:1731:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLastFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLastFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLastFuncAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLastFunc"


    // $ANTLR start "entryRuleDelete"
    // InternalExpression.g:1756:1: entryRuleDelete returns [EObject current=null] : iv_ruleDelete= ruleDelete EOF ;
    public final EObject entryRuleDelete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDelete = null;


        try {
            // InternalExpression.g:1756:47: (iv_ruleDelete= ruleDelete EOF )
            // InternalExpression.g:1757:2: iv_ruleDelete= ruleDelete EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeleteRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDelete=ruleDelete();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDelete; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelete"


    // $ANTLR start "ruleDelete"
    // InternalExpression.g:1763:1: ruleDelete returns [EObject current=null] : (otherlv_0= 'delete(' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ')' ) ;
    public final EObject ruleDelete() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_variable_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1769:2: ( (otherlv_0= 'delete(' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ')' ) )
            // InternalExpression.g:1770:2: (otherlv_0= 'delete(' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:1770:2: (otherlv_0= 'delete(' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ')' )
            // InternalExpression.g:1771:3: otherlv_0= 'delete(' ( (lv_variable_1_0= ruleVariable ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeleteAccess().getDeleteKeyword_0());
              		
            }
            // InternalExpression.g:1775:3: ( (lv_variable_1_0= ruleVariable ) )
            // InternalExpression.g:1776:4: (lv_variable_1_0= ruleVariable )
            {
            // InternalExpression.g:1776:4: (lv_variable_1_0= ruleVariable )
            // InternalExpression.g:1777:5: lv_variable_1_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeleteAccess().getVariableVariableParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_variable_1_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeleteRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_1_0,
              						"com.intuit.dsl.Expression.Variable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeleteAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelete"


    // $ANTLR start "entryRuleSplit"
    // InternalExpression.g:1802:1: entryRuleSplit returns [EObject current=null] : iv_ruleSplit= ruleSplit EOF ;
    public final EObject entryRuleSplit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSplit = null;


        try {
            // InternalExpression.g:1802:46: (iv_ruleSplit= ruleSplit EOF )
            // InternalExpression.g:1803:2: iv_ruleSplit= ruleSplit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSplitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSplit=ruleSplit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSplit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSplit"


    // $ANTLR start "ruleSplit"
    // InternalExpression.g:1809:1: ruleSplit returns [EObject current=null] : (otherlv_0= 'split(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_regex_3_0= RULE_STRING ) ) otherlv_4= ')' ) ;
    public final EObject ruleSplit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_regex_3_0=null;
        Token otherlv_4=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1815:2: ( (otherlv_0= 'split(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_regex_3_0= RULE_STRING ) ) otherlv_4= ')' ) )
            // InternalExpression.g:1816:2: (otherlv_0= 'split(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_regex_3_0= RULE_STRING ) ) otherlv_4= ')' )
            {
            // InternalExpression.g:1816:2: (otherlv_0= 'split(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_regex_3_0= RULE_STRING ) ) otherlv_4= ')' )
            // InternalExpression.g:1817:3: otherlv_0= 'split(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_regex_3_0= RULE_STRING ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSplitAccess().getSplitKeyword_0());
              		
            }
            // InternalExpression.g:1821:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:1822:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:1822:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:1823:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSplitAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSplitRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSplitAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:1844:3: ( (lv_regex_3_0= RULE_STRING ) )
            // InternalExpression.g:1845:4: (lv_regex_3_0= RULE_STRING )
            {
            // InternalExpression.g:1845:4: (lv_regex_3_0= RULE_STRING )
            // InternalExpression.g:1846:5: lv_regex_3_0= RULE_STRING
            {
            lv_regex_3_0=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regex_3_0, grammarAccess.getSplitAccess().getRegexSTRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSplitRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regex",
              						lv_regex_3_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSplitAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSplit"


    // $ANTLR start "entryRuleContains"
    // InternalExpression.g:1870:1: entryRuleContains returns [EObject current=null] : iv_ruleContains= ruleContains EOF ;
    public final EObject entryRuleContains() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContains = null;


        try {
            // InternalExpression.g:1870:49: (iv_ruleContains= ruleContains EOF )
            // InternalExpression.g:1871:2: iv_ruleContains= ruleContains EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContains=ruleContains();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContains; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContains"


    // $ANTLR start "ruleContains"
    // InternalExpression.g:1877:1: ruleContains returns [EObject current=null] : (otherlv_0= 'contains(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_search_3_0= ruleExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleContains() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_input_1_0 = null;

        EObject lv_search_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1883:2: ( (otherlv_0= 'contains(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_search_3_0= ruleExpression ) ) otherlv_4= ')' ) )
            // InternalExpression.g:1884:2: (otherlv_0= 'contains(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_search_3_0= ruleExpression ) ) otherlv_4= ')' )
            {
            // InternalExpression.g:1884:2: (otherlv_0= 'contains(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_search_3_0= ruleExpression ) ) otherlv_4= ')' )
            // InternalExpression.g:1885:3: otherlv_0= 'contains(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_search_3_0= ruleExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getContainsAccess().getContainsKeyword_0());
              		
            }
            // InternalExpression.g:1889:3: ( (lv_input_1_0= ruleExpression ) )
            // InternalExpression.g:1890:4: (lv_input_1_0= ruleExpression )
            {
            // InternalExpression.g:1890:4: (lv_input_1_0= ruleExpression )
            // InternalExpression.g:1891:5: lv_input_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainsAccess().getInputExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_input_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContainsRule());
              					}
              					set(
              						current,
              						"input",
              						lv_input_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getContainsAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:1912:3: ( (lv_search_3_0= ruleExpression ) )
            // InternalExpression.g:1913:4: (lv_search_3_0= ruleExpression )
            {
            // InternalExpression.g:1913:4: (lv_search_3_0= ruleExpression )
            // InternalExpression.g:1914:5: lv_search_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainsAccess().getSearchExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_search_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContainsRule());
              					}
              					set(
              						current,
              						"search",
              						lv_search_3_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getContainsAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContains"


    // $ANTLR start "entryRuleExtract"
    // InternalExpression.g:1939:1: entryRuleExtract returns [EObject current=null] : iv_ruleExtract= ruleExtract EOF ;
    public final EObject entryRuleExtract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtract = null;


        try {
            // InternalExpression.g:1939:48: (iv_ruleExtract= ruleExtract EOF )
            // InternalExpression.g:1940:2: iv_ruleExtract= ruleExtract EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtractRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtract=ruleExtract();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtract; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtract"


    // $ANTLR start "ruleExtract"
    // InternalExpression.g:1946:1: ruleExtract returns [EObject current=null] : (otherlv_0= 'extract(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_range_3_0= ruleRange ) ) otherlv_4= ')' ) ;
    public final EObject ruleExtract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_input_1_0 = null;

        EObject lv_range_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1952:2: ( (otherlv_0= 'extract(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_range_3_0= ruleRange ) ) otherlv_4= ')' ) )
            // InternalExpression.g:1953:2: (otherlv_0= 'extract(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_range_3_0= ruleRange ) ) otherlv_4= ')' )
            {
            // InternalExpression.g:1953:2: (otherlv_0= 'extract(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_range_3_0= ruleRange ) ) otherlv_4= ')' )
            // InternalExpression.g:1954:3: otherlv_0= 'extract(' ( (lv_input_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_range_3_0= ruleRange ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtractAccess().getExtractKeyword_0());
              		
            }
            // InternalExpression.g:1958:3: ( (lv_input_1_0= ruleExpression ) )
            // InternalExpression.g:1959:4: (lv_input_1_0= ruleExpression )
            {
            // InternalExpression.g:1959:4: (lv_input_1_0= ruleExpression )
            // InternalExpression.g:1960:5: lv_input_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtractAccess().getInputExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_input_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtractRule());
              					}
              					set(
              						current,
              						"input",
              						lv_input_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExtractAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:1981:3: ( (lv_range_3_0= ruleRange ) )
            // InternalExpression.g:1982:4: (lv_range_3_0= ruleRange )
            {
            // InternalExpression.g:1982:4: (lv_range_3_0= ruleRange )
            // InternalExpression.g:1983:5: lv_range_3_0= ruleRange
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtractAccess().getRangeRangeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_range_3_0=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtractRule());
              					}
              					set(
              						current,
              						"range",
              						lv_range_3_0,
              						"com.intuit.dsl.Expression.Range");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getExtractAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtract"


    // $ANTLR start "entryRuleDateFormat"
    // InternalExpression.g:2008:1: entryRuleDateFormat returns [EObject current=null] : iv_ruleDateFormat= ruleDateFormat EOF ;
    public final EObject entryRuleDateFormat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFormat = null;


        try {
            // InternalExpression.g:2008:51: (iv_ruleDateFormat= ruleDateFormat EOF )
            // InternalExpression.g:2009:2: iv_ruleDateFormat= ruleDateFormat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDateFormatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDateFormat=ruleDateFormat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDateFormat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateFormat"


    // $ANTLR start "ruleDateFormat"
    // InternalExpression.g:2015:1: ruleDateFormat returns [EObject current=null] : (otherlv_0= 'dateFormat' otherlv_1= '(' ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) ) otherlv_3= ',' ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ')' ) ;
    public final EObject ruleDateFormat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_from_2_1=null;
        Token lv_from_2_2=null;
        Token lv_from_2_3=null;
        Token lv_from_2_4=null;
        Token lv_from_2_5=null;
        Token otherlv_3=null;
        Token lv_to_4_1=null;
        Token lv_to_4_2=null;
        Token lv_to_4_3=null;
        Token lv_to_4_4=null;
        Token lv_to_4_5=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_exp_6_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2021:2: ( (otherlv_0= 'dateFormat' otherlv_1= '(' ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) ) otherlv_3= ',' ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ')' ) )
            // InternalExpression.g:2022:2: (otherlv_0= 'dateFormat' otherlv_1= '(' ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) ) otherlv_3= ',' ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ')' )
            {
            // InternalExpression.g:2022:2: (otherlv_0= 'dateFormat' otherlv_1= '(' ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) ) otherlv_3= ',' ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ')' )
            // InternalExpression.g:2023:3: otherlv_0= 'dateFormat' otherlv_1= '(' ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) ) otherlv_3= ',' ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDateFormatAccess().getDateFormatKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,41,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDateFormatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalExpression.g:2031:3: ( ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) ) )
            // InternalExpression.g:2032:4: ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) )
            {
            // InternalExpression.g:2032:4: ( (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING ) )
            // InternalExpression.g:2033:5: (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING )
            {
            // InternalExpression.g:2033:5: (lv_from_2_1= '\"MM/dd/yyyy\"' | lv_from_2_2= '\"yyyyMMdd\"' | lv_from_2_3= '\"yyyy-MM-dd\"' | lv_from_2_4= '\"ms\"' | lv_from_2_5= RULE_STRING )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt24=1;
                }
                break;
            case 52:
                {
                alt24=2;
                }
                break;
            case 53:
                {
                alt24=3;
                }
                break;
            case 54:
                {
                alt24=4;
                }
                break;
            case RULE_STRING:
                {
                alt24=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalExpression.g:2034:6: lv_from_2_1= '\"MM/dd/yyyy\"'
                    {
                    lv_from_2_1=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_from_2_1, grammarAccess.getDateFormatAccess().getFromMMDdYyyyKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "from", lv_from_2_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:2045:6: lv_from_2_2= '\"yyyyMMdd\"'
                    {
                    lv_from_2_2=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_from_2_2, grammarAccess.getDateFormatAccess().getFromYyyyMMddKeyword_2_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "from", lv_from_2_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:2056:6: lv_from_2_3= '\"yyyy-MM-dd\"'
                    {
                    lv_from_2_3=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_from_2_3, grammarAccess.getDateFormatAccess().getFromYyyyMMDdKeyword_2_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "from", lv_from_2_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:2067:6: lv_from_2_4= '\"ms\"'
                    {
                    lv_from_2_4=(Token)match(input,54,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_from_2_4, grammarAccess.getDateFormatAccess().getFromMsKeyword_2_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "from", lv_from_2_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:2078:6: lv_from_2_5= RULE_STRING
                    {
                    lv_from_2_5=(Token)match(input,RULE_STRING,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_from_2_5, grammarAccess.getDateFormatAccess().getFromSTRINGTerminalRuleCall_2_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"from",
                      							lv_from_2_5,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDateFormatAccess().getCommaKeyword_3());
              		
            }
            // InternalExpression.g:2099:3: ( ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) ) )
            // InternalExpression.g:2100:4: ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) )
            {
            // InternalExpression.g:2100:4: ( (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING ) )
            // InternalExpression.g:2101:5: (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING )
            {
            // InternalExpression.g:2101:5: (lv_to_4_1= '\"MM/dd/yyyy\"' | lv_to_4_2= '\"yyyyMMdd\"' | lv_to_4_3= '\"yyyy-MM-dd\"' | lv_to_4_4= '\"ms\"' | lv_to_4_5= RULE_STRING )
            int alt25=5;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt25=1;
                }
                break;
            case 52:
                {
                alt25=2;
                }
                break;
            case 53:
                {
                alt25=3;
                }
                break;
            case 54:
                {
                alt25=4;
                }
                break;
            case RULE_STRING:
                {
                alt25=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalExpression.g:2102:6: lv_to_4_1= '\"MM/dd/yyyy\"'
                    {
                    lv_to_4_1=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_to_4_1, grammarAccess.getDateFormatAccess().getToMMDdYyyyKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "to", lv_to_4_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:2113:6: lv_to_4_2= '\"yyyyMMdd\"'
                    {
                    lv_to_4_2=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_to_4_2, grammarAccess.getDateFormatAccess().getToYyyyMMddKeyword_4_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "to", lv_to_4_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:2124:6: lv_to_4_3= '\"yyyy-MM-dd\"'
                    {
                    lv_to_4_3=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_to_4_3, grammarAccess.getDateFormatAccess().getToYyyyMMDdKeyword_4_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "to", lv_to_4_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:2135:6: lv_to_4_4= '\"ms\"'
                    {
                    lv_to_4_4=(Token)match(input,54,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_to_4_4, grammarAccess.getDateFormatAccess().getToMsKeyword_4_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(current, "to", lv_to_4_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:2146:6: lv_to_4_5= RULE_STRING
                    {
                    lv_to_4_5=(Token)match(input,RULE_STRING,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_to_4_5, grammarAccess.getDateFormatAccess().getToSTRINGTerminalRuleCall_4_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDateFormatRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"to",
                      							lv_to_4_5,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getDateFormatAccess().getCommaKeyword_5());
              		
            }
            // InternalExpression.g:2167:3: ( (lv_exp_6_0= ruleExpression ) )
            // InternalExpression.g:2168:4: (lv_exp_6_0= ruleExpression )
            {
            // InternalExpression.g:2168:4: (lv_exp_6_0= ruleExpression )
            // InternalExpression.g:2169:5: lv_exp_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDateFormatAccess().getExpExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDateFormatRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_6_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getDateFormatAccess().getRightParenthesisKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateFormat"


    // $ANTLR start "entryRuleAddToDate"
    // InternalExpression.g:2194:1: entryRuleAddToDate returns [EObject current=null] : iv_ruleAddToDate= ruleAddToDate EOF ;
    public final EObject entryRuleAddToDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddToDate = null;


        try {
            // InternalExpression.g:2194:50: (iv_ruleAddToDate= ruleAddToDate EOF )
            // InternalExpression.g:2195:2: iv_ruleAddToDate= ruleAddToDate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddToDateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddToDate=ruleAddToDate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddToDate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddToDate"


    // $ANTLR start "ruleAddToDate"
    // InternalExpression.g:2201:1: ruleAddToDate returns [EObject current=null] : (otherlv_0= 'addToDate' otherlv_1= '(' ( (lv_dateExp_2_0= ruleExpression ) ) otherlv_3= ',' ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ',' ( (lv_type_8_0= 'Days' ) ) otherlv_9= ')' ) ;
    public final EObject ruleAddToDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_format_4_1=null;
        Token lv_format_4_2=null;
        Token lv_format_4_3=null;
        Token lv_format_4_4=null;
        Token lv_format_4_5=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_type_8_0=null;
        Token otherlv_9=null;
        EObject lv_dateExp_2_0 = null;

        EObject lv_exp_6_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2207:2: ( (otherlv_0= 'addToDate' otherlv_1= '(' ( (lv_dateExp_2_0= ruleExpression ) ) otherlv_3= ',' ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ',' ( (lv_type_8_0= 'Days' ) ) otherlv_9= ')' ) )
            // InternalExpression.g:2208:2: (otherlv_0= 'addToDate' otherlv_1= '(' ( (lv_dateExp_2_0= ruleExpression ) ) otherlv_3= ',' ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ',' ( (lv_type_8_0= 'Days' ) ) otherlv_9= ')' )
            {
            // InternalExpression.g:2208:2: (otherlv_0= 'addToDate' otherlv_1= '(' ( (lv_dateExp_2_0= ruleExpression ) ) otherlv_3= ',' ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ',' ( (lv_type_8_0= 'Days' ) ) otherlv_9= ')' )
            // InternalExpression.g:2209:3: otherlv_0= 'addToDate' otherlv_1= '(' ( (lv_dateExp_2_0= ruleExpression ) ) otherlv_3= ',' ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) ) otherlv_5= ',' ( (lv_exp_6_0= ruleExpression ) ) otherlv_7= ',' ( (lv_type_8_0= 'Days' ) ) otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAddToDateAccess().getAddToDateKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,41,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAddToDateAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalExpression.g:2217:3: ( (lv_dateExp_2_0= ruleExpression ) )
            // InternalExpression.g:2218:4: (lv_dateExp_2_0= ruleExpression )
            {
            // InternalExpression.g:2218:4: (lv_dateExp_2_0= ruleExpression )
            // InternalExpression.g:2219:5: lv_dateExp_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddToDateAccess().getDateExpExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_dateExp_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAddToDateRule());
              					}
              					set(
              						current,
              						"dateExp",
              						lv_dateExp_2_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAddToDateAccess().getCommaKeyword_3());
              		
            }
            // InternalExpression.g:2240:3: ( ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) ) )
            // InternalExpression.g:2241:4: ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) )
            {
            // InternalExpression.g:2241:4: ( (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING ) )
            // InternalExpression.g:2242:5: (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING )
            {
            // InternalExpression.g:2242:5: (lv_format_4_1= '\"MM/dd/yyyy\"' | lv_format_4_2= '\"yyyyMMdd\"' | lv_format_4_3= '\"yyyy-MM-dd\"' | lv_format_4_4= '\"ms\"' | lv_format_4_5= RULE_STRING )
            int alt26=5;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt26=1;
                }
                break;
            case 52:
                {
                alt26=2;
                }
                break;
            case 53:
                {
                alt26=3;
                }
                break;
            case 54:
                {
                alt26=4;
                }
                break;
            case RULE_STRING:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalExpression.g:2243:6: lv_format_4_1= '\"MM/dd/yyyy\"'
                    {
                    lv_format_4_1=(Token)match(input,51,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_format_4_1, grammarAccess.getAddToDateAccess().getFormatMMDdYyyyKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddToDateRule());
                      						}
                      						setWithLastConsumed(current, "format", lv_format_4_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:2254:6: lv_format_4_2= '\"yyyyMMdd\"'
                    {
                    lv_format_4_2=(Token)match(input,52,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_format_4_2, grammarAccess.getAddToDateAccess().getFormatYyyyMMddKeyword_4_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddToDateRule());
                      						}
                      						setWithLastConsumed(current, "format", lv_format_4_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:2265:6: lv_format_4_3= '\"yyyy-MM-dd\"'
                    {
                    lv_format_4_3=(Token)match(input,53,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_format_4_3, grammarAccess.getAddToDateAccess().getFormatYyyyMMDdKeyword_4_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddToDateRule());
                      						}
                      						setWithLastConsumed(current, "format", lv_format_4_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:2276:6: lv_format_4_4= '\"ms\"'
                    {
                    lv_format_4_4=(Token)match(input,54,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_format_4_4, grammarAccess.getAddToDateAccess().getFormatMsKeyword_4_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddToDateRule());
                      						}
                      						setWithLastConsumed(current, "format", lv_format_4_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:2287:6: lv_format_4_5= RULE_STRING
                    {
                    lv_format_4_5=(Token)match(input,RULE_STRING,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_format_4_5, grammarAccess.getAddToDateAccess().getFormatSTRINGTerminalRuleCall_4_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAddToDateRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"format",
                      							lv_format_4_5,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getAddToDateAccess().getCommaKeyword_5());
              		
            }
            // InternalExpression.g:2308:3: ( (lv_exp_6_0= ruleExpression ) )
            // InternalExpression.g:2309:4: (lv_exp_6_0= ruleExpression )
            {
            // InternalExpression.g:2309:4: (lv_exp_6_0= ruleExpression )
            // InternalExpression.g:2310:5: lv_exp_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAddToDateAccess().getExpExpressionParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAddToDateRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_6_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAddToDateAccess().getCommaKeyword_7());
              		
            }
            // InternalExpression.g:2331:3: ( (lv_type_8_0= 'Days' ) )
            // InternalExpression.g:2332:4: (lv_type_8_0= 'Days' )
            {
            // InternalExpression.g:2332:4: (lv_type_8_0= 'Days' )
            // InternalExpression.g:2333:5: lv_type_8_0= 'Days'
            {
            lv_type_8_0=(Token)match(input,56,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_type_8_0, grammarAccess.getAddToDateAccess().getTypeDaysKeyword_8_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAddToDateRule());
              					}
              					setWithLastConsumed(current, "type", lv_type_8_0, "Days");
              				
            }

            }


            }

            otherlv_9=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getAddToDateAccess().getRightParenthesisKeyword_9());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddToDate"


    // $ANTLR start "entryRuleFilterFunc"
    // InternalExpression.g:2353:1: entryRuleFilterFunc returns [EObject current=null] : iv_ruleFilterFunc= ruleFilterFunc EOF ;
    public final EObject entryRuleFilterFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterFunc = null;


        try {
            // InternalExpression.g:2353:51: (iv_ruleFilterFunc= ruleFilterFunc EOF )
            // InternalExpression.g:2354:2: iv_ruleFilterFunc= ruleFilterFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFilterFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFilterFunc=ruleFilterFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFilterFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilterFunc"


    // $ANTLR start "ruleFilterFunc"
    // InternalExpression.g:2360:1: ruleFilterFunc returns [EObject current=null] : (otherlv_0= 'filter(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_condtion_3_0= ruleBooleanExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleFilterFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_exp_1_0 = null;

        EObject lv_condtion_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2366:2: ( (otherlv_0= 'filter(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_condtion_3_0= ruleBooleanExpression ) ) otherlv_4= ')' ) )
            // InternalExpression.g:2367:2: (otherlv_0= 'filter(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_condtion_3_0= ruleBooleanExpression ) ) otherlv_4= ')' )
            {
            // InternalExpression.g:2367:2: (otherlv_0= 'filter(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_condtion_3_0= ruleBooleanExpression ) ) otherlv_4= ')' )
            // InternalExpression.g:2368:3: otherlv_0= 'filter(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_condtion_3_0= ruleBooleanExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFilterFuncAccess().getFilterKeyword_0());
              		
            }
            // InternalExpression.g:2372:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:2373:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:2373:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:2374:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFilterFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFilterFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFilterFuncAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:2395:3: ( (lv_condtion_3_0= ruleBooleanExpression ) )
            // InternalExpression.g:2396:4: (lv_condtion_3_0= ruleBooleanExpression )
            {
            // InternalExpression.g:2396:4: (lv_condtion_3_0= ruleBooleanExpression )
            // InternalExpression.g:2397:5: lv_condtion_3_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFilterFuncAccess().getCondtionBooleanExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_condtion_3_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFilterFuncRule());
              					}
              					set(
              						current,
              						"condtion",
              						lv_condtion_3_0,
              						"com.intuit.dsl.Expression.BooleanExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getFilterFuncAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterFunc"


    // $ANTLR start "entryRuleFindFirstFunc"
    // InternalExpression.g:2422:1: entryRuleFindFirstFunc returns [EObject current=null] : iv_ruleFindFirstFunc= ruleFindFirstFunc EOF ;
    public final EObject entryRuleFindFirstFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFindFirstFunc = null;


        try {
            // InternalExpression.g:2422:54: (iv_ruleFindFirstFunc= ruleFindFirstFunc EOF )
            // InternalExpression.g:2423:2: iv_ruleFindFirstFunc= ruleFindFirstFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFindFirstFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFindFirstFunc=ruleFindFirstFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFindFirstFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFindFirstFunc"


    // $ANTLR start "ruleFindFirstFunc"
    // InternalExpression.g:2429:1: ruleFindFirstFunc returns [EObject current=null] : (otherlv_0= 'findFirst' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleFindFirstFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exp_2_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2435:2: ( (otherlv_0= 'findFirst' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' ) )
            // InternalExpression.g:2436:2: (otherlv_0= 'findFirst' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' )
            {
            // InternalExpression.g:2436:2: (otherlv_0= 'findFirst' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' )
            // InternalExpression.g:2437:3: otherlv_0= 'findFirst' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFindFirstFuncAccess().getFindFirstKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,41,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFindFirstFuncAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalExpression.g:2445:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalExpression.g:2446:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalExpression.g:2446:4: (lv_exp_2_0= ruleExpression )
            // InternalExpression.g:2447:5: lv_exp_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFindFirstFuncAccess().getExpExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFindFirstFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_2_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFindFirstFuncAccess().getCommaKeyword_3());
              		
            }
            // InternalExpression.g:2468:3: ( (lv_condition_4_0= ruleBooleanExpression ) )
            // InternalExpression.g:2469:4: (lv_condition_4_0= ruleBooleanExpression )
            {
            // InternalExpression.g:2469:4: (lv_condition_4_0= ruleBooleanExpression )
            // InternalExpression.g:2470:5: lv_condition_4_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFindFirstFuncAccess().getConditionBooleanExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_condition_4_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFindFirstFuncRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_4_0,
              						"com.intuit.dsl.Expression.BooleanExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFindFirstFuncAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFindFirstFunc"


    // $ANTLR start "entryRuleRemoveFunc"
    // InternalExpression.g:2495:1: entryRuleRemoveFunc returns [EObject current=null] : iv_ruleRemoveFunc= ruleRemoveFunc EOF ;
    public final EObject entryRuleRemoveFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveFunc = null;


        try {
            // InternalExpression.g:2495:51: (iv_ruleRemoveFunc= ruleRemoveFunc EOF )
            // InternalExpression.g:2496:2: iv_ruleRemoveFunc= ruleRemoveFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRemoveFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRemoveFunc=ruleRemoveFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRemoveFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveFunc"


    // $ANTLR start "ruleRemoveFunc"
    // InternalExpression.g:2502:1: ruleRemoveFunc returns [EObject current=null] : (otherlv_0= 'remove' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleRemoveFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exp_2_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2508:2: ( (otherlv_0= 'remove' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' ) )
            // InternalExpression.g:2509:2: (otherlv_0= 'remove' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' )
            {
            // InternalExpression.g:2509:2: (otherlv_0= 'remove' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')' )
            // InternalExpression.g:2510:3: otherlv_0= 'remove' otherlv_1= '(' ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_condition_4_0= ruleBooleanExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRemoveFuncAccess().getRemoveKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,41,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRemoveFuncAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalExpression.g:2518:3: ( (lv_exp_2_0= ruleExpression ) )
            // InternalExpression.g:2519:4: (lv_exp_2_0= ruleExpression )
            {
            // InternalExpression.g:2519:4: (lv_exp_2_0= ruleExpression )
            // InternalExpression.g:2520:5: lv_exp_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRemoveFuncAccess().getExpExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRemoveFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_2_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRemoveFuncAccess().getCommaKeyword_3());
              		
            }
            // InternalExpression.g:2541:3: ( (lv_condition_4_0= ruleBooleanExpression ) )
            // InternalExpression.g:2542:4: (lv_condition_4_0= ruleBooleanExpression )
            {
            // InternalExpression.g:2542:4: (lv_condition_4_0= ruleBooleanExpression )
            // InternalExpression.g:2543:5: lv_condition_4_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRemoveFuncAccess().getConditionBooleanExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_condition_4_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRemoveFuncRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_4_0,
              						"com.intuit.dsl.Expression.BooleanExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRemoveFuncAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveFunc"


    // $ANTLR start "entryRuleSortFunc"
    // InternalExpression.g:2568:1: entryRuleSortFunc returns [EObject current=null] : iv_ruleSortFunc= ruleSortFunc EOF ;
    public final EObject entryRuleSortFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortFunc = null;


        try {
            // InternalExpression.g:2568:49: (iv_ruleSortFunc= ruleSortFunc EOF )
            // InternalExpression.g:2569:2: iv_ruleSortFunc= ruleSortFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSortFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSortFunc=ruleSortFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSortFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSortFunc"


    // $ANTLR start "ruleSortFunc"
    // InternalExpression.g:2575:1: ruleSortFunc returns [EObject current=null] : (otherlv_0= 'sort(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )? otherlv_6= ')' ) ;
    public final EObject ruleSortFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_exp_1_0 = null;

        EObject lv_key_3_0 = null;

        AntlrDatatypeRuleToken lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2581:2: ( (otherlv_0= 'sort(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )? otherlv_6= ')' ) )
            // InternalExpression.g:2582:2: (otherlv_0= 'sort(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )? otherlv_6= ')' )
            {
            // InternalExpression.g:2582:2: (otherlv_0= 'sort(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )? otherlv_6= ')' )
            // InternalExpression.g:2583:3: otherlv_0= 'sort(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSortFuncAccess().getSortKeyword_0());
              		
            }
            // InternalExpression.g:2587:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:2588:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:2588:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:2589:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSortFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSortFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSortFuncAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:2610:3: ( (lv_key_3_0= ruleSchemaVariable ) )
            // InternalExpression.g:2611:4: (lv_key_3_0= ruleSchemaVariable )
            {
            // InternalExpression.g:2611:4: (lv_key_3_0= ruleSchemaVariable )
            // InternalExpression.g:2612:5: lv_key_3_0= ruleSchemaVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSortFuncAccess().getKeySchemaVariableParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_key_3_0=ruleSchemaVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSortFuncRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_3_0,
              						"com.intuit.dsl.Expression.SchemaVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:2629:3: (otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==22) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalExpression.g:2630:4: otherlv_4= ',' ( (lv_type_5_0= ruleORDER_TYPE ) )
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getSortFuncAccess().getCommaKeyword_4_0());
                      			
                    }
                    // InternalExpression.g:2634:4: ( (lv_type_5_0= ruleORDER_TYPE ) )
                    // InternalExpression.g:2635:5: (lv_type_5_0= ruleORDER_TYPE )
                    {
                    // InternalExpression.g:2635:5: (lv_type_5_0= ruleORDER_TYPE )
                    // InternalExpression.g:2636:6: lv_type_5_0= ruleORDER_TYPE
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSortFuncAccess().getTypeORDER_TYPEParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_type_5_0=ruleORDER_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSortFuncRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_5_0,
                      							"com.intuit.dsl.Expression.ORDER_TYPE");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSortFuncAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortFunc"


    // $ANTLR start "entryRuleDedupFunc"
    // InternalExpression.g:2662:1: entryRuleDedupFunc returns [EObject current=null] : iv_ruleDedupFunc= ruleDedupFunc EOF ;
    public final EObject entryRuleDedupFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDedupFunc = null;


        try {
            // InternalExpression.g:2662:50: (iv_ruleDedupFunc= ruleDedupFunc EOF )
            // InternalExpression.g:2663:2: iv_ruleDedupFunc= ruleDedupFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDedupFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDedupFunc=ruleDedupFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDedupFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDedupFunc"


    // $ANTLR start "ruleDedupFunc"
    // InternalExpression.g:2669:1: ruleDedupFunc returns [EObject current=null] : (otherlv_0= 'dedup(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )? otherlv_4= ')' ) ;
    public final EObject ruleDedupFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_exp_1_0 = null;

        EObject lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2675:2: ( (otherlv_0= 'dedup(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )? otherlv_4= ')' ) )
            // InternalExpression.g:2676:2: (otherlv_0= 'dedup(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )? otherlv_4= ')' )
            {
            // InternalExpression.g:2676:2: (otherlv_0= 'dedup(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )? otherlv_4= ')' )
            // InternalExpression.g:2677:3: otherlv_0= 'dedup(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )? otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDedupFuncAccess().getDedupKeyword_0());
              		
            }
            // InternalExpression.g:2681:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:2682:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:2682:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:2683:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDedupFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDedupFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:2700:3: (otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==22) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalExpression.g:2701:4: otherlv_2= ',' ( (lv_key_3_0= ruleSchemaVariable ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getDedupFuncAccess().getCommaKeyword_2_0());
                      			
                    }
                    // InternalExpression.g:2705:4: ( (lv_key_3_0= ruleSchemaVariable ) )
                    // InternalExpression.g:2706:5: (lv_key_3_0= ruleSchemaVariable )
                    {
                    // InternalExpression.g:2706:5: (lv_key_3_0= ruleSchemaVariable )
                    // InternalExpression.g:2707:6: lv_key_3_0= ruleSchemaVariable
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDedupFuncAccess().getKeySchemaVariableParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_key_3_0=ruleSchemaVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDedupFuncRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_3_0,
                      							"com.intuit.dsl.Expression.SchemaVariable");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDedupFuncAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDedupFunc"


    // $ANTLR start "entryRuleORDER_TYPE"
    // InternalExpression.g:2733:1: entryRuleORDER_TYPE returns [String current=null] : iv_ruleORDER_TYPE= ruleORDER_TYPE EOF ;
    public final String entryRuleORDER_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleORDER_TYPE = null;


        try {
            // InternalExpression.g:2733:50: (iv_ruleORDER_TYPE= ruleORDER_TYPE EOF )
            // InternalExpression.g:2734:2: iv_ruleORDER_TYPE= ruleORDER_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getORDER_TYPERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleORDER_TYPE=ruleORDER_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleORDER_TYPE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleORDER_TYPE"


    // $ANTLR start "ruleORDER_TYPE"
    // InternalExpression.g:2740:1: ruleORDER_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'ascending' | kw= 'descending' ) ;
    public final AntlrDatatypeRuleToken ruleORDER_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExpression.g:2746:2: ( (kw= 'ascending' | kw= 'descending' ) )
            // InternalExpression.g:2747:2: (kw= 'ascending' | kw= 'descending' )
            {
            // InternalExpression.g:2747:2: (kw= 'ascending' | kw= 'descending' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==62) ) {
                alt29=1;
            }
            else if ( (LA29_0==63) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalExpression.g:2748:3: kw= 'ascending'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getORDER_TYPEAccess().getAscendingKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:2754:3: kw= 'descending'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getORDER_TYPEAccess().getDescendingKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleORDER_TYPE"


    // $ANTLR start "entryRuleMapFunc"
    // InternalExpression.g:2763:1: entryRuleMapFunc returns [EObject current=null] : iv_ruleMapFunc= ruleMapFunc EOF ;
    public final EObject entryRuleMapFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapFunc = null;


        try {
            // InternalExpression.g:2763:48: (iv_ruleMapFunc= ruleMapFunc EOF )
            // InternalExpression.g:2764:2: iv_ruleMapFunc= ruleMapFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMapFunc=ruleMapFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapFunc"


    // $ANTLR start "ruleMapFunc"
    // InternalExpression.g:2770:1: ruleMapFunc returns [EObject current=null] : (otherlv_0= 'map(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )? (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )? otherlv_7= '->' ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) ) otherlv_12= ')' ) ;
    public final EObject ruleMapFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_exp_1_0 = null;

        EObject lv_range_3_0 = null;

        AntlrDatatypeRuleToken lv_aliasKey_6_0 = null;

        EObject lv_returnexp_8_0 = null;

        EObject lv_statement_10_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2776:2: ( (otherlv_0= 'map(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )? (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )? otherlv_7= '->' ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) ) otherlv_12= ')' ) )
            // InternalExpression.g:2777:2: (otherlv_0= 'map(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )? (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )? otherlv_7= '->' ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) ) otherlv_12= ')' )
            {
            // InternalExpression.g:2777:2: (otherlv_0= 'map(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )? (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )? otherlv_7= '->' ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) ) otherlv_12= ')' )
            // InternalExpression.g:2778:3: otherlv_0= 'map(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )? (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )? otherlv_7= '->' ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) ) otherlv_12= ')'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMapFuncAccess().getMapKeyword_0());
              		
            }
            // InternalExpression.g:2782:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:2783:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:2783:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:2784:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMapFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:2801:3: (otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalExpression.g:2802:4: otherlv_2= '{' ( (lv_range_3_0= ruleRange ) ) otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getMapFuncAccess().getLeftCurlyBracketKeyword_2_0());
                      			
                    }
                    // InternalExpression.g:2806:4: ( (lv_range_3_0= ruleRange ) )
                    // InternalExpression.g:2807:5: (lv_range_3_0= ruleRange )
                    {
                    // InternalExpression.g:2807:5: (lv_range_3_0= ruleRange )
                    // InternalExpression.g:2808:6: lv_range_3_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMapFuncAccess().getRangeRangeParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_range_3_0=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMapFuncRule());
                      						}
                      						set(
                      							current,
                      							"range",
                      							lv_range_3_0,
                      							"com.intuit.dsl.Expression.Range");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,66,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getMapFuncAccess().getRightCurlyBracketKeyword_2_2());
                      			
                    }

                    }
                    break;

            }

            // InternalExpression.g:2830:3: (otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==67) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalExpression.g:2831:4: otherlv_5= 'as' ( (lv_aliasKey_6_0= ruleAllowedKeyword ) )
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getMapFuncAccess().getAsKeyword_3_0());
                      			
                    }
                    // InternalExpression.g:2835:4: ( (lv_aliasKey_6_0= ruleAllowedKeyword ) )
                    // InternalExpression.g:2836:5: (lv_aliasKey_6_0= ruleAllowedKeyword )
                    {
                    // InternalExpression.g:2836:5: (lv_aliasKey_6_0= ruleAllowedKeyword )
                    // InternalExpression.g:2837:6: lv_aliasKey_6_0= ruleAllowedKeyword
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMapFuncAccess().getAliasKeyAllowedKeywordParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_aliasKey_6_0=ruleAllowedKeyword();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMapFuncRule());
                      						}
                      						set(
                      							current,
                      							"aliasKey",
                      							lv_aliasKey_6_0,
                      							"com.intuit.dsl.Expression.AllowedKeyword");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,68,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getMapFuncAccess().getHyphenMinusGreaterThanSignKeyword_4());
              		
            }
            // InternalExpression.g:2859:3: ( ( (lv_returnexp_8_0= ruleExpression ) ) | (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_INT)||LA33_0==21||LA33_0==30||(LA33_0>=34 && LA33_0<=38)||LA33_0==41||(LA33_0>=44 && LA33_0<=50)||LA33_0==55||(LA33_0>=57 && LA33_0<=61)||LA33_0==64||(LA33_0>=71 && LA33_0<=99)) ) {
                alt33=1;
            }
            else if ( (LA33_0==65) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalExpression.g:2860:4: ( (lv_returnexp_8_0= ruleExpression ) )
                    {
                    // InternalExpression.g:2860:4: ( (lv_returnexp_8_0= ruleExpression ) )
                    // InternalExpression.g:2861:5: (lv_returnexp_8_0= ruleExpression )
                    {
                    // InternalExpression.g:2861:5: (lv_returnexp_8_0= ruleExpression )
                    // InternalExpression.g:2862:6: lv_returnexp_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMapFuncAccess().getReturnexpExpressionParserRuleCall_5_0_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_returnexp_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMapFuncRule());
                      						}
                      						set(
                      							current,
                      							"returnexp",
                      							lv_returnexp_8_0,
                      							"com.intuit.dsl.Expression.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2880:4: (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' )
                    {
                    // InternalExpression.g:2880:4: (otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}' )
                    // InternalExpression.g:2881:5: otherlv_9= '{' ( (lv_statement_10_0= ruleMapStatement ) )+ otherlv_11= '}'
                    {
                    otherlv_9=(Token)match(input,65,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getMapFuncAccess().getLeftCurlyBracketKeyword_5_1_0());
                      				
                    }
                    // InternalExpression.g:2885:5: ( (lv_statement_10_0= ruleMapStatement ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_ID||(LA32_0>=84 && LA32_0<=99)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // InternalExpression.g:2886:6: (lv_statement_10_0= ruleMapStatement )
                    	    {
                    	    // InternalExpression.g:2886:6: (lv_statement_10_0= ruleMapStatement )
                    	    // InternalExpression.g:2887:7: lv_statement_10_0= ruleMapStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getMapFuncAccess().getStatementMapStatementParserRuleCall_5_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_32);
                    	    lv_statement_10_0=ruleMapStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getMapFuncRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"statement",
                    	      								lv_statement_10_0,
                    	      								"com.intuit.dsl.Expression.MapStatement");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    otherlv_11=(Token)match(input,66,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getMapFuncAccess().getRightCurlyBracketKeyword_5_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getMapFuncAccess().getRightParenthesisKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapFunc"


    // $ANTLR start "entryRuleRange"
    // InternalExpression.g:2918:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalExpression.g:2918:46: (iv_ruleRange= ruleRange EOF )
            // InternalExpression.g:2919:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalExpression.g:2925:1: ruleRange returns [EObject current=null] : ( ( (lv_low_0_0= ruleExpression ) )? ( (lv_diff_1_0= '..' ) ) ( (lv_high_2_0= ruleExpression ) )? ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token lv_diff_1_0=null;
        EObject lv_low_0_0 = null;

        EObject lv_high_2_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2931:2: ( ( ( (lv_low_0_0= ruleExpression ) )? ( (lv_diff_1_0= '..' ) ) ( (lv_high_2_0= ruleExpression ) )? ) )
            // InternalExpression.g:2932:2: ( ( (lv_low_0_0= ruleExpression ) )? ( (lv_diff_1_0= '..' ) ) ( (lv_high_2_0= ruleExpression ) )? )
            {
            // InternalExpression.g:2932:2: ( ( (lv_low_0_0= ruleExpression ) )? ( (lv_diff_1_0= '..' ) ) ( (lv_high_2_0= ruleExpression ) )? )
            // InternalExpression.g:2933:3: ( (lv_low_0_0= ruleExpression ) )? ( (lv_diff_1_0= '..' ) ) ( (lv_high_2_0= ruleExpression ) )?
            {
            // InternalExpression.g:2933:3: ( (lv_low_0_0= ruleExpression ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_INT)||LA34_0==21||LA34_0==30||(LA34_0>=34 && LA34_0<=38)||LA34_0==41||(LA34_0>=44 && LA34_0<=50)||LA34_0==55||(LA34_0>=57 && LA34_0<=61)||LA34_0==64||(LA34_0>=71 && LA34_0<=99)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalExpression.g:2934:4: (lv_low_0_0= ruleExpression )
                    {
                    // InternalExpression.g:2934:4: (lv_low_0_0= ruleExpression )
                    // InternalExpression.g:2935:5: lv_low_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRangeAccess().getLowExpressionParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_33);
                    lv_low_0_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRangeRule());
                      					}
                      					set(
                      						current,
                      						"low",
                      						lv_low_0_0,
                      						"com.intuit.dsl.Expression.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExpression.g:2952:3: ( (lv_diff_1_0= '..' ) )
            // InternalExpression.g:2953:4: (lv_diff_1_0= '..' )
            {
            // InternalExpression.g:2953:4: (lv_diff_1_0= '..' )
            // InternalExpression.g:2954:5: lv_diff_1_0= '..'
            {
            lv_diff_1_0=(Token)match(input,69,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_diff_1_0, grammarAccess.getRangeAccess().getDiffFullStopFullStopKeyword_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRangeRule());
              					}
              					setWithLastConsumed(current, "diff", lv_diff_1_0, "..");
              				
            }

            }


            }

            // InternalExpression.g:2966:3: ( (lv_high_2_0= ruleExpression ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_INT)||LA35_0==21||LA35_0==30||(LA35_0>=34 && LA35_0<=38)||LA35_0==41||(LA35_0>=44 && LA35_0<=50)||LA35_0==55||(LA35_0>=57 && LA35_0<=61)||LA35_0==64||(LA35_0>=71 && LA35_0<=99)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalExpression.g:2967:4: (lv_high_2_0= ruleExpression )
                    {
                    // InternalExpression.g:2967:4: (lv_high_2_0= ruleExpression )
                    // InternalExpression.g:2968:5: lv_high_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRangeAccess().getHighExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_high_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRangeRule());
                      					}
                      					set(
                      						current,
                      						"high",
                      						lv_high_2_0,
                      						"com.intuit.dsl.Expression.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleMapStatement"
    // InternalExpression.g:2989:1: entryRuleMapStatement returns [EObject current=null] : iv_ruleMapStatement= ruleMapStatement EOF ;
    public final EObject entryRuleMapStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapStatement = null;


        try {
            // InternalExpression.g:2989:53: (iv_ruleMapStatement= ruleMapStatement EOF )
            // InternalExpression.g:2990:2: iv_ruleMapStatement= ruleMapStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMapStatement=ruleMapStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapStatement"


    // $ANTLR start "ruleMapStatement"
    // InternalExpression.g:2996:1: ruleMapStatement returns [EObject current=null] : ( ( (lv_resultKey_0_0= ruleKey ) ) (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExpression ) ) ) ;
    public final EObject ruleMapStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_resultKey_0_0 = null;

        EObject lv_resultKey_2_0 = null;

        EObject lv_exp_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3002:2: ( ( ( (lv_resultKey_0_0= ruleKey ) ) (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExpression ) ) ) )
            // InternalExpression.g:3003:2: ( ( (lv_resultKey_0_0= ruleKey ) ) (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExpression ) ) )
            {
            // InternalExpression.g:3003:2: ( ( (lv_resultKey_0_0= ruleKey ) ) (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExpression ) ) )
            // InternalExpression.g:3004:3: ( (lv_resultKey_0_0= ruleKey ) ) (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )* otherlv_3= '=' ( (lv_exp_4_0= ruleExpression ) )
            {
            // InternalExpression.g:3004:3: ( (lv_resultKey_0_0= ruleKey ) )
            // InternalExpression.g:3005:4: (lv_resultKey_0_0= ruleKey )
            {
            // InternalExpression.g:3005:4: (lv_resultKey_0_0= ruleKey )
            // InternalExpression.g:3006:5: lv_resultKey_0_0= ruleKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapStatementAccess().getResultKeyKeyParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
            lv_resultKey_0_0=ruleKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMapStatementRule());
              					}
              					add(
              						current,
              						"resultKey",
              						lv_resultKey_0_0,
              						"com.intuit.dsl.Expression.Key");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:3023:3: (otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalExpression.g:3024:4: otherlv_1= '.' ( (lv_resultKey_2_0= ruleKey ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getMapStatementAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    // InternalExpression.g:3028:4: ( (lv_resultKey_2_0= ruleKey ) )
            	    // InternalExpression.g:3029:5: (lv_resultKey_2_0= ruleKey )
            	    {
            	    // InternalExpression.g:3029:5: (lv_resultKey_2_0= ruleKey )
            	    // InternalExpression.g:3030:6: lv_resultKey_2_0= ruleKey
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMapStatementAccess().getResultKeyKeyParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_resultKey_2_0=ruleKey();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMapStatementRule());
            	      						}
            	      						add(
            	      							current,
            	      							"resultKey",
            	      							lv_resultKey_2_0,
            	      							"com.intuit.dsl.Expression.Key");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_3=(Token)match(input,70,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getMapStatementAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalExpression.g:3052:3: ( (lv_exp_4_0= ruleExpression ) )
            // InternalExpression.g:3053:4: (lv_exp_4_0= ruleExpression )
            {
            // InternalExpression.g:3053:4: (lv_exp_4_0= ruleExpression )
            // InternalExpression.g:3054:5: lv_exp_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapStatementAccess().getExpExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_exp_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMapStatementRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_4_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapStatement"


    // $ANTLR start "entryRuleConcatFunc"
    // InternalExpression.g:3075:1: entryRuleConcatFunc returns [EObject current=null] : iv_ruleConcatFunc= ruleConcatFunc EOF ;
    public final EObject entryRuleConcatFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatFunc = null;


        try {
            // InternalExpression.g:3075:51: (iv_ruleConcatFunc= ruleConcatFunc EOF )
            // InternalExpression.g:3076:2: iv_ruleConcatFunc= ruleConcatFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcatFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcatFunc=ruleConcatFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcatFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatFunc"


    // $ANTLR start "ruleConcatFunc"
    // InternalExpression.g:3082:1: ruleConcatFunc returns [EObject current=null] : (otherlv_0= 'concat(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= ')' ) ;
    public final EObject ruleConcatFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_exp_1_0 = null;

        EObject lv_exp_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3088:2: ( (otherlv_0= 'concat(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= ')' ) )
            // InternalExpression.g:3089:2: (otherlv_0= 'concat(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= ')' )
            {
            // InternalExpression.g:3089:2: (otherlv_0= 'concat(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= ')' )
            // InternalExpression.g:3090:3: otherlv_0= 'concat(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConcatFuncAccess().getConcatKeyword_0());
              		
            }
            // InternalExpression.g:3094:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3095:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3095:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3096:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConcatFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConcatFuncRule());
              					}
              					add(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:3113:3: (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==22) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalExpression.g:3114:4: otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getConcatFuncAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalExpression.g:3118:4: ( (lv_exp_3_0= ruleExpression ) )
            	    // InternalExpression.g:3119:5: (lv_exp_3_0= ruleExpression )
            	    {
            	    // InternalExpression.g:3119:5: (lv_exp_3_0= ruleExpression )
            	    // InternalExpression.g:3120:6: lv_exp_3_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getConcatFuncAccess().getExpExpressionParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_exp_3_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getConcatFuncRule());
            	      						}
            	      						add(
            	      							current,
            	      							"exp",
            	      							lv_exp_3_0,
            	      							"com.intuit.dsl.Expression.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            otherlv_4=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConcatFuncAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatFunc"


    // $ANTLR start "entryRuleLength"
    // InternalExpression.g:3146:1: entryRuleLength returns [EObject current=null] : iv_ruleLength= ruleLength EOF ;
    public final EObject entryRuleLength() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLength = null;


        try {
            // InternalExpression.g:3146:47: (iv_ruleLength= ruleLength EOF )
            // InternalExpression.g:3147:2: iv_ruleLength= ruleLength EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLengthRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLength=ruleLength();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLength; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLength"


    // $ANTLR start "ruleLength"
    // InternalExpression.g:3153:1: ruleLength returns [EObject current=null] : (otherlv_0= 'length(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleLength() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3159:2: ( (otherlv_0= 'length(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:3160:2: (otherlv_0= 'length(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:3160:2: (otherlv_0= 'length(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:3161:3: otherlv_0= 'length(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLengthAccess().getLengthKeyword_0());
              		
            }
            // InternalExpression.g:3165:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3166:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3166:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3167:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLengthAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLengthRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLengthAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLength"


    // $ANTLR start "entryRuleLowerFunc"
    // InternalExpression.g:3192:1: entryRuleLowerFunc returns [EObject current=null] : iv_ruleLowerFunc= ruleLowerFunc EOF ;
    public final EObject entryRuleLowerFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerFunc = null;


        try {
            // InternalExpression.g:3192:50: (iv_ruleLowerFunc= ruleLowerFunc EOF )
            // InternalExpression.g:3193:2: iv_ruleLowerFunc= ruleLowerFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLowerFunc=ruleLowerFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLowerFunc"


    // $ANTLR start "ruleLowerFunc"
    // InternalExpression.g:3199:1: ruleLowerFunc returns [EObject current=null] : (otherlv_0= 'lowerCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleLowerFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3205:2: ( (otherlv_0= 'lowerCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:3206:2: (otherlv_0= 'lowerCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:3206:2: (otherlv_0= 'lowerCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:3207:3: otherlv_0= 'lowerCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLowerFuncAccess().getLowerCaseKeyword_0());
              		
            }
            // InternalExpression.g:3211:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3212:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3212:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3213:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLowerFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLowerFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLowerFuncAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLowerFunc"


    // $ANTLR start "entryRuleUpperFunc"
    // InternalExpression.g:3238:1: entryRuleUpperFunc returns [EObject current=null] : iv_ruleUpperFunc= ruleUpperFunc EOF ;
    public final EObject entryRuleUpperFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperFunc = null;


        try {
            // InternalExpression.g:3238:50: (iv_ruleUpperFunc= ruleUpperFunc EOF )
            // InternalExpression.g:3239:2: iv_ruleUpperFunc= ruleUpperFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpperFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUpperFunc=ruleUpperFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpperFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpperFunc"


    // $ANTLR start "ruleUpperFunc"
    // InternalExpression.g:3245:1: ruleUpperFunc returns [EObject current=null] : (otherlv_0= 'upperCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleUpperFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3251:2: ( (otherlv_0= 'upperCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:3252:2: (otherlv_0= 'upperCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:3252:2: (otherlv_0= 'upperCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:3253:3: otherlv_0= 'upperCase(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUpperFuncAccess().getUpperCaseKeyword_0());
              		
            }
            // InternalExpression.g:3257:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3258:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3258:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3259:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUpperFuncAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUpperFuncRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUpperFuncAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpperFunc"


    // $ANTLR start "entryRuleUUIDFunc"
    // InternalExpression.g:3284:1: entryRuleUUIDFunc returns [EObject current=null] : iv_ruleUUIDFunc= ruleUUIDFunc EOF ;
    public final EObject entryRuleUUIDFunc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUUIDFunc = null;


        try {
            // InternalExpression.g:3284:49: (iv_ruleUUIDFunc= ruleUUIDFunc EOF )
            // InternalExpression.g:3285:2: iv_ruleUUIDFunc= ruleUUIDFunc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUUIDFuncRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUUIDFunc=ruleUUIDFunc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUUIDFunc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUUIDFunc"


    // $ANTLR start "ruleUUIDFunc"
    // InternalExpression.g:3291:1: ruleUUIDFunc returns [EObject current=null] : ( () otherlv_1= 'uuid()' ) ;
    public final EObject ruleUUIDFunc() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpression.g:3297:2: ( ( () otherlv_1= 'uuid()' ) )
            // InternalExpression.g:3298:2: ( () otherlv_1= 'uuid()' )
            {
            // InternalExpression.g:3298:2: ( () otherlv_1= 'uuid()' )
            // InternalExpression.g:3299:3: () otherlv_1= 'uuid()'
            {
            // InternalExpression.g:3299:3: ()
            // InternalExpression.g:3300:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUUIDFuncAccess().getUUIDFuncAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUUIDFuncAccess().getUuidKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUUIDFunc"


    // $ANTLR start "entryRuleJson"
    // InternalExpression.g:3314:1: entryRuleJson returns [EObject current=null] : iv_ruleJson= ruleJson EOF ;
    public final EObject entryRuleJson() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJson = null;


        try {
            // InternalExpression.g:3314:45: (iv_ruleJson= ruleJson EOF )
            // InternalExpression.g:3315:2: iv_ruleJson= ruleJson EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJsonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJson=ruleJson();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJson; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJson"


    // $ANTLR start "ruleJson"
    // InternalExpression.g:3321:1: ruleJson returns [EObject current=null] : (otherlv_0= 'json(' ( (lv_exp_1_0= ruleSchemaVariable ) ) otherlv_2= ')' ) ;
    public final EObject ruleJson() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3327:2: ( (otherlv_0= 'json(' ( (lv_exp_1_0= ruleSchemaVariable ) ) otherlv_2= ')' ) )
            // InternalExpression.g:3328:2: (otherlv_0= 'json(' ( (lv_exp_1_0= ruleSchemaVariable ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:3328:2: (otherlv_0= 'json(' ( (lv_exp_1_0= ruleSchemaVariable ) ) otherlv_2= ')' )
            // InternalExpression.g:3329:3: otherlv_0= 'json(' ( (lv_exp_1_0= ruleSchemaVariable ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJsonAccess().getJsonKeyword_0());
              		
            }
            // InternalExpression.g:3333:3: ( (lv_exp_1_0= ruleSchemaVariable ) )
            // InternalExpression.g:3334:4: (lv_exp_1_0= ruleSchemaVariable )
            {
            // InternalExpression.g:3334:4: (lv_exp_1_0= ruleSchemaVariable )
            // InternalExpression.g:3335:5: lv_exp_1_0= ruleSchemaVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJsonAccess().getExpSchemaVariableParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleSchemaVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJsonRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.SchemaVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getJsonAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJson"


    // $ANTLR start "entryRuleJoin"
    // InternalExpression.g:3360:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalExpression.g:3360:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalExpression.g:3361:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJoin"


    // $ANTLR start "ruleJoin"
    // InternalExpression.g:3367:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_delimiter_5_0= RULE_STRING ) ) (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )? otherlv_8= ')' ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_delimiter_5_0=null;
        Token otherlv_6=null;
        Token lv_last_7_0=null;
        Token otherlv_8=null;
        EObject lv_exp_1_0 = null;

        EObject lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3373:2: ( (otherlv_0= 'join(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_delimiter_5_0= RULE_STRING ) ) (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )? otherlv_8= ')' ) )
            // InternalExpression.g:3374:2: (otherlv_0= 'join(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_delimiter_5_0= RULE_STRING ) ) (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )? otherlv_8= ')' )
            {
            // InternalExpression.g:3374:2: (otherlv_0= 'join(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_delimiter_5_0= RULE_STRING ) ) (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )? otherlv_8= ')' )
            // InternalExpression.g:3375:3: otherlv_0= 'join(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_key_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_delimiter_5_0= RULE_STRING ) ) (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
              		
            }
            // InternalExpression.g:3379:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3380:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3380:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3381:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJoinRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getJoinAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:3402:3: ( (lv_key_3_0= ruleExpression ) )
            // InternalExpression.g:3403:4: (lv_key_3_0= ruleExpression )
            {
            // InternalExpression.g:3403:4: (lv_key_3_0= ruleExpression )
            // InternalExpression.g:3404:5: lv_key_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinAccess().getKeyExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_key_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJoinRule());
              					}
              					set(
              						current,
              						"key",
              						lv_key_3_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getJoinAccess().getCommaKeyword_4());
              		
            }
            // InternalExpression.g:3425:3: ( (lv_delimiter_5_0= RULE_STRING ) )
            // InternalExpression.g:3426:4: (lv_delimiter_5_0= RULE_STRING )
            {
            // InternalExpression.g:3426:4: (lv_delimiter_5_0= RULE_STRING )
            // InternalExpression.g:3427:5: lv_delimiter_5_0= RULE_STRING
            {
            lv_delimiter_5_0=(Token)match(input,RULE_STRING,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_delimiter_5_0, grammarAccess.getJoinAccess().getDelimiterSTRINGTerminalRuleCall_5_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJoinRule());
              					}
              					setWithLastConsumed(
              						current,
              						"delimiter",
              						lv_delimiter_5_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalExpression.g:3443:3: (otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==22) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalExpression.g:3444:4: otherlv_6= ',' ( (lv_last_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getCommaKeyword_6_0());
                      			
                    }
                    // InternalExpression.g:3448:4: ( (lv_last_7_0= RULE_STRING ) )
                    // InternalExpression.g:3449:5: (lv_last_7_0= RULE_STRING )
                    {
                    // InternalExpression.g:3449:5: (lv_last_7_0= RULE_STRING )
                    // InternalExpression.g:3450:6: lv_last_7_0= RULE_STRING
                    {
                    lv_last_7_0=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_last_7_0, grammarAccess.getJoinAccess().getLastSTRINGTerminalRuleCall_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getJoinRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"last",
                      							lv_last_7_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getJoinAccess().getRightParenthesisKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJoin"


    // $ANTLR start "entryRuleDayDifference"
    // InternalExpression.g:3475:1: entryRuleDayDifference returns [EObject current=null] : iv_ruleDayDifference= ruleDayDifference EOF ;
    public final EObject entryRuleDayDifference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDayDifference = null;


        try {
            // InternalExpression.g:3475:54: (iv_ruleDayDifference= ruleDayDifference EOF )
            // InternalExpression.g:3476:2: iv_ruleDayDifference= ruleDayDifference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDayDifferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDayDifference=ruleDayDifference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDayDifference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDayDifference"


    // $ANTLR start "ruleDayDifference"
    // InternalExpression.g:3482:1: ruleDayDifference returns [EObject current=null] : (otherlv_0= 'dayDifference(' ( (lv_from_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_to_3_0= ruleExpression ) ) otherlv_4= ',' ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) ) otherlv_6= ')' ) ;
    public final EObject ruleDayDifference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_formatter_5_1=null;
        Token lv_formatter_5_2=null;
        Token lv_formatter_5_3=null;
        Token otherlv_6=null;
        EObject lv_from_1_0 = null;

        EObject lv_to_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3488:2: ( (otherlv_0= 'dayDifference(' ( (lv_from_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_to_3_0= ruleExpression ) ) otherlv_4= ',' ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) ) otherlv_6= ')' ) )
            // InternalExpression.g:3489:2: (otherlv_0= 'dayDifference(' ( (lv_from_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_to_3_0= ruleExpression ) ) otherlv_4= ',' ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) ) otherlv_6= ')' )
            {
            // InternalExpression.g:3489:2: (otherlv_0= 'dayDifference(' ( (lv_from_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_to_3_0= ruleExpression ) ) otherlv_4= ',' ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) ) otherlv_6= ')' )
            // InternalExpression.g:3490:3: otherlv_0= 'dayDifference(' ( (lv_from_1_0= ruleExpression ) ) otherlv_2= ',' ( (lv_to_3_0= ruleExpression ) ) otherlv_4= ',' ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDayDifferenceAccess().getDayDifferenceKeyword_0());
              		
            }
            // InternalExpression.g:3494:3: ( (lv_from_1_0= ruleExpression ) )
            // InternalExpression.g:3495:4: (lv_from_1_0= ruleExpression )
            {
            // InternalExpression.g:3495:4: (lv_from_1_0= ruleExpression )
            // InternalExpression.g:3496:5: lv_from_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDayDifferenceAccess().getFromExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_from_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDayDifferenceRule());
              					}
              					set(
              						current,
              						"from",
              						lv_from_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDayDifferenceAccess().getCommaKeyword_2());
              		
            }
            // InternalExpression.g:3517:3: ( (lv_to_3_0= ruleExpression ) )
            // InternalExpression.g:3518:4: (lv_to_3_0= ruleExpression )
            {
            // InternalExpression.g:3518:4: (lv_to_3_0= ruleExpression )
            // InternalExpression.g:3519:5: lv_to_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDayDifferenceAccess().getToExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_to_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDayDifferenceRule());
              					}
              					set(
              						current,
              						"to",
              						lv_to_3_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDayDifferenceAccess().getCommaKeyword_4());
              		
            }
            // InternalExpression.g:3540:3: ( ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) ) )
            // InternalExpression.g:3541:4: ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) )
            {
            // InternalExpression.g:3541:4: ( (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' ) )
            // InternalExpression.g:3542:5: (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' )
            {
            // InternalExpression.g:3542:5: (lv_formatter_5_1= '\"MM/dd/yyyy\"' | lv_formatter_5_2= '\"yyyyMMdd\"' | lv_formatter_5_3= '\"yyyy-MM-dd\"' )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt39=1;
                }
                break;
            case 52:
                {
                alt39=2;
                }
                break;
            case 53:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalExpression.g:3543:6: lv_formatter_5_1= '\"MM/dd/yyyy\"'
                    {
                    lv_formatter_5_1=(Token)match(input,51,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_formatter_5_1, grammarAccess.getDayDifferenceAccess().getFormatterMMDdYyyyKeyword_5_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDayDifferenceRule());
                      						}
                      						setWithLastConsumed(current, "formatter", lv_formatter_5_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:3554:6: lv_formatter_5_2= '\"yyyyMMdd\"'
                    {
                    lv_formatter_5_2=(Token)match(input,52,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_formatter_5_2, grammarAccess.getDayDifferenceAccess().getFormatterYyyyMMddKeyword_5_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDayDifferenceRule());
                      						}
                      						setWithLastConsumed(current, "formatter", lv_formatter_5_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:3565:6: lv_formatter_5_3= '\"yyyy-MM-dd\"'
                    {
                    lv_formatter_5_3=(Token)match(input,53,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_formatter_5_3, grammarAccess.getDayDifferenceAccess().getFormatterYyyyMMDdKeyword_5_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getDayDifferenceRule());
                      						}
                      						setWithLastConsumed(current, "formatter", lv_formatter_5_3, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            otherlv_6=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getDayDifferenceAccess().getRightParenthesisKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDayDifference"


    // $ANTLR start "entryRuleTranslateUnicode"
    // InternalExpression.g:3586:1: entryRuleTranslateUnicode returns [EObject current=null] : iv_ruleTranslateUnicode= ruleTranslateUnicode EOF ;
    public final EObject entryRuleTranslateUnicode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTranslateUnicode = null;


        try {
            // InternalExpression.g:3586:57: (iv_ruleTranslateUnicode= ruleTranslateUnicode EOF )
            // InternalExpression.g:3587:2: iv_ruleTranslateUnicode= ruleTranslateUnicode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTranslateUnicodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTranslateUnicode=ruleTranslateUnicode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTranslateUnicode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTranslateUnicode"


    // $ANTLR start "ruleTranslateUnicode"
    // InternalExpression.g:3593:1: ruleTranslateUnicode returns [EObject current=null] : (otherlv_0= 'translateUnicode(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleTranslateUnicode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exp_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3599:2: ( (otherlv_0= 'translateUnicode(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' ) )
            // InternalExpression.g:3600:2: (otherlv_0= 'translateUnicode(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:3600:2: (otherlv_0= 'translateUnicode(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')' )
            // InternalExpression.g:3601:3: otherlv_0= 'translateUnicode(' ( (lv_exp_1_0= ruleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTranslateUnicodeAccess().getTranslateUnicodeKeyword_0());
              		
            }
            // InternalExpression.g:3605:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3606:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3606:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3607:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTranslateUnicodeAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTranslateUnicodeRule());
              					}
              					set(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTranslateUnicodeAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTranslateUnicode"


    // $ANTLR start "entryRuleCurrentDate"
    // InternalExpression.g:3632:1: entryRuleCurrentDate returns [EObject current=null] : iv_ruleCurrentDate= ruleCurrentDate EOF ;
    public final EObject entryRuleCurrentDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurrentDate = null;


        try {
            // InternalExpression.g:3632:52: (iv_ruleCurrentDate= ruleCurrentDate EOF )
            // InternalExpression.g:3633:2: iv_ruleCurrentDate= ruleCurrentDate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurrentDateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCurrentDate=ruleCurrentDate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurrentDate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCurrentDate"


    // $ANTLR start "ruleCurrentDate"
    // InternalExpression.g:3639:1: ruleCurrentDate returns [EObject current=null] : ( () otherlv_1= 'currentDate(' ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )? otherlv_3= ')' ) ;
    public final EObject ruleCurrentDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_format_2_1=null;
        Token lv_format_2_2=null;
        Token lv_format_2_3=null;
        Token lv_format_2_4=null;
        Token lv_format_2_5=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalExpression.g:3645:2: ( ( () otherlv_1= 'currentDate(' ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )? otherlv_3= ')' ) )
            // InternalExpression.g:3646:2: ( () otherlv_1= 'currentDate(' ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )? otherlv_3= ')' )
            {
            // InternalExpression.g:3646:2: ( () otherlv_1= 'currentDate(' ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )? otherlv_3= ')' )
            // InternalExpression.g:3647:3: () otherlv_1= 'currentDate(' ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )? otherlv_3= ')'
            {
            // InternalExpression.g:3647:3: ()
            // InternalExpression.g:3648:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCurrentDateAccess().getCurrentDateAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,80,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCurrentDateAccess().getCurrentDateKeyword_1());
              		
            }
            // InternalExpression.g:3658:3: ( ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_STRING||(LA41_0>=51 && LA41_0<=54)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalExpression.g:3659:4: ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) )
                    {
                    // InternalExpression.g:3659:4: ( (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING ) )
                    // InternalExpression.g:3660:5: (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING )
                    {
                    // InternalExpression.g:3660:5: (lv_format_2_1= '\"MM/dd/yyyy\"' | lv_format_2_2= '\"yyyyMMdd\"' | lv_format_2_3= '\"yyyy-MM-dd\"' | lv_format_2_4= '\"ms\"' | lv_format_2_5= RULE_STRING )
                    int alt40=5;
                    switch ( input.LA(1) ) {
                    case 51:
                        {
                        alt40=1;
                        }
                        break;
                    case 52:
                        {
                        alt40=2;
                        }
                        break;
                    case 53:
                        {
                        alt40=3;
                        }
                        break;
                    case 54:
                        {
                        alt40=4;
                        }
                        break;
                    case RULE_STRING:
                        {
                        alt40=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // InternalExpression.g:3661:6: lv_format_2_1= '\"MM/dd/yyyy\"'
                            {
                            lv_format_2_1=(Token)match(input,51,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_format_2_1, grammarAccess.getCurrentDateAccess().getFormatMMDdYyyyKeyword_2_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getCurrentDateRule());
                              						}
                              						setWithLastConsumed(current, "format", lv_format_2_1, null);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalExpression.g:3672:6: lv_format_2_2= '\"yyyyMMdd\"'
                            {
                            lv_format_2_2=(Token)match(input,52,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_format_2_2, grammarAccess.getCurrentDateAccess().getFormatYyyyMMddKeyword_2_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getCurrentDateRule());
                              						}
                              						setWithLastConsumed(current, "format", lv_format_2_2, null);
                              					
                            }

                            }
                            break;
                        case 3 :
                            // InternalExpression.g:3683:6: lv_format_2_3= '\"yyyy-MM-dd\"'
                            {
                            lv_format_2_3=(Token)match(input,53,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_format_2_3, grammarAccess.getCurrentDateAccess().getFormatYyyyMMDdKeyword_2_0_2());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getCurrentDateRule());
                              						}
                              						setWithLastConsumed(current, "format", lv_format_2_3, null);
                              					
                            }

                            }
                            break;
                        case 4 :
                            // InternalExpression.g:3694:6: lv_format_2_4= '\"ms\"'
                            {
                            lv_format_2_4=(Token)match(input,54,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_format_2_4, grammarAccess.getCurrentDateAccess().getFormatMsKeyword_2_0_3());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getCurrentDateRule());
                              						}
                              						setWithLastConsumed(current, "format", lv_format_2_4, null);
                              					
                            }

                            }
                            break;
                        case 5 :
                            // InternalExpression.g:3705:6: lv_format_2_5= RULE_STRING
                            {
                            lv_format_2_5=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_format_2_5, grammarAccess.getCurrentDateAccess().getFormatSTRINGTerminalRuleCall_2_0_4());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getCurrentDateRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"format",
                              							lv_format_2_5,
                              							"org.eclipse.xtext.common.Terminals.STRING");
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCurrentDateAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCurrentDate"


    // $ANTLR start "entryRulePickFirst"
    // InternalExpression.g:3730:1: entryRulePickFirst returns [EObject current=null] : iv_rulePickFirst= rulePickFirst EOF ;
    public final EObject entryRulePickFirst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePickFirst = null;


        try {
            // InternalExpression.g:3730:50: (iv_rulePickFirst= rulePickFirst EOF )
            // InternalExpression.g:3731:2: iv_rulePickFirst= rulePickFirst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPickFirstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePickFirst=rulePickFirst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePickFirst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePickFirst"


    // $ANTLR start "rulePickFirst"
    // InternalExpression.g:3737:1: rulePickFirst returns [EObject current=null] : (otherlv_0= 'pickFirst(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= '->' ( (lv_condition_5_0= ruleComparison ) ) otherlv_6= ')' ) ;
    public final EObject rulePickFirst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_exp_1_0 = null;

        EObject lv_exp_3_0 = null;

        EObject lv_condition_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3743:2: ( (otherlv_0= 'pickFirst(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= '->' ( (lv_condition_5_0= ruleComparison ) ) otherlv_6= ')' ) )
            // InternalExpression.g:3744:2: (otherlv_0= 'pickFirst(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= '->' ( (lv_condition_5_0= ruleComparison ) ) otherlv_6= ')' )
            {
            // InternalExpression.g:3744:2: (otherlv_0= 'pickFirst(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= '->' ( (lv_condition_5_0= ruleComparison ) ) otherlv_6= ')' )
            // InternalExpression.g:3745:3: otherlv_0= 'pickFirst(' ( (lv_exp_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+ otherlv_4= '->' ( (lv_condition_5_0= ruleComparison ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPickFirstAccess().getPickFirstKeyword_0());
              		
            }
            // InternalExpression.g:3749:3: ( (lv_exp_1_0= ruleExpression ) )
            // InternalExpression.g:3750:4: (lv_exp_1_0= ruleExpression )
            {
            // InternalExpression.g:3750:4: (lv_exp_1_0= ruleExpression )
            // InternalExpression.g:3751:5: lv_exp_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPickFirstAccess().getExpExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_exp_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPickFirstRule());
              					}
              					add(
              						current,
              						"exp",
              						lv_exp_1_0,
              						"com.intuit.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:3768:3: (otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==22) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalExpression.g:3769:4: otherlv_2= ',' ( (lv_exp_3_0= ruleExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getPickFirstAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalExpression.g:3773:4: ( (lv_exp_3_0= ruleExpression ) )
            	    // InternalExpression.g:3774:5: (lv_exp_3_0= ruleExpression )
            	    {
            	    // InternalExpression.g:3774:5: (lv_exp_3_0= ruleExpression )
            	    // InternalExpression.g:3775:6: lv_exp_3_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPickFirstAccess().getExpExpressionParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_exp_3_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPickFirstRule());
            	      						}
            	      						add(
            	      							current,
            	      							"exp",
            	      							lv_exp_3_0,
            	      							"com.intuit.dsl.Expression.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);

            otherlv_4=(Token)match(input,68,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPickFirstAccess().getHyphenMinusGreaterThanSignKeyword_3());
              		
            }
            // InternalExpression.g:3797:3: ( (lv_condition_5_0= ruleComparison ) )
            // InternalExpression.g:3798:4: (lv_condition_5_0= ruleComparison )
            {
            // InternalExpression.g:3798:4: (lv_condition_5_0= ruleComparison )
            // InternalExpression.g:3799:5: lv_condition_5_0= ruleComparison
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPickFirstAccess().getConditionComparisonParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_condition_5_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPickFirstRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_5_0,
              						"com.intuit.dsl.Expression.Comparison");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getPickFirstAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePickFirst"


    // $ANTLR start "entryRuleVariable"
    // InternalExpression.g:3824:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalExpression.g:3824:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalExpression.g:3825:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalExpression.g:3831:1: ruleVariable returns [EObject current=null] : ( (lv_schemaVariable_0_0= ruleSchemaVariable ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_schemaVariable_0_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3837:2: ( ( (lv_schemaVariable_0_0= ruleSchemaVariable ) ) )
            // InternalExpression.g:3838:2: ( (lv_schemaVariable_0_0= ruleSchemaVariable ) )
            {
            // InternalExpression.g:3838:2: ( (lv_schemaVariable_0_0= ruleSchemaVariable ) )
            // InternalExpression.g:3839:3: (lv_schemaVariable_0_0= ruleSchemaVariable )
            {
            // InternalExpression.g:3839:3: (lv_schemaVariable_0_0= ruleSchemaVariable )
            // InternalExpression.g:3840:4: lv_schemaVariable_0_0= ruleSchemaVariable
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getVariableAccess().getSchemaVariableSchemaVariableParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_schemaVariable_0_0=ruleSchemaVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getVariableRule());
              				}
              				set(
              					current,
              					"schemaVariable",
              					lv_schemaVariable_0_0,
              					"com.intuit.dsl.Expression.SchemaVariable");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleKey"
    // InternalExpression.g:3860:1: entryRuleKey returns [EObject current=null] : iv_ruleKey= ruleKey EOF ;
    public final EObject entryRuleKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKey = null;


        try {
            // InternalExpression.g:3860:44: (iv_ruleKey= ruleKey EOF )
            // InternalExpression.g:3861:2: iv_ruleKey= ruleKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKey=ruleKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKey; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKey"


    // $ANTLR start "ruleKey"
    // InternalExpression.g:3867:1: ruleKey returns [EObject current=null] : ( ( (lv_id_0_0= ruleAllowedKeyword ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3873:2: ( ( ( (lv_id_0_0= ruleAllowedKeyword ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )? ) )
            // InternalExpression.g:3874:2: ( ( (lv_id_0_0= ruleAllowedKeyword ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            {
            // InternalExpression.g:3874:2: ( ( (lv_id_0_0= ruleAllowedKeyword ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            // InternalExpression.g:3875:3: ( (lv_id_0_0= ruleAllowedKeyword ) ) ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )?
            {
            // InternalExpression.g:3875:3: ( (lv_id_0_0= ruleAllowedKeyword ) )
            // InternalExpression.g:3876:4: (lv_id_0_0= ruleAllowedKeyword )
            {
            // InternalExpression.g:3876:4: (lv_id_0_0= ruleAllowedKeyword )
            // InternalExpression.g:3877:5: lv_id_0_0= ruleAllowedKeyword
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getKeyAccess().getIdAllowedKeywordParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_39);
            lv_id_0_0=ruleAllowedKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getKeyRule());
              					}
              					set(
              						current,
              						"id",
              						lv_id_0_0,
              						"com.intuit.dsl.Expression.AllowedKeyword");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:3894:3: ( ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==21) && (synpred4_InternalExpression())) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalExpression.g:3895:4: ( ( '[' )=>otherlv_1= '[' ) ( (lv_exp_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    // InternalExpression.g:3895:4: ( ( '[' )=>otherlv_1= '[' )
                    // InternalExpression.g:3896:5: ( '[' )=>otherlv_1= '['
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getKeyAccess().getLeftSquareBracketKeyword_1_0());
                      				
                    }

                    }

                    // InternalExpression.g:3902:4: ( (lv_exp_2_0= ruleExpression ) )
                    // InternalExpression.g:3903:5: (lv_exp_2_0= ruleExpression )
                    {
                    // InternalExpression.g:3903:5: (lv_exp_2_0= ruleExpression )
                    // InternalExpression.g:3904:6: lv_exp_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getKeyAccess().getExpExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_exp_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getKeyRule());
                      						}
                      						set(
                      							current,
                      							"exp",
                      							lv_exp_2_0,
                      							"com.intuit.dsl.Expression.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getKeyAccess().getRightSquareBracketKeyword_1_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKey"


    // $ANTLR start "entryRuleSchemaVariable"
    // InternalExpression.g:3930:1: entryRuleSchemaVariable returns [EObject current=null] : iv_ruleSchemaVariable= ruleSchemaVariable EOF ;
    public final EObject entryRuleSchemaVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchemaVariable = null;


        try {
            // InternalExpression.g:3930:55: (iv_ruleSchemaVariable= ruleSchemaVariable EOF )
            // InternalExpression.g:3931:2: iv_ruleSchemaVariable= ruleSchemaVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSchemaVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSchemaVariable=ruleSchemaVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSchemaVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSchemaVariable"


    // $ANTLR start "ruleSchemaVariable"
    // InternalExpression.g:3937:1: ruleSchemaVariable returns [EObject current=null] : ( ( (lv_global_0_0= '::' ) )? ( (lv_key_1_0= ruleKey ) ) (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )* ) ;
    public final EObject ruleSchemaVariable() throws RecognitionException {
        EObject current = null;

        Token lv_global_0_0=null;
        Token otherlv_2=null;
        EObject lv_key_1_0 = null;

        EObject lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:3943:2: ( ( ( (lv_global_0_0= '::' ) )? ( (lv_key_1_0= ruleKey ) ) (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )* ) )
            // InternalExpression.g:3944:2: ( ( (lv_global_0_0= '::' ) )? ( (lv_key_1_0= ruleKey ) ) (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )* )
            {
            // InternalExpression.g:3944:2: ( ( (lv_global_0_0= '::' ) )? ( (lv_key_1_0= ruleKey ) ) (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )* )
            // InternalExpression.g:3945:3: ( (lv_global_0_0= '::' ) )? ( (lv_key_1_0= ruleKey ) ) (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )*
            {
            // InternalExpression.g:3945:3: ( (lv_global_0_0= '::' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==82) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalExpression.g:3946:4: (lv_global_0_0= '::' )
                    {
                    // InternalExpression.g:3946:4: (lv_global_0_0= '::' )
                    // InternalExpression.g:3947:5: lv_global_0_0= '::'
                    {
                    lv_global_0_0=(Token)match(input,82,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_global_0_0, grammarAccess.getSchemaVariableAccess().getGlobalColonColonKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getSchemaVariableRule());
                      					}
                      					setWithLastConsumed(current, "global", lv_global_0_0, "::");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExpression.g:3959:3: ( (lv_key_1_0= ruleKey ) )
            // InternalExpression.g:3960:4: (lv_key_1_0= ruleKey )
            {
            // InternalExpression.g:3960:4: (lv_key_1_0= ruleKey )
            // InternalExpression.g:3961:5: lv_key_1_0= ruleKey
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSchemaVariableAccess().getKeyKeyParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_key_1_0=ruleKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSchemaVariableRule());
              					}
              					add(
              						current,
              						"key",
              						lv_key_1_0,
              						"com.intuit.dsl.Expression.Key");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:3978:3: (otherlv_2= '.' ( (lv_key_3_0= ruleKey ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==43) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalExpression.g:3979:4: otherlv_2= '.' ( (lv_key_3_0= ruleKey ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getSchemaVariableAccess().getFullStopKeyword_2_0());
            	      			
            	    }
            	    // InternalExpression.g:3983:4: ( (lv_key_3_0= ruleKey ) )
            	    // InternalExpression.g:3984:5: (lv_key_3_0= ruleKey )
            	    {
            	    // InternalExpression.g:3984:5: (lv_key_3_0= ruleKey )
            	    // InternalExpression.g:3985:6: lv_key_3_0= ruleKey
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSchemaVariableAccess().getKeyKeyParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_key_3_0=ruleKey();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getSchemaVariableRule());
            	      						}
            	      						add(
            	      							current,
            	      							"key",
            	      							lv_key_3_0,
            	      							"com.intuit.dsl.Expression.Key");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSchemaVariable"


    // $ANTLR start "entryRuleProperty"
    // InternalExpression.g:4007:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalExpression.g:4007:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalExpression.g:4008:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalExpression.g:4014:1: ruleProperty returns [EObject current=null] : (otherlv_0= '@Config(' ( (lv_key_1_0= RULE_STRING ) ) otherlv_2= ')' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_key_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalExpression.g:4020:2: ( (otherlv_0= '@Config(' ( (lv_key_1_0= RULE_STRING ) ) otherlv_2= ')' ) )
            // InternalExpression.g:4021:2: (otherlv_0= '@Config(' ( (lv_key_1_0= RULE_STRING ) ) otherlv_2= ')' )
            {
            // InternalExpression.g:4021:2: (otherlv_0= '@Config(' ( (lv_key_1_0= RULE_STRING ) ) otherlv_2= ')' )
            // InternalExpression.g:4022:3: otherlv_0= '@Config(' ( (lv_key_1_0= RULE_STRING ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPropertyAccess().getConfigKeyword_0());
              		
            }
            // InternalExpression.g:4026:3: ( (lv_key_1_0= RULE_STRING ) )
            // InternalExpression.g:4027:4: (lv_key_1_0= RULE_STRING )
            {
            // InternalExpression.g:4027:4: (lv_key_1_0= RULE_STRING )
            // InternalExpression.g:4028:5: lv_key_1_0= RULE_STRING
            {
            lv_key_1_0=(Token)match(input,RULE_STRING,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_key_1_0, grammarAccess.getPropertyAccess().getKeySTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyRule());
              					}
              					setWithLastConsumed(
              						current,
              						"key",
              						lv_key_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleAllowedKeyword"
    // InternalExpression.g:4052:1: entryRuleAllowedKeyword returns [String current=null] : iv_ruleAllowedKeyword= ruleAllowedKeyword EOF ;
    public final String entryRuleAllowedKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAllowedKeyword = null;


        try {
            // InternalExpression.g:4052:54: (iv_ruleAllowedKeyword= ruleAllowedKeyword EOF )
            // InternalExpression.g:4053:2: iv_ruleAllowedKeyword= ruleAllowedKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAllowedKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAllowedKeyword=ruleAllowedKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAllowedKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAllowedKeyword"


    // $ANTLR start "ruleAllowedKeyword"
    // InternalExpression.g:4059:1: ruleAllowedKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'length' | kw= 'filter' | kw= 'delete' | kw= 'path' | kw= 'it' | kw= 'field' | kw= 'default' | kw= 'template' | kw= 'uuid' | kw= 'parent' | kw= 'json' | kw= 'join' | kw= 'translateUnicode' | kw= 'upperCase' | kw= 'lowerCase' | kw= 'concat' ) ;
    public final AntlrDatatypeRuleToken ruleAllowedKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalExpression.g:4065:2: ( (this_ID_0= RULE_ID | kw= 'length' | kw= 'filter' | kw= 'delete' | kw= 'path' | kw= 'it' | kw= 'field' | kw= 'default' | kw= 'template' | kw= 'uuid' | kw= 'parent' | kw= 'json' | kw= 'join' | kw= 'translateUnicode' | kw= 'upperCase' | kw= 'lowerCase' | kw= 'concat' ) )
            // InternalExpression.g:4066:2: (this_ID_0= RULE_ID | kw= 'length' | kw= 'filter' | kw= 'delete' | kw= 'path' | kw= 'it' | kw= 'field' | kw= 'default' | kw= 'template' | kw= 'uuid' | kw= 'parent' | kw= 'json' | kw= 'join' | kw= 'translateUnicode' | kw= 'upperCase' | kw= 'lowerCase' | kw= 'concat' )
            {
            // InternalExpression.g:4066:2: (this_ID_0= RULE_ID | kw= 'length' | kw= 'filter' | kw= 'delete' | kw= 'path' | kw= 'it' | kw= 'field' | kw= 'default' | kw= 'template' | kw= 'uuid' | kw= 'parent' | kw= 'json' | kw= 'join' | kw= 'translateUnicode' | kw= 'upperCase' | kw= 'lowerCase' | kw= 'concat' )
            int alt46=17;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt46=1;
                }
                break;
            case 84:
                {
                alt46=2;
                }
                break;
            case 85:
                {
                alt46=3;
                }
                break;
            case 86:
                {
                alt46=4;
                }
                break;
            case 87:
                {
                alt46=5;
                }
                break;
            case 88:
                {
                alt46=6;
                }
                break;
            case 89:
                {
                alt46=7;
                }
                break;
            case 90:
                {
                alt46=8;
                }
                break;
            case 91:
                {
                alt46=9;
                }
                break;
            case 92:
                {
                alt46=10;
                }
                break;
            case 93:
                {
                alt46=11;
                }
                break;
            case 94:
                {
                alt46=12;
                }
                break;
            case 95:
                {
                alt46=13;
                }
                break;
            case 96:
                {
                alt46=14;
                }
                break;
            case 97:
                {
                alt46=15;
                }
                break;
            case 98:
                {
                alt46=16;
                }
                break;
            case 99:
                {
                alt46=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalExpression.g:4067:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getAllowedKeywordAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:4075:3: kw= 'length'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getLengthKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:4081:3: kw= 'filter'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getFilterKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:4087:3: kw= 'delete'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getDeleteKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:4093:3: kw= 'path'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getPathKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpression.g:4099:3: kw= 'it'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getItKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExpression.g:4105:3: kw= 'field'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getFieldKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExpression.g:4111:3: kw= 'default'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getDefaultKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalExpression.g:4117:3: kw= 'template'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getTemplateKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalExpression.g:4123:3: kw= 'uuid'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getUuidKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalExpression.g:4129:3: kw= 'parent'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getParentKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalExpression.g:4135:3: kw= 'json'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getJsonKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalExpression.g:4141:3: kw= 'join'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getJoinKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalExpression.g:4147:3: kw= 'translateUnicode'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getTranslateUnicodeKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalExpression.g:4153:3: kw= 'upperCase'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getUpperCaseKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalExpression.g:4159:3: kw= 'lowerCase'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getLowerCaseKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalExpression.g:4165:3: kw= 'concat'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAllowedKeywordAccess().getConcatKeyword_16());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAllowedKeyword"


    // $ANTLR start "entryRuleNUMBER"
    // InternalExpression.g:4174:1: entryRuleNUMBER returns [String current=null] : iv_ruleNUMBER= ruleNUMBER EOF ;
    public final String entryRuleNUMBER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER = null;


        try {
            // InternalExpression.g:4174:46: (iv_ruleNUMBER= ruleNUMBER EOF )
            // InternalExpression.g:4175:2: iv_ruleNUMBER= ruleNUMBER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBERRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNUMBER=ruleNUMBER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUMBER"


    // $ANTLR start "ruleNUMBER"
    // InternalExpression.g:4181:1: ruleNUMBER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleNUMBER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_INT_1=null;
        Token kw=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalExpression.g:4187:2: ( (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) ) )
            // InternalExpression.g:4188:2: (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) )
            {
            // InternalExpression.g:4188:2: (this_INT_0= RULE_INT | (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_INT) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==EOF||LA47_1==RULE_ID||(LA47_1>=11 && LA47_1<=20)||(LA47_1>=22 && LA47_1<=33)||(LA47_1>=39 && LA47_1<=40)||LA47_1==42||(LA47_1>=65 && LA47_1<=69)||(LA47_1>=84 && LA47_1<=99)) ) {
                    alt47=1;
                }
                else if ( (LA47_1==43) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalExpression.g:4189:3: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_0, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:4197:3: (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT )
                    {
                    // InternalExpression.g:4197:3: (this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT )
                    // InternalExpression.g:4198:4: this_INT_1= RULE_INT kw= '.' this_INT_3= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_1, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_0());
                      			
                    }
                    kw=(Token)match(input,43,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNUMBERAccess().getFullStopKeyword_1_1());
                      			
                    }
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_3, grammarAccess.getNUMBERAccess().getINTTerminalRuleCall_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMBER"

    // $ANTLR start synpred1_InternalExpression
    public final void synpred1_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:560:5: ( ( ( () '+' ) | ( () '-' ) ) )
        // InternalExpression.g:560:6: ( ( () '+' ) | ( () '-' ) )
        {
        // InternalExpression.g:560:6: ( ( () '+' ) | ( () '-' ) )
        int alt48=2;
        int LA48_0 = input.LA(1);

        if ( (LA48_0==29) ) {
            alt48=1;
        }
        else if ( (LA48_0==30) ) {
            alt48=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 48, 0, input);

            throw nvae;
        }
        switch (alt48) {
            case 1 :
                // InternalExpression.g:561:6: ( () '+' )
                {
                // InternalExpression.g:561:6: ( () '+' )
                // InternalExpression.g:562:7: () '+'
                {
                // InternalExpression.g:562:7: ()
                // InternalExpression.g:563:7: 
                {
                }

                match(input,29,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;
            case 2 :
                // InternalExpression.g:567:6: ( () '-' )
                {
                // InternalExpression.g:567:6: ( () '-' )
                // InternalExpression.g:568:7: () '-'
                {
                // InternalExpression.g:568:7: ()
                // InternalExpression.g:569:7: 
                {
                }

                match(input,30,FOLLOW_2); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred1_InternalExpression

    // $ANTLR start synpred2_InternalExpression
    public final void synpred2_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:1156:5: ( 'else' )
        // InternalExpression.g:1156:6: 'else'
        {
        match(input,40,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalExpression

    // $ANTLR start synpred3_InternalExpression
    public final void synpred3_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:1488:5: ( '[' )
        // InternalExpression.g:1488:6: '['
        {
        match(input,21,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalExpression

    // $ANTLR start synpred4_InternalExpression
    public final void synpred4_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:3896:5: ( '[' )
        // InternalExpression.g:3896:6: '['
        {
        match(input,21,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalExpression

    // Delegated rules

    public final boolean synpred2_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000007802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x3E87F27C40200070L,0x0000000FFFFFFF81L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000001F000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000080000200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L,0x0000000FFFF40000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x3E87F27C40200070L,0x0000000FFFFFFFA1L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0078000000000010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000040000400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001AL});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x3E87F27C40200070L,0x0000000FFFFFFF83L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000020L,0x0000000FFFF40004L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x3E87F27C40200072L,0x0000000FFFFFFF81L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0038000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0078040000000010L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L});

}