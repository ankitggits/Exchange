package no.sample.exchange.core.storage.component;

import no.sample.exchange.core.storage.model.StorageFileLocation;

import java.io.File;

/**
 * Created by Ankit on 16-12-2016.
 */
public interface StorageFileTransfer {

    void to(StorageFileLocation fileLocation, File file);

    File from(StorageFileLocation fileLocation);
}
