package utils;

import exceptions.ElementNotFoundException;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigData {

    private static ConfigData instance;
    private static final String UI_MAPPING_FILE = "src/main/resources/UIMapping.properties";
    private Map<String, String> map;
    private Properties properties;

    private ConfigData(){
        this.properties = new Properties();
        try {
            this.map = readPropertiesFileAsMap();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConfigData getConfig() {
        if (instance == null) {
            instance = new ConfigData();
        }

        return instance;
    }

    private Map<String, String> readPropertiesFileAsMap() throws IOException {
        FileInputStream inputStream = new FileInputStream(UI_MAPPING_FILE);
        properties.load(inputStream);
        return map = new HashMap<>((Map) properties);
    }

    public By ui(String key) throws ElementNotFoundException {

        String[] partsOfLocators = map.get(key).split("\"");

        String method = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String target = partsOfLocators[1];

        // Return By class with appropriate method and target
        if (method.equals("xpath")) {
            return By.xpath(target);
        } else if (method.equals("cssSelector")) {
            return By.cssSelector(target);
        } else if (method.equals("id")) {
            return By.id(target);
        } else if (method.equals("className")) {
            return By.className(target);
        } else {
            throw new ElementNotFoundException(key);
        }

    }





}


