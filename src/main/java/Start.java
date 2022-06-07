import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mycompany.moduloindividual.view.ManterEvento;

public class Start {
  static String  msgErroSis = "Opcao Invalido"; 
    static String  msgErroUsu = "Usuario Invalido"; 

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
           menu();
    }
        
    public static void menu() throws SQLException, ClassNotFoundException{
            int ops = Integer.parseInt(JOptionPane.showInputDialog("Deseja ficar? \n 0 - Não \n 1 - Sim"));
            switch(ops) {
                case 0: 
                    int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                    if(sair > 0 ) {
                        menu();
                    } 
                    break;
                case 1:
                    ManterEvento.menu();
                    menu();
                    break;
            default:
                    JOptionPane.showMessageDialog(null, msgErroSis);
                    menu();
                    break;
        }
   }
}
