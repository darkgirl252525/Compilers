/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AReturnExprStmt extends PStmt
{
    private TReturn _return_;
    private PAllExpr _allExpr_;
    private PSemicolonId _semicolonId_;

    public AReturnExprStmt()
    {
        // Constructor
    }

    public AReturnExprStmt(
        @SuppressWarnings("hiding") TReturn _return_,
        @SuppressWarnings("hiding") PAllExpr _allExpr_,
        @SuppressWarnings("hiding") PSemicolonId _semicolonId_)
    {
        // Constructor
        setReturn(_return_);

        setAllExpr(_allExpr_);

        setSemicolonId(_semicolonId_);

    }

    @Override
    public Object clone()
    {
        return new AReturnExprStmt(
            cloneNode(this._return_),
            cloneNode(this._allExpr_),
            cloneNode(this._semicolonId_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReturnExprStmt(this);
    }

    public TReturn getReturn()
    {
        return this._return_;
    }

    public void setReturn(TReturn node)
    {
        if(this._return_ != null)
        {
            this._return_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._return_ = node;
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
            + toString(this._return_)
            + toString(this._allExpr_)
            + toString(this._semicolonId_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._return_ == child)
        {
            this._return_ = null;
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
        if(this._return_ == oldChild)
        {
            setReturn((TReturn) newChild);
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
