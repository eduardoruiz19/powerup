package com.pragma.powerup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectModel {
    private Long id;
    private String name;
}
