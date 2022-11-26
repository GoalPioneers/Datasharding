package com.io.jaegers.backend.object;

public class CounterObject
        implements Comparable<CounterObject>
{
    public CounterObject()
    {
        this( 0 );
    }

    public CounterObject( int v )
    {
        this.setValueCounter( v );
    }

    public void increase(int v)
    {
        int r = this.getValueCounter() + v;
        this.setValueCounter( r );
    }

    public void increment()
    {
        this.increase(1 );
    }

    public void decrease( int v )
    {
        int r = this.getValueCounter() - v;
        this.setValueCounter( r );
    }

    public void decrement()
    {
        this.decrease(1 );
    }

    // Variables
    private int valueCounter;

    public int getValueCounter()
    {
        return this.valueCounter;
    }

    public void setValueCounter( int valueCounter )
    {
        this.valueCounter = valueCounter;
    }

    public int modulus( int withInteger )
    {
        return this.getValueCounter() % withInteger;
    }

    public boolean isZero()
    {
        return this.isIntegerValueZero( this.getValueCounter() );
    }

    public boolean isIntegerValueZero(int v)
    {
        return v == 0;
    }

    @Override
    public int compareTo( CounterObject o )
    {
        return Integer.compare( this.getValueCounter(),
                                o.getValueCounter() );
    }
}
