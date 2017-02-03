package no.vipps.exchange.common.model;

/**
 * Created by Ankit on 23-12-2016.
 */
public class ResourceInfo {

    private byte[] bytes;
    private ResourceMeta resourceMetadata;

    public ResourceMeta getResourceMetadata() {
        return resourceMetadata;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setResourceMetadata(ResourceMeta resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public static class ResourceMeta {
        private String blobName;
        private String extension;
        private String fileName;
        private String uploadedDate;

        public ResourceMeta(String resourceName){
            this.blobName=resourceName;
            this.fileName=resourceName;
        }

        public ResourceMeta(String resourceName, String uploadedDate){
            this.blobName=resourceName;
            this.fileName=resourceName;
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
