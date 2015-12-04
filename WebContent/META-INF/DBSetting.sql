/* 계정 생성 (in 관리자 계정)*/
-- USER SQL
CREATE USER camtudy IDENTIFIED BY 1004 DEFAULT TABLESPACE "USERS" TEMPORARY TABLESPACE "TEMP";

-- QUOTAS
    
-- ROLES
GRANT "CONNECT" TO camtudy ;
GRANT "RESOURCE" TO camtudy ;
ALTER USER camtudy DEFAULT ROLE "CONNECT","RESOURCE";

-- SYSTEM PRIVILEGES


/* DB Table 및 Sequence 생성(in camtudy 계정) */

/* study */
CREATE TABLE study (
	no_study NUMBER NOT NULL, /* no_study */
	no_mem NUMBER NOT NULL, /* 회원번호 */
	name_study VARCHAR2(50) NOT NULL, /* name_study */
	manager_study NUMBER NOT NULL, /* manager_study */
	category_study VARCHAR2(50) NOT NULL, /* category_study */
	num_mem_study NUMBER NOT NULL, /* num_mem_study */
	date_start_study DATE NOT NULL, /* date_start_study */
	date_end_study DATE NOT NULL, /* date_end_study */
	time_start_study DATE NOT NULL, /* time_start_study */
	time_end_study DATE NOT NULL, /* time_end_study */
	lateness_panalty_study NUMBER NOT NULL, /* lateness_panalty_study */
	latness_time_study NUMBER NOT NULL, /* latness_time_study */
	absence_panalty_study NUMBER NOT NULL, /* absence_panalty_study */
	notice_study VARCHAR2(300) /* notice_study */
);

CREATE UNIQUE INDEX PK_study
	ON study (
		no_study ASC
	);

ALTER TABLE study
	ADD
		CONSTRAINT PK_study
		PRIMARY KEY (
			no_study
		);

/* category */
CREATE TABLE category (
	no_category NUMBER NOT NULL, /* no_category */
	name_category VARCHAR2(50) NOT NULL /* name_category */
);

CREATE UNIQUE INDEX PK_category
	ON category (
		no_category ASC
	);

ALTER TABLE category
	ADD
		CONSTRAINT PK_category
		PRIMARY KEY (
			no_category
		);

/* list */
CREATE TABLE list (
	no_study NUMBER NOT NULL, /* no_study */
	no_mem NUMBER NOT NULL, /* 회원번호 */
	point_list NUMBER NOT NULL, /* point_list */
	acc_time_list NUMBER NOT NULL /* acc_time_list */
);

CREATE UNIQUE INDEX PK_list
	ON list (
		no_study ASC,
		no_mem ASC
	);

ALTER TABLE list
	ADD
		CONSTRAINT PK_list
		PRIMARY KEY (
			no_study,
			no_mem
		);

/* result */
CREATE TABLE result (
	num_exam NUMBER NOT NULL, /* 시험번호 */
	no_mem NUMBER NOT NULL, /* 회원번호 */
	score_exam NUMBER NOT NULL, /* 시험점수 */
	date_exam DATE NOT NULL /* 시험날짜 */
);

CREATE UNIQUE INDEX PK_result
	ON result (
		num_exam ASC,
		no_mem ASC
	);

ALTER TABLE result
	ADD
		CONSTRAINT PK_result
		PRIMARY KEY (
			num_exam,
			no_mem
		);

/* member */
CREATE TABLE member (
	no_mem NUMBER NOT NULL, /* 회원번호 */
	id_mem VARCHAR2(200) NOT NULL, /* 회원ID */
	pwd_mem VARCHAR2(200) NOT NULL, /* 회원PWD */
	name_mem VARCHAR2(20) NOT NULL, /* 회원이름 */
	email_mem VARCHAR2(200) NOT NULL, /* 회원이메일 */
	intro_mem VARCHAR2(200) NOT NULL, /* 회원자기소개 */
	acc_time_mem DATE NOT NULL /* 회원누적시간 */
);

CREATE UNIQUE INDEX PK_member
	ON member (
		no_mem ASC
	);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			no_mem
		);

/* question */
CREATE TABLE question (
	num_exam NUMBER NOT NULL, /* 시험번호 */
	num_question NUMBER NOT NULL, /* 문제번호 */
	type_question VARCHAR2(20) NOT NULL, /* 문제타입 */
	content_question VARCHAR2(4000) NOT NULL, /* 문제 */
	answer_list_question VARCHAR2(4000) NOT NULL, /* 보기 */
	answer_question VARCHAR2(4000) NOT NULL /* 답안결과 */
);

CREATE UNIQUE INDEX PK_question
	ON question (
		num_exam ASC,
		num_question ASC
	);

ALTER TABLE question
	ADD
		CONSTRAINT PK_question
		PRIMARY KEY (
			num_exam,
			num_question
		);

/* exam */
CREATE TABLE exam (
	num_exam NUMBER NOT NULL, /* 시험번호 */
	title_exam VARCHAR2(200) NOT NULL, /* 시험제목 */
	id_mem VARCHAR2(200) NOT NULL, /* 회원ID */
	category_exam VARCHAR2(200) NOT NULL, /* 카테고리 */
	view_count_exam NUMBER NOT NULL, /* 조회수 */
	count_exam NUMBER NOT NULL, /* 시험조회수 */
	recomand_count_exam NUMBER NOT NULL, /* 시험추천수 */
	date_exam DATE NOT NULL /* 시험등록일 */
);

CREATE UNIQUE INDEX PK_exam
	ON exam (
		num_exam ASC
	);

ALTER TABLE exam
	ADD
		CONSTRAINT PK_exam
		PRIMARY KEY (
			num_exam
		);

