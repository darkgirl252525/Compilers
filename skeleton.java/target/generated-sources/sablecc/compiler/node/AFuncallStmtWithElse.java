/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AFuncallStmtWithElse extends PStmtWithElse
{
    private PFuncCall _funcCall_;
    private PSemicolonId _semicolonId_;

    public AFuncallStmtWithElse()
    {
        // Constructor
    }

    public AFuncallStmtWithElse(
        @SuppressWarnings("hiding") PFuncCall _funcCall_,
        @SuppressWarnings("hiding") PSemicolonId _semicolonId_)
    {
        // Constructor
        setFuncCall(_funcCall_);

        setSemicolonId(_semicolonId_);

    }

    @Override
    public Object clone()
    {
        return new AFuncallStmtWithElse(
            cloneNode(this._funcCall_),
            cloneNode(this._semicolonId_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncallStmtWithElse(this);
    }

    public PFuncCall getFuncCall()
    {
        return this._funcCall_;
    }

    public void setFuncCall(PFuncCall node)
    {
        if(this._funcCall_ != null)
        {
            this._funcCall_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._funcCall_ = node;
    }

    public PSemicolonId getSemicolonId()
    {
        return this._semicolonId_;
    }

    public void setSemicolonId(PSemicolonId node)
    {
        if(this._semicolonId_ != null)
        {
            this._semicolonId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolonId_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._funcCall_)
            + toString(this._semicolonId_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._funcCall_ == child)
        {
            this._funcCall_ = null;
            return;
        }

        if(this._semicolonId_ == child)
        {
            this._semicolonId_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._funcCall_ == oldChild)
        {
            setFuncCall((PFuncCall) newChild);
            return;
        }

        if(this._semicolonId_ == oldChild)
        {
            setSemicolonId((PSemicolonId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}