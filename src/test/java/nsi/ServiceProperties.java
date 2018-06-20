package nsi;

import java.util.Properties;

public class ServiceProperties {
    private static final String PROPERTIESFILENAME = "common.properties";

    private ServiceProperties() {
    }

    /**
     * Returns a Property from the AutomationProject.properties file, if the
     * property exists within the file
     * 
     * @param property
     * @return String of the property
     */
    public static String getProperty(final String property) {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader
                    .getSystemResourceAsStream(PROPERTIESFILENAME));
        } catch (final Exception exception) {
            properties = null;
        }

        if (null == properties) {
            return null;
        } else {
            return properties.getProperty(property);
        }
    }
}