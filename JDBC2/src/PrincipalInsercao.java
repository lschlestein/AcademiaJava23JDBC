import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrincipalInsercao {

	public static void main(String[] args) {
		String db_query = "jdbc:mysql://localhost:3306/reuniao";
		String db_user = "root";
		String db_password = "";

		try (Connection c = DriverManager.getConnection(db_query, db_user, db_password)) {// conexão ao banco de dados
			PreparedStatement ps = c.prepareStatement("INSERT INTO PESSOA VALUES (?,?,?,?)");// carrega um PreparedStatement com 4 parâmetros (?;?;?;?)
			ps.setInt(1, 0);//parâmetro 1
			ps.setString(2, "Ronaldo");//parâmetro 2
			ps.setString(3, "joao@mail.com");//parâmetro 3
			ps.setString(4, "Professor");//parâmetro 4
			System.out.println("Afetou x linhas:" + ps.executeUpdate());// executa a inserção no Banco de dados

		} catch (Exception e) {
			System.out.println("Problema na inserção:" + e);

		}

	}
}
