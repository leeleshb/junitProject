package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataDrivenTesting {

	String username;
	String password;
	
	public DataDrivenTesting(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Test
	public void login() {
		
		System.out.println(username+" : "+password);
	}
	
	@Parameters
	public static Object[][] dataSupplier() {
		
		Object[][] data = {{"Leelesh", "34"},
				{"Minu", "28"},
				{"Samu", "25"},
				{"Ayu", "22"}};
		return data;
	}
}
