-- -----------------------------------------------------
-- ATENÇÃO :
-- Esse script deve ser executado com o usuário 
-- realsafe_admin do banco de dados.
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Efetua a criação do schema realsafe_ope_db
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS realsafe_ope_db;

-- -----------------------------------------------------
-- Altera o schema para realsafe_ope_db	
-- -----------------------------------------------------

USE realsafe_ope_db;

-- -----------------------------------------------------
-- Cria o usuário default da base de dados
-- -----------------------------------------------------

CREATE USER IF NOT EXISTS 'realsafe_user'@'localhost' IDENTIFIED BY 'R3al$afe';
