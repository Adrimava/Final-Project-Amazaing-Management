DROP SCHEMA IF EXISTS amazaing_management;
CREATE SCHEMA amazaing_management;
USE amazaing_management;

CREATE TABLE player(
	player_id BIGINT NOT NULL AUTO_INCREMENT,
    player_name VARCHAR(255) NOT NULL,
    money DECIMAL,
    photo VARCHAR(255),
    PRIMARY KEY(player_id)
);

CREATE TABLE business_model(
	model_id BIGINT NOT NULL,
    model_name VARCHAR(255),
    photo VARCHAR(255),
    purchase_price VARCHAR(255),
    max_employees INT,
    average_revenue DECIMAL,
    daily_costs DECIMAL,
    employee_salary DECIMAL,
    PRIMARY KEY(model_id)
);

INSERT INTO business_model(model_name, purchase_price, max_employees, average_revenue, daily_costs, employee_salary) VALUES
	('Lemonade Stand', 600, 2, 100, 10, 20),
    ('Kiosk', 1, 1000, 100, 40, 30),
    ('Khlav Kalash Cart', 450, 1, 50, 10, 20)
;

CREATE TABLE company(
	company_id BIGINT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255),
    revenue DECIMAL,
    maintenance DECIMAL,
    employees INT,
    accident_risk_index DECIMAL,
    model_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY(company_id),
	FOREIGN KEY(model_id) REFERENCES business_model(model_id),
    FOREIGN KEY(player_id) REFERENCES player(player_id)
);

CREATE TABLE employee(
	employee_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_name VARCHAR(255),
    photo VARCHAR(255),
    productivity DECIMAL,
    clumsiness DECIMAL,
    company_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    FOREIGN KEY(company_id) REFERENCES company(company_id),
    FOREIGN KEY(player_id) REFERENCES player(player_id),
    PRIMARY KEY(employee_id)    
);
