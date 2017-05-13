/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ALbrId extends PLbrId
{
    private TLBr _lBr_;

    public ALbrId()
    {
        // Constructor
    }

    public ALbrId(
        @SuppressWarnings("hiding") TLBr _lBr_)
    {
        // Constructor
        setLBr(_lBr_);

    }

    @Override
    public Object clone()
    {
        return new ALbrId(
            cloneNode(this._lBr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALbrId(this);
    }

    public TLBr getLBr()
    {
        return this._lBr_;
    }

    public void setLBr(TLBr node)
    {
        if(this._lBr_ != null)
        {
            this._lBr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBr_ == child)
        {
            this._lBr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBr_ == oldChild)
        {
            setLBr((TLBr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
