package com.POO.Sistema_De_Bar.dto;

import java.util.UUID;

public record AdicionarItemDTO(
        UUID produtoId,
        Integer quantidade
) {}