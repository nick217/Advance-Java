package com.practice.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) //class that contains business logic for this class.
@Target({ElementType.METHOD, ElementType.FIELD}) //places where this annotation can be applied.
@Retention(RetentionPolicy.RUNTIME) //This says how long will the marked annotation be stored or used.
									// RetentionPolicy.RUNTIME: store in byte code (class file), use at runtime.
public @interface CourseCode {

	//define default course code
	public String value() default "CS";
	
	//define default error message
	public String message() default "must start with CS";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads
	public Class<? extends Payload>[] payload() default{}; //can contain extra info about errors occured.
}
