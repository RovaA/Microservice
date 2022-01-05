package com.example.demopayment.domain;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Command implements Serializable {

    String name;
}
