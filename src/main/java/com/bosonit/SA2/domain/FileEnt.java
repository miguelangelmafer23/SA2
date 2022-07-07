package com.bosonit.SA2.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class FileEnt {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String extension;
    private Date date_uploaded;
    private String path;
}
