package base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

Properties prop;

public ConfigReader() {

try{

FileInputStream file=
new FileInputStream(
"src/test/resources/config/config.properties");

prop=new Properties();

prop.load(file);

}
catch(Exception e){
e.printStackTrace();
}

}

public String getBrowser(){
return prop.getProperty("browser");
}

public String getUrl(){
return prop.getProperty("url");
}

}