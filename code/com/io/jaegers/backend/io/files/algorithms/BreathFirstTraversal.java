package com.io.jaegers.backend.io.files.algorithms;

import com.io.jaegers.backend.io.files.algorithms.component.FoundConnector;
import com.io.jaegers.backend.io.files.algorithms.interfaces.AlgorithmTraverseType;
import com.io.jaegers.backend.io.files.algorithms.interfaces.ExecutableAlgorithm;
import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;
import com.io.jaegers.backend.io.files.algorithms.test.TestPrinter;
import com.io.jaegers.backend.io.files.algorithms.types.AlgorithmBuffer;
import com.io.jaegers.backend.io.files.algorithms.types.BaseFacade;

import java.io.File;


/**
 *
 */
public class BreathFirstTraversal
        implements AlgorithmTraverseType,
                   ExecutableAlgorithm
{
    /**
     *
     * @param facade
     */
    public BreathFirstTraversal( TraversalFacade facade )
    {
        this.setFacade( facade );
        this.setToContinue( true );

        this.setBuffer( new AlgorithmBuffer() );
        this.setSetting( new DefaultSetting() );

        this.setSetting( new DefaultSetting() );
    }

    private static final int zero = 0;


    // Variables
    private TraversalFacade facade = null;

    private boolean toContinue = false;

    private AlgorithmBuffer buffer = null;

    private boolean initialised = false;

    private FoundConnector found = null;

    private boolean isDebugging = false;

    private DefaultSetting setting = null;


    // Functions
    /**
     *
     */
    public void initialise()
    {
        if( !this.isInitialised() && !this.isFacadeNull() )
        {
            this.getBuffer().append( this.facade.getRootPath() );
            this.setInitialised( true );
        }
    }

    /**
     *
     */
    @Override
    public final void execute()
    {
        this.initialise();

        while( this.isToContinue() )
        {
            this.traverse();
        }
    }

    /**
     *
     */
    @Override
    public void traverse()
    {
        this.initialise();
        String current = this.getCurrentPath();

        this.listChildren( current );
        this.updateState();
    }

    /**
     *
     * @return
     */
    public String getCurrentPath()
    {
        String r = null;

        r = this.getBuffer().getCurrent();
        this.getBuffer().removeCurrent();

        return r;
    }

    /**
     *
     * @param path
     */
    public void listChildren( String path )
    {
        this.getConnector().callCurrentDirectory( path );

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

    /**
     *
     * @param args
     */
    protected void iteratingFiles( File[] args )
    {
        int size = args.length;

        for( int index = zero;
                 index < size;
                 index ++ )
        {
            File current = args[index];
            this.iteration( current );
        }
    }

    protected void iteration( File current )
    {
        try
        {
            if( current.canRead() )
            {
                this.iterationCurrentFile( current );
                this.iterationCallFoundConnector( current );
            }
        }
        catch ( Exception ex )
        {
            System.out.println( ex.toString() );
        }
    }

    protected void iterationCurrentFile( File current )
    {
        // Base -> Appends it to the list, to be searched.
        if( current.isDirectory() )
        {
            this.buffer.append( current.getAbsolutePath() );
        }
    }

    protected void iterationCallFoundConnector( File current )
    {
        if( !this.isFoundConnectorNull() )
        {
            String toPath = current.getAbsolutePath();

            if( current.isFile() )
            {
                this.getConnector().callFoundFile( toPath );
            }

            if( current.isDirectory() )
            {
                this.getConnector().callFoundDirectory( toPath );
            }
        }
    }

    // Accessors
    /**
     *
     * @param facade
     */
    @Override
    public void setFacade( TraversalFacade facade )
    {
        this.facade = facade;
    }

    /**
     *
     * @return
     */
    public TraversalFacade getFacade()
    {
        return this.facade;
    }


    public DefaultSetting getSetting()
    {
        return this.setting;
    }

    public void setSetting( DefaultSetting setting )
    {
        this.setting = setting;
    }

    /**
     *
     * @return
     */
    public boolean isDebugging()
    {
        return this.isDebugging;
    }

    /**
     *
     * @param debugging
     */
    public void setDebugging( boolean debugging )
    {
        this.isDebugging = debugging;
    }

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public AlgorithmBuffer getBuffer()
    {
        return this.buffer;
    }

    /**
     *
     * @param buffer
     */
    public void setBuffer( AlgorithmBuffer buffer )
    {
        this.buffer = buffer;
    }

    /**
     *
     * @return
     */
    public boolean isInitialised()
    {
        return this.initialised;
    }

    /**
     *
     * @param initialised
     */
    public void setInitialised( boolean initialised )
    {
        this.initialised = initialised;
    }

    /**
     *
     * @return
     */
    public FoundConnector getConnector()
    {
        return this.found;
    }

    /**
     *
     * @param found
     */
    public void setConnector( FoundConnector found )
    {
        this.found = found;
    }

    /**
     *
     * @return
     */
    public boolean isFoundConnectorNull()
    {
        return this.found == null;
    }


    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {
        BaseFacade facade = new BaseFacade("C:\\Workspace\\common hardware initiative\\Archive\\dataset");
        BreathFirstTraversal first = new BreathFirstTraversal( facade );

        FoundConnector connector = new FoundConnector();
        connector.setFound(new TestPrinter());

        first.setConnector( connector );
        first.isDebugging = true;
        first.execute();
    }


    public static class DefaultSetting
    {
        public DefaultSetting()
        {


        }

    }
}