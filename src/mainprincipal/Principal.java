/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainprincipal;
import comunicacao.ServidorTCP;
import javax.swing.JOptionPane;
import controle.ControlePersistencia;
/**
 *
 * @author eugeniojulio
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        ServidorTCP servidor = new ServidorTCP(7777);
        
        while(true){
            String dados = servidor.receberMensagem();
            ControlePersistencia executa = null;
            executa = new ControlePersistencia();
            executa.executarOrdem(dados);
            System.out.println(dados);
            servidor.enviarMensagem("incluido com sucesso");
        }
    }
}
