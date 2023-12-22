package com.ws.wiseSaying.entity;

public class WiseSaying {
	private int id; //프라이빗 클래스 int id
	private String content; //프라이빗 스트릴 content
	private String author; // 프라이빗 스트링 author

	public WiseSaying(int id, String content, String author) { // 퍼블릭 클래스 와이즈세잉 인자 int id 스트링콘텐트 스트링 author
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId() { //프라이빗 클래스 가져다 쓰려고
		return id;
	}

	public void setId(int id) {//프라이빗 클래스 가져다 쓰려고
		this.id = id;
	}

	public String getContent() {//프라이빗 클래스 가져다 쓰려고
		return content;
	}

	public void setContent(String content) {//프라이빗 클래스 가져다 쓰려고
		this.content = content;
	}

	public String getAuthor() {//프라이빗 클래스 가져다 쓰려고
		return author;
	}

	public void setAuthor(String author) {//프라이빗 클래스 가져다 쓰려고
		this.author = author;
	}
}