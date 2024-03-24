CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                    email varchar(200) NOT NULL CHECK(email != ''),
                    password VARCHAR(50) NOT NULL CHECK(password != ''));

CREATE TABLE notes (id INT PRIMARY KEY AUTO_INCREMENT,
                    user_id INT REFERENCES users(id) ON DELETE SET NULL ON UPDATE CASCADE,
                    type VARCHAR(8)
                    note_text TEXT,
                    update_time DATETIME);