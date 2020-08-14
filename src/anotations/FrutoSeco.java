package anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FrutoSeco {
    boolean tieneVitaminaE() default false;

    int calorias();

    String arbolQueDaEsteFruto() default "";
}
