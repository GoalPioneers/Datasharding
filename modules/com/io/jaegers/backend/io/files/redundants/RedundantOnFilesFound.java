package com.io.jaegers.backend.io.files.redundants;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;
import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundSettingsInterface;
import com.io.jaegers.backend.object.CounterObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RedundantOnFilesFound
    implements FoundInterface,
               RedundantResultSet
{
    public RedundantOnFilesFound()
    {
        this.setStored( new ArrayList<>() );
        this.setRedundantOrphans( new ArrayList<>() );
        this.setOptimiseBy( new CounterObject() );
    }

    @Override
    public void FoundDirectory( String path )
    {

    }

    @Override
    public void FoundFile( String path )
    {
        this.getOptimiseBy().increment();

        if( this.getOptimiseBy().isIntegerValueZero(
                this.getOptimiseBy().modulus(250)
            )
          )
        {
            this.getStored().sort( new EntryStoredComparator() );
            this.getOptimiseBy().setValueCounter( 0 );
        }

        //System.out.println("Found File: " + path);
        try
        {
            FileToHash hashGen = new FileToHash( path );
            String hashValue = hashGen.convertToHex();

            this.IndexFile( hashValue, hashGen );
        }
        catch ( Exception ex )
        {
            System.out.println( ex.getMessage() );
            System.out.println( ex.getLocalizedMessage() );
        }
    }

    protected void IndexFile( String hash,
                              FileToHash toStore )
            throws IOException
    {
        int idx,
            sizeOfEntries;

        sizeOfEntries = this.getStored().size();
        boolean foundSameEntry = false;

        if( sizeOfEntries == 0 )
        {
            this.getStored().add(
                new EntryStored( hash, toStore )
            );
        }

        for( idx = 0;
             idx < sizeOfEntries;
             idx ++ )
        {
            EntryStored current = this.getStored().get( idx );

            if( current.getHash().equals( hash ) )
            {
                foundSameEntry = true;

                if( current.isInSet( toStore ) )
                {
                    //System.out.println( "Redundant Found: " + hash );
                    this.foundRedundantOrphan( toStore );
                }
                else
                {
                    //System.out.println( "Collision Added to List: " + hash );
                    current.getStored().add( toStore );
                }

                break;
            }
        }

        if( !foundSameEntry )
        {
            //System.out.println( "Added to Hashmap " + hash );
            this.getStored().add(
                new EntryStored( hash, toStore )
            );
        }
    }

    protected void foundRedundantOrphan( FileToHash toStore )
    {
        this.getRedundantOrphans().add( toStore );
    }

    @Override
    public void CurrentDirectory( String path )
    {

    }


    @Override
    public FoundSettingsInterface getSettings()
    {
        return getDefaultSettings();
    }

    // Variables
    private static RedundantOperationSettings defaultSettings = null;

    private List<FileToHash> redundantOrphans = null;

    private List<EntryStored> stored = null;

    private CounterObject optimiseBy = null;

    public void setStored( List<EntryStored> stored )
    {
        this.stored = stored;
    }

    public List<EntryStored> getStored()
    {
        return this.stored;
    }

    public CounterObject getOptimiseBy()
    {
        return this.optimiseBy;
    }

    public void setOptimiseBy( CounterObject optimiseBy )
    {
        this.optimiseBy = optimiseBy;
    }

    public static RedundantOperationSettings getDefaultSettings()
    {
        if( defaultSettings == null )
        {
            setDefaultSettings( new RedundantOperationSettings() );
        }

        return defaultSettings;
    }

    public static void setDefaultSettings( RedundantOperationSettings defaultSettings )
    {
        RedundantOnFilesFound.defaultSettings = defaultSettings;
    }

    public List<FileToHash> getRedundantOrphans()
    {
        return redundantOrphans;
    }

    public void setRedundantOrphans(List<FileToHash> redundantOrphans)
    {
        this.redundantOrphans = redundantOrphans;
    }

    @Override
    public FileToHash[] getResultOrphans()
    {
        int sizeOfOrphans = this.getRedundantOrphans().size();

        FileToHash[] results = new FileToHash[sizeOfOrphans];
        results = this.getRedundantOrphans().toArray(results);

        return results;
    }


    @Override
    public EntryStored[] getResultEntries()
    {
        int sizeOfEntries = this.getStored().size();
        EntryStored[] results = new EntryStored[sizeOfEntries];
        results = this.getStored().toArray(results);

        return results;
    }
}
