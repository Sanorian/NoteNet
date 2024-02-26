CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                    username VARCHAR(50) NOT NULL CHECK(username != ''),
                    email varchar(200) NOT NULL CHECK(email != ''),
                    password VARCHAR(50) NOT NULL CHECK(password != ''));

CREATE TABLE notes (id INT PRIMARY KEY AUTO_INCREMENT,
                    user_id INT REFERENCES users(id) ON DELETE SET NULL ON UPDATE CASCADE,
                    note_text TEXT,
                    update_time DATETIME);