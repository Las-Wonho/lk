import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {
    JsonParser parser = new JsonParser();

    @Test
    @DisplayName("can String one depth")
    void jsonTest1() {
        String _json = "{\n" +
                "  \"name\": \"wonho\"\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("name").get_string().equals("wonho"));
    }

    @Test
    @DisplayName("can bool one depth")
    void jsonTest2() {
        String _json = "{\n" +
                "  \"state\": true\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("state").get_bool());
    }

    @Test
    @DisplayName("can int one depth")
    void jsonTest3() {
        String _json = "{\n" +
                "  \"year\": 2018\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("year").get_int() == 2018);
    }

    @Test
    @DisplayName("can double one depth")
    void jsonTest4() {
        String _json = "{\n" +
                "  \"pi\": 3.14\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("pi").get_double() == 3.14);
    }

    @Test
    @DisplayName("can string two depth")
    void jsonTest5() {
        String _json = "{\n" +
                "\"devDependencies\": {\n" +
                "    \"gulp\": \"^3.9.1\",\n" +
                "    \"gulp-coffee\": \"^2.3.4\",\n" +
                "    \"gulp-jade\": \"^1.1.0\",\n" +
                "    \"gulp-plumber\": \"^1.1.0\",\n" +
                "    \"gulp-riot\": \"^1.1.1\",\n" +
                "    \"gulp-uglify\": \"^2.1.2\"\n" +
                "  }\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("devDependencies").get_json_Array().get("gulp").get_string().equals("^3.9.1"));
    }

    @Test
    @DisplayName("can bool two depth")
    void jsonTest6() {
        String _json = "{\n" +
                "\"devDependencies\": {\n" +
                "    \"gulp\": false,\n" +
                "    \"gulp-coffee\": \"^2.3.4\",\n" +
                "    \"gulp-jade\": \"^1.1.0\",\n" +
                "    \"gulp-plumber\": \"^1.1.0\",\n" +
                "    \"gulp-riot\": \"^1.1.1\",\n" +
                "    \"gulp-uglify\": \"^2.1.2\"\n" +
                "  }\n" +
                "}";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());

        assertFalse(json.get("devDependencies").get_json_Array().get("gulp").get_bool());
    }

    @Test
    @DisplayName("can convert http header")
    void jsonTest7() {
        String _json = "    { request:\n" +
                "    { method: 'GET',\n" +
                "            url: '/',\n" +
                "            header:\n" +
                "        { host: 'localhost:3000',\n" +
                "                connection: 'keep-alive',\n" +
                "                purpose: 'prefetch',\n" +
                "                'upgrade-insecure-requests': '1',\n" +
                "                'user-agent':\n" +
                "            'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36',\n" +
                "                    accept:\n" +
                "            'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',\n" +
                "                    'accept-encoding': 'gzip, deflate, br',\n" +
                "                'accept-language': 'ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7',\n" +
                "                cookie: 'jenkins-timestamper-offset=-32400000' } },\n" +
                "        response: { status: 404, message: 'Not Found', header: {} },\n" +
                "        app: { subdomainOffset: 2, proxy: false, env: 'development' },\n" +
                "        originalUrl: '/',\n" +
                "                req: '<original node req>',\n" +
                "            res: '<original node res>',\n" +
                "            socket: '<original node socket>' }";

        JsonElement element = parser.parse(_json);

        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());
        assertTrue(json.get("request").get_json_Array()
                .get("method").get_string()
                .equals("GET"));
        assertTrue(json.get("request").get_json_Array()
                .get("header").get_json_Array()
                .get("connection").get_string()
                .equals("keep-alive"));
        assertTrue(json.get("response").get_json_Array()
                .get("status").get_int() == 404);
        assertFalse(json.get("app").get_json_Array()
                .get("proxy").get_bool());
    }

}