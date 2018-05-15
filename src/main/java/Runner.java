import db.DBHelper;
import models.File;
import models.Folder;

public class Runner {

    public static void main(String[] args) {

       Folder folder1 = new Folder("test title");
       File file1 = new File("test name", "txt", 4, folder1);

        DBHelper.save(folder1);
        DBHelper.save(file1);
    }
}
