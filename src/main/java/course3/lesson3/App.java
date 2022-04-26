package course3.lesson3;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        final File file = new File("mydir", "myfile.txt");
        String path = "C:\\myfile.txt"; //windows
        String path1 = "mydir/myfile.txt";
        //File.separator
        boolean exists = file.exists();
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.length() = " + file.length());
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());

        try {
            boolean newFile = file.createNewFile();
            System.out.println("newFile = " + newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean mkdir = file.mkdir();
        boolean delete = file.delete();

        file.listFiles();

        File f = new File("C:\\Users\\muist\\IdeaProjects\\Java2007\\src");
        App app = new App();
        app.dirWalker(f, 0);
    }
    private void dirWalker(File file, int level){
        level++;
        for(File child: file.listFiles()){
            if(child.isDirectory()){
                System.out.println("-".repeat(level) + child);
                dirWalker(child, level);
            } else {
                System.out.println("-".repeat(level) + child.getAbsolutePath());
            }
        }
    }
}
