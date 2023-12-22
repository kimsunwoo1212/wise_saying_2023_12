package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();
	}

	public void write() {
		System.out.print("명언 : "); //등록 입력시 출력
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : "); // 명언 다음에 출력
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author); // int 데이터에 id라는 변수에 와이즈세잉서비스.write값을 
		//넣겠다 인자는 content, author

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 출력
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();
		// 리스트 와이즈세잉 데이터, 와이즈세잉 변수를 만들고 와이즈세잉서비스.findAll 을 하고 와이즈세잉 변수에 넣겠다
		System.out.println("번호  /  작가  /  명언  "); //출력
		System.out.println("=".repeat(30)); //출력

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {	//반복문 
			WiseSaying ws = wiseSayings.get(i);
			
			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
		}
	}

	public void remove(Rq rq) { //삭제 

		int id = rq.getIntParam("id", -1); //int id 라는 변수에 id== -1 값을 넣는다

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요"); //id 값이 -1일때 출력
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) { //수정
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}