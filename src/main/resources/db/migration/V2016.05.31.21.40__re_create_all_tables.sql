-- Create question table
DROP TABLE IF EXISTS wee_question;
CREATE TABLE wee_question (
  id BIGINT AUTO_INCREMENT NOT NULL,
  uuid VARCHAR(64) NOT NULL,
  user_id VARCHAR(64) NOT NULL,
  book_id VARCHAR(64) NOT NULL,
  content VARCHAR(512) NOT NULL,
  time_created DATETIME NOT NULL,
  last_modified DATETIME NOT NULL,
  status VARCHAR(16) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (uuid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create answer table
DROP TABLE IF EXISTS wee_answer;
CREATE TABLE wee_answer (
  id BIGINT AUTO_INCREMENT NOT NULL,
  uuid VARCHAR(64) NOT NULL,
  user_id VARCHAR(64) NOT NULL,
  question_id VARCHAR(64) NOT NULL,
  content VARCHAR(2048) NOT NULL,
  time_created DATETIME NOT NULL,
  last_modified DATETIME NOT NULL,
  status VARCHAR(16) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (uuid),
  UNIQUE KEY (user_id, question_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
