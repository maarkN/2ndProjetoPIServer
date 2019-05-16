/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;
import modelos.CRUD;
import modelos.Contato;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author eugenio
 */
public class ContatoPersistencia implements CRUD{
    private String nomeDoArquivoNoDisco=null;
    
    public ContatoPersistencia(String nomeDoArquivoNoDisco){
        this.nomeDoArquivoNoDisco = nomeDoArquivoNoDisco;
    }
    @Override
    public void incluir(Contato objeto) throws Exception {
      try{
         //cria o arquivo
         FileWriter fw = new FileWriter(nomeDoArquivoNoDisco,true);
         //Criar o buffer do arquivo
         BufferedWriter bw =new BufferedWriter(fw);
         //Escreve no arquivo
         bw.write(objeto.desmontarObjeto()+"\n");
         //fecha o arquivo
         bw.close();		
      }catch(Exception erro){
         throw erro;
      }
    }
    

   //@Override
   public ArrayList<Contato> recuperar() throws Exception {
      try{
         ArrayList<Contato> pilhaDeContatos = new ArrayList<Contato>();
         FileReader fr = new FileReader(nomeDoArquivoNoDisco);
         BufferedReader br  = new BufferedReader(fr);
         String linha = "";
         while((linha=br.readLine())!=null){
                Contato objetoContato = new Contato();
                objetoContato.montarObjeto(linha);
                pilhaDeContatos.add(objetoContato);
            }
         br.close();
         return pilhaDeContatos;
      }catch(Exception erro){
         throw erro;
      }
   }
}
