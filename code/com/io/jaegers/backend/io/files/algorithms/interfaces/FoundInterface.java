package com.io.jaegers.backend.io.files.algorithms.interfaces;


public interface FoundInterface
{
    void CurrentDirectory( String path );

    void FoundDirectory( String path );

    void FoundFile( String path );

    FoundSettingsInterface getSettings();
}
