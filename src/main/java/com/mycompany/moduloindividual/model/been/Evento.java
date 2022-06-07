package com.mycompany.moduloindividual.model.been;

public class Evento {
  private int id;
  private String data;
  private String local;
  private int numero_pessoas;
  private String organizador;
  private String horario;
  
  public Evento(int id) {
    this.id = id;
  }

  public Evento(int id, String data, String local, int numero_pessoas, String organizador, String horario) {
    this.id = id;
    this.data = data;
    this.local = local;
    this.numero_pessoas = numero_pessoas;
    this.organizador = organizador;
    this.horario = horario;
  }

  public Evento(String data, String local, int numero_pessoas, String organizador, String horario) {
    this.data = data;
    this.local = local;
    this.numero_pessoas = numero_pessoas;
    this.organizador = organizador;
    this.horario = horario;
  }

  public Evento(String local) {
    this.local = local;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public int getNumero_pessoas() {
    return numero_pessoas;
  }

  public void setNumero_pessoas(int numero_pessoas) {
    this.numero_pessoas = numero_pessoas;
  }

  public String getOrganizador() {
    return organizador;
  }

  public void setOrganizador(String organizador) {
    this.organizador = organizador;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }

  @Override
  public String toString() {
    return "Evento [data=" + data + ", horario=" + horario + ", id=" + id + ", local=" + local + ", numero_pessoas="
        + numero_pessoas + ", organizador=" + organizador + "]";
  }

  
}
