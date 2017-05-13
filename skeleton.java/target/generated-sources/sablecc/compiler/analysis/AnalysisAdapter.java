/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.analysis;

import java.util.*;
import compiler.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    public void caseAFuncDef(AFuncDef node)
    {
        defaultCase(node);
    }

    public void caseAWithHeaderHelperBiggerHeader(AWithHeaderHelperBiggerHeader node)
    {
        defaultCase(node);
    }

    public void caseAWithoutHeaderHelperBiggerHeader(AWithoutHeaderHelperBiggerHeader node)
    {
        defaultCase(node);
    }

    public void caseAHeaderHelper(AHeaderHelper node)
    {
        defaultCase(node);
    }

    public void caseAHeaderHelperBigger(AHeaderHelperBigger node)
    {
        defaultCase(node);
    }

    public void caseAHeaderHelper2(AHeaderHelper2 node)
    {
        defaultCase(node);
    }

    public void caseAWithRefFparDef(AWithRefFparDef node)
    {
        defaultCase(node);
    }

    public void caseANoRefFparDef(ANoRefFparDef node)
    {
        defaultCase(node);
    }

    public void caseAIntDataType(AIntDataType node)
    {
        defaultCase(node);
    }

    public void caseACharDataType(ACharDataType node)
    {
        defaultCase(node);
    }

    public void caseADtType(ADtType node)
    {
        defaultCase(node);
    }

    public void caseAArType(AArType node)
    {
        defaultCase(node);
    }

    public void caseATypeHelper(ATypeHelper node)
    {
        defaultCase(node);
    }

    public void caseADtRetType(ADtRetType node)
    {
        defaultCase(node);
    }

    public void caseANothingRetType(ANothingRetType node)
    {
        defaultCase(node);
    }

    public void caseADtWithHelperFparType(ADtWithHelperFparType node)
    {
        defaultCase(node);
    }

    public void caseADtWithoutHelperFparType(ADtWithoutHelperFparType node)
    {
        defaultCase(node);
    }

    public void caseAArrFparType(AArrFparType node)
    {
        defaultCase(node);
    }

    public void caseABrs(ABrs node)
    {
        defaultCase(node);
    }

    public void caseAFparTypeHelper(AFparTypeHelper node)
    {
        defaultCase(node);
    }

    public void caseAWithBrsFparTypeHelper2(AWithBrsFparTypeHelper2 node)
    {
        defaultCase(node);
    }

    public void caseAWithoutBrsFparTypeHelper2(AWithoutBrsFparTypeHelper2 node)
    {
        defaultCase(node);
    }

    public void caseAFuncDefLocalDef(AFuncDefLocalDef node)
    {
        defaultCase(node);
    }

    public void caseAFuncDeclLocalDef(AFuncDeclLocalDef node)
    {
        defaultCase(node);
    }

    public void caseAVarDefLocalDef(AVarDefLocalDef node)
    {
        defaultCase(node);
    }

    public void caseAVarDef(AVarDef node)
    {
        defaultCase(node);
    }

    public void caseAVarDefHelper(AVarDefHelper node)
    {
        defaultCase(node);
    }

    public void caseAColonId(AColonId node)
    {
        defaultCase(node);
    }

    public void caseAFuncDecl(AFuncDecl node)
    {
        defaultCase(node);
    }

    public void caseASemicolonStmt(ASemicolonStmt node)
    {
        defaultCase(node);
    }

    public void caseAExpressionStmt(AExpressionStmt node)
    {
        defaultCase(node);
    }

    public void caseABlockStmt(ABlockStmt node)
    {
        defaultCase(node);
    }

    public void caseAFuncallStmt(AFuncallStmt node)
    {
        defaultCase(node);
    }

    public void caseAIfStmt(AIfStmt node)
    {
        defaultCase(node);
    }

    public void caseAWhileStmt(AWhileStmt node)
    {
        defaultCase(node);
    }

    public void caseAReturnWithExprStmt(AReturnWithExprStmt node)
    {
        defaultCase(node);
    }

    public void caseAReturnExprStmt(AReturnExprStmt node)
    {
        defaultCase(node);
    }

    public void caseAReturnStmt(AReturnStmt node)
    {
        defaultCase(node);
    }

    public void caseANoElseIfStmt(ANoElseIfStmt node)
    {
        defaultCase(node);
    }

    public void caseAWithElseIfStmt(AWithElseIfStmt node)
    {
        defaultCase(node);
    }

    public void caseASemicolonStmtWithElse(ASemicolonStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAExpressionStmtWithElse(AExpressionStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseABlockStmtWithElse(ABlockStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAFuncallStmtWithElse(AFuncallStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAIfElseStmtWithElse(AIfElseStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAWhileStmtWithElse(AWhileStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAReturnWithExprStmtWithElse(AReturnWithExprStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAReturnExprStmtWithElse(AReturnExprStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAReturnStmtWithElse(AReturnStmtWithElse node)
    {
        defaultCase(node);
    }

    public void caseAIfElseStmt(AIfElseStmt node)
    {
        defaultCase(node);
    }

    public void caseASemicolonId(ASemicolonId node)
    {
        defaultCase(node);
    }

    public void caseADoId(ADoId node)
    {
        defaultCase(node);
    }

    public void caseAThenId(AThenId node)
    {
        defaultCase(node);
    }

    public void caseAElseId(AElseId node)
    {
        defaultCase(node);
    }

    public void caseAAssignId(AAssignId node)
    {
        defaultCase(node);
    }

    public void caseABlockBlock(ABlockBlock node)
    {
        defaultCase(node);
    }

    public void caseAWithParFuncCall(AWithParFuncCall node)
    {
        defaultCase(node);
    }

    public void caseAWithoutParFuncCall(AWithoutParFuncCall node)
    {
        defaultCase(node);
    }

    public void caseAParametersParameters(AParametersParameters node)
    {
        defaultCase(node);
    }

    public void caseAParameterParameter(AParameterParameter node)
    {
        defaultCase(node);
    }

    public void caseAVarLValue(AVarLValue node)
    {
        defaultCase(node);
    }

    public void caseAConstantStringLValue(AConstantStringLValue node)
    {
        defaultCase(node);
    }

    public void caseALValueLValue(ALValueLValue node)
    {
        defaultCase(node);
    }

    public void caseALbrId(ALbrId node)
    {
        defaultCase(node);
    }

    public void caseARbrId(ARbrId node)
    {
        defaultCase(node);
    }

    public void caseAExprcalcAllExpr(AExprcalcAllExpr node)
    {
        defaultCase(node);
    }

    public void caseAGenAllExpr(AGenAllExpr node)
    {
        defaultCase(node);
    }

    public void caseAParexprGeneralExpr(AParexprGeneralExpr node)
    {
        defaultCase(node);
    }

    public void caseATermExprCalc(ATermExprCalc node)
    {
        defaultCase(node);
    }

    public void caseAAddSubExprCalc(AAddSubExprCalc node)
    {
        defaultCase(node);
    }

    public void caseAFactorTerm(AFactorTerm node)
    {
        defaultCase(node);
    }

    public void caseARestSignsTerm(ARestSignsTerm node)
    {
        defaultCase(node);
    }

    public void caseANumberFactor(ANumberFactor node)
    {
        defaultCase(node);
    }

    public void caseALetterFactor(ALetterFactor node)
    {
        defaultCase(node);
    }

    public void caseALValueFactor(ALValueFactor node)
    {
        defaultCase(node);
    }

    public void caseAExprCalcFactor(AExprCalcFactor node)
    {
        defaultCase(node);
    }

    public void caseAFunFactor(AFunFactor node)
    {
        defaultCase(node);
    }

    public void caseAWithPlminExprSigns(AWithPlminExprSigns node)
    {
        defaultCase(node);
    }

    public void caseAWithoutPlminExprSigns(AWithoutPlminExprSigns node)
    {
        defaultCase(node);
    }

    public void caseAParexprParenthesesExpr(AParexprParenthesesExpr node)
    {
        defaultCase(node);
    }

    public void caseAPlusPlusMinus(APlusPlusMinus node)
    {
        defaultCase(node);
    }

    public void caseAMinusPlusMinus(AMinusPlusMinus node)
    {
        defaultCase(node);
    }

    public void caseAPlusPlusMinus2(APlusPlusMinus2 node)
    {
        defaultCase(node);
    }

    public void caseAMinusPlusMinus2(AMinusPlusMinus2 node)
    {
        defaultCase(node);
    }

    public void caseAMultRestSigns(AMultRestSigns node)
    {
        defaultCase(node);
    }

    public void caseADivRestSigns(ADivRestSigns node)
    {
        defaultCase(node);
    }

    public void caseADiv1RestSigns(ADiv1RestSigns node)
    {
        defaultCase(node);
    }

    public void caseAModRestSigns(AModRestSigns node)
    {
        defaultCase(node);
    }

    public void caseACondInParCond(ACondInParCond node)
    {
        defaultCase(node);
    }

    public void caseACondExpCond(ACondExpCond node)
    {
        defaultCase(node);
    }

    public void caseAExprsignsAssCond(AExprsignsAssCond node)
    {
        defaultCase(node);
    }

    public void caseACondparCondInPar(ACondparCondInPar node)
    {
        defaultCase(node);
    }

    public void caseAEqualAssSigns(AEqualAssSigns node)
    {
        defaultCase(node);
    }

    public void caseANeAssSigns(ANeAssSigns node)
    {
        defaultCase(node);
    }

    public void caseASmallAssSigns(ASmallAssSigns node)
    {
        defaultCase(node);
    }

    public void caseAGreatAssSigns(AGreatAssSigns node)
    {
        defaultCase(node);
    }

    public void caseASmalleAssSigns(ASmalleAssSigns node)
    {
        defaultCase(node);
    }

    public void caseAGreateAssSigns(AGreateAssSigns node)
    {
        defaultCase(node);
    }

    public void caseATermCond2CondExpr(ATermCond2CondExpr node)
    {
        defaultCase(node);
    }

    public void caseAOrCondExpr(AOrCondExpr node)
    {
        defaultCase(node);
    }

    public void caseATermCond1TermCond2(ATermCond1TermCond2 node)
    {
        defaultCase(node);
    }

    public void caseAAndTermCond2(AAndTermCond2 node)
    {
        defaultCase(node);
    }

    public void caseAFactorCTermCond1(AFactorCTermCond1 node)
    {
        defaultCase(node);
    }

    public void caseANotTermCond1(ANotTermCond1 node)
    {
        defaultCase(node);
    }

    public void caseALogicalAnd(ALogicalAnd node)
    {
        defaultCase(node);
    }

    public void caseALogicalOr(ALogicalOr node)
    {
        defaultCase(node);
    }

    public void caseALogicalNot(ALogicalNot node)
    {
        defaultCase(node);
    }

    public void caseAAsCondFactorCond(AAsCondFactorCond node)
    {
        defaultCase(node);
    }

    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    public void caseTChar(TChar node)
    {
        defaultCase(node);
    }

    public void caseTDiv1(TDiv1 node)
    {
        defaultCase(node);
    }

    public void caseTDo(TDo node)
    {
        defaultCase(node);
    }

    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    public void caseTFun(TFun node)
    {
        defaultCase(node);
    }

    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    public void caseTMod(TMod node)
    {
        defaultCase(node);
    }

    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    public void caseTNothing(TNothing node)
    {
        defaultCase(node);
    }

    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    public void caseTRef(TRef node)
    {
        defaultCase(node);
    }

    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    public void caseTVar(TVar node)
    {
        defaultCase(node);
    }

    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    public void caseTSpace(TSpace node)
    {
        defaultCase(node);
    }

    public void caseTVarName(TVarName node)
    {
        defaultCase(node);
    }

    public void caseTConstant(TConstant node)
    {
        defaultCase(node);
    }

    public void caseTConstantCharacter(TConstantCharacter node)
    {
        defaultCase(node);
    }

    public void caseTConstantString(TConstantString node)
    {
        defaultCase(node);
    }

    public void caseTWhiteSpace(TWhiteSpace node)
    {
        defaultCase(node);
    }

    public void caseTCommentLine(TCommentLine node)
    {
        defaultCase(node);
    }

    public void caseTMulCommentLine(TMulCommentLine node)
    {
        defaultCase(node);
    }

    public void caseTArray(TArray node)
    {
        defaultCase(node);
    }

    public void caseTAnotherType(TAnotherType node)
    {
        defaultCase(node);
    }

    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    public void caseTLBr(TLBr node)
    {
        defaultCase(node);
    }

    public void caseTRBr(TRBr node)
    {
        defaultCase(node);
    }

    public void caseTCurlyLBr(TCurlyLBr node)
    {
        defaultCase(node);
    }

    public void caseTCurlyRBr(TCurlyRBr node)
    {
        defaultCase(node);
    }

    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    public void caseTSemicolon(TSemicolon node)
    {
        defaultCase(node);
    }

    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    public void caseTAssign(TAssign node)
    {
        defaultCase(node);
    }

    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    public void caseTNotEqual(TNotEqual node)
    {
        defaultCase(node);
    }

    public void caseTGreater(TGreater node)
    {
        defaultCase(node);
    }

    public void caseTSmaller(TSmaller node)
    {
        defaultCase(node);
    }

    public void caseTSmallerEq(TSmallerEq node)
    {
        defaultCase(node);
    }

    public void caseTGreaterEq(TGreaterEq node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}