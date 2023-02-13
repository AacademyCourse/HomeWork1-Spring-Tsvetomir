package com.example.homeworkOne.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "phone_number")
    private String phoneNumber;
    @Column (name = "email")
    private String email;
    @Column (name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Address> addressSet = new HashSet<Address>();
    @OneToMany(mappedBy = "user")
    private Set<Role> roleSet = new HashSet<Role>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
