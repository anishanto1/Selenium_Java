package TestNG;

import org.testng.annotations.Test;

public class SkipTestcases {

	@Test(priority = 0,enabled = false)
	public void Login() {
		System.out.println("Logged in Successfully");	
	}

	@Test(priority = 1)
	public void Search() {

		System.out.println("Explor the Application ");
	}

	@Test(priority = 2)
	public void Logout() {
		System.out.println("logged out ");
	}
}

	

