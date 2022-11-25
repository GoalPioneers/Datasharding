package com.io.jaegers.backend.io.files.redundants;

import com.io.jaegers.backend.io.files.algorithms.interfaces.FoundSettingsInterface;


public class RedundantOperationSettings
    implements FoundSettingsInterface
{
    @Override
    public boolean usesDirectories()
    {
        return false;
    }

    @Override
    public boolean usesCurrentDirectory()
    {
        return false;
    }

    @Override
    public boolean usesFiles()
    {
        return true;
    }
}
