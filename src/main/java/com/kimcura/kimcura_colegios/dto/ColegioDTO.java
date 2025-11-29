package com.kimcura.kimcura_colegios.dto;

import java.io.Serializable;
import java.util.UUID;

public class ColegioDTO implements Serializable {

    final UUID id;
    final String name;
    final String address;
    
    public ColegioDTO(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
