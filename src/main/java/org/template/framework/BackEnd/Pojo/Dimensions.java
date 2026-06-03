package org.template.framework.BackEnd.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dimensions {

    @JsonProperty("width")
    private double WIDTH;
    @JsonProperty("height")
    private double HEIGHT;
    @JsonProperty("depth")
    private double DEPTH;

}
