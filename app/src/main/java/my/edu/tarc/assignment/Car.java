package my.edu.tarc.assignment;

/**
 * Created by User on 06/01/2018.
 */

public class Car {
    private String carPlate ;
    private String carBrand ;
    private String model ;
    //private int year;

    public Car() {
    }
    public Car(String carPlate, String carBrand, String model, int year) {
        this.carPlate = carPlate;
        this.carBrand = carBrand;
        this.model = model;
        //this.year = year;
    }

    public String getCarPlate()
    {
        return carPlate ;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getCarBrand()
    {
        return carBrand ;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model ;
    }

    public void setModel(String model) {
        this.model = model;
    }

   // public int getYear() {
       // return year ;
    //}

   // public void setYear(int year) {
        //this.year = year;
    //}

    //@Override
   // public String toString() {
       // return "my.edu.tarc.lab44networkoperations.Course{" +
                //"code='" + code + " \' " +
               // ", title='" + title + " \' " +
               // ", credit='" + credit + " \' " +
               // '}' ;
   // }
}

