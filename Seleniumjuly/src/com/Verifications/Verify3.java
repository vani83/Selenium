package com.Verifications;

import com.Launching.BaseTest;

public class Verify3 extends BaseTest {

	public static void main(String[] args) throws Exception
	{
		 init();
		test = report.startTest("Verify3");
		 
		 launch("chromebrowser");
		 navigate("amazonurl");
		
		String expectedtxt1 = "Customer Serv";
		System.out.println("Expected Test : " + expectedtxt1);
		
		if(!isLinkEqual(expectedtxt1))
			testFail("Both Links are not equal....");
			//System.out.println("Both Links are not equal....");
		else
			testPass("Both Links are equal....");
			//System.out.println("Both Links are equal....");
		
		report.flush();
		report.endTest(test);
	}

}
