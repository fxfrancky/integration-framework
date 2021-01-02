package com.domain.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements Serializable {

    @Getter
    @Setter
    private Integer idRole;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

}
