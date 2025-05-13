CREATE TABLE `Schedule`
(
    `schedule_id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '일정_ID',
    `todo`        VARCHAR(100) NOT NULL COMMENT '할일',
    `create_name` VARCHAR(100) NOT NULL COMMENT '작성자명',
    `password`    VARCHAR(100) NOT NULL COMMENT '비밀번호',
    `create_date` DATE         NOT NULL COMMENT '작성일',
    `update_date` DATE         NOT NULL COMMENT '수정일'
);