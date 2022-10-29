package persistence;

import org.json.JSONObject;

// The Interface below is taken and modified from JsonSerializationDemo file provided during class
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}