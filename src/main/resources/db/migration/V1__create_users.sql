CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       user_pic VARCHAR(255),
                       user_pass VARCHAR(255) NOT NULL
);

CREATE TABLE items (
                         item_id SERIAL PRIMARY KEY,
                         item_name VARCHAR(100) NOT NULL,
                         item_descr VARCHAR(255),
                         item_pic VARCHAR(255) NOT NULL,
                         user_id INT NOT NULL REFERENCES users(user_id),
                         created_at TIMESTAMP DEFAULT NOW(),
                         item_loc VARCHAR(100) NOT NULL
);

CREATE TABLE discovered_objects (
                        disc_id SERIAL PRIMARY KEY,
                        ob_id INT NOT NULL REFERENCES items(item_id),
                        user_id INT NOT NULL REFERENCES users(user_id),
                        disc_loc VARCHAR(100) NOT NULL,
                        disc_note TEXT,
                        disc_pic VARCHAR(255),
                        discovered_at TIMESTAMP DEFAULT NOW()
);
