-- -----------------------------------------------------
-- Seleciona o banco de dados
-- -----------------------------------------------------

USE realsafe_ope_db;

-- -----------------------------------------------------
-- Efetua a inclusão do proprietário dos grupos
-- -----------------------------------------------------

INSERT INTO tb_group_owner (group_owner_id, group_owner_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info)
VALUES
(24469077097, 'Proprietário Grupos', 'Proprietário Grupos', 'Endereço Proprietário Grupos', 1, 'Complemento Proprietário Grupos', 'Bairro Proprietário Grupos',
'São Paulo', 'SP', 'BR', 11111111, 55, 11, 11111111, 'www.ownergroups.com.br', 'ownergroups@grupo001.com.br', 'Informação Adicional Proprietário Grupos');

-- ----------------------------------------------------------------------
-- Efetua a inclusão do parâmetro de login
-- ----------------------------------------------------------------------

INSERT INTO tb_parameter(group_owner_id, parameter_id, parameter_value, description)
VALUES (24469077097, 'max.login.retries', '3', 'Quantidade máxima de tentativas de login');

-- -----------------------------------------------------
-- Efetua a inclusão do grupo 001
-- -----------------------------------------------------

INSERT INTO tb_group (group_owner_id, group_id, group_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info)
VALUES
(24469077097, 34992916000197, 'Grupo 001', 'Grupo 001', 'Endereço Grupo 001', 1, 'Complemento Grupo 001', 'Bairro Grupo 001',
'São Paulo', 'SP', 'BR', 11111111, 55, 11, 11111111, 'www.grupo001.com.br', 'grupo001@grupo001.com.br', 'Informação Adicional Grupo 001');

-- -----------------------------------------------------
-- Efetua a inclusão do grupo 002
-- -----------------------------------------------------

INSERT INTO tb_group (group_owner_id, group_id, group_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info)
VALUES
(24469077097, 16578878000149, 'Grupo 002', 'Grupo 002', 'Endereço Grupo 002', 2, 'Complemento Grupo 002', 'Bairro Grupo 002', 
'São Paulo', 'SP', 'BR', 22222222, 55, 11, 22222222, 'www.grupo002.com.br', 'grupo002@grupo002.com.br', 'Informação Adicional Grupo 002');

-- -----------------------------------------------------
-- Efetua a inclusão da empresa 001 do grupo 001
-- -----------------------------------------------------

INSERT INTO tb_company (company_id, company_name, business_name, contact_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, group_id)
VALUES
(62378165000159, 'Empresa 001 / Grupo 001', 'Empresa 001 / Grupo 001', 'Contato Empresa 001 / 001', 'Endereço Empresa 001 / Grupo 001', 1, 'Complemento Empresa 001 / Grupo 001', 'Bairro Empresa 001 / Grupo 001', 
'São Paulo', 'SP', 'BR', 11111111, 55, 11, 11111111, 'www.empresa001grupo001.com.br', 'empresa001@grupo001.com.br', 'Informação Adicional Empresa 001 / Grupo 001', 34992916000197);

-- -----------------------------------------------------
-- Efetua a inclusão da empresa 002 do grupo 001
-- -----------------------------------------------------

INSERT INTO tb_company (company_id, company_name, business_name, contact_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, group_id)
VALUES
(42149496000100, 'Empresa 002 / Grupo 001', 'Empresa 002 / Grupo 001', 'Contato Empresa 001 / 002', 'Endereço Empresa 002 / Grupo 001', 1, 'Complemento Empresa 002 / Grupo 001', 'Bairro Empresa 002 / Grupo 001', 
'São Paulo', 'SP', 'BR', 22222111, 55, 11, 22222111, 'www.empresa002grupo001.com.br', 'empresa002@grupo001.com.br', 'Informação Adicional Empresa 002 / Grupo 001', 34992916000197);

-- -----------------------------------------------------
-- Efetua a inclusão da empresa 001 do grupo 002
-- -----------------------------------------------------

