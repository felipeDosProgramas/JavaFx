package com.ale.alessandro;
import javax.swing.*;
import java.awt.*;

public class FormularioCadastro extends JFrame {
    private JTextField nomeField;
    private JSpinner idadeSpinner;
    private JRadioButton masculinoButton;
    private JRadioButton femininoButton;
    private JButton enviarButton;
    private JLabel resumoLabel;

    public FormularioCadastro() {
        setTitle("Formulário de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLayout(new GridLayout(6, 2));

        // Labels
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Idade:"));
        idadeSpinner = new JSpinner(
                new SpinnerNumberModel(18, 0, 100, 1)
        );
        add(idadeSpinner);

        add(new JLabel("Sexo:"));
        masculinoButton = new JRadioButton("Masculino");
        femininoButton = new JRadioButton("Feminino");
        ButtonGroup group = new ButtonGroup();
        group.add(masculinoButton);
        group.add(femininoButton);
        add(masculinoButton);
        add(femininoButton);

        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(e -> {
            if (!validateFields()) {
                resumoLabel.setText("Preencha todos os campos.");
                return;
            }
            resumoLabel.setText(
                new Cliente(
                    nomeField.getText(),
                    (Integer) idadeSpinner.getValue(),
                    masculinoButton.isSelected()
                ).toString()
            );
        });
        add(enviarButton);

        resumoLabel = new JLabel();
        add(resumoLabel);

        setVisible(true);
    }

    private boolean validateFields() {
        return !nomeField.getText().isEmpty() &&
                (masculinoButton.isSelected() || femininoButton.isSelected());
    }

    public static void main(String[] args) {
        new FormularioCadastro();
    }
}
