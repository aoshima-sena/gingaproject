package jp.co.ginga.cui.impl.janken;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import jp.co.ginga.util.exception.SystemException;
import jp.co.ginga.util.properties.MessageProperties;

public class JankenCuiGameApplicationImplTest {

	//privateメソッドはモック化できない
	private JankenCuiGameApplicationImpl impl = new JankenCuiGameApplicationImpl();

	//正常に動き、グーを変えすとき
	@Test
	public void actionTestRock() {
		try {
			//テストデータ
			int rock = JankenParam.ROCK.getInt();

			//スパイ化
			JankenCuiGameApplicationImpl spyGame = spy(JankenCuiGameApplicationImpl.class);
			doNothing().when(spyGame).createCpuOfJankenPlayer();
			doNothing().when(spyGame).createHumanOfJankenPlayer();
			doReturn(true).when(spyGame).isCheckJankenPlayerCount();
			doNothing().when(spyGame).selectJankenHand();
			doReturn(rock).when(spyGame).judge();
			doNothing().when(spyGame).viewWinner();
			doReturn(false).when(spyGame).hasGameContinue();
//			List<JankenPlayer> list = new ArrayList<>();
//			JankenPlayer jp = new HumanJankenPlayerImpl(
//					MessageProperties.getMessage("janken.msg.playername.human"));
//			list.add(jp);


			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spyGame,null); //nullにlist入れる。

			//spyを正常に動かせるようにfieldでセット
			spyGame.action();

			verify(spyGame, times(1)).createCpuOfJankenPlayer();
			verify(spyGame, times(1)).createHumanOfJankenPlayer();
			verify(spyGame, times(1)).isCheckJankenPlayerCount();
			verify(spyGame, times(1)).selectJankenHand();
			verify(spyGame, times(1)).judge();
			verify(spyGame, times(1)).viewWinner();
			verify(spyGame, times(1)).hasGameContinue();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//正常に動きチョキの時
	@Test
	public void actionTestChoki() {
		try {
			int scissors = JankenParam.SCISSORS.getInt();

			JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);
			doNothing().when(spy).createCpuOfJankenPlayer();
			doNothing().when(spy).createHumanOfJankenPlayer();
			doReturn(true).when(spy).isCheckJankenPlayerCount();
			doNothing().when(spy).selectJankenHand();
			doReturn(scissors).when(spy).judge();
			doNothing().when(spy).viewWinner();
			doReturn(false).when(spy).hasGameContinue();

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			spy.action();

			verify(spy, times(1)).createCpuOfJankenPlayer();
			verify(spy, times(1)).createHumanOfJankenPlayer();
			verify(spy, times(1)).isCheckJankenPlayerCount();
			verify(spy, times(1)).selectJankenHand();
			verify(spy, times(1)).judge();
			verify(spy, times(1)).viewWinner();
			verify(spy, times(1)).hasGameContinue();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//正常に動いてパーの時
	@Test
	public void actionTestPaper() {
		try {
			int paper = JankenParam.PAPER.getInt();

			JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);
			doNothing().when(spy).createCpuOfJankenPlayer();
			doNothing().when(spy).createHumanOfJankenPlayer();
			doReturn(true).when(spy).isCheckJankenPlayerCount();
			doNothing().when(spy).selectJankenHand();
			doReturn(paper).when(spy).judge();
			doNothing().when(spy).viewWinner();
			doReturn(false).when(spy).hasGameContinue();

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			spy.action();

			verify(spy, times(1)).createCpuOfJankenPlayer();
			verify(spy, times(1)).createHumanOfJankenPlayer();
			verify(spy, times(1)).isCheckJankenPlayerCount();
			verify(spy, times(1)).selectJankenHand();
			verify(spy, times(1)).judge();
			verify(spy, times(1)).viewWinner();
			verify(spy, times(1)).hasGameContinue();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//正常に動いてドロー判定が出たとき(そのあとパーを出す)
	@Test
	public void actionTestDraw() {
		try {
			int draw = JankenParam.DRAW.getInt();
			int paper = JankenParam.PAPER.getInt();

			JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);
			doNothing().when(spy).createCpuOfJankenPlayer();
			doNothing().when(spy).createHumanOfJankenPlayer();
			doReturn(true).when(spy).isCheckJankenPlayerCount();
			doNothing().when(spy).selectJankenHand();
			doReturn(draw).doReturn(paper).when(spy).judge();
			doNothing().when(spy).viewWinner();
			doReturn(false).when(spy).hasGameContinue();

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			spy.action();

			verify(spy, times(1)).createCpuOfJankenPlayer();
			verify(spy, times(1)).createHumanOfJankenPlayer();
			verify(spy, times(1)).isCheckJankenPlayerCount();
			verify(spy, times(2)).selectJankenHand();
			verify(spy, times(2)).judge();
			verify(spy, times(1)).viewWinner();
			verify(spy, times(1)).hasGameContinue();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//isCheckJankenPlayerCountでfalseが出てからtrueが出るようにする
	@Test
	public void actionTestCount() {
		try {
			int rock = JankenParam.ROCK.getInt();
			JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);
			doNothing().when(spy).createCpuOfJankenPlayer();
			doNothing().when(spy).createHumanOfJankenPlayer();
			doReturn(false).doReturn(true).when(spy).isCheckJankenPlayerCount();//あいこ→あいこ以外を返す
			doNothing().when(spy).selectJankenHand();
			doReturn(rock).when(spy).judge();
			doNothing().when(spy).viewWinner();
			doReturn(false).when(spy).hasGameContinue();

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			spy.action();

			verify(spy, times(2)).createCpuOfJankenPlayer();
			verify(spy, times(2)).createHumanOfJankenPlayer();
			verify(spy, times(2)).isCheckJankenPlayerCount();
			verify(spy, times(1)).selectJankenHand();
			verify(spy, times(1)).judge();
			verify(spy, times(1)).viewWinner();
			verify(spy, times(1)).hasGameContinue();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//hasGameContinueでtrueが返ってきたとき
	@Test
	public void actionTestContinue() {
		try {
			int rock = JankenParam.ROCK.getInt();
			JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);

			doNothing().when(spy).createCpuOfJankenPlayer();
			doNothing().when(spy).createHumanOfJankenPlayer();
			doReturn(true).when(spy).isCheckJankenPlayerCount();
			doNothing().when(spy).selectJankenHand();
			doReturn(rock).when(spy).judge();
			doNothing().when(spy).viewWinner();
			doReturn(true).doReturn(false).when(spy).hasGameContinue();

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			spy.action();

			verify(spy, times(2)).createCpuOfJankenPlayer();
			verify(spy, times(2)).createHumanOfJankenPlayer();
			verify(spy, times(2)).isCheckJankenPlayerCount();
			verify(spy, times(2)).selectJankenHand();
			verify(spy, times(2)).judge();
			verify(spy, times(2)).viewWinner();
			verify(spy, times(2)).hasGameContinue();

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	//janken.msg.startが見つからないとき
	@Test
	public void actionTestNoStart() {
		JankenCuiGameApplicationImpl spy = spy(JankenCuiGameApplicationImpl.class);
		try (MockedStatic<MessageProperties> mock = mockStatic(MessageProperties.class)) {
			mock.when(() -> MessageProperties.getMessage("janken.msg.start"))
					.thenThrow(new SystemException("janken.msg.start"));

			Field field = JankenCuiGameApplicationImpl.class.getDeclaredField("playerList");
			field.setAccessible(true);
			field.set(spy, null);

			SystemException result = assertThrows(SystemException.class, () -> spy.action());
			assertEquals("janken.msg.start", result.getSysMsg());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
