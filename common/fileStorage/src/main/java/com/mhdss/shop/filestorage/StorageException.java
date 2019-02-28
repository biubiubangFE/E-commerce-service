package com.mhdss.shop.filestorage;

public class StorageException extends RuntimeException {

    public StorageException(Throwable e) {
        super(e);
    }

    public StorageException(String msg) {
        super(msg);
    }
}
