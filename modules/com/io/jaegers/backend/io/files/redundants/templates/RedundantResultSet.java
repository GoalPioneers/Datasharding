package com.io.jaegers.backend.io.files.redundants.templates;


import com.io.jaegers.backend.io.files.redundants.objects.EntryStored;
import com.io.jaegers.backend.object.FileHash;


public interface RedundantResultSet
{
    public EntryStored[] getResultEntries();

    public FileHash[] getResultOrphans();
}
