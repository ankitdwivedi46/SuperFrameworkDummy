package org.template.framework.BackEnd.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.template.framework.Utility.Annotation.Author;

import java.util.List;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

    @JsonProperty("id")
    private int ID;
    @JsonProperty("category")
    private String CATEGORY;
    @JsonProperty("brand")
    private String BRAND;
    @JsonProperty("reviews")
    private List<Reviews> REVIEWS;
    @JsonProperty("dimensions")
    private Dimensions DIMENSIONS;



}
