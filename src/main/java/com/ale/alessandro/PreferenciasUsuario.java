package com.ale.alessandro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreferenciasUsuario extends JFrame {
    private JComboBox<String> temaComboBox;
    private JCheckBox notificacoesCheckBox;
    private JSlider volumeSlider;
    private JButton salvarButton;
    private JTextArea preferenciasTextArea;
    private Usuario usuario;

    public PreferenciasUsuario() {
        usuario = new Usuario("Claro", true, 50);  // Valores iniciais

        setTitle("Configurações de Preferências");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        // Títulos
        add(new JLabel("Tema:"));
        temaComboBox = new JComboBox<>(new String[]{"Claro", "Escuro"});
        add(temaComboBox);

        add(new JLabel("Notificações:"));
        notificacoesCheckBox = new JCheckBox("Habilitar Notificações");
        add(notificacoesCheckBox);

        add(new JLabel("Volume:"));
        volumeSlider = new JSlider(0, 100, 50);
        add(volumeSlider);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPreferencias();
            }
        });
        add(salvarButton);

        preferenciasTextArea = new JTextArea();
        preferenciasTextArea.setEditable(false);
        add(preferenciasTextArea);

        carregarPreferencias();

        setVisible(true);
    }

    private void salvarPreferencias() {
        String tema = (String) temaComboBox.getSelectedItem();
        boolean notificacoes = notificacoesCheckBox.isSelected();
        int volume = volumeSlider.getValue();

        usuario.setTema(tema);
        usuario.setNotificacoes(notificacoes);
        usuario.setVolume(volume);

        preferenciasTextArea.setText(usuario.toString());
        atualizarTema();
    }

    private void carregarPreferencias() {
        temaComboBox.setSelectedItem(usuario.getTema());
        notificacoesCheckBox.setSelected(usuario.isNotificacoes());
        volumeSlider.setValue(usuario.getVolume());
    }

    private void atualizarTema() {
        if ("Escuro".equals(usuario.getTema())) {
            getContentPane().setBackground(Color.DARK_GRAY);
        } else {
            getContentPane().setBackground(Color.LIGHT_GRAY);
        }
    }

    public static void main(String[] args) {
        new PreferenciasUsuario();
    }
}
