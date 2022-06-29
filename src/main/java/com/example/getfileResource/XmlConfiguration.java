package com.example.getfileResource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix ="server.file")
@Component
public class XmlConfiguration {
    private Map<Integer, ExceptionCommandsXml.Command> exceptionCommandMap = new HashMap<>();
    private Resource path;

    public Resource getPath() {
        return path;
    }

    public void setPath(Resource path) {
        this.path = path;
    }
    public ExceptionCommandsXml convertXmlToObj(Resource path){
        InputStream in = null;
        ExceptionCommandsXml exceptionCommandsXmls = null;
        try {
            in = path.getInputStream();
            exceptionCommandsXmls = ExceptionCommandsXmlTranslator.INSTANCE.convertXmlToObj(in);
        } catch (IOException | JAXBException | XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return exceptionCommandsXmls;
    }

    public Map<Integer, ExceptionCommandsXml.Command> parseMap(){
        ExceptionCommandsXml exceptionCommandsXmls =convertXmlToObj(this.getPath());
            List<ExceptionCommandsXml.Command> excpList = exceptionCommandsXmls.getCommand();
            int size = excpList.size();
            for(int i = 0; i < size; ++i)
            {
                ExceptionCommandsXml.Command cmd = excpList.get(i);
                exceptionCommandMap.put(cmd.getKey(), cmd);
            }
            return exceptionCommandMap;


    }
}
