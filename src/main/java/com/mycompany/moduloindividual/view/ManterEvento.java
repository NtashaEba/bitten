package com.mycompany.moduloindividual.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.mycompany.moduloindividual.controller.ControllerEvento;
import com.mycompany.moduloindividual.model.been.Evento;

public class ManterEvento {
  public static void menu() throws ClassNotFoundException, SQLException{
    String msgErro = "Modulo Inválido"; 
    String msgMenu = "0 - Sair \n 1 - Inserir \n 2 - Alterar \n 3 - Excluir \n 4 - Buscar \n 5 - Listar" ;

    int modulo = Integer.parseInt(JOptionPane.showInputDialog(msgMenu));

    switch(modulo) {
        case 0:
            int sair = JOptionPane.showConfirmDialog(null, "Deseja Sair");
                if(sair > 0 ) {
                    menu();
                } 
            break;
        case 1:
            inserir();
            break;
        case 2:
            alterar();
            break;
        case 3:
            excluir();
            break;
        case 4:
            buscar();
            break;
        case 5:
            listar();
            break;
        default:
            JOptionPane.showMessageDialog(null, msgErro);
            menu();
            break;
    }
}

private static void inserir() throws ClassNotFoundException, SQLException {
    String data = JOptionPane.showInputDialog("Digite a data do evento");
    String local = JOptionPane.showInputDialog("Digite o local do evento");
    int numero_pessoas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de pessoas"));
    String organizador = JOptionPane.showInputDialog("Digite o organizador do evento");
    String horario = JOptionPane.showInputDialog(null, "Digite o horario do evento");
    
    Evento eveEnt = new Evento(data, local, numero_pessoas, organizador, horario);
    
    ControllerEvento contLav = new ControllerEvento();
    Evento eveSai = contLav.inserir(eveEnt);
    
    JOptionPane.showMessageDialog(null, eveSai.toString());
}

private static void alterar() throws ClassNotFoundException, SQLException {
  int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do evento"));
  String data = JOptionPane.showInputDialog("Digite a data do evento");
  String local = JOptionPane.showInputDialog("Digite o local do evento");
  int numero_pessoas = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de pessoas"));
  String organizador = JOptionPane.showInputDialog("Digite o organizador do evento");
  String horario = JOptionPane.showInputDialog(null, "Digite o horário do evento");
  
  Evento eveEnt = new Evento(id, data, local, numero_pessoas, organizador, horario);
    
  ControllerEvento contLav = new ControllerEvento();
  Evento eveSai = contLav.alterar(eveEnt);
    
  JOptionPane.showMessageDialog(null, eveSai.toString());
}

private static void excluir() throws ClassNotFoundException, SQLException{
    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do evento"));
    
    Evento eveEnt = new Evento(id);
    
    ControllerEvento contLav = new ControllerEvento();
    Evento eveSai = contLav.excluir(eveEnt);
    
    JOptionPane.showMessageDialog(null, eveSai.toString());
}

private static void buscar() throws ClassNotFoundException, SQLException{
    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do evento"));

    Evento eveEnt = new Evento(id);
    
    ControllerEvento contLav = new ControllerEvento();
    Evento eveSai = contLav.buscar(eveEnt);
    
    JOptionPane.showMessageDialog(null, eveSai.toString());
}

private static void listar() throws ClassNotFoundException, SQLException {
    String local = JOptionPane.showInputDialog("Digite o local do evento");

    Evento eveEnt = new Evento(local);
    
    ControllerEvento contLav = new ControllerEvento();
    List<Evento> eveSai = contLav.listar(eveEnt);
    
    for (Evento eve : eveSai) {
        JOptionPane.showMessageDialog(null, eve.toString());
    }
}
}
