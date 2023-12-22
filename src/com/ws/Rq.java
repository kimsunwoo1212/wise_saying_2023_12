package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode; //프라이빗 스트링 액션코드
	private Map<String, String> params; //프라이빗 맵 스트링 스트링 파람스

	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2); //스트링들을 담을 cmdBits에 cmd 인자에 ? 가 들어가고 두개면 쪼개겠다

		actionCode = cmdBits[0]; //액션코드 변수에 cmdBits 값을 넣겠다 인자는 0

		params = new HashMap<>(); // 파람스 변수랑 해쉬맵 객체 하나 만들겠다 

		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);

			if (paramStrBits.length == 1) {
				continue;
			}

			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}

	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) {
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}