package com.example.getfileResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;


public class ExceptionMessagesXmlTranslator {
    public static ExceptionMessagesXmlTranslator INSTANCE = new ExceptionMessagesXmlTranslator();
    private static Unmarshaller unmarshaller;

    private ExceptionMessagesXmlTranslator() {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(ExceptionMessagesXml.class);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public ExceptionMessagesXml convertXmlToObj(InputStream is) throws JAXBException, XMLStreamException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(is);
        NoNameSpaceReader noNameSpaceReader = new NoNameSpaceReader(xmlStreamReader, null);
        return (ExceptionMessagesXml) unmarshaller.unmarshal(noNameSpaceReader);
    }
}