package com.io.jaegers.backend.io.files.algorithms;

import com.io.jaegers.backend.io.files.algorithms.interfaces.AlgorithmTraverseType;
import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class LazyTraversal
        implements AlgorithmTraverseType
{
    /**
     *
     */
    @Override
    public void traverse()
    {

    }

    /**
     *
     * @param facade
     */
    @Override
    public void setFacade( TraversalFacade facade )
    {

    }

    /**
     *
     * @return
     */
    @Override
    public boolean isToContinue()
    {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isFacadeNull()
    {
        return false;
    }


    /**
     *
     * @param args
     * @throws IOException
     */
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
