import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;
import java.util.Map;

public class Json_Parse {
    static void parse(Map<String, _Any> json, JsonElement e, String s) {
        if (e.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = e.getAsJsonPrimitive();
            if (jsonPrimitive.isNumber()) {
                try {
                    json.put(s, new _Any(e.getAsJsonPrimitive().getAsDouble()));
                }catch (Exception ex){
                    json.put(s, new _Any(e.getAsJsonPrimitive().getAsInt()));
                }

            } else if (jsonPrimitive.isString()) {
                json.put(s, new _Any(e.getAsJsonPrimitive().getAsString()));
            } else if (jsonPrimitive.isBoolean()) {
                json.put(s, new _Any(e.getAsJsonPrimitive().getAsBoolean()));
            }
        }
        if (e.isJsonObject()) {
            json.put(s, new _Any(new HashMap<String, _Any>()));

            parse(json.get(s).get_json_Array(), e.getAsJsonObject());
        }
        if (e.isJsonArray()) {
            json.put(s, new _Any(new HashMap<String, _Any>()));
            JsonArray j = e.getAsJsonArray();
            for (int i = 0; i < j.size(); i++) {
                parse(json.get(s).get_json_Array(), j.get(i), String.valueOf(i));
            }
        }
    }

    static void parse(Map<String, _Any> json, JsonObject j) {
        j.entrySet().iterator().forEachRemaining(stringJsonElementEntry -> {
            parse(json, stringJsonElementEntry.getValue(), stringJsonElementEntry.getKey());
        });
    }
}
