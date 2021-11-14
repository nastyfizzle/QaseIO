package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.api.Response;
import models.Suite;

public class SuiteAdapter extends BaseAdapter {
    public void createSuite(Suite suite, String code) {
        post(new Gson().toJson(suite), "v1/suite" + code, 200);
    }

    public void deleteSuite(String code, int suiteId) {
        delete("v1/suite" + code + "/" + suiteId, 200);
    }

    public Response<Suite> getSuite(String code, int suiteId) {
        String body = get("v1/suite/" + code + "/" + suiteId, 200);
        return new Gson().fromJson(body, new TypeToken<Response<Suite>>() {}.getType());
    }

    public Response<Suite> updateSuite(Suite suite, String code, int suiteId) {
        String body = patch(new Gson().toJson(suite), "v1/suite" + code + "/" + suiteId, 200);
        return new Gson().fromJson(body, new TypeToken<Response<Suite>>() {}.getType());
    }
}
