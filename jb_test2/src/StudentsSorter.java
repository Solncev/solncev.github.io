import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Марат on 25.05.2016.
 */
public interface StudentsSorter {
    void process(InputStream input, OutputStream output) throws IOException;
}
