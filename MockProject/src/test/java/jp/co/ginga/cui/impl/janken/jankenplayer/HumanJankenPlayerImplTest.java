package jp.co.ginga.cui.impl.janken.jankenplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;

import jp.co.ginga.cui.impl.janken.JankenParam;
import jp.co.ginga.cui.impl.janken.jankenplayer.impl.HumanJankenPlayerImpl;
import jp.co.ginga.util.exception.SystemException;
import jp.co.ginga.util.keybord.Keybord;

public class HumanJankenPlayerImplTest {

	private int rock = JankenParam.ROCK.getInt();
	private int scissors = JankenParam.SCISSORS.getInt();
	private int paper = JankenParam.PAPER.getInt();
	private int illegalValue = -1;
	private int zerovalue = 0;
	private String playerName = "player";
	private String nullPlayerName = null;
	private int playerHand = rock;
	private int notPlayerHand = 0;
	private int from = rock;
	private int to = paper;
	private String errorMessage = "もう一度入力をお願いします。";

	@InjectMocks
	private HumanJankenPlayerImpl player = new HumanJankenPlayerImpl(this.playerName);

	@Test
	public void ConstructorOk() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerName");

			field.setAccessible(true);

			HumanJankenPlayerImpl impl = new HumanJankenPlayerImpl(this.playerName);

			String result = (String) field.get(impl);
			assertEquals(this.playerName, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void ConstructorNull() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerName");

			field.setAccessible(true);

			HumanJankenPlayerImpl impl = new HumanJankenPlayerImpl(this.nullPlayerName);

			String result = (String) field.get(impl);
			assertEquals(this.nullPlayerName, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getPlayerNameTest() {
		HumanJankenPlayerImpl impl = new HumanJankenPlayerImpl(this.playerName);
		String result = impl.getPlayerName();
		assertEquals(this.playerName, result);
	}

	@Test
	public void getPlayerNameTest1() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerName");
			field.setAccessible(true);
			//mockのthis.playerにfieldのthis.playerNameを入れる
			field.set(this.player, this.playerName);

			//resultにはplayerが入る
			String result = this.player.getPlayerName();
			//result2にはplayerNameが入る
			//	String result2 = field.getName();

			assertEquals(this.playerName, result);
			//	assertEquals(this.playerName, result2);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getPlayerNameNull() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerName");
			field.setAccessible(true);
			field.set(this.player, this.nullPlayerName);

			String result = this.player.getPlayerName();

			assertEquals(this.nullPlayerName, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getJankenHand() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);
			field.set(this.player, this.playerHand);

			int result = this.player.getJankenHand();

			assertEquals(this.playerHand, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getJankenHandNull() {
		try {
			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);
			field.set(this.player, this.notPlayerHand);

			int result = this.player.getJankenHand();

			assertEquals(this.notPlayerHand, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSelectJankenHandRock() {

		//モックをインスタンス生成
		//mockStaticを生成するとmocked.close()をする必要があるからtry-with-resourcesの中で書く
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			//() -> Keybord.getInt(this.from, this.to)をしたときグーを返す
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenReturn(this.rock);

			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int playerHand = (Integer) field.get(this.player);
			assertEquals(playerHand, this.rock);
			mockKeybord.verify(() -> Keybord.getInt(this.from, this.to), times(1));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSelectJankenHandScissors() {
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenReturn(this.scissors);

			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int playerHand = (Integer) field.get(this.player);
			assertEquals(playerHand, this.scissors);
			mockKeybord.verify(() -> Keybord.getInt(this.from, this.to), times(1));

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSelectJAnkenHandPaper() {
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenReturn(this.paper);

			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int playerHand = (Integer) field.get(this.player);
			assertEquals(playerHand, this.paper);
			mockKeybord.verify(() -> Keybord.getInt(this.from, this.to), times(1));
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}

	//nullを渡した後グーを渡したときの反応
	@Test
	public void testSelectJanekenHandApplicationException() {
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenThrow(new SystemException(null))
					.thenReturn(this.rock);

			Field field = HumanJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int playerHand = (Integer) field.get(this.player);
			assertEquals(this.rock, playerHand);
			mockKeybord.verify(() -> Keybord.getInt(this.from, this.to), times(2));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//範囲外の数字が渡されたときNullPointerExceptionが発生する
	@Test
	public void testSelectJankenHandNullPointerException() {
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenReturn(this.illegalValue);

			assertThrows(NullPointerException.class, () -> this.player.selectJankenHand());

		}
	}

	//0が渡されたときSystemExceptionが発生する
	@Test
	public void testSelectJankenHandSystemException() {
		try (MockedStatic<Keybord> mockKeybord = mockStatic(Keybord.class)) {
			mockKeybord.when(() -> Keybord.getInt(this.from, this.to)).thenReturn(this.zerovalue);

			SystemException e = assertThrows(SystemException.class, () -> this.player.selectJankenHand());
			assertEquals(this.errorMessage, e.getSysMsg());
			mockKeybord.verify(() -> Keybord.getInt(this.from, this.to), times(1));
		}
	}

}
