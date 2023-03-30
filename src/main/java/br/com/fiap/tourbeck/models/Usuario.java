package br.com.fiap.tourbeck.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "T_TBE_USUARIO")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)    
        private Long id;
        private String nomeCompleto;
        private String sexo;
        private String Email;
        private String cidade;
        
    
        public Usuario() {
        }

        public Usuario(Long id, String nomeCompleto, String sexo, String email, String cidade) {
            this.id = id;
            this.nomeCompleto = nomeCompleto;
            this.sexo = sexo;
            Email = email;
            this.cidade = cidade;
        }


        public Long getId() {
            return id;
        }


        public void setId(Long id) {
            this.id = id;
        }


        public String getNomeCompleto() {
            return nomeCompleto;
        }


        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }


        public String getSexo() {
            return sexo;
        }


        public void setSexo(String sexo) {
            this.sexo = sexo;
        }


        public String getEmail() {
            return Email;
        }


        public void setEmail(String email) {
            Email = email;
        }


        public String getCidade() {
            return cidade;
        }


        public void setCidade(String cidade) {
            this.cidade = cidade;
        }


        @Override
        public String toString() {
            return "Usuario [id=" + id + ", nomeCompleto=" + nomeCompleto + ", sexo=" + sexo + ", Email=" + Email
                    + ", cidade=" + cidade + "]";
        }
    }
