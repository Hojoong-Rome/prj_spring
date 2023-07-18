package com.mycompany.app.another;

public class SuperObj {
	public void show() {
		print();
	}
	
	public void print() {
		print();
		System.out.print("super");
	}
}
