//RESOLVER O DETALHE DAS TRANSAÇÕES E FAZER COM QUE NÃO DUPLIQUE A TRANSFERENCIA NO EXTRATO!!!
//RESOLVER A QUESTAO 'EMAIL' NO SQL QUANDO DEPOSITA OU SACA!!

package Projetos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Random;

public class SistemaBancario extends JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/sistemabanco";
    private static final String USUARIO = "root";
    private static final String SENHA = "SuaNovaSenha";
    private static JFrame frame;
    private static JPanel panel;
    private static boolean loginTentado = false;
    private static int tentativas = 0;
    private static boolean bloqueado = false;

    public static void main(String[] args) {
        createWindow();
        createMainMenu();
    }

    private static void createWindow() {
        frame = new JFrame("Menu Principal");
        frame.setSize(400, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static void createMainMenu() {
        clearPanel();

        JLabel lblMenu = new JLabel("Bem-vindo ao Sistema Bancário");
        lblMenu.setBounds(105, 20, 300, 30);

        JLabel lblNumeroConta = new JLabel("Número da Conta:");
        JTextField numeroContaTxt = new JTextField();
        JPasswordField passwordTxt = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        JButton btnCadastro = new JButton("Cadastrar");
        JButton btnSair = new JButton("Sair");
        JLabel lblTimer = new JLabel("");

        setBoundsForMainMenu(lblNumeroConta, numeroContaTxt, passwordTxt, btnLogin, btnCadastro, btnSair, lblTimer);

        addEnterKeyListeners(numeroContaTxt, passwordTxt, btnLogin);

        btnLogin.addActionListener(e -> handleLogin(numeroContaTxt, passwordTxt));
        btnCadastro.addActionListener(e -> createRegistrationMenu());
        btnSair.addActionListener(e -> handleExit());

        addComponentsToPanel(lblMenu, lblNumeroConta, numeroContaTxt, passwordTxt, btnLogin, btnCadastro, btnSair, lblTimer);
    }

    private static void setBoundsForMainMenu(JLabel lblNumeroConta, JTextField numeroContaTxt, JPasswordField passwordTxt,
                                             JButton btnLogin, JButton btnCadastro, JButton btnSair, JLabel lblTimer) {
        lblNumeroConta.setBounds(70, 60, 200, 20);
        numeroContaTxt.setBounds(70, 80, 250, 30);
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(70, 120, 200, 20);
        passwordTxt.setBounds(70, 140, 250, 30);
        btnLogin.setBounds(70, 180, 250, 30);
        btnCadastro.setBounds(70, 220, 250, 30);
        btnSair.setBounds(70, 260, 250, 30);
        lblTimer.setBounds(70, 300, 250, 30);
        lblTimer.setForeground(Color.RED);
    }

    private static void addEnterKeyListeners(JTextField numeroContaTxt, JPasswordField passwordTxt, JButton btnLogin) {
        numeroContaTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordTxt.requestFocus();
                }
            }
        });

        passwordTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }
        });
    }

    private static void handleLogin(JTextField numeroContaTxt, JPasswordField passwordTxt) {
        String numeroConta = numeroContaTxt.getText().trim();
        String senha = new String(passwordTxt.getPassword()).trim();

        if (checkLogin(numeroConta, senha)) {
            JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
            createAccountMenu(numeroConta);
        } else {
            JOptionPane.showMessageDialog(frame, "Número da conta ou senha inválidos.");
        }
    }

    private static void handleExit() {
        int confirmation = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private static void clearPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    private static void addComponentsToPanel(JComponent... components) {
        for (JComponent component : components) {
            panel.add(component);
        }
        panel.revalidate();
        panel.repaint();
    }

    private static void createRegistrationMenu() {
        clearPanel();

        JLabel lblMenu = new JLabel("Cadastro de Usuário");
        lblMenu.setBounds(105, 20, 250, 30);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblEmail = new JLabel("E-mail:");
        JLabel lblSenha = new JLabel("Senha:");
        JTextField nomeTxt = new JTextField();
        JTextField emailTxt = new JTextField();
        JPasswordField senhaTxt = new JPasswordField();
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnVoltar = new JButton("Voltar");

        setBoundsForRegistrationMenu(lblNome, nomeTxt, lblEmail, emailTxt, lblSenha, senhaTxt, btnCadastrar, btnVoltar);

        addEnterKeyListenersRegistration(nomeTxt, emailTxt, senhaTxt, btnCadastrar);

        btnCadastrar.addActionListener(e -> handleRegistration(nomeTxt, emailTxt, senhaTxt));
        btnVoltar.addActionListener(e -> createMainMenu());

        addComponentsToPanel(lblMenu, lblNome, nomeTxt, lblEmail, emailTxt, lblSenha, senhaTxt, btnCadastrar, btnVoltar);
    }

    private static void setBoundsForRegistrationMenu(JLabel lblNome, JTextField nomeTxt, JLabel lblEmail, JTextField emailTxt,
                                                 JLabel lblSenha, JPasswordField senhaTxt, JButton btnCadastrar, JButton btnVoltar) {
        lblNome.setBounds(70, 50, 200, 20);
        nomeTxt.setBounds(70, 70, 250, 30);
        lblEmail.setBounds(70, 110, 200, 20);
        emailTxt.setBounds(70, 130, 250, 30);
        lblSenha.setBounds(70, 170, 200, 20);
        senhaTxt.setBounds(70, 190, 250, 30);
        btnCadastrar.setBounds(70, 230, 250, 30);
        btnVoltar.setBounds(70, 270, 250, 30);
    }

    private static void addEnterKeyListenersRegistration(JTextField nomeTxt, JTextField emailTxt, JPasswordField senhaTxt, JButton btnCadastrar) {
        nomeTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    emailTxt.requestFocus();
                }
            }
        });

        emailTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    senhaTxt.requestFocus();
                }
            }
        });

        senhaTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnCadastrar.doClick();
                }
            }
        });
    }

    private static void handleRegistration(JTextField nomeTxt, JTextField emailTxt, JPasswordField senhaTxt) {
        String nome = nomeTxt.getText();
        String email = emailTxt.getText();
        String senha = new String(senhaTxt.getPassword());
        if (registerUser(nome, email, senha)) {
            JOptionPane.showMessageDialog(frame, "Cadastro realizado com sucesso!");
            createMainMenu();
        } else {
            JOptionPane.showMessageDialog(frame, "Erro ao realizar cadastro.");
        }
    }

    private static void createAccountMenu(String email) {
        clearPanel();

        JLabel lblMenu = new JLabel("Conta Corrente");
        lblMenu.setBounds(150, 20, 200, 30);

        double saldo = getBalance(email);
        JLabel lblSaldo = new JLabel("Saldo: R$ " + saldo);
        JCheckBox ocultarSaldo = new JCheckBox("Ocultar saldo");
        ocultarSaldo.setSelected(true);

        lblSaldo.setText("Saldo: R$ ****");

        JButton btnDepositar = new JButton("Depositar");
        JButton btnSacar = new JButton("Sacar");
        JButton btnTransferir = new JButton("Transferir");
        JButton btnExtrato = new JButton("Ver Extrato");
        JButton btnExcluirConta = new JButton("Excluir Conta");
        JButton btnVoltar = new JButton("Sair");

        setBoundsForAccountMenu(lblSaldo, ocultarSaldo, btnDepositar, btnSacar, btnTransferir, btnExtrato, btnExcluirConta, btnVoltar);

        btnExtrato.addActionListener(e -> showExtract(email));

        ocultarSaldo.addActionListener(e -> {
            if (ocultarSaldo.isSelected()) {
                lblSaldo.setText("Saldo: R$ ****");
            } else {
                lblSaldo.setText("Saldo: R$ " + getBalance(email));
            }
        });

        lblSaldo.setText("Saldo: R$ ****");

        btnDepositar.addActionListener(e -> handleDeposit(email, lblSaldo, ocultarSaldo));
        btnSacar.addActionListener(e -> handleWithdraw(email, lblSaldo, ocultarSaldo));
        btnTransferir.addActionListener(e -> handleTransfer(email, lblSaldo, ocultarSaldo));
        btnExcluirConta.addActionListener(e -> handleDeleteAccount(email));
        btnVoltar.addActionListener(e -> createMainMenu());

        addComponentsToPanel(lblMenu, lblSaldo, ocultarSaldo, btnDepositar, btnSacar, btnTransferir, btnExtrato, btnExcluirConta, btnVoltar);
    }

    private static void setBoundsForAccountMenu(JLabel lblSaldo, JCheckBox ocultarSaldo, JButton btnDepositar,
                                              JButton btnSacar, JButton btnTransferir, JButton btnExtrato,
                                              JButton btnExcluirConta, JButton btnVoltar) {
        lblSaldo.setBounds(80, 90, 200, 30);
        ocultarSaldo.setBounds(220, 90, 200, 30);
        btnDepositar.setBounds(70, 130, 250, 30);
        btnSacar.setBounds(70, 170, 250, 30);
        btnTransferir.setBounds(70, 210, 250, 30);
        btnExtrato.setBounds(70, 330, 250, 30);
        btnExcluirConta.setBounds(70, 250, 250, 30);
        btnVoltar.setBounds(70, 290, 250, 30);
    }

    private static void handleDeposit(String email, JLabel lblSaldo, JCheckBox ocultarSaldo) {
        String valor = JOptionPane.showInputDialog(frame, "Informe o valor para depósito:");
        if (valor != null && !valor.isEmpty()) {
            try {
                double valorDep = Double.parseDouble(valor);
                int idUsuario = getUserId(email);
                if (idUsuario != -1) {
                    depositBalance(idUsuario, valorDep);
                    JOptionPane.showMessageDialog(frame, "Depósito realizado com sucesso!");
                    recordTransaction(email, "Depósito", valorDep);
                    updateBalance(lblSaldo, email, ocultarSaldo);
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário não encontrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Valor inválido.");
            }
        }
    }

    private static void handleWithdraw(String email, JLabel lblSaldo, JCheckBox ocultarSaldo) {
        String valor = JOptionPane.showInputDialog(frame, "Informe o valor para saque:");
        if (valor != null && !valor.isEmpty()) {
            try {
                double valorSaque = Double.parseDouble(valor);
                int idUsuario = getUserId(email);
                if (idUsuario != -1) {
                    if (withdrawBalance(idUsuario, valorSaque)) {
                        JOptionPane.showMessageDialog(frame, "Saque realizado com sucesso!");
                        recordTransaction(email, "Saque", valorSaque);
                        updateBalance(lblSaldo, email, ocultarSaldo);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Saldo insuficiente.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Valor inválido.");
            }
        }
    }

    private static void handleTransfer(String email, JLabel lblSaldo, JCheckBox ocultarSaldo) {
        String numeroContaDestino = JOptionPane.showInputDialog(frame, "Informe o número da conta do destinatário:");
        if (numeroContaDestino != null && !numeroContaDestino.isEmpty()) {
            String valor = JOptionPane.showInputDialog(frame, "Informe o valor a ser transferido:");
            if (valor != null && !valor.isEmpty()) {
                try {
                    double valorTransferencia = Double.parseDouble(valor);
                    int idUsuarioOrigem = getUserId(email);  // Obtém id_usuario do remetente
                    int idUsuarioDestino = getUserId(numeroContaDestino);  // Obtém id_usuario do destinatário

                    // Verifica se o usuário está tentando transferir para si mesmo
                    if (idUsuarioOrigem == idUsuarioDestino) {
                        JOptionPane.showMessageDialog(frame, "Você não pode transferir dinheiro para sua própria conta.");
                        return;
                    }

                    // Verifica se os IDs são válidos
                    if (idUsuarioOrigem == -1) {
                        JOptionPane.showMessageDialog(frame, "Usuário remetente não encontrado.");
                        return;
                    }
                    if (idUsuarioDestino == -1) {
                        JOptionPane.showMessageDialog(frame, "Número da conta do destinatário inválido.");
                        return;
                    }

                    // Realiza a transferência
                    if (transferBalance(idUsuarioOrigem, idUsuarioDestino, valorTransferencia)) {
                        JOptionPane.showMessageDialog(frame, "Transferência realizada com sucesso!");

                        // Registrar a transferência
                        String emailDestino = getEmailByUserId(idUsuarioDestino);
                        recordTransfer(email, emailDestino, valorTransferencia);

                        updateBalance(lblSaldo, email, ocultarSaldo);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Saldo insuficiente ou erro no destinatário.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido.");
                }
            }
        }
    }

    private static String getEmailByUserId(int idUsuario) {
        String email = null;
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT email FROM usuarios WHERE id_usuario = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, idUsuario);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        email = rs.getString("email");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    private static void handleDeleteAccount(String email) {
        int confirmation = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir sua conta?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            deleteAccont(email);
            JOptionPane.showMessageDialog(frame, "Conta excluída com sucesso.");
            createMainMenu();
        }
    }

    private static void updateBalance(JLabel lblSaldo, String email, JCheckBox ocultarSaldo) {
        double saldoAtual = getBalance(email);
        if (ocultarSaldo.isSelected()) {
            lblSaldo.setText("Saldo: R$ ****");
        } else {
            lblSaldo.setText("Saldo: R$ " + saldoAtual);
        }
    }

    private static int getUserId(String numeroConta) {
        int idUsuario = -1; // Valor padrão para não encontrado
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT id_usuario FROM contas WHERE numero_conta = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, numeroConta);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        idUsuario = rs.getInt("id_usuario");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUsuario;
    }

    private static boolean checkLogin(String numeroConta, String senha) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT c.id_usuario FROM contas c " +
                    "JOIN usuarios u ON c.id_usuario = u.id_usuario " +
                    "WHERE c.numero_conta = ? AND u.senha = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, numeroConta);
                pst.setString(2, senha);
                try (ResultSet rs = pst.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean registerUser(String nome, String email, String senha) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setString(3, senha);

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int idUsuario = generatedKeys.getInt(1);
                            int numeroConta = createAccount(idUsuario);

                            JPanel panel = new JPanel();
                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                            JLabel accountNumberLabel = new JLabel("Este é o seu número da conta: " + numeroConta);
                            JTextField textField = new JTextField(String.valueOf(numeroConta));
                            textField.setEditable(false);

                            panel.add(accountNumberLabel);
                            panel.add(textField);

                            JOptionPane.showMessageDialog(null, panel, "Informação", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private static int createAccount(int idUsuario) {
        int numeroConta = 0;
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            Random random = new Random();

            double saldoInicial = 5000 + (5000 * random.nextDouble());


            do {
                numeroConta = 1000 + random.nextInt(9000);
            } while (existingAccountNumber(con, numeroConta));

            String query = "INSERT INTO contas (id_usuario, saldo, numero_conta) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setInt(1, idUsuario);
                stmt.setDouble(2, saldoInicial);
                stmt.setInt(3, numeroConta);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numeroConta;
    }

    private static boolean existingAccountNumber(Connection con, int numeroConta) throws SQLException {
        String query = "SELECT COUNT(*) FROM contas WHERE numero_conta = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, numeroConta);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private static double getBalance(String email) {
        double saldo = 0.0;
        int idUsuario = getUserId(email);
        if (idUsuario != -1) {
            try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
                String query = "SELECT saldo FROM contas WHERE id_usuario = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setInt(1, idUsuario);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            saldo = rs.getDouble("saldo");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return saldo;
    }

    private static void depositBalance(int idUsuario, double valor) {
        executeUpdate("UPDATE contas SET saldo = saldo + ? WHERE id_usuario = ?", valor, idUsuario);
    }

    private static boolean withdrawBalance(int idUsuario, double valor) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT saldo FROM contas WHERE id_usuario = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, idUsuario);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        double saldoAtual = rs.getDouble("saldo");
                        if (saldoAtual >= valor) {
                            executeUpdate("UPDATE contas SET saldo = saldo - ? WHERE id_usuario = ?", valor, idUsuario);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Saldo insuficiente.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void executeUpdate(String query, double valor, int idUsuario) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDouble(1, valor);
            pst.setInt(2, idUsuario);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Nenhuma linha afetada. Verifique se o id_usuario existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean transferBalance(int idUsuarioOrigem, int idUsuarioDestino, double valor) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            con.setAutoCommit(false);
            if (checkBalance(con, idUsuarioOrigem, valor)) {
                executeUpdate(con, "UPDATE contas SET saldo = saldo - ? WHERE id_usuario = ?", valor, idUsuarioOrigem);
                executeUpdate(con, "UPDATE contas SET saldo = saldo + ? WHERE id_usuario = ?", valor, idUsuarioDestino);

                // Obter os e-mails dos usuários
                String emailOrigem = getEmailByUserId(idUsuarioOrigem);
                String emailDestino = getEmailByUserId(idUsuarioDestino);

                // Registrar a transferência
                String query = "INSERT INTO transacoes (email_origem, email_destino, tipo, valor) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, emailOrigem);
                    pst.setString(2, emailDestino);
                    pst.setString(3, "Transferência enviada");
                    pst.setDouble(4, valor);
                    pst.executeUpdate();
                }

                con.commit();
                return true;
            } else {
                JOptionPane.showMessageDialog(frame, "Saldo insuficiente para a transferência.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void showTransferDetails(int idUsuario) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Remetente");
        modelo.addColumn("Destinatário");
        modelo.addColumn("Valor (R$)");
        modelo.addColumn("Data");

        String emailUsuario = getEmailByUserId(idUsuario); // Obter o e-mail do usuário

        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "SELECT t.email_origem AS remetente, t.email_destino AS destinatario, t.valor, t.data " +
                    "FROM transacoes t " +
                    "WHERE t.email_origem = ? OR t.email_destino = ? " +
                    "ORDER BY t.data DESC";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, emailUsuario);
                pst.setString(2, emailUsuario);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String remetente = rs.getString("remetente");
                        String destinatario = rs.getString("destinatario");
                        double valor = rs.getDouble("valor");
                        Timestamp data = rs.getTimestamp("data"); // Certifique-se de que isso é um Timestamp

                        String dataFormatada = formatDate(data);
                        modelo.addRow(new Object[]{remetente, destinatario, String.format("R$ %.2f", valor), dataFormatada});
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable tabela = createTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.setFillsViewportHeight(true);

        JOptionPane.showMessageDialog(null, scrollPane, "Detalhes da Transferência", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void executeUpdate(Connection con, String query, double valor, int idUsuario) {
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDouble(1, valor);
            pst.setInt(2, idUsuario);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Nenhuma linha afetada. Verifique se o id_usuario existe.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkBalance(Connection con, int idUsuario, double valor) throws SQLException {
        String query = "SELECT saldo FROM contas WHERE id_usuario = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, idUsuario);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    double saldoOrigem = rs.getDouble("saldo");
                    return saldoOrigem >= valor;
                }
            }
        }
        return false;
    }

    private static void recordTransaction(String email, String tipo, double valor) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO transacoes (email, tipo, valor) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, tipo);
                pst.setDouble(3, valor);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void recordTransfer(String emailOrigem, String emailDestino, double valor) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO transacoes (email_origem, email_destino, tipo, valor) VALUES (?, ?, ?, ?)";

            // Registrar a transferência enviada
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, emailOrigem);
                pst.setString(2, emailDestino);
                pst.setString(3, "Transferência enviada");
                pst.setDouble(4, valor);
                pst.executeUpdate();
            }

            // Registrar a transferência recebida
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, emailDestino);
                pst.setString(2, emailOrigem);
                pst.setString(3, "Transferência recebida");
                pst.setDouble(4, valor);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showExtract(String email) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Operação");
        modelo.addColumn("Valor (R$)");
        modelo.addColumn("Data");

        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            // Obter transações do usuário
            String query = "SELECT tipo, valor, data FROM transacoes WHERE email_origem = ? OR email_destino = ? ORDER BY data DESC";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, email);
                try (ResultSet rs = pst.executeQuery()) {
                    boolean temTransacoes = false;
                    while (rs.next()) {
                        temTransacoes = true;
                        String operacao = rs.getString("tipo");
                        double valor = rs.getDouble("valor");
                        Timestamp data = rs.getTimestamp("data"); // Certifique-se de que isso é um Timestamp

                        String dataFormatada = formatDate(data);
                        modelo.addRow(new Object[]{operacao, String.format("R$ %.2f", valor), dataFormatada});
                    }

                    if (!temTransacoes) {
                        JOptionPane.showMessageDialog(null, "Nenhuma transação encontrada no histórico.");
                        return;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable tabela = createTable(modelo);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.setFillsViewportHeight(true);

        // Adicionar um listener para mostrar detalhes ao clicar
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabela.getSelectedRow() != -1) {
                    int selectedRow = tabela.getSelectedRow();
                    String tipo = (String) modelo.getValueAt(selectedRow, 0);
                    double valor = Double.parseDouble(((String) modelo.getValueAt(selectedRow, 1)).replace("R$ ", "").replace(",", "."));
                    Timestamp data = (Timestamp) modelo.getValueAt(selectedRow, 2); // Corrigido para obter o Timestamp corretamente
                    showTransferDetails(tipo, valor, data);
                }
            }
        });

        JOptionPane.showMessageDialog(null, scrollPane, "Extrato de Transações", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showTransferDetails(String tipo, double valor, Timestamp data) {
        String detalhes = String.format("Tipo: %s\nValor: R$ %.2f\nData: %s", tipo, valor, formatDate(data));
        JOptionPane.showMessageDialog(null, detalhes, "Detalhes da Transferência", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String formatDate(Timestamp data) {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        return sdfData.format(data) + " " + sdfHora.format(data) + "h";
    }

    private static JTable createTable(DefaultTableModel modelo) {
        JTable tabela = new JTable(modelo) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela.setBackground(new Color(245, 245, 245));
        tabela.setGridColor(new Color(200, 200, 200));
        tabela.setSelectionBackground(new Color(84, 153, 199));
        tabela.setSelectionForeground(Color.WHITE);
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));

        tabela.getTableHeader().setBackground(new Color(0, 123, 255));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        tabela.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : new Color(230, 230, 230));
                }
                return c;
            }
        });

        return tabela;
    }

    private static void deleteAccont(String email) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String deleteContas = "DELETE FROM contas WHERE email = ?";
            try (PreparedStatement pstContas = con.prepareStatement(deleteContas)) {
                pstContas.setString(1, email);
                pstContas.executeUpdate();
            }

            String deleteUsuario = "DELETE FROM usuarios WHERE email = ?";
            try (PreparedStatement pstUsuario = con.prepareStatement(deleteUsuario)) {
                pstUsuario.setString(1, email);
                pstUsuario.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