/* admin */
CREATE TABLE admin (
	id_admin VARCHAR2(200) NOT NULL, /* Admin ID */
	pwd_admin VARCHAR2(200) NOT NULL /* 회원PWD */
);

/* free */
CREATE TABLE free (
	NO_FREE NUMBER NOT NULL, /* NO_FREE */
	TITLE_FREE VARCHAR2(100) NOT NULL, /* TITLE_FREE */
	WRITER_FREE VARCHAR2(20) NOT NULL, /* WRITER_FREE */
	CONTENT_FREE VARCHAR2(2000) NOT NULL, /* CONTENT_FREE */
	HIT_FREE NUMBER NOT NULL, /* HIT_FREE */
	REGDATE_FREE DATE, /* REGDATE_FREE */
	DELETED_FREE NUMBER NOT NULL, /* DELETED_FREE */
	GROUPNO_FREE NUMBER NOT NULL, /* GROUPNO_FREE */
	STEP_FREE NUMBER NOT NULL, /* STEP_FREE */
	DEPTH_FREE NUMBER NOT NULL /* DEPTH_FREE */
);

CREATE UNIQUE INDEX PK_free
	ON free (
		NO_FREE ASC
	);

ALTER TABLE free
	ADD
		CONSTRAINT PK_free
		PRIMARY KEY (
			NO_FREE
		);

/* recruit */
CREATE TABLE recruit (
	NO_RECRUIT NUMBER NOT NULL, /* NO_RECRUIT */
	TITLE_RECRUIT VARCHAR2(100) NOT NULL, /* TITLE_RECRUIT */
	WRITER_RECRUIT VARCHAR2(20) NOT NULL, /* WRITER_RECRUIT */
	CONTENT_RECRUIT VARCHAR2(2000) NOT NULL, /* CONTENT_RECRUIT */
	HIT_RECRUIT NUMBER NOT NULL, /* HIT_RECRUIT */
	REGDATE_RECRUIT DATE, /* REGDATE_RECRUIT */
	DELETED_RECRUIT NUMBER NOT NULL, /* DELETED_RECRUIT */
	GROUPNO_RECRUIT NUMBER NOT NULL, /* GROUPNO_RECRUIT */
	STEP_RECRUIT NUMBER NOT NULL, /* STEP_RECRUIT */
	DEPTH_RECRUIT NUMBER NOT NULL /* DEPTH_RECRUIT */
);

CREATE UNIQUE INDEX PK_recruit
	ON recruit (
		NO_RECRUIT ASC
	);

ALTER TABLE recruit
	ADD
		CONSTRAINT PK_recruit
		PRIMARY KEY (
			NO_RECRUIT
		);

/* qna */
CREATE TABLE qna (
	NO_QNA NUMBER NOT NULL, /* NO_QNA */
	TITLE_QNA VARCHAR2(100) NOT NULL, /* TITLE_QNA */
	WRITER_QNA VARCHAR2(20) NOT NULL, /* WRITER_QNA */
	CONTENT_QNA VARCHAR2(2000) NOT NULL, /* CONTENT_QNA */
	HIT_QNA NUMBER NOT NULL, /* HIT_QNA */
	REGDATE_QNA DATE, /* REGDATE_QNA */
	DELETED_QNA NUMBER NOT NULL, /* DELETED_QNA */
	GROUPNO_QNA NUMBER NOT NULL, /* GROUPNO_QNA */
	STEP_QNA NUMBER NOT NULL, /* STEP_QNA */
	DEPTH_QNA NUMBER NOT NULL /* DEPTH_QNA */
);

CREATE UNIQUE INDEX PK_qna
	ON qna (
		NO_QNA ASC
	);

ALTER TABLE qna
	ADD
		CONSTRAINT PK_qna
		PRIMARY KEY (
			NO_QNA
		);

ALTER TABLE study
	ADD
		CONSTRAINT FK_member_TO_study
		FOREIGN KEY (
			no_mem
		)
		REFERENCES member (
			no_mem
		);

ALTER TABLE list
	ADD
		CONSTRAINT FK_member_TO_list
		FOREIGN KEY (
			no_mem
		)
		REFERENCES member (
			no_mem
		);

ALTER TABLE list
	ADD
		CONSTRAINT FK_study_TO_list
		FOREIGN KEY (
			no_study
		)
		REFERENCES study (
			no_study
		);

ALTER TABLE result
	ADD
		CONSTRAINT FK_member_TO_result
		FOREIGN KEY (
			no_mem
		)
		REFERENCES member (
			no_mem
		);

ALTER TABLE result
	ADD
		CONSTRAINT FK_exam_TO_result
		FOREIGN KEY (
			num_exam
		)
		REFERENCES exam (
			num_exam
		);

ALTER TABLE question
	ADD
		CONSTRAINT FK_exam_TO_question
		FOREIGN KEY (
			num_exam
		)
		REFERENCES exam (
			num_exam
		);
		
/*Sequence 생성*/
CREATE SEQUENCE  seq_no_study  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_no_mem  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_num_exam  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_no_category  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_NO_FREE  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_NO_RECRUIT  START WITH 1  INCREMENT BY 1;
CREATE SEQUENCE  seq_NO_QNA  START WITH 1  INCREMENT BY 1;		

/*Amdin 계정 생성: ID -> admin , pwd -> 1004 */
insert into admin values ('admin','1004');   

/*Category data 생성*/
insert into category values (1,'고시');
insert into category values (2,'공무원');
insert into category values (3,'취업');
insert into category values (4,'자격증');
insert into category values (5,'어학');
insert into category values (6,'대입');
insert into category values (7,'기타');

/* Test member 생성*/
insert into member values(0,'camtudy','1004','고시생','test@naver.com','열공합시다');

/*필수*/
commit;