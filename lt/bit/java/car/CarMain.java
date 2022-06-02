package lt.bit.java.car;

import java.util.Arrays;
import java.util.Comparator;

public class CarMain
{
    public static void main(String[] args) {
     Car[] cars = {
             new Car("Audi", "automatic", 180),
             new Car("BMW", "automatic", 240),
             new Car("Mercedes", "manual", 210),
             new Car("Mazda", "automatic", 165),
             new Car("Opel", "manual", 160),

     };
     System.out.println(Arrays.toString(cars));

     Arrays.sort(cars, new Comparator<Car>() {
                 @Override
                 public int compare(Car c1, Car c2) {
                     return c2.getMaxSpeed() - c1.getMaxSpeed();
                 }
             });
             System.out.println(Arrays.toString(cars));
    }
}


class Car {

    private String name;
    private GearBoxType gearBox;
    private int maxSpeed;
    public Car(String name, String gearBox, int maxSpeed) {
        this.name = name;
        setGearBox(gearBox);
        this.maxSpeed = maxSpeed;
        setMaxSpeed(maxSpeed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGearBox() {
        return gearBox.toString();
    }

    public void setGearBox(String gearBox) {
        this.gearBox = GearBoxType.valueOf(gearBox.toUpperCase());
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed < 0)
          throw new IllegalArgumentException("maxSpeed cannot be negative");
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", gearBox=" + gearBox +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

enum GearBoxType {
    AUTOMATIC, MANUAL;
    @Override
    public String toString() {
        return name().toLowerCase();

    }
}
