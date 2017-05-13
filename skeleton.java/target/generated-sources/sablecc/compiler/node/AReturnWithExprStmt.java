/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AReturnWithExprStmt extends PStmt
{
    private TReturn _return_;
    private PParenthesesExpr _parenthesesExpr_;
    private PSemicolonId _semicolonId_;

    public AReturnWithExprStmt()
    {
        // Constructor
    }

    public AReturnWithExprStmt(
        @SuppressWarnings("hiding") TReturn _return_,
        @SuppressWarnings("hiding") PParenthesesExpr _parenthesesExpr_,
        @SuppressWarnings("hiding") PSemicolonId _semicolonId_)
    {
        // Constructor
        setReturn(_return_);

        setParenthesesExpr(_parenthesesExpr_);

        setSemicolonId(_semicolonId_);

    }

    @Override
    public Object clone()
    {
        return new AReturnWithExprStmt(
            cloneNode(this._return_),
            cloneNode(this._parenthesesExpr_),
            cloneNode(this._semicolonId_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReturnWithExprStmt(this);
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

    public PParenthesesExpr getParenthesesExpr()
    {
        return this._parenthesesExpr_;
    }

    public void setParenthesesExpr(PParenthesesExpr node)
    {
        if(this._parenthesesExpr_ != null)
        {
            this._parenthesesExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parenthesesExpr_ = node;
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
            + toString(this._parenthesesExpr_)
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

        if(this._parenthesesExpr_ == child)
        {
            this._parenthesesExpr_ = null;
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

        if(this._parenthesesExpr_ == oldChild)
        {
            setParenthesesExpr((PParenthesesExpr) newChild);
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