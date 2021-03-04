/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farroupsmon;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Arthur
 */
public class Personagem {
  
    private String nome;
    private Icon sprite;
    public Ataques[] moves;
    private int hp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int speed;
    private int defOriginal;
    private int spDefOriginal;
    private int hpOriginal;
    private boolean usouHibernar;
    
    private boolean isBot;
    
    public Personagem(String nome) throws LineUnavailableException{
        nome = nome.toLowerCase();
        
        if(nome.equals("diogo")){
            this.nome = "Diogo";
            sprite = new ImageIcon(getClass().getResource("/Fotos/diogoPequeno.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("dose diária de barrinha");
            moves[1] = new Ataques("ataque sonolento");
            moves[2] = new Ataques("não mais um lobo solitário");
            moves[3] = new Ataques("watashi wa diogo-san");
            hp = 90;
            atk = 120;
            def = 70;
            spAtk = 60;
            spDef = 70;
            speed = 120;       
            defOriginal = def;
            spDefOriginal = spDef;     
            hpOriginal = hp;
            usouHibernar = false;
            //530
        }
        else if(nome.equals("braga")){
            this.nome = "Braga";
            sprite = new ImageIcon(getClass().getResource("/Fotos/bragaPequenoRobo.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("disfarce");
            moves[1] = new Ataques("capaci-thor");
            moves[2] = new Ataques("01001001010");
            moves[3] = new Ataques("fórmula de brágara");
            hp = 100;
            atk = 60;
            def = 90;
            spAtk = 110;
            spDef = 80;
            speed = 70;   
            defOriginal = def;
            spDefOriginal = spDef;
            hpOriginal = hp;
            usouHibernar = false;
            //510
        }
        else if(nome.equals("rode")){
            this.nome = "Rode";
            sprite = new ImageIcon(getClass().getResource("/Fotos/rodeGrande.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("porra, ibarra!"); 
            moves[1] = new Ataques("hibernar"); 
            moves[2] = new Ataques("raiva Liberada");
            moves[3] = new Ataques("nelsificação");
            hp = 160;
            atk = 60;
            def = 100;
            spAtk = 60;
            spDef = 85;
            speed = 20;
            defOriginal = def;
            spDefOriginal = spDef;
            hpOriginal = hp;
            usouHibernar = false;
            //485
        }
        else if(nome.equals("ibarra")){
            this.nome = "Ibarra";
            sprite = new ImageIcon(getClass().getResource("/Fotos/euGrande.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("ibadeus"); 
            moves[1] = new Ataques("ibapossessão"); 
            moves[2] = new Ataques("chamado zéfinico"); 
            moves[3] = new Ataques("barra"); 
            hp = 100;
            atk = 60;
            def = 100;
            spAtk = 100;
            spDef = 100;
            speed = 65;
            defOriginal = def;
            spDefOriginal = spDef;
            hpOriginal = hp;
            usouHibernar = false;
            //515
        }
        else if(nome.equals("matheus")){
            this.nome = "Matheus";
            sprite = new ImageIcon(getClass().getResource("/Fotos/matheusGrande.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("camuflagem"); 
            moves[1] = new Ataques("gaita man"); 
            moves[2] = new Ataques("poema trágico"); 
            moves[3] = new Ataques("reforço do rebanho"); 
            hp = 90;
            atk = 120;
            def = 70;
            spAtk = 50;
            spDef = 90;
            speed = 110;
            defOriginal = def;
            spDefOriginal = spDef;
            hpOriginal = hp;
            usouHibernar = false;
            //530
        }
        else if(nome.equals("bruno")){
            this.nome = "Bruno Balas";
            sprite = new ImageIcon(getClass().getResource("/Fotos/brunoGrande.png"));
            moves = new Ataques[4];
            moves[0] = new Ataques("camuflagem"); 
            moves[1] = new Ataques("mete bala"); 
            moves[2] = new Ataques("halls da fama"); 
            moves[3] = new Ataques("dentaduras vampíricas"); 
            hp = 90;
            atk = 50;
            def = 70;
            spAtk = 120;
            spDef = 90;
            speed = 110;
            defOriginal = def;
            spDefOriginal = spDef;
            hpOriginal = hp;
            usouHibernar = false;
            //530
        }
    }
    
    
    public void tirarAccuracy(int n){
        moves[0].tirarAccuracy(n);
        moves[1].tirarAccuracy(n);
        moves[2].tirarAccuracy(n);
        moves[3].tirarAccuracy(n);
    }
    
    public void limiteStats(){
        if(this.atk < 15) this.atk = 15;
        if(this.spAtk < 15) this.spAtk = 15;
        if(this.def < 15) this.def = 15;
        if(this.spDef < 15) this.spDef = 15;
        if(this.speed < 15) this.speed = 15;      
    }
    
    public String getNome(){return this.nome;}
    public Icon getSprite(){return sprite;}
    public int getHp(){return this.hp;}
    public int getAtk(){return this.atk;}
    public int getDef(){return this.def;}
    public int getSpAtk(){return this.spAtk;}
    public int getSpDef(){return this.spDef;}
    public int getSpeed(){return this.speed;}
    public int getDefOriginal() {return this.defOriginal;}
    public int getSpDefOriginal() {return this.spDefOriginal;}
    public int getHpOriginal() {return this.hpOriginal;}
    public boolean getUsouHibernar(){return this.usouHibernar;}
    
    public boolean isBot(){
        return this.isBot;
    }
    
    public void setIsBot(boolean b){
        this.isBot = b;
    }
    
    public void setUsouHibernar(boolean b){
        this.usouHibernar = b;
    }
    
    public void setHp(int hp){this.hp = hp;}
    public void setAtk(int atk){this.atk = atk;}
    public void setDef(int def){this.def = def;}
    public void setSpAtk(int spAtk){this.spAtk = spAtk;}
    public void setSpDef(int spDef){this.spDef = spDef;}
    public void setSpeed(int speed){this.speed = speed;}
    
    
    
}
