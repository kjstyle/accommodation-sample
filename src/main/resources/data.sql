INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text) VALUES ('서울 호텔', '서울 중심에 위치한 5성급 호텔로, 럭셔리한 객실과 다양한 편의 시설을 제공합니다.', 37.5665, 126.9780, 'HOTEL', 1, 'FIELD', '서울역에서 도보 5분 거리');
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text) VALUES ('부산 모텔', '부산 해운대 근처에 위치한 모텔로, 합리적인 가격에 숙박을 제공합니다.', 35.1587, 129.1603, 'MOTEL', 1, 'MACHINE', '해운대역에서 도보 10분 거리');
INSERT INTO ACCOMMODATION (name, description, latitude, longitude, type, is_free_parking, parking_type, location_guide_text) VALUES ('제주 호텔', '제주 바다 전망을 자랑하는 호텔로, 여유로운 휴식을 위한 최적의 장소입니다.', 33.4996, 126.5312, 'HOTEL', 1, 'ETC', '제주공항에서 차로 15분 거리');

INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/accommodation1/main.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/accommodation1/thumbnail.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/accommodation1/detail.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/accommodation1/location.jpg', 1);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('MAIN', 'images/accommodation1/main.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('THUMBNAIL', 'images/accommodation1/thumbnail.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('DETAIL', 'images/accommodation1/detail.jpg', 2);
INSERT INTO IMAGE (image_type, path, acmd_no) VALUES ('LOCATION', 'images/accommodation1/location.jpg', 2);

INSERT INTO amenity (description, name) VALUES ('에어컨이 설치되어 있습니다.', '에어컨');
INSERT INTO amenity (description, name) VALUES ('냉장고가 구비되어 있습니다.', '냉장고');
INSERT INTO amenity (description, name) VALUES ('욕조가 있습니다.', '욕조');
INSERT INTO amenity (description, name) VALUES ('무료 Wi-Fi가 제공됩니다.', '무료 Wi-Fi');
INSERT INTO amenity (description, name) VALUES ('주차장이 마련되어 있습니다.', '주차장');
INSERT INTO amenity (description, name) VALUES ('온돌방입니다.', '온돌방');
INSERT INTO amenity (description, name) VALUES ('해변까지 도보로 이동할 수 있습니다.', '해변 접근');


INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 1);  -- 비산호텔 - 에어컨
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 2);  -- 비산호텔 - 냉장고
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 1, 3);  -- 비산호텔 - 욕조
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 4);  -- 안양 콘도 - 무료 Wi-Fi
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 2, 5);  -- 안양 콘도 - 주차장
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 6);  -- 시내 게스트하우스 - 온돌방
INSERT INTO accommodation_amenity (is_available, acmd_no, amenity_no) VALUES (TRUE, 3, 7);  -- 시내 게스트하우스 - 해변 접근

INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('온돌방', '서울 호텔의 전통 온돌방', 1, 2, '싱글 침대 2개', 2, '14:00', '12:00', '프로모션 없음', 1);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('오션뷰', '서울 호텔의 멋진 오션뷰 객실', 1, 2, '퀸 침대 1개', 1, '14:00', '12:00', '프로모션 없음', 1);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('마운틴뷰', '서울 호텔의 산 전망 객실', 2, 4, '더블 침대 2개', 2, '14:00', '12:00', '프로모션 없음', 1);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('패밀리룸', '서울 호텔의 가족 단위 투숙객을 위한 객실', 3, 6, '더블 침대 1개, 싱글 침대 2개', 3, '14:00', '12:00', '프로모션 없음', 1);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('스위트룸', '서울 호텔의 최고급 스위트룸', 2, 4, '킹 사이즈 침대 1개', 1, '14:00', '12:00', '프로모션 있음', 1);

INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('온돌방', '부산 모텔의 전통 온돌방', 1, 2, '싱글 침대 2개', 2, '15:00', '11:00', '프로모션 없음', 2);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('오션뷰', '부산 모텔의 멋진 오션뷰 객실', 1, 2, '퀸 침대 1개', 1, '15:00', '11:00', '프로모션 없음', 2);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('마운틴뷰', '부산 모텔의 산 전망 객실', 2, 4, '더블 침대 2개', 2, '15:00', '11:00', '프로모션 없음', 2);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('패밀리룸', '부산 모텔의 가족 단위 투숙객을 위한 객실', 3, 6, '더블 침대 1개, 싱글 침대 2개', 3, '15:00', '11:00', '프로모션 없음', 2);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('스위트룸', '부산 모텔의 최고급 스위트룸', 2, 4, '킹 사이즈 침대 1개', 1, '15:00', '11:00', '프로모션 있음', 2);

INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('온돌방', '제주 호텔의 전통 온돌방', 1, 2, '싱글 침대 2개', 2, '16:00', '10:00', '프로모션 없음', 3);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('오션뷰', '제주 호텔의 멋진 오션뷰 객실', 1, 2, '퀸 침대 1개', 1, '16:00', '10:00', '프로모션 없음', 3);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('마운틴뷰', '제주 호텔의 산 전망 객실', 2, 4, '더블 침대 2개', 2, '16:00', '10:00', '프로모션 없음', 3);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('패밀리룸', '제주 호텔의 가족 단위 투숙객을 위한 객실', 3, 6, '더블 침대 1개, 싱글 침대 2개', 3, '16:00', '10:00', '프로모션 없음', 3);
INSERT INTO ROOM (room_name, description, min_occupancy, max_occupancy, bed_type_description, bed_count, check_in_time, check_out_time, promotion_text, acmd_no) VALUES ('스위트룸', '제주 호텔의 최고급 스위트룸', 2, 4, '킹 사이즈 침대 1개', 1, '16:00', '10:00', '프로모션 있음', 3);
