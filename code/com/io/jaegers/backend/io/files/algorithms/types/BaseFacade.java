package com.io.jaegers.backend.io.files.algorithms.types;


import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;


/**
 *
 */
public class BaseFacade
        implements TraversalFacade
{
    /**
     *
     * @param rootPath
     */
    public BaseFacade( String rootPath )
    {
        this.setRootPath( rootPath );
    }


    //
    private String rootPath = null;

    /**
     *
     * @return
     */
    @Override
    public String getRootPath()
    {
        return this.rootPath;
    }

    /**
     *
     * @param pathBegin
     */
    public void setRootPath( String pathBegin )
    {
        this.rootPath = pathBegin;
    }
}
