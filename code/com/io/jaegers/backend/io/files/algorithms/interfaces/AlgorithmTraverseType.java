package com.io.jaegers.backend.io.files.algorithms.interfaces;


public interface AlgorithmTraverseType
{
    public boolean isToContinue();

    public void traverse();

    public void setFacade(TraversalFacade facade);

    public boolean isFacadeNull();
}
