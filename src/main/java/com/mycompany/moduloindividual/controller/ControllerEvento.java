package com.mycompany.moduloindividual.controller;

import java.sql.SQLException;
import java.util.List;

import com.mycompany.moduloindividual.model.been.Evento;
import com.mycompany.moduloindividual.model.dao.DaoEvento;

public class ControllerEvento {
   public Evento inserir(Evento eve) throws ClassNotFoundException, SQLException{
        DaoEvento daoLav = new DaoEvento();
        return daoLav.inserir(eve);
    }
    
    public Evento buscar(Evento eve) throws ClassNotFoundException, SQLException{
        DaoEvento daoLav = new DaoEvento();
        return daoLav.buscar(eve);
    }
    
    public List<Evento> listar(Evento eve) throws ClassNotFoundException, SQLException{
        DaoEvento daoLav = new DaoEvento();
        return daoLav.listar(eve);
    }
    
    public Evento excluir(Evento eve) throws ClassNotFoundException, SQLException{
        DaoEvento daoLav = new DaoEvento();
        return daoLav.excluir(eve);
    }
    
    public Evento alterar(Evento eve) throws ClassNotFoundException, SQLException{
        DaoEvento daoLav = new DaoEvento();
        return daoLav.alterar(eve);
    }
}
