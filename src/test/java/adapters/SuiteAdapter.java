package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Response;
import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    public void createSuite(Suite suite, String code) {
        post(new Gson().toJson(suite), "v1/project" + code, 200);
    }

    public void deleteSuite(String code) {
        delete("v1/suite" + code);
    }

    public Suite getSuite(String code, String suiteId) {
        String body = get("v1/suite/" + code + "/" + suiteId);
        return new Gson().fromJson(body, new TypeToken<Response<Suite>>() {}.getType());
    }
}
