package com.home.milkcount.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="Milks")
public class Milks {
    @Id
    private long id;
    private String name;
    private long price;
}
