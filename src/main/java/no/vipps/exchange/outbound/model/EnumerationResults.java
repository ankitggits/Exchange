
package no.vipps.exchange.outbound.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Blobs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Blob" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Properties">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Last-Modified" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Etag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Content-Length" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                       &lt;element name="Content-Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Content-Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Content-Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Content-MD5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Cache-Control" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Content-Disposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="BlobType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="LeaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="LeaseState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NextMarker" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ServiceEndpoint" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ContainerName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "blobs",
        "nextMarker"
})
@XmlRootElement(name = "EnumerationResults")
public class EnumerationResults {

    @XmlElement(name = "Blobs", required = true)
    protected EnumerationResults.Blobs blobs;
    @XmlElement(name = "NextMarker", required = true)
    protected String nextMarker;
    @XmlAttribute(name = "ServiceEndpoint")
    protected String serviceEndpoint;
    @XmlAttribute(name = "ContainerName")
    protected String containerName;

    /**
     * Gets the value of the blobs property.
     *
     * @return
     *     possible object is
     *     {@link EnumerationResults.Blobs }
     *
     */
    public EnumerationResults.Blobs getBlobs() {
        return blobs;
    }

    /**
     * Sets the value of the blobs property.
     *
     * @param value
     *     allowed object is
     *     {@link EnumerationResults.Blobs }
     *
     */
    public void setBlobs(EnumerationResults.Blobs value) {
        this.blobs = value;
    }

