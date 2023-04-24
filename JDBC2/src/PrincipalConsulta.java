import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PrincipalConsulta {

	public static void main(String[] args) {
		String db_query = "jdbc:mysql://localhost:3306/reuniao";
		String db_user = "root";
		String db_password = "";

		try (Connection c = DriverManager.getConnection(db_query, db_user, db_password)) {// conexão ao banco de dados
			System.out.println("Conectado!!!");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM PESSOA");// envia a query ao Prepared Statement

			ResultSet resultSet = ps.executeQuery();// execusta a query, configurada acima e carrega os resultados ao
													// resultSet
			ResultSetMetaData metaData = resultSet.getMetaData();// Carrega o nome das coluna do resultSet

			int numberOfColumns = metaData.getColumnCount();// verifica o número de colunas no resultSet

			System.out.printf("Resultado da pesquisa:%n%n");

			// exibe os nomes de coluna no ResultSet
			for (int i = 1; i <= numberOfColumns; i++)
				System.out.printf("%-25s\t", metaData.getColumnName(i));
			System.out.println();
			// exibie o contéudo das colunas no console
			while (resultSet.next()) {// verifica se existem linhas no resultSet, se existe avança o cursor para
										// próxima linha
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.printf("%-25s\t", resultSet.getObject(i));// Varre tantas quantas forem as colunas, da
																			// linha do resultSet
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println("Falha na conexão com o BD " + e);
		}

	}
}
