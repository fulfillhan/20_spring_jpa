CREATE DATABASE IF NOT EXISTS SPRING_JPA_EX;
USE SPRING_JPA_EX;

CREATE TABLE PRODUCT (
    PRODUCT_ID 		BIGINT AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_NM 		VARCHAR(100),
	PRICE 			INT,
	DELIVERY_PRICE 	INT,
	ENROLL_DT		TIMESTAMP,
	BRAND_ID		BIGINT
);

CREATE TABLE BRAND (
    BRAND_ID	BIGINT PRIMARY KEY,
    BRAND_NM	VARCHAR(200),
    ENTERED_DT 	TIMESTAMP,
    ACTIVE_YN	CHAR(1)
);


INSERT INTO 
		PRODUCT 
VALUES
	(1 , '삼성전자 2021 노트북 플러스2 15.6' , 598000 , 0 , '2021-01-07' , 1),  
	(2 , '삼성전자 2021 갤럭시북 15.6' , 1208000 , 0 , '2021-02-28' , 1),
	(3 , 'LG전자 10세대 코어i7 윈10탑재 17형 LG 그램 2020년형 17Z90N'  , 2149000 , 0 , '2021-03-07' , 2),
	(4 , 'LG전자 2021그램 360 14' , 1740000 , 0  , '2021-07-08' , 2),
	(5 , 'LG전자 2020 울트라 PC 14' , 477000 , 0 , '2021-10-10' , 2),
	(6 , '2020 맥북 프로 13' , 2129650 , 3000 , '2022-01-01' , 3),
	(7 , 'Apple 2020 맥북 에어 13' , 1489800 , 3000 , '2022-03-03' , 3),
	(8 , '레노버 2021 IdeaPad Slim3 15.6' , 2129650 , 2500 , '2022-07-07' , 4),
	(9 , '기가바이트 2021 Gaming G5 15.6' , 1499000 , 2500 , '2022-11-11' , 5),
	(10 , 'HP 2021 노트북 15s' , 768840 , 2500 , '2022-12-31' , 6);


INSERT INTO 
		BRAND 
VALUES
	(1 , 'samsung' , '2021-01-01' , 'Y'), 
	(2 , 'lg' , '2021-02-01' , 'Y'),  
	(3 , 'apple' , '2021-03-01' , 'Y'),  
	(4 , 'lenovo' , '2021-04-01' , 'N'),  
	(5 , 'gigabyte' , '2021-05-01' , 'N'),  
	(6 , 'hp' , '2021-06-01' , 'N'); 