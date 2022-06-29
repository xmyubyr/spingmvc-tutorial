package com.example.getfileResource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ConfigurationTest {
    @Autowired
   public Person person;
    @Autowired
    public PersonConfiguration personConfiguration;
    @Autowired
    public XmlConfiguration xmlConfiguration;
    @Test
    void contextLoads(){
        System.out.println(personConfiguration.getGroupManager());
        ExceptionCommandsXml exceptionCommandsXmls =xmlConfiguration.convertXmlToObj(xmlConfiguration.getPath());
        try {
            String exception =ExceptionCommandsXmlTranslator.INSTANCE.convertObjToString(exceptionCommandsXmls);
            System.out.println(exception);
            String ps = JsonUtil.covertObjectToString(person);
            System.out.println(ps);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }

    }

}
