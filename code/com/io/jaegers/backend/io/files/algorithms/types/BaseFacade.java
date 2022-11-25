package com.io.jaegers.backend.io.files.algorithms.types;


import com.io.jaegers.backend.io.files.algorithms.interfaces.TraversalFacade;

public class BaseFacade
        implements TraversalFacade
{
    public BaseFacade( String rootPath )
    {
        this.setRootPath( rootPath );
    }

    private String rootPath = null;

    @Override
    public String getRootPath()
    {
        return this.rootPath;
    }

    public void setRootPath( String pathBegin )
    {
        this.rootPath = pathBegin;
    }
}
