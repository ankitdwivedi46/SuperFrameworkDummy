package org.template.framework.Utility.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Custom Annotation to Define the Author of the code.
Only Benefit is clean and direct pointing to Author
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Author {
    String name();
    String date();
    String email();
}
