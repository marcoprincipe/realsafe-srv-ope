package br.com.volans.realsafe.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.HealthDAO;
import br.com.volans.realsafe.dto.HealthDTO;
import br.com.volans.realsafe.exception.SystemException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.HealthService;

/**
 * Implementação da interface do serviço de checagem do banco de dados.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class HealthServiceImpl extends AbstractService implements HealthService {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Value("${app.name}")
	private String name;
	
	@Value("${app.version}")
	private String version;
	
	private HealthDAO healthDAO;
	
	/**
	 * Construtor default da classe.
	 * 
	 * @param healthDAO - Instância do DAO de checagem do banco de dados.
	 */
	
	@Autowired
	public HealthServiceImpl(HealthDAO healthDAO) {
		this.healthDAO = healthDAO;
	}
	
	/**
	 * Efetua a validação do estado da aplicação.
	 * 
	 * @return - Objeto com os dados da verificação.
	 * 
	 * @throws SystemException - Exceção do sistema.
	 */
	
	@Override
	public HealthDTO checkHealth() throws SystemException {
		
		try {
			
			HealthDTO result = new HealthDTO();
			
			Timestamp timeStamp = healthDAO.selectTimeStamp();
			
			result.setName(name);
			result.setVersion(version);
			result.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeStamp));
			
			return result;
			
		}
		catch (DataAccessResourceFailureException ex) {
			
			if (ex.getCause() instanceof JDBCConnectionException) {
				throw new SystemException(getMessage("db.connection.failure"));
			}
			
			throw new SystemException(getMessage("unknown.error"));
			
		}
		
	}

}
