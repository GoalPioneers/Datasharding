package com.io.jaegers.backend.io.files.algorithms.component;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;
import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundSettingsInterface;


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

    public FoundConnector( FoundInterface f, FoundSettingsInterface settingsInterface )
    {
        this.setFound( f );
        this.setSettings( settingsInterface );
    }


    /**
     *
     * @param path
     */
    public void callCurrentDirectory( String path )
    {
        if( this.hasFoundInterface() && ( this.getSettings().usesCurrentDirectory() || this.isSettingsNull() ) )
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
        if( this.hasFoundInterface() && ( this.getSettings().usesDirectories() || this.isSettingsNull() ) )
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
        if( this.hasFoundInterface() && (this.getSettings().usesFiles() || this.isSettingsNull() ) )
        {
            this.getFound().FoundFile( path );
        }
    }

    // Variables
    private FoundInterface found = null;

    private FoundSettingsInterface settings = null;

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


    public FoundSettingsInterface getSettings()
    {
        return this.settings;
    }

    public void setSettings( FoundSettingsInterface settings )
    {
        this.settings = settings;
    }

    public boolean isSettingsNull()
    {
        return this.settings == null;
    }
}
