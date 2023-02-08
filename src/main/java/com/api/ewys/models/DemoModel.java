package com.api.ewys.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DemoModel - demo модель описывающая поля для работы с БД.
 */
@AllArgsConstructor
@Data
public class DemoModel {
    private int id;
    private String name;
    private String fullName;

    @Override
    public String toString() {
        return "DemoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

