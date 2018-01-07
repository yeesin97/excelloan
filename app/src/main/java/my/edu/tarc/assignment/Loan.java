package my.edu.tarc.assignment;

import java.util.Date;

/**
 * Created by User on 07/01/2018.
 */

public class Loan {
    private String loanID;
    private String userID;
    private char loanStatus;
    private double loanMonthlyIncome;
    private double loanMonthlyExpenses;
    private Date startdate;
    private int loanTerm;
    private double monthlyRepayment;
    private double loanAmount;
    private String guarantorIC;
    private String carPlate;

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public char getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(char loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getLoanMonthlyIncome() {
        return loanMonthlyIncome;
    }

    public void setLoanMonthlyIncome(double loanMonthlyIncome) {
        this.loanMonthlyIncome = loanMonthlyIncome;
    }

    public double getLoanMonthlyExpenses() {
        return loanMonthlyExpenses;
    }

    public void setLoanMonthlyExpenses(double loanMonthlyExpenses) {
        this.loanMonthlyExpenses = loanMonthlyExpenses;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getGuarantorIC() {
        return guarantorIC;
    }

    public void setGuarantorIC(String guarantorIC) {
        this.guarantorIC = guarantorIC;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
}
