package com.example.getfileResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ErrorMessageConfigLoader {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    //string key is 'skinCode_locale_errorCodeNumber'
    private static final String EXCEPTION_MAP_KEY_FORMAT = "EXCP_%s_%s_%s";
    private static final String DEFAULT_CONFIG_BASE = "exception";
    private static final String CONFIG_FILE_SUFFIX = ".xml";
    private static final String KEY_SEPARATOR = "_";
    //private final ResourceBundleMessageSource defaultMessage;
    private final ExceptionConfigLoader defaultExceptionConfig;
    //private final Map<String, ExceptionMessagesXml.Exception> exceptionMap;

    public ErrorMessageConfigLoader(ExceptionConfigLoader exceptionConfigLoader) {

        defaultExceptionConfig = exceptionConfigLoader;
       /* if (StringUtils.isEmpty(customMessageDir)) {
            logger.error("The custom messages root directory path not set, use default");
            exceptionMap = null;
            return;
        }
        File customDir = new File(customMessageDir);
        if (!customDir.exists()) {
            logger.error("The custom messages root directory {} does not exist. ", customDir.getAbsolutePath());
            exceptionMap = null;
            return;
        }
        if (!customDir.isDirectory()) {
            logger.error("The custom messages root directory not point to a directory.");
            exceptionMap = null;
            return;
        }
        exceptionMap = new HashMap<>();
        for (File file : customDir.listFiles()) {
            if (file.isDirectory()) {
                String skinFolderName = file.getName();
                logger.debug("parsing skin folder : {}", skinFolderName);
                for (File skinFolderFile : file.listFiles()) {
                    processSkinFolderFile(skinFolderFile, skinFolderName);
                }
            }
        }*/
    }

   /* public ExceptionMessagesXml.Exception getCustomizedException(String skin, Locale locale, int errorId) {
        if (exceptionMap == null) {
            return null;
        }
        String[] locales = LocaleUtil.buildCandidates(locale);
        for (int i = 0; i < locales.length; i++) {
            String key = String.format(EXCEPTION_MAP_KEY_FORMAT, skin, locales[i], errorId);
            ExceptionMessagesXml.Exception exception = exceptionMap.get(key);
            if (exception != null) {
                logger.debug("customized exception message is found with key: {}", key);
                return exception;
            }
        }
        return null;
    }*/

    /*private void processSkinFolderFile(File skinFolderFile, String skinFolderName) {
        String fileName = skinFolderFile.getName();
        if (fileName.endsWith(CONFIG_FILE_SUFFIX) && fileName.startsWith(DEFAULT_CONFIG_BASE + KEY_SEPARATOR)) {
            String localeStr =
                    fileName.replaceAll(DEFAULT_CONFIG_BASE + KEY_SEPARATOR + "(.*)" + CONFIG_FILE_SUFFIX, "$1");
            if (!StringUtils.isEmpty(localeStr)) {
                logger.debug("begin to parse {}", fileName);
                ExceptionMessagesXml exceptionMessages;
                try (InputStream is = new FileInputStream(skinFolderFile)) {
                    exceptionMessages = ExceptionMessagesXmlTranslator.INSTANCE.convertXmlToObj(is);
                } catch (JAXBException | XMLStreamException | IOException e) {
                    logger.error("{} can't be parsed. ", skinFolderFile.getAbsolutePath());
                    logger.error("xml file parse failure. ", e);
                    return;
                }
                List<ExceptionMessagesXml.Exception> excpList = exceptionMessages.getException();
                for (ExceptionMessagesXml.Exception excp : excpList) {
                    int errorCode = excp.getKey();
                    String key = String.format(EXCEPTION_MAP_KEY_FORMAT, skinFolderName, localeStr, errorCode);
                    exceptionMap.put(key, excp);
                }
            }
        }
    }*/

    /*public ResourceBundleMessageSource getDefaultMessage() {
        return defaultMessage;
    }*/

    public ExceptionConfigLoader getDefaultExceptionConfig() {
        return defaultExceptionConfig;
    }
}
