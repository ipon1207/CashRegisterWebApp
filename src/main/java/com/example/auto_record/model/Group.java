package com.example.auto_record.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "pass")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private String createdAt;
}
