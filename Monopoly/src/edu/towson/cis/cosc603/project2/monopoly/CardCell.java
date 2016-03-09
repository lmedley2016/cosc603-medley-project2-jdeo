package edu.towson.cis.cosc603.project2.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class CardCell.
 */
public class CardCell extends Cell {
    
    /** The type. */
    private int type;
	/**
     * Instantiates a new card cell.
     *
     * @param type the type
     * @param name the name
     */
    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc442.project1.monopoly.Cell#playAction()
     */
    public Boolean playAction(String msg) {
		return null;
    }
    
    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }
}
