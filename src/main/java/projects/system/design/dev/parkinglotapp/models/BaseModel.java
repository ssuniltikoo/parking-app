package projects.system.design.dev.parkinglotapp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private Long id;
    private Date createdDate;
    private Date updatedDate;
}
