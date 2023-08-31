package logic;

import lombok.Data;

import java.util.List;
@Data
public class ResponseData {
    private boolean success;
    private List<Place> data;
    private String error;

}
