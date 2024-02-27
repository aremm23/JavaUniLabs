package FileHandling;

import java.io.File;
import java.io.IOException;

public class CreateNewDir {
    private final File rootDir = new File("taskWithFile_3lab/src/main/java/Data/OutputData");
    private File newDir;

    public CreateNewDir(String newDirName) {
        this.newDir = new File(rootDir.getPath() + "/" + newDirName);
    }

    public void createNewDir() throws IOException {
        if (!newDir.mkdir()) {
            throw new IOException("Can't make dir " + newDir.getPath());
        }
    }

    public File getNewDir() {
        return newDir;
    }


}
