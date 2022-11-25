package com.io.jaegers.backend.io.files.algorithms.component;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;

public class FoundConnector
{
    public FoundConnector()
    {

    }

    public void callCurrentDirectory( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().CurrentDirectory( path );
        }
    }

    public void callFoundDirectory( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().FoundDirectory( path );
        }
    }

    public void callFoundFile( String path )
    {
        if( this.hasFoundInterface() )
        {
            this.getFound().FoundFile( path );
        }
    }

    private FoundInterface found = null;

    public FoundInterface getFound()
    {
        return this.found;
    }

    public void setFound( FoundInterface found )
    {
        this.found = found;
    }

    public boolean isFoundNull()
    {
        return this.found == null;
    }

    public boolean hasFoundInterface()
    {
        return this.found != null;
    }
}
