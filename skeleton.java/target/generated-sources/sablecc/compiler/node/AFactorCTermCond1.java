/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AFactorCTermCond1 extends PTermCond1
{
    private PFactorCond _factorCond_;

    public AFactorCTermCond1()
    {
        // Constructor
    }

    public AFactorCTermCond1(
        @SuppressWarnings("hiding") PFactorCond _factorCond_)
    {
        // Constructor
        setFactorCond(_factorCond_);

    }

    @Override
    public Object clone()
    {
        return new AFactorCTermCond1(
            cloneNode(this._factorCond_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFactorCTermCond1(this);
    }

    public PFactorCond getFactorCond()
    {
        return this._factorCond_;
    }

    public void setFactorCond(PFactorCond node)
    {
        if(this._factorCond_ != null)
        {
            this._factorCond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._factorCond_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._factorCond_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._factorCond_ == child)
        {
            this._factorCond_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._factorCond_ == oldChild)
        {
            setFactorCond((PFactorCond) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}