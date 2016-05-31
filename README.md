# No Auth For You! #

A small fixture-project that examplifies the issues [#1048][1] and [#5638][2]
in Spring Boot (with Security) among others.

  [1]: https://github.com/spring-projects/spring-boot/issues/1048  
  [2]: https://github.com/spring-projects/spring-boot/issues/5638

## Overview

As mentioned in [#5638][2], a simple work-around is only possible when using
a pre 1.3.x version of Spring Boot. Together with my colleague, we came
up with a work-around that also works in 1.3.x - have a look at the
`ErrorController`.

### Spring Boot Versions and their Bug-Status:

* Spring Boot 1.2.8.RELEASE - **no auth for you!**
* Spring Boot 1.3.3.RELEASE - **no auth for you!**
* Spring Boot 1.3.4.RELEASE - **no auth for you!**
* Spring Boot 1.3.5.RELEASE - **no auth for you!**
* Spring Boot 1.4.0.M3 - **no auth for you!**

> Something sneaky did occur though - as I was trying out the 1.3.3.RELEASE fix,
  I noticed that the problem only appears when the `spring-boot-starter-actuator`
  is activated. Aha!

## Getting started

All apps are simple Maven projects and should compile, build and start as long
as Maven and Java 8 is properly set up. In each project, just run:

    mvn spring-boot:run

The app uses an interceptor to log the security context/auth status to the
console, for every request.

Demo-credentials are `user:user` or `admin:admin`.

To run the app **without** the quick-fix workaround, simply flick the switch
and start with the `without-fix` profile.

    mvn spring-boot:run -Dspring.profiles.active=without-fix

Have fun!
