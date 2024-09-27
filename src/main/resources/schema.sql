-- CREATE TABLE ACCOMMODATION (
--    acmd_no BIGINT AUTO_INCREMENT PRIMARY KEY,
--    name VARCHAR(100) NOT NULL,
--    description VARCHAR(1000) NOT NULL,
--    latitude DOUBLE,
--    longitude DOUBLE,
--    type VARCHAR(20) NOT NULL,
--    is_free_parking BOOLEAN,
--    parking_type VARCHAR(20),
--    location_guide_text VARCHAR(255),
--    image_no BIGINT NOT NULL
-- );


drop table if exists ACCOMMODATION CASCADE;
CREATE TABLE ACCOMMODATION (
   acmd_no BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   description VARCHAR(1000) NOT NULL,
   latitude DOUBLE,
   longitude DOUBLE,
   type VARCHAR(255) NOT NULL,
   is_free_parking BOOLEAN,
   parking_type VARCHAR(255),
   location_guide_text VARCHAR(255)
);

drop table if exists IMAGE CASCADE;
CREATE TABLE IMAGE (
   image_no BIGINT AUTO_INCREMENT PRIMARY KEY,
   image_type VARCHAR(255) NOT NULL,
   path VARCHAR(255) NOT NULL,
   acmd_no BIGINT NOT NULL
-- ,CONSTRAINT fk_accommodation FOREIGN KEY (acmd_no) REFERENCES ACCOMMODATION(acmd_no) ON DELETE CASCADE
);

DROP TABLE IF EXISTS amenity CASCADE;
CREATE TABLE amenity (
    amenity_no BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS accommodation_amenity CASCADE;
CREATE TABLE accommodation_amenity (
    acmd_amenity_no BIGINT AUTO_INCREMENT PRIMARY KEY,
    acmd_no BIGINT NOT NULL,
    amenity_no BIGINT NOT NULL,
    is_available BOOLEAN NOT NULL
);
