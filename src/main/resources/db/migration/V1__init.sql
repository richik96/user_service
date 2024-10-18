CREATE TABLE user
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NULL,
    updated_at     datetime NULL,
    email          VARCHAR(255) NULL,
    username       VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    name_id        BIGINT NULL,
    geolocation_id BIGINT NULL,
    address_id     BIGINT NULL,
    phone          VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE user_address
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    updated_at      datetime NULL,
    city            VARCHAR(255) NULL,
    street          VARCHAR(255) NULL,
    number          BIGINT NULL,
    zipcode         VARCHAR(255) NULL,
    geo_location_id BIGINT NULL,
    user_id         BIGINT NULL,
    CONSTRAINT pk_user_address PRIMARY KEY (id)
);

CREATE TABLE user_geolocation
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    latitude DOUBLE NULL,
    longitude DOUBLE NULL,
    address_id BIGINT NULL,
    user_id    BIGINT NULL,
    CONSTRAINT pk_user_geolocation PRIMARY KEY (id)
);

CREATE TABLE user_name
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NULL,
    updated_at datetime NULL,
    first_name VARCHAR(255) NULL,
    last_name  VARCHAR(255) NULL,
    user_id    BIGINT NULL,
    CONSTRAINT pk_user_name PRIMARY KEY (id)
);

ALTER TABLE user_address
    ADD CONSTRAINT FK_USER_ADDRESS_ON_GEO_LOCATION FOREIGN KEY (geo_location_id) REFERENCES user_geolocation (id);

ALTER TABLE user_address
    ADD CONSTRAINT FK_USER_ADDRESS_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user_geolocation
    ADD CONSTRAINT FK_USER_GEOLOCATION_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES user_address (id);

ALTER TABLE user_geolocation
    ADD CONSTRAINT FK_USER_GEOLOCATION_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user_name
    ADD CONSTRAINT FK_USER_NAME_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES user_address (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_GEOLOCATION FOREIGN KEY (geolocation_id) REFERENCES user_geolocation (id);

ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_NAME FOREIGN KEY (name_id) REFERENCES user_name (id);