package org.kainos.ea.cli;

public class Employee implements IPayable, IPermanent{
    private int employeeId;
    private String name;
    private double salary;
    private double monthlySales;
    private float commissionRate;

    public Employee(int employeeId, String name, double salary) {
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
    }
    public double calcPay(String role){
        if (role == "Software Engineer"){
            return getSalary()/12 + 1000;
        }else{
            return getSalary()/12;
        }

    }
    public double calcBonus(){
        return salary * 0.1;
    }

    public Employee(int employeeId, String name, double salary, double monthlySales, float commissionRate){
        setEmployeeId(employeeId);
        setName(name);
        setSalary(salary);
        setCommissionRate(commissionRate);
        setMonthlySales(monthlySales);
    }

    public double calcPay(){
        return getSalary()/12;
    }

    public double calcSalesEmployeePay(){
        return getSalary()/12 + (monthlySales*commissionRate);
    }
    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate){
        this.commissionRate = commissionRate;
    }
    public double getMonthlySales(){
        return monthlySales;
    }
    public void setMonthlySales(double monthlySales){
        this.monthlySales = this.monthlySales;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
