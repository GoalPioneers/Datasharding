package com.io.jaegers.backend.io.files.algorithms.component;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;


/**
 *
 */
public class FoundConnector
{
    /**
     *
     */
    public FoundConnector()
    {

    }


    /**
     *
     * @param path
     */
    public void callCurrentDirectory( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().CurrentDirectory( path );
        }
    }

    /**
     *
     * @param path
     */
    public void callFoundDirectory( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().FoundDirectory( path );
        }
    }

    /**
     *
     * @param path
     */
    public void callFoundFile( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().FoundFile( path );
        }
    }

    // Variables
    private FoundInterface found = null;

    /**
     *
     * @return
     */
    public FoundInterface getFound()
    {
        return this.found;
    }

    /**
     *
     * @param found
     */
    public void setFound( FoundInterface found )
    {
        this.found = found;
    }

    /**
     *
     * @return
     */
    public boolean isFoundNull()
    {
        return this.found == null;
    }

    /**
     *
     * @return
     */
    public boolean hasFoundInterface()
    {
        return this.found != null;
    }
}
