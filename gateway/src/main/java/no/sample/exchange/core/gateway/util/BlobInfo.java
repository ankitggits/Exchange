package no.sample.exchange.core.gateway.util;

import java.util.Date;

/**
 * Created by Ankit on 23-12-2016.
 */
public class BlobInfo {

    private byte[] bytes;
    private BlobMeta blobMetadata;

    public BlobMeta getBlobMetadata() {
        return blobMetadata;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBlobMetadata(BlobMeta blobMetadata) {
        this.blobMetadata = blobMetadata;
    }

    public static class BlobMeta {
        private String blobName;
        private String extension;
        private String fileName;
        private String uploadedDate;

        public BlobMeta(String blobName){
            this.blobName=blobName;
            this.fileName=blobName;
        }

        public BlobMeta(String blobName,String uploadedDate){
            this.blobName=blobName;
            this.uploadedDate=uploadedDate;
        }

        public String getUploadedDate() {
            return uploadedDate;
        }

        public void setBlobName(String blobName) {
            this.blobName = blobName;
        }

        public String getBlobName() {
            return blobName;
        }

        public void setUploadedDate(String uploadedDate) {
            this.uploadedDate = uploadedDate;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }
    }
}
