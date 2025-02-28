package Projetos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FirstProject {
    private static JFrame frame;
    private static JPanel panel;
    private static boolean darkMode = false;

    public static void main(String[] args) {
        createWindow();
        createMainMenu();
    }

    private static void createWindow() {
        frame = new JFrame("Calculator Menu");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static void createMainMenu() {
        panel.removeAll();
        panel.repaint();

        JLabel lblMenu = new JLabel("Mini Caluladora");
        lblMenu.setBounds(95, 20, 200, 30);

        JButton btnStart = new JButton("Operações");
        JButton btnSettings = new JButton("Configurações");
        JButton btnExit = new JButton("Sair");

        btnStart.setBounds(70, 50, 140, 30);
        btnSettings.setBounds(70, 90, 140, 30);
        btnExit.setBounds(70, 130, 140, 30);

        btnStart.addActionListener(e -> createOperationsMenu());
        btnSettings.addActionListener(e -> createSettingsMenu());
        btnExit.addActionListener(e -> {
            int confirmation = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        panel.add(lblMenu);
        panel.add(btnStart);
        panel.add(btnSettings);
        panel.add(btnExit);
        updateTheme();
    }

    private static void createOperationsMenu() {
        panel.removeAll();
        panel.repaint();

        JLabel lblTitle = new JLabel("Escolha uma operação");
        lblTitle.setBounds(80, 20, 200, 30);

        JButton btnAddition = new JButton("Adição");
        JButton btnSubtraction = new JButton("Subtração");
        JButton btnMultiplication = new JButton("Multiplicação");
        JButton btnDivision = new JButton("Divisão");
        JButton btnBack = new JButton("Voltar");

        btnAddition.setBounds(70, 50, 140, 30);
        btnSubtraction.setBounds(70, 80, 140, 30);
        btnMultiplication.setBounds(70, 110, 140, 30);
        btnDivision.setBounds(70, 140, 140, 30);
        btnBack.setBounds(70, 170, 140, 30);

        btnAddition.addActionListener(e -> performOperation("+"));
        btnSubtraction.addActionListener(e -> performOperation("-"));
        btnMultiplication.addActionListener(e -> performOperation("*"));
        btnDivision.addActionListener(e -> performOperation("/"));
        btnBack.addActionListener(e -> createMainMenu());

        panel.add(lblTitle);
        panel.add(btnAddition);
        panel.add(btnSubtraction);
        panel.add(btnMultiplication);
        panel.add(btnDivision);
        panel.add(btnBack);
        updateTheme();
    }

    private static void performOperation(String operation) {
        panel.removeAll();
        panel.repaint();

        JLabel lblNumber1 = new JLabel("1º número:");
        JTextField txtNumber1 = new JTextField();
        JLabel lblNumber2 = new JLabel("2º número:");
        JTextField txtNumber2 = new JTextField();
        JButton btnCalculate = new JButton("Calcular");
        JLabel lblResult = new JLabel("Resultado: ");
        JButton btnBack = new JButton("Voltar");

        lblNumber1.setBounds(50, 20, 100, 30);
        txtNumber1.setBounds(120, 20, 100, 30);
        lblNumber2.setBounds(50, 60, 100, 30);
        txtNumber2.setBounds(120, 60, 100, 30);
        btnCalculate.setBounds(80, 100, 140, 30);
        lblResult.setBounds(50, 140, 200, 30);
        btnBack.setBounds(80, 170, 140, 30);

        // Variável para controlar se o cálculo já foi feito
        final boolean[] calculationDone = {false};

        // Pressionar Enter no primeiro campo move para o segundo
        txtNumber1.addActionListener(e -> txtNumber2.requestFocus());

        // Pressionar Enter no segundo campo aciona o cálculo
        txtNumber2.addActionListener(e -> btnCalculate.doClick());

        // Evento do botão de cálculo
        btnCalculate.addActionListener(e -> {
            try {
                double number1 = Double.parseDouble(txtNumber1.getText());
                double number2 = Double.parseDouble(txtNumber2.getText());
                double result = 0;

                switch (operation) {
                    case "+": result = number1 + number2; break;
                    case "-": result = number1 - number2; break;
                    case "*": result = number1 * number2; break;
                    case "/": result = number2 != 0 ? number1 / number2 : Double.NaN; break;
                }

                lblResult.setText("Resultado: " + result);
                calculationDone[0] = true; // Marca que o cálculo foi feito
            } catch (NumberFormatException ex) {
                lblResult.setText("Erro: Coloque números válidos!");
            }
        });

        // Evento para limpar os campos com Backspace (apenas depois de calcular)
        txtNumber2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE && calculationDone[0]) {
                    txtNumber1.setText("");
                    txtNumber2.setText("");
                    lblResult.setText("Resultado: ");
                    calculationDone[0] = false; // Reseta o status de cálculo
                    txtNumber1.requestFocus();
                }
            }
        });

        btnBack.addActionListener(e -> createOperationsMenu());

        panel.add(lblNumber1);
        panel.add(txtNumber1);
        panel.add(lblNumber2);
        panel.add(txtNumber2);
        panel.add(btnCalculate);
        panel.add(lblResult);
        panel.add(btnBack);

        updateTheme();

        // Garante que o campo receba o foco corretamente
        txtNumber1.requestFocus();
    }


    private static void createSettingsMenu() {
        panel.removeAll();
        panel.repaint();

        JLabel lblTitle = new JLabel("Confirgurações");
        lblTitle.setBounds(100, 20, 200, 30);

        // Criando o botão de alternância deslizante (Toggle Switch)
        JCheckBox toggleTheme = new JCheckBox("Dark Mode");
        toggleTheme.setBounds(80, 60, 140, 30);
        toggleTheme.setSelected(darkMode); // Define o estado inicial
        toggleTheme.addActionListener(e -> {
            darkMode = toggleTheme.isSelected();
            updateTheme(); // Aplica o novo tema
        });

        JButton btnBack = new JButton("Voltar");
        btnBack.setBounds(80, 100, 140, 30);
        btnBack.addActionListener(e -> createMainMenu());

        panel.add(lblTitle);
        panel.add(toggleTheme); // Adiciona o toggle switch
        panel.add(btnBack);

        updateTheme();
    }

    private static void updateTheme() {
        Color bgColor = darkMode ? Color.DARK_GRAY : Color.LIGHT_GRAY;
        Color textColor = darkMode ? Color.WHITE : Color.BLACK;
        Color buttonColor = darkMode ? Color.GRAY : Color.WHITE;
        Color buttonTextColor = darkMode ? Color.BLACK : Color.BLUE;

        panel.setBackground(bgColor);

        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                comp.setForeground(textColor);
            } else if (comp instanceof JButton || comp instanceof JCheckBox) {
                comp.setBackground(buttonColor);
                comp.setForeground(buttonTextColor);
            }
        }

        panel.revalidate();
        panel.repaint();
    }
}