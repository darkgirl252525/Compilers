/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AExpressionStmtWithElse extends PStmtWithElse
{
    private PLValue _lValue_;
    private PAssignId _assignId_;
    private PAllExpr _allExpr_;
    private PSemicolonId _semicolonId_;

    public AExpressionStmtWithElse()
    {
        // Constructor
    }

    public AExpressionStmtWithElse(
        @SuppressWarnings("hiding") PLValue _lValue_,
        @SuppressWarnings("hiding") PAssignId _assignId_,
        @SuppressWarnings("hiding") PAllExpr _allExpr_,
        @SuppressWarnings("hiding") PSemicolonId _semicolonId_)
    {
        // Constructor
        setLValue(_lValue_);

        setAssignId(_assignId_);

        setAllExpr(_allExpr_);

        setSemicolonId(_semicolonId_);

    }

    @Override
    public Object clone()
    {
        return new AExpressionStmtWithElse(
            cloneNode(this._lValue_),
            cloneNode(this._assignId_),
            cloneNode(this._allExpr_),
            cloneNode(this._semicolonId_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpressionStmtWithElse(this);
    }

    public PLValue getLValue()
    {
        return this._lValue_;
    }

    public void setLValue(PLValue node)
    {
        if(this._lValue_ != null)
        {
            this._lValue_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lValue_ = node;
    }

    public PAssignId getAssignId()
    {
        return this._assignId_;
    }

    public void setAssignId(PAssignId node)
    {
        if(this._assignId_ != null)
        {
            this._assignId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assignId_ = node;
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
            + toString(this._lValue_)
            + toString(this._assignId_)
            + toString(this._allExpr_)
            + toString(this._semicolonId_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lValue_ == child)
        {
            this._lValue_ = null;
            return;
        }

        if(this._assignId_ == child)
        {
            this._assignId_ = null;
            return;
        }

        if(this._allExpr_ == child)
        {
            this._allExpr_ = null;
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
        if(this._lValue_ == oldChild)
        {
            setLValue((PLValue) newChild);
            return;
        }

        if(this._assignId_ == oldChild)
        {
            setAssignId((PAssignId) newChild);
            return;
        }

        if(this._allExpr_ == oldChild)
        {
            setAllExpr((PAllExpr) newChild);
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
