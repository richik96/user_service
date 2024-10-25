CREATE TABLE `role`
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    deleted BIT(1) NOT NULL,
    name    VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE token
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    deleted     BIT(1) NOT NULL,
    value       VARCHAR(255) NULL,
    user_id     BIGINT NULL,
    expiry_date datetime NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

CREATE TABLE user
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    deleted         BIT(1) NOT NULL,
    email           VARCHAR(255) NULL,
    username        VARCHAR(255) NULL,
    hashed_password VARCHAR(255) NULL,
    name_id         BIGINT NULL,
    is_email_verify BIT(1) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_name
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    deleted    BIT(1) NOT NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    CONSTRAINT pk_user_name PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_name UNIQUE (name_id);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_NAME FOREIGN KEY (name_id) REFERENCES user_name (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES user (id);