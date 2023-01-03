package com.example.getfileResource;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id", "reference", "message", "buttons", "customErrorData", "supportInfo"})
@XmlRootElement(name = "Exception")
public class ExceptionXml {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Reference")
    protected String reference;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "Buttons", required = true)
    protected ExceptionXml.Buttons buttons;
    @XmlElement(name = "CustomErrorData", required = true)
    protected ExceptionXml.CustomErrorData customErrorData;
    @XmlElement(name = "SupportInfo", required = true)
    protected ExceptionXml.SupportInfo supportInfo;

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the reference property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the message property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the buttons property.
     *
     * @return possible object is
     * {@link Buttons }
     */
    public Buttons getButtons() {
        return buttons;
    }

    /**
     * Sets the value of the buttons property.
     *
     * @param value allowed object is
     *              {@link Buttons }
     */
    public void setButtons(Buttons value) {
        this.buttons = value;
    }

    /**
     * Gets the value of the customErrorData property.
     *
     * @return possible object is
     * {@link CustomErrorData }
     */
    public CustomErrorData getCustomErrorData() {
        return customErrorData;
    }

    /**
     * Sets the value of the customErrorData property.
     *
     * @param value allowed object is
     *              {@link CustomErrorData }
     */
    public void setCustomErrorData(CustomErrorData value) {
        this.customErrorData = value;
    }

    /**
     * Gets the value of the supportInfo property.
     *
     * @return possible object is
     * {@link SupportInfo }
     */
    public SupportInfo getSupportInfo() {
        return supportInfo;
    }

    /**
     * Sets the value of the supportInfo property.
     *
     * @param value allowed object is
     *              {@link SupportInfo }
     */
    public void setSupportInfo(SupportInfo value) {
        this.supportInfo = value;
    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Button" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Cmd">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"button"})
    public static class Buttons {

        @XmlElement(name = "Button", required = true)
        protected List<Button> button;

        /**
         * Gets the value of the button property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the button property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getButton().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Button }
         */
        public List<Button> getButton() {
            if (button == null) {
                button = new ArrayList<Button>();
            }
            return this.button;
        }

        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Cmd">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"text", "cmd"})
        public static class Button {

            @XmlElement(name = "Text", required = true)
            protected String text;
            @XmlElement(name = "Cmd", required = true)
            protected ExceptionXml.Buttons.Button.Cmd cmd;

            /**
             * Gets the value of the text property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setText(String value) {
                this.text = value;
            }

            /**
             * Gets the value of the cmd property.
             *
             * @return possible object is
             * {@link Cmd }
             */
            public Cmd getCmd() {
                return cmd;
            }

            /**
             * Sets the value of the cmd property.
             *
             * @param value allowed object is
             *              {@link Cmd }
             */
            public void setCmd(Cmd value) {
                this.cmd = value;
            }

            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Param" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {"param"})
            public static class Cmd {

                @XmlElement(name = "Param")
                protected List<Param> param;
                @XmlAttribute(name = "name", required = true)
                protected String name;

                /**
                 * Gets the value of the param property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the param property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getParam().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Param }
                 */
                public List<Param> getParam() {
                    if (param == null) {
                        param = new ArrayList<Param>();
                    }
                    return this.param;
                }

                /**
                 * Gets the value of the name property.
                 *
                 * @return possible object is
                 * {@link String }
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 *
                 * @param value allowed object is
                 *              {@link String }
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * <p>Java class for anonymous complex type.
                 *
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {"value"})
                public static class Param {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "name", required = true)
                    protected String name;

                    /**
                     * Gets the value of the value property.
                     *
                     * @return possible object is
                     * {@link String }
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     *
                     * @param value allowed object is
                     *              {@link String }
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the name property.
                     *
                     * @return possible object is
                     * {@link String }
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     *
                     * @param value allowed object is
                     *              {@link String }
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                }

            }

        }

    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CustomError" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"customError"})
    public static class CustomErrorData {

        @XmlElement(name = "CustomError", required = true)
        protected List<CustomError> customError;

        /**
         * Gets the value of the customError property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customError property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustomError().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CustomError }
         */
        public List<CustomError> getCustomError() {
            if (customError == null) {
                customError = new ArrayList<CustomError>();
            }
            return this.customError;
        }

        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"key", "value"})
        public static class CustomError {

            @XmlElement(name = "Key", required = true)
            protected String key;
            @XmlElement(name = "Value", required = true)
            protected String value;

            /**
             * Gets the value of the key property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"message", "phoneNumber", "email"})
    public static class SupportInfo {

        @XmlElement(name = "Message", required = true)
        protected String message;
        @XmlElement(name = "PhoneNumber", required = true)
        protected String phoneNumber;
        @XmlElement(name = "Email", required = true)
        protected String email;

        /**
         * Gets the value of the message property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getMessage() {
            return message;
        }

        /**
         * Sets the value of the message property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setMessage(String value) {
            this.message = value;
        }

        /**
         * Gets the value of the phoneNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * Sets the value of the phoneNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPhoneNumber(String value) {
            this.phoneNumber = value;
        }

        /**
         * Gets the value of the email property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getEmail() {
            return email;
        }

        /**
         * Sets the value of the email property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setEmail(String value) {
            this.email = value;
        }

    }

}