
-- DROPING EVERY EXISTING TABLE BEFORE CREATION
DROP TABLE public.user;
DROP TABLE public.role;
DROP TABLE public.user_role;


CREATE TABLE public.user
(
    id_user SERIAL PRIMARY KEY,
    login text NOT NULL,
    password text  NOT NULL,
    email text
);

CREATE TABLE public.role
(
    id_role SERIAL PRIMARY KEY,
    name text NOT NULL,
    description text
);


CREATE TABLE public.user_role
(
    id_user SERIAL,
    id_role SERIAL,

    PRIMARY KEY(id_user, id_role)
)

