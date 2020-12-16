package model;

import org.omg.CORBA.TIMEOUT;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Employee {
    private String name;
    private String dob;
    private Role role;
    private String startDate;
    private float startSal;

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

    public float getStartSal() {
        return startSal;
    }

    public int getAgeFromDob() {
        Date now = Utils.getDateNow();
        Date birthDate = Utils.parseStringToDate(dob);
        long diffInMillies = Math.abs(now.getTime() - birthDate.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return (int)diffInDays / 365;
    }
}
