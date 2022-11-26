package com.io.jaegers.backend.io.files;

import java.util.ArrayList;
import java.util.List;

public class OperationController
{
    public OperationController()
    {
        this.operations = new ArrayList<>();
    }

    private List<FileSystemOperation> operations = null;

    public void setOperations( ArrayList<FileSystemOperation> operations )
    {
        this.operations = operations;
    }

    public List<FileSystemOperation> getOperations()
    {
        return this.operations;
    }

    // Global
    private static OperationController singletonController = null;

    public static void setSingletonController( OperationController controller )
    {
        singletonController = controller;
    }

    public static OperationController getSingletonController()
    {
        if( singletonController == null )
        {
            setSingletonController( new OperationController() );
        }

        return singletonController;
    }

    public static void main(String[] args)
    {

    }

}

