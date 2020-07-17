package pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    private Integer empId;
    private Integer depId;
    private String firstName;
    private String lastName;
    private Double salary;
    private Date hiretime;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiretime() {
        return hiretime;
    }

    public void setHiretime(Date hiretime) {
        this.hiretime = hiretime;
    }
}
