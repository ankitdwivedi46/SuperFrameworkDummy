package org.template.framework.BackEnd.Enums;

/*
Enum to define the different HTTP methods for calling the API.
Benefit of having enum is that it makes code more readable and maintainable.
Also it removes the need to change at multiple places in case of any new addition or deletion.
*/


import org.template.framework.Utility.Annotation.Author;

@Author(name = "Ankit Dwivedi",
date = "2026-05-22",
email = "ankitdwivedi46@live.com")
public enum RestMethods {

    GET,
    POST,
    PUT,
    PATCH,
    DELETE;

}
