package com.example.getfileResource;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class NoNameSpaceReader extends StreamReaderDelegate {
    private final String ns;

    public NoNameSpaceReader(XMLStreamReader reader, String ns) {
        super(reader);
        this.ns = ns;
    }

    @Override
    public String getAttributeNamespace(int arg0) {
        return "";
    }

    @Override
    public String getNamespaceURI() {
        return ns;
    }
}
