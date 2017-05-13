/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AParameterParameter extends PParameter
{
    private TComma _comma_;
    private PAllExpr _allExpr_;

    public AParameterParameter()
    {
        // Constructor
    }

    public AParameterParameter(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PAllExpr _allExpr_)
    {
        // Constructor
        setComma(_comma_);

        setAllExpr(_allExpr_);

    }

    @Override
    public Object clone()
    {
        return new AParameterParameter(
            cloneNode(this._comma_),
            cloneNode(this._allExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParameterParameter(this);
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PAllExpr getAllExpr()
    {
        return this._allExpr_;
    }

    public void setAllExpr(PAllExpr node)
    {
        if(this._allExpr_ != null)
        {
            this._allExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._allExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comma_)
            + toString(this._allExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._allExpr_ == child)
        {
            this._allExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._allExpr_ == oldChild)
        {
            setAllExpr((PAllExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
