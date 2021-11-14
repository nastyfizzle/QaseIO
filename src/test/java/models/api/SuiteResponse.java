package models.api;

import lombok.Data;
import models.Suite;

@Data
public class SuiteResponse extends Response<Suite> {

    boolean status;
    Suite result;
}
