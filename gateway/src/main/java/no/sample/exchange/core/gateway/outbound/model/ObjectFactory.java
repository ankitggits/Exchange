
package no.sample.exchange.core.gateway.outbound.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the mypackage package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnumerationResults }
     *
     */
    public EnumerationResults createEnumerationResults() {
        return new EnumerationResults();
    }

    /**
     * Create an instance of {@link EnumerationResults.Blobs }
     *
     */
    public EnumerationResults.Blobs createEnumerationResultsBlobs() {
        return new EnumerationResults.Blobs();
    }

    /**
     * Create an instance of {@link EnumerationResults.Blobs.Blob }
     *
     */
    public EnumerationResults.Blobs.Blob createEnumerationResultsBlobsBlob() {
        return new EnumerationResults.Blobs.Blob();
    }

    /**
     * Create an instance of {@link EnumerationResults.Blobs.Blob.Properties }
     *
     */
    public EnumerationResults.Blobs.Blob.Properties createEnumerationResultsBlobsBlobProperties() {
        return new EnumerationResults.Blobs.Blob.Properties();
    }

}
