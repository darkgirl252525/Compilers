/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.parser;

import compiler.node.*;
import compiler.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 0;
    }

    @Override
    public void caseTChar(@SuppressWarnings("unused") TChar node)
    {
        this.index = 1;
    }

    @Override
    public void caseTDiv1(@SuppressWarnings("unused") TDiv1 node)
    {
        this.index = 2;
    }

    @Override
    public void caseTDo(@SuppressWarnings("unused") TDo node)
    {
        this.index = 3;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 4;
    }

    @Override
    public void caseTFun(@SuppressWarnings("unused") TFun node)
    {
        this.index = 5;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 6;
    }

    @Override
    public void caseTInt(@SuppressWarnings("unused") TInt node)
    {
        this.index = 7;
    }

    @Override
    public void caseTMod(@SuppressWarnings("unused") TMod node)
    {
        this.index = 8;
    }

    @Override
    public void caseTNot(@SuppressWarnings("unused") TNot node)
    {
        this.index = 9;
    }

    @Override
    public void caseTNothing(@SuppressWarnings("unused") TNothing node)
    {
        this.index = 10;
    }

    @Override
    public void caseTOr(@SuppressWarnings("unused") TOr node)
    {
        this.index = 11;
    }

    @Override
    public void caseTRef(@SuppressWarnings("unused") TRef node)
    {
        this.index = 12;
    }

    @Override
    public void caseTReturn(@SuppressWarnings("unused") TReturn node)
    {
        this.index = 13;
    }

    @Override
    public void caseTThen(@SuppressWarnings("unused") TThen node)
    {
        this.index = 14;
    }

    @Override
    public void caseTVar(@SuppressWarnings("unused") TVar node)
    {
        this.index = 15;
    }

    @Override
    public void caseTWhile(@SuppressWarnings("unused") TWhile node)
    {
        this.index = 16;
    }

    @Override
    public void caseTSpace(@SuppressWarnings("unused") TSpace node)
    {
        this.index = 17;
    }

    @Override
    public void caseTVarName(@SuppressWarnings("unused") TVarName node)
    {
        this.index = 18;
    }

    @Override
    public void caseTConstant(@SuppressWarnings("unused") TConstant node)
    {
        this.index = 19;
    }

    @Override
    public void caseTConstantCharacter(@SuppressWarnings("unused") TConstantCharacter node)
    {
        this.index = 20;
    }

    @Override
    public void caseTConstantString(@SuppressWarnings("unused") TConstantString node)
    {
        this.index = 21;
    }

    @Override
    public void caseTArray(@SuppressWarnings("unused") TArray node)
    {
        this.index = 22;
    }

    @Override
    public void caseTAnotherType(@SuppressWarnings("unused") TAnotherType node)
    {
        this.index = 23;
    }

    @Override
    public void caseTLPar(@SuppressWarnings("unused") TLPar node)
    {
        this.index = 24;
    }

    @Override
    public void caseTRPar(@SuppressWarnings("unused") TRPar node)
    {
        this.index = 25;
    }

    @Override
    public void caseTLBr(@SuppressWarnings("unused") TLBr node)
    {
        this.index = 26;
    }

    @Override
    public void caseTRBr(@SuppressWarnings("unused") TRBr node)
    {
        this.index = 27;
    }

    @Override
    public void caseTCurlyLBr(@SuppressWarnings("unused") TCurlyLBr node)
    {
        this.index = 28;
    }

    @Override
    public void caseTCurlyRBr(@SuppressWarnings("unused") TCurlyRBr node)
    {
        this.index = 29;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 30;
    }

    @Override
    public void caseTSemicolon(@SuppressWarnings("unused") TSemicolon node)
    {
        this.index = 31;
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        this.index = 32;
    }

    @Override
    public void caseTAssign(@SuppressWarnings("unused") TAssign node)
    {
        this.index = 33;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 34;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 35;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 36;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 37;
    }

    @Override
    public void caseTEqual(@SuppressWarnings("unused") TEqual node)
    {
        this.index = 38;
    }

    @Override
    public void caseTNotEqual(@SuppressWarnings("unused") TNotEqual node)
    {
        this.index = 39;
    }

    @Override
    public void caseTGreater(@SuppressWarnings("unused") TGreater node)
    {
        this.index = 40;
    }

    @Override
    public void caseTSmaller(@SuppressWarnings("unused") TSmaller node)
    {
        this.index = 41;
    }

    @Override
    public void caseTSmallerEq(@SuppressWarnings("unused") TSmallerEq node)
    {
        this.index = 42;
    }

    @Override
    public void caseTGreaterEq(@SuppressWarnings("unused") TGreaterEq node)
    {
        this.index = 43;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 44;
    }
}
