package models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name ="owners")


public class Owner {


    private List<Folder> folders;
    private int id;
    private String name;
    private String username;

    public Owner(String name, String username) {
        this.name = name;
        this.username = username;
        this.folders = folders;
    }

    public Owner() {
    }

    @OneToMany(mappedBy = "folders")
    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
