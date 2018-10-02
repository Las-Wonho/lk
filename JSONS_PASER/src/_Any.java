import java.util.HashMap;
import java.util.Map;

public class _Any {
    Object value;

    _Any(Object v) {
        value = v;
    }

    Map<String, _Any> get_json_Array() {
        try {
            return Map.class.cast(value);
        } catch (Exception e) {
            return HashMap.class.cast(value);
        }
    }

    int get_int() {
        try {
            return (int) Integer.class.cast(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    boolean get_bool() {
        try {
            return (boolean) Boolean.class.cast(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    double get_double() {
        try {
            return (double) Double.class.cast(value);
        } catch (Exception e) {
        }
        return 0;
    }

    String get_string() {
        try {
            return String.class.cast(value);
        } catch (Exception e) {
        }
        return "";
    }
}
