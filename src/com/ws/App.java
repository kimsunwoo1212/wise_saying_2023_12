package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	
	private byte system_status = 1;
	// system_status 변수에 1이란 값을 넣는다.
	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");
		// 실행 했을때 출력
		SystemController systemController = new SystemController();
		WiseSayingController wiseSayingController = new WiseSayingController();
		// 시스템 컨트롤러 타입에 시스템 컨트롤러 변수에 시스템 컨트롤러 객체 하나 만들겠다
		// 와이즈세잉컨트롤러 타입에 와이즈세잉컨트롤러 변수에 와이즈세잉컨트롤러 객체 하나 만들겠다
		while (system_status == 1) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();
			Rq rq = new Rq(cmd);
			//반복문 조건값이 true일때 명령어) 를 출력하고 다음순으로 명언, 작가 입력을 하겠다.
			switch (rq.getActionCode()) {
			case "종료":
				systemController.exit();
				system_status = 0;
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}