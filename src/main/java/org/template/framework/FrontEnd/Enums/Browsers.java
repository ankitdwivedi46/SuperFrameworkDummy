package org.template.framework.FrontEnd.Enums;

import org.template.framework.Utility.Annotation.Author;

/*
Enum to define the different Browsers methods for calling the WebDriver Factory.
Benefit of having enum is that it makes code more readable and maintainable.
Also it removes the need to change at multiple places in case of any new addition or deletion.
*/

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public enum Browsers {

    CHROME,
    FIREFOX,
    SAFARI,
    EDGE;

}
