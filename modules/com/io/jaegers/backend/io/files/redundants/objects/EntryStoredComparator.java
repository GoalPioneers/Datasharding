package com.io.jaegers.backend.io.files.redundants.objects;

import java.util.Comparator;

public class EntryStoredComparator
        implements Comparator<EntryStored>
{
    @Override
    public int compare( EntryStored o1, EntryStored o2 )
    {
        return o1.compareTo( o2 );
    }
}
