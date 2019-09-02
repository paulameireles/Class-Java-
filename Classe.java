import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Time{

	//variaveis privadas da classe//
	private String nome, apelido, estadio, tecnico,liga, nomeArq, fundacao;
	private int capacidade;
	private long paginaTam;

	public Time(){

		//sets para guardar info
		this.setNome("");
		this.setApelido("");
		this.setEstadio("");
		this.setTecnico("");
		this.setLiga("");
		this.setNomeArq("");
		this.setCapacidade(0);
		this.setFundacao("");
		this.setPaginaTam(0);
	}

	public Time(String nome, String apelido, String estadio, String tecnico, String liga,
	String nomeArq, int capacidade, String fundacao, long paginaTam){
		//sets p guardar info
		this.setNome(nome);
		this.setApelido(apelido);
		this.setEstadio(estadio);
		this.setTecnico(tecnico);
		this.setLiga(liga);
		this.setNomeArq(nomeArq);
		this.setCapacidade(capacidade);
		this.setFundacao(fundacao);
		this.setPaginaTam(paginaTam);
	}

	//getters e setters 

	public String getNome(){
		return this.nome;
	}

	public String getApelido (){
		return this.apelido;
	}

	public String getEstadio (){
		return this.estadio;
	}

	public String getTecnico (){
		return this.tecnico;
	}

	public String getLiga (){
		return this.liga;
	}

	public String getNomeArq (){
		return this.nomeArq;
	}

	public int getCapacidade (){
		return this.capacidade;
	}

	public String getFundacao (){
		return this.fundacao;
	}

	public long getPaginaTam (){
		return this.paginaTam;
	}

	public void setNome (String nome){
		this.nome = nome;
	}

	public void setApelido (String apelido){
		this.apelido = apelido;
	}

	public void setEstadio (String estadio){
		this.estadio = estadio;
	}

	public void setTecnico (String tecnico){
		this.tecnico = tecnico;
	}

	public void setLiga (String liga){
		this.liga = liga;
	}

	public void setNomeArq (String nomeArq){
		this.nomeArq = nomeArq;
	}

	public void setCapacidade (int capacidade){
		this.capacidade = capacidade;
	}

	public void setFundacao (String fundacao){
		this.fundacao = fundacao;
	}

	public void setPaginaTam (long paginaTam){
		this.paginaTam = paginaTam;
	}

	public Time clone(){
		Time newT = new Time();

		newT.setNome(getNome());
		newT.setApelido(getApelido());
		newT.setEstadio(getEstadio());
		newT.setTecnico(getTecnico());
		newT.setLiga(getLiga());
		newT.setNomeArq(getNomeArq());
		newT.setCapacidade(getCapacidade());
		newT.setFundacao(getFundacao());
		newT.setPaginaTam(getPaginaTam());

		return newT;
	}
	public void printAll(){
		System.out.println(this.nome + " ## " + this.apelido + " ## " + this.estadio + " ## " + this.tecnico + " ## " + this.liga + " ## " + this.nomeArq
			+ " ## " + this.capacidade + " ## " + this.fundacao + " ## " + this.paginaTam);
	}

	public String ler(String path)throws Exception{
		
		FileReader file = new FileReader(path);
		BufferedReader br = new BufferedReader(file);
		long pagt = new File(path).length();
		String line = br.readLine();

		setNomeArq(path);

		if(path.equals("/tmp/times/Frosinone_Calcio.html")){
			while(!line.contains("vcard")){
				line = br.readLine();
			}
			String a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;

			
		}else if(path.equals("/tmp/times/Juventus_F.C..html")){
			while(!line.contains("vcard")){
				line = br.readLine();
				
			}
			String a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			a = br.readLine();
			line = line + a;
			
		}else{
			while(!line.contains("vcard")){
				line = br.readLine();
				
			}
			if(!(line.contains("ull name") && line.contains("ickname") && line.contains("ounded") && line.contains("round") && line.contains("eague"))){
				String a = br.readLine();
				line = line + a;
				
			}
		}

		//System.out.println(pagt);
		setPaginaTam(pagt);

		return line;
	}

	public void criarTime(String path){
		
		int i = 0, a = 0, b = 0;
		String nNome = "", nApelido = "", nFundacao = "", nEstadio = "", nCapacidade = "", nTecnico = "", nLiga = "";
	
		while(i < 7){
			if(i == 0){
				if(path.contains("ull name")){
					a = path.indexOf("ull name");
					String nome = path.substring(a);
					a = nome.indexOf("ull name") + 8;
					b = nome.indexOf("text-align:left") + 17; 
					nNome = nome.substring(a,b);
					nNome = limpaTags(nNome);
					//System.out.println(nNome);
					setNome(nNome);
				}
			}
			if(i == 1){
				if(path.contains("ickname")){
					a = path.indexOf("ickname");
					String apelido = path.substring(a);
					a = apelido.indexOf("ickname")+10;
					b = apelido.indexOf("text-align:left") + 17;
					nApelido = apelido.substring(a,b);
					nApelido = limpaTags(nApelido);
					//System.out.println(nApelido);
					setApelido(nApelido);
				}
			}
			if(i == 2){
				if(path.contains("ounded")){
					a = path.indexOf("ounded") + 6;
					String fundacao = path.substring(a);
					a = fundacao.indexOf("ounded") + 6;
					b = fundacao.indexOf("text-align:left") + 17;
					nFundacao = fundacao.substring(a,b);
					nFundacao = limpaTags(nFundacao);
					setFundacao(nFundacao);
					//tratarData(nFundacao);
				}
			}
			if(i ==3){
				if(path.contains("round")){
					a = path.indexOf("round");
					String estadio = path.substring(a);
					a = estadio.indexOf("round") + 5;
					b = estadio.indexOf("text-align:left") + 17;
					nEstadio = estadio.substring(a,b);
					nEstadio = limpaTags(nEstadio);
					//System.out.println(nEstadio);
					setEstadio(nEstadio);
				}
			}
			if(i == 4){
				if(path.contains("apacity")){
					a = path.indexOf("apacity");
					String capacidade = path.substring(a);
					//System.out.println(capacidade);
					a = capacidade.indexOf("apacity") +7;
					b = capacidade.indexOf("text-align:left") + 17;
					nCapacidade = capacidade.substring(a,b);
					//System.out.println(nCapacidade);
					if (nCapacidade.contains("1&#93")) {
						nCapacidade = nCapacidade.replace("1&#93", "");	
					}
					nCapacidade = nCapacidade.replace(",", "");
					nCapacidade = nCapacidade.replace(".", "");
					
					nCapacidade = limpaTags(nCapacidade);
					int aux = trataCapacidade(nCapacidade);
					//System.out.println(aux);
					setCapacidade(aux);
				}
			}
			if(i == 5){
				if(path.contains("oach")){
					a = path.indexOf("oach");
					String tecnico = path.substring(a);
					a = tecnico.indexOf("oach") + 4;
					b = tecnico.indexOf("text-align:left") + 17;
					nTecnico = tecnico.substring(a,b);
					nTecnico = limpaTags(nTecnico);
					//System.out.println(nTecnico);
					setTecnico(nTecnico);
				}else if(path.contains("Manager")){
					a = path.indexOf("Manager");
					String tecnico = path.substring(a);
					a = tecnico.indexOf("Manager") + 7;
					b = tecnico.indexOf("text-align:left") + 17;
					nTecnico = tecnico.substring(a,b);
					nTecnico = limpaTags(nTecnico);
					nTecnico = nTecnico.replace(" ", "");
					//System.out.println(nTecnico);
					setTecnico(nTecnico);
				}
			}
			if(i == 6){
				if(path.contains("eague")){
					a = path.indexOf("eague");
					String liga = path.substring(a);
					a = liga.indexOf("eague") + 5;
					b = liga.indexOf("text-align:left") + 17;
					nLiga = liga.substring(a,b);
					nLiga = limpaTags(nLiga);
					//System.out.println(nLiga);
					setLiga(nLiga);
				}
			}
			i++;
		}
		//System.out.println("=============================================================");
		Arq.close();
	}

	public static int trataCapacidade(String path){

		String num = "";
		int i = 0;

		path = path.replace("(", ";");	
		path = path.replace(" ", ";");
		String [] info = path.split(";");
		//System.out.println(info[0]);
		if(info[0].length() <= 5){
			i = Integer.parseInt(info[0]);
		}else{
			num += info[0].charAt(0);
			num += info[0].charAt(1);
			num += info[0].charAt(2);
			num += info[0].charAt(3);
			num += info[0].charAt(4);
			i = Integer.parseInt(num);
		}

		return i;
	}

	public void tratarData(String data){

        String linha = data;
        String newData = "";
        String fundacaoDia = "";
        String fundacaoMes = "";
        String fundacaoAno = "";
        String array[] = new String[3];
        int a = 0;
        int b = 0;

        newData = data.replaceAll("<.*?>", "");
        data = newData.replaceAll("&#.*?;", "");
    }

/*
	public static String arrumaData(String path){

	}*/

	public static String limpaTags (String a){

		String linhatratada = "";
		a = a.replaceAll("<.*?>","");
		a = a.replaceAll("&#91;1&#93;", ""); 
		a = a.replaceAll("&#91", ""); 
		a = a.replaceAll("&[^;]+;","");
		//String info [] = a.split(";");//separa a string
		//a = a.replaceAll("(.*?)","");

		return a;
	}
}

public class Classe{

	public static void main(String[]args) throws Exception{

		MyIO.setCharset("UTF-8");
		Time t = new Time();

		String input = "";
		//System.out.println(input);
		input = MyIO.readLine();
		while(!input.equals("FIM")){
				
			System.out.println(input);
			String a = t.ler(input);
			t.criarTime(a);
			t.printAll();	
			input = MyIO.readLine();
		}
	}	
}