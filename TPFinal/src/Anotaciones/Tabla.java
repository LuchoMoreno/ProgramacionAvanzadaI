package Anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// NIVEL CLASE.
@Target(ElementType.TYPE)
public @interface Tabla {
	String nombre();
}
