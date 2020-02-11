package br.com.volans.realsafe.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Filtro para recebimento das solicitações de clientes.
 * 
 * @author Volans Informática Ltda.
 */

//@Order(1)
//@Component
public class TokenTranslatorFilter implements Filter {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private static Map<String, String> TOKENS = new LinkedHashMap<String, String>();
	
	static {
		TOKENS.put("environment", System.getProperty("environment"));
	}
	
	/**
	 * Classe para customização dos streams de output.
	 * 
	 * @author Volans Informática Ltda.
	 */
	
	private class ByteArrayServletStream extends ServletOutputStream {
		
		/**
		 * Declaração das variáveis membro
		 */
		
		private ByteArrayOutputStream baos;
		
		/**
		 * Construtor default da classe.
		 * 
		 * @param baos - Instância do stream de saída a ser utilizado.
		 */
		
		public ByteArrayServletStream(ByteArrayOutputStream baos) {
			this.baos = baos;
		}

		/**
		 * Verifica o status de escrita não blocante.
		 */
		
		@Override
		public boolean isReady() {
			return false;
		}

		/**
		 * Determina o listener de escrita a ser utilizado.
		 * 
		 * @param listener - Instância do listener a ser utilizado.
		 */
		
		@Override
		public void setWriteListener(WriteListener listener) {
		}

		/**
		 * Efetua a gravação de um byte na saída.
		 * 
		 * @param b - Byte a ser gravado.
		 */
		
		@Override
		public void write(int b) throws IOException {
			baos.write(b);
		}
		
	}
	
	/**
	 * Classe para customização dos streams de output.
	 * 
	 * @author Volans Informática Ltda.
	 */
	
	private class ByteArrayStreamWriter {
		
		/**
		 * Declaração das variáveis membro
		 */
		
		private ByteArrayOutputStream baos = new ByteArrayOutputStream();
		private PrintWriter writer = new PrintWriter(baos);
		private ServletOutputStream stream = new ByteArrayServletStream(baos);
		
		/**
		 * Retorna a instância da classe PrintWriter.
		 * 
		 * @return - Instância da classe PrintWriter.
		 */
		
		public PrintWriter getWriter() {
			return writer;
		}
		
		/**
		 * Retorna a instância da classe ServletOutputStream.
		 * 
		 * @return - Instância da classe ServletOutputStream.
		 */
		
		public ServletOutputStream getStream() {
			return stream;
		}
		
		/**
		 * Retorna o array de bytes de escrita.
		 * 
		 * @return - Array de bytes.
		 */
		
		public byte[] toByteArray() {
			return baos.toByteArray();
		}
		
	}
	
	/**
	 * Classe para customização da resposta da requisição.
	 * 
	 * @author Volans Informática Ltda.
	 */
	
	private class ResponseWrapper extends HttpServletResponseWrapper {

		/**
		 * Declaração das variáveis membro
		 */
		
		private ByteArrayStreamWriter printer;
		
		/**
		 * Construtor default da classe.
		 * 
		 * @param response - Instância do objeto de resposta original.
		 */
		
		public ResponseWrapper(HttpServletResponse response, ByteArrayStreamWriter printer) {
			super(response);
			this.printer = printer;
		}

		/**
		 * Define o tipo de conteúdo a ser retornado.
		 * 
		 * @param - Tipo de conteúdo.
		 */
		
		@Override
		public void setContentType(String type) {
			super.setContentType(type);
		}
		
		/**
		 * Retorna a instância do writer a ser utilizado.
		 * 
		 * @return - Instância do writer.
		 */
		
		@Override
		public PrintWriter getWriter() throws IOException {
			return printer.getWriter();
		}
		
		/**
		 * Retorna a intância do stream de saída a ser utilizado.
		 * 
		 * @return - Instância do stream de saída.
		 */
		
		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return printer.getStream();
		}
		
		/**
		 * Retorna o array de bytes da resposta.
		 * 
		 * @return - Array de bytes a ser retornado.
		 */
		
		public byte[] getBytes() {
			return printer.toByteArray();
		}
		
	}

	/**
	 * Efetua o tratamento da solicitação.
	 * 
	 * @param request - Instância do objeto ServletRequest.
	 * @param response - Instância do ServletResponse.
	 * @param chain - instância do objeto FilterChain.
	 */
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (!req.getRequestURI().toLowerCase().endsWith("env.js")) {
			chain.doFilter(request, response);
			return;
		}
		
		// Envia a requisição para o próximo filtro.
		
		ResponseWrapper wrapper = new ResponseWrapper(res, new ByteArrayStreamWriter());
		
		chain.doFilter(request, wrapper);
		
		String data = translate(wrapper.getBytes());
		
		OutputStream os = res.getOutputStream();

		res.setContentLength(data.length());
		
		os.write(data.getBytes(StandardCharsets.UTF_8));
		
		os.flush();
		
		res.flushBuffer();
		
	}
	
	/**
	 * Converte os tokens recebidos.
	 * 
	 * @param data - Dados para transformação dos tokens.
	 * 
	 * @return - Dados convertidos.
	 */
	
	private String translate(byte[] bytes) {
		
		String result = new String(bytes);
		
		Set<String> keys = TokenTranslatorFilter.TOKENS.keySet();
		
		for (String key : keys) {
			
			String value = TokenTranslatorFilter.TOKENS.get(key);
			
			String regex = String.format("\\$\\{%s\\}", key);
			
			result = result.replaceAll(regex, value);
			
			
		}
		
		return result;
		
	}

}
