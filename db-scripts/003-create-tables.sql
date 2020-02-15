-- -----------------------------------------------------
-- ATENÇÃO :
-- Esse script deve ser executado com o usuário 
-- realsafe_admin do banco de dados.
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Seleciona o banco de dados
-- -----------------------------------------------------

USE realsafe_ope_db;

-- -----------------------------------------------------
-- Efetua a exclusão das tabelas
-- -----------------------------------------------------

DROP TABLE IF EXISTS tb_parameter;
DROP TABLE IF EXISTS tb_terminal_parameter;
DROP TABLE IF EXISTS tb_event_log;
DROP TABLE IF EXISTS tb_nsu_terminal;
DROP TABLE IF EXISTS tb_terminal_status;
DROP TABLE IF EXISTS tb_cash_collection_detail;
DROP TABLE IF EXISTS tb_closing_detail;
DROP TABLE IF EXISTS tb_opening_detail;
DROP TABLE IF EXISTS tb_deposit_detail;
DROP TABLE IF EXISTS tb_transaction_log;
DROP TABLE IF EXISTS tb_terminal;
DROP TABLE IF EXISTS tb_user_unit;
DROP TABLE IF EXISTS tb_functionality_role;
DROP TABLE IF EXISTS tb_transport_company_user;
DROP TABLE IF EXISTS tb_role;
DROP TABLE IF EXISTS tb_user;
DROP TABLE IF EXISTS tb_functionality;
DROP TABLE IF EXISTS tb_unit;
DROP TABLE IF EXISTS tb_company;
DROP TABLE IF EXISTS tb_group;
DROP TABLE IF EXISTS tb_transport_company;
DROP TABLE IF EXISTS tb_group_owner;

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_group_owner
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_group_owner (
  group_owner_id DECIMAL(15) NOT NULL,
  group_owner_name VARCHAR(50) NOT NULL,
  business_name VARCHAR(50) NOT NULL,
  contact_name VARCHAR(50) NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  cel_country_code DECIMAL(5) NULL,
  cel_area_code DECIMAL(5) NULL,
  cel_number DECIMAL(10) NULL,
  state_registration DECIMAL(10) NULL,
  municipal_registration DECIMAL(10) NULL,
  site_address VARCHAR(100) NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  creation_user DECIMAL(12) NULL,
  last_update TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  update_user DECIMAL(12) NULL,
  PRIMARY KEY (group_owner_id))
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_group_owner TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_group
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_group (
  group_id DECIMAL(15) NOT NULL,
  group_name VARCHAR(50) NOT NULL,
  business_name VARCHAR(50) NOT NULL,
  contact_name VARCHAR(50) NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NOT NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  cel_country_code DECIMAL(5) NULL,
  cel_area_code DECIMAL(5) NULL,
  cel_number DECIMAL(10) NULL,
  municipal_registration DECIMAL(10) NULL,
  state_registration DECIMAL(10) NULL,
  site_address VARCHAR(100) NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  creation_user DECIMAL(12) NULL,
  last_update TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  update_user DECIMAL(12) NULL,
  group_owner_id DECIMAL(15) NOT NULL,
  PRIMARY KEY (group_id),
  CONSTRAINT fk_tb_group_tb_group_owner1
    FOREIGN KEY (group_owner_id)
    REFERENCES tb_group_owner (group_owner_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_group_tb_group_owner1_idx ON tb_group (group_owner_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_group TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_company
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_company (
  company_id DECIMAL(15) NOT NULL,
  company_name VARCHAR(50) NOT NULL,
  business_name VARCHAR(50) NOT NULL,
  contact_name VARCHAR(50) NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NOT NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  cel_country_code DECIMAL(5) NULL,
  cel_area_code DECIMAL(5) NULL,
  cel_number DECIMAL(10) NULL,
  state_registration DECIMAL(10) NULL,
  municipal_registration DECIMAL(10) NULL,
  site_address VARCHAR(100) NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  creation_user DECIMAL(12) NULL,
  last_update TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  update_user DECIMAL(12) NULL,
  group_id DECIMAL(15) NOT NULL,
  PRIMARY KEY (company_id),
  CONSTRAINT fk_tb_company_tb_group1
    FOREIGN KEY (group_id)
    REFERENCES tb_group (group_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_company_tb_group1_idx ON tb_company (group_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_company TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_unit
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_unit (
  unit_id DECIMAL(15) NOT NULL,
  unit_name VARCHAR(50) NOT NULL,
  business_name VARCHAR(50) NOT NULL,
  contact_name VARCHAR(50) NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NOT NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  cel_country_code DECIMAL(5) NULL,
  cel_area_code DECIMAL(5) NULL,
  cel_number DECIMAL(10) NULL,
  municipal_registration DECIMAL(10) NULL,
  state_registration DECIMAL(10) NULL,
  site_address VARCHAR(100) NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  creation_user DECIMAL(12) NULL,
  last_update TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  update_user DECIMAL(12) NULL,
  company_id DECIMAL(15) NOT NULL,
  PRIMARY KEY (unit_id),
  CONSTRAINT fk_tb_unit_tb_company1
    FOREIGN KEY (company_id)
    REFERENCES tb_company (company_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_unit_tb_company1_idx ON tb_unit (company_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_unit TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_terminal
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_terminal (
  terminal_id VARCHAR(8) NOT NULL,
  terminal_name VARCHAR(50) NOT NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  unit_id DECIMAL(15) NOT NULL,
  PRIMARY KEY (terminal_id),
  CONSTRAINT fk_tb_terminal_tb_unit1
    FOREIGN KEY (unit_id)
    REFERENCES tb_unit (unit_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_terminal_tb_unit1_idx ON tb_terminal (unit_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_terminal TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_terminal_status
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_terminal_status (
  terminal_id VARCHAR(8) NOT NULL,
  accounting_date TIMESTAMP(3) NULL,
  banknotes_in_safe INT NOT NULL DEFAULT 0,
  amount_in_safe DECIMAL(11,2) NOT NULL DEFAULT 0,
  last_opening_date_time TIMESTAMP(3) NULL,
  last_opening_banknotes INT NOT NULL DEFAULT 0,
  last_opening_amount DECIMAL(11,2) NOT NULL DEFAULT 0,
  last_closing_date_time TIMESTAMP(3) NULL,
  last_closing_banknotes INT NOT NULL DEFAULT 0,
  last_closing_amount DECIMAL(11,2) NOT NULL DEFAULT 0,
  etv_closing CHAR(1) NOT NULL DEFAULT 'N',
  status CHAR(1) NOT NULL DEFAULT 'C',
  PRIMARY KEY (terminal_id),
  CONSTRAINT fk_tb_terminal_status_tb_terminal1
    FOREIGN KEY (terminal_id)
    REFERENCES tb_terminal (terminal_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_terminal_status TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_nsu_terminal
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_nsu_terminal (
  terminal_id VARCHAR(8) NOT NULL,
  nsu_terminal DECIMAL(7,0) NOT NULL DEFAULT 0,
  nsu_event DECIMAL(7,0) NOT NULL DEFAULT 0,
  PRIMARY KEY (terminal_id),
  CONSTRAINT fk_tb_nsu_terminal_tb_terminal1
    FOREIGN KEY (terminal_id)
    REFERENCES tb_terminal (terminal_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_nsu_terminal TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_role
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_role (
  role_id INT NOT NULL,
  role_initial VARCHAR(10) NOT NULL,
  role_name VARCHAR(50) NOT NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (role_id))
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_role TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_user
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_user (
  group_owner_id DECIMAL(15) NOT NULL,
  user_id DECIMAL(12) NOT NULL,
  user_code VARCHAR(16) NOT NULL,
  password VARCHAR(256) NULL,
  user_name VARCHAR(50) NOT NULL,
  general_registration DECIMAL(11) NOT NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NOT NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  is_blocked CHAR(1) NOT NULL DEFAULT 'N',
  login_retries INT NOT NULL DEFAULT 0,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (group_owner_id, user_id),
  CONSTRAINT fk_tb_user_tb_group_owner1
    FOREIGN KEY (group_owner_id)
    REFERENCES tb_group_owner (group_owner_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_user TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_functionality
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_functionality (
  functionality_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(50) NULL,
  route VARCHAR(100) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  parent_id INT NULL,
  PRIMARY KEY (functionality_id),
  CONSTRAINT fk_functionality_functionality
    FOREIGN KEY (parent_id)
    REFERENCES tb_functionality (functionality_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_functionality_functionality_idx ON tb_functionality (parent_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_functionality TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_functionality_role
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_functionality_role (
  role_id INT NOT NULL,
  functionality_id INT NOT NULL,
  show_order INT NULL DEFAULT 0,
  access_key VARCHAR(1) NULL,
  CONSTRAINT fk_tb_functionality_role_tb_role1
    FOREIGN KEY (role_id)
    REFERENCES tb_role (role_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_functionality_role_tb_functionality1
    FOREIGN KEY (functionality_id)
    REFERENCES tb_functionality (functionality_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_functionality_role_idx ON tb_functionality_role (role_id ASC) VISIBLE;

CREATE INDEX fk_role_functionality_idx ON tb_functionality_role (functionality_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_functionality_role TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_user_unit
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_user_unit (
  group_owner_id DECIMAL(15) NOT NULL,
  unit_id DECIMAL(15) NOT NULL,
  user_id DECIMAL(12) NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (group_owner_id, unit_id, user_id),
  CONSTRAINT fk_tb_user_unit_tb_unit1
    FOREIGN KEY (unit_id)
    REFERENCES tb_unit (unit_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_user_unit_tb_role1
    FOREIGN KEY (role_id)
    REFERENCES tb_role (role_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_user_unit_tb_user1
    FOREIGN KEY (group_owner_id , user_id)
    REFERENCES tb_user (group_owner_id , user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_user_unit_tb_unit1_idx ON tb_user_unit (unit_id ASC) VISIBLE;

CREATE INDEX fk_tb_user_unit_tb_role1_idx ON tb_user_unit (role_id ASC) VISIBLE;

CREATE INDEX fk_tb_user_unit_tb_user1_idx ON tb_user_unit (group_owner_id ASC, user_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_user_unit TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_transport_company
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_transport_company (
  group_owner_id DECIMAL(15) NOT NULL,
  transport_company_id DECIMAL(15) NOT NULL,
  transport_company_name VARCHAR(50) NOT NULL,
  business_name VARCHAR(50) NOT NULL,
  address VARCHAR(256) NOT NULL,
  address_number VARCHAR(10) NOT NULL,
  address_complement VARCHAR(50) NULL,
  address_neighborhood VARCHAR(50) NOT NULL,
  city_name VARCHAR(50) NOT NULL,
  state_code VARCHAR(3) NOT NULL,
  country_code VARCHAR(3) NOT NULL,
  zip_code DECIMAL(10) NOT NULL,
  phone_country_code DECIMAL(5) NOT NULL,
  phone_area_code DECIMAL(5) NOT NULL,
  phone_number DECIMAL(10) NOT NULL,
  site_address VARCHAR(100) NULL,
  email_address VARCHAR(100) NULL,
  additional_info VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (group_owner_id, transport_company_id),
  CONSTRAINT fk_tb_transport_company_tb_group_owner1
    FOREIGN KEY (group_owner_id)
    REFERENCES tb_group_owner (group_owner_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_transport_company_tb_group_owner1_idx ON tb_transport_company (group_owner_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_transport_company TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_transport_company_user
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_transport_company_user (
  group_owner_id DECIMAL(15) NOT NULL,
  transport_company_id DECIMAL(15) NOT NULL,
  user_group_owner_id DECIMAL(15) NOT NULL,
  user_id DECIMAL(12) NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (group_owner_id, transport_company_id, user_group_owner_id, user_id, role_id),
  CONSTRAINT fk_tb_transport_company_user_tb_transport_company1
    FOREIGN KEY (group_owner_id , transport_company_id)
    REFERENCES tb_transport_company (group_owner_id , transport_company_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_transport_company_user_tb_role1
    FOREIGN KEY (role_id)
    REFERENCES tb_role (role_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_transport_company_user_tb_user1
    FOREIGN KEY (user_group_owner_id , user_id)
    REFERENCES tb_user (group_owner_id , user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_transport_company_user_tb_role1_idx ON tb_transport_company_user (role_id ASC) VISIBLE;

CREATE INDEX fk_tb_transport_company_user_tb_user1_idx ON tb_transport_company_user (user_group_owner_id ASC, user_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_transport_company_user TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_transaction_log
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_transaction_log (
  nsu_terminal VARCHAR(15) NOT NULL,
  group_owner_id DECIMAL(15) NOT NULL,
  unit_id DECIMAL(15) NOT NULL,
  user_id DECIMAL(12) NOT NULL,
  terminal_id VARCHAR(8) NOT NULL,
  accounting_date TIMESTAMP(3) NOT NULL,
  date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  functionality_id INT NOT NULL,
  banknotes INT NOT NULL DEFAULT 0,
  amount DECIMAL(11,2) NOT NULL,
  status CHAR(1) NOT NULL DEFAULT 'P',
  PRIMARY KEY (nsu_terminal),
  CONSTRAINT fk_tb_transaction_log_tb_unit1
    FOREIGN KEY (unit_id)
    REFERENCES tb_unit (unit_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_transaction_log_tb_user1
    FOREIGN KEY (group_owner_id , user_id)
    REFERENCES tb_user (group_owner_id , user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_transaction_log_tb_functionality1
    FOREIGN KEY (functionality_id)
    REFERENCES tb_functionality (functionality_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_tb_transaction_log_tb_terminal1
    FOREIGN KEY (terminal_id)
    REFERENCES tb_terminal (terminal_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_transaction_log_tb_unit1_idx ON tb_transaction_log (unit_id ASC) VISIBLE;

CREATE INDEX fk_tb_transaction_log_tb_user1_idx ON tb_transaction_log (group_owner_id ASC, user_id ASC) VISIBLE;

CREATE INDEX fk_tb_transaction_log_tb_functionality1_idx ON tb_transaction_log (functionality_id ASC) VISIBLE;

CREATE INDEX fk_tb_transaction_log_tb_terminal1_idx ON tb_transaction_log (terminal_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_transaction_log TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_deposit_detail
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_deposit_detail (
  nsu_terminal VARCHAR(15) NOT NULL,
  include_order INT NOT NULL,
  quantity INT NOT NULL,
  amount DECIMAL(11,2) NOT NULL,
  PRIMARY KEY (nsu_terminal, include_order),
  CONSTRAINT fk_tb_deposit_detail_tb_transaction_log1
    FOREIGN KEY (nsu_terminal)
    REFERENCES tb_transaction_log (nsu_terminal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_deposit_detail_tb_transaction_log1_idx ON tb_deposit_detail (nsu_terminal ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_deposit_detail TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_opening_detail
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_opening_detail (
  nsu_terminal VARCHAR(15) NOT NULL,
  accounting_date TIMESTAMP(3) NULL,
  opening_date_time TIMESTAMP(3) NOT NULL,
  banknotes_in_safe INT NOT NULL,
  amount_in_safe DECIMAL(11,2) NOT NULL,
  last_closing_date_time TIMESTAMP(3) NULL,
  last_closing_banknotes INT NULL,
  last_closing_amount DECIMAL(11,2) NULL,
  etv_closing CHAR(1) NULL,
  PRIMARY KEY (nsu_terminal),
  CONSTRAINT fk_tb_opening_detail_tb_transaction_log1
    FOREIGN KEY (nsu_terminal)
    REFERENCES tb_transaction_log (nsu_terminal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_opening_detail TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_closing_detail
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_closing_detail (
  nsu_terminal VARCHAR(15) NOT NULL,
  closing_date_time TIMESTAMP(3) NULL,
  banknotes_in_safe INT NOT NULL DEFAULT 0,
  amount_in_safe DECIMAL(11,2) NOT NULL DEFAULT 0,
  last_opening_date_time TIMESTAMP(3) NULL,
  last_opening_banknotes INT NOT NULL DEFAULT 0,
  last_opening_amount DECIMAL(11,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (nsu_terminal),
  CONSTRAINT fk_tb_closing_detail_tb_transaction_log1
    FOREIGN KEY (nsu_terminal)
    REFERENCES tb_transaction_log (nsu_terminal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_closing_detail TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_cash_collection_detail
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_cash_collection_detail (
  nsu_terminal VARCHAR(15) NOT NULL,
  cash_collection_nsu VARCHAR(15) NOT NULL,
  PRIMARY KEY (nsu_terminal),
  CONSTRAINT fk_tb_cash_collection_detail_tb_transaction_log1
    FOREIGN KEY (nsu_terminal)
    REFERENCES tb_transaction_log (nsu_terminal)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_cash_collection_detail TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_parameter
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_parameter (
  group_owner_id DECIMAL(15) NOT NULL,
  parameter_id VARCHAR(256) NOT NULL,
  parameter_value VARCHAR(256) NOT NULL,
  description VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (group_owner_id, parameter_id),
  CONSTRAINT fk_tb_parameter_tb_group_owner1
    FOREIGN KEY (group_owner_id)
    REFERENCES tb_group_owner (group_owner_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_tb_parameter_tb_group_owner1_idx ON tb_parameter (group_owner_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_parameter TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_terminal_parameter
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_terminal_parameter (
  parameter_id VARCHAR(256) NOT NULL,
  parameter_value VARCHAR(256) NOT NULL,
  description VARCHAR(256) NULL,
  status CHAR(1) NOT NULL DEFAULT 'A',
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (parameter_id))
ENGINE = InnoDB;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_terminal_parameter TO 'realsafe_user'@'localhost';

-- -----------------------------------------------------
-- Efetua a criação da tabela tb_event_log
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS tb_event_log (
  nsu_event VARCHAR(15) NOT NULL,
  terminal_id VARCHAR(8) NOT NULL,
  user_id DECIMAL(12) NULL,
  date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  event_id INT NOT NULL,
  event_name VARCHAR(50) NOT NULL,
  nsu_transaction VARCHAR(15) NULL,
  result_code INT NOT NULL,
  message VARCHAR(256) NULL,
  extra_data VARCHAR(1000) NULL,
  status CHAR(1) NOT NULL DEFAULT 'P',
  PRIMARY KEY (nsu_event))
ENGINE = InnoDB;

CREATE INDEX tb_event_log_idx1 ON tb_event_log (user_id ASC) VISIBLE;

GRANT SELECT, INSERT, UPDATE, DELETE ON tb_event_log TO 'realsafe_user'@'localhost';