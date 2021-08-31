CREATE TABLE task (
    id int(11) NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    description varchar(512) NOT NULL,
    createdDate timestamp NOT NULL,
    completedDate timestamp,
    completed bit NOT NULL
);