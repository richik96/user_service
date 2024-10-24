ALTER TABLE user_address
DROP
FOREIGN KEY FK_USER_ADDRESS_ON_USER;

ALTER TABLE user_name
DROP
FOREIGN KEY FK_USER_NAME_ON_USER;

ALTER TABLE user_address
DROP
FOREIGN KEY FKktrexv3xhyd28dcsqarrbfp08;

ALTER TABLE user
DROP
FOREIGN KEY FKppp1w9cteihck4b20vttv1a4j;

ALTER TABLE user_address
DROP
KEY uc_user_address_user;

DROP TABLE user_geolocation;

ALTER TABLE user
    ADD CONSTRAINT uc_user_address UNIQUE (address_id);

ALTER TABLE user_name
DROP
COLUMN user_id;

ALTER TABLE user
DROP
COLUMN phone;

ALTER TABLE user
DROP
COLUMN password;

DROP TABLE geolocation;

DROP TABLE user_address;