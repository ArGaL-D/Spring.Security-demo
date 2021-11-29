package com.example.security.usuarios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    @JsonProperty("id")
    private Long userId;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String name;

    @Column(name = "apellido")
    @JsonProperty("apellido")
    private String lastname;

    @Column(name = "edad")
    @JsonProperty("edad")
    private Integer age;
    
}
