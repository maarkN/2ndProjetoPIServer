/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import persistencia.ContatoPersistencia;
import modelos.Contato;
/**
 *
 * @author eugeniojulio
 */
public class ControlePersistencia {
    
    public void executarOrdem(String dados)throws Exception{
        String[] informacao = dados.split("#");
        switch(informacao[0]){
            case "Contato": controlePersistenciaContato(informacao[1], informacao[2]);
            break; 
    }
    }
   
    public void controlePersistenciaContato(String opcao,String dados)throws Exception{
        ContatoPersistencia contatoPersistencia = new ContatoPersistencia("Contato.txt");
        switch(opcao){
            case "1":
                Contato objetoContato = new Contato();
                objetoContato.montarObjeto(dados);
                contatoPersistencia.incluir(objetoContato);
            }
    }
}
