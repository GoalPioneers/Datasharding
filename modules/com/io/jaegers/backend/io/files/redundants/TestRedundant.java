package com.io.jaegers.backend.io.files.redundants;

import com.io.jaegers.backend.io.files.redundants.objects.EntryStored;
import com.io.jaegers.backend.object.HashStoredFile;

import java.time.LocalTime;

public class TestRedundant
{
    public static void main( String[] args )
    {
        System.out.println( LocalTime.now().toString() );
        RedundantOperation operation = new RedundantOperation("C:\\test\\a");
        operation.execute();

        System.out.println( LocalTime.now().toString() );

        EntryStored[] entries = operation.getResultSet().getResultEntries();
        HashStoredFile[] orphans = operation.getResultSet().getResultOrphans();

        System.out.println("Entries Size: " + Integer.toString(entries.length));
        System.out.println("Orphans Size: " + Integer.toString(orphans.length));

        for( EntryStored now : entries )
        {
            System.out.println( now.getHash() );


            for( HashStoredFile f : now.getStored() )
            {
                System.out.println(f.getStorageSpace().getFile().getName());
            }

        }
    }
}
