package ir.ac.iust.dml.kg.knowledge.core.transforms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All transformer must has this annotation
 * 1- value must be unique and is key of transformer
 * 2- description can be empty
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transformer {
    String value();

    String description() default "";
}
