/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ASmallAssSigns extends PAssSigns
{
    private TSmaller _smaller_;

    public ASmallAssSigns()
    {
        // Constructor
    }

    public ASmallAssSigns(
        @SuppressWarnings("hiding") TSmaller _smaller_)
    {
        // Constructor
        setSmaller(_smaller_);

    }

    @Override
    public Object clone()
    {
        return new ASmallAssSigns(
            cloneNode(this._smaller_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASmallAssSigns(this);
    }

    public TSmaller getSmaller()
    {
        return this._smaller_;
    }

    public void setSmaller(TSmaller node)
    {
        if(this._smaller_ != null)
        {
            this._smaller_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._smaller_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._smaller_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._smaller_ == child)
        {
            this._smaller_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._smaller_ == oldChild)
        {
            setSmaller((TSmaller) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}