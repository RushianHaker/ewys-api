package com.api.ewys.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DemoModel - demo модель описывающая поля для работы с БД.
 */

@Data
@AllArgsConstructor
public class DemoModel {
    private int id;
    private String name;
    private String fullName;

}

