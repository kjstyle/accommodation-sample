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


-- Accommodation table
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

-- Image table
CREATE TABLE IMAGE (
   image_no BIGINT AUTO_INCREMENT PRIMARY KEY,
   image_type VARCHAR(255) NOT NULL,
   path VARCHAR(255) NOT NULL,
   acmd_no BIGINT NOT NULL
-- ,CONSTRAINT fk_accommodation FOREIGN KEY (acmd_no) REFERENCES ACCOMMODATION(acmd_no) ON DELETE CASCADE
);