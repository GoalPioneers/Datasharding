package com.io.jaegers.backend.object;


import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class HashStoredFile
{
    public HashStoredFile( StoredFile storage_file )
            throws
                NoSuchAlgorithmException,
                IOException
    {
        this.setStorageSpace( storage_file );
        this.initialise();
    }

    public HashStoredFile( String pathToLocation )
            throws
                NoSuchAlgorithmException,
                IOException
    {
        this.setStorageSpace( new StoredFile( pathToLocation ) );
        this.initialise();
    }

    protected void initialise()
            throws IOException, NoSuchAlgorithmException
    {
        this.generateHash();
    }

    // Variables
    private StoredFile storageSpace = null;

    private MessageDigest message = null;

    private byte[] hash = null;


    // Code
    public void generateHash()
            throws NoSuchAlgorithmException,
                   IOException
    {
        this.setMessage( MessageDigest.getInstance( this.getStorageSpace().DetectAlgorithmByType() ) );

        FileInputStream in = new FileInputStream (
                this.getStorageSpace().getFile()
        );

        byte[] input = new byte[1024];
        int sizeOfBytes = 0;

        while ( ( sizeOfBytes = in.read( input ) ) != -1 )
        {
            this.message.update(input, 0, sizeOfBytes);
        }

        this.setHash( this.getMessage().digest() );
        in.close();
    }

    // https://howtodoinjava.com/java/java-security/sha-md5-file-checksum-hash/
    public String convertToHex()
    {
        StringBuilder builder = new StringBuilder();
        int idx;

        for( idx = 0;
             idx < this.getHash().length;
             idx++ )
        {
            byte current = this.getHash()[idx];
            builder.append(Integer.toString(( current & 0xff )+ 0x100, 16 ).substring(1 ) );
        }

        return builder.toString();
    }

    // Accessors
    public StoredFile getStorageSpace()
    {
        return this.storageSpace;
    }

    public void setStorageSpace( StoredFile storageSpace )
    {
        this.storageSpace = storageSpace;
    }

    public byte[] getHash()
    {
        return this.hash;
    }

    public void setHash( byte[] hash )
    {
        this.hash = hash;
    }

    protected MessageDigest getMessage()
    {
        return this.message;
    }

    protected void setMessage( MessageDigest message )
    {
        this.message = message;
    }
}
