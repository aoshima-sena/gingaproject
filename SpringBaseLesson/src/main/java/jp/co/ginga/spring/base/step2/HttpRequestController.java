package jp.co.ginga.spring.base.step2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HttpRequestController {

	@GetMapping("/step2")
	public String createIndexGet() {
		return "step2/index";
	}


	// GET通信
	// "/get"への遷移処理
	@GetMapping("/get")
	public String createSecondGet(HttpServletRequest request) {

		System.out.println("Get送信");

		//リクエストパラメーターから入力した値を取り出す処理
		String text = request.getParameter("paramGet");

		System.out.println("入力した値は、" + text + " です。");

		//遷移画面名をリターン
		return "step2/get";
	}

	// POST通信
	// "/post"への遷移処理
	@PostMapping("/post")
	public String createSecondPost(HttpServletRequest request) {

		System.out.println("Post送信");

		//リクエストパラメーターから入力した値を取り出す処理
		String text = request.getParameter("paramPost");

		System.out.println("入力した値は、" + text + " です。");

		//遷移画面名をリターン
		return "step2/post";
	}
}
