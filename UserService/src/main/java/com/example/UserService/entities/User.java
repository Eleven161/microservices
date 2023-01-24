package com.example.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
@Column(name="NAME" ,length=20)
private String name;
@Id
@Column(name="ID")
private String userId;
@Column(name="EMAIL")
private String email;
@Column(name="ABOUT")
private String about;
@Transient         // because we are getting this from another microservices we do'nt need to store it in database of users
private List<Rating> ratings=new ArrayList<>();
}
