package com.xxx;

import org.testng.annotations.Test;

public class abc {
	
	@SuppressWarnings
	public void login(){
		System.out.println("login successful");//
	}
	@Test(groups={"sanity"})
	public void fundTransfer(){
		System.out.println("fundTransfer successful");//
	}
	@Test(groups={"sanity"})
	public void search(){
		System.out.println("search successful");//
	}
	@Test(groups={"regression"})
	public void Advancedsearch(){
		System.out.println("Advancedsearch successful");
	}
	@Test
	public void prePaidRecharge(){
		System.out.println("prePaidRecharge successful");
	}
	@Test
	public void billPay(){
		System.out.println("billPay successful");
	}
	@Test(groups={"sanity","regression"})
	public void logout(){
		System.out.println("logout successful");//
	}
}
