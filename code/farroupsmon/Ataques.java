/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farroupsmon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author Arthur
 */
public class Ataques {

    private String nome;
    private String descricao;
    private String fisicoEspecialStatus;
    private int accuracy;
    private String poder;

    private Timer timer1;
    private Timer timer2;
    private Timer timer3;

    private Clip efeitos;

    public Ataques(String nome) throws LineUnavailableException {
        efeitos = AudioSystem.getClip();
        nome = nome.toLowerCase();

        if (nome.equals("dose diária de barrinha")) {
            this.nome = "Dose Diária de Barrinha";
            this.descricao = "O usuário degusta das melhoras barrinhas da região e aumenta o seu dano físico em 50%.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("ataque sonolento")) {
            this.nome = "Ataque Sonolento";
            this.descricao = "Ataque físico sonolento com dano moderado, porém, possui uma taxa de acerto (accuracy) generosa.";
            this.fisicoEspecialStatus = "Físico";
            this.accuracy = 100;
            this.poder = "80";
        } else if (nome.equals("não mais um lobo solitário")) {
            this.nome = "Não mais um Lobo Solitário";
            this.descricao = "Diogo farta-se de ser um lobo solitário e invoca uma alcateia de lobos ferozes para atacar o oponente, "
                    + "provocando dano pesado";
            this.fisicoEspecialStatus = "Físico";
            this.accuracy = 70;
            this.poder = "120";
        } else if (nome.equals("watashi wa diogo-san")) {
            this.nome = "Watashi wa Diogo-san";
            this.descricao = "Ataque especial que liberta a fúria do samurai japonês e aumenta o Sp.Atk em "
                    + "20%.";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 90;
            this.poder = "100";
        } else if (nome.equals("disfarce")) {
            this.nome = "Disfarce";
            this.descricao = "Braga se passa por um humano, aumentando a empatia do inimigo por este. Consequentemente, reduz "
                    + "a accuracy do oponente em 20% (mín 30%).";

            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("capaci-thor")) {
            this.nome = "Capaci-Thor";
            this.descricao = "Armazena grandes quantidades de energia eletroestática em seu sistema e aumenta Sp.Attack em 50%.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("01001001010")) {
            this.nome = "01001001010";
            this.descricao = "Somente máquinas como o Braga conseguem entender e decodificar este movimento poderoso. Overclock de máquina, o qual"
                    + " aumenta speed em 100%";

            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("fórmula de brágara")) {
            this.nome = "Fórmula de Brágara";
            this.descricao = "Através de sua fórmula, Braga calcula com precisão o ponto fraco do oponente. Assim, este ataque nunca erra e sempre"
                    + " causa dano dobrado.";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 100;
            this.poder = "50";
        } else if (nome.equals("porra, ibarra!")) {
            this.nome = "PORRA, IBARRA!";
            this.descricao = "Rode indigna-se demais com seu oponente com este ataque de 80 de poder físico."
                    + " O poder do golpe sobe para 150 caso seu adversário seja o Ibarra.";

            this.fisicoEspecialStatus = "Físico";
            this.accuracy = 90;
            this.poder = "80";
        } else if (nome.equals("hibernar")) {
            this.nome = "Hibernar";
            this.descricao = "Rode dorme suas necessárias 15 horas diárias de sono e recupera 20% da vida. Este golpe não pode ser "
                    + "usado consecutivamente.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("raiva liberada")) {
            this.nome = "Raiva Liberada";
            this.descricao = "Rode fica putasso e deseja agredir tudo pela frente. Aumenta o ataque em 150%, mas é necessário ceder 50% do HP total.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("nelsificação")) {
            this.nome = "Nelsificação";
            this.descricao = "Rode induz uma mutação e vira Rodenelson. Com este movimento, os atributos de ataque e defesa de Rode são trocados.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("ibadeus")) {
            this.nome = "IbaDeus";
            this.descricao = "Ibarra se transforma no todo poderoso IbaDeus e recebe asas. Aumenta sua Speed e Sp.Atk em 30%.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("ibapossessão")) {
            this.nome = "IbaPossessão";
            this.descricao = "Esta maldição poderosa inverte completamente todos os stats dos jogadores no campo de batalha.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 60;
            this.poder = "-";
        } else if (nome.equals("chamado zéfinico")) {
            this.nome = "Chamado Zéfinico";
            this.descricao = "Ibarra desmoraliza seu oponente ao referir-se a este como Zé. O poder deste ataque é igual ao atributo mais forte do inimigo.";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 100;
            this.poder = "?";
        } else if (nome.equals("barra")) {
            this.nome = "Barra";
            this.descricao = "Ibarra intimida seu oponente com seu treino monstro, fazendo-o perder 30% do seu atributo mais forte.";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("camuflagem")) {
            this.nome = "Camuflagem";
            this.descricao = "Bruno transforma-se em Matheus e vice-versa. Bruno é mais forte em Sp.Attack, enquanto que Matheus se destaca em Attack "
                    + "(Mantém ataques originais).";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 100;
            this.poder = "-";
        } else if (nome.equals("mete bala")) {
            this.nome = "Mete Bala";
            this.descricao = "Bruno puxa sua AK-47Belo, fuzilando o inimigo. Este ataque possui uma chance de causar sangramento e "
                    + "tirar 30% a mais de vida. +5 pontos em Sp.Attack.";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 95;
            this.poder = "100";

        } else if (nome.equals("halls da fama")) {
            this.nome = "Halls da Fama";
            this.descricao = "Os famosos Halls de Bruno viram explosivos que se autodetonam. A ardência da"
                    + " explosão debilita os olhos do oponente, reduzindo accuracy em 10% (mín 30%).";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 90;
            this.poder = "90";

        } else if (nome.equals("dentaduras vampíricas")) {
            this.nome = "Dentaduras Vampíricas";
            this.descricao = "Bruno invoca suas dentaduras Fini para sugar o sangue do adversário. Este golpe retorna 40% do dano causado como vida para"
                    + " Bruno.";
            this.fisicoEspecialStatus = "Físico";
            this.accuracy = 100;
            this.poder = "90";

        } else if (nome.equals("poema trágico")) {
            this.nome = "Poema Trágico";
            this.descricao = "Poema com um inevitável e triste fim. Poder astronômico, no entanto, caso o eu-lírico não seja finalizado com este"
                    + " ataque, quem morrerá será o próprio autor.";
            this.fisicoEspecialStatus = "Especial";
            this.accuracy = 100;
            this.poder = "200";
        } else if (nome.equals("gaita man")) {
            this.nome = "Gaita Man";
            this.descricao = "Matheus toca sua icônica gaitinha e encanta o oponente, fazendo-o perder 50% de um atributo aleatório "
                    + "(HP e accuracy não estão incluídos).";
            this.fisicoEspecialStatus = "Status";
            this.accuracy = 80;
            this.poder = "-";
        } else if (nome.equals("reforço do rebanho")) {
            this.nome = "Reforço do Rebanho";
            this.descricao = "Ataque MUUUito poderoso. Não é a toa que matheus veste esse chapéu de vaca em sua cabeça... Lendas clamam que"
                    + " tal adorno pode invocar certas criaturas.";
            this.fisicoEspecialStatus = "Físico";
            this.accuracy = 90;
            this.poder = "110";
        }

    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getFisicoEspecialStatus() {
        return this.fisicoEspecialStatus;
    }

    public String getPoder() {
        return this.poder;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public void atacar(Personagem atacante, Personagem defensor, JLabel sprites, JLabel acertouOuErrou,
            JProgressBar vidaP1, JProgressBar vidaP2,
            JLabel foto1, JLabel foto2, JLabel nome1, JLabel nome2, JLabel hp1, JLabel atk1, JLabel def1,
            JLabel spAtk1, JLabel spDef1, JLabel speed1, JLabel hp2, JLabel atk2, JLabel def2,
            JLabel spAtk2, JLabel spDef2, JLabel speed2) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        if (atacante.getNome().equals("Diogo")) {
            if (this.nome.equals("Dose Diária de Barrinha")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(500, 500);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/barrinha.gif")));
                sprites.setLocation(sprites.getLocation().x - 470, sprites.getLocation().y - 100);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/mordida.wav"));
                efeitos.open(ais);
                efeitos.loop(6);
                efeitos.start();

                acertouOuErrou.setText(atacante.getNome() + " used Dose diária de Barrinha!");

                atacante.setAtk((int) (atacante.getAtk() * 1.5));

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " raised its Attack!");
                    atk1.setText("Attack: " + atacante.getAtk());
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(4800, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5000, a2);
                timer2.setRepeats(false);
                timer2.start();

            } else if (this.nome.equals("Ataque Sonolento")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }              
               
                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(312, 219);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/zzz.gif")));
                sprites.setLocation(sprites.getLocation().x - 310, sprites.getLocation().y + 50);
                sprites.setVisible(true);

                acertouOuErrou.setText(atacante.getNome() + " used Ataque Sonolento!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/diogoFalaZzz.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3200, a2);
                timer2.setRepeats(false);
                timer2.start();

            } else if (this.nome.equals("Não mais um Lobo Solitário")) {
                
                Random r = new Random();
                int chance = r.nextInt(100);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                vidaP2.setValue(defensor.getHp());

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(371, 217);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/alcateia.gif")));
                sprites.setLocation(sprites.getLocation().x - 140, sprites.getLocation().y - 10);
                sprites.setVisible(true);

                acertouOuErrou.setText(atacante.getNome() + " used Não mais um Lobo Solitário!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/SomDeLobo.wav"));
                efeitos.open(ais);
                
                mudarVolume(0.25);
                
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(5000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5100, a2);
                timer2.setRepeats(false);
                timer2.start();

            } else if (this.nome.equals("Watashi wa Diogo-san")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;

                }

                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                atacante.setSpAtk((int) (atacante.getSpAtk() * 1.2));

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(231, 216);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/shuriken.gif")));
                sprites.setLocation(sprites.getLocation().x - 125, sprites.getLocation().y - 10);
                sprites.setVisible(true);

                acertouOuErrou.setText(atacante.getNome() + " used Watashi wa Diogo-san!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/banzai.wav"));
                efeitos.open(ais);
               
