package org.example;

import API.responses.RequestController;
import com.google.gson.Gson;
import infra.HttpFacade;
import logic.Place;
import logic.ResponseData;

import static infra.HttpFacade.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//        String requestBody_post = "{\"id\": 121212, \"name\": \"Shalom's place\", \"score\": 3.2, \"address\": \"The street 1\"}";
//        String requestBody_patch ="{\"address\": \"Hashalom 22 Tel Aviv\"}";

//        ResponseData Json2 = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/121212",HttpMethod.DELETE, "");
//        ResponseData js0 = RequestController.POST_Reset_restaurant_data();
//        ResponseData js1 = RequestController.GET_Gets_all_restaurants();
//        ResponseData js2 = RequestController.POST_Creates_a_new_restaurant(124,"Sh place",3.5," jk 50");
//        ResponseData js3 = RequestController.PATCH_Update_a_property_of_a_restaurant(125,125,"SH212",2.4,null);
//        ResponseData js4 = RequestController.DELETE_Delete_a_restaurant(125);




//        Integer i =1;
//        System.out.println(i);

        int OldId=124;
        int id = 124;
        String name = "Sh place";
        String address = "china town";
        double score= 4.5;
        String requestBody ;

        Gson gson = new Gson();
        Place temp = new Place(null,name,null,score);
        requestBody= gson.toJson(temp);
//        requestBody = "{\"id\": 124,  \"address\": \"Hashalom 22 Tel Aviv\",  \"Score\": 2.4}";
        System.out.println(requestBody);
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/"+OldId, HttpFacade.HttpMethod.PATCH, requestBody);

        }
    }
