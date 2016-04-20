# No Auth For You! #

A small fixture-project that examplifies the issues [#1048][1] and [#5638][2]
in Spring Boot (with Security) among others.

  [1]: https://github.com/spring-projects/spring-boot/issues/1048  
  [2]: https://github.com/spring-projects/spring-boot/issues/5638

## Getting started

This is a simple Maven project, should compile, build and start with Java 8.

    mvn clean spring-boot:run

The app uses an interceptor to log the security context/auth status to the
console, for every request. Demo-credentials are `user:user` or `admin:admin`.

To try out a quick-fix, described in [#5638][2], simply flick the switch and
start with the `fix` profile enabled.

    mvn spring-boot:run -Dspring.profiles.active=fix

Have fun!
