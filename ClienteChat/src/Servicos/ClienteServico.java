/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import PacoteCliente.Mensagem;
/**
 *
 * @author idnil
 */
public class ClienteServico 
{
    private Socket socket;
    private ObjectOutputStream enviomsg;
    private ObjectInputStream recebemsg;
    
    public Socket conectar()
    {
        try {
            this.socket = new Socket("localhost", 8888);
            this.enviomsg = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //retorna o IP da maquina q contem o servidor na aplicação usuario
        return socket;
    }
    
    public  void envio (Mensagem mensagem )
    {
        
        try {
            enviomsg.writeObject(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(ClienteServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
