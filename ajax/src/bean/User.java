package bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @className: bean.User
 * @description:
 * @author: 江骏杰
 * @create: 2022-08-05 10:53
 */
public class User implements Serializable {
    private String username;
    private String userPwd;
    private String id;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username, String userPwd, String id) {
        this.username = username;
        this.userPwd = userPwd;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(userPwd, user.userPwd) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userPwd, id);
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
