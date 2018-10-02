import java.util.HashMap;
import java.util.Map;

public class Any {

    int int_value;
    boolean bool_value;
    String string_value;
    double double_value;
    boolean lock;
    Map<String, Any> json_value;

    Any() {
        lock = false;
        json_value = new HashMap<String, Any>();
    }

    Any(int value) {
        int_value = value;
    }

    Any(boolean value) {
        bool_value = value;
    }

    Any(String value) {
        string_value = value;
    }

    Any(double value) {
        double_value = value;
    }


    Any setValue(String key, int value) {
        if (lock) {
            return null;
        }
        json_value.put(key, new Any(value));
        return this;
    }

    Any setValue(String key, boolean value) {
        if (lock) {
            return null;
        }
        json_value.put(key, new Any(value));
        return this;
    }

    Any setValue(String key, String value) {
        if (lock) {
            return null;
        }
        json_value.put(key, new Any(value));
        return this;
    }

    Any setValue(String key, double value) {
        if (lock) {
            return null;
        }
        json_value.put(key, new Any(value));
        return this;
    }
    Any setValue(String key, Any value) {
        if (lock) {
            return null;
        }
        json_value.put(key, value);
        return this;
    }

}
