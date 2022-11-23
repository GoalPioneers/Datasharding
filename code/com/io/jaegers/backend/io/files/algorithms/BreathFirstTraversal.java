package com.io.jaegers.backend.io.files.algorithms;


public class BreathFirstTraversal
        implements AlgorithmTraverseType
{
    public BreathFirstTraversal( TraversalFacade facade )
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
        return this.facade;
    }

    @Override
    public boolean isFacadeNull()
    {
        return false;
    }

    public static void main(String[] args )
    {

    }
}
