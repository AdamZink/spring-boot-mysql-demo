package com.github.adamzink.springbootmysqldemo.model.db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="APP_USER")
public class UserModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="ADD_TS")
    private Date addTs;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAddTs() {
        return addTs;
    }

    public void setAddTs(Date addTs) {
        this.addTs = addTs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != null ? !id.equals(userModel.id) : userModel.id != null) return false;
        if (firstName != null ? !firstName.equals(userModel.firstName) : userModel.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userModel.lastName) : userModel.lastName != null) return false;
        return addTs != null ? addTs.equals(userModel.addTs) : userModel.addTs == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (addTs != null ? addTs.hashCode() : 0);
        return result;
    }
}
