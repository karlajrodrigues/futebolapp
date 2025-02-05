package com.futebol.webapp.dto;

public class PartidaCSV {

    private Integer partidaId;
    private int rodada;
    private String data;
    private String hora;
    private String mandante;
    private String visitante;
    private String tecnico_mandante;
    private  String tecnico_visitante;
    private String vencedor;
    private String arena;
    private String mandante_placar;
    private String visitante_placar;
    private String mandante_estado;
    private String visitante_estado;
    // Getters and setters
    public Integer getPartidaId() {
        return partidaId;
    }
    public void setPartidaId(Integer partidaId) {
        this.partidaId = partidaId;
    }
    public int getRodada() {
        return rodada;
    }
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getMandante() {
        return mandante;
    }
    public void setMandante(String mandante) {
        this.mandante = mandante;
    }
    public String getVisitante() {
        return visitante;
    }
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    

    
    
    public String getVencedor() {
        return vencedor;
    }
    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }
    public String getArena() {
        return arena;
    }
    public void setArena(String arena) {
        this.arena = arena;
    }
    
    public String getTecnico_mandante() {
        return tecnico_mandante;
    }
    public void setTecnico_mandante(String tecnico_mandante) {
        this.tecnico_mandante = tecnico_mandante;
    }

    public String getTecnico_visitante() {
        return tecnico_visitante;
    }

    public void setTecnico_visitante(String tecnico_visitante) {
        this.tecnico_visitante = tecnico_visitante;
    }

    public String getMandante_placar() {
        return mandante_placar;
    }

    public void setMandante_placar(String mandante_placar) {
        this.mandante_placar = mandante_placar;
    }

    public String getVisitante_placar() {
        return visitante_placar;
    }

    public void setVisitante_placar(String visitante_placar) {
        this.visitante_placar = visitante_placar;
    }

    public String getMandante_estado() {
        return mandante_estado;
    }

    public void setMandante_estado(String mandante_estado) {
        this.mandante_estado = mandante_estado;
    }

    public String getVisitante_estado() {
        return visitante_estado;
    }

    public void setVisitante_estado(String visitante_estado) {
        this.visitante_estado = visitante_estado;
    }
    

}
