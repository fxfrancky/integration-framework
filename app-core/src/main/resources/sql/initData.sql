/*
 * Copyright (c) 2021.  By François Xavier OWONA
 */

DELETE FROM public.user;

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('fxfrancky', 'fxfrancky100','francky@yahoo.com' );

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('ritamkn', 'ritamkn101','ritamkn@yahoo.com' );

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('evamkn', 'evamkn102','evamkn102@yahoo.com' );

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('stevemkn', 'stevemkn103','stevemkn@yahoo.com' );

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('julesbene', 'julesbene104','julesbene@yahoo.com' );

INSERT INTO public.user(@Param("login")String login, @Param("password")String password, @Param("email")String email);
VALUES ('jordanowona', 'jordanowona105','jordanowona@yahoo.com' );