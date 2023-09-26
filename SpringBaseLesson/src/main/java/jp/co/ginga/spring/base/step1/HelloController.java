package jp.co.ginga.spring.base.step1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author someya
 * HelloControllerクラス
 * Web基礎・Springハンズオン Step1
 */

@Controller
public class HelloController {

	// GET送信なのでURLの末尾のキーワードを指定している
	// （このURLにアクセスがあったときにメソッドが動く？）
	@GetMapping("/step1")
	public String createHelloGet() {

		// 表示するHTMLのディレクトリを指定している
		return "step1/index";
	}
}
