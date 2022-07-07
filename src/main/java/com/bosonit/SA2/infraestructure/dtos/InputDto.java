package com.bosonit.SA2.infraestructure.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class InputDto {
    private String name;
    private String extension;
    private Date date_uploaded;
}
