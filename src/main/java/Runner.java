import db.DBFile;
import db.DBFolder;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

       Folder folder1 = new Folder("test title");
       Folder folder2 = new Folder("test title");
       Folder folder3 = new Folder("test title");
       Folder folder4 = new Folder("test title");
       File file1 = new File("test name", "txt", 4, folder1);
       File file2 = new File("test name", "txt", 4, folder1);
       File file3 = new File("test name", "txt", 4, folder1);
       File file4 = new File("test name", "txt", 4, folder1);
       File file5 = new File("test name", "txt", 4, folder1);

        DBHelper.save(folder1);
        DBHelper.save(folder2);
        DBHelper.save(folder3);
        DBHelper.save(folder4);
        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        DBHelper.save(file4);
        DBHelper.save(file5);
        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);

        file1.setExtention("pdf");
        DBFile.update(file1);
        List<File> files2 = DBHelper.getAll(File.class);
        folder2.setTitle("test title updated");
        DBFolder.update(folder2);
        List<Folder> folders2 = DBHelper.getAll(Folder.class);
        DBFile.delete(file5);
        List<File> files3 = DBHelper.getAll(File.class);


    }
}
