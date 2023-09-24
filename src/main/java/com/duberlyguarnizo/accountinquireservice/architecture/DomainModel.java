/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.architecture;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that a class is a domain model.
 *
 * <p>The {@code @DomainModel} annotation is used with ArchUnit to check if a class
 * is a domain model.
 *
 * <p>Example usage:
 * <pre>{@code
 * @DomainModel
 * public class Customer {
 *     // Class body
 * }
 * }</pre>
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface DomainModel {
}
