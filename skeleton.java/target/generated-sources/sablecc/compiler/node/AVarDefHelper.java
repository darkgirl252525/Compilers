/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AVarDefHelper extends PVarDefHelper
{
    private TComma _comma_;
    private TVarName _varName_;

    public AVarDefHelper()
    {
        // Constructor
    }

    public AVarDefHelper(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") TVarName _varName_)
    {
        // Constructor
        setComma(_comma_);

        setVarName(_varName_);

    }

    @Override
    public Object clone()
    {
        return new AVarDefHelper(
            cloneNode(this._comma_),
            cloneNode(this._varName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarDefHelper(this);
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

    public TVarName getVarName()
    {
        return this._varName_;
    }

    public void setVarName(TVarName node)
    {
        if(this._varName_ != null)
        {
            this._varName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._varName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comma_)
            + toString(this._varName_);
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

        if(this._varName_ == child)
        {
            this._varName_ = null;
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

        if(this._varName_ == oldChild)
        {
            setVarName((TVarName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
