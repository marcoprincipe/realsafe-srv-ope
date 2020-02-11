package br.com.volans.realsafe.enums;

/**
 * Enumeração com as chaves do arquivo de mensagens.
 * 
 * @author Volans Informcática Ltda
 */

public enum MessageKeys {
	
	/**
	 * Declaração das chaves dos parâmetros
	 */
	
	// Mensagens genéricas
	
	SUCCESS("success", "ok"),
	UNKNOWN_ERROR("unknown.error", "Erro não previsto"),
	PRINTER_STATUS_CODE_NOT_FOUND("printer.status.code.not.found", "Código do status da impressora não encontrado, código : %d"),
	DEPOSITORY_STATUS_CODE_NOT_FOUND("depository.status.code.not.found", "Código do status do depositário não encontrado, código : %d"),
	SENSORS_STATUS_CODE_NOT_FOUND("sensors.status.code.not.found", "Código do status da placa de sensores não encontrado, código : %d"),
	DB_CONNECTION_FAILURE("db.connection.failure", "Falha na conexão com o banco de dados"),
	NO_PARAMETER_INFORMED("no.parameter.informed", "Nenhum parâmetro informado para pesquisa"),

	// Mensagens do proprietário de grupos.
	
	GROUP_OWNER_CODE_NOT_INFORMED("group.owner.code.not.informed", "Código do proprietário de grupos não informado"),
	INVALID_GROUP_OWNER_CODE("invalid.group.owner.code", "Código do proprietário de grupos informado inválido"),
	NO_GROUP_OWNER_FOUND("no.group.owner.found", "Proprietário de grupos não encontrado"),
	
	// Mensagnes do status de terminal.

	LOCAL_TERMINAL_STATUS_NOT_FOUND("local.terminal.status.not.found", "Status do terminal não encontrado na base local"),
	
	// Mensagens do serviço de grupos.
	
	GROUP_CODE_NOT_INFORMED("group.code.not.informed", "Código do grupo não informado"),
	INVALID_GROUP_CODE("invalid.group.code", "Código do grupo informado inválido"),
	NO_GROUP_FOUND("no.group.found", "Nenhuma grupo não encontrado"),
	GROUP_NOT_FOUND("group.not.found", "Grupo não encontrado"),
	
	// Mensagens do serviço de empresas
	
	COMPANY_CODE_NOT_INFORMED("company.code.not.informed", "Código da empresa não informado"),
	INVALID_COMPANY_CODE("invalid.company.code", "Código da empresa informado inválido"),
	NO_COMPANY_FOUND("no.company.found", "Nenhuma empresa não encontrada"),
	COMPANY_NOT_FOUND("company.not.found", "Empresa não encontrada"),
	
	// Mensagens do serviço de unidades
	
	UNIT_CODE_NOT_INFORMED("unit.code.not.informed", "Código da unidade não informado"),
	INVALID_UNIT_CODE("invalid.unit.code", "Código da unidade informado inválido"),
	NO_UNIT_FOUND("no.unit.found", "Nenhuma unidade encontrada"),
	UNIT_NOT_FOUND("unit.not.found", "Unidade não encontrada"),
	
	// Mensages do serviço de usuários
	
	USER_CODE_NOT_INFORMED("user.code.not.informed", "Código do usuário não informado"),
	INVALID_USER_CODE("invalid.user.code", "Código do usuário informado inválido"),
	EMAIL_NOT_INFORMED("email.not.informed", "Email não informado"),
	PASSWORD_NOT_INFORMED("password.not.informed", "Senha não informada"),
	INVALID_EMAIL("invalid.email", "Email informado inválido"),
	USER_NOT_FOUND("user.not.found", "Usuário não encontrado"),
	INVALID_USERNAME_OR_PASSWORD("invalid.username.or.password", "Usuário / Senha inválidos"),
	INVALID_RETRY_USERNAME_OR_PASSWORD("invalid.retry.username.or.password", "Usuário / Senha inválidos, tentativa %d / %d"),
	INVALID_PASSWORD_FORMAT("invalid.password.format", "Formato da senha informada inválido"),
	USER_INACTIVE("user.inactive", "Usuário inativo"),
	USER_BLOCKED("user.blocked", "Usuário bloqueado"),
	
	// Mensages do serviço de funcionalidades de perfis
	
	ROLE_NOT_INFORMED("role.not.informed", "Perfil não informado"),
	INVALID_ROLE_CODE("invalid.role.code", "Código do perfil informado inválido"),
	
	// Mensagens do serviço de transações

