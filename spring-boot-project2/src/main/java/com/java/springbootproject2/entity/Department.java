package com.java.springbootproject2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long departmentid;
    @NotBlank(message = "Please Add Department Name")
    /*@Length(max=5,min=1)
    @Size(max=10,min=0)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent*/
    private String departmentname;
    private String departmentadress;
    private String departmentcode;


}

