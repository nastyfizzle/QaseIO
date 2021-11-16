package models.api;

import lombok.Data;

@Data
public class Response <T> {

    boolean status;
    T result;

    //из-за того, что в теле приходят status и result для проекта/сьюта/кейса, а в самом резалте разные данные могут быть, то правильнее создать новый класс, принимающий объект T
    //и тогда резалт будет распозноваться как разные объекты..
}
