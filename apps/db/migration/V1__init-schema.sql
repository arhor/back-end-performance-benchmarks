-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE IF NOT EXISTS "users"
(
    "id"                BIGSERIAL     NOT NULL PRIMARY KEY,
    "username"          VARCHAR(128)  NOT NULL UNIQUE,
    "password"          VARCHAR(1024) NULL,
    "version"           BIGINT        NOT NULL,
    "created_date_time" TIMESTAMP     NOT NULL,
    "updated_date_time" TIMESTAMP     NULL
) WITH (OIDS = FALSE);

CREATE OR REPLACE FUNCTION FIND_ALL_USERS() RETURNS SETOF "users" AS
$$
BEGIN
    PERFORM PG_SLEEP(0.5);
    RETURN QUERY SELECT u.id
                      , u.username
                      , u.password
                      , u.version
                      , u.created_date_time
                      , u.updated_date_time
                 FROM users u;
END
$$ LANGUAGE plpgsql;
