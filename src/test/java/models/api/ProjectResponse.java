package models.api;

import lombok.Data;
import models.Project;

@Data
public class ProjectResponse extends Response<Project> {

    boolean status;
    Project result;
}
