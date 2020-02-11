-- -----------------------------------------------------
-- ATENÇÃO :
-- Esse script deve ser executado com o usuário root
-- do banco de dados.
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Efetua a criação do usuário administrador do db
-- -----------------------------------------------------

CREATE USER IF NOT EXISTS 'realsafe_admin'@'localhost' IDENTIFIED BY 'R3al$afe';

-- -----------------------------------------------------
-- Associa todos os privilégios ao administrador do db
-- -----------------------------------------------------

 GRANT ALL PRIVILEGES ON *.* TO 'realsafe_admin'@'localhost' WITH GRANT OPTION;