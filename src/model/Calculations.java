package model;

/**
 * Interface stating the methods that apply to {@link MainTrainer Main Trainers} and {@link Player Players}.<br>
 * @author Samuel Hernandez <br>
 * @since 0.4.<br>
 */
public interface Calculations {
    /**
     * Calculates the market price of a player or main trainer.<br>
     * <b>Pre: </b><br>
     * <b>Post: </b>The market price is calculated.<br>
     */
    public String marketPrice();

    /**
     * Calculates the star level of a player or main trainer.<br>
     * <b>Pre: </b><br>
     * <b>Post: </b>The star level is calculated.<br>
     */
    public double starLevel();
}
