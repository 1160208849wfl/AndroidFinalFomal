package top.wufl.bean;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "T_User")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT user FROM User user"),
        @NamedQuery(name = "User.findByUserName", query = "SELECT user FROM User user where user.userName=:userName")
})
public class User {
    @Generated(GenerationTime.INSERT)
    @Column(name = "id", insertable = false, updatable = false)
    private int id;
    @Id
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", userName: " + userName + ", password: " + password + "]";
    }

}
