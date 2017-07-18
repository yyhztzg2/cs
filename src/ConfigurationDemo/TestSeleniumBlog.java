package ConfigurationDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;



public class TestSeleniumBlog {
	@Test
	public void testConfig() throws Exception{
		File file=new File("Configuration/Config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("URL");
		System.out.println(url);
	}
}
