package com.io.jaegers.backend.object;


import com.io.jaegers.backend.object.StoredFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FileHash
    extends StoredFile
{
    public FileHash( String path )
            throws NoSuchAlgorithmException,
                   IOException
    {
        this.setFile(
            new File( path )
        );

        this.setMessage(
            MessageDigest.getInstance( "SHA-256" )
        );

        this.generateHash();
    }

    public void generateHash()
        throws IOException
    {
        FileInputStream in = new FileInputStream (
                this.getFile()
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


    ///
    private File file = null;
    private MessageDigest message = null;

    private byte[] hash = null;


    public File getFile()
    {
        return this.file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public byte[] getHash()
    {
        return this.hash;
    }

    public void setHash(byte[] hash)
    {
        this.hash = hash;
    }

    public MessageDigest getMessage()
    {
        return this.message;
    }

    public void setMessage(MessageDigest message)
    {
        this.message = message;
    }
}
