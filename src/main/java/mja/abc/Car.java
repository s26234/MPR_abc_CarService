package mja.abc;

public class Car {
    private String marka;
    private String model;
    private String vin;
     private CarType carType;

    public Car (String marka,String model, String vin, CarType carType) {
        this.marka = marka;
        this.model = model;
        this.vin = vin;
        this.carType = carType;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public CarType getCarType() {
        return carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
