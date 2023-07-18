package com.mycompany.app.another;

public class SubObj extends SuperObj {
	
	public void show() {
		super.print();
	}
	
	public void print() {
		System.out.print("sub");
	}
	
}
