package com.io.jaegers.backend.io.files.algorithms;


import com.io.jaegers.backend.io.files.algorithms.interfaces.AlgorithmTraverseType;
import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;
import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;
import com.io.jaegers.backend.io.files.algorithms.types.AlgorithmBuffer;
import com.io.jaegers.backend.io.files.algorithms.types.BaseFacade;

import java.io.File;
import java.nio.file.Path;


public class BreathFirstTraversal
        implements AlgorithmTraverseType
{
    public BreathFirstTraversal( TraversalFacade facade )
    {
        this.setFacade( facade );
        this.setToContinue( true );

        this.setBuffer( new AlgorithmBuffer() );
    }

    // Variables
    private TraversalFacade facade = null;

    private boolean toContinue = false;

    private AlgorithmBuffer buffer = null;

    private boolean initialised = false;

    private FoundInterface found = null;

    private boolean isDebugging = false;


    // Functions
    public void initialise()
    {
        if( !this.isInitialised() && !this.isFacadeNull() )
        {
            this.getBuffer().append( this.facade.getRootPath() );
            this.setInitialised( true );
        }
    }

    @Override
    public void traverse()
    {
        this.initialise();
        String current = this.getCurrentPath();

        this.listChildren( current );
        this.updateState();
    }

    public String getCurrentPath()
    {
        String r = null;

        r = this.getBuffer().getCurrent();
        this.getBuffer().removeCurrent();

        return r;
    }

    public void listChildren( String path )
    {
        File directoryOrFile = new File( path );

        if( directoryOrFile.isDirectory() )
        {
            File[] filesFoundInDirectory = directoryOrFile.listFiles();

            if( !( filesFoundInDirectory == null ) )
            {
                this.iteratingFiles( filesFoundInDirectory );
            }
        }
    }


    protected void iteratingFiles( File[] args )
    {
        int size = args.length;

        for( int index = 0;
                 index < size;
                 index ++ )
        {
            File current = args[index];
            this.debugOutput( current.getAbsolutePath() );

            // Base -> Appends it to the list, to be searched.
            if( current.isDirectory() )
            {
                this.buffer.append( current.getAbsolutePath() );
            }

            if( !this.isFoundNull() )
            {
                String toPath = current.getAbsolutePath();

                if( current.isFile() )
                {
                    this.getFound().FoundFile( toPath );
                }

                if( current.isDirectory() )
                {
                    this.getFound().FoundDirectory( toPath );
                }
            }
        }

    }

    // Accessors
    @Override
    public void setFacade( TraversalFacade facade )
    {
        this.facade = facade;
    }

    public TraversalFacade getFacade()
    {
        return this.facade;
    }

    public boolean isDebugging()
    {
        return this.isDebugging;
    }


    public void setDebugging( boolean debugging )
    {
        this.isDebugging = debugging;
    }

    protected void updateState()
    {
        if( buffer.isEmpty() )
        {
            this.setToContinue( false );
        }
    }


    /**
     *
     * @return
     */
    @Override
    public boolean isFacadeNull()
    {
        return this.facade == null;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isToContinue()
    {
        return this.toContinue;
    }

    /**
     *
     * @param state
     */
    public void setToContinue( boolean state )
    {
        this.toContinue = state;
    }


    public AlgorithmBuffer getBuffer()
    {
        return this.buffer;
    }

    public void setBuffer( AlgorithmBuffer buffer )
    {
        this.buffer = buffer;
    }

    public boolean isInitialised()
    {
        return this.initialised;
    }

    public void setInitialised( boolean initialised )
    {
        this.initialised = initialised;
    }

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

    public void debugOutput( String out )
    {
        if( this.isDebugging() )
        {
            System.out.println( out );
        }
    }

    // Debug
    public static void main( String[] args )
    {
        BaseFacade facade = new BaseFacade("C:\\Users\\Kentv\\Desktop\\Filer");
        BreathFirstTraversal first = new BreathFirstTraversal( facade );
        first.isDebugging = true;

        while( first.isToContinue() )
        {
            first.traverse();
        }
    }
}
