package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public String getNome(){
        return this.nome;
    }
    public Double getMensalidade(){
        return this.mensalidade;
    }
    public Integer getQtdAluno(){
        return this.qtdAluno;
    }

    public Boolean getAtiva() {
        return this.ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma(String nome, Double mensalidade){
        setNome(nome);
        this.mensalidade = mensalidade;
        qtdAluno = 0;
        ativa = true;
    }

    public void matricular(Integer qtd){
        if(qtd != null && qtd > 0 && ativa == true){
            qtdAluno += qtd;
        }
    }
    public Integer cancelar(Integer qtd){
        if(qtd != null && qtd > 0 && qtd <= qtdAluno && ativa == true){
            qtdAluno -= qtd;
            return qtd;
        }
        else {
            return null;
        }
    }
    public Integer desativar(){
        if(ativa == false){
            return null;
        }
        else {
            ativa = false;
            int quantidade = qtdAluno;
            qtdAluno = 0;
            return quantidade;
        }
    }
    public void transferir(Turma destino, Integer qtdAtransferir){
        if(destino != null && destino.ativa == true && qtdAtransferir != null && qtdAtransferir > 0 && qtdAtransferir <= this.qtdAluno && this.ativa == true){
            destino.qtdAluno += qtdAtransferir;
            this.qtdAluno -= qtdAtransferir;
        }
    }
    public Boolean reajustarMensalidade(Double reajuste){
        if(reajuste != null && reajuste > 0){
            reajuste = mensalidade * 0.15;
            mensalidade += reajuste;
            return true;
        }
        else {
            return false;
        }
    }
}
