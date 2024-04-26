package edu.iu.otiwari.guitarservice.repository;

import edu.iu.otiwari.guitarservice.model.GuitarData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
public class InventoryFileRepository {
    public InventoryFileRepository() {
        File guitarsImagesDirectory = new File("guitars/images");
        if(!guitarsImagesDirectory.exists()) {
            guitarsImagesDirectory.mkdirs();
        }
        File guitarsAudioDirectory = new File("guitars/audio");
        if(!guitarsAudioDirectory.exists()) {
            guitarsAudioDirectory.mkdirs();
        }
    }
    private String IMAGES_FOLDER_PATH = "guitars/images/";
    private static final String DATABASE_NAME = "guitars/guitars_database.txt";
    private static final String NEW_LINE = System.lineSeparator();



    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public boolean add(GuitarData guitarData) throws IOException{

        Path path = Paths.get(DATABASE_NAME);
        String data = guitarData.toLine();
        System.out.println(data);
        appendToFile(path, data + NEW_LINE);
        return true;

    }

    public List<GuitarData> search(String type) throws IOException{
        List<GuitarData> guitars = findAll();
        List<GuitarData> result = new ArrayList<>();
        for(GuitarData guitar : guitars) {
            if (type != null && !guitar.getType().equalsIgnoreCase(type)) {
                continue;
            }
            result.add(guitar);
        }
        return result;
    }

    public List<GuitarData> findAll() throws IOException {
        List<GuitarData> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            GuitarData g = GuitarData.fromLine(line);
            result.add(g);
        }
        return result;
    }
    public GuitarData find(String serialNumber) throws IOException {
        List<GuitarData> guitars = findAll();
        for(GuitarData guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
}
