--liquibase formatted sql

--changeset nevermind:001-create-words
CREATE TABLE words(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    original TEXT NOT NULL,
    translation TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
--rollback DROP TABLE words;