package models;

import javax.persistence.*;

@Entity
@Table(name="files")

public class File {
    private String name;
    private String extention;
    private int size;
    private Folder folder;
    private int id;

    public File(String name, String extention, int size, Folder folder) {
        this.name = name;
        this.extention = extention;
        this.size = size;
        this.folder = folder;
    }

    public File() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "extention")
    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }
    @Column(name="size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

}
