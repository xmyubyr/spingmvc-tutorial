package com.example.getfileResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.*;
import java.io.InputStream;
import java.io.StringWriter;

public class ExceptionCommandsXmlTranslator {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionCommandsXmlTranslator.class);
    public static ExceptionCommandsXmlTranslator INSTANCE = new ExceptionCommandsXmlTranslator();
    private static JAXBContext context;
    private static Unmarshaller unmarshaller;

    private ExceptionCommandsXmlTranslator() {
        try {
            context = JAXBContext.newInstance(ExceptionCommandsXml.class);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            logger.error("Fail to initialize JAXB unmarshaller. ", e);
            throw new IllegalStateException(e);
        }
    }

    public ExceptionCommandsXml convertXmlToObj(InputStream is) throws JAXBException, XMLStreamException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(is);
        NoNameSpaceReader noNameSpaceReader = new NoNameSpaceReader(xmlStreamReader, null);
        return (ExceptionCommandsXml) unmarshaller.unmarshal(noNameSpaceReader);
    }
    public String convertObjToString(ExceptionCommandsXml exception) throws JAXBException, XMLStreamException {
        StringWriter sw = new StringWriter();
        XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(sw);
        NoNameSpaceWriter noNameSpaceWriter = new NoNameSpaceWriter(xmlStreamWriter);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.marshal(exception, noNameSpaceWriter);
        return sw.toString();
    }
}
