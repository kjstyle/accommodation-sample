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

DROP TABLE IF EXISTS ROOM CASCADE;

CREATE TABLE ROOM (
    room_no BIGINT AUTO_INCREMENT PRIMARY KEY,
    room_name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    min_occupancy INT NOT NULL,
    max_occupancy INT NOT NULL,
    bed_type_description VARCHAR(255) NOT NULL,
    bed_count INT NOT NULL,
    check_in_time TIME NOT NULL,
    check_out_time TIME NOT NULL,
    promotion_text VARCHAR(255),
    acmd_no BIGINT NOT NULL
);
