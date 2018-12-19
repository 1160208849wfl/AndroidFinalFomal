package top.wufl.bean;

import javax.persistence.*;

@Entity
@Table(name = "T_Video")
@NamedQueries({
        @NamedQuery(name = "Video.findAll", query = "SELECT video FROM Video video"),
        @NamedQuery(name = "Video.findByUserName", query = "SELECT video FROM Video video where video.userName=:userName")
})
public class Video {
    @Id
    private int id;
    private String name;
    private String url;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
