CREATE TABLE ACCOMMODATION (
   acmd_no BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   description VARCHAR(1000) NOT NULL,
   latitude DOUBLE,
   longitude DOUBLE,
   type VARCHAR(20) NOT NULL,
   is_free_parking BOOLEAN,
   parking_type VARCHAR(20),
   location_guide_text VARCHAR(255),
   image_no BIGINT NOT NULL
);