package projects.system.design.dev.parkinglotapp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private ResponseStatus responseStatus;
    private String message;
}
