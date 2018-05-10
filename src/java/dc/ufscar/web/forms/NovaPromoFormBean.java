/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc.ufscar.web.forms;

import dc.ufscar.web.dao.SiteReservaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juliamourac
 */
public class NovaPromoFormBean {
    private String url;
    private String cnpj;
    private String preco;
    private String dataInicio;
    private String dataFim;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    //VALIDAÇÃO
    public List<String> validar(){
       List <String> mensagens = new ArrayList<String>();
       //SiteReservaDAO srdao = new SiteReservaDAO(dataSource);
       
       //verifica se URL está vazia
       if(url.length()==0)
           mensagens.add("URL não pode ser vazia!");
       //verifica se o CNPJ está vazio
       if(cnpj.length()==0){
           mensagens.add("CNPJ não pode ser vazio!");
       }else if (cnpj.length()!= 14){
          mensagens.add("O CNPJ deve ter 14 dígitos!");          
       }else{
            //verifica se o cnpj é formado somente de números
            try {
                Integer.parseInt(cnpj);
            } catch (Exception e) {
                mensagens.add("O CNPJ deve ser formado somente de números!");
            }
        }
       
       //verifica se o campo preço está vazio
       if(preco.length()==0)
           mensagens.add("O preço não pode ser vazio");
       else{
           //verifica se preço é float (um número)
           try {
               Float.parseFloat(preco);
           } catch (Exception e) {
               mensagens.add("O preço deve ser um número");
           }                   
       }
       
       //verifica se data de início está vazia
       if (dataInicio.length()==0)
           mensagens.add("A data de início não pode ser vazia");
       
       //verifica se data final está vazia
       if(dataFim.length() == 0)
           mensagens.add("A data final não pode ser vazia!");
       
       return mensagens;
    }
}
