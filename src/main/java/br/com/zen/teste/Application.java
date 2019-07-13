package br.com.zen.teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.zen.dao.PecasDAOImpl;
import br.com.zen.model.TbPecas;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
	
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("-------- Oracle MySQL Connection Testing ------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		logger.info("MySQL JDBC Driver Registered!");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/zen_schema?useTimezone=true&serverTimezone=America/Sao_Paulo", "gazambuja",
					"root");
			if (connection != null) {
				logger.info("You made it, take control your database now!");
				try {
					Statement stmt = connection.createStatement();
					ResultSet results = stmt.executeQuery("SELECT * FROM tb_pecas");

					// Create session to use hibernate
					//SessionFactory sessionFactory;
					//sessionFactory = new Configuration().configure().buildSessionFactory();
					//Session session = sessionFactory.openSession();

					while (results.next()) {
						String encodedPedidos = results.getString("NOME");
						logger.info("Pedido vindo do banco: " + encodedPedidos + "\n");
					}
					
					//Tabela pecas, persistir
					TbPecas tbPeca = new TbPecas();
					BigDecimal pesoBruto = new BigDecimal("11.00");
					BigDecimal pesoLiquido = new BigDecimal("9.00");
					tbPeca.setNome("Teste peca");
					tbPeca.setVeiculoAplicacao("KA");
					tbPeca.setPesoBruto(pesoBruto);
					tbPeca.setPesoLiquido(pesoLiquido);

					PecasDAOImpl pecasDAO = new PecasDAOImpl();
					pecasDAO.salvarPeca(tbPeca);
					//tbPecaBanco = pecasDAO.getPecaById(5L);
					//pecasDAO.removerPeca(tbPecaBanco);
					pecasDAO.getTodasPecas();
					
					logger.info("Valor recuperado: " + pecasDAO.getTodasPecas());
									
					connection.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				logger.error("Failed to make connection!");
			}

		} catch (SQLException e) {
			logger.error("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
}