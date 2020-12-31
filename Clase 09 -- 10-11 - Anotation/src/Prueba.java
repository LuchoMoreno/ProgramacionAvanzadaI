import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Siempre con RunTime.
@Retention(RetentionPolicy.RUNTIME)

// Esto elijo donde quiero poner la anotacion. En un metodo.
@Target(ElementType.METHOD)

public @interface Prueba {
	int intentos();
	String nombre() default "sin nombre";
	
	//Hay que poner Prueba p = getAnnotation(Prueba.class)
	//p.nombre

}
