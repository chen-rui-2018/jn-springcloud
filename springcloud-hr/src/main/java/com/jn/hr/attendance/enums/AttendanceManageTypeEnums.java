package com.jn.hr.attendance.enums;

import com.jn.common.api.CodeAndMsg;

public enum AttendanceManageTypeEnums implements CodeAndMsg{
    NORMAL("0","正常"),
	COME_LATE("1","迟到"),
	LEAVE_EARLY("2","早退"),
	MISS_CARD("3","缺卡"),
	OVER_TIME("4","加班"),
    ABSENCE("5","旷工"),
    LEAVE("6","请假"),
    ANNUAL_LEAVE("1","年假"),
    REVISION_REST("2","补休"),
    COMPASSIONATE_LEAVE("3","事假"),
    SICK_LEAVE("4","病假"),
    MARRIAGE_HOLIDAY("5","婚嫁"),
    FUNERAL_LEAVE("9","丧家"),
    MATERNITY_LEAVE("6","产假"),
    PATERNITY_LEAVE("7","陪产假"),
    WORK_INJURY_LEAVE("8","工伤假"),
    ;
    
	
	private String code;

    private String message;

    AttendanceManageTypeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
	
}
