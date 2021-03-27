package com.home.milkcount.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity(name="milk_details")
public class Milk_Details {
    @Id
    private long id;
    private String username;
    private String name;
    private int count;
    private Timestamp datetime;
}
