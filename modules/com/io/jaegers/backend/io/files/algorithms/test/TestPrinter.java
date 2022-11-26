package com.io.jaegers.backend.io.files.algorithms.test;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundInterface;
import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundSettingsInterface;


public class TestPrinter
        implements FoundInterface
{
    @Override
    public FoundSettingsInterface getSettings()
    {
        return new DefaultSettings();
    }

    @Override
    public void CurrentDirectory( String path )
    {

    }

    @Override
    public void FoundDirectory( String path )
    {

    }

    @Override
    public void FoundFile( String path )
    {
        System.out.println( "found:" + path );
    }

    static class DefaultSettings
            implements FoundSettingsInterface
    {
        @Override
        public boolean usesCurrentDirectory()
        {
            return true;
        }

        @Override
        public boolean usesDirectories()
        {
            return true;
        }

        @Override
        public boolean usesFiles()
        {
            return false;
        }
    }
}
