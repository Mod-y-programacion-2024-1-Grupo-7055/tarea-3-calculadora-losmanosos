import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculadoraInterfaz {
    private JFrame frame;
    private JTextField textField;
    static Compilador comp = new Compilador();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculadoraInterfaz window = new CalculadoraInterfaz();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CalculadoraInterfaz() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(7, 3));

        

        textField = new JTextField();
        textField.setBounds(20, 10, 200, 30);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Crear botones y agregarlos al JFrame
        int x = 20, y = 50;
        for(int i=1; i<=9; i++){
            addButton(String.valueOf(i), x, y);
            x += 60;
            if(i%3 == 0){ x = 20; y += 60; }
        }
        addButton("0", 80, y);
        addButton("+", 140, 50);  // Botón de suma
        addButton("-", 140, 110);  // Botón de resta
        addButton("*", 140, 170);
        addButton("/", 140, 230);  // Botón de división
        addButton("s", 20, y+60);
        addButton("c", 80, y+60);
        addButton("t", 140, y+60);
        addButton("r", 20, y+120);
        addButton("C", 80, y+120);
        addButton("=", 140, y+120);
        addButton("(", 200, 120);
        addButton(")", 260, 120);
    }

    private void addButton(String text, int x, int y){
        JButton btn = new JButton(text);
        btn.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(text.equals("=")){
                    
                    String expression = textField.getText();
                    try {
                        StringTokenizer lexemas = comp.analisisLexico(expression);
                        CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
                        double result = nodo.evalua();
                        textField.setText(String.valueOf(result));
                    } catch(ErrorDeSintaxisException ese){
                        textField.setText("Error de sintaxis");
                    }
                } else if(text.equals("C")){
                    textField.setText("");
                } else {
                    textField.setText(textField.getText() + text);
                }
            }
        });
    }
}
