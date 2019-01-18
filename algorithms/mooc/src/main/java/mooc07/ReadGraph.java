package mooc07;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author YaboSun
 *
 *
 */
public class ReadGraph {

    private Scanner scanner;

    public ReadGraph(Graph graph, String fileName) {

        readFile(fileName);

        int V = scanner.nextInt();
        if (V < 0) {
            throw new IllegalArgumentException("vertices in a graph must be nonnegative");
        }
        assert V == graph.V();

        int E = scanner.nextInt();
        if (E < 0) {
            throw new IllegalArgumentException("edges in a graph must be nonnegative");
        }

        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            assert v >= 0 && v < V;
            assert w >= 0 && w < V;
            graph.addEdge(v, w);
        }
    }

    private void readFile(String fileName) {
        assert fileName != null;
        String path = ReadGraph.class.getResource(File.separator + fileName).getPath();

        File file = new File(path);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
