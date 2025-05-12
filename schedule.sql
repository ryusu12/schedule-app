CREATE TABLE `Schedule`
(
    `schedule_id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정_ID',
    `todo`        VARCHAR(100) NOT NULL COMMENT '할일',
    `create_name` VARCHAR(100) NOT NULL COMMENT '작성자명',
    `password`    VARCHAR(100) NOT NULL COMMENT '비밀번호',
    `create_date` DATE         NOT NULL COMMENT '작성일',
    `update_date` DATE         NOT NULL COMMENT '수정일'
);

CREATE TABLE `User`
(
    `user_id`     BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '작성자_ID',
    `name`        VARCHAR(100) NOT NULL COMMENT '이름',
    `email`       VARCHAR(100) NOT NULL COMMENT '이메일',
    `create_date` DATE         NOT NULL COMMENT '작성일',
    `update_date` DATE         NOT NULL COMMENT '수정일'
);

ALTER TABLE `Schedule`
    ADD COLUMN `user_id` BIGINT NOT NULL COMMENT '작성자_ID';

ALTER TABLE `Schedule`
    ADD CONSTRAINT `FK_User_TO_Schedule_1`
        FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`);