package no.sample.exchange.gateway.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.integration.file.filters.AbstractFileListFilter;
import org.springframework.integration.file.filters.AcceptAllFileListFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

/**
 * Created by Ankit on 28-12-2016.
 */
public class AllowedFileTypeFilter extends AbstractFileListFilter<File>{

    private List<String> allowedExtensions;

    @Override
    protected boolean accept(File file) {
        String fileName = file.getName();
        if(allowedExtensions.contains(FilenameUtils.getExtension(fileName))){
            return true;
        }
        return false;
    }

    public List<String> getAllowedExtensions() {
        return allowedExtensions;
    }

    public void setAllowedExtensions(List<String> allowedExtensions) {
        this.allowedExtensions = allowedExtensions;
    }
}
