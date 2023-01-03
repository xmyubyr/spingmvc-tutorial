package com.example.getfileResource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@ConfigurationProperties(prefix ="server.file")
@Component
public class XmlConfiguration {
    private Map<Integer, ExceptionCommandsXml.Command> exceptionCommandMap = new HashMap<>();

    private ResourceBundleMessageSource buttonLocale;
    private Resource path;

    public Resource exceptionJsonConfigurationFilePath;

    private String buttonlocalizationResourceBundleBasename;

    public Resource getExceptionJsonConfigurationFilePath() {
        return exceptionJsonConfigurationFilePath;
    }

    public void setExceptionJsonConfigurationFilePath(Resource exceptionJsonConfigurationFilePath) {
        this.exceptionJsonConfigurationFilePath = exceptionJsonConfigurationFilePath;
    }

    public Resource getPath() {
        return path;
    }

    public void setPath(Resource path) {
        this.path = path;
    }

    public String getButtonlocalizationResourceBundleBasename() {
        return buttonlocalizationResourceBundleBasename;
    }

    public void setButtonlocalizationResourceBundleBasename(String buttonlocalizationResourceBundleBasename) {
        this.buttonlocalizationResourceBundleBasename = buttonlocalizationResourceBundleBasename;
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

    public void initbutton(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(getButtonlocalizationResourceBundleBasename());
        buttonLocale = messageSource;
    }

    public ErrorMessageConfigLoader errorMessageConfigLoader() {
        ExceptionConfigLoader exceptionConfigLoader =
                new ExceptionConfigLoader(this.getExceptionJsonConfigurationFilePath());
        return new ErrorMessageConfigLoader(exceptionConfigLoader);
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
    public List<ExceptionXml.Buttons.Button> getButtonsCommands(int exceptionCode,Locale locale) {
        ExceptionConfig defaultExceptionConfig =
                this.errorMessageConfigLoader().getDefaultExceptionConfig().getExceptionConfigMap().get(exceptionCode);
        ExceptionConfig.Buttons buttons = defaultExceptionConfig.getButtons();
        if (buttons == null) {
            return null;
        }
        ExceptionXml.Buttons btns = new ExceptionXml.Buttons();
        List<ExceptionConfig.Buttons.Button> buttonList = buttons.getButton();
        if (buttonList != null) {
            List<ExceptionXml.Buttons.Button> btnList = btns.getButton();
            for (int i = 0; i < buttonList.size(); i++) {
                ExceptionConfig.Buttons.Button button = buttonList.get(i);
                ExceptionXml.Buttons.Button btn = new ExceptionXml.Buttons.Button();
                btnList.add(btn);
                ResourceBundleMessageSource buttonTextLocale = buttonLocale;
                String buttonKey;
                if(button.getText().equalsIgnoreCase("View Account History")){
                    buttonKey = "View_Account_History";
                }else{
                    buttonKey = button.getText();
                }
                String text = buttonTextLocale.getMessage(buttonKey,null, locale);
                btn.setText(text);
                List<ExceptionCommandsXml.Command.Button> cmdbtn=exceptionCommandMap.get(exceptionCode).getButton();
                ExceptionXml.Buttons.Button.Cmd cmd = new ExceptionXml.Buttons.Button.Cmd();
                cmd.setName(cmdbtn.get(i).getCmdName());
                for (String paramName : cmdbtn.get(i).getParamName()) {
                    ExceptionXml.Buttons.Button.Cmd.Param prm = new ExceptionXml.Buttons.Button.Cmd.Param();
                    prm.setName(paramName);
                    cmd.getParam().add(prm);
                }

                btn.setCmd(cmd);

            }
            return btnList;
        }
        return null;
    }
    public List<String> getMessageButtons(int exceptionCode , Locale locale) {
        ExceptionConfig defaultExceptionConfig =
                this.errorMessageConfigLoader().getDefaultExceptionConfig().getExceptionConfigMap().get(exceptionCode);
        List<String> messageButton = new ArrayList<>();
        ExceptionConfig.Buttons buttons = defaultExceptionConfig.getButtons();
        if (buttons == null) {
            return null;
        }
        List<ExceptionConfig.Buttons.Button> buttonList = buttons.getButton();
        if (buttonList != null) {
            for(int i = 0; i < buttonList.size(); i++){
                messageButton.add(buttonList.get(i).getText());
            }
        }
        return messageButton;
    }
    public List<ExceptionCommandsXml.Command.Button> getButtonsCommands(int exceptionCode) {
        List<ExceptionCommandsXml.Command.Button> cmdbtn=exceptionCommandMap.get(exceptionCode).getButton();
        return cmdbtn;
    }
    public static Locale getLocale(String languageCode) {
        Locale locale;
        if (languageCode == null || languageCode.length() < 2) {
            locale = Locale.getDefault();
        } else if (languageCode.length() == 5) {
            locale = new Locale(languageCode.substring(0, 2).toLowerCase(), languageCode.substring(3).toUpperCase());
        } else {
            locale = new Locale(languageCode.substring(0, 2).toLowerCase());
        }
        return locale;
    }

}
