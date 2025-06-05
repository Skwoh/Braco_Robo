import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Item item = new Item();
        Robo r = new Robo();

        JFrame tela = new JFrame("Robo 3PK7C");
        JLabel text = new JLabel("Robo 3PK7C operando normalmente", SwingConstants.CENTER);
        tela.setSize(800, 400);
        JPanel painelBotoes = new JPanel();
        JButton botao1 = new JButton("Instruções");
        JButton botao2 = new JButton("Começar");
        tela.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 15;
        grid.gridy = 0;
        grid.anchor = GridBagConstraints.CENTER;
        grid.fill = GridBagConstraints.NONE;

        painelBotoes.add(botao1);
        painelBotoes.add(botao2);

        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instrucoes();
            }
        });

        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.registro(r);
            }
        });

        String[] iniciar =  {"INICIANDO SISTEMA",".", "..", "...", "SISTEMA INICIADO!"};
        final int[] index = {0};

        Timer tempo1 =  new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index[0] < iniciar.length) {
                    text.setText(iniciar[index[0]]);
                    index[0]++;
                } else {
                    ((Timer) e.getSource()).stop();
                    tela.remove(text);
                    tela.add(painelBotoes);
                    tela.revalidate();
                    tela.repaint();
                }
            }
        });
        tempo1.start();

        text.setFont(new Font("Arial", Font.BOLD, 24));

        tela.setVisible(true);
        tela.add(text, grid);

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(300,200);
    }
    public static void instrucoes() {
        JFrame instrucoes = new JFrame("Instruções");
        instrucoes.setLayout(new BorderLayout());
        JLabel insTexto = new JLabel();
        insTexto.setText("<html>Movimente o robo com W-A-S-D e pegue os itens. <br>Depois organize-os colocando no caminhão e despache para a entrega!<br></html>");
        insTexto.setFont(new Font("Arial", Font.BOLD, 18));
        insTexto.setHorizontalAlignment(SwingConstants.CENTER);
        instrucoes.setSize(800, 400);
        instrucoes.setLocationRelativeTo(null);
        instrucoes.setVisible(true);
        instrucoes.add(insTexto);
    }
}
