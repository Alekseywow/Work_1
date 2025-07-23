import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.JsonFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class JsonTest {

    private ClassLoader cl = JsonTest.class.getClassLoader();

    private static final Gson gson = new Gson();

    @Test
    void checkFileParsingJson() throws Exception {
        try(Reader reader = new InputStreamReader(
                cl.getResourceAsStream("JsonFile.json")
        )) {
            JsonFile jsonFile = gson.fromJson(reader, JsonFile.class);

            Assertions.assertEquals("Small", jsonFile.getSize());
            Assertions.assertEquals("Black", jsonFile.getColor());
            Assertions.assertEquals(2.5, jsonFile.getVolume());
            Assertions.assertEquals("Used", jsonFile.getCondition());
            Assertions.assertTrue(jsonFile.isClosed());
            Assertions.assertEquals(List.of("lipstick", "phone", "wallet"), jsonFile.getContents());

        }
    }

}
