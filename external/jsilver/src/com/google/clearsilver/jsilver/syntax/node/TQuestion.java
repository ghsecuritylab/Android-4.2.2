/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.google.clearsilver.jsilver.syntax.node;

import com.google.clearsilver.jsilver.syntax.analysis.*;

@SuppressWarnings("nls")
public final class TQuestion extends Token
{
    public TQuestion()
    {
        super.setText("?");
    }

    public TQuestion(int line, int pos)
    {
        super.setText("?");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TQuestion(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTQuestion(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TQuestion text.");
    }
}
