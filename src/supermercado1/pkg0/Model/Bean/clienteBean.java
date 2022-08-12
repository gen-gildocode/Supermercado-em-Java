/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

/**
 *
 * @author gildo
 */
public class clienteBean 
{
    private String nome,nuit,email,numbi,pais,bairro,telefone,sexo,cidade,endereco;
    private int ID;

    public clienteBean() {
    }

    public clienteBean(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
    }

    
    public clienteBean(String nome, String nuit, String email, String numbi, String pais, String bairro, String telefone, String sexo, String cidade, String endereco, int ID) {
        this.nome = nome;
        this.nuit = nuit;
        this.email = email;
        this.numbi = numbi;
        this.pais = pais;
        this.bairro = bairro;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cidade = cidade;
        this.endereco = endereco;
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumbi() {
        return numbi;
    }

    public void setNumbi(String numbi) {
        this.numbi = numbi;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}
