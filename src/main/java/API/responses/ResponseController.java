package API.responses;

import com.google.gson.Gson;
import infra.HttpFacade;
import logic.Place;
import logic.ResponseData;

import static infra.HttpFacade.makeHttpRequest;

public class ResponseController {


    //POST_Reset_restaurant_data: Is a method that implement the reset restaurant data Api response using HTTP POST request
    public static <T> T POST_Reset_restaurant_data()throws RuntimeException{
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/reset", HttpFacade.HttpMethod.POST, "");
        return (T) Json;
    }

    //GET_Gets_all_restaurants: Is a method that implement the gets all restaurants Api response Using HTTP GET request
    public static <T> T GET_Gets_all_restaurants()throws RuntimeException{
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurants", HttpFacade.HttpMethod.GET, "");
        return (T) Json;
    }

    //POST_Creates_a_new_restaurant: Is a method that implement the creates a new restaurant Api response
    // by sending requestBody that contains the new restaurant property's using HTTP POST requests
    public static <T> T POST_Creates_a_new_restaurant(int id ,String name,double score , String Address)throws RuntimeException{
        String requestBody= "{\"id\": "+id+", \"name\": \""+name+"\", \"score\": "+score+", \"address\": \""+Address+"\"}";

        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant", HttpFacade.HttpMethod.POST, requestBody);
        return (T) Json;
    }

    //PATCH_Update_a_property_of_a_restaurant: Is a method that implement the update a property of a restaurant Api response
    // by sending requestBody that contains the targeted property's using HTTP PATCH requests
    public static <T> T PATCH_Update_a_property_of_a_restaurant(Integer OldId, Integer new_id ,String new_name ,Double new_score , String new_Address) throws RuntimeException{

        String requestBody ;
        Gson gson = new Gson();
        Place temp = new Place(new_id,new_name,new_Address,new_score);
        requestBody= gson.toJson(temp);
//        System.out.println(requestBody);
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/"+OldId, HttpFacade.HttpMethod.PATCH, requestBody);
        return (T) Json;
    }
    //DELETE_Delete_a_restaurant: Is a method that implement the Delete a restaurant Api response using HTTP DELETE request
    public static <T> T DELETE_Delete_a_restaurant(int Id)throws RuntimeException{
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/"+Id, HttpFacade.HttpMethod.DELETE, "");
        return (T) Json;
    }



}
