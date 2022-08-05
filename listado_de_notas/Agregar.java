package listado_de_notas;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Agregar implements ActionListener
{
	JFrame frame;
	JLabel nombre, cedula, nota;
	JTextField datoNombre, datoCedula, datoNota;
	JPanel panel;
	JButton botonCrear;
	
	public Agregar()
	{
		// en el siguiente panel se agregaran los campos para ingresar los
		// datos del nuevo estudiante
		panel = new JPanel();
		panel.setBounds(50, 40, 280, 225);
		panel.setLayout(new GridLayout(3,2,10,10));
		
		// campo nombre
		nombre = new JLabel("Nombre");
		nombre.setHorizontalAlignment(JLabel.CENTER);
		datoNombre = new JTextField();
		panel.add(nombre);
		panel.add(datoNombre);
		
		// campo cedula
		cedula = new JLabel("Cedula");
		cedula.setHorizontalAlignment(JLabel.CENTER);
		datoCedula = new JTextField();
		panel.add(cedula);
		panel.add(datoCedula);
		
		// campo nota
		nota = new JLabel("Nota");
		nota.setHorizontalAlignment(JLabel.CENTER);
		datoNota = new JTextField();
		panel.add(nota);
		panel.add(datoNota);
		
		// boton para crear
		botonCrear = new JButton("CREAR ESTUDIANTE");
		botonCrear.setBounds(50, 280, 280, 50);
		botonCrear.addActionListener(this);
		
		// configurando ventana
		frame = new JFrame("Listado de notas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.add(panel);
		frame.add(botonCrear);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// extrayendo datos del nuevo estudiante
		String nom = datoNombre.getText();
		String c = datoCedula.getText();
		String not = datoNota.getText(); 
		
		if (e.getSource() == botonCrear)
		{
			// coneccion a base de datos
			try 
			{
				Connection driver = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "28042158");
				Statement actualizacion = driver.createStatement();
				
				actualizacion.executeUpdate("INSERT INTO notas (nombre,cedula,nota) VALUES " + 
				String.format("('%s','%s',%s)", nom, c, not));

				frame.dispose();
				new Menu();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
