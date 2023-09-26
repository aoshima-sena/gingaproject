package jp.co.ginga.cui.impl.janken.jankenplayer.impl;

import jp.co.ginga.cui.impl.janken.JankenParam;
import jp.co.ginga.cui.impl.janken.jankenplayer.JankenPlayer;
import jp.co.ginga.util.exception.ApplicationException;
import jp.co.ginga.util.exception.SystemException;
import jp.co.ginga.util.keybord.Keybord;
import jp.co.ginga.util.properties.MessageProperties;

public class HumanJankenPlayerImpl implements JankenPlayer {

	private String playerName;
	private int playerHand;

	public HumanJankenPlayerImpl(String playerName) {
		this.playerName = playerName;

	}

	@Override
	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public int getJankenHand() {
		return this.playerHand;
	}

	@Override
	public void selectJankenHand() throws SystemException {
		while (true) {
			System.out.println(MessageProperties.getMessage("janken.msg.select.hand.human"));
			try {
				playerHand = Keybord.getInt(1, 3);

				switch (JankenParam.getEnum(playerHand)) {
				case ROCK:
					playerHand = JankenParam.ROCK.getInt();
					break;
				case SCISSORS:
					playerHand = JankenParam.SCISSORS.getInt();
					break;
				case PAPER:
					playerHand = JankenParam.PAPER.getInt();
					break;
				default:
					throw new SystemException(MessageProperties.getMessage("error.arg"));
				}
				break;

			} catch (ApplicationException e) {

				System.out.println(MessageProperties.getMessage("janken.msg.select.hand.continue"));

			}

		}
	}
}
