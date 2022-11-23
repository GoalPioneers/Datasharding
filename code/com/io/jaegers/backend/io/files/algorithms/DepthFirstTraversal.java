package com.io.jaegers.backend.io.files.algorithms;


public class DepthFirstTraversal
        implements AlgorithmTraverseType
{
    public DepthFirstTraversal( TraversalFacade facade )
    {
        this.setFacade( facade );
    }

    private TraversalFacade facade = null;

    @Override
    public void traverse()
    {

    }

    @Override
    public void setFacade( TraversalFacade facade )
    {
        this.facade = facade;
    }

    public TraversalFacade getFacade()
    {
        return facade;
    }

    @Override
    public boolean isFacadeNull() 
    {
        return false;
    }

    public static void main(String[] args)
    {

    }
}