INSERT INTO tb_company (company_id, company_name, business_name, contact_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, group_id)
VALUES
(91435953000138, 'Empresa 001 / Grupo 002', 'Empresa 001 / Grupo 002', 'Contato 002 / 001', 'Endereço Empresa 001 / Grupo 002', 1, 'Complemento Empresa 001 / Grupo 002', 'Bairro Empresa 001 / Grupo 002', 
'São Paulo', 'SP', 'BR', 11111222, 55, 11, 11111222, 'www.empresa001grupo002.com.br', 'empresa001@grupo002.com.br', 'Informação Adicional Empresa 001 / Grupo 002', 16578878000149);

-- -----------------------------------------------------
-- Efetua a inclusão da empresa 002 do grupo 002
-- -----------------------------------------------------

INSERT INTO tb_company (company_id, company_name, business_name, contact_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, group_id)
VALUES
(44469286000124, 'Empresa 002 / Grupo 002', 'Empresa 002 / Grupo 002', 'Contato 002 / 002', 'Endereço Empresa 002 / Grupo 002', 1, 'Complemento Empresa 002 / Grupo 002', 'Bairro Empresa 002 / Grupo 002', 
'São Paulo', 'SP', 'BR', 22222222, 55, 11, 22222222, 'www.empresa002grupo002.com.br', 'empresa002@grupo002.com.br', 'Informação Adicional Empresa 002 / Grupo 002', 16578878000149);

-- -----------------------------------------------------
-- Efetua a inclusão da filial 001 / 001 / 001
-- -----------------------------------------------------

INSERT INTO tb_unit (unit_id, unit_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, company_id)
VALUES
(10066500000180, 'Filial 001/001/001', 'Filial 001/001/001', 'Endereço Filial 001/001/001', 1, 'Complemento Filial 001/001/001', 'Bairro Filial 001/001/001', 
'São Paulo', 'SP', 'BR', 11111111, 55, 11, 11111111, 'www.filial001empresa001grupo001.com.br', 'filial001@empresa001.com.br', 'Informação Adicional Filial 001/001/001', 62378165000159);

-- -----------------------------------------------------
-- Efetua a inclusão da filial 002 / 001 / 001
-- -----------------------------------------------------

INSERT INTO tb_unit (unit_id, unit_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, company_id)
VALUES
(28459044000101, 'Filial 002/001/001', 'Filial 002/001/001', 'Endereço Filial 002/001/001', 1, 'Complemento Filial 002/001/001', 'Bairro Filial 002/001/001', 
'São Paulo', 'SP', 'BR', 22222222, 55, 11, 22222222, 'www.filial002empresa001grupo001.com.br', 'filial002@empresa001.com.br', 'Informação Adicional Filial 002/001/001', 62378165000159);

-- -----------------------------------------------------
-- Efetua a inclusão da filial 001 / 002 / 001
-- -----------------------------------------------------

INSERT INTO tb_unit (unit_id, unit_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, company_id)
VALUES
(31443361000136, 'Filial 001/002/001', 'Filial 001/002/001', 'Endereço Filial 001/002/001', 1, 'Complemento Filial 001/002/001', 'Bairro Filial Filial 001/002/001', 
'São Paulo', 'SP', 'BR', 11111222, 55, 11, 11111222, 'www.filial001empresa002grupo001.com.br', 'filial001@empresa002.com.br', 'Informação Adicional Filial 001/002/001', 42149496000100);

-- -----------------------------------------------------
-- Efetua a inclusão da filial 002 / 002 / 001
-- -----------------------------------------------------

INSERT INTO tb_unit (unit_id, unit_name, business_name, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, site_address, email_address, additional_info, company_id)
VALUES
(27842950000110, 'Filial 002/002/001', 'Filial 002/002/001', 'Endereço Filial 002/002/001', 1, 'Complemento Filial 002/002/001', 'Bairro Filial 002/002/001', 
'São Paulo', 'SP', 'BR', 22222222, 55, 11, 22222222, 'www.filial002empresa002grupo001.com.br', 'filial002@empresa002.com.br', 'Informação Adicional Filial 002/002/001', 42149496000100);

-- ----------------------------------------------------------------------
-- Efetua a inclusão do terminal TERM0000000001 do proprietário
-- ----------------------------------------------------------------------

INSERT INTO tb_terminal (terminal_id, terminal_name, unit_id)
VALUES ('VOL00001', 'Terminal VOL00001', 10066500000180);

INSERT INTO tb_terminal_status (terminal_id)
VALUES ('VOL00001');