    /**
     * Gets the value of the nextMarker property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNextMarker() {
        return nextMarker;
    }

    /**
     * Sets the value of the nextMarker property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNextMarker(String value) {
        this.nextMarker = value;
    }

    /**
     * Gets the value of the serviceEndpoint property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    /**
     * Sets the value of the serviceEndpoint property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServiceEndpoint(String value) {
        this.serviceEndpoint = value;
    }

    /**
     * Gets the value of the containerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * Sets the value of the containerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContainerName(String value) {
        this.containerName = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Blob" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Properties">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Last-Modified" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Etag" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Content-Length" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                             &lt;element name="Content-Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Content-Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Content-Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Content-MD5" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Cache-Control" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Content-Disposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="BlobType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="LeaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="LeaseState" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "blob"
    })
    public static class Blobs {

        @XmlElement(name = "Blob")
        protected List<EnumerationResults.Blobs.Blob> blob;

        /**
         * Gets the value of the blob property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the blob property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBlob().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EnumerationResults.Blobs.Blob }
         *
         *
         */
        public List<EnumerationResults.Blobs.Blob> getBlob() {
            if (blob == null) {
                blob = new ArrayList<EnumerationResults.Blobs.Blob>();
            }
            return this.blob;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Properties">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Last-Modified" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Etag" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Content-Length" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *                   &lt;element name="Content-Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Content-Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Content-Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Content-MD5" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Cache-Control" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Content-Disposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="BlobType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="LeaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="LeaseState" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "name",
                "properties"
        })
        public static class Blob {

            @XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "Properties", required = true)
            protected EnumerationResults.Blobs.Blob.Properties properties;

            /**
             * Gets the value of the name property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the properties property.
             *
             * @return
             *     possible object is
             *     {@link EnumerationResults.Blobs.Blob.Properties }
             *
             */
            public EnumerationResults.Blobs.Blob.Properties getProperties() {
                return properties;
            }

            /**
             * Sets the value of the properties property.
             *
             * @param value
             *     allowed object is
             *     {@link EnumerationResults.Blobs.Blob.Properties }
             *
             */
            public void setProperties(EnumerationResults.Blobs.Blob.Properties value) {
                this.properties = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Last-Modified" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Etag" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Content-Length" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="Content-Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Content-Encoding" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Content-Language" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Content-MD5" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Cache-Control" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Content-Disposition" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="BlobType" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LeaseStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="LeaseState" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "lastModified",
                    "etag",
                    "contentLength",
                    "contentType",
                    "contentEncoding",
                    "contentLanguage",
                    "contentMD5",
                    "cacheControl",
                    "contentDisposition",
                    "blobType",
                    "leaseStatus",
                    "leaseState"
            })
            public static class Properties {

                @XmlElement(name = "Last-Modified", required = true)
                protected String lastModified;
                @XmlElement(name = "Etag", required = true)
                protected String etag;
                @XmlElement(name = "Content-Length")
                protected short contentLength;
                @XmlElement(name = "Content-Type", required = true)
                protected String contentType;
                @XmlElement(name = "Content-Encoding", required = true)
                protected String contentEncoding;
                @XmlElement(name = "Content-Language", required = true)
                protected String contentLanguage;
                @XmlElement(name = "Content-MD5", required = true)
                protected String contentMD5;
                @XmlElement(name = "Cache-Control", required = true)
                protected String cacheControl;
                @XmlElement(name = "Content-Disposition", required = true)
                protected String contentDisposition;
                @XmlElement(name = "BlobType", required = true)
                protected String blobType;
                @XmlElement(name = "LeaseStatus", required = true)
                protected String leaseStatus;
                @XmlElement(name = "LeaseState", required = true)
                protected String leaseState;

                /**
                 * Gets the value of the lastModified property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLastModified() {
                    return lastModified;
                }

                /**
                 * Sets the value of the lastModified property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLastModified(String value) {
                    this.lastModified = value;
                }

                /**
                 * Gets the value of the etag property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getEtag() {
                    return etag;
                }

                /**
                 * Sets the value of the etag property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setEtag(String value) {
                    this.etag = value;
                }

                /**
                 * Gets the value of the contentLength property.
                 *
                 */
                public short getContentLength() {
                    return contentLength;
                }

                /**
                 * Sets the value of the contentLength property.
                 *
                 */
                public void setContentLength(short value) {
                    this.contentLength = value;
                }

                /**
                 * Gets the value of the contentType property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getContentType() {
                    return contentType;
                }

                /**
                 * Sets the value of the contentType property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setContentType(String value) {
                    this.contentType = value;
                }

                /**
                 * Gets the value of the contentEncoding property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getContentEncoding() {
                    return contentEncoding;
                }

                /**
                 * Sets the value of the contentEncoding property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setContentEncoding(String value) {
                    this.contentEncoding = value;
                }

                /**
                 * Gets the value of the contentLanguage property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getContentLanguage() {
                    return contentLanguage;
                }

                /**
                 * Sets the value of the contentLanguage property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setContentLanguage(String value) {
                    this.contentLanguage = value;
                }

                /**
                 * Gets the value of the contentMD5 property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getContentMD5() {
                    return contentMD5;
                }

                /**
                 * Sets the value of the contentMD5 property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setContentMD5(String value) {
                    this.contentMD5 = value;
                }

                /**
                 * Gets the value of the cacheControl property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getCacheControl() {
                    return cacheControl;
                }

                /**
                 * Sets the value of the cacheControl property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setCacheControl(String value) {
                    this.cacheControl = value;
                }

                /**
                 * Gets the value of the contentDisposition property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getContentDisposition() {
                    return contentDisposition;
                }

                /**
                 * Sets the value of the contentDisposition property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setContentDisposition(String value) {
                    this.contentDisposition = value;
                }

                /**
                 * Gets the value of the blobType property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getBlobType() {
                    return blobType;
                }

                /**
                 * Sets the value of the blobType property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setBlobType(String value) {
                    this.blobType = value;
                }

                /**
                 * Gets the value of the leaseStatus property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLeaseStatus() {
                    return leaseStatus;
                }

                /**
                 * Sets the value of the leaseStatus property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLeaseStatus(String value) {
                    this.leaseStatus = value;
                }

                /**
                 * Gets the value of the leaseState property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLeaseState() {
                    return leaseState;
                }

                /**
                 * Sets the value of the leaseState property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLeaseState(String value) {
                    this.leaseState = value;
                }

            }

        }

    }

}
