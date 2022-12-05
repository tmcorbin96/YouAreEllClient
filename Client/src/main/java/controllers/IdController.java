package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;
    private  String idUrl="http://zipcode.rocks:8085/ids";
    private ObjectMapper objectMapper = new ObjectMapper();
    private URL myUrl= null;
    private Id myId;
    private HttpClient client = HttpClient.newHttpClient();
    public ArrayList<Id> getIds(){
        try {
            myUrl = new URL(idUrl);
            return objectMapper.readValue(myUrl, new TypeReference<ArrayList<Id>>(){});
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj
        // ObjectMapper mapper = new ObjectMapper();
        Id createdID;
        try {
            String jsonID = objectMapper.writeValueAsString(id);
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(idUrl))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonID)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                createdID = objectMapper.readValue(response.body(), Id.class);
                myId=createdID;
            }
            return myId;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//        public Id putId(Id id) {
//        return null;
//    }

}