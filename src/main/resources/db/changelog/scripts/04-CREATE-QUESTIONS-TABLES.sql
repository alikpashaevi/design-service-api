
CREATE SEQUENCE question_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE answer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE question (
  id BIGINT PRIMARY KEY,
  question TEXT NOT NULL,
  type VARCHAR(50) NOT NULL
);

CREATE TABLE answer (
    id BIGINT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    answerValue TEXT,
    question_id BIGINT,
    CONSTRAINT fk_answer_question FOREIGN KEY (question_id)
        REFERENCES question (id)
        ON DELETE CASCADE
);
