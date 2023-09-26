package jp.co.ginga.cui.impl.janken.jankenplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import jp.co.ginga.cui.impl.janken.JankenParam;
import jp.co.ginga.cui.impl.janken.jankenplayer.impl.CpuJankenPlayerImpl;
import jp.co.ginga.util.exception.SystemException;

public class CpuJankenPlayerImplTest {

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
	private String erroeMessage = "パラメーターの値が不正です。";

	@InjectMocks
	private CpuJankenPlayerImpl player = new CpuJankenPlayerImpl(this.playerName);

	@Test
	public void consructorOk() {
		try {
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerName");
			field.setAccessible(true);

			CpuJankenPlayerImpl impl = new CpuJankenPlayerImpl(this.playerName);

			String result = (String) field.get(impl);
			assertEquals(this.playerName, result);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void NoConstructor() {
		try {
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerName");
			field.setAccessible(true);

			CpuJankenPlayerImpl impl = new CpuJankenPlayerImpl(this.nullPlayerName);

			String result = (String) field.get(impl);
			assertEquals(this.nullPlayerName, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getPlayerName() {
		try {
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerName");
			field.setAccessible(true);
			field.set(this.player, this.playerName);

			String result = this.player.getPlayerName();

			assertEquals(this.playerName, result);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void getPlayerNameNull() {
		try {
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerName");
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
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerHand");
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
	public void getJankenHandNo() {
		try {
			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);
			field.set(this.player, this.playerHand);

			int result = this.player.getJankenHand();

			assertEquals(this.playerHand, result);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//グーの時
	@Test
	public void selectJankenHandRock() {
		try (MockedConstruction<Random> mockRandom = Mockito.mockConstruction(Random.class,
				(random, context) -> when(random.nextInt(this.to)).thenReturn(this.rock - 1))) {
			//	mockKeybord.when(() -> Random().nextInt(3)).thenReturn(this.rock);

			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int playerHand = (Integer) field.get(this.player);
			assertEquals(playerHand, this.rock);
			assertEquals(mockRandom.constructed().size(), 1);
			verify(mockRandom.constructed().get(0), times(1)).nextInt(this.to);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void selectJankenHandChoki() {
		try (MockedConstruction<Random> mockRandom = Mockito.mockConstruction(Random.class,
				(random, context) -> when(random.nextInt(this.to)).thenReturn(this.scissors - 1))) {

			Field field = CpuJankenPlayerImpl.class.getDeclaredField("playerHand");
			field.setAccessible(true);

			this.player.selectJankenHand();

			int result = (Integer) field.get(this.player);
			assertEquals(result
					, this.scissors);
			verify(mockRandom.constructed().get(0), times(1));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSelectJankenHandNullpointer() {
		//モック化
		try (MockedConstruction<Random> mockRandom = mockConstruction(
				Random.class,
				(random, context) -> when(random.nextInt(this.to)).thenReturn(this.illegalValue - 1))) {
			//テストメソッド 、検証
			assertThrows(NullPointerException.class, () -> this.player.selectJankenHand());
			assertEquals(mockRandom.constructed().size(), 1);
			verify(mockRandom.constructed().get(0), times(1)).nextInt(this.to);
		}
	}

	@Test
	public void testSelectJanakenHandSystemException() {
		try (MockedConstruction<Random> mockRandom = mockConstruction(Random.class,
				(random, context) -> when(random.nextInt(this.to)).thenReturn(this.zerovalue - 1))) {
			SystemException e = assertThrows(SystemException.class, () -> this.player.selectJankenHand());
			assertEquals(this.erroeMessage, e.getSysMsg());
			assertEquals(mockRandom.constructed().size(), 1);
			verify(mockRandom.constructed().get(0), times(1)).nextInt(this.to);
		}
	}
}
