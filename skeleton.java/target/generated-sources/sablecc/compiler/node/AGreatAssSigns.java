/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AGreatAssSigns extends PAssSigns
{
    private TGreater _greater_;

    public AGreatAssSigns()
    {
        // Constructor
    }

    public AGreatAssSigns(
        @SuppressWarnings("hiding") TGreater _greater_)
    {
        // Constructor
        setGreater(_greater_);

    }

    @Override
    public Object clone()
    {
        return new AGreatAssSigns(
            cloneNode(this._greater_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGreatAssSigns(this);
    }

    public TGreater getGreater()
    {
        return this._greater_;
    }

    public void setGreater(TGreater node)
    {
        if(this._greater_ != null)
        {
            this._greater_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._greater_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._greater_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._greater_ == child)
        {
            this._greater_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._greater_ == oldChild)
        {
            setGreater((TGreater) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}