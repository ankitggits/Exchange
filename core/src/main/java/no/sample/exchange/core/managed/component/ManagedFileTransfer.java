package no.sample.exchange.core.managed.component;

import no.sample.exchange.core.managed.model.ManagedFileLocation;

import java.io.File;

/**
 * Created by Ankit on 16-12-2016.
 */
public interface ManagedFileTransfer {

    void to(ManagedFileLocation fileLocation, File file);

    File from(ManagedFileLocation fileLocation);
}
