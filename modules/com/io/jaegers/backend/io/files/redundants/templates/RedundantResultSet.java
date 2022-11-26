package com.io.jaegers.backend.io.files.redundants.templates;


import com.io.jaegers.backend.io.files.redundants.objects.EntryStored;
import com.io.jaegers.backend.object.HashStoredFile;


public interface RedundantResultSet
{
    public EntryStored[] getResultEntries();

    public HashStoredFile[] getResultOrphans();
}
