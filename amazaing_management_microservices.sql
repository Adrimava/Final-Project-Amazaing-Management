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
	('Richie Mc.Money', 1000000, 'human'),
    ('Poor Boy', 100, 'human')
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

DROP SCHEMA IF EXISTS company;
CREATE SCHEMA company;
USE company;

CREATE TABLE company(
	company_id BIGINT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255),
    revenue DECIMAL,
    maintenance DECIMAL,
    employees_number INT,
    accident_risk_index DECIMAL,
    business_model_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY(company_id)
);

INSERT INTO company(company_name, revenue, maintenance, employees_number, accident_risk_index, business_model_id, player_id) VALUES
	('The Great Stand', 75, 25, 1, 25, 1, 1),
    ('Lemon Party', 80, 35, 2, 40, 1, 1),
    ('Sneed Feed and Seed', 90, 40, 1, 15, 2, 1),
    ('Just Khlav Kalash', 40, 10, 1, 5, 3, 2)
;

CREATE TABLE company_employees(
	employee_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);

INSERT INTO company_employees(employee_id, company_id) VALUES
	(1, 1),
    (2, 1),
    (3, 2),
    (4, 3),
    (5, 4)
;

DROP SCHEMA IF EXISTS employee;
CREATE SCHEMA employee;
USE employee;

CREATE TABLE employee(
	employee_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_name VARCHAR(255),
    photo VARCHAR(255),
    productivity DECIMAL,
    clumsiness DECIMAL,
    company_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY(employee_id)    
);

INSERT INTO employee(employee_name, photo, productivity, clumsiness, company_id, player_id) VALUES
	('Sara Penguin', 'noPhoto', 60, 15, 1, 1),
    ('Celia Penguin', 'noPhoto', 50, 10, 1, 1),
    ('Lemoncio Sour', 'noPhoto', 35, 20, 2, 1),
    ('Sneed Fisher', 'noPhoto', 40, 19, 3, 1),
    ('Khlav Kalash Guy', 'noPhoto', 95, 34, 4, 2)
;
