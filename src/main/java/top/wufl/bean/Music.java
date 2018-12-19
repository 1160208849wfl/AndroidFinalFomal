package top.wufl.bean;

import javax.persistence.*;

@Entity
@Table(name = "T_Music")
@NamedQueries({
        @NamedQuery(name = "Music.findAll", query = "SELECT music FROM Music music"),
        @NamedQuery(name = "Music.findByUserName", query = "SELECT music FROM Music music where music.userName=:userName")
})
public class Music {
    @Id
    private int id;
    private String name;
    private String artist;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
