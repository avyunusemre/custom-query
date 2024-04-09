package com.yunusky.customquery.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private boolean active;
    private long salary;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    public User(String username, boolean active, long salary, Date birthDate) {
        this.username = username;
        this.active = active;
        this.salary = salary;
        this.birthDate = birthDate;
    }
}
