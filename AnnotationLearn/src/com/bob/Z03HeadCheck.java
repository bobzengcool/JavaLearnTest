package com.bob;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Z03HeadCheck {
    String dqdh() default "43";
    String jgdh() default "101";
    String jyrq() default "1899-01-01";
}
