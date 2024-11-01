package datadriven;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

public class ReadPropertiesFile {

    public static void main(String[] args) throws IOException {

        //Location of Properties file.
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");

        //Load Properties file.
        Properties properties = new Properties();
        properties.load(file);

        //Reading Data from properties file.
        String url = properties.getProperty("app_url");
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        String order = properties.getProperty("orderId");
        String customer = properties.getProperty("customerId");

        System.out.println(url+"\t"+email+"\t"+password+"\t"+order+"\t"+customer);

        //Read the key from properties file.
        Set<String> keys = properties.stringPropertyNames();
        for (String key:keys){
            System.out.println(key);
        }

        //Reading all the values
        Collection<Object> value =  properties.values();
        System.out.println(value);

        //close properties file.
        file.close();
    }
}
