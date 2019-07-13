package br.com.zen.teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.zen.dao.PecasDAOImpl;
import br.com.zen.model.TbPecas;

public class Application {

	public static void main(String[] args) {
		System.out.println("-------- Oracle MySQL Connection Testing ------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/zen_schema?useTimezone=true&serverTimezone=America/Sao_Paulo", "gazambuja",
					"root");
			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				try {
					Statement stmt = connection.createStatement();
					ResultSet results = stmt.executeQuery("SELECT * FROM tb_pecas");

					// Create session to use hibernate
					//SessionFactory sessionFactory;
					//sessionFactory = new Configuration().configure().buildSessionFactory();
					//Session session = sessionFactory.openSession();

					while (results.next()) {
						String encodedPedidos = results.getString("NOME");
						System.out.println("Pedido vindo do banco: " + encodedPedidos + "\n");
					}
					
					//Tabela pecas, persistir
					TbPecas tbPeca = new TbPecas();
					BigDecimal pesoBruto = new BigDecimal("2.60");
					BigDecimal pesoLiquido = new BigDecimal("1.00");
					tbPeca.setNome("Impulsor de teste");
					tbPeca.setVeiculoAplicacao("KA");
					tbPeca.setPesoBruto(pesoBruto);
					tbPeca.setPesoLiquido(pesoLiquido);

					PecasDAOImpl pecasDAO = new PecasDAOImpl();
					pecasDAO.salvarPeca(tbPeca);
					//tbPecaBanco = pecasDAO.getPecaById(5L);
					//pecasDAO.removerPeca(tbPecaBanco);
					pecasDAO.getTodasPecas();
					
					System.out.println("Valor recuperado: " + pecasDAO.getTodasPecas());
									
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
}