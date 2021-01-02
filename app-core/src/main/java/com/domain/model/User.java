package com.domain.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Getter
    @Setter
    private Integer idUser;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

}
