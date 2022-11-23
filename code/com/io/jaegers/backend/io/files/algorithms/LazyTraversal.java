package com.io.jaegers.backend.io.files.algorithms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LazyTraversal
        implements AlgorithmTraverseType
{
    @Override
    public void traverse()
    {

    }

    @Override
    public void setFacade( TraversalFacade facade )
    {

    }

    @Override
    public boolean isFacadeNull()
    {
        return false;
    }

    public static void main( String[] args )
            throws IOException
    {
        try ( Stream<Path> pathIterated = Files.walk( Paths.get( "D:\\Images" ) ) )
        {
            List<Path> arr = pathIterated.toList();
            int sizeOf = arr.size();

            for( int idx = 0;
                 idx < sizeOf;
                 idx++ )
            {

            }
        }
        catch (Exception ex)
        {
            throw new IOException("does not exist");
        }

    }
}
