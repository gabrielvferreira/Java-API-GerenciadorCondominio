package br.com.condominio.condominio.enums;

public enum AreasDeServicoEnum {
    SALAOFESTAS("Salão de Festas"),
    PISCINA("Piscina"),
    QUADRA("Quadra");

    private String areaDeServico;

    AreasDeServicoEnum(String areaDeServico){
        this.areaDeServico = areaDeServico;
    }

    public String getAreaDeServico(){
        return this.areaDeServico;
    }
}