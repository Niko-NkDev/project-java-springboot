package com.nikonkdev.MySchoolAPP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 1. Se establecen las anotaciones con la libreria de Lombok para poder generar codigo repetitvo y de esta manera quede mas legible *
 * 2. Se usa la anotacion @Table para definir el nombre de la tabla segun lo establecido en SQL (base de datos)
 * 3. Definicion de la clase con sus respectivos atributos los cuales seran mapeados contra las columnas de la tabla
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="rol")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    @Column(name = "nombre")
    private String name;
}
