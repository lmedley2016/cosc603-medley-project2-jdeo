package edu.towson.cis.cosc603.project2.monopoly;

import java.util.ArrayList;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class GameMasterTest.
 */
public class GameMasterTest extends TestCase {

	private GameMasterTestProduct gameMasterTestProduct = new GameMasterTestProduct();
	/** The game master. */
	GameMaster gameMaster;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardFull());
		gameMaster.setNumberOfPlayers(2);
        gameMaster.getPlayer(0).setName("Player 1");
        gameMaster.getPlayer(1).setName("Player 2");
		gameMaster.reset();
		gameMaster.setTestMode(true);
        gameMaster.setGUI(new MockGUI());
        gameMaster.startGame();
	}
	
	/**
	 * Test init.
	 */
	public void testInit() {
		assertEquals(gameMaster.getInitAmountOfMoney(),
				gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test reset.
	 */
	public void testReset() {
		gameMaster.movePlayer(0, 3);
		gameMaster.movePlayer(1, 4);
		gameMaster.reset();
		for(int i = 0; i < gameMaster.getNumberOfPlayers(); i++) {
			Player player = gameMaster.getPlayer(i);
			assertEquals("Go", player.getPosition().getName());
		}
		assertEquals(0, gameMaster.getTurn());
	}
    
    /**
     * Test trade process.
     */
    public void testTradeProcess() {
        gameMasterTestProduct.testTradeProcess(gameMaster);
    }
	
	/**
	 * Test turn.
	 */
	public void testTurn() {
		assertEquals(0, gameMaster.getTurn());
		gameMaster.switchTurn();
		assertEquals(1, gameMaster.getTurn());
		gameMaster.switchTurn();
		assertEquals(0, gameMaster.getTurn());
	}
	
	/**
	 * Test button get out of jail clicked.
	 */
	public void testButtonGetOutOfJailClicked() {
		MonopolyGUI gui = gameMaster.getGUI();
		gameMaster.movePlayer(0,30);
		gameMaster.btnEndTurnClicked();
		assertEquals("Jail", gameMaster.getPlayer(0).getPosition().getName());
		gameMaster.movePlayer(1,2);
		gameMaster.btnEndTurnClicked();
		assertTrue(gui.isGetOutOfJailButtonEnabled());
		assertTrue(gameMaster.getPlayer(0).isInJail());
		gameMaster.btnGetOutOfJailClicked();
		assertFalse(gameMaster.getPlayer(0).isInJail());
		assertEquals(1450,gameMaster.getPlayer(0).getMoney());
	}
	
	/**
	 * Test button purchase property clicked.
	 */
	public void testButtonPurchasePropertyClicked() {
		gameMasterTestProduct.testButtonPurchasePropertyClicked(gameMaster);
	}
	
	/**
	 * Test button roll dice clicked.
	 */
	public void testButtonRollDiceClicked() {
		gameMaster.reset();
		gameMaster.getGUI();
		gameMaster.btnRollDiceClicked();
		assertEquals(0,gameMaster.getCurrentPlayerIndex());
		assertEquals(gameMaster.getGameBoard().getCell(5), gameMaster.getPlayer(0).getPosition());
	}
	
	/**
	 * Test button trade clicked.
	 */
	public void testButtonTradeClicked() {
		gameMasterTestProduct.testButtonTradeClicked(gameMaster);
	}
}
