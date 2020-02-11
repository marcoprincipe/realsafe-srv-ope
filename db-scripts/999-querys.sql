-- Query para montagem de extratos

SELECT
	company.company_name,
	unit.unit_name,
	trx.transaction_name,
	user.user_email,
	log.transaction_date,
	log.amount
FROM 
	tb_transaction_log log
INNER JOIN tb_user user ON
	user.user_id = log.user_id
INNER JOIN tb_transaction trx ON
	trx.transaction_id = log.transaction_id
INNER JOIN tb_unit unit ON
	unit.unit_id = log.unit_id
INNER JOIN tb_company company ON
	company.company_id = unit.company_id;
	