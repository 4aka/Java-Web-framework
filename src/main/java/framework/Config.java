package framework;

import static framework.PropertyLoader.retrieveProperty;

public class Config {

    public static int timeout = Integer.parseInt(PropertyLoader.getProperty("timeout"));
    public static Platform platform = Platform.valueOf(retrieveProperty("webdriver.platform"));
    public static String baseUrl = PropertyLoader.getProperty("base.url");

}

