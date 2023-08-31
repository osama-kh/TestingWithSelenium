package logic;

import lombok.Data;

import java.util.List;

@Data
public class Place {
    private int id;
    private String name;
    private String address;
    private double score;

    public Place(int id,String name, String address, double score){
        this.id=id;
        this.name=name;
        this.address=address;
        this.score=score;

    }

}


