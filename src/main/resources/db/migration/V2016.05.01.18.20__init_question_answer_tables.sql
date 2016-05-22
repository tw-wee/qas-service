-- Create question table
DROP TABLE IF EXISTS wee_question;
CREATE TABLE wee_question (
  uuid VARCHAR(64) NOT NULL PRIMARY KEY,
  book VARCHAR(64) NOT NULL,
  content VARCHAR(4096) NOT NULL,
  time_created DATETIME NOT NULL,
  last_modified DATETIME NOT NULL
);

-- Create answer table
DROP TABLE IF EXISTS wee_answer;
CREATE TABLE wee_answer (
  uuid VARCHAR(64) NOT NULL PRIMARY KEY,
  question VARCHAR(64) NOT NULL,
  content VARCHAR(4096) NOT NULL,
  time_created DATETIME NOT NULL,
  last_modified DATETIME NOT NULL
);
