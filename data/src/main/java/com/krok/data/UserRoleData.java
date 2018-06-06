package com.krok.data;

import javax.persistence.*;

/**
 * Created by Mateusz Krok on 2018-06-06
 */

@Entity
@Table(name = "USER_ROLES")
public class UserRoleData {

    @Id
    @Column(name = "URO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "URO_USR_ID", nullable = false)
    private UserData userData;

    @Column(name = "URO_ROLE")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleData{" +
                "id=" + id +
                ", userData=" + userData +
                ", role='" + role + '\'' +
                '}';
    }
}
