package com.io.jaegers.backend.io.files.redundants;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;
import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundSettingsInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RedundantOnFilesFound
    implements FoundInterface
{
    public RedundantOnFilesFound()
    {
        this.setStored( new ArrayList<>() );
        this.setRedundantOrphans( new ArrayList<>() );
    }

    @Override
    public void FoundDirectory( String path )
    {

    }

    @Override
    public void FoundFile( String path )
    {
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

    public void setStored( List<EntryStored> stored )
    {
        this.stored = stored;
    }

    public List<EntryStored> getStored()
    {
        return this.stored;
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
}
