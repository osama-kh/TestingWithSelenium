package API.responses;

import com.google.gson.Gson;
import infra.HttpFacade;
import logic.Place;
import logic.ResponseData;

import static infra.HttpFacade.makeHttpRequest;

public class RequestController {

    public static <T> T POST_Reset_restaurant_data(){
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/reset", HttpFacade.HttpMethod.POST, "");
        return (T) Json;
    }
    public static <T> T GET_Gets_all_restaurants(){
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurants", HttpFacade.HttpMethod.GET, "");
        return (T) Json;
    }

    public static <T> T POST_Creates_a_new_restaurant(int id ,String name,double score , String Address){
        String requestBody= "{\"id\": "+id+", \"name\": \""+name+"\", \"score\": "+score+", \"address\": \""+Address+"\"}";

        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant", HttpFacade.HttpMethod.POST, requestBody);
        return (T) Json;
    }

    public static <T> T PATCH_Update_a_property_of_a_restaurant(int OldId, Integer new_id ,String new_name ,Double new_score , String new_Address){

////        "{
////        \"id\": "+id+"
////        ,
////        \"name\": \""+name+"\"
////        ,
////        \"score\": "+score+"
////        ,
////        \"address\": \""+Address+"\"
////
////        }"
//
//        requestBody+="{";
//        if(new_id != null ){
//            requestBody+="\"id\": "+new_id+"";
//
//        }
//        requestBody+=", ";
//        if (new_name!=null || !new_name.isEmpty()) {
//            requestBody+="\"name\": \""+new_name+"\"";
//
//        }
//        requestBody+=", ";
//        if(new_score != null ){
//            requestBody+="\"score\": "+new_score+"";
//
//        }
//        requestBody+=", ";
//        if (new_Address!=null || !new_Address.isEmpty()) {
//            requestBody+="\"address\": \""+new_Address+"\" ";
//
//        }
//        requestBody+="}";
//
//        System.out.println(requestBody);
        String requestBody ;
        Gson gson = new Gson();
        Place temp = new Place(new_id,new_name,new_Address,new_score);
        requestBody= gson.toJson(temp);
//        System.out.println(requestBody);
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/"+OldId, HttpFacade.HttpMethod.PATCH, requestBody);
        return (T) Json;
    }

    public static <T> T DELETE_Delete_a_restaurant(int Id){
        ResponseData Json = makeHttpRequest(ResponseData.class,"https://us-central1-testomate-test.cloudfunctions.net/api/restaurant/"+Id, HttpFacade.HttpMethod.DELETE, "");
        return (T) Json;
    }



}