INSERT INTO tb_nsu_terminal (terminal_id)
VALUES ('VOL00001');

-- -----------------------------------------------------
-- Efetua a inclusão do usuário administrador
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 28859563054, 'user001', sha2('snalov', 256), 'Administrador', '112223334', 'Endereço Administrador', 1, 'Complemento Administrador', 'Bairro Administrador', 
'São Paulo', 'SP', 'BR', 11111111, 55, 11, 11111111, 'administrador@teste.com.br', 'Informação Adicional Administrador');

INSERT INTO tb_user_unit (group_owner_id, unit_id, user_id, role_id)
VALUES (24469077097, 10066500000180, 28859563054, 1);

INSERT INTO tb_user_unit (group_owner_id, unit_id, user_id, role_id)
VALUES (24469077097, 28459044000101, 28859563054, 1);

-- -----------------------------------------------------
-- Efetua a inclusão do usuário tesoureiro
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 53761711085, 'user002', sha2('snalov', 256), 'Tesoureiro', '223334445', 'Endereço Tesoureiro', 1, 'Complemento Tesoureiro', 'Bairro Tesoureiro', 
'São Paulo', 'SP', 'BR', 22222222, 55, 11, 22222222, 'tesoureiro@teste.com.br', 'Informação Adicional Tesoureiro');

INSERT INTO tb_user_unit (group_owner_id, unit_id, user_id, role_id)
VALUES (24469077097, 10066500000180, 53761711085, 2);

INSERT INTO tb_user_unit (group_owner_id, unit_id, user_id, role_id)
VALUES (24469077097, 28459044000101, 53761711085, 2);

-- -----------------------------------------------------
-- Efetua a inclusão do usuário gerente
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 66102493001, 'user003', sha2('snalov', 256), 'Gerente', '334445556', 'Endereço Gerente', 1, 'Complemento Gerente', 'Bairro Gerente', 
'São Paulo', 'SP', 'BR', 33333333, 55, 11, 33333333, 'gerente@teste.com.br', 'Informação Adicional Gerente');

-- -----------------------------------------------------
-- Efetua a inclusão do usuário operador
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 10695980033, 'user004', sha2('snalov', 256), 'Operador', '445556667', 'Endereço Operador', 1, 'Complemento Operador', 'Bairro Operador', 
'São Paulo', 'SP', 'BR', 44444444, 55, 11, 44444444, 'operador@teste.com.br', 'Informação Adicional Operador');

-- -----------------------------------------------------
-- Efetua a inclusão do usuário técnico
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 72196661015, 'user005', sha2('snalov', 256), 'Técnico', '556667778', 'Endereço Técnico', 1, 'Complemento Técnico', 'Bairro Técnico', 
'São Paulo', 'SP', 'BR', 55555555, 55, 11, 55555555, 'tecnico@teste.com.br', 'Informação Adicional Técnico');

-- -----------------------------------------------------
-- Efetua a inclusão do usuário sistema
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 53159693040, 'user006', sha2('snalov', 256), 'Sistema', '667778889', 'Endereço Sistema', 1, 'Complemento Sistema', 'Bairro Sistema', 
'São Paulo', 'SP', 'BR', 66666666, 55, 11, 66666666, 'sistema@teste.com.br', 'Informação Adicional Sistema');


-- -----------------------------------------------------
-- Efetua a inclusão do usuário operador ETV
-- -----------------------------------------------------

INSERT INTO tb_user (group_owner_id, user_id, user_code, password, user_name, general_registration, address, address_number, address_complement, address_neighborhood, 
city_name, state_code, country_code, zip_code, phone_country_code, phone_area_code, phone_number, email_address, additional_info)
VALUES
(24469077097, 48966582052, 'user007', sha2('snalov', 256), 'Operador ETV', '12123123', 'Endereço Operador ETV', 1, 'Complemento Operador ETV', 'Bairro Operador ETV', 
'São Paulo', 'SP', 'BR', 88888888, 55, 11, 88888888, 'operador.etv@teste.com.br', 'Informação Adicional Operador ETV');

INSERT INTO tb_user_unit (group_owner_id, unit_id, user_id, role_id)
VALUES (24469077097, 28459044000101, 48966582052, 7);
