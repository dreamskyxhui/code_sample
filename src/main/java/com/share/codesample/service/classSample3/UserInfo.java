package com.share.codesample.service.classSample3;

import com.share.codesample.service.classSample1.BaseUserInfo;

public class UserInfo extends BaseUserInfo {

    private static Integer MAX_NAME_LEN = 3; //姓名最大长度

    private static Integer MIN_AGE = 0; //最小年龄
    private static Integer MAX_AGE = 130; //最大年龄
    private static Integer UNKNOWN_AGE = -1; //未知年龄

    private static Integer MAN_SEX_CODE = 1; //男性
    private static Integer FEMALE_SEX_CODE = 2; //女性
    private static Integer UNKNOWN_SEX_CODE = -1; //未知性别

    public UserInfo() {

    }

    public UserInfo(String inIdNo, String inMobile, String inName, Integer inSex, Integer inAge) {
        super(inIdNo, inMobile, inName, inSex, inAge);
        normalizeName();
        normalizeSex();
        normalizeAge();
    }

    private void normalizeName() {
        name = name.replace("~", "").trim().substring(0, MAX_NAME_LEN);
    }

    private void normalizeSex() {
        if (sex != MAN_SEX_CODE && sex != FEMALE_SEX_CODE) {
            sex = UNKNOWN_SEX_CODE;
        }
    }

    private void normalizeAge() {
        if (age < MIN_AGE) {
            age = UNKNOWN_AGE;
            return;
        }

        if (age > MAX_AGE) {
            age = UNKNOWN_AGE;
        }
    }

    public Boolean isDiffName(String cmpName) {
        if (null == name || name.isEmpty()) {
            return false;
        }

        if (null == cmpName || cmpName.isEmpty()) {
            return false;
        }

        if (name.equals(cmpName)) {
            return false;
        }

        return true;
    }

    public Boolean isDiffSex(Integer cmpSex) {
        if (null == sex || sex.equals(UNKNOWN_SEX_CODE)) {
            return false;
        }

        if (null == cmpSex || cmpSex.equals(UNKNOWN_SEX_CODE)) {
            return false;
        }

        if (sex.equals(cmpSex)) {
            return false;
        }

        return true;
    }

    public Boolean isDiffAge(Integer cmpAge) {
        if (null == age || age.equals(UNKNOWN_AGE)) {
            return false;
        }

        if (null == cmpAge || cmpAge.equals(UNKNOWN_AGE)) {
            return false;
        }

        if (age.equals(cmpAge)) {
            return false;
        }

        return true;
    }
}
