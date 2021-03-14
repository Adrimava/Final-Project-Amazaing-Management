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

INSERT INTO business_model(model_id, model_name, photo, purchase_price, max_employees, average_revenue, daily_costs, employee_salary) VALUES
	(1, 'Lemonade Stand', 'https://avatars.dicebear.com/api/identicon/Lemonade Stand.svg', 600, 2, 100, 10, 20),
    (2, 'Kiosk', 'https://avatars.dicebear.com/api/identicon/Kiosk.svg', 1000, 1, 100, 40, 30),
    (3, 'Khlav Kalash Cart', 'https://avatars.dicebear.com/api/identicon/Khlav Kalash Cart.svg', 450, 1, 50, 10, 20),
    (4, 'Hairdresser', 'https://avatars.dicebear.com/api/identicon/Hairdresser.svg', 1500, 4, 200, 40, 40),
    (5, 'Gym', 'https://avatars.dicebear.com/api/identicon/Gym.svg', 2000, 4, 190, 60, 30),
	(6, 'Spanish academy', 'https://avatars.dicebear.com/api/identicon/Spanish academy.svg', 2100, 5, 100, 40, 60),
	(7, 'Book shop', 'https://avatars.dicebear.com/api/identicon/Book shop.svg', 2500, 3, 150, 50, 60),
    (8, 'Real state', 'https://avatars.dicebear.com/api/identicon/Real state.svg', 3000, 4, 250, 200, 50),
    (9, 'Cinema', 'https://avatars.dicebear.com/api/identicon/Cinema.svg', 5000, 6, 400, 400, 40),
    (10, 'Theater', 'https://avatars.dicebear.com/api/identicon/Theater.svg', 5000, 8, 300, 400, 60),
    (11, 'Small amusement park', 'https://avatars.dicebear.com/api/identicon/Small musement park.svg', 8000, 10, 600, 700, 50),
    (12, 'Small mall', 'https://avatars.dicebear.com/api/identicon/Small mall.svg', 13000, 15, 1000, 3000, 50),
    (13, 'Hospital', 'https://avatars.dicebear.com/api/identicon/Hospital.svg', 12500, 20, 800, 4000, 80),
    (14, 'Private school', 'https://avatars.dicebear.com/api/identicon/Private school.svg', 12000, 15, 500, 1500, 80),
    (15, 'Consulting', 'https://avatars.dicebear.com/api/identicon/Consulting.svg', 12000, 5, 900, 1000, 200),
    (16, 'Train station', 'https://avatars.dicebear.com/api/identicon/Train station.svg', 19000, 10, 1100, 1100, 100),
    (17, 'Cab company', 'https://avatars.dicebear.com/api/identicon/Cab company.svg', 20000, 30, 300, 800, 80),
    (18, 'Small Airport', 'https://avatars.dicebear.com/api/identicon/Small Airport.svg', 30000, 25, 800, 2000, 300),
    (19, 'Bank', 'https://avatars.dicebear.com/api/identicon/Bank.svg', 40000, 30, 1000, 1000, 100),
    (20, 'Big-tech', 'https://avatars.dicebear.com/api/identicon/Cab company.svg', 100000, 100, 5000, 10000, 150)    
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

CREATE TABLE player_employees(
	employee_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (player_id) REFERENCES player(player_id)
);

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
	('The Great Stand', 75, 25, 2, 25, 1, 1),
    ('Lemon Party', 80, 35, 1, 40, 1, 1),
    ('Sneed Feed and Seed', 90, 40, 1, 15, 2, 1),
    ('Just Khlav Kalash', 40, 10, 1, 5, 3, 2)
;

CREATE TABLE company_employees(
	employee_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);

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
	('Sara Penguin', 'https://avatars.dicebear.com/api/bottts/Sara Penguin.svg', 60, 15, 1, 1),
    ('Celia Penguin', 'https://avatars.dicebear.com/api/bottts/Celia Penguin.svg', 50, 10, 1, 1),
    ('Lemoncio Sour', 'https://avatars.dicebear.com/api/bottts/Lemoncio Sour.svg', 35, 20, 2, 1),
    ('Sneed Fisher', 'https://avatars.dicebear.com/api/bottts/Sneed Fisher.svg', 40, 19, 3, 1),
    ('Khlav Kalash Guy', 'https://avatars.dicebear.com/api/bottts/Khlav Kalash Guy.svg', 95, 34, 4, 2)
;
