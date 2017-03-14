package Logic;

/**
 * Created by julieglasdam on 14/03/2017.
 */
public class Employee {
    private String name;
    private int ID;
    private double salary;
    private char role = 'e';

    public Employee(){

    }

    public Employee (String name, int ID, double salary){
        this.name = name;
        this.ID = ID;
        this.salary = salary;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public double getSalary() {
        return salary;
    }

    public void setNumber(double salary) {
        this.salary = salary;
    }


    public char getRole(){
        return role;
    }

}
