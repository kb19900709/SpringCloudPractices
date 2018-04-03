package com.cathay.kb.practice.session.security.bean;

import java.util.List;

public class CurrentUser {
    private String userName;
    private List<String> rolesGroup;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRolesGroup() {
        return rolesGroup;
    }

    public void setRolesGroup(List<String> rolesGroup) {
        this.rolesGroup = rolesGroup;
    }
}
