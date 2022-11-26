package com.io.jaegers.backend.object;

import java.io.File;

public class StoredFile
{
    public StoredFile()
    {

    }

    public StoredFile( String path )
    {
        this.setFile(
                new File( path )
        );
    }

    public String DetectAlgorithmByType()
    {
        return this.DetectAlgorithmType( this.getType() );
    }

    public String DetectAlgorithmType( HashType type )
    {
        String retVal = "";

        switch ( type )
        {
            case MD5:
                retVal = "MD5";
                break;


            default:
            case SHA256:
                retVal = "SHA-256";
                break;

        }

        return retVal;
    }


    // Variables
    private File file = null;

    private HashType type = HashType.None;

    public File getFile()
    {
        return this.file;
    }

    public void setFile( File file )
    {
        this.file = file;
    }

    public HashType getType()
    {
        return this.type;
    }


    public void setType( HashType type )
    {
        this.type = type;
    }
}
