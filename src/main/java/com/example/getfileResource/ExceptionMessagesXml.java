package com.example.getfileResource;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"exception"})
@XmlRootElement(name = "ExceptionMessages")
public class ExceptionMessagesXml {

    @XmlElement(name = "Exception", required = true)
    protected List<Exception> exception;

    /**
     * Gets the value of the exception property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exception property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getException().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExceptionMessagesXml.Exception }
     */
    public List<Exception> getException() {
        if (exception == null) {
            exception = new ArrayList<Exception>();
        }
        return this.exception;
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
     *         &lt;element name="Buttons" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Button" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="key" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="supportinfo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"message", "buttons"})
    public static class Exception {

        @XmlElement(name = "Message", required = true)
        protected String message;
        @XmlElement(name = "Buttons")
        protected ExceptionMessagesXml.Exception.Buttons buttons;
        @XmlAttribute(name = "key", required = true)
        protected int key;
        @XmlAttribute(name = "supportinfo")
        protected Boolean supportinfo;

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
         * {@link ExceptionMessagesXml.Exception.Buttons }
         */
        public ExceptionMessagesXml.Exception.Buttons getButtons() {
            return buttons;
        }

        /**
         * Sets the value of the buttons property.
         *
         * @param value allowed object is
         *              {@link ExceptionMessagesXml.Exception.Buttons }
         */
        public void setButtons(ExceptionMessagesXml.Exception.Buttons value) {
            this.buttons = value;
        }

        /**
         * Gets the value of the key property.
         */
        public int getKey() {
            return key;
        }

        /**
         * Sets the value of the key property.
         */
        public void setKey(int value) {
            this.key = value;
        }

        /**
         * Gets the value of the supportinfo property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public Boolean isSupportinfo() {
            return supportinfo;
        }

        /**
         * Sets the value of the supportinfo property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setSupportinfo(Boolean value) {
            this.supportinfo = value;
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
         *         &lt;element name="Button" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
            protected List<String> button;

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
             * {@link String }
             */
            public List<String> getButton() {
                if (button == null) {
                    button = new ArrayList<String>();
                }
                return this.button;
            }

        }

    }
}