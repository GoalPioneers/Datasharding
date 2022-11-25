package com.io.jaegers.backend.io.files.redundants;


public interface RedundantResultSet
{
    public EntryStored[] getResultEntries();
    public FileToHash[] getResultOrphans();
}
