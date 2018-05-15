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
        DBHelper.save(file1);
        DBHelper.save(file2);
        DBHelper.save(file3);
        DBHelper.save(file4);
        DBHelper.save(file5);
        List<File> files = DBHelper.getAll(File.class);
    }
}
