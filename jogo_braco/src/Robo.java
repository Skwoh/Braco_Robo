import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Robo {

    public void pegar (JFrame registrar, Item item) {

        List<String> itemPego = item.getItem();

        JPanel painelP = new JPanel();
        painelP.setLayout(new BoxLayout(painelP, BoxLayout.Y_AXIS));
        JLabel mudandoTexto = new JLabel();

        JButton pegarItem = new JButton("PEGAR");
        JButton mover_x = new JButton("MOVER EIXO X");
        JButton mover_y = new JButton("MOVER EIXO Y");
        JButton mover_z = new JButton("MOVER EIXO Z");

        painelP.add(pegarItem);
        painelP.add(mover_x);
        painelP.add(mover_y);
        painelP.add(mover_z);

        registrar.setContentPane(painelP);
        registrar.validate();
        registrar.repaint();

        String[] mudando = {".", ".", "."};
        final int[] index = {0};

        Timer tempo1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( index[0] < mudando.length){
                    mudandoTexto.setText(mudando[0]);
                    index[0]++;
                } else {
                    ((Timer) e.getSource()).stop();
                    registrar.remove(mudandoTexto);
                    registrar.setContentPane(painelP);
                    registrar.validate();
                    registrar.repaint();
                }
            }
        });
        tempo1.start();
    }
}
