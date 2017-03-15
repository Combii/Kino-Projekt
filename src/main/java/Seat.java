/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Seat {

    private int number;

    public Seat(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                '}';
    }
}
