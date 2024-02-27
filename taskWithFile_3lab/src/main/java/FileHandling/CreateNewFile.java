package FileHandling;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    private File newFile;

    public void createNewFileInDir(String newFileName) throws IOException {
        CreateNewDir newDir = new CreateNewDir(newFileName);
        newDir.createNewDir();
        newFile = new File(newDir.getNewDir().getPath() + "/" + newFileName + ".txt");
        try {
            if (!newFile.createNewFile()) {
                throw new IOException("Can't make file " + newFile.getPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getNewFile() {
        return newFile;
    }
}
