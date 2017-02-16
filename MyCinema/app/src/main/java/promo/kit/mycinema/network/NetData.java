package promo.kit.mycinema.network;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import promo.kit.mycinema.model.Movie;

/**
 * Created by Влад on 15.01.17.
 */

public class NetData {
    private static final String TAG = "NetData";
    private static final String API_KEY = "b4b187ef65d78f5f798a4acb5f7b531e";
    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ": witch " + urlSpec);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<Movie> fetchItems() {
        List<Movie> items = new ArrayList<>();
        try {
            String url = Uri.parse("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=b4b187ef65d78f5f798a4acb5f7b531e&language=ru")
                    .toString();
            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(items, jsonBody);

        }catch (JSONException je) {
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to net items: ", ioe);
        }

        return items;
    }


    private void parseItems(List<Movie> items, JSONObject jsonBody) throws IOException, JSONException {
        JSONArray movieJsonArray = jsonBody.getJSONArray("results");
        Gson gson = new Gson();
        for(int i = 0; i < movieJsonArray.length(); i++) {
            JSONObject movieJson = movieJsonArray.getJSONObject(i);
            Movie item = gson.fromJson(movieJson.toString(), Movie.class);

            items.add(item);
        }
    }

}
