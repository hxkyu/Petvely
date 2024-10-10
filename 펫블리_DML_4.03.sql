-- Member 테이블에 회원 추가
INSERT INTO petvely.Member (me_id, me_pw, me_nickname, me_email, me_authority, me_phone, me_ms_status)
VALUES 
('user01', 'password111', 'nickname01', 'user01@example.com', 'user', '01011111111', 'active'), 
('user02', 'password222', 'nickname02', 'user02@example.com', 'user', '01022222222', 'active'), 
('user03', 'password333', 'nickname03', 'user03@example.com', 'user', '01033333333', 'active'), 
('user04', 'password444', 'nickname04', 'user04@example.com', 'user', '01044444444', 'active'), 
('user05', 'password555', 'nickname05', 'user05@example.com', 'user', '01055555555', 'active');
-- FacilityShare 테이블에 시설 정보 추가
INSERT INTO FacilityShare (fs_name, fs_grade, fs_reviewCount, fs_reportCount, fs_fst_type)
VALUES ('Pet Park', 5, 10, 0, 'Park');

-- Animal 테이블에 반려동물 정보 추가
INSERT INTO Animal (ani_num, ani_name, ani_age, ani_gender, ani_birth, ani_weight, ani_neutralization, ani_at_type, ani_me_num)
VALUES ('A001', 'Max', 2, 'M', '2022-01-01', 5.5, TRUE, 'Dog', 1);

-- 새로운 게시글 추가 (user01이 작성)
INSERT INTO petvely.Post (po_title, po_content, po_date, po_co_num, po_hidden, po_viewCount, po_recommendCount, po_reportCount, po_notice, po_me_num, po_delete)
VALUES 
('고양이 키우면 게추', 
'히히',
NOW(), 
'1', 
0, 
0, 
0,
0, 
'0', 
0,
(SELECT me_num FROM petvely.Member WHERE me_id = 'user01'));

# 관리자가 '강아지', '고양이', '도마뱀', '고슴도치' 커뮤니티를 추가했을 때 필요한 쿼리
INSERT INTO COMMUNITY(CO_NAME) VALUES('강아지');
INSERT INTO COMMUNITY(CO_NAME) VALUES('고양이');
INSERT INTO COMMUNITY(CO_NAME) VALUES('도마뱀');
INSERT INTO COMMUNITY(CO_NAME) VALUES('고슴도치');


-- 모든 회원 정보를 조회
SELECT * FROM Member;

-- 특정 회원의 이메일과 닉네임 조회
SELECT me_email, me_nickname FROM Member WHERE me_id = 'user01';

-- 시설 정보에서 리뷰가 5개 이상인 시설만 조회
SELECT fs_name, fs_grade, fs_reviewCount FROM FacilityShare WHERE fs_reviewCount >= 5;

-- 특정 회원의 닉네임을 수정
UPDATE Member
SET me_nickname = 'new_nickname01'
WHERE me_id = 'user01';

-- Animal 테이블에서 반려동물의 무게를 수정
UPDATE Animal
SET ani_weight = 6.0
WHERE ani_num = 'A001';

-- 특정 회원 삭제
DELETE FROM Member WHERE me_id = 'user01';

-- 특정 반려동물 정보 삭제
DELETE FROM Animal WHERE ani_num = 'A001';


INSERT INTO WALKMATEPOST ( PO_NUM, WM_DATE, WM_TIME )
	VALUES ( 4, '2020-10-19', '19:30');
    
-- auto_increment값 초기화
ALTER TABLE walkmatepost AUTO_INCREMENT = 5;    
ALTER TABLE post AUTO_INCREMENT = 5;    

-- po_me_num을 me_id로 보여지게
SELECT p.po_num, p.po_title, p.po_content, p.po_date, p.po_co_num, m.me_id
FROM Post p
JOIN Member m ON p.po_me_num = m.me_num;