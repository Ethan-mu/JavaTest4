package com.hand.exam1.vo;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyPage {
//
//	String value() default "pageSize";
//	String value() default "page";

}