                mudarVolume(0.3);
                
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " hit the foe " + nome2.getText() + " and raised its Sp.Atk!");
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3200, a2);
                timer2.setRepeats(false);
                timer2.start();

            }
        } else if (atacante.getNome().equals("Braga")) {
            if (this.nome.equals("Disfarce")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(540, 270);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/nSouRobo.gif")));
                sprites.setLocation(sprites.getLocation().x - 260, sprites.getLocation().y - 25);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/ImHuman.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(atacante.getNome() + " used Disfarce!");

                int acc1 = defensor.moves[0].getAccuracy();
                if(defensor.moves[0].getFisicoEspecialStatus().equals("Status") && defensor.moves[0].getAccuracy() == 100) acc1 = -1;
                int acc2 = defensor.moves[1].getAccuracy();
                if(defensor.moves[1].getFisicoEspecialStatus().equals("Status") && defensor.moves[1].getAccuracy() == 100) acc2 = -1;
                int acc3 = defensor.moves[2].getAccuracy();
                if(defensor.moves[2].getFisicoEspecialStatus().equals("Status") && defensor.moves[2].getAccuracy() == 100) acc3 = -1;
                int acc4 = defensor.moves[3].getAccuracy();
                if(defensor.moves[3].getFisicoEspecialStatus().equals("Status") && defensor.moves[3].getAccuracy() == 100) acc4 = -1;
                
                defensor.tirarAccuracy(20); 
                
                String msg = "";
                
                if((acc1 == -1 || acc1 == defensor.moves[0].getAccuracy()) && (acc2 == -1 || acc2 == defensor.moves[1].getAccuracy())
                        && (acc3 == -1 || acc3 == defensor.moves[2].getAccuracy())
                        && (acc4 == -1 || acc4 == defensor.moves[3].getAccuracy())) msg = defensor.getNome() + "'s Accuracy won't go any lower!";
                else msg = defensor.getNome() + "'s Accuracy fell!";
                
                final String lower = msg;
                
                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    foto1.setIcon(new ImageIcon(getClass().getResource("/Fotos/bragaPequeno.png")));
                    efeitos.close();
                    acertouOuErrou.setText(lower);
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(4820, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5000, a2);
                timer2.setRepeats(false);
                timer2.start();
                
            } else if (this.nome.equals("Capaci-Thor")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(300, 300);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/capaci-thor.gif")));
                sprites.setLocation(sprites.getLocation().x - 550, sprites.getLocation().y + 50);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/Electric.wav"));
                
                efeitos.open(ais);
                
                FloatControl gainControl = (FloatControl) efeitos.getControl(FloatControl.Type.MASTER_GAIN);
                double gain = 0.2;
                float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
                
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(atacante.getNome() + " used Capaci-Thor!");

                atacante.setSpAtk((int) (atacante.getSpAtk() * 1.5));

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " raised its Sp.Attack!");
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3100, a2);
                timer2.setRepeats(false);
                timer2.start();

            } else if (this.nome.equals("01001001010")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(221, 320);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/overclock.gif")));
                sprites.setLocation(sprites.getLocation().x - 350, sprites.getLocation().y);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/robo.wav"));
                efeitos.open(ais);
                efeitos.loop(5);
                efeitos.start();

                acertouOuErrou.setText(atacante.getNome() + " used 01001001010!");

                atacante.setSpeed(atacante.getSpeed() * 2);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " sharply raised its Speed!");
                    speed1.setText("Speed: " + atacante.getSpeed());
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3100, a2);
                timer2.setRepeats(false);
                timer2.start();

            } else if (this.nome.equals("Fórmula de Brágara")) {
                
                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()) * 2);

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(270, 480);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/formulaDeBragara.gif")));
                sprites.setLocation(sprites.getLocation().x - 52, sprites.getLocation().y - 120);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/TeoremaBraga.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(atacante.getNome() + " used Fórmula de Brágara!");

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(atacante.getNome() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(4800, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5100, a2);
                timer2.setRepeats(false);
                timer2.start();

            }
        } else if (atacante.getNome().equals("Rode")) {

            if (this.nome.equals("PORRA, IBARRA!")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(nome1.getText() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                        atacante.setUsouHibernar(false);
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                boolean crit;
                
                if (defensor.getNome().equals("Ibarra")) {
                    crit = critChance(atacante, defensor, 150);
                } else {
                    crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                }

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(600, 600);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/facepalm.gif")));
                sprites.setLocation(sprites.getLocation().x - 430, sprites.getLocation().y - 130);
                sprites.setVisible(true);

                acertouOuErrou.setText(nome1.getText() + " used PORRA, IBARRA!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/porraIbarra.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    atacante.setUsouHibernar(false);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3200, a2);
                timer2.setRepeats(false);
                timer2.start();                         

            } else if (this.getNome().equals("Hibernar")) {
               
                boolean b = atacante.getUsouHibernar();
                
                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;
                
                if(!b){                    
                    sprites.setSize(320, 320);
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/recuperaVida.gif")));
                    sprites.setLocation(sprites.getLocation().x - 320, sprites.getLocation().y);
                    sprites.setVisible(true);

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/ronco.wav"));
                    efeitos.open(ais);
               
                    mudarVolume(0.5);
                
                    efeitos.loop(3);
                    efeitos.start();
                }

                acertouOuErrou.setText(nome1.getText() + " used Hibernar!");         
                
                if(!b) {
                    atacante.setHp(atacante.getHp() + 32);
                    if(atacante.getHp() > 160) atacante.setHp(160);
                    atacante.setUsouHibernar(true);
                }
                
                ActionListener a = (ActionEvent e) -> {
                    if(!b){
                        sprites.setVisible(false);
                        vidaP1.setValue(atacante.getHp());
                        efeitos.close();
                        acertouOuErrou.setText(nome1.getText() + " restored its health!");                   
                        hp1.setText("HP: " + atacante.getHp());
                    }
                    else {
                        acertouOuErrou.setText("But it fails!");
                        atacante.setUsouHibernar(false);
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3500, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3600, a2);
                timer2.setRepeats(false);
                timer2.start();
                
            } else if (this.getNome().equals("Raiva Liberada")) {

                foto1.setIcon(new ImageIcon(getClass().getResource("/Fotos/rodeVermelho.png")));

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/gritoRode.wav"));
                efeitos.open(ais);
                
                mudarVolume(0.3);
                
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used Raiva Liberada!");

                atacante.setAtk((int) (atacante.getAtk() * 2.5));
                atacante.setHp(atacante.getHp() - 80);

                if (atacante.getHp() < 0) {
                    atacante.setHp(0);
                    vidaP1.setValue(0);
                } else {
                    vidaP1.setValue(atacante.getHp());
                }

                ActionListener a = (ActionEvent e) -> {
                    efeitos.close();
                    foto1.setIcon(atacante.getSprite());
                    acertouOuErrou.setText(nome1.getText() + " drastically raised its Attack but lost some of its HP!");
                    hp1.setText("HP: " + atacante.getHp());
                    atk1.setText("Attack: " + atacante.getAtk());
                    atacante.setUsouHibernar(false);

                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

            } else if (this.getNome().equals("Nelsificação")) {
                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(208, 300);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/dna.gif")));
                sprites.setLocation(sprites.getLocation().x - 280, sprites.getLocation().y + 10);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/sayagin.wav"));
                efeitos.open(ais);
                
                mudarVolume(0.2);
                
                efeitos.loop(3);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used Nelsificação!");

                int ataque = atacante.getAtk();

                atacante.setAtk(atacante.getDef());
                atacante.setDef(ataque);

                ActionListener nelson = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    vidaP1.setValue(atacante.getHp());
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " switched its stats!");
                    atk1.setText("Attack: " + atacante.getAtk());
                    def1.setText("Defense: " + atacante.getDef());
                    nome1.setText("Rodenelson");
                };

                ActionListener rode = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    vidaP1.setValue(atacante.getHp());
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " switched its stats!");
                    atk1.setText("Attack: " + atacante.getAtk());
                    def1.setText("Defense: " + atacante.getDef());
                    nome1.setText("Rode");
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    atacante.setUsouHibernar(false);
                };

                if (nome1.getText().equals("Rode")) {
                    timer1 = new Timer(3500, nelson);
                } else {
                    timer1 = new Timer(3500, rode);
                }

                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3600, a2);
                timer2.setRepeats(false);
                timer2.start();
            }
        } else if (atacante.getNome().equals("Ibarra")) {
            if (this.getNome().equals("IbaDeus")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(1280, 720);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/ceu.gif")));
                sprites.setLocation(sprites.getLocation().x - 800, sprites.getLocation().y - 100);
                sprites.setVisible(false);
                acertouOuErrou.setText(nome1.getText() + " used IbaDeus!");

                ActionListener used = (ActionEvent e) -> {
                    AudioInputStream ais = null;
                    try {
                        ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/holy.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        efeitos.open(ais);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    efeitos.loop(0);
                    efeitos.start();
                    sprites.setVisible(true);
                };

                atacante.setSpeed((int) (atacante.getSpeed() * 1.3));
                atacante.setSpAtk((int) (atacante.getSpAtk() * 1.3));

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    foto1.setIcon(new ImageIcon(getClass().getResource("/Fotos/asasFinalComigoTeste.png")));                 
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    acertouOuErrou.setText(nome1.getText() + " raised its Sp.Attack and Speed!");
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());
                    speed1.setText("Speed: " + atacante.getSpeed());
                    nome1.setText("IbaDeus");
                };

                timer1 = new Timer(5500, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5600, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(1200, used);
                timer3.setRepeats(false);
                timer3.start();
                
            } else if (this.getNome().equals("IbaPossessão")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance <= 100 - accuracy) {

                    acertouOuErrou.setText(nome1.getText() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    
                    mudarVolume(0.3);
                    
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                sprites.setSize(300, 400);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/possession.gif")));
                sprites.setLocation(sprites.getLocation().x - 350, sprites.getLocation().y - 50);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/ghost.wav"));
                efeitos.open(ais);
                efeitos.loop(5);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used IbaPossessão!");
               
                int ataque = atacante.getAtk();
                int defesa = atacante.getDef();
                int spAtaque = atacante.getSpAtk();
                int spDefesa = atacante.getSpDef();
                int velocidade = atacante.getSpeed();

                atacante.setAtk(defensor.getAtk());
                atacante.setDef(defensor.getDef());
                atacante.setSpAtk(defensor.getSpAtk());
                atacante.setSpDef(defensor.getSpDef());
                atacante.setSpeed(defensor.getSpeed());

                defensor.setAtk(ataque);
                defensor.setDef(defesa);
                defensor.setSpAtk(spAtaque);
                defensor.setSpDef(spDefesa);
                defensor.setSpeed(velocidade);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " switched stats with the opponent!");
                    
                    hp1.setText("HP: " + atacante.getHp());
                    atk1.setText("Attack: " + atacante.getAtk());
                    def1.setText("Defense: " + atacante.getDef());
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());
                    spDef1.setText("Sp.Defense: " + atacante.getSpDef());
                    speed1.setText("Speed: " + atacante.getSpeed());
                    
                    hp2.setText("HP: " + defensor.getHp());
                    atk2.setText("Attack: " + defensor.getAtk());
                    def2.setText("Defense: " + defensor.getDef());
                    spAtk2.setText("Sp.Attack: " + defensor.getSpAtk());
                    spDef2.setText("Sp.Defense: " + defensor.getSpDef());
                    speed2.setText("Speed: " + defensor.getSpeed());
                    
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3100, a2);
                timer2.setRepeats(false);
                timer2.start();
                
            } else if (this.getNome().equals("Chamado Zéfinico")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(nome1.getText() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                int maior = Math.max(defensor.getAtk(), defensor.getDef());
                maior = Math.max(maior, defensor.getSpAtk());
                maior = Math.max(maior, defensor.getSpDef());
                maior = Math.max(maior, defensor.getSpeed());

                boolean crit = critChance(atacante, defensor, maior);

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setVisible(false);
                sprites.setSize(200, 247);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/nuclear.gif")));
                sprites.setLocation(sprites.getLocation().x - 25, sprites.getLocation().y - 65);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/zeMesmo.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used Chamado Zefínico!");

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(true);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                };

                ActionListener a3 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(2700, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(4300, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(4900, a3);
                timer3.setRepeats(false);
                timer3.start();

            } else if (this.getNome().equals("Barra")) {

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(640, 360);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/barra.gif")));
                sprites.setLocation(sprites.getLocation().x - 480, sprites.getLocation().y - 30);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/bodybuilder.wav"));
                efeitos.open(ais);
               
                mudarVolume(0.5);
                
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used Barra!");      

                String maisForte = "";

                int ataque = defensor.getAtk();
                int defesa = defensor.getDef();
                int spAtaque = defensor.getSpAtk();
                int spDefesa = defensor.getSpDef();
                int velocidade = defensor.getSpeed();

                int maior = Math.max(ataque, defesa);
                maior = Math.max(maior, spAtaque);
                maior = Math.max(maior, spDefesa);
                maior = Math.max(maior, velocidade);

                if (maior == ataque) {
                    maisForte = nome2.getText() + "'s Attack fell!";
                    defensor.setAtk((int) (maior * 0.7));
                    defensor.limiteStats();
                    if(ataque == defensor.getAtk()) maisForte = nome2.getText() + "'s Attack won't go any lower!";
                    atk2.setText("Attack: " + defensor.getAtk());
                } else if (maior == defesa) {
                    maisForte = nome2.getText() + "'s Defense fell!";
                    defensor.setDef((int) (maior * 0.7));
                    defensor.limiteStats();
                    if(defesa == defensor.getDef()) maisForte = nome2.getText() + "'s Defense won't go any lower!";
                    def2.setText("Defense: " + defensor.getDef());
                } else if (maior == spAtaque) {
                    maisForte = nome2.getText() + "'s Sp.Attack fell!";
                    defensor.setSpAtk((int) (maior * 0.7));
                    defensor.limiteStats();
                    if(spAtaque == defensor.getSpAtk()) maisForte = nome2.getText() + "'s Sp.Attack won't go any lower!";
                    spAtk2.setText("Sp.Attack: " + defensor.getSpAtk());
                } else if (maior == spDefesa) {
                    maisForte = nome2.getText() + "'s Sp.Defense fell!";
                    defensor.setSpDef((int) (maior * 0.7));
                    defensor.limiteStats();
                    if(spDefesa == defensor.getSpDef()) maisForte = nome2.getText() + "'s Sp.Defense won't go any lower!";
                    spDef2.setText("Sp.Defense: " + defensor.getSpDef());
                } else if (maior == velocidade) {
                    maisForte = nome2.getText() + "'s Speed fell!";
                    defensor.setSpeed((int) (maior * 0.7));
                    defensor.limiteStats();
                    if(velocidade == defensor.getSpeed()) maisForte = nome2.getText() + "'s Speed won't go any lower!";                   
                    speed2.setText("Speed: " + defensor.getSpeed());
                }                          
                
                final String maisForte2 = maisForte;

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(maisForte2);
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3100, a2);
                timer2.setRepeats(false);
                timer2.start();
            }
        } else if (atacante.getNome().equalsIgnoreCase("Bruno Balas")) {

            if (this.nome.equals("Dentaduras Vampíricas")) {
               
                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }              
                
                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));       
                
                if(atacante.getHp() > 90) atacante.setHp(90);

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(256, 256);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/dentadura.gif")));
                sprites.setLocation(sprites.getLocation().x - 310, sprites.getLocation().y + 50);
                sprites.setVisible(true);

                acertouOuErrou.setText(nome1.getText() + " used Dentaduras Vampíricas!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/risadaMal.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText() + " and restored some health!");
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    hp1.setText("HP: " + atacante.getHp());
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                    vidaP1.setValue(atacante.getHp());
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3200, a2);
                timer2.setRepeats(false);
                timer2.start();
                
            } else if (this.nome.equals("Halls da Fama")) {
               
                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                
                int acc1 = defensor.moves[0].getAccuracy();
                if(defensor.moves[0].getFisicoEspecialStatus().equals("Status") && defensor.moves[0].getAccuracy() == 100) acc1 = -1;
                int acc2 = defensor.moves[1].getAccuracy();
                if(defensor.moves[1].getFisicoEspecialStatus().equals("Status") && defensor.moves[1].getAccuracy() == 100) acc2 = -1;
                int acc3 = defensor.moves[2].getAccuracy();
                if(defensor.moves[2].getFisicoEspecialStatus().equals("Status") && defensor.moves[2].getAccuracy() == 100) acc3 = -1;
                int acc4 = defensor.moves[3].getAccuracy();
                if(defensor.moves[3].getFisicoEspecialStatus().equals("Status") && defensor.moves[3].getAccuracy() == 100) acc4 = -1;
                
                defensor.tirarAccuracy(10);
                
                String msg = "";
                
                if((acc1 == -1 || acc1 == defensor.moves[0].getAccuracy()) && (acc2 == -1 || acc2 == defensor.moves[1].getAccuracy())
                        && (acc3 == -1 || acc3 == defensor.moves[2].getAccuracy())
                        && (acc4 == -1 || acc4 == defensor.moves[3].getAccuracy())) msg = nome2.getText() + "'s Accuracy won't go any lower!";
                else msg = nome2.getText() + "'s Accuracy fell!";
                
                final String lower = msg;

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setVisible(true);

                sprites.setSize(640, 360);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/halls.gif")));
                sprites.setLocation(sprites.getLocation().x - 350, sprites.getLocation().y - 20);

                acertouOuErrou.setText(nome1.getText() + " used Halls da Fama!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/hallsExplosao.wav"));
                efeitos.open(ais);
                
                mudarVolume(0.2);
                
                efeitos.loop(0);
                efeitos.start();

                ActionListener a2 = (ActionEvent e) -> {
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText() + ". " + lower);
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                };

                ActionListener a3 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer2 = new Timer(5500, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(5600, a3);
                timer3.setRepeats(false);
                timer3.start();
                
            } else if (this.nome.equals("Mete Bala")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(990, 720);

                if (defensor.getNome().equals("Braga")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akBraga.gif")));
                } else if (defensor.getNome().equals("Diogo")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akDiogo.gif")));
                } else if (defensor.getNome().equals("Ibarra")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akEu.gif")));
                } else if (defensor.getNome().equals("Rode")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akRode.gif")));
                } else if (defensor.getNome().equals("Matheus")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akMatheus.gif")));
                } else if (defensor.getNome().equals("Bruno Balas")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/akBruno.gif")));
                }

                sprites.setLocation(sprites.getLocation().x - 665, sprites.getLocation().y - 100);
                sprites.setVisible(false);
                acertouOuErrou.setText(nome1.getText() + " used Mete Bala!");

                ActionListener used = (ActionEvent e) -> {
                    AudioInputStream ais = null;
                    try {
                        ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/AK47.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        efeitos.open(ais);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    efeitos.loop(4);
                    efeitos.start();
                    sprites.setVisible(true);
                };

                int hpInimigoInicial = defensor.getHp();
                
                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                atacante.setSpAtk(atacante.getSpAtk() + 5);
                
                int hpInimigoFinal = defensor.getHp();

                int sangramento = r.nextInt(101);

                String s = "";

                if (sangramento < 30) {
                    int danoDado = hpInimigoInicial - hpInimigoFinal;
                    defensor.setHp(defensor.getHp() - (int) Math.ceil(danoDado * 0.3));
                    s = " (BLEEDING ACTIVATED)";
                }

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                };

                final String sFinal = s;

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText() + sFinal);
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                    vidaP1.setValue(atacante.getHp());
                };

                timer1 = new Timer(5500, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5600, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(1200, used);
                timer3.setRepeats(false);
                timer3.start();
            }
            else if(this.nome.equals("Camuflagem")){
                
                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(1000,626);
                
                int atributoAtaque;
                int atributoSpAtaque;
                String msg;
                String nomePraColocar;
                Icon iconPraColocar;

                if(nome1.getText().equals("Matheus")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/TransformaMatheus.gif")));
                    
                    int ataqueDoMatheusAtual = atacante.getAtk();
                    int spAtaqueDoMatheusAtual = atacante.getSpAtk();
                    
                    atributoAtaque = ataqueDoMatheusAtual * 50 / 120;
                    atributoSpAtaque = spAtaqueDoMatheusAtual * 120 / 50;  
                    
                    msg = "Matheus turned into Bruno Balas!";
                    nomePraColocar = "Bruno Balas";
                    iconPraColocar = new ImageIcon(getClass().getResource("/Fotos/brunoGrande.png"));
                }
                else {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/TransformaBruno.gif")));
                    
                    int ataqueDoBrunoAtual = atacante.getAtk();
                    int spAtaqueDoBrunoAtual = atacante.getSpAtk();
                    
                    atributoAtaque = ataqueDoBrunoAtual * 120 / 50;
                    atributoSpAtaque = spAtaqueDoBrunoAtual * 50 / 120; 
                    
                    msg = "Bruno Balas turned into Matheus!";
                    nomePraColocar = "Matheus";
                    iconPraColocar = new ImageIcon(getClass().getResource("/Fotos/matheusGrande.png"));
                }
                
                final String msgFinal = msg;
                final String nomeFinal = nomePraColocar;
                final Icon iconFinal = iconPraColocar;

                sprites.setLocation(sprites.getLocation().x - 665, sprites.getLocation().y - 100);
                sprites.setVisible(false);
                acertouOuErrou.setText(nome1.getText() + " used Camuflagem!");
      
                ActionListener used = (ActionEvent e) -> {                   
                    sprites.setVisible(true);
                    
                    AudioInputStream ais = null;
                    
                    try {
                        ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/evolution.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        efeitos.open(ais);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    FloatControl gainControl = (FloatControl) efeitos.getControl(FloatControl.Type.MASTER_GAIN);
                    double gain = 0.2;
                    float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                    gainControl.setValue(dB);
                    
                    efeitos.loop(0);
                    efeitos.start();   
                };

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);    
                    
                    atacante.setAtk(atributoAtaque);
                    atacante.setSpAtk(atributoSpAtaque);
                    
                    nome1.setText(nomeFinal);
                    foto1.setIcon(iconFinal);
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    acertouOuErrou.setText(msgFinal);             
                    atk1.setText("Attack: " + atacante.getAtk());
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());                   
                    efeitos.close();                   
                };
                

                timer1 = new Timer(5800, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5900, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(1200, used);
                timer3.setRepeats(false);
                timer3.start();
            }       
            
        } else if (atacante.getNome().equals("Matheus")) {
            if (this.nome.equals("Poema Trágico")) {

                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }
                
                boolean autorMorreu = false;

                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                
                if(defensor.getHp() > 0) {
                    atacante.setHp(0);
                    autorMorreu = true;
                }
                
                final boolean autorMorreu2 = autorMorreu;

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(500, 500);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/livro.gif")));
                sprites.setLocation(sprites.getLocation().x - 430, sprites.getLocation().y - 130);
                sprites.setVisible(true);

                acertouOuErrou.setText(nome1.getText() + " used Poema Trágico!");

                AudioInputStream ais = null;

                if (defensor.getNome().equals("Braga")) {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraBraga.wav"));
                } else if (defensor.getNome().equals("Diogo")) {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraDiogo.wav"));
                } else if (defensor.getNome().equals("Ibarra")) {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraIba.wav"));
                } else if (defensor.getNome().equals("Rode")) {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraRode.wav"));
                } else if (defensor.getNome().equals("Matheus")) {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraMatheus.wav"));
                } else {
                    ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/eraBruno.wav"));
                }

                efeitos.open(ais);
                
                FloatControl gainControl = (FloatControl) efeitos.getControl(FloatControl.Type.MASTER_GAIN);
                double gain = 2;
                float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);
                
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText());
                    tirarVidaDefensor(defensor, hp2);
                    hp1.setText("HP: " + atacante.getHp());

                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }

                    if (autorMorreu2) {     
                        vidaP1.setValue(0);
                        acertouOuErrou.setText(acertouOuErrou.getText() + "! But couldn't defeat it and thus fainted!");
                    }
                    
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");

                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(5000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5100, a2);
                timer2.setRepeats(false);
                timer2.start();
            }
            else if(this.nome.equals("Gaita Man")){
                
                Random r = new Random();
                int chance = r.nextInt(101);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }
                
                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(350, 350);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/gaita.gif")));
                sprites.setLocation(sprites.getLocation().x - 420, sprites.getLocation().y - 30);
                sprites.setVisible(true);

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/gaita.wav"));
                efeitos.open(ais);
                
                mudarVolume(2);
                
                efeitos.loop(0);
                efeitos.start();

                acertouOuErrou.setText(nome1.getText() + " used Gaita Man!");

                String[] atributos = {"Attack", "Sp.Attack", "Defense", "Sp.Defense", "Speed"};
                String escolhido = atributos[r.nextInt(atributos.length)];
                
                int ataque = defensor.getAtk();
                int defesa = defensor.getDef();
                int spAtaque = defensor.getSpAtk();
                int spDefesa = defensor.getSpDef();
                int velocidade = defensor.getSpeed();

                if (escolhido.equals("Attack")) {                    
                    defensor.setAtk((int) (defensor.getAtk() * 0.5));
                    defensor.limiteStats();
                    if(ataque == defensor.getAtk()) escolhido = nome2.getText() + "'s Attack won't go any lower!";
                    else escolhido = nome2.getText() + "'s Attack drastically fell!";
                    atk2.setText("Attack: " + defensor.getAtk());
                } else if (escolhido.equals("Sp.Attack")) {                  
                    defensor.setSpAtk((int) (defensor.getSpAtk() * 0.5));
                    defensor.limiteStats();
                    if(spAtaque == defensor.getSpAtk()) escolhido = nome2.getText() + "'s Sp.Attack won't go any lower!";
                    else escolhido = nome2.getText() + "'s Sp.Attack drastically fell!";
                    spAtk2.setText("Sp.Attack: " + defensor.getSpAtk());
                } else if (escolhido.equals("Defense")) {
                    defensor.setDef((int) (defensor.getDef() * 0.5));
                    defensor.limiteStats();
                    if(defesa == defensor.getDef()) escolhido = nome2.getText() + "'s Defense won't go any lower!";
                    else escolhido = nome2.getText() + "'s Defense drastically fell!";
                    def2.setText("Defense: " + defensor.getDef());
                } else if (escolhido.equals("Sp.Defense")) {
                    defensor.setSpDef((int) (defensor.getSpDef() * 0.5));
                    defensor.limiteStats();
                    if(spDefesa == defensor.getSpDef()) escolhido = nome2.getText() + "'s Sp.Defense won't go any lower!";
                    else escolhido = nome2.getText() + "'s Sp.Defense drastically fell!";
                    spDef2.setText("Sp.Defense: " + defensor.getSpDef());
                } else if (escolhido.equals("Speed")) {
                    defensor.setSpeed((int) (defensor.getSpeed() * 0.5));
                    defensor.limiteStats();
                    if(velocidade == defensor.getSpeed()) escolhido = nome2.getText() + "'s Speed won't go any lower!";
                    else escolhido = nome2.getText() + "'s Speed drastically fell!";
                    speed2.setText("Speed: " + defensor.getSpeed());
                }

                final String escolhidoFinal = escolhido;

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(escolhidoFinal);
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(5500, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5600, a2);
                timer2.setRepeats(false);
                timer2.start();
            }
            else if(this.nome.equals("Reforço do Rebanho")){
               
                Random r = new Random();
                int chance = r.nextInt(100);

                if (chance < 100 - accuracy) {

                    acertouOuErrou.setText(atacante.getNome() + "'s attack missed!");

                    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/errou.wav"));
                    efeitos.open(ais);
                    efeitos.loop(0);
                    efeitos.start();

                    ActionListener a = (ActionEvent e) -> {
                        efeitos.close();
                    };

                    timer1 = new Timer(4000, a);
                    timer1.setRepeats(false);
                    timer1.start();

                    return;
                }

                boolean crit = critChance(atacante, defensor, Integer.parseInt(this.getPoder()));
                
                vidaP2.setValue(defensor.getHp());

                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(371, 217);
                sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/vaca.gif")));
                sprites.setLocation(sprites.getLocation().x - 140, sprites.getLocation().y - 10);
                sprites.setVisible(true);

                acertouOuErrou.setText(nome1.getText() + " used Reforço do Rebanho!");

                AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/muuu.wav"));
                efeitos.open(ais);
                efeitos.loop(0);
                efeitos.start();

                sprites.setVisible(true);

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);
                    efeitos.close();
                    acertouOuErrou.setText(nome1.getText() + " hit the foe " + nome2.getText());
                    if(crit) acertouOuErrou.setText(acertouOuErrou.getText() + " (CRITICAL HIT)");
                    tirarVidaDefensor(defensor, hp2);
                    if (defensor.getHp() < 0) {
                        defensor.setHp(0);
                        vidaP2.setValue(0);
                    } else {
                        vidaP2.setValue(defensor.getHp());
                    }
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                };

                timer1 = new Timer(3000, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(3100, a2);
                timer2.setRepeats(false);
                timer2.start();
            }
            else if(this.nome.equals("Camuflagem")){
                
                int x = sprites.getLocation().x;
                int y = sprites.getLocation().y;

                sprites.setSize(1000,626);
                
                int atributoAtaque;
                int atributoSpAtaque;
                String msg;
                String nomePraColocar;
                Icon iconPraColocar;

                if(nome1.getText().equals("Matheus")) {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/TransformaMatheus.gif")));
                    
                    int ataqueDoMatheusAtual = atacante.getAtk();
                    int spAtaqueDoMatheusAtual = atacante.getSpAtk();
                    
                    atributoAtaque = ataqueDoMatheusAtual * 50 / 120;
                    atributoSpAtaque = spAtaqueDoMatheusAtual * 120 / 50;  
                                      
                    msg = "Matheus turned into Bruno Balas!";
                    nomePraColocar = "Bruno Balas";
                    iconPraColocar = new ImageIcon(getClass().getResource("/Fotos/brunoGrande.png"));
                }
                else {
                    sprites.setIcon(new ImageIcon(getClass().getResource("/SpritesAtaques/TransformaBruno.gif")));
                    
                    int ataqueDoBrunoAtual = atacante.getAtk();
                    int spAtaqueDoBrunoAtual = atacante.getSpAtk();
                    
                    atributoAtaque = ataqueDoBrunoAtual * 120 / 50;
                    atributoSpAtaque = spAtaqueDoBrunoAtual * 50 / 120;  
                
                    msg = "Bruno Balas turned into Matheus!";
                    nomePraColocar = "Matheus";
                    iconPraColocar = new ImageIcon(getClass().getResource("/Fotos/matheusGrande.png"));
                }
                
                final String msgFinal = msg;
                final String nomeFinal = nomePraColocar;
                final Icon iconFinal = iconPraColocar;

                sprites.setLocation(sprites.getLocation().x - 665, sprites.getLocation().y - 100);
                sprites.setVisible(false);
                acertouOuErrou.setText(nome1.getText() + " used Camuflagem!");
      
                ActionListener used = (ActionEvent e) -> {                   
                    sprites.setVisible(true);
                    
                    AudioInputStream ais = null;
                                
                    try {
                        ais = AudioSystem.getAudioInputStream(getClass().getResource("/Sons/evolution.wav"));
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        efeitos.open(ais);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Ataques.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    FloatControl gainControl = (FloatControl) efeitos.getControl(FloatControl.Type.MASTER_GAIN);
                    double gain = 0.2;
                    float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
                    gainControl.setValue(dB);
                    
                    efeitos.loop(0);
                    efeitos.start();   
                };

                ActionListener a = (ActionEvent e) -> {
                    sprites.setVisible(false);    
                    
                    atacante.setAtk(atributoAtaque);
                    atacante.setSpAtk(atributoSpAtaque);
                    
                    atacante.limiteStats();
                    
                    nome1.setText(nomeFinal);
                    foto1.setIcon(iconFinal);
                };

                ActionListener a2 = (ActionEvent e) -> {
                    sprites.setLocation(x, y);
                    acertouOuErrou.setText(msgFinal);    
                    atk1.setText("Attack: " + atacante.getAtk());
                    spAtk1.setText("Sp.Attack: " + atacante.getSpAtk());  
                    efeitos.close();                   
                };
                

                timer1 = new Timer(5800, a);
                timer1.setRepeats(false);
                timer1.start();

                timer2 = new Timer(5900, a2);
                timer2.setRepeats(false);
                timer2.start();

                timer3 = new Timer(1200, used);
                timer3.setRepeats(false);
                timer3.start();
            }            
        }
    }

    public void tirarAccuracy(int n) {
        
        if(this.nome.equals("Fórmula de Brágara") || (this.fisicoEspecialStatus.equals("Status") && this.accuracy == 100)) return;
        
        this.accuracy = this.accuracy - n;
        
        if (this.accuracy < 30) {
            this.accuracy = 30;
        }
    }
    
    public void tirarVidaDefensor(Personagem defensor, JLabel hp2){
        hp2.setText("HP: " + defensor.getHp());
    }
    
    public boolean critChance(Personagem atacante, Personagem defensor, int poderAtaque){
        
        Random r = new Random();
        
        int chance = r.nextInt(101);
        
        if(chance <= 9){ 
            if(this.fisicoEspecialStatus.equals("Físico")) defensor.setHp(defensor.getHp() - (int) Math.ceil((poderAtaque * atacante.getAtk() * 1.5/7)/defensor.getDefOriginal()));
            else defensor.setHp(defensor.getHp() - (int) Math.ceil((poderAtaque * atacante.getSpAtk() * 1.5/7)/defensor.getSpDefOriginal()));
            
            if(this.nome.equals("Dentaduras Vampíricas")){
                atacante.setHp(atacante.getHp() + (int) (Math.ceil((0.4 * poderAtaque * atacante.getAtk() * 1.5/7)/defensor.getDefOriginal())));
            }
            
            return true;
        }
        else{
            if(this.fisicoEspecialStatus.equals("Físico")) defensor.setHp(defensor.getHp() - (int) Math.ceil((poderAtaque * atacante.getAtk()/7)/defensor.getDef()));
            else defensor.setHp(defensor.getHp() - (int) Math.ceil((poderAtaque * atacante.getSpAtk()/7)/defensor.getSpDef()));
            
            if(this.nome.equals("Dentaduras Vampíricas")){
                atacante.setHp(atacante.getHp() + (int) (Math.ceil((0.4 * poderAtaque * atacante.getAtk()/7)/defensor.getDef())));
            }
            
            return false;
        }
    }

    public void mudarVolume(double vol){
        FloatControl gainControl = (FloatControl) efeitos.getControl(FloatControl.Type.MASTER_GAIN);
        double gain = vol;
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }
}
