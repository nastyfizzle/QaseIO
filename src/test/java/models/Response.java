package models;

import lombok.Data;

@Data
public class Response <T> {

    boolean status;
    T result;
}
