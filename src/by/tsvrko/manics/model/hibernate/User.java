package by.tsvrko.manics.model.hibernate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created main.by tsvrko on 11/22/2016.
 */
@Entity
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "LOGIN") })
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASS")
    private String pass;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    private UserSession userSession;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Chat> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public List<Chat> getList() {
        return list;
    }

    public void setList(List<Chat> list) {
        this.list = list;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User() {
    }

    public User(String login, String pass, UserSession userSession) {
        this.login = login;
        this.pass = pass;
        this.userSession = userSession;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        return pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }
}
