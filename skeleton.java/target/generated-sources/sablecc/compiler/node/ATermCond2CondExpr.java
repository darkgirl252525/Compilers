/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ATermCond2CondExpr extends PCondExpr
{
    private PTermCond2 _termCond2_;

    public ATermCond2CondExpr()
    {
        // Constructor
    }

    public ATermCond2CondExpr(
        @SuppressWarnings("hiding") PTermCond2 _termCond2_)
    {
        // Constructor
        setTermCond2(_termCond2_);

    }

    @Override
    public Object clone()
    {
        return new ATermCond2CondExpr(
            cloneNode(this._termCond2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATermCond2CondExpr(this);
    }

    public PTermCond2 getTermCond2()
    {
        return this._termCond2_;
    }

    public void setTermCond2(PTermCond2 node)
    {
        if(this._termCond2_ != null)
        {
            this._termCond2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._termCond2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._termCond2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._termCond2_ == child)
        {
            this._termCond2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._termCond2_ == oldChild)
        {
            setTermCond2((PTermCond2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
