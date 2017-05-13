/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AWithoutHeaderHelperBiggerHeader extends PHeader
{
    private TFun _fun_;
    private TVarName _varName_;
    private TLPar _lPar_;
    private PHeaderHelper2 _headerHelper2_;
    private PRetType _retType_;

    public AWithoutHeaderHelperBiggerHeader()
    {
        // Constructor
    }

    public AWithoutHeaderHelperBiggerHeader(
        @SuppressWarnings("hiding") TFun _fun_,
        @SuppressWarnings("hiding") TVarName _varName_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PHeaderHelper2 _headerHelper2_,
        @SuppressWarnings("hiding") PRetType _retType_)
    {
        // Constructor
        setFun(_fun_);

        setVarName(_varName_);

        setLPar(_lPar_);

        setHeaderHelper2(_headerHelper2_);

        setRetType(_retType_);

    }

    @Override
    public Object clone()
    {
        return new AWithoutHeaderHelperBiggerHeader(
            cloneNode(this._fun_),
            cloneNode(this._varName_),
            cloneNode(this._lPar_),
            cloneNode(this._headerHelper2_),
            cloneNode(this._retType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWithoutHeaderHelperBiggerHeader(this);
    }

    public TFun getFun()
    {
        return this._fun_;
    }

    public void setFun(TFun node)
    {
        if(this._fun_ != null)
        {
            this._fun_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fun_ = node;
    }

    public TVarName getVarName()
    {
        return this._varName_;
    }

    public void setVarName(TVarName node)
    {
        if(this._varName_ != null)
        {
            this._varName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._varName_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PHeaderHelper2 getHeaderHelper2()
    {
        return this._headerHelper2_;
    }

    public void setHeaderHelper2(PHeaderHelper2 node)
    {
        if(this._headerHelper2_ != null)
        {
            this._headerHelper2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._headerHelper2_ = node;
    }

    public PRetType getRetType()
    {
        return this._retType_;
    }

    public void setRetType(PRetType node)
    {
        if(this._retType_ != null)
        {
            this._retType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._retType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._fun_)
            + toString(this._varName_)
            + toString(this._lPar_)
            + toString(this._headerHelper2_)
            + toString(this._retType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._fun_ == child)
        {
            this._fun_ = null;
            return;
        }

        if(this._varName_ == child)
        {
            this._varName_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._headerHelper2_ == child)
        {
            this._headerHelper2_ = null;
            return;
        }

        if(this._retType_ == child)
        {
            this._retType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._fun_ == oldChild)
        {
            setFun((TFun) newChild);
            return;
        }

        if(this._varName_ == oldChild)
        {
            setVarName((TVarName) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._headerHelper2_ == oldChild)
        {
            setHeaderHelper2((PHeaderHelper2) newChild);
            return;
        }

        if(this._retType_ == oldChild)
        {
            setRetType((PRetType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
