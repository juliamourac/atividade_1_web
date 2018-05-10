/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.beans;

/**
 *
 * @author 619655
 */
public class Hotel {
    String cnpj;
    String nome;
    String cidade;
    String senha;
    
    public String getSenha(){return senha;}
    public void setSenha(String senha){this.senha = senha;}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
        
}
