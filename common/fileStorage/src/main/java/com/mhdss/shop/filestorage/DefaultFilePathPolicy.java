package com.mhdss.shop.filestorage;

import java.io.File;

public class DefaultFilePathPolicy extends FilePathPolicy {

    @Override
    public String generateFilePath(FileType type, File file) throws Exception {
        return generateFilePath(type);
    }
}
