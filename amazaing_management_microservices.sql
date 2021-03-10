DROP SCHEMA IF EXISTS business_model;
CREATE SCHEMA business_model;
USE business_model;

CREATE TABLE business_model(
	model_id BIGINT NOT NULL,
    model_name VARCHAR(255),
    photo VARCHAR(255),
    purchase_price DECIMAL,
    max_employees INT,
    average_revenue DECIMAL,
    daily_costs DECIMAL,
    employee_salary DECIMAL,
    PRIMARY KEY(model_id)
);

INSERT INTO business_model(model_id, model_name, purchase_price, max_employees, average_revenue, daily_costs, employee_salary) VALUES
	(1, 'Lemonade Stand', 600, 2, 100, 10, 20),
    (2, 'Kiosk', 1000, 1, 100, 40, 30),
    (3, 'Khlav Kalash Cart', 450, 1, 50, 10, 20)
;

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