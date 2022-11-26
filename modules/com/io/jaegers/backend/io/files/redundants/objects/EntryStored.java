package com.io.jaegers.backend.io.files.redundants.objects;

import com.io.jaegers.backend.object.FileHash;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class EntryStored
        implements Comparable<EntryStored>
{
    public EntryStored()
    {
        this.setStored( new ArrayList<>() );
    }

    public EntryStored( String hashStr )
    {
        this();
        this.setHash( hashStr );
    }

    public EntryStored( String hashStr,
                        FileHash hashFile )
    {
        this( hashStr );
        this.getStored().add( hashFile );
    }

    private String hash = null;

    private List<FileHash> stored = null;


    public String getHash()
    {
        return this.hash;
    }

    public void setHash( String hash )
    {
        this.hash = hash;
    }

    public void setStored( List<FileHash> stored )
    {
        this.stored = stored;
    }

    public List<FileHash> getStored()
    {
        return this.stored;
    }

    public boolean isInSet( FileHash store )
            throws IOException
    {
        int idx;
        boolean rValue = false;

        for( idx = 0;
             idx < this.getStored().size();
             idx++ )
        {
            FileHash current = this.getStored().get( idx );

            if( this.compareFiles( current, store ) )
            {
                rValue = true;
                break;
            }
        }

        return rValue;
    }

    protected boolean compareFiles(FileHash A, FileHash B )
            throws IOException
    {
        long r = Files.mismatch(A.getFile().toPath(), B.getFile().toPath());
        return (r == -1);
    }

    @Override
    public int compareTo( EntryStored o )
    {
        return this.getHash().compareTo( o.getHash() );
    }
}
