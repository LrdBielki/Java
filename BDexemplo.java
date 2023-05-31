import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;

public class BDexemplo {
    public static void main(String[] args) {
        String SQLcriarTabela = "CREATE TABLE pessoa (" +
                "cpf int, nome VARCHAR(60))";
        
        //String SQLInserirDados = "INSERT INTO pessoa (cpf, nome) VALUES (23145712, 'maria maria')";
        //String SQLInserirDados = "INSERT INTO pessoa (cpf, nome) VALUES (735236414, 'joão josé')";

        //String SQLconsultarDados = "SELECT * FROM pessoa";
        //String SQLatualizarDados = "UPDATE pessoa SET nome = 'carlos'";
       // String SQLexcluirDados = "DELETE from pessoa";

        String driver = "jdbc:postgresql://127.0.0.1:5432/DadosGerais";
        Statement st = null;
        //Statement st;
        //ResultSet result;
        
        try (Connection conn = DriverManager.getConnection(driver, "postgres", "Estacio@123")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            //Criação da tabela
            System.out.println("Criando Tabela, aguarde...");
            Statement st = conn.createStatement();
            st.executeUpdate(SQLcriarTabela);
            System.out.println("Tabela criada com sucesso!");
            st.close();
            
          /* // Inserção de dados
            System.out.println("Inserindo dados na Tabela...");
            Statement st = conn.createStatement();
            st.executeUpdate(SQLInserirDados);
            System.out.println("Dados inseridos!");
            st.close();*/
            // Consulta de dados
           /* System.out.println("Consultando dados na Tabela...");
            st = conn.createStatement();
            ResultSet result = st.executeQuery(SQLconsultarDados);
            while (result.next()) {
                System.out.println("----------------------");
                System.out.println("CPF: " + result.getString("cpf"));
                System.out.println("Nome: " + result.getString("nome"));
            }
            result.close();
            st.close();
            */
            //bloco atualiza dados
           /* System.out.println("Atualizando dados na Tabela...");
		st = conn.createStatement();
		st.executeUpdate(SQLatualizarDados);
		System.out.println("Dados atualizados!");
		st.close();
		conn.close();*/
            //fim do bloco atualiza dados
            
            //bloco excluir dados
            /*System.out.println("Excluindo dados na Tabela...");
		st = conn.createStatement();
		st.executeUpdate(SQLexcluirDados);
		System.out.println("Dados Excluídos");
		st.close();
		conn.close();*/
              //fim do bloco excluir dados
        } 
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
