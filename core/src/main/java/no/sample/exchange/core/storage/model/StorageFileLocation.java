package no.sample.exchange.core.storage.model;

/**
 * Created by Ankit on 16-12-2016.
 */

public class StorageFileLocation {

    private String storageConnectionString;
    private String container;
    private String fileName;

    public StorageFileLocation(String storageConnectionString , String container, String fileName){
        this.storageConnectionString=storageConnectionString;
        this.container=container;
        this.fileName=fileName;
    }

    public String getServerNameSpace() {
        return storageConnectionString;
    }

    public String getContainer() {
        return container;
    }

    public String getFileName() {
        return fileName;
    }
}
