package logic;

import lombok.Data;

import java.util.List;

//Place class to store the data of restaurant that included in a Http request and response using Gson library
@Data
public class Place {
    private Integer id;
    private String name;
    private String address;
    private Double score;

    public Place(Integer id,String name, String address, Double score){
        this.id=id;
        this.name=name;
        this.address=address;
        this.score=score;

    }

}


