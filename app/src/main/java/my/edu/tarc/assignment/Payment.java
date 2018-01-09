package my.edu.tarc.assignment;

/**
 * Created by Personal on 10/1/2018.
 */

public class Payment {

    private String paymentID;
    private String paymentDate;
    private double amount;
    private int noOfTrans;

    public Payment() {
    }

    public Payment(String paymentID, String paymentDate, double amount, int noOfTrans) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.noOfTrans = noOfTrans;
    }

    public Payment(String paymentDate, double amount, int noOfTrans) {
        this.paymentID = "";
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.noOfTrans = noOfTrans;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNoOfTrans() {
        return noOfTrans;
    }

    public void setNoOfTrans(int noOfTrans) {
        this.noOfTrans = noOfTrans;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", amount=" + amount +
                ", noOfTrans=" + noOfTrans +
                '}';
    }
}
