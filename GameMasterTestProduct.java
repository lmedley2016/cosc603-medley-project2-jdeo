package edu.towson.cis.cosc603.project2.monopoly;


import java.util.ArrayList;

public class GameMasterTestProduct {
	/**
	 * Test trade process.
	 */
	public void testTradeProcess(GameMaster gameMaster) {
		gameMaster.testTradeProcess();
	}

	/**
	 * Test button purchase property clicked.
	 */
	public void testButtonPurchasePropertyClicked(GameMaster gameMaster) {
		@SuppressWarnings("unused")
		MonopolyGUI gui = gameMaster.getGUI();
		gameMaster.movePlayer(0, 1);
		gameMaster.btnPurchasePropertyClicked();
		GameMasterTest.assertEquals(gameMaster.getGameBoard().getCell(1),
				gameMaster.getCurrentPlayer().getAllProperties()[0]);
		GameMasterTest.assertEquals(1440, gameMaster.getCurrentPlayer()
				.getMoney());
	}

	/**
	 * Test button trade clicked.
	 */
	public void testButtonTradeClicked(GameMaster gameMaster) {
		gameMaster.getGUI();
		gameMaster.movePlayer(0, 1);
		gameMaster.getCurrentPlayer().purchase();
		gameMaster.btnEndTurnClicked();
		gameMaster.btnTradeClicked();
		GameMasterTest.assertEquals(gameMaster.getGameBoard().getCell(1),
				gameMaster.getCurrentPlayer().getAllProperties()[0]);
		GameMasterTest.assertEquals(1640, gameMaster.getPlayer(0).getMoney());
		GameMasterTest.assertEquals(1300, gameMaster.getPlayer(1).getMoney());
	}
}