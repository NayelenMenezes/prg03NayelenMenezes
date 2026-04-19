/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.ifba.atividade08;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @author mealf
 */
public class MainTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //cria perfil
        PerfilUsuario perfil = new PerfilUsuario (1L, "Administrador", Arrays.asList("Ler", "Gravar", "Excluir"));
        
        //cria usuario
        Usuario usuario = new Usuario(100L, perfil, "Ana_Paula", "aninha88@email.com", "123456", null, true);
        
        //testa o login e cria dependencias
        if (usuario.getSenha().equals("123456")){
            //gera log
            LogAuditoria log = new LogAuditoria(500L, usuario, "tentativa de login", LocalDateTime.now(), "199.999.0.1");
        
            //gera sessão
            Sessao sessao = new Sessao(320L, usuario, "tok-aB-001");
            System.out.println("Login realizado com sucesso!");
            System.out.println(log.toString());
            System.out.println(sessao.toString());
        }
    }
    
}
