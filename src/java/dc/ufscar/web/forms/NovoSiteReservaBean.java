/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.forms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 619655
 */
public class NovoSiteReservaBean {
    String url;
    String nome;
    String telefone;
    String senha;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();
        
        if (url.length() == 0) {
            mensagens.add("URL não pode ser vazia!");
        }
        
        if (nome.length() == 0) {
            mensagens.add("O nome não pode ser vazio!");

            try {
                Integer.parseInt(telefone);
            } catch (Exception e) {
                mensagens.add("O telefone deve ser um número");
            }
        }
        
        if (senha.length() == 0) {
            mensagens.add("A senha não pode ser vazia");
        }

        return mensagens;
    }
}
