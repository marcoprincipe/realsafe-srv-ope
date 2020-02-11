-- -----------------------------------------------------
-- Seleciona o banco de dados
-- -----------------------------------------------------

USE realsafe_ope_db;

-- -----------------------------------------------------
-- Efetua a carga dos dados da tabela de perfis de usuários
-- -----------------------------------------------------

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(1, 'ADM', 'Administrador');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(2, 'TES', 'Tesoureiro');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(3, 'GER', 'Gerente');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(4, 'OPE', 'Operador');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(5, 'TEC', 'Técnico / Manutenção');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(6, 'SIS', 'Sistema');

INSERT INTO tb_role (role_id, role_initial, role_name)
VALUES(7, 'ETV', 'Operador ETV');

-- ------------------------------------------------------------
-- Efetua a carga dos dados da tabela de parâmetros do terminal
-- ------------------------------------------------------------

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('access.mode', '0', 'Modo de acesso do terminal : 0 - 0ffline / 1 - online');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('use.virtual.keyboard', 'true', 'Utiliza o teclado virtual : true - sim / false - não');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('inactivity.timeout.enabled', 'true', 'Habilita ou desabilita a verificação da inatividade do terminal : true - habilitado / false - desabilitado');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('inactivity.timeout.value', '300000', 'Tempo máximo em milisegundos para retorno a tela de login');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('inactivity.timeout.interval', '1000', 'Intervalo em milisegundos para verificação da inatividade');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('check.sensors.enabled', 'false', 'Habilita ou desabilita a verificação dos sensores : true - habilitado / false - desabilitado');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('check.sensors.interval', '10000', 'Intervalo em milisegundos para verificação dos sensores');

INSERT INTO tb_terminal_parameter(parameter_id, parameter_value, description)
VALUES ('accounting.date.max.days', '3', 'Quantidade de dias permitidos para a data contábil');

-- -----------------------------------------------------
-- Efetua a carga dos dados da tabela de funcionalidades
-- -----------------------------------------------------

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(1, 'Abertura', 'Abertura contábil', 'accounting-opening');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(2, 'Fechamento', 'Fechamento contábil', 'accounting-closing');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(3, 'Depósito', 'Depósito de cédulas', 'deposit');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(4, 'Extrato', 'Extrato de transações', 'bank-statement');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(5, 'Consultas', 'Menu de consultas', 'searchs');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(6, 'Troca de Senha', 'Troca de senha de usuários', 'change-password');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(7, 'Cadastros', 'Cadastros diversos', 'registration-menu');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(8, 'Segurança', 'Menu de segurança', 'security');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(9, 'Reemissão de Comprovantes', 'Reemissão de comprovantes de operações', 'voucher-reprint');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(10, 'Recolhimento de Numerário', 'Retirada de cédulas', 'cash-collection');

INSERT INTO tb_functionality (functionality_id, name, description, route)
VALUES(11, 'Parâmetros do Sistema', 'Manutenção dos parâmetros do sistema', 'system-parameters');

-- ------------------------------------------------------------------
-- Efetua a carga dos dados da tabela de funcionalidades de cadastros
-- ------------------------------------------------------------------

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(12, 'Cadastro de Proprietários', 'Manutenção dos proprietários', 'group-owner', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(13, 'Cadastro de Grupos', 'Manutenção dos grupos', 'group-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(14, 'Cadastro de Empresas', 'Manutenção de empresas', 'company-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(15, 'Cadastro de Filiais/Unidades', 'Manutenção de filiais/unidades', 'unit-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(16, 'Cadastro de Usuários', 'Manutenção de usuários', 'user-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(17, 'Cadastro de Perfis de Acesso', 'Manutenção de perfis de acesso', 'role-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(18, 'Cadastro de Funcionalidades', 'Manutenção de funcionalidades', 'functionality-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(19, 'Cadastro de Parâmetros', 'Manutenção de parâmetros', 'parameter-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(20, 'Cadastro Geográfico', 'Manutenção de parâmetros geográficos', 'geographic-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(21, 'Terminais', 'Manutenção de parâmetros dos terminais', 'terminal-registration', 7);

INSERT INTO tb_functionality (functionality_id, name, description, route, parent_id)
VALUES(22, 'ETV´s', 'Manutenção de parâmetros ETV', 'transport-company-registration', 7);

-- -----------------------------------------------------
-- Efetua a criação do menu do administrador
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 1, 1, '1'); -- Abertura

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 2, 2, '2'); -- Fechamento

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 5, 3, '3'); -- Consultas

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 6, 3, '3'); -- Troca de senha

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 7, 4, '4'); -- Cadastros

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 8, 5, '5'); -- Segurança

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 12, 1, '1'); -- Cadastro de proprietários

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 13, 2, '2'); -- Cadastro de grupos

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 14, 3, '3'); -- Cadastro de empresas

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 15, 4, '4'); -- Cadastro de filiais/unidades

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 21, 7, '5'); -- Cadastro de terminais

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(1, 22, 8, '6'); -- Cadastro ETV's

-- -----------------------------------------------------
-- Retirada dos itens de cadastro do menu do administrador
-- -----------------------------------------------------

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 16, 5, '5'); -- Cadastro de usuários

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 17, 6, '6'); -- Cadastro de perfis de acesso

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 18, 7, '7'); -- Cadastro de funcionalidades

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 19, 8, '8'); -- Cadastro de parâmetros

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(1, 20, 9, '9'); -- Cadastro geográfico

-- -----------------------------------------------------
-- Efetua a criação do menu do tesoureiro
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 1, 1, '1'); -- Abertura

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 2, 2, '2'); -- Fechamento

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 3, 3, '3'); -- Depósito

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 4, 4, '4'); -- Extrato

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(2, 5, 5, '5'); -- Consultas

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 6, 5, '5'); -- Troca de senha

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 9, 6, '6'); -- Reemissão de comprovantes

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(2, 10, 7, '7'); -- Recolhimento de numerário

-- -----------------------------------------------------
-- Efetua a criação do menu do gerente
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 3, 1, '1'); -- Depósito

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 4, 2, '2'); -- Extrato

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(3, 5, 3, '3'); -- Consultas

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 6, 3, '3'); -- Troca de senha

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 9, 4, '4'); -- Reemissão de comprovantes

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 7, 5, '5'); -- Cadastros

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 15, 1, '1'); -- Cadastro de filiais/unidades

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(3, 16, 2, '2'); -- Cadastro de usuários

-- -----------------------------------------------------
-- Efetua a criação do menu do operador
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(4, 3, 1, '1'); -- Depósito

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(4, 4, 2, '2'); -- Extrato

-- INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
-- VALUES(4, 5, 3, '3'); -- Consultas

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(4, 6, 3, '3'); -- Troca de senha

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(4, 9, 4, '4'); -- Reemissão de comprovantes

-- -----------------------------------------------------
-- Efetua a criação do menu do técnico / manutenção
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(5, 11, 1, '1'); -- Parâmetros do sistema

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(5, 6, 2, '2'); -- Troca de senha

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(5, 18, 1, '1'); -- Cadastro de funcionalidades

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(5, 17, 2, '2'); -- Cadastro de perfis de acesso

-- -----------------------------------------------------
-- Efetua a criação do menu do Operador ETV
-- -----------------------------------------------------

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(7, 10, 1, '1'); -- Recolhimento de numerário

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(7, 2, 2, '2'); -- Fechamento

INSERT INTO tb_functionality_role (role_id, functionality_id, show_order, access_key)
VALUES(7, 6, 3, '3'); -- Troca de senha
