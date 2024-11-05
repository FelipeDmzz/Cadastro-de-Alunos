package org.example;

public class Estagio {
    private String local;
    private int id;
    private String supervisor;
    private String horarios;
    private String instituicao;
    private String endereco;
    private String periodo;

// mesma alteração que na classe aluno aqui
    public Estagio() {
        this.local = local;
        this.id = id;
        this.supervisor = supervisor;
        this.horarios = horarios;
        this.instituicao = instituicao;
        this.endereco = endereco;
        this.periodo = periodo;
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


    public void exibirInformacoes() {
        System.out.println("Local: " + local);
        System.out.println("id: " + id);
        System.out.println("Supervisor: " + supervisor);
        System.out.println("Horários: " + horarios);
        System.out.println("Instituição: " + instituicao);
        System.out.println("Endereço: " + endereco);
        System.out.println("Período: " + periodo);
    }

}

