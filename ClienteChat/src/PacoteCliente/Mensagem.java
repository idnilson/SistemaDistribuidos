/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteCliente;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author idnil
 */

/*
 Serializable, guando eu 
*/
public class Mensagem implements Serializable
{
    private String nome;
    private String conteudoMsg;
    /*
    armazena um nome de usuário que receberar uma msg do tipo reservada 
    (nome do cliente a qual a msg é direcionada)
    */
    private String nomeReservado;
    
   
    /*
    Lista que vai armazenar todos os usuarios online no chats
    que estão conectatados no servidor
    */
    
    private Set<String> usuariosOnline = new HashSet<String>();
    
    /*
    Action acao: a cada msg que o cliente envia o servidor , 
    ele vai dizer qual é a ação a se fazer (criar conexao, sair 
    do chat, mandar msg resevada, ou para todos e se esta fazendo
    o pedido da lista de usuarios online.)
    */
    private Action acao; 

    public String getNome() {
        return nome;
    }

    public String getConteudoMsg() {
        return conteudoMsg;
    }

    public String getNomeReservado() {
        return nomeReservado;
    }

    public Set<String> getUsuariosOnline() {
        return usuariosOnline;
    }

    public Action getAcao() {
        return acao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }

    public void setNomeReservado(String nomeReservado) {
        this.nomeReservado = nomeReservado;
    }

    public void setUsuariosOnline(Set<String> usuariosOnline) {
        this.usuariosOnline = usuariosOnline;
    }

    public void setAcao(Action acao) {
        this.acao = acao;
    }
    
    
    public enum Action 
    {
        CONECTAR, DESCONECTAR, ENVIE_UMA, ENVIE_TODAS, USUARIOS_ONLINE
    }   
    
    
    
}
