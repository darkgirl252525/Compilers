/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AHeaderHelper extends PHeaderHelper
{
    private TSemicolon _semicolon_;
    private PFparDef _fparDef_;

    public AHeaderHelper()
    {
        // Constructor
    }

    public AHeaderHelper(
        @SuppressWarnings("hiding") TSemicolon _semicolon_,
        @SuppressWarnings("hiding") PFparDef _fparDef_)
    {
        // Constructor
        setSemicolon(_semicolon_);

        setFparDef(_fparDef_);

    }

    @Override
    public Object clone()
    {
        return new AHeaderHelper(
            cloneNode(this._semicolon_),
            cloneNode(this._fparDef_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAHeaderHelper(this);
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    public PFparDef getFparDef()
    {
        return this._fparDef_;
    }

    public void setFparDef(PFparDef node)
    {
        if(this._fparDef_ != null)
        {
            this._fparDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fparDef_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._semicolon_)
            + toString(this._fparDef_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        if(this._fparDef_ == child)
        {
            this._fparDef_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        if(this._fparDef_ == oldChild)
        {
            setFparDef((PFparDef) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
