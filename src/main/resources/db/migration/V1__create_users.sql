CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       user_pic VARCHAR(255),
                       user_pass VARCHAR(255) NOT NULL
);

CREATE TABLE objects (
                         ob_id SERIAL PRIMARY KEY,
                         ob_name VARCHAR(100) NOT NULL,
                         ob_description VARCHAR(255),
                         ob_pic VARCHAR(255) NOT NULL,
                         user_id INT NOT NULL REFERENCES users(user_id),
                         created_at TIMESTAMP DEFAULT NOW(),
                         city VARCHAR(100) NOT NULL
);

CREATE TABLE discovered_objects (
                        discover_id SERIAL PRIMARY KEY,
                        ob_id INT NOT NULL REFERENCES objects(ob_id),
                        user_id INT NOT NULL REFERENCES users(user_id),
                        city VARCHAR(100) NOT NULL,
                        note TEXT,
                        pic VARCHAR(255),
                        discovered_at TIMESTAMP DEFAULT NOW()
);
