create table question(
    id int auto_increment,
    body varchar(255) NOT NULL,
    category varchar(255) NOT NULL,
    difficulty_level int NOT NULL,
    author varchar(255) NOT NULL
);
