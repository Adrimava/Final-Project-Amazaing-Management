DROP SCHEMA IF EXISTS player;
CREATE SCHEMA player;
USE player;

CREATE TABLE player(
	player_id BIGINT NOT NULL AUTO_INCREMENT,
    player_name VARCHAR(255) NOT NULL,
    money DECIMAL,
    photo VARCHAR(255),
    PRIMARY KEY(player_id)
);

INSERT INTO player(player_name, money, photo) VALUES
	('Richie Mc.Money', 1000000, 'noPhoto'),
    ('Poor Boy', 100, 'noPhoto')
;

CREATE TABLE player_companies(
	company_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY (company_id),
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

INSERT INTO player_companies(company_id, player_id) VALUES
	(1, 1),
    (2, 1),
    (3, 1),
    (4, 2)
;

CREATE TABLE player_employees(
	employee_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

INSERT INTO player_employees(employee_id, player_id) VALUES
	(1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 2)
;