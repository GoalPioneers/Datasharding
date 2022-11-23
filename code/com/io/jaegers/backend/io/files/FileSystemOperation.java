package com.io.jaegers.backend.io.files;


public interface FileSystemOperation
{
    void setFlags( FileSystemFlag flag, String label );

    void execute();

    String getOperationName();
}
