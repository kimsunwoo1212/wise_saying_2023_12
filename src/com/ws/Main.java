package com.ws;

public class Main {
	public static void main(String[] args) {
		
		Container.init(); //초기화??
		
		new App().run(); // app클래스 실행

		Container.close(); //컨테이너 클래스 종료
	}
}