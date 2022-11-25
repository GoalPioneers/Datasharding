package com.io.jaegers.backend.io.files.algorithms;


import com.io.jaegers.backend.io.files.algorithms.interfaces.AlgorithmTraverseType;
import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;

/**
 *
 */
public class DepthFirstTraversal
        implements AlgorithmTraverseType
{
    /**
     *
     * @param facade
     */
    public DepthFirstTraversal( TraversalFacade facade )
    {
        this.setFacade( facade );
    }

    private TraversalFacade facade = null;

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
        this.facade = facade;
    }

    /**
     *
     * @return
     */
    public TraversalFacade getFacade()
    {
        return facade;
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
     */
    public static void main(String[] args)
    {

    }
}
