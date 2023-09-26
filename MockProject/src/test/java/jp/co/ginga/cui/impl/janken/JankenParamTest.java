package jp.co.ginga.cui.impl.janken;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class JankenParamTest {

	private int rock = 1;
	private int scissors = 2;
	private int paper = 3;
	private int drow = 0;
	//null用
	private int illegalValue = -1;

	//コンストラクタから与えられた値はあってるか
	@Test
	public void testConstructorRock() {
		try {

			//getDeclaredFieldはpublic以外のもので持ってこれる
			Field enumValueField = JankenParam.class.getDeclaredField("enumValue");
			enumValueField.setAccessible(true);

			JankenParam param = JankenParam.ROCK;

			int result = (int) enumValueField.get(param);
			assertEquals(this.rock, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConstructorScissors() {
		try {
			Field enumValueField = JankenParam.class.getDeclaredField("enumValue");
			enumValueField.setAccessible(true);

			JankenParam param = JankenParam.SCISSORS;

			int result = (int) enumValueField.get(param);
			assertEquals(this.scissors, result);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConstructorPaper() {
		try {
			Field enumValueField = JankenParam.class.getDeclaredField("enumValue");
			enumValueField.setAccessible(true);

			JankenParam param = JankenParam.PAPER;

			int result = (int) enumValueField.get(param);
			assertEquals(this.paper, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testConstructorDrow() {
		try {
			Field enumValueField = JankenParam.class.getDeclaredField("enumValue");
			enumValueField.setAccessible(true);

			JankenParam param = JankenParam.DRAW;

			int result = (int) enumValueField.get(param);
			assertEquals(this.drow, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getIntTest() {

		JankenParam param = JankenParam.ROCK;

		int result = param.getInt();

		assertEquals(this.rock, result);
	}

	@Test
	public void getEnumTest() {
		//JankenParamのgetEnumで値を持ってきたときあっているかどうか
		JankenParam result = JankenParam.getEnum(this.rock);

		assertEquals(JankenParam.ROCK, result);
		assertEquals(this.rock, result.getInt());
	}

	@Test
	public void getEnumTestNo() {
		JankenParam result = JankenParam.getEnum(this.illegalValue);
		assertNull(result);
	}
}
