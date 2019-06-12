package com.jn.hr.employee.enums;

/**
 * @author dt
 * @create 2019-05-08 下午 3:56
 */
public enum HolidayRuleEnum {
    ANNUAL_LEAVE("1", "年假","40"),
    COMPENSATED_LEAVE("2", "补休","0"),
    CASUAL_LEAVE("3", "事假","0"),
    SICK_LEAVE("4", "病假","96"),
    MARRIAGE_LEAVE("5", "婚假","0"),
    MATERNITY_LEAVE("6", "产假","0"),
    PATERNITY_LEAVE("7", "陪产假","0"),
    WORKRELATED_INJURY_LEAVE("8", "工伤假","0"),
    BEREAVEMENT_LEAVE("9", "丧假","0"),
    ;


    private String vacationType;

    private String message;
    private String vacationTime;

    HolidayRuleEnum(String vacationType, String message,String vacationTime) {
        this.vacationType = vacationType;
        this.message = message;
        this.vacationTime = vacationTime;
    }

    public String getVacationType() {
        return vacationType;
    }

    public String getMessage() {
        return message;
    }

    public String getVacationTime() {
        return vacationTime;
    }
}
