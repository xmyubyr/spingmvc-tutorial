package com.example.getfileResource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ExceptionConfigLoader {
    private ObjectMapper objectMapper = new ObjectMapper();

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }
    private static final Logger logger = LoggerFactory.getLogger(ExceptionConfigLoader.class);
    private Map<Integer, ExceptionConfig> exceptionConfigMap = new HashMap<>();

    public ExceptionConfigLoader(Resource resource) {
        String fileContent = null;
        try {
            fileContent = this.parseFileContent(resource.getInputStream(), "UTF-8");
            exceptionConfigMap = parseAndPrepareMap(fileContent);
        } catch (IOException e) {
            logger.error("Error happens when loading the file. ", resource.getFilename());
            logger.error("Fail to ExceptionConfigLoader " + "instance, because of exception.", e);
            throw new IllegalStateException("Fail to initialize the instance.", e);
        }
    }

    private Map<Integer, ExceptionConfig> parseAndPrepareMap(String fileContent) throws IOException {
        ExceptionConfig[] exceptionConfigs =
                objectMapper.readValue(fileContent, ExceptionConfig[].class);
        for (ExceptionConfig exceptionConfig : exceptionConfigs) {
            exceptionConfigMap.put(exceptionConfig.getId(), exceptionConfig);
        }
        return exceptionConfigMap;
    }

    private String parseFileContent(InputStream inputStream, String charset) throws IOException {
        StringBuilder resultBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            String data = bufferedReader.readLine();
            while (data != null) {
                resultBuilder.append(data);
                data = bufferedReader.readLine();
            }
        }
        return resultBuilder.toString();
    }

    public Map<Integer, ExceptionConfig> getExceptionConfigMap() {
        return exceptionConfigMap;
    }
}
