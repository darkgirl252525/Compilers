/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import java.util.*;
import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AWithRefFparDef extends PFparDef
{
    private TRef _ref_;
    private TVarName _varName_;
    private final LinkedList<PVarDefHelper> _varDefHelper_ = new LinkedList<PVarDefHelper>();
    private PColonId _colonId_;
    private PFparType _fparType_;

    public AWithRefFparDef()
    {
        // Constructor
    }

    public AWithRefFparDef(
        @SuppressWarnings("hiding") TRef _ref_,
        @SuppressWarnings("hiding") TVarName _varName_,
        @SuppressWarnings("hiding") List<PVarDefHelper> _varDefHelper_,
        @SuppressWarnings("hiding") PColonId _colonId_,
        @SuppressWarnings("hiding") PFparType _fparType_)
    {
        // Constructor
        setRef(_ref_);

        setVarName(_varName_);

        setVarDefHelper(_varDefHelper_);

        setColonId(_colonId_);

        setFparType(_fparType_);

    }

    @Override
    public Object clone()
    {
        return new AWithRefFparDef(
            cloneNode(this._ref_),
            cloneNode(this._varName_),
            cloneList(this._varDefHelper_),
            cloneNode(this._colonId_),
            cloneNode(this._fparType_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWithRefFparDef(this);
    }

    public TRef getRef()
    {
        return this._ref_;
    }

    public void setRef(TRef node)
    {
        if(this._ref_ != null)
        {
            this._ref_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ref_ = node;
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

    public LinkedList<PVarDefHelper> getVarDefHelper()
    {
        return this._varDefHelper_;
    }

    public void setVarDefHelper(List<PVarDefHelper> list)
    {
        this._varDefHelper_.clear();
        this._varDefHelper_.addAll(list);
        for(PVarDefHelper e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public PColonId getColonId()
    {
        return this._colonId_;
    }

    public void setColonId(PColonId node)
    {
        if(this._colonId_ != null)
        {
            this._colonId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colonId_ = node;
    }

    public PFparType getFparType()
    {
        return this._fparType_;
    }

    public void setFparType(PFparType node)
    {
        if(this._fparType_ != null)
        {
            this._fparType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fparType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ref_)
            + toString(this._varName_)
            + toString(this._varDefHelper_)
            + toString(this._colonId_)
            + toString(this._fparType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ref_ == child)
        {
            this._ref_ = null;
            return;
        }

        if(this._varName_ == child)
        {
            this._varName_ = null;
            return;
        }

        if(this._varDefHelper_.remove(child))
        {
            return;
        }

        if(this._colonId_ == child)
        {
            this._colonId_ = null;
            return;
        }

        if(this._fparType_ == child)
        {
            this._fparType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ref_ == oldChild)
        {
            setRef((TRef) newChild);
            return;
        }

        if(this._varName_ == oldChild)
        {
            setVarName((TVarName) newChild);
            return;
        }

        for(ListIterator<PVarDefHelper> i = this._varDefHelper_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVarDefHelper) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._colonId_ == oldChild)
        {
            setColonId((PColonId) newChild);
            return;
        }

        if(this._fparType_ == oldChild)
        {
            setFparType((PFparType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
