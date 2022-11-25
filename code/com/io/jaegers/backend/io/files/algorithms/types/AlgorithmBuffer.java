package com.io.jaegers.backend.io.files.algorithms.types;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class AlgorithmBuffer
{
    private static final int zero = 0;

    private List<String> queue = null;


    // Constructors
    /**
     *
     */
    public AlgorithmBuffer()
    {
        this.setQueue( new ArrayList<>() );
    }


    // Functions
    /**
     *
     * @param path
     */
    public void append( String path )
    {
        this.getQueue().add( path );
    }

    /**
     *
     * @return
     */
    public String getCurrent()
    {
        return this.getQueue().get( zero );
    }

    /**
     *
     */
    public void removeCurrent()
    {
        if( this.hasItems() )
        {
            this.getQueue().remove( zero );
        }
    }

    /**
     *
     */
    public void clear()
    {
        this.getQueue().clear();
    }


    // Accessors
    /**
     *
     * @return
     */
    public List<String> getQueue()
    {
        return this.queue;
    }

    /**
     *
     * @param queue
     */
    public void setQueue( List<String> queue )
    {
        this.queue = queue;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty()
    {

        int v = this.getQueue().size();
        return ( v == zero );
    }

    /**
     *
     * @return
     */
    public boolean hasItems()
    {
        int v = this.getQueue().size();
        return ( v > zero );
    }
}
