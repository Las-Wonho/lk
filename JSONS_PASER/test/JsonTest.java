import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    @Test
    void jsonTest(){
        String _json = "";

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(_json);
        Map<String, _Any> json;
        json = new HashMap<>();
        parse(json, element.getAsJsonObject());
    }
}