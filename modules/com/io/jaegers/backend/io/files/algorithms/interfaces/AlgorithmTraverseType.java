package com.io.jaegers.backend.io.files.algorithms.interfaces;

/**
 *
 */
public interface AlgorithmTraverseType
{
    /**
     *
     * @return
     */
    public boolean isToContinue();

    /**
     *
     */
    public void traverse();

    /**
     *
     * @param facade
     */
    public void setFacade( TraversalFacade facade );

    /**
     *
     * @return
     */
    public boolean isFacadeNull();
}
