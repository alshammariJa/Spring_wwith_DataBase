package com.example.springdata.Module;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
  private Integer id;
@NonNull
@Column(columnDefinition =  "varchar(4) not null")
@Size(min = 4,message = "enter valid  name")
    private String name;

@NonNull
//@Min(value = 4 ,message = "enter valid username")
@Size(min = 4,message = "enter valid username")
@Column(unique = true)
private String username;
@NonNull
@Column(columnDefinition =  "varchar(30) not null")
private String password;
@NonNull
@Email
@Column(unique = true)
private  String email;
@NonNull
@Positive
@Column(columnDefinition =  "varchar(30) not null \" not null check (role='user' or role='admin' \"" )

private String role;

@Positive
private Integer age;






}
