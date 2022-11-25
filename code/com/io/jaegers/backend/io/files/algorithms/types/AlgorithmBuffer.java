package com.io.jaegers.backend.io.files.algorithms.types;

import java.util.ArrayList;
import java.util.List;


public class AlgorithmBuffer
{
    private static final int zero = 0;

    private List<String> queue = null;


    // Constructors
    public AlgorithmBuffer()
    {
        this.setQueue( new ArrayList<>() );
    }


    // Functions
    public void append( String path )
    {
        this.getQueue().add( path );
    }

    public String getCurrent()
    {
        return this.getQueue().get( zero );
    }

    public void removeCurrent()
    {
        if( this.hasItems() )
        {
            this.getQueue().remove( zero );
        }
    }

    public void clear()
    {
        this.getQueue().clear();
    }


    // Accessors
    public List<String> getQueue()
    {
        return this.queue;
    }


    public void setQueue( List<String> queue )
    {
        this.queue = queue;
    }

    public boolean isEmpty()
    {

        int v = this.getQueue().size();
        return ( v == zero );
    }

    public boolean hasItems()
    {
        int v = this.getQueue().size();
        return ( v > zero );
    }
}
