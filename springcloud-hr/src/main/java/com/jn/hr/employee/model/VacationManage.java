package com.jn.hr.employee.model;

/**
 * @author dt
 * @create 2019-05-08 下午 4:25
 */
public class VacationManage {
    private String id;

    private String jobNumber;

    private String vacationType;

    private String vacationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(String vacationTime) {
        this.vacationTime = vacationTime;
    }

    @Override
    public String toString() {
        return "VacationManage{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", vacationType='" + vacationType + '\'' +
                ", vacationTime='" + vacationTime + '\'' +
                '}';
    }
}
