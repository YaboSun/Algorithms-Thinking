package mooc08.weightedgraph;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author YaboSun
 */
public class ReadWeightedGraph {

    private Scanner scanner;

    public ReadWeightedGraph(WeightedGraph<Double> graph, String fileName) {

        readFile(fileName);

        try {
            int V = scanner.nextInt(); // 定义读取顶点数
            if (V <= 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            }
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E <= 0) {
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            }
            assert E == graph.E();

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                Double weight = scanner.nextDouble();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;

                graph.addEdge(new Edge<>(v, w, weight));
            }
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private void readFile(String fileName) {
        assert fileName != null;
        try {
            String path = ReadWeightedGraph.class.getResource(File.separator + fileName).getPath();
            File file = new File(path);

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
            else {
                throw new IllegalArgumentException(fileName + " doesn't exist.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open " + fileName, e);
        }
    }
}
