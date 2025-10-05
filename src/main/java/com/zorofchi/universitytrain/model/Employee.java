package com.zorofchi.universitytrain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person{



}
