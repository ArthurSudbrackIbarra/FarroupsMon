/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farroupsmon;

import java.util.Random;

/**
 *
 * @author Arthur
 */

public class Bot_AI {
    
    private Personagem bot;
    private Personagem enemy;
    private int turns;
    
    public Bot_AI(Personagem bot, Personagem enemy){     
        this.bot = bot;    
        this.enemy = enemy;    
        turns = 0;   
    }
    
    public boolean botIsLowHealth(){
        if(bot.getHp() <= bot.getHpOriginal() * 0.5) return true;
        else return false;
    }
    
    public boolean enemyIsLowHealth(){
        if(enemy.getHp() <= enemy.getHpOriginal() * 0.5) return true;
        else return false;
    }
    
    public boolean botGreaterThan(int atributo1, int atributo2){
        if(atributo1 >= atributo2) return true;
        else return false;
    }
    
    public boolean sumOfEnemyGreaterThanBot(){
        int totalEnemy = enemy.getAtk();
        totalEnemy = totalEnemy + enemy.getDef();
        totalEnemy = totalEnemy + enemy.getSpAtk();
        totalEnemy = totalEnemy + enemy.getSpDef();
        totalEnemy = totalEnemy + enemy.getSpeed();
        
        int totalBot = bot.getAtk();
        totalBot = totalBot + bot.getDef();
        totalBot = totalBot + bot.getSpAtk();
        totalBot = totalBot + bot.getSpDef();
        totalBot = totalBot + bot.getSpeed();
        
        if(totalEnemy > totalBot) return true;
        else return false;       
    }
    
    public int botAtacar(){             
        turns++;
        
        if(bot.getNome().equals("Diogo")){
            
            if(turns == 1 || turns == 2) {             
                return 0;
            }           
            
            int damage1 = (int) Math.ceil((bot.getAtk() * Integer.parseInt(bot.moves[2].getPoder())/7)/enemy.getDef());
            int damage2 = (int) Math.ceil((bot.getSpAtk() * Integer.parseInt(bot.moves[3].getPoder())/7)/enemy.getSpDef());
            
            if(damage1 > damage2){                
                return 2;
            }
            else{
                return 3;
            }       
        }          
        else if(bot.getNome().equals("Braga")){
           
            if(turns == 1) {             
                return 0;
            }   
            else if(enemy.getSpeed() >= bot.getSpeed()){
                return 2;
            }
            else if(turns == 2 || turns == 3){
                return 1;
            }
            else if(enemyIsLowHealth()){
                return 3;
            }
            else if(botGreaterThan(140, bot.getSpAtk())){
                return 1;
            }    
            else return 3;         
        }
        else if(bot.getNome().equals("Ibarra")){
            
            if(turns == 1) {             
                return 0;
            }  
            else if(enemy.getSpeed() >= bot.getSpeed() && bot.getSpeed() > 50){
                return 0;
            }
            else if(sumOfEnemyGreaterThanBot()){
                return 1;
            }
            else return 2;     
        }
        else if(bot.getNome().equals("Rode")){
            
            if(turns == 1 && (enemy.getNome().equals("Bruno Balas") || enemy.getNome().equals("Ibarra") || enemy.getNome().equals("Braga"))){
                return 3;
            }
            else if(botGreaterThan(bot.getHp(), (int) Math.ceil(bot.getHpOriginal() * 0.8))){
                return 2;
            }
            else if(!bot.getUsouHibernar() && botIsLowHealth()){
                return 1;
            }
            else if(enemy.getNome().equals("Ibarra")){
                return 0;
            }
            else if(botGreaterThan(bot.getAtk(), bot.getDef()) && (enemy.getNome().equals("Diogo") || enemy.getNome().equals("Matheus") || enemy.getNome().equals("Rode"))){
                return 3;
            }
            else return 0;
        }
        else if(bot.getNome().equals("Matheus")){
            
            if(turns == 1){
                return 0;
            }
            
            int damage = (int) Math.ceil((bot.getSpAtk() * Integer.parseInt(bot.moves[2].getPoder())/7)/enemy.getSpDef());
            
            if(botGreaterThan(damage, enemy.getHp())){
                return 2;
            }
            else{
                
                if(enemy.getDef() <= 40) return 3;
                
                Random r = new Random();
                int chance = r.nextInt(101);
                int n;
                if(chance <= 80){
                    n = 1;
                }
                else n = 3;
                
                return n;
            }
        }
        else { //Bruno Balas
            
            if(turns == 1 || turns == 2){
                return 2;
            }
            else{
                Random r = new Random();
                int chance = r.nextInt(101);
                int n;
                if(chance <= 90){
                    n = 1;
                }
                else n = 2;
                
                return n;
            }
        }      
    }  
}
