package com.uep.wap.dto;

public class UserStatisticsDTO {
    private int id;

    private String username;

    private int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public UserStatisticsDTO(int id, String username, int value) {
        this.id = id;
        this.username = username;
        this.value = value;
    }

    public UserStatisticsDTO() {
    }
}
