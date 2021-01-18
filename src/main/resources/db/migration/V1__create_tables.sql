CREATE TABLE likes (
    id INTEGER NOT NULL AUTO_INCREMENT,
    date datetime(6),
    publication_id INTEGER,
    user_id INTEGER,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE publications (
    id INTEGER NOT NULL AUTO_INCREMENT,
    date DATETIME(6),
    description VARCHAR(255),
    image VARCHAR(255),
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE publications_author (
    id INTEGER NOT NULL AUTO_INCREMENT,
    publication_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE subscribers (
    id INTEGER NOT NULL AUTO_INCREMENT,
    subscriber_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE subscriptions (
    id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    subscriber_id INTEGER NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE users (
    id INTEGER NOT NULL AUTO_INCREMENT,
    date DATETIME(6),
    email VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE comments (
    id INTEGER NOT NULL AUTO_INCREMENT,
    text VARCHAR(255),
    user_id INTEGER,
    PRIMARY KEY (id)
) engine=InnoDB;

ALTER TABLE likes ADD CONSTRAINT FKpyogbn36rsoh4hp231acgeq1i FOREIGN KEY (publication_id) REFERENCES publications (id);
ALTER TABLE likes ADD CONSTRAINT FKnvx9seeqqyy71bij291pwiwrg FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE publications_author ADD CONSTRAINT FK1windgijv7518jswtceswymy2 FOREIGN KEY (author_id) REFERENCES users (id);
ALTER TABLE publications_author ADD CONSTRAINT FK4tgpnj5xi8tdrjmdqj05yyre5 FOREIGN KEY (publication_id) REFERENCES publications (id);
ALTER TABLE subscribers ADD CONSTRAINT FKll9lhik8xj3ep6ahtdt7me7pu FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE subscribers ADD CONSTRAINT FKh0b65sm1qah4q8iy69k8aaxij FOREIGN KEY (subscriber_id) REFERENCES users (id);
ALTER TABLE subscriptions ADD CONSTRAINT FKoodc4352epkjrvxx79odlxbji FOREIGN KEY (subscriber_id) REFERENCES users (id);
ALTER TABLE subscriptions ADD CONSTRAINT FKhro52ohfqfbay9774bev0qinr FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE comments ADD CONSTRAINT FK8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES users (id);
