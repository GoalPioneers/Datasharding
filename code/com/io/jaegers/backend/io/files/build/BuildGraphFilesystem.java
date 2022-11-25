package com.io.jaegers.backend.io.files.build;

import com.io.jaegers.backend.io.files.FileSystemFlag;
import com.io.jaegers.backend.io.files.FileSystemOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;



/**
 *
 */
public class BuildGraphFilesystem
        implements FileSystemOperation
{
    /**
     *
     * @return
     */
    @Override
    public String getOperationName()
    {
        return null;
    }

    /**
     *
     * @param flag
     * @param label
     */
    @Override
    public void setFlags( FileSystemFlag flag, String label )
    {

    }

    /**
     *
     */
    @Override
    public void execute()
    {

    }

    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {

    }
}
