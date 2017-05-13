/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AArType extends PType
{
    private TArray _array_;

    public AArType()
    {
        // Constructor
    }

    public AArType(
        @SuppressWarnings("hiding") TArray _array_)
    {
        // Constructor
        setArray(_array_);

    }

    @Override
    public Object clone()
    {
        return new AArType(
            cloneNode(this._array_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArType(this);
    }

    public TArray getArray()
    {
        return this._array_;
    }

    public void setArray(TArray node)
    {
        if(this._array_ != null)
        {
            this._array_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._array_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._array_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._array_ == child)
        {
            this._array_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._array_ == oldChild)
        {
            setArray((TArray) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}