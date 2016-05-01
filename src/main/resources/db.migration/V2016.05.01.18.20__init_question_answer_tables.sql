-- Create question table
DROP TABLE IF EXISTS wee_question;
CREATE TABLE wee_question (
  uuid VARCHAR(64) NOT NULL,
  book VARCHAR(64) NOT NULL,
  content VARCHAR(MAX) NOT NULL,
  time_created DATE NOT NULL,
  last_modified DATE NOT NULL,
  PRIMARY KEY ('uuid')
);

-- Create answer table
DROP TABLE IF EXISTS wee_answer;
CREATE TABLE wee_answer (
  uuid VARCHAR(64) NOT NULL,
  question VARCHAR(64) NOT NULL,
  content VARCHAR(MAX) NOT NULL,
  time_created DATE NOT NULL,
  last_modified DATE NOT NULL,
  PRIMARY KEY ('uuid')
);
