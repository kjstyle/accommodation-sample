INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text, image_no) VALUES ('서울 호텔', '서울 중심에 위치한 5성급 호텔로, 럭셔리한 객실과 다양한 편의 시설을 제공합니다.', 37.5665, 126.9780, 'HOTEL', 1, 'FIELD', '서울역에서 도보 5분 거리', 1);
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text, image_no) VALUES ('부산 모텔', '부산 해운대 근처에 위치한 모텔로, 합리적인 가격에 숙박을 제공합니다.', 35.1587, 129.1603, 'MOTEL', 1, 'MACHINE', '해운대역에서 도보 10분 거리', 2);
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text, image_no) VALUES ('제주 호텔', '제주 바다 전망을 자랑하는 호텔로, 여유로운 휴식을 위한 최적의 장소입니다.', 33.4996, 126.5312, 'HOTEL', 1, 'ETC', '제주공항에서 차로 15분 거리', 3);


/*
    create table accommodation (
        is_free_parking boolean not null,
        latitude float(53) not null,
        longitude float(53) not null,
        acmd_no bigint not null,
        image_no bigint not null,
        name varchar(100) not null,
        description varchar(1000) not null,
        location_guide_text varchar(255),
        parking_type enum ('ETC','FIELD','MACHINE'),
        type enum ('HOTEL','MOTEL') not null,
        primary key (acmd_no)
    )
*/