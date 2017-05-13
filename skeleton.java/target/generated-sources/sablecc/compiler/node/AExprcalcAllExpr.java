/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AExprcalcAllExpr extends PAllExpr
{
    private PExprCalc _exprCalc_;

    public AExprcalcAllExpr()
    {
        // Constructor
    }

    public AExprcalcAllExpr(
        @SuppressWarnings("hiding") PExprCalc _exprCalc_)
    {
        // Constructor
        setExprCalc(_exprCalc_);

    }

    @Override
    public Object clone()
    {
        return new AExprcalcAllExpr(
            cloneNode(this._exprCalc_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprcalcAllExpr(this);
    }

    public PExprCalc getExprCalc()
    {
        return this._exprCalc_;
    }

    public void setExprCalc(PExprCalc node)
    {
        if(this._exprCalc_ != null)
        {
            this._exprCalc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exprCalc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exprCalc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exprCalc_ == child)
        {
            this._exprCalc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exprCalc_ == oldChild)
        {
            setExprCalc((PExprCalc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
