package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String[] args) {
		TestNG runner=new TestNG();
		
		List<String> list=new ArrayList<>();
		list.add("E:\\workspace2\\Assss\\test-output\\Failed suite [Failed suite [Failed suite [Failed suite [Failed suite [Suite]]]]]\\testng-failed.xml");
		runner.setTestSuites(list);	
		runner.run();
	}

}
