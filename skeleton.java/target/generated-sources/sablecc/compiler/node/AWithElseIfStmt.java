/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AWithElseIfStmt extends PIfStmt
{
    private TIf _if_;
    private PCond _cond_;
    private PThenId _thenId_;
    private PStmtWithElse _stmtWithElse_;
    private PElseId _elseId_;
    private PStmt _elseStmt_;

    public AWithElseIfStmt()
    {
        // Constructor
    }

    public AWithElseIfStmt(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") PCond _cond_,
        @SuppressWarnings("hiding") PThenId _thenId_,
        @SuppressWarnings("hiding") PStmtWithElse _stmtWithElse_,
        @SuppressWarnings("hiding") PElseId _elseId_,
        @SuppressWarnings("hiding") PStmt _elseStmt_)
    {
        // Constructor
        setIf(_if_);

        setCond(_cond_);

        setThenId(_thenId_);

        setStmtWithElse(_stmtWithElse_);

        setElseId(_elseId_);

        setElseStmt(_elseStmt_);

    }

    @Override
    public Object clone()
    {
        return new AWithElseIfStmt(
            cloneNode(this._if_),
            cloneNode(this._cond_),
            cloneNode(this._thenId_),
            cloneNode(this._stmtWithElse_),
            cloneNode(this._elseId_),
            cloneNode(this._elseStmt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWithElseIfStmt(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
    }

    public PCond getCond()
    {
        return this._cond_;
    }

    public void setCond(PCond node)
    {
        if(this._cond_ != null)
        {
            this._cond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cond_ = node;
    }

    public PThenId getThenId()
    {
        return this._thenId_;
    }

    public void setThenId(PThenId node)
    {
        if(this._thenId_ != null)
        {
            this._thenId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._thenId_ = node;
    }

    public PStmtWithElse getStmtWithElse()
    {
        return this._stmtWithElse_;
    }

    public void setStmtWithElse(PStmtWithElse node)
    {
        if(this._stmtWithElse_ != null)
        {
            this._stmtWithElse_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stmtWithElse_ = node;
    }

    public PElseId getElseId()
    {
        return this._elseId_;
    }

    public void setElseId(PElseId node)
    {
        if(this._elseId_ != null)
        {
            this._elseId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elseId_ = node;
    }

    public PStmt getElseStmt()
    {
        return this._elseStmt_;
    }

    public void setElseStmt(PStmt node)
    {
        if(this._elseStmt_ != null)
        {
            this._elseStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elseStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._cond_)
            + toString(this._thenId_)
            + toString(this._stmtWithElse_)
            + toString(this._elseId_)
            + toString(this._elseStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
            return;
        }

        if(this._cond_ == child)
        {
            this._cond_ = null;
            return;
        }

        if(this._thenId_ == child)
        {
            this._thenId_ = null;
            return;
        }

        if(this._stmtWithElse_ == child)
        {
            this._stmtWithElse_ = null;
            return;
        }

        if(this._elseId_ == child)
        {
            this._elseId_ = null;
            return;
        }

        if(this._elseStmt_ == child)
        {
            this._elseStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
            return;
        }

        if(this._cond_ == oldChild)
        {
            setCond((PCond) newChild);
            return;
        }

        if(this._thenId_ == oldChild)
        {
            setThenId((PThenId) newChild);
            return;
        }

        if(this._stmtWithElse_ == oldChild)
        {
            setStmtWithElse((PStmtWithElse) newChild);
            return;
        }

        if(this._elseId_ == oldChild)
        {
            setElseId((PElseId) newChild);
            return;
        }

        if(this._elseStmt_ == oldChild)
        {
            setElseStmt((PStmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
