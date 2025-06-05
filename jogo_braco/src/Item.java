import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Item {

    List<String> item = new ArrayList<>();

    public List<String> getItem(){
        return item;
    }

    public void registro(Robo r){

        JFrame registrar = new JFrame("Registrar Itens");
        registrar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registrar.setSize(800, 400);
        registrar.setVisible(true);
        registrar.setLocationRelativeTo(null);

        JButton salvar = new JButton("Enviar");
        JButton cancelar = new JButton("Cancelar");
        JButton apagar = new JButton("Apagar tudo");

        JTextArea input = new JTextArea(10,20);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel painel1 = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.fill = GridBagConstraints.NONE;
        grid.anchor = GridBagConstraints.CENTER;
        grid.insets = new Insets(10,10, 10, 10);

        JScrollPane painel2 = new JScrollPane(input);
        painel2.setPreferredSize(new Dimension(800,400));

        JPanel painelP = new JPanel();
        painelP.setLayout(new BoxLayout(painelP, BoxLayout.Y_AXIS));
        painelP.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,20));

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(salvar);
        painelBotoes.add(cancelar);
        painelBotoes.add(apagar);

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.add(input.getText());
                registrar.remove(painelP);
                r.pegar( registrar,Item.this);
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.clear();
                registrar.dispose();
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.clear();
                input.setText("");
            }
        });

        JLabel regisTexto = new JLabel();
        regisTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        regisTexto.setText("Por favor, coloque no campo abaixo os itens que voce quer organizar.");
        regisTexto.setFont(new Font("Arial", Font.BOLD, 24));


        grid.gridy = 0;
        painel1.add(regisTexto);

        grid.gridy = 1;
        painel1.add(painel2, grid);

        painelP.add(regisTexto);
        painelP.add(Box.createVerticalStrut(20));
        painelP.add(painel2);
        painelP.add(Box.createVerticalStrut(20));
        painelP.add(painelBotoes);


        painelP.add(painel1);

        registrar.setContentPane(painelP);
    }
}