	NSU_TERMINAL_NOT_INFORMED("nsu.terminal.not.informed", "NSU do terminal não informado"),
	NSU_TERMINAL_NOT_FOUND("nsu.terminal.not.found", "NSU do terminal não encontrado"),
	TERMINAL_STATUS_NOT_FOUND("terminal.status.not.found", "Status do terminal não encontrado"),
	TRANSACTION_AMOUNT_NOT_INFORMED("transaction.amount.not.informed", "Valor da transação não informado"),
	INVALID_TRANSACTION_AMOUNT("invalid.transaction.amount", "Valor da transação informado inválido"),
	TERMINAL_CODE_NOT_INFORMED("terminal.code.not.informed", "Código do terminal não informado"),
	FUNCTIONALITY_CODE_NOT_INFORMED("functionality.code.not.informed", "Código da funcionalidade não informado"),
	INVALID_FUNCTIONALITY_CODE("invalid.functionality.code", "Código da funcionalidade informado inválido"),
	
	// Mensagens da abertura de terminal

	ACCOUNTING_DATE_NOT_INFORMED("accounting.date.not.informed", "Data contábil não informada não informado"),
	INVALID_ACCOUNTING_DATE("invalid.accounting.date", "Data contábil informada inválida"),
	
	// Mensagens do serviço de detalhes de depoósito

	DEPOSIT_DETAIL_QUANTITY_NOT_INFORMED("deposit.detail.quantity.not.informed", "Quantidade de notas do detalhe do depósito não informado"),
	INVALID_DEPOSIT_DETAIL_QUANTITY("invalid.deposit.detail.quantity", "Quantidade de notas do detalhe do depósito informado inválido"),
	DEPOSIT_DETAIL_AMOUNT_NOT_INFORMED("deposit.detail.amount.not.informed", "Valor do detalhe do depósito não informado"),
	INVALID_DEPOSIT_DETAIL_AMOUNT("invalid.deposit.detail.amount", "Valor do detalhe do depósito informado inválido"),
	DEPOSIT_DETAIL_DATE_TIME_NOT_INFORMED("deposit.detail.date.time.not.informed", "Data e hora do depósito não informados"),
	
	// Mensagens da reimpressão de comprovantes

	INVALID_NSU_FORMAT("invalid.nsu.format", "NSU informado inválido"),
	INITIAL_DATE_NOT_INFORMED("initial.date.not.informed", "Data inicial para pesquisa não informada"),
	INVALID_INITIAL_DATE("invalid.initial.date", "Data inicial informada inválida"),
	FINAL_DATE_NOT_INFORMED("final.date.not.informed", "Data final para pesquisa não informada"),
	INVALID_FINAL_DATE("invalid.final.date", "Data final informada inválida"),
	INITIAL_DATE_GREATER_THAN_FINAL("initial.date.greater.than.final", "Data inicial informada maior que a data final"),
	
	// Mensagens do serviço de impressoras

	OPEN_PRINTER_FAILED("open.printer.failed", "Falha na abertura da impressora : %s"),
	CLOSE_PRINTER_FAILED("close.printer.failed", "Falha no fechamento da impressora : %s"),
	PRINT_DOCUMENT_FAILED("print.document.failed", "Falha na impressão do documento : %s"),
	PAPER_CUT_FAILED("paper.cut.failed", "Falha no corte do papel : %s"),
	PRINTER_RESET_FAILED("printer.reset.failed", "Falha no reset da impressora : %s"),
	
	// Mensagens do serviço de impressoras

	OPEN_DEPOSITORY_FAILED("open.depository.failed", "Falha na abertura do depositário : %s"),
	CLOSE_DEPOSITORY_FAILED("close.depository.failed", "Falha no fechamento do depositário : %s"),
	
	// Mensagens do serviço de placa de sensores

	OPEN_SENSORS_FAILED("open.sensors.failed", "Falha na abertura da placa de sensores : %s"),
	CLOSE_SENSORS_FAILED("close.sensors.failed", "Falha no fechamento da placa de sensores : %s"),
	ENABLE_SENSORS_FAILED("enable.sensors.failed", "Falha na habilitação dos sensores : %s"),
	DISABLE_SENSORS_FAILED("disable.sensors.failed", "Falha na desabilitação dos sensores : %s"),
	RESET_SENSORS_FAILED("reset.sensors.failed", "Falha na inicialização dos sensores : %s"),
	GET_SENSORS_FAILED("get.sensors.failed", "Falha na obtenção do status dos sensores : %s"),
	WRITE_MASK_FAILED("write.mask.failed", "Falha na gravação da máscara dos sensores : %s"),
	READ_MASK_FAILED("read.mask.failed", "Falha na leitura da máscara dos sensores : %s"),
	
	// Mensagens do serviço de parâmetros
	
	PARAMETER_CODE_NOT_INFORMED("parameter.code.not.informed", "Código do parâmetro não informado"),
	PARAMETER_NOT_FOUND("parameter.not.found", "Parâmetro '%s' não encontrado");

	/**
	 * Declaração das variáveis membro
	 */
	
	private String key;
	private String description;

	/**
	 * Construtor default da enumeração.
	 * 
	 * @param key - Identificador único da mensagem do arquivo de propriedades.
	 * @param description - Descrição da chave de mensagem.
	 */
	
	MessageKeys(String key, String description) {
		this.key = key;
		this.description = description;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
