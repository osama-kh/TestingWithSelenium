package logic;

import lombok.Data;

import java.util.List;
//Place ResponseData to store the data of Http request and response status using Gson library

@Data
public class ResponseData {
    private boolean success;
    private List<Place> data;
    private String error;

}
