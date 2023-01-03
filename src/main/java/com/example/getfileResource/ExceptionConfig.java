package com.example.getfileResource;

import java.util.ArrayList;
import java.util.List;

public class ExceptionConfig {
    protected int id;
    protected ExceptionConfig.Buttons buttons;
    protected boolean supportInfo;

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
     * Gets the value of the buttons property.
     *
     * @return possible object is
     * {@link ExceptionConfig.Buttons }
     */
    public ExceptionConfig.Buttons getButtons() {
        return buttons;
    }

    /**
     * Sets the value of the buttons property.
     *
     * @param value allowed object is
     *              {@link ExceptionConfig.Buttons }
     */
    public void setButtons(ExceptionConfig.Buttons value) {
        this.buttons = value;
    }

    public boolean isSupportInfo() {
        return supportInfo;
    }

    public void setSupportInfo(boolean supportInfo) {
        this.supportInfo = supportInfo;
    }

    public static class Buttons {
        protected List<Button> button;

        /**
         * Gets the value of the button property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the button
         * property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getButton().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExceptionConfig.Buttons.Button }
         */
        public List<Button> getButton() {
            if (button == null) {
                button = new ArrayList<Button>();
            }
            return this.button;
        }

        public static class Button {
            protected String text;
            protected ExceptionConfig.Buttons.Button.Cmd cmd;

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
             * {@link ExceptionConfig.Buttons.Button.Cmd }
             */
            public ExceptionConfig.Buttons.Button.Cmd getCmd() {
                return cmd;
            }

            /**
             * Sets the value of the cmd property.
             *
             * @param value allowed object is
             *              {@link ExceptionConfig.Buttons.Button.Cmd }
             */
            public void setCmd(ExceptionConfig.Buttons.Button.Cmd value) {
                this.cmd = value;
            }

            public static class Cmd {
                protected List<Param> param;
                protected String name;

                /**
                 * Gets the value of the param property.
                 * <p>
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the
                 * param property.
                 * <p>
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getParam().add(newItem);
                 * </pre>
                 * <p>
                 * <p>
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ExceptionConfig.Buttons.Button.Cmd.Param }
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

                public static class Param {
                    protected String name;

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
}
