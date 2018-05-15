import db.DBFile;
import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("test name", "test username");
        Owner owner2 = new Owner("test name", "test username");
        Owner owner3 = new Owner("test name", "test username");

        Folder folder1 = new Folder("test title", owner1);
        Folder folder2 = new Folder("test title", owner2);
        Folder folder3 = new Folder("test title", owner3);
        Folder folder4 = new Folder("test title", owner3);

        File file1 = new File("test name", "txt", 4, folder1);
        File file2 = new File("test name", "txt", 4, folder1);
        File file3 = new File("test name", "txt", 4, folder1);
        File file4 = new File("test name", "txt", 4, folder1);
        File file5 = new File("test name", "txt", 4, folder1);


        DBHelper.save(owner1);
        DBHelper.save(owner2);
        DBHelper.save(owner3);

        List<Owner> owners = DBHelper.getAll(Owner.class);

        owner1.setUsername("updated test username");
        DBOwner.update(owner1);

        List<Owner> owners2 = DBHelper.getAll(Owner.class);

        DBOwner.delete(owner2);
        List<Owner> owners3 = DBHelper.getAll(Owner.class);



        DBHelper.save(folder1);
        DBHelper.save(folder2);
        DBHelper.save(folder3);
        DBHelper.save(folder4);

        List<Folder> folders = DBHelper.getAll(Folder.class);

        folder2.setTitle("test title updated");
        DBFolder.update(folder2);

        List<Folder> folders2 = DBHelper.getAll(Folder.class);


        DBFolder.delete(folder4);
        List<Folder> folders3 = DBHelper.getAll(Folder.class);

        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        DBHelper.save(file4);
        DBHelper.save(file5);


        List<File> files = DBHelper.getAll(File.class);


        file1.setExtention("pdf");
        DBFile.update(file1);

        List<File> files2 = DBHelper.getAll(File.class);


        DBFile.delete(file5);
        List<File> files3 = DBHelper.getAll(File.class);



        List<File> filesinFolder1 = DBFolder.getFilesInFolder(folder1);
        List<Folder> foldersinOwner = DBOwner.getFoldersOfOwner(owner3);

    }
}
