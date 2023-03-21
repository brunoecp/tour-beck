package br.com.fiap.tourbeck.models;

import java.util.Date;

public class Usuario {

        private String nomeCompleto;
        private Date dataNascimento;
        private int contato;
        private String Email;
        private int cep;
        private String endereco;
        private int numero;
        private String bairro;
        private String cidade; 
        private String uf;
    
        public Usuario() {
        }

        public Usuario(String nomeCompleto, Date dataNascimento, int contato, String email, int cep, String endereco,
                int numero, String bairro, String cidade, String uf) {
            this.nomeCompleto = nomeCompleto;
            this.dataNascimento = dataNascimento;
            this.contato = contato;
            Email = email;
            this.cep = cep;
            this.endereco = endereco;
            this.numero = numero;
            this.bairro = bairro;
            this.cidade = cidade;
            this.uf = uf;
        }

        //getters and setters
        public String getNomeCompleto() {
            return nomeCompleto;
        }
        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }
        public Date getDataNascimento() {
            return dataNascimento;
        }
        public void setDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
        public int getContato() {
            return contato;
        }
        public void setContato(int contato) {
            this.contato = contato;
        }
        public String getEmail() {
            return Email;
        }
        public void setEmail(String email) {
            Email = email;
        }
        public int getCep() {
            return cep;
        }
        public void setCep(int cep) {
            this.cep = cep;
        }
        public String getEndereco() {
            return endereco;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        public int getNumero() {
            return numero;
        }
        public void setNumero(int numero) {
            this.numero = numero;
        }
        public String getBairro() {
            return bairro;
        }
        public void setBairro(String bairro) {
            this.bairro = bairro;
        }
        public String getCidade() {
            return cidade;
        }
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
        public String getUf() {
            return uf;
        }
        public void setUf(String uf) {
            this.uf = uf;
        }
    
    }
