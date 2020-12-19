package model;

import org.omg.CORBA.TIMEOUT;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee {
    private final static double INCRE_MULTI_NUMBER = 0.06;
    private String name;
    private String dob;
    private Role role;
    private String startDate;
    private double startSal;

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStartSal(float startSal) {
        this.startSal = startSal;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Role getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
    }

    public double getStartSal() {
        return startSal;
    }

    public double getAge() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDay = LocalDate.parse(this.dob, dateFormatter);
        return birthDay.until(LocalDate.now(), ChronoUnit.DAYS) / 365.2425f;
    }

    public double getSalary() {
        int month = getWorkMonth();
        if (month >= 12) {
            return startSal + INCRE_MULTI_NUMBER * startSal;
        }

        return startSal;
    }

    private int getWorkMonth() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startWorkDate = LocalDate.parse(this.startDate, dateFormatter);
        return (int)startWorkDate.until(LocalDate.now(), ChronoUnit.DAYS) / 30;
    }
}
