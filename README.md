# No Auth For You! #

A small fixture-project that examplifies the issues [#1048][1] and [#5638][2]
in Spring Boot (with Security) among others.

  [1]: https://github.com/spring-projects/spring-boot/issues/1048  
  [2]: https://github.com/spring-projects/spring-boot/issues/5638

## Overview

As mentioned in [#5638][2], a simple work-around is only possible when using
a pre 1.3.x version of Spring Boot. Here we have the exact same application,
setup with the two different versions of Boot - 1.3.3 and 1.2.8.

Enjoy!

## Getting started

Both apps are simple Maven projects and should compile, build and start as long
as Maven and Java 8 is properly set up. In each project, just run:

    mvn spring-boot:run

The app uses an interceptor to log the security context/auth status to the
console, for every request.

Demo-credentials are `user:user` or `admin:admin`.

To run the app **without** the quick-fix workaround, simply flick the switch
and start with the `disable-fix` profile.

    mvn spring-boot:run -Dspring.profiles.active=disable-fix

Have fun!
