package com.POO.Sistema_De_Bar.dto;

import com.POO.Sistema_De_Bar.model.UserRole;

public record RegisterDTO(String login,
                          String senha,
                          UserRole role
) {}